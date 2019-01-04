package com.ECsite.loginController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class UserSerch {
	public int execute(HttpServletRequest request)throws Exception{
		LoginDAO loginDao = new LoginDAO();

		String empSignID = request.getParameter("paramSign");
		String empPassword = request.getParameter("paramPass");

		try {
			if(empSignID != null && empPassword != null &&
				!empSignID.equals("") && !empPassword.equals("")){

				//検索結果をDAOに入れてからArrayListに返す
				LoginDTO loginDto = loginDao.getEmpDataforData(empSignID , empPassword);

				if(loginDto != null) {
					request.setAttribute("emp",loginDto);
				}else{
					request.setAttribute("message","サインインIDまたはパスワードが間違っています");
				}
			}else{
				request.setAttribute("message",
									"サインインIDまたはパスワード入力してください");
			}
		}catch(NumberFormatException e) {
			request.setAttribute("message","数値を入力してください");
			e.printStackTrace();
		}catch(SQLException e) {
			request.setAttribute("message","JDBCエラーです");
		}catch(Exception e) {
			request.setAttribute("message","数値を入力してください");
		}finally{
			if(loginDao != null) loginDao.close();
		}
		return 0;
	}
}
