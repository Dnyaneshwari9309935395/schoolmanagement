package schoolmanagement;

import java.io.IOException;

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

@WebServlet("/principle")
public class PrincipleServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		int id2=Integer.parseInt(id);
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Principle p=new Principle();
		p.setName(name);
		p.setAddress(address);
		p.setId(id2);
		p.setEmail(email);
		p.setPass(pass);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd= req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		
	}

}
