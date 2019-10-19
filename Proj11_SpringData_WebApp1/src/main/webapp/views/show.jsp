<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src=https://code.jquery.com/jquery-1.12.4.min.js></script>
<script src=https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js></script>
<script>
$(function(){
$('form[id="user_form"]').validate({
	  rules: {
	    username: 'required',
	    pwd: {
		      required: true,
		      minlength: 4
		    },
	    email: {
	      required: true,
	      email: true
	    },
	    phno:{
	    	required:true,
	    	minlength:5,
	    	maxlength:10
	    }
	  },
	  messages: {
	    username: 'This field is required',
	    email: 'Enter a valid email',
	    pwd: {
	      minlength: 'Password must be at least 8 characters long'
	    },
	  phno:{
		   minlength:'Must be in digits'
	  }
	   },
	  
	  submitHandler: function(form) {
	    form.submit();
	  }
    });
});
</script>
Result::${resultMsg}
<form:form action="registerUser" method="post" modelAttribute="user" id="user_form">
   <table>
     <tr>
     <td>UserName::</td>
     <td><form:input path="username"/></td>
     </tr>
     
     <tr>
     <td>Password::</td>
     <td><form:input type="password" path="pwd"/></td>
     </tr>
     
     <tr>
     <td>Email::</td>
     <td><form:input path="email"/></td>
     </tr>
     
     <tr>
     <td>Phone No::</td>
     <td><form:input path="phno"/></td>
     </tr>
     
   </table>
<br><br>
<input type="submit" value="register" />
<input type="reset" value="Reset" />
</form:form>
<br><br>
<a href="viewUser1?pn=1">View User</a>