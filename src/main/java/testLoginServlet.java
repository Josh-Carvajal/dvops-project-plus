import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testLoginServlet {
	private LoginServlet ls;
	private String correctUsername;
	private String correctPassword;
	private String username;
	private String password;

	@BeforeEach
	void setUp() throws Exception {
		username = "admin@gmail.com";
		password = "password";
		correctUsername = "admin@gmail.com";
		correctPassword = "password";
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		//fail("Not yet implemented");
		assertEqualls(username, correctUsername);
		assertEqualls(password, correctPassword);
		
	}

	private void assertEqualls(String username2, String correctUsername2) {
		// TODO Auto-generated method stub
		
	}

}
