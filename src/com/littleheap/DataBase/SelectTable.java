package com.littleheap.DataBase;

import java.sql.*;

import com.littleheap.Static.Information;

public class SelectTable {

	public SelectTable() {
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");

            String sql = "select * from temp";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t"+"姓名"+"\t"+"年龄");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
	}
    
    public static boolean isExist_Customer(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Customer";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("用户名"+"\t"+"\t"+"\t"+"密码");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
    
    public static boolean isExist_Manager(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("用户名"+"\t"+"\t"+"\t"+"密码");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

    public static void regist_Customer(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");

            String sql = "insert into Customer values('"+user+"','"+password+"');";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    public static void regist_Manager(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Manager");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Manager");

            String sql = "insert into Manager values('"+user+"','"+password+"');";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
