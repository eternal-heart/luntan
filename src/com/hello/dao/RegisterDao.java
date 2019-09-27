package com.hello.dao;

import com.hello.bean.User;
import java.util.*;
import java.sql.*;

public class RegisterDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/forum?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&&useSSL=false&&allowPublicKeyRetrieval=true","root","418613");
		
		}catch(Exception e){
			System.out.print(e);
		}
		
		return con;
	}
	public static int save(User u) {
		int status=0;
		try {
			Connection con=RegisterDao.getConnection();
			String sql="insert into forum.userinfo(`email`, `uerName`, `pwd`) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getMail());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		return status;
	}
	
	public static boolean checkmail(String mail){
		boolean status=false;
		try {
			Connection con=RegisterDao.getConnection();
			String sql="select * from forum.userinfo where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
            ResultSet rs=ps.executeQuery();
			status=rs.next();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean checkname(String name){
		boolean status=false;
		try {
			Connection con=RegisterDao.getConnection();
			String sql="select * from forum.userinfo where uerName=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
			status=rs.next();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
