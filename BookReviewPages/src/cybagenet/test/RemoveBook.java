package cybagenet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import cybagenet.pojos.Book;


@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement pst;
	PrintWriter out;
	ServletContext ctx;

	public RemoveBook() 
	{
		System.out.println("In Constructor of RemoveBook");
	}

	@Override
	public void init() throws ServletException 
	{
		System.out.println("In init of RemoveBook");
		ctx = getServletContext();

		System.out.println(getServletConfig());
		System.out.println(getServletContext());

		connection = (Connection) ctx.getAttribute("mycon");

		if(connection==null)

			System.out.println("No connection");

		else

			System.out.println(" connection established ");

	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("In doGet of RemoveBook");

		out = resp.getWriter();

		System.out.println(req.getParameter("category"));

		try 
		{
			String category = req.getParameter("category");

			System.out.println("Title of Book : "+category);

			String query = "SELECT * FROM BOOKS WHERE CATEGORY = ?";

			pst = connection.prepareStatement(query);

			pst.setString(1, category);

			ResultSet rs = pst.executeQuery(); 

			ArrayList<Book> al = new ArrayList<>();

			while(rs.next())
			{
				Book b = new Book();
				b.setIsbn(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setCategory(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setPublication(rs.getString(5));
				b.setDescription(rs.getString(6));
				al.add(b);
			}

			req.setAttribute("list",al);
			req.setAttribute("message","No Such Books");


			RequestDispatcher rd = req.getRequestDispatcher("/RemoveSuccess.jsp");
			rd.forward(req, resp);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("In doPost of RemoveBook");

		out = response.getWriter();

		try
		{
			System.out.println("In try of RemoveBook");

			System.out.println(request.getParameter("title"));

			if(!(request.getParameter("title").isEmpty()/* || (request.getParameter("category").isEmpty())*/))
			{
				try 
				{
					String title = request.getParameter("title");

					System.out.println("Title of Book : "+title);

					String query = ("SELECT * FROM BOOKS WHERE BOOKNAME LIKE '%"+title+"%'");

					pst = connection.prepareStatement(query);

					ResultSet rs = pst.executeQuery();
					
					ArrayList<Book> al = new ArrayList<>();

					while(rs.next())
					{
						if(rs.getString(2).contains(title))
						{
							Book b = new Book();
							b.setIsbn(rs.getInt(1));
							b.setBookName(rs.getString(2));
							b.setCategory(rs.getString(3));
							b.setAuthor(rs.getString(4));
							b.setPublication(rs.getString(5));
							b.setDescription(rs.getString(6));
							al.add(b);
						}
					}

					request.setAttribute("list",al);
					
					RequestDispatcher rd = request.getRequestDispatcher("/RemoveSuccess.jsp");
					rd.forward(request, response);
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}

			else
			
				throw new EmptyFieldException("You Entered Empty Book Name");
			
		}
		
		catch(EmptyFieldException e)
		{
			System.out.println("In Catch");
			out.println("<b>"+e.getMessage()+"</b>");
			out.println("<br/><br/>");
			out.println("<b><a href='RemoveBook.jsp'>Back</a></b>");
		}

	}
}
