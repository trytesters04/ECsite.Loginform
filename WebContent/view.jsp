<%@ page contentType="text/html;charset=Shift_JIS" %>
<%@ page import="com.ECsite.loginController.*" %>

<%
LoginDTO loginDto = (LoginDTO)request.getAttribute("emp");
String messageTable = (String)request.getAttribute("message");
%>

<html>
	<head>
		<title>���[�U��������y�[�W</title>
	</head>
	<body>
		<div align="center">
		<h1>���O�C���t�H�[��</h1>
		<h2>�T�C���C��ID,�p�X���[�h����͂��ĉ�����</h2>

		<form action = "control" method = "POST">
			�T�C���C��ID<input type = "text" name = paramSign>
			<br />
			�p�X���[�h<input type = "password" name = paramPass>
			<br />
			<input type = "submit" value = "����">
			<input type = "hidden" name = "btn" value = "UserSerch">
		</form>

		<h1>���[�U���</h1>
			<table border="1">
			<tr bgcolor='#FF9900'>
				<td>���O(��)</td>
				<td>���O(��)</td>
				<td>�T�C���C��ID</td>
				<td>�X�֔ԍ�</td>
				<td>�Z��</td>
			</tr>
			<%
			if(loginDto != null){
				%>
				<tr>
					<td><%= loginDto.getFirstName() %></td>
					<td><%= loginDto.getLastName() %></td>
					<td><%= loginDto.getSignID() %></td>
					<td><%= loginDto.getPostalNum() %></td>
					<td><%= loginDto.getAddress() %></td>
				</tr>
				<%
			}else{
			%>
				<tr><td colspan="5"><%= messageTable %></td></tr>
				<%
				}
				%>
			</table>
		</div>
	</body>
</html>