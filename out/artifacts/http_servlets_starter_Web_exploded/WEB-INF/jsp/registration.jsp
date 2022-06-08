<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img width="500px" height="250px" src="${pageContext.request.contextPath}/images/users/167490-osennie_derevya_korichnevye-osen-list-derevo-vetv-3840x2160.jpg" alt="User image">

    <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
        <label for="name">Name:
            <input type="text" name="name" id="name">
        </label><br>
        <label for="birthday">Birthday:
            <input type="date" name="birthday" id="birthday" required>
        </label><br>
        <label for="image">Image:
            <input type="file" name="image" id="image" required>
        </label><br>
        <label for="email">Email:
            <input type="email" name="email" id="email">
        </label><br>
        <label for="password">Password:
            <input type="password" name="password" id="password">
        </label><br>
        <select name="role" id="role">
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select><br>
        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value="${gender}"> ${gender}
            <br>
        </c:forEach>
        <button type="submit">Send</button>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                </c:forEach>
            </div>
        </c:if>
    </form>
</body>
</html>
