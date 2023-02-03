

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		String correctUserName = "admin@gmail.com";
		String correctPassword = "password";
		
		if(userName.compareTo(correctUserName)==0 && password.compareTo(correctPassword)==0) {
			//PrintWriter writer = response.getWriter();
			//writer.println("<h1>Logged In Successfully.<h1>");
			//writer.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			String loginSuccess = "Success";
		}else {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Wrong Credentials.</h1>"+ "<a href='/DVOPS_Project/login.jsp'>Retry</a>");
			writer.close();
			String loginFail = "Fail";
		}
		doGet(request, response);
	}

}
