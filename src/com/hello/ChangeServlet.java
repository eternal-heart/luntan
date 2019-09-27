package com.hello;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.hello.bean.User;
import com.hello.dao.ChangeDao;

public class ChangeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			
			String mail=request.getParameter("mail");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			if(ChangeDao.check(mail,name)) {
				User user=new User(mail, name, password);
				user.setMail(mail);
				user.setName(name);
				user.setPassword(password);
				int status=0;
				try {
					status=ChangeDao.change(user);
					if(status>0) {
						RequestDispatcher rd = request.getRequestDispatcher("change.jsp");
		                rd.include(request, response);
					}else {
						out.print("修改失败");
						RequestDispatcher rd = request.getRequestDispatcher("error2.html");
		                rd.include(request, response);
					}
				}catch(Exception e2) {
					System.out.println(e2);
				}
	        }else {
	        	out.print("操作失败，邮箱或昵称输入错误");
				RequestDispatcher rd = request.getRequestDispatcher("error2.html");
                rd.include(request, response);
	        }
		out.close();
	}
}
