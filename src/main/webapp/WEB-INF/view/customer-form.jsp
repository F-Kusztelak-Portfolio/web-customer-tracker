<%--
  Created by IntelliJ IDEA.
  User: Lobo
  Date: 2017-12-03
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manage</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="post">

            <table>
                <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><form:input path="firstName"></form:input></td>
                </tr>

                <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input path="lastName"></form:input></td>
                </tr>

                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"></form:input></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
                </tbody>
            </table>

        </form:form>

        <div style="clear: both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>

</body>
</html>