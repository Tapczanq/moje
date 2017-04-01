package rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hello.FileController;

public class FileControllerTest {

	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.standaloneSetup(new FileController()).build();
		
	}
	
	
	@Test
	public void test() throws Exception{
		mockMvc//
		.perform(MockMvcRequestBuilders.get("/file"))//
		.andDo(MockMvcResultHandlers.print());
		
		
		
	}
	
	
}
