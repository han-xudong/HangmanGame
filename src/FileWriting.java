import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriting {
	private String path;
	private WordMessage[] wordlist;
	public FileWriting(String path, WordMessage[] wordlist) {
		this.path = path;
		this.wordlist = wordlist;
		try {
			fileWrite();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void fileWrite() throws IOException {
			try {
				File f = new File(path);
				if(!f.exists()) {
					f.createNewFile();
				}
				FileOutputStream fileOutputStream = new FileOutputStream(f);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
				for(int i = 0 ; i < wordlist.length ; i++) {
					bufferedWriter.write(wordlist[i].getWord() + ", " + String.format("%.1f", wordlist[i].getDifficultyScore()) + ", " + wordlist[i].getLevel());
					bufferedWriter.newLine();
				}
				bufferedWriter.close();
				outputStreamWriter.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
	}
}
