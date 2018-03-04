package com.currencyfair.tradefrontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class TradeFrontendApplicationTests {

	@Autowired
	private ApplicationContext context;

	
	private int port = 8083;

	private TestRestTemplate template;

	@Before
	public void before() throws Exception {
		template = new TestRestTemplate();
	}

	@Test
	public void rootValidResponse() throws Exception {
		URL url = new URL("http://localhost:" + port + "/");

		ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);

		assertEquals("200", response.getStatusCode().toString());
	}

	@Test
	public void indexValidóResponse() throws Exception {
		URL url = new URL("http://localhost:" + port + "/index");

		ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);

		assertEquals("200", response.getStatusCode().toString());
	}
	
	@Test
	public void application_context_loads_correctly() {
		assertNotNull(context);
	}

}
