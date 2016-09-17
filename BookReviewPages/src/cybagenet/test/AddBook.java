package cybagenet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import cybagenet.exception.EmptyFieldException;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement pst1,pst2;
	PrintWriter out;
	ServletContext ctx;
	ResultSet rs;

	public AddBook() 
	{
		System.out.println("In Constructor of AddBook");
	}

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("In doPost of AddBook");

		out = response.getWriter();

		try
		{

			if(!(request.getParameter("category").isEmpty() || request.getParameter("isbn").isEmpty() || request.getParameter("name").isEmpty() || request.getParameter("author").isEmpty() || request.getParameter("publication").isEmpty()))
			{
				try
				{
					System.out.println("In try of AddBook");

					System.out.println(request.getParameter("isbn"));

					int isbn1 = Integer.parseInt(request.getParameter("isbn"));

					String query1 = "UPDATE BOOKS SET ISBN = ISBN + 0 WHERE ISBN = ?";

					pst2 = connection.prepareStatement(query1);

					pst2.setInt(1, isbn1);

					System.out.println(pst2.executeUpdate());

					if(!(pst2.executeUpdate() > 0))
					{

						String query = "INSERT INTO BOOKS VALUES(?,?,?,?,?,?)";

						pst1 = connection.prepareStatement(query);

						{
							System.out.println("In IFFFFF");
							pst1.setInt(1,Integer.parseInt(request.getParameter("isbn")));
							pst1.setString(2, request.getParameter("name"));
							pst1.setString(3, request.getParameter("category"));
							pst1.setString(4, request.getParameter("author"));
							pst1.setString(5, request.getParameter("publication"));
							pst1.setString(6, request.getParameter("description"));

							System.out.println("Number of rows Entered : "+pst1.executeUpdate());
							response.sendRedirect("Success.jsp");

						}
					}
					else
						response.sendRedirect("Failure.jsp");
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
			}
			else
			{
				System.out.println("in Else");
				throw new EmptyFieldException();
			}
		}
		catch(EmptyFieldException e1)
		{
			out.println("Each Field is Mandatory . . . ");
			out.println("<br/><br/>");
			out.println("<b><a href='AddBook.jsp'>Back</a></b>");
			
		}
	}
}
