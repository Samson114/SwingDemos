package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.InfoBean;

import dao.BaseConnection;

public class GetConn {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		           // ����������
		           String driver = "com.mysql.jdbc.Driver"; 

		           // URLָ��Ҫ���ʵ����ݿ���scutcs
		           String url = "jdbc:mysql://localhost:3306/bishe";

		           // MySQL����ʱ���û���
		           String user = "root"; 
		  
		           // MySQL����ʱ������
		           String password ="root"; 

		           try { 
		            // ������������
		            Class.forName(driver); 

		            // �������ݿ�
		            Connection conn = DriverManager.getConnection(url, user, password); 

		            if(!conn.isClosed()) 
		             System.out.println("Succeeded connecting to the Database!"); 

		            // statement����ִ��SQL���
		            Statement statement = conn.createStatement();

		            // Ҫִ�е�SQL���
		            String sql = "select * from info";

		            // �����
		            ResultSet rs = statement.executeQuery(sql);

		            System.out.println("-----------------");
		            System.out.println("ִ�н��������ʾ:");
		            System.out.println("-----------------");
		            System.out.println(" ѧ��" + "\t" + " ����");
		            System.out.println("-----------------");

		            String name = null;

		            while(rs.next()) {
		    
		             // ѡ��sname��������
		             name = rs.getString("name");
		    
		             // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
		             // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����

		             // ������
//		             System.out.println(rs.getString("sno") + "\t" + name);
		            }

		            rs.close();
		            conn.close(); 

		           } catch(ClassNotFoundException e) { 


		            System.out.println("Sorry,can`t find the Driver!"); 
		            e.printStackTrace(); 

		           } catch(SQLException e) { 


		            e.printStackTrace(); 


		} 

	}
}