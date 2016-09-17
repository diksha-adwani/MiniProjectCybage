package cybagenet.listener;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {

    public DBListener() {
       
    }
    Connection con ;
    public void contextInitialized(ServletContextEvent event)  { 
       
    	try
    	{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybagenet_db", "root", "root");
			if(con==null)
				System.out.println("No connection");
			else
				System.out.println(" connection established ");
			//storing connection object as attribute in ServletContext  
			ServletContext ctx= event.getServletContext(); 
			ctx.setAttribute("mycon",con);
    	
    	} 
    	catch (ClassNotFoundException | SQLException e)
    	{
    		e.printStackTrace();
		} 
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
      try
      {
		con.close();
      } 
      catch (SQLException e) 
      {
    	  e.printStackTrace();
      }
    }
}
