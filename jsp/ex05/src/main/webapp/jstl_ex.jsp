<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>JSTL 예제</title>
</head>
<body>
    <%-- 예제 코드 작성 --%>

    <h1>c:set</h1>
    <h3>지정된 범위에 변수 설정</h3>
    <c:set var="username" value="KB_User" scope="request" />
    <p>사용자 이름: ${username}</p>


    <h1>c:out</h1>
    <h3>EL 표현식의 결과나 지정된 값 출력</h3>
    <c:set var="message" value="<b>hello</b> JSTL"/>
    <p>이스케이프 안 함:
        <c:out value="${message}" escapeXml="false"/>
    </p>
    <p>이스케이프 함:
        <c:out value="${message}"/>
    </p>


    <h1>c:if</h1>
    <h3>조건에 따라 내용을 포함할지 결정. else 없음</h3>
    <c:set var="score" value="59" />
    <c:if test="${score >= 90}">
        <p>점수가 90점 이상입니다 (A학점)</p>
    </c:if>
    <c:if test="${score < 60}">
        <p>점수가 60점 미만입니다 (F학점)</p>
    </c:if>


    <h1>c:choose, c:when, c:otherwise</h1>
    <h3>다중 조건문: 여러 조건을 사용하여 흐름 제어. if-else if-else와 유사</h3>
    <c:set var="grade" value="B" />
    <c:choose>
        <c:when test="${grade eq 'A'}">
            <p>Excellent!</p>
        </c:when>
        <c:when test="${grade eq 'B'}">
            <p>Good!</p>
        </c:when>
        <c:otherwise>
            <p>Try Harder!</p>
        </c:otherwise>
    </c:choose>

    <h1>c:forEach</h1>
    <h3>반복문: 컬렉션이나 배열을 반복하거나, 특정 횟수만큼 반복</h3>

    <%-- 숫자 반복 --%>
    <p>1부터 5까지 반복:</p>
    <ul>
        <c:forEach var="i" begin="1" end="5">
            <li>${i}</li>
        </c:forEach>
    </ul>

    <%-- 배열/리스트 반복 --%>
    <c:set var="fruits" value="${['사과', '바나나', '오렌지', '포도']}" />
    <p>과일 목록:</p>
    <ul>
        <c:forEach var="fruit" items="${fruits}" varStatus="status">
            <li>${status.index}. ${fruit} ${status.first ? '(첫 번째)' : ''} ${status.last ? '(마지막)' : ''}</li>
        </c:forEach>
    </ul>
</body>
</html>