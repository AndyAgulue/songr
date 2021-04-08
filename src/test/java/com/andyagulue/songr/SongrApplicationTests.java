package com.andyagulue.songr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testHomePage() throws Exception {
//
		mockMvc.perform(get("/hello"))
//				.andDo(print())
				.andExpect(content().string(containsString("<h1>Hello World</h1>")))
				//.andExpect(content().string(containsString(" <form action=\"/cookie-store\" method=\"POST\">")))
				.andExpect(status().isOk());
	}

	@Test
	void testShowSplashPage() throws Exception {
//
		mockMvc.perform(get("/"))
//				.andDo(print())
				.andExpect(content().string(containsString("<h1>Songr! Discover new music, Add new music</h1>")))
				//.andExpect(content().string(containsString(" <form action=\"/cookie-store\" method=\"POST\">")))
				.andExpect(status().isOk());
	}
}
