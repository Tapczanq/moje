package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

	public static void main(String[] args) {
		
		File file = new File ("test.txt");
		
		try (Writer writer = new FileWriter(file, true);
				BufferedReader reader = new BufferedReader (new FileReader(file))) {
			writer.write("Stringi" + System.lineSeparator());
			writer.flush();
			System.out.println (reader.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		
		
	}

	}
}