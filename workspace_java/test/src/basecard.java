/**
 * BaseCard
 * ------------------------------------------------------------
 * Slay the Spire 모드용 카드의 공통 베이스 클래스
 *
 * 주요 기능
 *  - Damage / Block / Magic 업그레이드 공통 처리
 *  - 커스텀 Dynamic Variable 시스템 (#X# 같은 변수)
 *  - 업그레이드 시 설명 / 수치 / 상태 변경 자동 처리
 *  - applyPowers / calculateCardDamage와 연동되는 계산 로직
 */
public abstract class BaseCard extends CustomCard {

    /* =========================================================
     * Static 영역 (모든 카드가 공유)
     * ========================================================= */

    // DynamicVariable 전역 레지스트리
    private static final Map<String, DynamicVariable> customVars = new HashMap<>();

    // 모드 ID 기반 카드 ID 생성 헬퍼
    protected static String makeID(String name) {
        return leeyeda.makeID(name);
    }

    /* =========================================================
     * 카드 기본 정보
     * ========================================================= */

    protected CardStrings cardStrings;
    protected boolean upgradesDescription;

    // 기본 코스트 (업그레이드 계산용)
    protected int baseCost;

    /* =========================================================
     * 업그레이드 플래그 & 수치
     * ========================================================= */

    protected boolean upgradeCost;
    protected int costUpgrade;

    protected boolean upgradeDamage;
    protected boolean upgradeBlock;
    protected boolean upgradeMagic;

    protected int damageUpgrade;
    protected int blockUpgrade;
    protected int magicUpgrade;

    /* =========================================================
     * 카드 상태 플래그 (기본 / 업그레이드)
     * ========================================================= */

    protected boolean baseExhaust = false;
    protected boolean upgExhaust = false;

    protected boolean baseEthereal = false;
    protected boolean upgEthereal = false;

    protected boolean baseInnate = false;
    protected boolean upgInnate = false;

    protected boolean baseRetain = false;
    protected boolean upgRetain = false;

    /* =========================================================
     * 커스텀 변수 (카드별 로컬)
     * ========================================================= */

    // key → 변수 정보
    protected final Map<String, LocalVarInfo> cardVariables = new HashMap<>();

    /* =========================================================
     * 생성자 체인
     * ========================================================= */

    public BaseCard(String ID, CardStats info) {
        this(ID, info, getCardTextureString(removePrefix(ID), info.cardType));
    }

    public BaseCard(String ID, CardStats info, String cardImage) {
        this(ID, info.baseCost, info.cardType, info.cardTarget, info.cardRarity, info.cardColor, cardImage);
    }

    public BaseCard(String ID, int cost, CardType cardType, CardTarget target,
                    CardRarity rarity, CardColor color) {
        this(ID, cost, cardType, target, rarity, color,
                getCardTextureString(removePrefix(ID), cardType));
    }

    /**
     * 실제 메인 생성자
     */
    public BaseCard(String ID, int cost, CardType cardType, CardTarget target,
                    CardRarity rarity, CardColor color, String cardImage) {

        super(ID, getName(ID), cardImage, cost,
                getInitialDescription(ID), cardType, color, rarity, target);

        this.cardStrings = CardCrawlGame.languagePack.getCardStrings(cardID);
        this.originalName = cardStrings.NAME;

        this.baseCost = cost;

        // 업그레이드 관련 기본값 초기화
        this.upgradesDescription = cardStrings.UPGRADE_DESCRIPTION != null;

        this.upgradeCost = false;
        this.upgradeDamage = false;
        this.upgradeBlock = false;
        this.upgradeMagic = false;

        this.costUpgrade = cost;
        this.damageUpgrade = 0;
        this.blockUpgrade = 0;
        this.magicUpgrade = 0;
    }

    /* =========================================================
     * LanguagePack 헬퍼
     * ========================================================= */

    private static String getName(String ID) {
        return CardCrawlGame.languagePack.getCardStrings(ID).NAME;
    }

    private static String getInitialDescription(String ID) {
        return CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION;
    }

    /* =========================================================
     * 기본 수치 세팅 (생성자 전용)
     * ========================================================= */

    protected final void setDamage(int damage) {
        setDamage(damage, 0);
    }

    protected final void setDamage(int damage, int damageUpgrade) {
        this.baseDamage = this.damage = damage;
        if (damageUpgrade != 0) {
            this.upgradeDamage = true;
            this.damageUpgrade = damageUpgrade;
        }
    }

    protected final void setBlock(int block) {
        setBlock(block, 0);
    }

    protected final void setBlock(int block, int blockUpgrade) {
        this.baseBlock = this.block = block;
        if (blockUpgrade != 0) {
            this.upgradeBlock = true;
            this.blockUpgrade = blockUpgrade;
        }
    }

    protected final void setMagic(int magic) {
        setMagic(magic, 0);
    }

    protected final void setMagic(int magic, int magicUpgrade) {
        this.baseMagicNumber = this.magicNumber = magic;
        if (magicUpgrade != 0) {
            this.upgradeMagic = true;
            this.magicUpgrade = magicUpgrade;
        }
    }

    /* =========================================================
     * 커스텀 변수 시스템 (#X#)
     * ========================================================= */

