package cybagenet.test;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cybagenet.pojos.Book;

@WebServlet("/UserViewBookList")
public class UserViewBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext ctx;

	public UserViewBookList() 
	{
		System.out.println("In Constroouctor UserViewList");

	}
	
	

	Connection con ;

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		ctx = getServletContext();

		PrintWriter out = response.getWriter();

		try
		{
			con = (Connection) ctx.getAttribute("mycon");//getting connection from listener
			PreparedStatement ps;	//creting instance of preparedstatement

			String category = request.getParameter("category");//getting value from jsp page
			String book_name = request.getParameter("book_name");

			if(category.equals("all") && book_name.equals(""))//if caqtegory is all and book_name is blank
			{
				//out.println("1");
				ps = con.prepareStatement("select * from books");
			}
			else if(category.equals("all"))
			{
				//out.println("2");
				ps = con.prepareStatement("select * from books where BookName LIKE '%" +book_name+"%'" );
			}
			else
			{
				//out.println("3");
				ps = con.prepareStatement("select * from books where BookName LIKE '%" +book_name+"%' and Category LIKE '%" +category+"%'" );
			}

			ResultSet rs = ps.executeQuery();	//executing preparedstatement and storing in resultset

			ArrayList<Book> bookList = new ArrayList<>();

			while(rs.next())
			{
				Book b = new Book();
				b.setIsbn(rs.getLong(1));
				b.setBookName(rs.getString(2));
				b.setCategory(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setPublication(rs.getString(5));
				b.setDescription(rs.getString(6));
				bookList.add(b);
			}

			request.setAttribute("bookList",bookList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/UserViewBookList.jsp");
			rd.forward(request, response);

			out.println("<b><a href='ViewBook.jsp'>Back</b>");

		}//try ends
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}//doGet ends


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
