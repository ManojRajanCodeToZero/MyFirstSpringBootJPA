<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
<form action="addEngineer">
ID:   <input type="text" name="eid"><br>
Name: <input type="text" name="eName"><br>
Language:<input type="text" name="eLang"><br>
      <input type="submit"><br>
</form>
<form action="displayEngineer">
	<input type="text" name="eid"><br>
    <input type="submit"><br>
</form>

<form action="deleteEngineer">
	Enter an Eid To delete: <input type="text" name="eid"><br>
    <input type="submit"><br>
</form>

<form action="gotoSortedEngineer">
	Enter the Language: <input type="text" name="eLang"><br>
    <input type="submit"><br>
</form>
</body>
</html>