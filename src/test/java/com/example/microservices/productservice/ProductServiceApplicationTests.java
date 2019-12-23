package com.example.microservices.productservice;

import com.example.microservices.productservice.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.file.Files;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ResourceLoader resourceLoader;

	@MockBean
	private ProductService productService;

	@Test
	public void getProducts() throws Exception{


		Mockito.when(productService.getProductsByPage(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);

		mockMvc.perform(get("/products"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}

	@Test
	public void testFilterRequest() throws Exception {
		Resource resource = resourceLoader.getResource("classpath:filter-request.json");
		String jsonRequestBody = new String(Files.readAllBytes(resource.getFile().toPath()));

		MvcResult mvcResult = mockMvc.perform(post("/products/filter")
				.content(jsonRequestBody)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}
}
