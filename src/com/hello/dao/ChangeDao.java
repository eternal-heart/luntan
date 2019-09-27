package com.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hello.bean.User;

public class ChangeDao {
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
	
	public static boolean check(String mail, String password) {
        System.out.println("mail : "+mail+", Password："+password);
        boolean status = false;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/forum?useSSL=false&&allowPublicKeyRetrieval=true&&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "418613");
            // 邮箱及密码是否正确？
            PreparedStatement ps = con.prepareStatement("SELECT * FROM userinfo WHERE email=? AND uerName=?");
            ps.setString(1, mail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
	
	public static int change(User u) {
		int status=0;
		try {
			Connection con=RegisterDao.getConnection();
			String sql="UPDATE `forum`.`userinfo` SET `pwd` = ? WHERE (`email` = ?) and (`uerName` = ?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getMail());
			ps.setString(3, u.getName());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		return status;
	}
}
