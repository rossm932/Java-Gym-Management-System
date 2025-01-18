<!DOCTYPE html>
<html>
<head>
    <title>Add Participant</title>
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
    <h1>Add New Participant</h1>
   <form action="<%=request.getContextPath()%>/addParticipant" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required>
        <label for="phone">Phone:</label>
        <input type="text" name="phone" id="phone" required>
        <label for="batchId">Batch ID:</label>
        <input type="number" name="batchId" id="batchId" required>
        <button type="submit">Add Participant</button>
    </form>
 <a href="<%=request.getContextPath()%>/pages/dashboard.html">Back to Dashboard</a>
</body>
</html>
