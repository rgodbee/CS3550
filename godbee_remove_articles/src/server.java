import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class server {
	public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new FileReader("big-file1.txt"));
	PrintWriter page = new PrintWriter("noArticles.txt");
	String line = "";
	while((line = input.readLine()) != null){
		String pattern = "(\\s|^)(THE|tHe|the|The|a|A|an|An)(\\s|$)";
		String newLine = line.replaceAll(pattern, " ");
		page.println(newLine);
	}
	page.close();
	}
}

