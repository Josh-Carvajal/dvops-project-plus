

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;


/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
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
		
		
		String n = request.getParameter("username");
		String r = request.getParameter("tasks");
		String s = request.getParameter("status");
		String i = request.getParameter("importance");
		String d = request.getParameter("date");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/reminders", "root", "");
			
			PreparedStatement ps = con.prepareStatement("insert into REMINDERS values(?,?,?,?,?)");
			
			ps.setString(1, n);
			ps.setString(2, r);
			ps.setString(3, s);
			ps.setString(4, i);
			ps.setString(5, d);
			
			int num = ps.executeUpdate();
			
			if (num > 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ReminderServlet/dashboard");
				dispatcher.forward(request, response);
			}
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
		doGet(request, response);
	}

}
