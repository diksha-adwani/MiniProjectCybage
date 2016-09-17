package cybagenet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybagenet.pojos.*;

@WebServlet("/Logout")
public class Logout extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	ServletContext context;

	@Override
	public void init() throws ServletException {
		context=getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		
		Employee emp=(Employee)hs.getAttribute("employee");

		if(emp!=null)//if employee is user and not admin
		{
			System.out.println("Role"+emp.getRole());
			Integer activeUsrsCount=(Integer)context.getAttribute("activeUsersCount");
			System.out.println("act"+activeUsrsCount);
			context.setAttribute("activeUsersCount", activeUsrsCount-1);
		}
		
		hs.invalidate();
		out.println("You are Successfully Logged Out!");
		
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);

	}

}
