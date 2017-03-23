package com.hsm.db;

import java.io.*;
import java.sql.*;

/**
 * ��ȡָ���ļ���sql�ű���ִ�е����ݿ�
 * ���ж�ȡ�������������������ݿ�
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
        //��ȡ�ļ�
        BufferedReader reader;
        Connection conn = null;
        Statement pst = null;
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            conn = DriverManager.getConnection(
                    "jdbc:db2://10.250.1.229:50000/zyjrdb:currentSchema=CTS;","zyjrusr","zyjrusr");
            System.out.println("���ݿ����ӳɹ�������");
            pst = conn.createStatement();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            int i = 0;
            
            while ((line = reader.readLine()) != null) {
            	//��Ҫ��ֹ��������,���˾��������ȼ�
            	if(line.length()<=10){
            		continue;
            	}
            	if(i==0){
            		//���ִ�е�ʱ���ֵ�����,��֪��Ϊʲô,���������
            		System.out.println(line);
                	pst.execute(line.substring(1,line.length()-1));
            	}else{
            		System.out.println(line);
            		pst.execute(line.substring(0,line.length()-1));
            	}
                if (i % 100 == 0) {
                    System.out.println("ִ���ˣ�" + i);
                }
                i += 1;
            }
            reader.close();
            // ִ����������
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

