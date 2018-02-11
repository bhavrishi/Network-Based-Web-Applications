<%@include file="header.jsp"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="java.util.ArrayList"%>
<section>
	<h1>Future Value Calculator</h1>

	<label>Investment Amount:</label> <span>${requestScope.investmnt}</span><br />

	<label>Yearly Interest Rate:</label> <span>${requestScope.intRate}</span><br />

	<label>Number of Years:</label> <span>${requestScope.years}</span><br />

	<label>Future Value:</label> <span>${requestScope.futValue}</span><br />

	<!--  <label>&nbsp;</label> -->
	<table>
		<tr>
			<th>Year</th>
			<th class="right">Value</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach var="cal" items="${requestScope.calculations}">
			<tr>
				<td><c:out value="${cal.years}" /></td>
				<td class="right"><c:out value="${cal.futureValue}" /></td>
			</tr>
		</c:forEach>
	</table>

	<span><a href="index.jsp">Return to Calculator</a></span>
</section>
<%@include file="footer.jsp"%>
