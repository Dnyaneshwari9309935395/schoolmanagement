<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="schoolmanagement.Teacher" %>
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
EntityManager em =emf.createEntityManager();
   Teacher t=em.find(Teacher.class, id1);

%>
<form action="fetch" method="post">
id:<input type="id" value="<%=t.getId()%>" name="id">
name:<input type="name" value="<%=t.getName()%>" name="name">
sal:<input type="sal" value="<%=t.getSal()%>" name="sal">
<input type="submit">

</form>

</body>
</html>