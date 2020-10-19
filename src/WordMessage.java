public class WordMessage {
	private String word;
	private int length;
	private String level;
	private double difficultyScore;
	private double[] letterFrequency = new double[26];
	private char[] theLetter = new char[26];
	public WordMessage(String word) {
		this.word = word.toLowerCase();
		setDifficultyScore();
	}
	public void setLevel(double ls, double hs) {
		if(getDifficultyScore() >= ls && getDifficultyScore() < (hs / 3 + 2 * ls / 3)) {
			level = "easy";
		}else if(getDifficultyScore() >= (hs / 3 + 2 * ls / 3) && getDifficultyScore() < (ls / 3 + 2 * hs / 3)) {
			level = "medium";
		}else {
			level = "hard";
		}
	}
	public void setDifficultyScore() {
		length = word.length();
		double uncertainty = 0;
		setLetterFrequency();
		for(int i = 0 ; i < getLetterFrequency().length ; i++) {
			if(getLetterFrequency()[i] != 0) {
				uncertainty -= getLetterFrequency()[i] / length * Math.log(getLetterFrequency()[i] / length) / Math.log(2);
			}
		}
		difficultyScore = length * uncertainty;
	}
	public void setLetterFrequency() {
		char[] letter = word.toCharArray();
		for(int i = 0 ; i < theLetter.length ; i++) {
			theLetter[i] = (char) ('a' + i);
		}
		for(int i = 0 ; i < length ; i++) {
			for(int j = 0 ; j < theLetter.length ; j++) {
				if(letter[i] == theLetter[j]) {
					letterFrequency[j] += 1;
				}
			}
		}
	}
	public String getWord() {
		return word;
	}
	public String getLevel() {
		return level;
	}
	public double getDifficultyScore() {
		return difficultyScore;
	}
	public double[] getLetterFrequency() {
		return letterFrequency;
	}
	public String toString() {
		String re = getWord() + " " + getDifficultyScore() + " " + getLevel();
		return re;
	}
}
