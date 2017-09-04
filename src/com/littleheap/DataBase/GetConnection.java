package com.littleheap.DataBase;

import java.sql.*;

import com.littleheap.Static.Information;
import com.mysql.jdbc.Connection;

public class GetConnection {
	
    public static void main(String[] args){
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        
        String url=Information.JDBC_URL;    //JDBC的URL    
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = (Connection) DriverManager.getConnection(url,Information.username,Information.password);
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.print("成功连接到数据库！");
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
