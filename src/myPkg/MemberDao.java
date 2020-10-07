package myPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {

	//Singleton 방법
	private static MemberDao dao = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private MemberDao() {
		try { 
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	} 
	
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		
		return dao;
		
	} //getInstance

	public void insertData(String id, String passwd, String name) {
		
		String sql = "insert into member(num, id, passwd, name, register) values(m_seq.nextval,?,?,?,default)";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				
			}
		}
		
	} //insertData
	
	public ArrayList<MemberBean> getSelectAll() {
		
		String sql = "select * from member order by num asc";
		
		MemberBean mb = null;
		ArrayList<MemberBean> lists = new ArrayList<MemberBean>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String register = String.valueOf(rs.getDate("register")); //날짜만 가져옴
				// String register = rs.getString("register"); 날짜, 시간 둘 다 나옴
							
				mb = new MemberBean(num, id, passwd, name, register);
				
				lists.add(mb);
			}
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				
			}
		}	
		return lists;
	} //getSelectAll

	public void deleteData(int num) {

		String sql = "delete from member where num=?";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				
			}
		}
		
	} //deleteData

	public MemberBean oneSelect(String num) {
		
		String sql = "select * from member where num=?";
		MemberBean mb = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(num));
			
			rs= ps.executeQuery();
					
			if(rs.next()) {
				int num2 = rs.getInt("num");
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String register = String.valueOf(rs.getDate("register")); //날짜만 가져옴
				// String register = rs.getString("register"); 날짜, 시간 둘 다 나옴
							
				mb = new MemberBean(num2, id, passwd, name, register);
			}
		} catch (SQLException e) {
			
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				
			}
		}	
		return mb;
	} //oneSelect

	public void updateData(String num, String id, String passwd, String name) {

		String sql = "update member set id=?,passwd=?,name=? where num = ?";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			ps.setInt(4, Integer.parseInt(num));
		
			ps.executeUpdate();
		} catch (SQLException e) {
			
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				
			} 
		}
		
	} //updateData
	
	
	
}
