<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>DTO를 이용한 파라미터 수집</h3>
<form action="/sample/ex01" method="post">
    name: <input type="text" name="name" placeholder="name">
    <br>
    age: <input type="text" name="age" placeholder="age">
    <br>
    <button>제출하기</button>
</form>

<hr/>

<h3>param를 이용한 파라미터 수집</h3>
<form action="/sample/ex02" method="get">
    name: <input type="text" name="name" placeholder="name">
    <br>
    age: <input type="text" name="age" placeholder="age">
    <br>
    <button>제출하기</button>
</form>

<hr/>

<h3>@RequestParam를 이용한 파라미터 수집</h3>
<form action="/sample/ex02-advanced" method="get">
    name: <input type="text" name="name" placeholder="name">
    <br>
    age: <input type="text" name="age" placeholder="age">
    <br>
    <button>제출하기</button>
</form>

</body>
</html>
