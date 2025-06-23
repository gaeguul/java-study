<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Insert title here</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>login</h1>--%>
<%--<form name='f' action='/security/login' method='POST'>--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    <c:if test="${param.error != null}">--%>
<%--        <div style="color: red">사용자 ID 또는 비밀번호가 틀립니다.</div>--%>
<%--    </c:if>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>User:</td>--%>
<%--            <td><input type='text' name='username' value=''></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Password:</td>--%>
<%--            <td><input type='password' name='password'/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan='2'>--%>
<%--                <input name="submit" type="submit" value="Login"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background: white;
            padding: 40px 30px;
            border-radius: 12px;
            box-shadow: 9px 11px 20px rgba(0, 0, 0, 0.1);
            width: 320px;
        }

        h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #343a40;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #495057;
            font-weight: 500;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ced4da;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0d6efd;
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0b5ed7;
        }

        .error-message {
            color: #dc3545;
            margin-bottom: 16px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form name="f" action="/security/login" method="POST">
        <%--        필수) CSRF 토큰--%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <c:if test="${param.error != null}">
            <div class="error-message">사용자 ID 또는 비밀번호가 틀립니다.</div>
        </c:if>

        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username"/>
        </div>

        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password"/>
        </div>

        <input type="submit" name="submit" value="로그인"/>
    </form>
</div>
</body>
</html>
