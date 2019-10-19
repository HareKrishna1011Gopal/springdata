<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>User</title>
<h2 style="color:red;text-align:center">Register User Details</h2>
<script type="text/javascript">
   function deleteConfirm() {
	return confirm("Are you sure,you want to delete?");
}
</script>
</head>
<center>
<body>
	<table border="1" text-align="center">
		<thead>
			<tr>
				<th>Sr.No</th>
				<th>UserName</th>
				<th>Email</th>
				<th>Phone No</th>
			</tr>
		</thead>
		<c:forEach items="${userData}" var="u" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
				<td>${u.phno}</td>
				<td><a href="editUser?uid=${u.uid}">Edit</a>&nbsp;&nbsp;
	<a href="softdelete?uid=${u.uid}" onclick="return deleteConfirm()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
   
	<br>
	<c:if test="${cp>1}">
   <a href="viewUser1?pn=${cp-1}">Previous</a>
 </c:if>
 <c:forEach begin="1" end="${tp}" var="i">
   <c:choose>
     <c:when test="${cp==i}">
       <c:out value="${i}"></c:out>
     </c:when>
    <c:otherwise>
       <a href="viewUser1?pn=${i}"><c:out value="${i}"></c:out></a>
    </c:otherwise>
    </c:choose>
 </c:forEach>
 <c:if test="${cp<tp}">
   <a href="viewUser1?pn=${cp+1}">Next</a>
 </c:if>
<br><a href="registerUser">Add User</a>
</body>
</center>
</html>

