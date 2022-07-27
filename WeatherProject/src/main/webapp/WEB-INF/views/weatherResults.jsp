<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather Results</title>
</head>
<body>
	<div>
		<h3>Area Description: ${weather.location.areaDescription}</h3>
		<h3>Elevation: ${weather.currentObservation.elev}</h3>
		<h3>Latitude: ${weather.currentObservation.latitude}</h3>
		<h3>Longitude: ${weather.currentObservation.longitude}</h3>
		<h3>Temperature: ${weather.currentObservation.temp}</h3>
		<h3>Upcoming Weather: </h3>
		<h4>
			<c:forEach var="unit" items="${upcomingWeather}">
				<td> ${unit.startPeriodName}: Temperature will be ${unit.temperature}. ${unit.text}</td><br><br>
			</c:forEach>
		</h4>
	</div>
</body>
</html>