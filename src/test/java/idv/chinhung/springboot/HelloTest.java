package idv.chinhung.springboot;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloTest {
	
	@Inject
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders
			.webAppContextSetup(webContext)
			.apply(springSecurity())
			.build();
	}
	
	@Test
	public void rootTest() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk());
	}
}
