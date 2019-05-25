package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import assets.DBConnectionMgr;

public class LoginTest {
	public static void main(String[] args) {
		boolean test = loginTest("test", "1234");
		System.out.println("로그인 결과 : "+ test);
	}
	
	public static boolean loginTest(String id, String password) {
		boolean flag = false;
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		String getPass = null;
		
		try {
			
			con = pool.getConnection();
			sql = "select password from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				getPass = rs.getString("password");
				if(getPass.equals(password)) {
					flag = true;
				}else {
					flag = false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, ps, rs);
		}
		
		return flag;
	}
}
