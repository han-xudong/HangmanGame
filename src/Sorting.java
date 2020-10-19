public class Sorting {
	private WordMessage[] wordlist;
	public Sorting(WordMessage[] wordlist) {
		this.wordlist = wordlist;
		getSort();
	}
	public void getSort() {
		for(int i = 0 ; i < wordlist.length - 1 ; i++) {
			for(int j = 0 ; j < wordlist.length - 1 - i ; j++) {
				if(wordlist[j].getDifficultyScore() > wordlist[j + 1].getDifficultyScore()) {
					WordMessage c = wordlist[j];
					wordlist[j] = wordlist[j + 1];
					wordlist[j + 1] = c;
				}
			}
		}
	}
	public WordMessage[] getlist() {
		return wordlist;
	}
}
