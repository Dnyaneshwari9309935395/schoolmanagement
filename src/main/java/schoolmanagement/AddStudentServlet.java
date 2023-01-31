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
@WebServlet("/as")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		
		String name=req.getParameter("name");
		String mno=req.getParameter("mno");
		long mno1=Long.parseLong(mno);
		
		String email=req.getParameter("email");
		
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
		s.setMno(mno1);
		s.setEmail(email);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
	
		
		et.begin();
		em.persist(s);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.write("save data sucessfully");
		
		RequestDispatcher rd=req.getRequestDispatcher("Student.html");
		rd.include(req, resp);
	}
	

}
