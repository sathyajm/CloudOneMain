package com.netapp.ngdc.devexp.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

	@Autowired
	private MockMvc webClient;

	@Autowired
	private HelloNGDC helloNGDC;

	@Test
	public void contextLoads() {
		Assertions.assertThat(helloNGDC).isNotNull();
	}

	@Test
	public void ping() throws Exception {
		this.webClient.perform(get("/ping")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("pong")));
	}

	@Test
	public void pingPost() throws Exception {
		this.webClient.perform(post("/ping")).andExpect(status().is(405));
	}

	@Test
	public void index() throws Exception {
		this.webClient.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

}
