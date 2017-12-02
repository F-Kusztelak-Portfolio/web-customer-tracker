<%--
  Created by IntelliJ IDEA.
  User: Lobo
  Date: 2017-12-02
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>web-customer-tracker</title>

    <%--reference style sheet--%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <%--add out htm table here--%>

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>

             <%--loop over and print customers--%>
                <c:forEach var="tempCustomer" items="${customers}">

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>

</body>
</html>