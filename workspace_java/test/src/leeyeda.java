package leeyeda;

// BaseMod 및 ModTheSpire 관련 import
import basemod.BaseMod;
import basemod.interfaces.*;

import leeyeda.util.GeneralUtils;
import leeyeda.util.KeywordInfo;
import leeyeda.util.Sounds;
import leeyeda.util.TextureLoader;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglFileHandle;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.ModInfo;
import com.evacipated.cardcrawl.modthespire.Patcher;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.scannotation.AnnotationDB;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.*;

import leeyeda.cards.*;
import leeyeda.enums.CardColorEnum;

/**
 * @SpireInitializer
 * → ModTheSpire가 이 클래스를 "모드의 시작점"으로 인식하게 해줌
 */
@SpireInitializer
public class leeyeda implements
        EditCardsSubscriber,        // 카드 등록 타이밍
        EditStringsSubscriber,      // 문자열(localization) 로드
        EditKeywordsSubscriber,     // 키워드 로드
        AddAudioSubscriber,         // 사운드 등록
        PostInitializeSubscriber {  // 게임 초기화 이후 실행

    // ModTheSpire에서 읽어온 이 모드의 정보 (ID, 이름, 설명 등)
    public static ModInfo info;

    // 모드 ID (pom.xml의 <artifactId>)
    public static String modID;

    // static 초기화 블록: 클래스 로드 시 mod 정보 먼저 불러옴
    static { loadModInfo(); }

    // resources/leeyeda 경로가 맞는지 확인하고 저장
    private static final String resourcesFolder = checkResourcesPath();

    // 로그 출력용 Logger
    public static final Logger logger = LogManager.getLogger(modID);

    /**
     * 카드 색상 정의 (핑크)
     */
    private static final Color PINK_COLOR = new Color(
            1.0f,   // R
            0.4f,   // G
            0.7f,   // B
            1.0f    // A
    );

    /**
     * 카드 및 카드 색상 등록
     * BaseMod가 EditCards 단계에서 호출
     */
    @Override
    public void receiveEditCards() {
        // 카드 클래스 등록
        BaseMod.addCard(new Defend());
        BaseMod.addCard(new Strike());

        // 커스텀 카드 색상 등록
        BaseMod.addColor(
                CardColorEnum.PINK,
                PINK_COLOR, PINK_COLOR, PINK_COLOR, PINK_COLOR,
                PINK_COLOR, PINK_COLOR, PINK_COLOR,

                // 카드 배경 이미지 경로
                "leeyedaResources/images/512/bg_attack_pink.png",
                "leeyedaResources/images/512/bg_skill_pink.png",
                "leeyedaResources/images/512/bg_power_pink.png",
                "leeyedaResources/images/1024/bg_attack_pink.png",
                "leeyedaResources/images/1024/bg_skill_pink.png",
                "leeyedaResources/images/1024/bg_power_pink.png",

                // 오브 이미지
                "leeyedaResources/images/orb/card_orb_pink.png",
                "leeyedaResources/images/orb/card_orb_pink.png",
                "leeyedaResources/images/orb/card_orb_pink.png"
        );
    }

    /**
     * 카드/파워/유물 ID 충돌 방지를 위한 공통 ID 생성기
     * 예: leeyeda:Strike
     */
    public static String makeID(String id) {
        return modID + ":" + id;
    }

    /**
     * ModTheSpire가 호출하는 모드 초기화 메서드
     */
    public static void initialize() {
        new leeyeda();
    }

    /**
     * 생성자
     * → BaseMod에 구독해서 각 이벤트(receiveXXX)가 호출되도록 함
     */
    public leeyeda() {
        BaseMod.subscribe(this);
        logger.info(modID + " subscribed to BaseMod.");
    }

    /**
     * 게임 로딩이 끝난 후 실행
     * → 모드 목록 화면에 배지 표시
     */
    @Override
    public void receivePostInitialize() {
        Texture badgeTexture = TextureLoader.getTexture(imagePath("badge.png"));

        BaseMod.registerModBadge(
                badgeTexture,
                info.Name,
                GeneralUtils.arrToString(info.Authors),
                info.Description,
                null
        );
    }

    /* ================= Localization ================= */

    /**
     * 현재 게임 언어 (eng, kor, jpn 등)
     */
    private static String getLangString() {
        return Settings.language.name().toLowerCase();
    }

    private static final String defaultLanguage = "eng";

    // 키워드 ID → KeywordInfo 매핑
    public static final Map<String, KeywordInfo> keywords = new HashMap<>();

    /**
     * 문자열(CardStrings, PowerStrings 등) 로드
     */
    @Override
    public void receiveEditStrings() {
        // 기본 언어 먼저 로드
        loadLocalization(defaultLanguage);

        // 현재 언어가 기본 언어가 아니면 추가 로드
        if (!defaultLanguage.equals(getLangString())) {
            try {
                loadLocalization(getLangString());
            } catch (GdxRuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 특정 언어의 localization 파일들을 BaseMod에 등록
     */
    private void loadLocalization(String lang) {
        BaseMod.loadCustomStringsFile(CardStrings.class, localizationPath(lang, "CardStrings.json"));
        BaseMod.loadCustomStringsFile(CharacterStrings.class, localizationPath(lang, "CharacterStrings.json"));
        BaseMod.loadCustomStringsFile(EventStrings.class, localizationPath(lang, "EventStrings.json"));
        BaseMod.loadCustomStringsFile(OrbStrings.class, localizationPath(lang, "OrbStrings.json"));
        BaseMod.loadCustomStringsFile(PotionStrings.class, localizationPath(lang, "PotionStrings.json"));
        BaseMod.loadCustomStringsFile(PowerStrings.class, localizationPath(lang, "PowerStrings.json"));
        BaseMod.loadCustomStringsFile(RelicStrings.class, localizationPath(lang, "RelicStrings.json"));
        BaseMod.loadCustomStringsFile(UIStrings.class, localizationPath(lang, "UIStrings.json"));
    }

    /**
     * 키워드 로드
     */
    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();

        // 기본 언어 키워드
        String json = Gdx.files.internal(
                localizationPath(defaultLanguage, "Keywords.json")
        ).readString(String.valueOf(StandardCharsets.UTF_8));

        KeywordInfo[] keywords = gson.fromJson(json, KeywordInfo[].class);
        for (KeywordInfo keyword : keywords) {
            keyword.prep();
            registerKeyword(keyword);
        }

        // 추가 언어 키워드
        if (!defaultLanguage.equals(getLangString())) {
            try {
                json = Gdx.files.internal(
                        localizationPath(getLangString(), "Keywords.json")
                ).readString(String.valueOf(StandardCharsets.UTF_8));

                keywords = gson.fromJson(json, KeywordInfo[].class);
                for (KeywordInfo keyword : keywords) {
                    keyword.prep();
                    registerKeyword(keyword);
                }
            } catch (Exception e) {
                logger.warn(modID + " does not support " + getLangString() + " keywords.");
            }
        }
    }

    /**
     * BaseMod에 키워드 등록
     */
    private void registerKeyword(KeywordInfo info) {
        BaseMod.addKeyword(
                modID.toLowerCase(),
                info.PROPER_NAME,
                info.NAMES,
                info.DESCRIPTION,
                info.COLOR
        );

        if (!info.ID.isEmpty()) {
            keywords.put(info.ID, info);
        }
    }

    /* ================= Audio ================= */

    /**
     * 사운드 로드 타이밍
     */
    @Override
    public void receiveAddAudio() {
        loadAudio(Sounds.class);
    }

    /**
     * Sounds 클래스의 public static String 필드를 자동으로 탐색해서 사운드 등록
     */
    private static final String[] AUDIO_EXTENSIONS = { ".ogg", ".wav", ".mp3" };

    private void loadAudio(Class<?> cls) {
        try {
            Field[] fields = cls.getDeclaredFields();

            outer:
            for (Field f : fields) {
                int modifiers = f.getModifiers();

                // public static String 필드만 대상
                if (Modifier.isStatic(modifiers) &&
                    Modifier.isPublic(modifiers) &&
                    f.getType().equals(String.class)) {

                    String s = (String) f.get(null);

                    // 값이 없으면 파일명 기반 자동 탐색
                    if (s == null) {
                        s = audioPath(f.getName());

                        for (String ext : AUDIO_EXTENSIONS) {
                            String testPath = s + ext;
                            if (Gdx.files.internal(testPath).exists()) {
                                BaseMod.addAudio(testPath, testPath);
                                f.set(null, testPath);
                                continue outer;
                            }
                        }
                        throw new Exception("오디오 파일을 찾을 수 없음: " + f.getName());
                    }
                    // 값이 있으면 해당 경로 사용
                    else {
                        if (Gdx.files.internal(s).exists()) {
                            BaseMod.addAudio(s, s);
                        } else {
                            throw new Exception("오디오 경로가 잘못됨: " + s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred in loadAudio: ", e);
        }
    }

    /* ================= Path Utils ================= */

    public static String localizationPath(String lang, String file) {
        return resourcesFolder + "/localization/" + lang + "/" + file;
    }

    public static String audioPath(String file) {
        return resourcesFolder + "/audio/" + file;
    }

    public static String imagePath(String file) {
        return resourcesFolder + "/images/" + file;
    }

    public static String characterPath(String file) {
        return resourcesFolder + "/images/character/" + file;
    }

    public static String powerPath(String file) {
        return resourcesFolder + "/images/powers/" + file;
    }

    public static String relicPath(String file) {
        return resourcesFolder + "/images/relics/" + file;
    }

    /**
     * resources 폴더 구조가 올바른지 검사
     */
    private static String checkResourcesPath() {
        String name = leeyeda.class.getName();
        int separator = name.indexOf('.');
        if (separator > 0)
            name = name.substring(0, separator);

        FileHandle resources = new LwjglFileHandle(name, Files.FileType.Internal);

        if (!resources.exists()) {
            throw new RuntimeException("resources 폴더를 찾을 수 없음: " + name);
        }
        if (!resources.child("images").exists()) {
            throw new RuntimeException("images 폴더 없음");
        }
        if (!resources.child("localization").exists()) {
            throw new RuntimeException("localization 폴더 없음");
        }

        return name;
    }

    /**
     * ModTheSpire에서 이 모드의 ModInfo를 찾아 modID 설정
     */
    private static void loadModInfo() {
        Optional<ModInfo> infos = Arrays.stream(Loader.MODINFOS)
                .filter((modInfo) -> {
                    AnnotationDB annotationDB = Patcher.annotationDBMap.get(modInfo.jarURL);
                    if (annotationDB == null) return false;

                    Set<String> initializers =
                            annotationDB.getAnnotationIndex()
                                    .getOrDefault(SpireInitializer.class.getName(), Collections.emptySet());

                    return initializers.contains(leeyeda.class.getName());
                })
                .findFirst();

        if (infos.isPresent()) {
            info = infos.get();
            modID = info.ID;
        } else {
            throw new RuntimeException("ModInfo를 찾지 못함");
        }
    }
}

