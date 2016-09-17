package cybagenet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybagenet.pojos.Employee;

@WebServlet("/Login")

public class Login extends HttpServlet {
	Validate validate = new Validate();

	Connection connection;
	PrintWriter out;
	ServletContext ctx;
	ResultSet rs;

	ServletContext context;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("In init of AddBook");
		ctx = getServletContext();

		System.out.println(getServletConfig());
		System.out.println(getServletContext());

		connection = (Connection) ctx.getAttribute("mycon");

		if (connection == null)
			System.out.println("No connection");

		else

			System.out.println(" connection established ");
		context = getServletContext();
		context.setAttribute("activeUsersCount", 0);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String pass = request.getParameter("pass");

		Employee employee1 = null;

		System.out.println("in Validation" + username + pass);
		try {
			PreparedStatement ps = connection
					.prepareStatement("select emp.empid,emp.username,emp.firstname,emp.lastname,emp.email,"
							+ "emp.pass,role.role from employees emp,user_role role "
							+ "where emp.username=? and emp.pass=sha1(?) and emp.empid=role.empid");

			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				employee1 = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}

			System.out.println(employee1);

			RequestDispatcher rd;
			if (employee1 != null) {
				if (employee1.getRole().equalsIgnoreCase("Admin")) {
					hs.setAttribute("admin", employee1);
					rd = request.getRequestDispatcher("AdminHome.jsp");
					

				} else {
					context = getServletContext();
					Integer activeUsrsCount = (Integer) context.getAttribute("activeUsersCount");
					if (activeUsrsCount == null) {
						activeUsrsCount = 0;
					}

					context.setAttribute("activeUsersCount", activeUsrsCount + 1);
					hs.setAttribute("employee", employee1);
					rd = request.getRequestDispatcher("UserHome.jsp");
					
				}
				rd.forward(request, response);
			} else {
				out.print("<h5><font color='red'>Username or Password incorrect</font></h5>");
				out.print("<h5>Try Again</h5>");
				rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}// doPost() ends
}// class ends
