 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Claim</title>
</head>
<body>
    <h2>Submit Insurance Claim</h2>
    <form action="submitClaim" method="post">
        <label for="policyNumber">Policy Number:</label>
        <input type="text" id="policyNumber" name="policyNumber" required><br><br>
        <label for="claimType">Claim Type:</label>
        <input type="text" id="claimType" name="claimType" required><br><br>
        <label for="claimAmount">Claim Amount:</label>
        <input type="number" id="claimAmount" name="claimAmount" step="0.01" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
