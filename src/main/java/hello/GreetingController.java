package hello;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static String content = "";

    @RequestMapping(path = "/file", method = {RequestMethod.POST})
    public String greeting(@RequestParam(value="line") String line) {
    	content = line;
        return "Hello";
}
    
    @RequestMapping(path="/file", method = {RequestMethod.GET})
    public String greeting2(){
        return content ;
        
        
}
    public static void main(String[] args) throws IOException {
    	File file = new File("test.txt");
    	
    	try (Writer writer = new FileWriter(file)){
    	
    	writer.write("fdfdfd"+ System.lineSeparator());
    	} catch (IOException ex){
    		ex.printStackTrace();
    		
    	}
    	
    }
    
}