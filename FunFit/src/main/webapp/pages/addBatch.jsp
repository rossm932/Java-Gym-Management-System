<!DOCTYPE html>
<html>
<head>
    <title>Add Batch</title>
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
    <h1>Add New Batch</h1>
    <form action="/FunFit/addBatch" method="post">
        <label for="batchName">Batch Name:</label>
        <input type="text" id="batchName" name="batchName" required>
        <br>
        <label for="timetable">Timetable:</label>
        <input type="text" id="timetable" name="timetable" required>
        <br>
        <button type="submit">Add Batch</button>
    </form>
    <br>
    <a href="<%=request.getContextPath()%>/pages/dashboard.html">Back to Dashboard</a>
</body>
</html>
