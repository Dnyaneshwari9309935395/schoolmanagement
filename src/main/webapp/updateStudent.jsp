<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="schoolmanagement.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<% 
String id=request.getParameter("id");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Dnyanu");
EntityManager em=emf.createEntityManager();

      Student s=em.find(Student.class, id1);
%>
<form action="updates" method="post">
id:<input type="id" value="<%=s.getId()%>" name="id">
name:<input type="name" value="<%=s.getName()%>" name="name">
mno:<input type="mno" value="<%=s.getMno()%>" name="mno">
email:<input type="email" value="<%=s.getEmail()%>" name="email">
<input type="submit">
</form>


</body>
</html>