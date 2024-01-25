<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="raseabi.replace.this.link.name" /></h2>

<br/>
<table>
  <tr>
   <th>Patient Id</th>
   <th>Names</th>
   <th>Gender</th>
   <th>Mobile Number</th>
   <th>Appointment Date</th>
  </tr>
  <c:forEach items="${appointments}" var="appointment">
      <tr>
        <td>${appointment.patientIdentifier}</td>
        <td>${appointment.personName}</td>
        <td>${appointment.gender}</td>
        <td>${appointment.mobileNumber}</td>
        <td>${appointment.startDate}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
