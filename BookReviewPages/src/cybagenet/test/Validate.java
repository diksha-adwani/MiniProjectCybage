package cybagenet.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cybagenet.pojos.*;

public class Validate extends HttpServlet 
{
	Connection connection;
	PrintWriter out;
	ServletContext ctx;
	ResultSet rs;

	@Override
	public void init() throws ServletException 
	{

		System.out.println("In init of AddBook");
		ctx = getServletContext();

		System.out.println(getServletConfig());
		System.out.println(getServletContext());

		connection = (Connection) ctx.getAttribute("mycon");

		if(connection==null)

			System.out.println("No connection");

		else

			System.out.println(" connection established ");

	}

	public Employee checkUser(String username, String pass) 
	{
		Employee employee1 = null;
		boolean st = false;

		try {
			
			System.out.println("in Validation"+username+pass);
			
			PreparedStatement ps = connection.prepareStatement("select emp.empid,emp.username,emp.firstname,emp.lastname,emp.email,"
					+ "emp.pass,role.role from employees emp,user_role role "
					+ "where emp.username=? and emp.pass=sha1(?) and emp.empid=role.empid");
			
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				employee1 = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee1;
	}
}



