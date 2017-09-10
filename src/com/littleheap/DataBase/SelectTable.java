package com.littleheap.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.littleheap.Book;
import com.littleheap.Static.Information;

public class SelectTable {
	
	//数据库查询连接模板
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
    
	//是否存在该用户
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
    
    //是否存在该管理员
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

    //注册新用户
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
    
    //注册新管理员
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
    
    //改变用户的密码
    public static void changePassword_Customer(String user,String password,String newPassword) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Customer set customer_password = '"+newPassword+"' where customer_user = '"+user+"';";    //要执行的SQL
            
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
    
    //改变管理员的密码
    public static void changePassword_Manager(String user,String password,String newPassword) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Manager set manager_password = '"+newPassword+"' where manager_user = '"+user+"';";    //要执行的SQL
            
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

    //是否存在该用户名
    public static boolean isExist_Customer_user(String user,String password) {
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
                    if(rs.getString(1).equals(user)) {
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

    //是否存在该管理员名称
    public static boolean isExist_Manager_user(String user,String password) {
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
                    if(rs.getString(1).equals(user)) {
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
    
    //插入新书
    public static void insertBook(String number,String classnumber,String name,String classname,String price,String state,String total) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-insertBook");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-insertBook");

            String sql = "insert into "+classname+"Book"+" values('"+number+"','"+classnumber+"','"+name+"','"+classname+"','"+price+"','"+state+"','"+total+"',null,null,null);";    //要执行的SQL
            
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

    //新建类别
    public static void newClass(String classnumber, String classname) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-newClass");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-newClass");

            String sql = "CREATE TABLE "+classname+"Book(number VARCHAR(255) primary key,classnumber VARCHAR(255),name VARCHAR(255),classname VARCHAR(255),price VARCHAR(255),state VARCHAR(255),total VARCHAR(255),current VARCHAR(255),dateon VARCHAR(255),dateoff VARCHAR(255));";    //要执行的SQL
            
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
    
    //删除书籍信息
    public static void deleteBook(String number, String classname) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-deleteBook");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-deleteBook");

            String sql = "delete from "+classname+"Book where number = '"+number+"';";  //要执行的SQL
            
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

    //查询某类图书信息
    public static void search_classname(String classname) {
    	Information.bookarray.clear();
    	try{
    		
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_classname");
                
            String url=Information.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_classname");

            String sql = "select * from "+classname+"Book;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                while (rs.next()){
                	Book book = new Book();
                    book.number = rs.getString(1);
                    book.classnumber = rs.getString(2);
                    book.name = rs.getString(3);
                    book.classname = rs.getString(4);
                    book.price = rs.getString(5);
                    book.state = rs.getString(6);
                    book.total = rs.getString(7);
                    book.current = rs.getString(8);
                    book.dateon = rs.getString(9);
                    book.dateoff = rs.getString(10);
                    Information.bookarray.add(book);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
