<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Name</title>
</head>
<body>

	<%
	
	String infoUser = (String) request.getAttribute("user");
	if(infoUser != null){
		out.println("Bonjour "+infoUser);
	}
	else{
		out.println("Vous n'êtes pas connu");
	}
	
	%>

</body>
</html>