<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="utf-8">
<title>Murach's Java Servlets and JSP</title>
<link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>

<body>
	<h1>Thanks for joining our email list</h1>

	<p>Here is the information that you entered:</p>

	<%-- <jsp:useBean id="user" scope="session" class="murach.business.User" />
	 --%>
	<label>Email:</label>
	<span>${user.email}</span>
	<br>
	<label>First Name:</label>
	<span>${user.firstName}</span>
	<br>
	<label>Last Name:</label>
	<span>${user.lastName}</span>
	<br>
	<label>Current Date:</label>
	<span>${requestScope.currentDate}</span>
	<br>
	<%
		ArrayList<murach.business.User> users = (ArrayList<murach.business.User>) session.getAttribute("users");

		/*  for(murach.business.User usertemp : users)
		 {
		 out.print("First Name: " + usertemp.getFirstName());
		 out.print("<br/>");
		 out.print("Last Name: " + usertemp.getLastName());
		 out.print("<br/>");
		 out.print("Email: " + usertemp.getEmail());
		 out.print("<br/>");
		
		 } */
	%>
	<p>First Name: ${users[0].firstName}</p>
	<p>Last Name: ${users[0].lastName}</p>
	<p>Email: ${users[0].email}</p>
	<p>First Name: ${users[1].firstName}</p>
	<p>Last Name: ${users[0].lastName}</p>
	<p>Email: ${users[0].email}</p>
	<label>Customer Service Email:</label>
	<span>${requestScope.ctxemail}</span>
	<br>
	<p>To enter another email address, click on the Back button in your
		browser or the Return button shown below.</p>

	<form action="" method="get">
		<input type="hidden" name="action" value="join"> <input
			type="submit" value="Return">
	</form>

</body>
</html>