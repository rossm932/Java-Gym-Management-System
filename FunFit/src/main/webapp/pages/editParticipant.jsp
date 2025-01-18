<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Your Page Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS (Optional, for interactive components like modals) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>Edit Participant</h1>
	<form action="<%=request.getContextPath()%>/updateParticipant"
		method="post">
		<input type="hidden" name="id" value="${participant.id}"> <label
			for="name">Name:</label> <input type="text" id="name" name="name"
			value="${participant.name}" required> <label for="email">Email:</label>
		<input type="email" id="email" name="email"
			value="${participant.email}" required> <label for="phone">Phone:</label>
		<input type="text" id="phone" name="phone"
			value="${participant.phone}" required> <label for="batchId">Batch
			ID:</label> <input type="number" id="batchId" name="batchId"
			value="${participant.batchId}" required>
		<button type="submit">Update Participant</button>
	</form>

</body>
</html>