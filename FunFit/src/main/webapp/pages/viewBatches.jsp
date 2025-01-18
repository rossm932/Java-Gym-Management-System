<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Your Page Title</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap JS (Optional, for interactive components like modals) -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<title>View Batches</title>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center">All Batches</h1>
		<table class="table table-striped mt-3">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Batch Name</th>
					<th>Timetable</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="batch" items="${batches}">
					<tr>
						<td>${batch.id}</td>
						<td>${batch.batchName}</td>
						<td>${batch.timetable}</td>
						<td><a href="editBatch?id=${batch.id}"
							class="btn btn-warning btn-sm">Edit</a> <a
							href="deleteBatch?id=${batch.id}" class="btn btn-danger btn-sm">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<%=request.getContextPath()%>/pages/dashboard.html" class="btn btn-secondary mt-3">Back to Dashboard</a>
	</div>
</body>
</html>

