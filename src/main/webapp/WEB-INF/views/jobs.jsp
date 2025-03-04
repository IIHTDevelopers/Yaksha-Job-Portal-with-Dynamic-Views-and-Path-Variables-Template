<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Listings</title>
</head>
<body>
	<h2>Available Jobs</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>
		<c:forEach items="${jobs}" var="job">
			<tr>
				<td>${job.id}</td>
				<td><a href="jobs/${job.id}">${job.title}</a></td>
				<td>${job.department}</td>
				<td>${job.salary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
