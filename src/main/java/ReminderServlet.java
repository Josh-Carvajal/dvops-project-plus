

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class ReminderServlet
 */
@WebServlet("/ReminderServlet")
public class ReminderServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3307/reminders";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_REMINDERS_SQL = "INSERT INTO reminders" + " (name, reminder, status, importance, date) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_REMINDER_BY_ID = "select * from reminders where name =?;";
	private static final String SELECT_ALL_REMINDERS = "select * from reminders ;";
	private static final String DELETE_REMINDER_SQL = "delete from reminders where name = ?;";
	private static final String UPDATE_REMINDER_SQL = "update reminders set name = ?,reminder = ?,status = ?,importance = ?,date = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	private void listReminders(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			List <Reminder> reminders = new ArrayList <>();
			try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REMINDERS);) {
						ResultSet rs = preparedStatement.executeQuery();
						while(rs.next()) {
							String name = rs.getString("name");
							String reminder = rs.getString("reminder");
							String status = rs.getString("status");
							String importance = rs.getString("importance");
							String date = rs.getString("date");
							reminders.add(new Reminder(name, reminder, status, importance, date));
						}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			request.setAttribute("listReminders", reminders);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String name = request.getParameter("name");
		Reminder existingReminder = new Reminder("","","","","");
		
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REMINDER_BY_ID);) {
			preparedStatement.setString(1, "name");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
				String reminder = rs.getString("reminder");
				String status = rs.getString("status");
				String importance = rs.getString("importance");
				String date = rs.getString("date");
				existingReminder = new Reminder(name, reminder, status, importance, date);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("reminder", existingReminder);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}
	
	private void updateReminder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String reminder = request.getParameter("reminder");
		String status = request.getParameter("status");
		String importance = request.getParameter("importance");
		String date = request.getParameter("date");
		
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_REMINDER_SQL);) {
			statement.setString(1, name);
			statement.setString(2, reminder);
			statement.setString(3, status);
			statement.setString(4, importance);
			statement.setString(5, date);
			//statement.setString(6, oriName);
			
			int num = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8080/DVOPS_Project/ReminderServlet/dashboard");
	}
	
	private void deleteReminder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String reminder = request.getParameter("reminder");
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_REMINDER_SQL);) {
			statement.setString(1, reminder);
			int num = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8080/DVOPS_Project/ReminderServlet/dashboard");
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReminderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/ReminderServlet/delete":
				deleteReminder(request, response);
				break;
			case "/ReminderServlet/edit":
				showEditForm(request, response);
				break;
			case "/ReminderServlet/update":
				updateReminder(request, response);
				break;
			case "/ReminderServlet/dashboard":
				listReminders(request, response);
				break;
			}
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
