package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		// url(jdbc url)
		// jdbc:protocol �̸�. mysql : db�̸�, 127.0.0.1:db server, 3306:port, scott:db�̸�
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC";
//		String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";
		String user = "scott";
		String pass = "tiger";

		Connection con;
		Statement stat;
		String q = "select * from customer order by num";

		try {
			// 1. DriverMananger �� driver ���
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection ����
			con = DriverManager.getConnection(url, user, pass);

			// 3. Statement ����
			stat = con.createStatement();

			// 4. Query ����
			ResultSet rs = stat.executeQuery(q);

			// 5. db���� �� ��� ó��
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				System.out.println(num + "--" + name + "--" + address);
			}
			
			// 6. ������
			stat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}
}