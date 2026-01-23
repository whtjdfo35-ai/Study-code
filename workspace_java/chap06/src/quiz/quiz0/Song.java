package quiz.quiz0;

public class Song {
	String songName;
	String singer;
	String albumName;
	String lyc;
	int runTime;
	
//	String[][] list = new String[] {songName, singer,albumName, lyc, runTime};
	
	void setSong(String songName,String singer,
				String albumName, String lyc, int runTime) {
		this.songName =songName;
		this.singer =singer;
		this.albumName =albumName;
		this.lyc =lyc;
		this.runTime =runTime;
		
	} 
	
}
