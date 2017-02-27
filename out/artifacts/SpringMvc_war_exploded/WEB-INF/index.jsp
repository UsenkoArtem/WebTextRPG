<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>First Page</title>
  </head>
  <body>
  <c:forEach  items="${user}" var="user" >
      <table border="1px" , bgcolor="#ffebcd">
  <tr>
      <td width="100"> ${user.id}</td>
      <td width="100"> ${user.login}</td>
      <td width="100"> ${user.password}</td>
      <td width="100"> ${user.userDetails.id}</td>
      <td width="100"> ${user.userDetails.firstName}</td>
      <td width="100"> ${user.userDetails.secondName}</td>
      <td width="100"> ${user.userDetails.age}</td>
      <td width="100"><a href="<c:url value='/user/${user.id}' />"> Edit </a>  </td>
      <td width="100"><a href="<c:url value='/delete/${user.id}' />"> Delete </a>  </td>
  </tr>
      </table>
  </c:forEach>
      <p  width="100" style="background: #0000"> <a href="new_user"> New User </a> </p>
  </body>
</html>