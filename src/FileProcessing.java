import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileProcessing{
	private String path;
	private ArrayList<WordMessage> infolist = new ArrayList<WordMessage>();
	public FileProcessing(String path) {
		this.path = path;
		try {
			fileRead();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<WordMessage> getWordList() {
		return infolist;
	}
	public void fileRead() throws IOException {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(new File(path));
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			List<String> list = new ArrayList<String>();
			while((line = bufferedReader.readLine()) != null) {
				list.add(line);
				
			}
			Collections.sort(list);
			for(int i = 0 ; i < list.size() ; i ++) {
				String word = list.get(i);
				int special = 0;
				WordMessage newWord = new WordMessage(word);
				for(int j = 0 ; j < infolist.size() ; j++) {
					if(word.equals(infolist.get(j).getWord())) {
						break;
					}else {
						special++;
					}
				}
				if(special == infolist.size()) {
					infolist.add(newWord);
				}
			}
			bufferedReader.close();
			inputStreamReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
