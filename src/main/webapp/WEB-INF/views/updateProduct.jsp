<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<form action="./updateproduct" method="post">
Id: <input type="number" name="id" id="id"><br>
Name: <input type="text" name="name" id="name"><br>
Price: <input type="number" name="price" id="price"><br>
Quantity: <input type="number" name="quantity" id="quantity"><br>
description: <input type="text" name="description" id="description"><br>
photo url: <input type="text" name="photo" id="photo"><br>
active: <input type="number" name="active" id="active"><br>
<!-- creationdate: <input type="datetime" name="createiondate" id="createiondate"><br> -->
<input type="submit">
</form>
</body>
</html>