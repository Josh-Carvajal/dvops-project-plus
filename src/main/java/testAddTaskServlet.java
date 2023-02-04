import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testAddTaskServlet {
	private AddTaskServlet as;
	private String n;
	private String r;
	private String s;
	private String i;
	private String d;

	@BeforeEach
	void setUp() throws Exception {
		n = "William";
		r = "Doctors Appointment";
		s = "Pending";
		i = "High Importance";
		d = "23/3/2023";
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		//fail("Not yet implemented");
		asserEquals(n, "Willaim");
		asserEquals(r, "Doctors Appointment");
		asserEquals(s, "Pending");
		asserEquals(i, "High Importance");
		asserEquals(d, "23/3/2023");
	}

	private void asserEquals(String n2, String string) {
		// TODO Auto-generated method stub
		
	}

}
