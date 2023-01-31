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
@WebServlet("/ds")

public class deleteStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String id=req.getParameter("id");
	int id1=Integer.parseInt(id);
	Student s=new Student();
	
     s.setId(id1);
     s.setName(id);
     s.setMno(id1);
     s.setEmail(id);
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
     EntityManager em=emf.createEntityManager();
     EntityTransaction et=em.getTransaction();
     
    Student s1= em.find(Student.class, id1);
     et.begin();
     em.remove(s1);
     et.commit();
     
   resp.setContentType("text/html");
   PrintWriter pw=resp.getWriter();
   pw.write("delete value sucessfully");
   
  RequestDispatcher rd=req.getRequestDispatcher("Student.html");
  rd.include(req, resp);
	}

}
