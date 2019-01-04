package com.ECsite.loginController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet{
	public void doGet(HttpServletRequest request,
					    HttpServletResponse response)
						throws IOException,ServletException{
	response.setContentType("text/html:charset = Shift_JIS");

	String serchBtn = ""; //押されたボタンか判断

	UserSerch users = new UserSerch();
	try {
		serchBtn = request.getParameter("btn");
		//サインインIDとパスワード検索
		if(serchBtn != null && serchBtn.equals("UserSerch")) {
			users.execute(request);
		}else{
			request.setAttribute("message","検索情報を入力してください");
		}
	}catch(Exception e){
		request.setAttribute("message","エラー");
	}

	ServletContext context = getServletContext();
	RequestDispatcher rd = context.getRequestDispatcher("/view.jsp");
	rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
						throws IOException,ServletException{
		doGet(request,response);
	}
}
