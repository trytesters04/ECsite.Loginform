package com.ECsite.loginController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	Connection connection;
	PreparedStatement login;

	public LoginDAO() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

	    String url = "jdbc:mysql: //localhost:3306/ecsite?characterEncoding=UTF-8&serverTimezone=JST";
	    String user = "root";
		String password = "sora0828"; //git記載時消す

		connection = DriverManager.getConnection(url, user, password);

		String sql = "select * from ecsite.USER_M where SIGN_ID = ? and PASSWORD = ?";

		login = connection.prepareStatement(sql);
	}

	//データベースから取得した値をLoginDAOオブジェクトにして返す
	public LoginDTO getEmpDataforData(String signID,String password)throws SQLException,ClassNotFoundException{
		LoginDTO loginDto = new LoginDTO();

		login.setString(1, signID);
		login.setString(2, password);
		ResultSet resultSet = login.executeQuery();

		if(resultSet.next()) {
			loginDto.setSignID(resultSet.getString("SIGN_ID"));
			loginDto.setFirstName(resultSet.getString("FIRST_NAME"));
			loginDto.setLastName(resultSet.getString("LAST_NAME"));
			loginDto.setPostalNum(resultSet.getString("POSTAL_NUM"));
			loginDto.setAddress(resultSet.getString("ADDRESS"));
		}else{
			loginDto = null;
		}
		return loginDto;
	}

	public void close(){
		try {
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}