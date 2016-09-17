package cybagenet.test;

import java.io.IOException;
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

import cybagenet.pojos.Book;
/**
 * Servlet implementation class ViewBookDetails
 */
@WebServlet("/UserViewBookDetails")
public class UserViewBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
	Connection con ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long isbn=Long.parseLong(request.getParameter("isbn"));
		ctx = getServletContext();
		try
		{
			con = (Connection) ctx.getAttribute("mycon");
			
			PreparedStatement pst=con.prepareStatement("select * from books where isbn=?");
			
			pst.setLong(1, isbn);
			ResultSet rs=pst.executeQuery();
			Book bookPojo=null;
			if(rs.next())
			{
				bookPojo=new Book(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			request.setAttribute("bookPojo", bookPojo);

			RequestDispatcher rd = request.getRequestDispatcher("/UserViewBookDetails.jsp");
			rd.forward(request, response);
			
		}//try ends
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}


	}

}
