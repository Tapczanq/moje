package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	File file = new File ("test.txt");
	
    @RequestMapping(path = "/file", method = {RequestMethod.POST})
    public String greeting(@RequestParam(value="name") String name) {
    	try (Writer writer = new FileWriter(file, true)) {
    		writer.write(name + System.lineSeparator());
			writer.flush();
    	} catch (IOException e) {
			e.printStackTrace();
    	}
    		return "zapisano";
    }
        
    @RequestMapping(path = "/file", method = {RequestMethod.GET})
    public String addName () {
    	ArrayList readFile = new ArrayList<>();
    
    	try (BufferedReader reader = new BufferedReader (new FileReader(file))) {
    		String currentLine;
    		    		
			while ((currentLine = reader.readLine()) != null) {
				readFile.add(currentLine);
		}
			
    	} catch (IOException e) {
			e.printStackTrace();
    	}
    	
    	return "odczytano z pliku: " + readFile;
    }
}