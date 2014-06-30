<%@page language="java" contentType="text/html" %>
<%@page import="java.io.*" %>
<html>
<body>
<%!
public void fun()
{


out.println("random");

}
%>
<%
String model=request.getParameter("model");
String mod_no=request.getParameter("module");
String strategy=request.getParameter("strategy");
if ("rf".equals(model))
{

fun();

}

%>

</body>
</html>