package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch")
public class FetchTeacherServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String sal=req.getParameter("sal");
		double sal1=Double.parseDouble(sal);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
		EntityManager em=emf.createEntityManager();

		
		Teacher t= new Teacher();
		t.setId(id1);
		t.setName(name);
		t.setSal(sal1);
		
		
		 Teacher t1=em.find(Teacher.class, id1);
		 
		 resp.setContentType("text/html");
		 PrintWriter pw=resp.getWriter();
		 pw.write("featch Data successfully");
		 
		 
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.include(req, resp);
		 
		
		
		
		 
	}

}
