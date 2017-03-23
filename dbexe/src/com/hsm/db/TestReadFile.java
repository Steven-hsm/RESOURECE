package com.hsm.db;

import java.io.*;
import java.sql.*;

/**
 * 读取指定文件下sql脚本，执行到数据库
 * 朱行读取分批处理批量插入数据库
 */
public class TestReadFile {
    public static void main(String[] args) {
        System.err.println("begin");
        long start = System.currentTimeMillis();
        String path = "C:\\Users\\huangsm@allinfinance.com\\Desktop\\tm_account.sql";
        getData(path);
        System.err.print((System.currentTimeMillis() - start) / 1000);

    }

    private static void getData(String path) {
        //读取文件
        BufferedReader reader;
        Connection conn = null;
        Statement pst = null;
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            conn = DriverManager.getConnection(
                    "jdbc:db2://10.250.1.229:50000/zyjrdb:currentSchema=CTS;","zyjrusr","zyjrusr");
            System.out.println("数据库连接成功！！！");
            pst = conn.createStatement();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            int i = 0;
            
            while ((line = reader.readLine()) != null) {
            	//主要防止空行问题,个人觉得这样比简单
            	if(line.length()<=10){
            		continue;
            	}
            	if(i==0){
            		//这个执行的时候发现的问题,不知道为什么,用这个测试
            		System.out.println(line);
                	pst.execute(line.substring(1,line.length()-1));
            	}else{
            		System.out.println(line);
            		pst.execute(line.substring(0,line.length()-1));
            	}
                if (i % 100 == 0) {
                    System.out.println("执行了：" + i);
                }
                i += 1;
            }
            reader.close();
            // 执行批量更新
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

