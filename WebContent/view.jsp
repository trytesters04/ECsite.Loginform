<%@ page contentType="text/html;charset=Shift_JIS" %>
<%@ page import="com.ECsite.loginController.*" %>

<%
LoginDTO loginDto = (LoginDTO)request.getAttribute("emp");
String messageTable = (String)request.getAttribute("message");
%>

<html>
	<head>
		<title>ユーザ会員検索ページ</title>
	</head>
	<body>
		<div align="center">
		<h1>ログインフォーム</h1>
		<h2>サインインID,パスワードを入力して下さい</h2>

		<form action = "control" method = "POST">
			サインインID<input type = "text" name = paramSign>
			<br />
			パスワード<input type = "password" name = paramPass>
			<br />
			<input type = "submit" value = "検索">
			<input type = "hidden" name = "btn" value = "UserSerch">
		</form>

		<h1>ユーザ情報</h1>
			<table border="1">
			<tr bgcolor='#FF9900'>
				<td>名前(性)</td>
				<td>名前(名)</td>
				<td>サインインID</td>
				<td>郵便番号</td>
				<td>住所</td>
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