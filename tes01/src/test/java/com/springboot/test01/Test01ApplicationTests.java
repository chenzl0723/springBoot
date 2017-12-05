package com.springboot.test01;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Test01ApplicationTests {
	private MockMvc mvc;

	/**
	 * 使用MockServletContext来构建一个空的WebApplicationContext，
	 * 这样我们创建的HelloController
	 * 就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
	 * @throws Exception
	 */
	@Before
	public void setUp()throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new HelloWorld()).build();
	}
	@Test
	public void getHello()throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello world")));
	}

}
