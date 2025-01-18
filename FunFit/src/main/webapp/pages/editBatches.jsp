<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Batch</title>
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
	<h1>Edit Batch</h1>
	<form action="<%=request.getContextPath()%>/updateBatch" method="post">
		<input type="hidden" name="id" value="${batch.id}"> <label
			for="batchName">Batch Name:</label> <input type="text" id="batchName"
			name="batchName" value="${batch.batchName}" required> <br>
		<label for="timetable">Timetable:</label> <input type="text"
			id="timetable" name="timetable" value="${batch.timetable}" required>
		<br>
		<button type="submit">Update Batch</button>
	</form>
	<br>
	<a href="<%=request.getContextPath()%>/viewBatches">Back to Batches</a>
</body>
</html>
