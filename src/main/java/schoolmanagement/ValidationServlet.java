package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class ValidationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		 Query q=em.createQuery("select a from Principle a where a.email=?1 and a.pass=?2");
		 
		 q.setParameter(1,email);
		 q.setParameter(2,pass);
		 
		 List<Principle> p1=q.getResultList();
		 if(p1.size()>0)
		 {
		RequestDispatcher rd= req.getRequestDispatcher("TeacherStudent.html");
		rd.forward(req, resp);
		 }
		 else {
			 PrintWriter w=resp.getWriter();
			 w.write("invalid credential");
			 RequestDispatcher rd =req.getRequestDispatcher("login.html");
			 rd.include(req,resp);
			 resp.setContentType("text/html");
			 
		 }
	}
	

}
