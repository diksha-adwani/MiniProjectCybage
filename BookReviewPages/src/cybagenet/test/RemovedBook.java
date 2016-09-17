package cybagenet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybagenet.exception.EmptyFieldException;


@WebServlet("/RemovedBook")
public class RemovedBook extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement pst;
	PrintWriter out;
	ServletContext ctx;

	public RemovedBook() 
	{
		System.out.println("In Constructor of RemovedBook");
	}

	@Override
	public void init() throws ServletException 
	{

		ctx = getServletContext();

		connection = (Connection) ctx.getAttribute("mycon");

		if(connection==null)

			System.out.println("No connection");

		else

			System.out.println(" connection established ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();

		String title = (String)session.getAttribute("bname");

		try
		{
			if(title.isEmpty())
				throw new EmptyFieldException();
		}
		catch (EmptyFieldException e) 
		{
			System.out.println(e);
		}

		

		try 
		{

			String query = "DELETE FROM BOOKS WHERE BOOKNAME = ?";

			pst = connection.prepareStatement(query);

			pst.setString(1, title);

			int rows = pst.executeUpdate(); 

			if(rows > 0)
			{

				RequestDispatcher rd = request.getRequestDispatcher("/Removed.jsp");
				rd.forward(request, response);	
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
}

