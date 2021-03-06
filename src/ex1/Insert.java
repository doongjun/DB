package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO MEMBER(ID, AGE, NAME, regdate)" + "values (?,?,?,SYSDATE)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"dongjun","skrduqrlf56");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,"11");
			pstmt.setString(2, "45");
			pstmt.setString(3, "정준하");
			
			int cnt = pstmt.executeUpdate(); //excuteUpdate(); create insert update delete
											 //excuteQuery(); select
			
			System.out.println("삽입된 행"+cnt);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				pstmt.close();
				con.close();
				System.out.println("삽입 완료");
			}catch(Exception e2) {}
			
		}
	}

}
