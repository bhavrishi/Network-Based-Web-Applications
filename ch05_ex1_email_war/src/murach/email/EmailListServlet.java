package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//System.out.println("REQ get  "+req);
		doPost(req,resp);
	}
    @Override
    public void init(ServletConfig config) throws ServletException {
       System.out.println("Initialising log4j");
       String log4jLocation = config.getInitParameter("log4j-properties-location");
     
       ServletContext sc = config.getServletContext();
     
       if (log4jLocation == null) {
          System.out.println("No log4j properites...");
          BasicConfigurator.configure();
       } else {
          String webAppPath = sc.getRealPath("/");
          String log4jProp = webAppPath + log4jLocation;
          File output = new File(log4jProp);
     
          if (output.exists()) {
             System.out.println("Initialising log4j with: " + log4jProp);
             PropertyConfigurator.configure(log4jProp);
          } else {
             System.out.println("Find not found (" + log4jProp + ").");
             BasicConfigurator.configure();
          }
       }
     
       super.init(config);
    }
	@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		  
		
		Logger logger = Logger.getLogger(EmailListServlet.class.getName());
		   logger.error("Testing Logging");

        String url = "/index.jsp";
		
        // get current action
        String action = request.getParameter("action");
        
        System.out.println("Action value passed to the parameter is - "+action);
        logger.error("Action value passed to the parameter is - " +action);
       
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            // store data in User object
            User user = new User(firstName, lastName, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } 
            else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}