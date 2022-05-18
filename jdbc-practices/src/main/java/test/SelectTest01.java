package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTest01 {

	public static void main(String[] args) {
		List<DepartmentVo> result = findAll();
		for(DepartmentVo vo : result) {
			System.out.println(vo);
		}
	}

	private static List<DepartmentVo> findAll() {
		List<DepartmentVo> result = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.10.39:3306/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. Statement 생성
			stmt = connection.createStatement();
			
			// 4. SQL 실행
			String sql = "select no, name from department order by no desc";
			// 여기서는 쿼리문안에 ; 이거 필요없음 => 있으면 오류남
			rs = stmt.executeQuery(sql);
			System.out.println("connected!");
			
			// 5. 결과처리
			while(rs.next()) {
				Long no = rs.getLong(1); // db 1로 시작
				String name = rs.getString(2);
				
				DepartmentVo vo = new DepartmentVo();
				vo.setNo(no);
				vo.setName(name);
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
