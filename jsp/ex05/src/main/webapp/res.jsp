<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <title>Insert title here</title>
</head>
<body>
<%--Servlet에서 위임받은 request, response 사용 가능함--%>
username 값: <%=request.getAttribute("username") %><br>
useraddress 값: <%=request.getAttribute("useraddress") %><br>
</body>
</html>