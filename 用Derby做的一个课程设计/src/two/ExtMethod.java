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
//		数据库连接区
		   ArrayList<InfoBean> infoList = new ArrayList<InfoBean>();
           
		// 驱动程序名
           String driver = "com.mysql.jdbc.Driver"; 
           // URL指向要访问的数据库名scutcs
           String url = "jdbc:mysql://localhost:3306/bishe";
           // MySQL配置时的用户名
           String user = "root"; 
           // MySQL配置时的密码
           String password ="root"; 
           try { 
            // 加载驱动程序
            Class.forName(driver); 
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password); 

            if(!conn.isClosed()) {
//             System.out.println("Succeeded connecting to the Database!"); 
             }
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from info";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
             // 选择sname这列数据
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
             // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
             // 然后使用GB2312字符集解码指定的字节数组
             // 输出结果
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
		
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver"; 
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://localhost:3306/bishe";
        // MySQL配置时的用户名
        String user = "root"; 
        // MySQL配置时的密码
        String password ="root"; 
        
        String old_score=null;
        int now_score=0;
        try { 
         // 加载驱动程序
         Class.forName(driver); 
         // 连续数据库
         Connection conn = DriverManager.getConnection(url, user, password); 

         if(!conn.isClosed()) {
//          System.out.println("Succeeded connecting to the Database!"); 
          }
         // statement用来执行SQL语句
         Statement statement = conn.createStatement();
         // 要执行的SQL语句
         String sel_sql ="select score from info where num='"+str+"'";
         // 结果集
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
         }else if(operate.equals("病假")){
        	 now_score=now_score-3;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -3"); 
         }else if(operate.equals("事假")){
        	 now_score=now_score-5;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -5"); 
         }else if(operate.equals("迟到")){
        	 now_score=now_score-10;
        	 if(now_score<=0){
        		 now_score=0;
        	 }
        	 
        	 System.out.println("database--  -10"); 
         }else if(operate.equals("早退")){
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
		
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver"; 
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://localhost:3306/bishe";
        // MySQL配置时的用户名
        String user = "root"; 
        // MySQL配置时的密码
        String password ="root"; 
        
        String old_acount=null;
        int now_acount=0;
        try { 
         // 加载驱动程序
         Class.forName(driver); 
         // 连续数据库
         Connection conn = DriverManager.getConnection(url, user, password); 

         if(!conn.isClosed()) {
//          System.out.println("Succeeded connecting to the Database!"); 
          }
         // statement用来执行SQL语句
         Statement statement = conn.createStatement();
         // 要执行的SQL语句
         String sel_sql ="select acount from info where num='"+str+"'";
         // 结果集
         ResultSet sel_rs = statement.executeQuery(sel_sql);
         while(sel_rs.next()) {
        	 old_acount=sel_rs.getString("acount");
            }
         now_acount=Integer.parseInt(old_acount);
         if(operate.equals("旷课")){
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
//	数据库连接区
	   ArrayList<InfoBean> infoList = new ArrayList<InfoBean>();
       
	// 驱动程序名
       String driver = "com.mysql.jdbc.Driver"; 
       // URL指向要访问的数据库名scutcs
       String url = "jdbc:mysql://localhost:3306/bishe";
       // MySQL配置时的用户名
       String user = "root"; 
       // MySQL配置时的密码
       String password ="root"; 
       try { 
        // 加载驱动程序
        Class.forName(driver); 
        // 连续数据库
        Connection conn = DriverManager.getConnection(url, user, password); 

        if(!conn.isClosed()) {
//         System.out.println("Succeeded connecting to the Database!"); 
         }
        // statement用来执行SQL语句
        Statement statement = conn.createStatement();
        // 要执行的SQL语句
        String sql = "select * from info where grade='"+grade+"'";
        // 结果集
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
         // 选择sname这列数据
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
         // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
         // 然后使用GB2312字符集解码指定的字节数组
         // 输出结果
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
