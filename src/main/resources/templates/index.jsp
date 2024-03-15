<html>
<body>
    <h1>Book Train Tickets</h1>
    <form action="/book" method="post">
        <label for="from">From:</label>
        <select id="from" name="from">
            <c:forEach var="station" items="${stations}">
                <option value="${station.code}">${station.name}</option>
            </c:forEach>
        </select><br>
        <label for="to">To:</label>
        <select id="to" name="to">
            <c:forEach var="station" items="${stations}">
                <option value="${station.code}">${station.name}</option>
            </c:forEach>
        </select><br>
        <label for="passengerName">Passenger Name:</label>
        <input type="text" id="passengerName" name="passengerName"><br>
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
