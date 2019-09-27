package com.hello;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.hello.bean.User;
import com.hello.dao.LoginDao;
import com.hello.dao.RegisterDao;

public class Register extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			
			String mail=request.getParameter("mail");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			if(RegisterDao.checkmail(mail)) {
				out.print("注册失败，邮箱已注册");
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
                rd.include(request, response);
			}else {
				if(RegisterDao.checkname(name)) {
					out.print("注册失败，昵称已注册");
					RequestDispatcher rd = request.getRequestDispatcher("error.html");
	                rd.include(request, response);
				}else {
					User user=new User(mail, name, password);
					user.setMail(mail);
					user.setName(name);
					user.setPassword(password);
					int status=0;
					try {
						status=RegisterDao.save(user);
						if(status>0) {
							String username=LoginDao.search(mail);
			                request.setAttribute("username", username);
							RequestDispatcher rd = request.getRequestDispatcher("reg.jsp");
			                rd.include(request, response);
						}else {
							out.print("注册失败");
							RequestDispatcher rd = request.getRequestDispatcher("error.html");
			                rd.include(request, response);
						}
					}catch(Exception e2) {
						System.out.println(e2);
					}
				}
			}
		out.close();
	}
}