    /**
     * 단순 정수 커스텀 변수 등록
     */
    protected final void setCustomVar(String key, int base, int upgrade) {
        setCustomVarValue(key, base, upgrade);

        // 전역 DynamicVariable 등록 (최초 1회)
        if (!customVars.containsKey(key)) {
            QuickDynamicVariable var = new QuickDynamicVariable(key);
            customVars.put(key, var);
            BaseMod.addDynamicVariable(var);
            initializeDescription();
        }
    }

    /**
     * 변수 타입 (Damage / Block / Magic) 지정
     */
    protected enum VariableType {
        DAMAGE,
        BLOCK,
        MAGIC
    }

    /**
     * Damage / Block 기반으로 자동 계산되는 커스텀 변수
     */
    protected final void setCustomVar(String key, VariableType type, int base, int upgrade) {
        setCustomVarValue(key, base, upgrade);

        switch (type) {
            case DAMAGE:
                calculateVarAsDamage(key);
                break;
            case BLOCK:
                calculateVarAsBlock(key);
                break;
        }

        if (!customVars.containsKey(key)) {
            QuickDynamicVariable var = new QuickDynamicVariable(key);
            customVars.put(key, var);
            BaseMod.addDynamicVariable(var);
            initializeDescription();
        }
    }

    /* =========================================================
     * 업그레이드 처리
     * ========================================================= */

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();

            // 설명 업그레이드
            if (upgradesDescription && cardStrings.UPGRADE_DESCRIPTION != null) {
                this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            }

            // 코스트 업그레이드
            if (upgradeCost) {
                upgradeBaseCost(costUpgrade);
            }

            // 기본 수치 업그레이드
            if (upgradeDamage) upgradeDamage(damageUpgrade);
            if (upgradeBlock) upgradeBlock(blockUpgrade);
            if (upgradeMagic) upgradeMagicNumber(magicUpgrade);

            // 커스텀 변수 업그레이드
            for (LocalVarInfo var : cardVariables.values()) {
                upgradeCustomVar(var);
            }

            // 상태 플래그 반영
            if (baseExhaust ^ upgExhaust) exhaust = upgExhaust;
            if (baseInnate ^ upgInnate) isInnate = upgInnate;
            if (baseEthereal ^ upgEthereal) isEthereal = upgEthereal;
            if (baseRetain ^ upgRetain) selfRetain = upgRetain;

            initializeDescription();
        }
    }

    /* =========================================================
     * 파워 / 데미지 계산 흐름
     * ========================================================= */

    /**
     * Strength / Dexterity 등 파워 적용 시 호출
     * 커스텀 변수도 같이 계산
     */
    @Override
    public void applyPowers() {
        // 무한 재귀 방지
        if (!inCalc) {
            inCalc = true;

            // 단일 타겟 계산
            for (LocalVarInfo var : cardVariables.values()) {
                var.value = var.calculation.apply(this, null, var.base);
            }

            // 광역 공격일 경우 몬스터별 계산
            if (isMultiDamage) {
                ArrayList<AbstractMonster> monsters = AbstractDungeon.getCurrRoom().monsters.monsters;
                for (LocalVarInfo var : cardVariables.values()) {
                    var.aoeValue = new int[monsters.size()];
                    for (int i = 0; i < monsters.size(); i++) {
                        var.aoeValue[i] = var.calculation.apply(this, monsters.get(i), var.base);
                    }
                }
            }
            inCalc = false;
        }
        super.applyPowers();
    }

    /* =========================================================
     * 내부 클래스
     * ========================================================= */

    /**
     * BaseMod DynamicVariable 구현체
     * 카드 텍스트의 !key! / #key# 처리 담당
     */
    private static class QuickDynamicVariable extends DynamicVariable {
        final String localKey;
        final String key;
        private BaseCard current = null;

        public QuickDynamicVariable(String key) {
            this.localKey = key;
            this.key = makeID(key);
        }

        @Override public String key() { return key; }
        @Override public int value(AbstractCard c) {
            return c instanceof BaseCard ? ((BaseCard) c).customVar(localKey) : 0;
        }
        @Override public int baseValue(AbstractCard c) {
            return c instanceof BaseCard ? ((BaseCard) c).customVarBase(localKey) : 0;
        }
        @Override public boolean upgraded(AbstractCard c) {
            return c instanceof BaseCard && ((BaseCard) c).customVarUpgraded(localKey);
        }
    }

    /**
     * 카드 인스턴스별 커스텀 변수 정보
     */
    protected static class LocalVarInfo {
        int base, value, upgrade;
        int[] aoeValue;
        boolean upgraded;
        boolean forceModified;

        Color normalColor = Settings.CREAM_COLOR;
        Color upgradedColor = Settings.GREEN_TEXT_COLOR;
        Color increasedColor = Settings.GREEN_TEXT_COLOR;
        Color decreasedColor = Settings.RED_TEXT_COLOR;

        TriFunction<BaseCard, AbstractMonster, Integer, Integer> calculation = LocalVarInfo::noCalc;

        public LocalVarInfo(int base, int upgrade) {
            this.base = this.value = base;
            this.upgrade = upgrade;
        }

        private static int noCalc(BaseCard c, AbstractMonster m, int base) {
            return base;
        }

        public boolean isModified() {
            return forceModified || base != value;
        }
    }
}

