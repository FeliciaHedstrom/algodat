import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {
private String fileName;

	
	public Printer(String fileName){
		this.fileName=fileName;
	}
	
	public void print(String out) throws IOException{
		File file = createFile(fileName);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(out);
		bw.close();
	}

	private File createFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();

		}
		return file;
	}
}
