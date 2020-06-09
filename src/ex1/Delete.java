package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String user = "dongjun";
		String pw = "skrduqrlf56";
		
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pw);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "8");
			
			int cnt = pstmt.executeUpdate();
			System.out.println("삭제된 셀"+cnt);
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
			pstmt.close();
			con.close();
			System.out.println("삭제 완료");
			}
		catch(Exception e2) {}
		}
	}

}
