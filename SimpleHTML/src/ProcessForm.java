

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessForm
 */
@WebServlet("/ProcessForm")
public class ProcessForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message=showData(request);
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
	}
	
	private String showData(HttpServletRequest request){
		String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
		String gender = request.getParameter("sex");
		String comments = request.getParameter("comments");
		String selectCars=request.getParameter("selectCars");
		System.out.println(name);
		String message = "<br></br> User name is " + name + "<br></br>";
		if (gender.equalsIgnoreCase("male")){
			message+= "He thinks " + comments +"<br></br>";
			message +="he loves cars like " + selectCars ;
		}else
			message+= "She thinks " + comments +"<br></br> She loves cars like " + selectCars ;
		
		return message;

	}

}
