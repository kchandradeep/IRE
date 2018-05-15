<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>

<div style=" height:100px"></div>
	<div><center>
	<% 	session = request.getSession(false); 
	if(session == null)
	{
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request,response);
	}

%>
		<h1>Welcome To ABZ Insurance</h1><br/>
		<h3> Administrator Functions</h3><br/>
		<h4>Mr. <% 
		String s = (String)session.getAttribute("username");
		out.println(s);   
		
		%> </h4>
		<br/>
		<a href="Auto.jsp">View and Maintain Base Rates(Auto)</a><br/>
		<a href ="Home.jsp">View and Maintain Rating Factors</a><br/>
		<a href="Auto.jsp">View and Maintain Base Rates(Home)</a><br/>
		<a href ="Home.jsp">View and Maintain Rating Factors</a><br/><br/>
		
		<a href ="Logout">Logout</a>
	</center></div>
	<div style=" height:100px"></div>
</body>
</html>