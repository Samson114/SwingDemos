package two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.InfoBean;

public class ExtMethod {

	
	public ArrayList getConn(){
//		���ݿ�������
		   ArrayList<InfoBean> infoList = new ArrayList<InfoBean>();
           
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

            if(!conn.isClosed()) {
//             System.out.println("Succeeded connecting to the Database!"); 
             }
            // statement����ִ��SQL���
            Statement statement = conn.createStatement();
            // Ҫִ�е�SQL���
            String sql = "select * from info";
            // �����
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
             // ѡ��sname��������
            	InfoBean info=new InfoBean();
             info.setName(rs.getString("name"));
//             System.out.println("database--name="+rs.getString("name"));
             
             info.setNum(rs.getString("num"));
             info.setAcademic(rs.getString("academic"));
             info.setAcount(Integer.parseInt(rs.getString("acount")));
             info.setImage_path(rs.getString("image_path"));
             info.setOne_score(Integer.parseInt(rs.getString("one_score")));
             info.setTwo_score(Integer.parseInt(rs.getString("two_score")));
             info.setThree_score(Integer.parseInt(rs.getString("three_score")));
             info.setFour_score(Integer.parseInt(rs.getString("four_score")));
             info.setAvg_score(Integer.parseInt(rs.getString("avg_score")));
             info.setScore(Integer.parseInt(rs.getString("score")));
             infoList.add(info);
             // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
             // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
             // ������
//             System.out.println("database--infoList="+infoList.toString());
            }
            
            rs.close();
            conn.close(); 
           } catch(ClassNotFoundException e) { 
            System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace(); 
           } catch(SQLException e) { 
            e.printStackTrace(); 
           } 
           return infoList;
	}
	
	public int operate(String str,String operate){
		
		// ����������
        String driver = "com.mysql.jdbc.Driver"; 
        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://localhost:3306/bishe";
        // MySQL����ʱ���û���
        String user = "root"; 
        // MySQL����ʱ������
        String password ="root"; 
        
        String old_score=null;
        int now_score=0;
        try { 
         // ������������
         Class.forName(driver); 
         // �������ݿ�
         Connection conn = DriverManager.getConnection(url, user, password); 

         if(!conn.isClosed()) {
//          System.out.println("Succeeded connecting to the Database!"); 
          }
         // statement����ִ��SQL���
         Statement statement = conn.createStatement();
         // Ҫִ�е�SQL���
         String sel_sql ="select score from info where num='"+str+"'";
         // �����
         ResultSet sel_rs = statement.executeQuery(sel_sql);
         while(sel_rs.next()) {
        	 old_score=sel_rs.getString("score");
            }
         now_score=Integer.parseInt(old_score);
         if(operate.equals("+3")){
        	 now_score=now_score+3;
        	 if(now_score>=100){
        		 now_score=100;
        	 }
         }else if(operate.equals("+5")){
        	 now_score=now_score+5;
        	 if(now_score>=100){
        		 now_score=100;
        	 }
        	 System.out.println("database--  +5"); 
         }else if(operate.equals("+10")){
        	 now_score=now_score+10;
        	 if(now_score>=100){
        		 now_score=100;
        	 }
        	 System.out.println("database--  +10"); 
         }else if(operate.equals("����")){
        	 now_score=now_score-3;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -3"); 
         }else if(operate.equals("�¼�")){
        	 now_score=now_score-5;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -5"); 
         }else if(operate.equals("�ٵ�")){
        	 now_score=now_score-10;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -10"); 
         }else if(operate.equals("����")){
        	 now_score=now_score-10;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -10"); 
         }
         
         
         String sql = "update info set score="+now_score+" where num='"+str+"' ";
         statement.executeUpdate(sql);
         
         sel_rs.close();
         conn.close(); 
        } catch(ClassNotFoundException e) { 
         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace(); 
        } catch(SQLException e) { 
         e.printStackTrace(); 
        } 
		return now_score;
	}
	public int operate_acount(String str,String operate){
		
		// ����������
        String driver = "com.mysql.jdbc.Driver"; 
        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://localhost:3306/bishe";
        // MySQL����ʱ���û���
        String user = "root"; 
        // MySQL����ʱ������
        String password ="root"; 
        
        String old_acount=null;
        int now_acount=0;
        try { 
         // ������������
         Class.forName(driver); 
         // �������ݿ�
         Connection conn = DriverManager.getConnection(url, user, password); 

         if(!conn.isClosed()) {
//          System.out.println("Succeeded connecting to the Database!"); 
          }
         // statement����ִ��SQL���
         Statement statement = conn.createStatement();
         // Ҫִ�е�SQL���
         String sel_sql ="select acount from info where num='"+str+"'";
         // �����
         ResultSet sel_rs = statement.executeQuery(sel_sql);
         while(sel_rs.next()) {
        	 old_acount=sel_rs.getString("acount");
            }
         now_acount=Integer.parseInt(old_acount);
         if(operate.equals("����")){
        	 now_acount=now_acount+1; 
//        	 if(now_acount>=3){
//        		 now_acount=3;
//        	 }
         }
         
         
         String sql = "update info set acount="+now_acount+" where num='"+str+"' ";
         statement.executeUpdate(sql);
         
         sel_rs.close();
         conn.close(); 
        } catch(ClassNotFoundException e) { 
         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace(); 
        } catch(SQLException e) { 
         e.printStackTrace(); 
        } 
		return now_acount;
	}
public ArrayList getGradeConn(String grade){
//	���ݿ�������
	   ArrayList<InfoBean> infoList = new ArrayList<InfoBean>();
       
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

        if(!conn.isClosed()) {
//         System.out.println("Succeeded connecting to the Database!"); 
         }
        // statement����ִ��SQL���
        Statement statement = conn.createStatement();
        // Ҫִ�е�SQL���
        String sql = "select * from info where grade='"+grade+"'";
        // �����
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
         // ѡ��sname��������
        	InfoBean info=new InfoBean();
         info.setName(rs.getString("name"));
//         System.out.println("database--name="+rs.getString("name"));
         
         info.setNum(rs.getString("num"));
         info.setAcademic(rs.getString("academic"));
         info.setAcount(Integer.parseInt(rs.getString("acount")));
         info.setImage_path(rs.getString("image_path"));
         info.setOne_score(Integer.parseInt(rs.getString("one_score")));
         info.setTwo_score(Integer.parseInt(rs.getString("two_score")));
         info.setThree_score(Integer.parseInt(rs.getString("three_score")));
         info.setFour_score(Integer.parseInt(rs.getString("four_score")));
         info.setAvg_score(Integer.parseInt(rs.getString("avg_score")));
         info.setScore(Integer.parseInt(rs.getString("score")));
         info.setVoice(rs.getString("voice"));
         infoList.add(info);
         // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
         // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
         // ������
//         System.out.println("database--infoList="+infoList.toString());
        }
        
        rs.close();
        conn.close(); 
       } catch(ClassNotFoundException e) { 
        System.out.println("Sorry,can`t find the Driver!"); 
        e.printStackTrace(); 
       } catch(SQLException e) { 
        e.printStackTrace(); 
       } 
       return infoList;
}
}
