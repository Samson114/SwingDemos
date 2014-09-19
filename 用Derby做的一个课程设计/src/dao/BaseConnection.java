package dao;
//�Լ���װ��һ���򵥵�JDBC�����������Ҫ�����ڿ����Լ���д�°�connection��������

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class BaseConnection {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement st;
	private ResultSet rs;
	
	/**
	 * ʹ�þ�̬ģ����ע������
	 */
	static{
		//ע������
		try {
		     Class.forName(getPro().getProperty("driver"));
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	//ȡ������
	private Connection getConn() {
		try {
			this.conn= DriverManager.getConnection(getPro().getProperty("url"),
					getPro().getProperty("user"), getPro()
					.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //ȡ����������
		return this.conn;

	}
	
	 /**
	  * ORMDBUtil�еķ���
    * ���ݴ����SQL��䷵��һ�����������
    */
	/*
	public ArrayList select_msg(String sql) throws Exception {
		ArrayList<Msg_bean> result = new ArrayList<Msg_bean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//��ѯ�Ľ��ת����Jobs����
				
				Msg_bean mb = new Msg_bean();
				
				mb.setId(rs.getInt(1));
				mb.setAdvice(rs.getString(2));
				//��ת���õ��Ķ������ArrayList��
				result.add(mb);
			}
		} catch (SQLException sqle) {
			throw new SQLException("select data exception: "
					+ sqle.getMessage());
		} catch (Exception e) {
			throw new Exception("System e exception: " + e.getMessage());
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				throw new Exception("statement close exception: " + e.getMessage());
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new Exception("statement close exception: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception("connection close exception: " + e.getMessage());
			}		
		}
		return result;
	}
	 *//**
	  * ORMDBUtil�еķ���
     * ���ݴ����SQL��䷵��һ�����������
     *//*
	public ArrayList select(String sql) throws Exception {
		ArrayList<Log_bean> result = new ArrayList<Log_bean>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//��ѯ�Ľ��ת����Jobs����
				
				Log_bean lb = new Log_bean();
				
				lb.setDiary_id(rs.getString("diary_id"));
				lb.setContent(rs.getString("content"));
				lb.setDiary_title(rs.getString("diary_title"));
				lb.setTime(rs.getString("time"));
				//��ת���õ��Ķ������ArrayList��
				result.add(lb);
			}
		} catch (SQLException sqle) {
			throw new SQLException("select data exception: "
					+ sqle.getMessage());
		} catch (Exception e) {
			throw new Exception("System e exception: " + e.getMessage());
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				throw new Exception("statement close exception: " + e.getMessage());
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new Exception("statement close exception: " + e.getMessage());
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception("connection close exception: " + e.getMessage());
			}		
		}
		return result;
	}*/
	/**
	 * prepareStatement ��ѯ
	 * @param param
	 * @param sql
	 * @return
	 */
	public ResultSet queryForObject(final String []param,final String sql){
		
			try {
				this.pstmt = this.getConn().prepareStatement(sql);
				setParamValue(param);
				this.rs = this.pstmt.executeQuery();
			//	this.closeConn(conn, pstmt,null,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return this.rs;
	}
	/**
	 * statement��ѯ
	 * 
	 */
	public ResultSet query(final String sql){
		try {
			this.st = this.getConn().createStatement();
			
			this.rs = this.st.executeQuery(sql);
//			this.closeConn(conn,null, st,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.rs;
		
	}
	//�б��ѯ

	public List<HashMap> queryForObjectList(final String []param,final String sql){
		  List<HashMap> list = new ArrayList<HashMap>();
	      HashMap<String, String> map = null;        
		
			try {
				this.pstmt = this.getConn().prepareStatement(sql);
				setParamValue(param);
				this.rs = this.pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				//rs.get
	            int cols = rsmd.getColumnCount();
	            while (rs.next()) {
	                map = new HashMap<String, String>();
	                // ��ÿ���ֶε�key/value�Ա��浽HashMap��
	                for (int i = 1; i <= cols; i++) {
	                    String field = rsmd.getColumnName(i);
	                    String value = rs.getString(i);
	                    map.put(field, value);
	                }
	                // ����ǰ��¼��ӵ�List��
	                list.add(map);
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return list;
	}
	//��,ɾ,��
	public int operate(final String []param,final String sql){
		int result =0;
	
			try {
				this.pstmt =this.getConn().prepareStatement(sql);
				setParamValue(param);
				result =this.pstmt.executeUpdate();
				this.closeConn(conn, pstmt,null, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return result;
	}
	//sql��䴫��
	public void setParamValue(String []param)throws SQLException{
		if(param !=null){
			for(int i=0;i<param.length; i++){
					this.pstmt.setString(i+1, param[i]);
			}
		}
	}  
	//�ر�����,�ͷ���Դ
		private void closeConn(Connection conn,PreparedStatement pstmt,Statement st,ResultSet rs) throws SQLException{
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	/**
	 * ��ȡ�����ļ�jdbc.properties
	 * @return
	 */
	 public static Properties getPro(){
	   	  InputStream is =BaseConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
	   	  Properties pro = new Properties();
			   	  try {
						pro.load(is);
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
							if(null!=is){
											try {
												is.close();
											} catch (IOException e) {
												e.printStackTrace();
											}
							}
					}	
			return pro;
	     
	}
}

