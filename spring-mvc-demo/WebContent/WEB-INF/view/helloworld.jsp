<!DOCTYPE html>
<html>
<head>
<%--
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
 --%>
</head>
<body>
Hello World in Spring!
<br><br>
Student name : ${param.studentName }
<br><br>
The message: ${message}
<br><br><br>
<img src="${pageContext.request.contextPath}/resources/images/corvette.jpg" alt="corvette"> 
</body>
</html>