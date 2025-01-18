<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Your Page Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS (Optional, for interactive components like modals) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <title>View Participants</title>
</head>
<body>
    <h1>All Participants</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Batch ID</th>
        </tr>
        <c:forEach var="participant" items="${participants}">
        <tr>
             <td>${participant.id}</td>
             <td>${participant.name}</td>
             <td>${participant.email}</td>
             <td>${participant.phone}</td>
             <td>${participant.batchId}</td>
              <td>
                <a href="${pageContext.request.contextPath}/editParticipant?id=${participant.id}">Edit</a> | 
                <a href="${pageContext.request.contextPath}/deleteParticipant?id=${participant.id}" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="<%=request.getContextPath()%>/pages/dashboard.html">Back to Dashboard</a>
</body>
</html>
