package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CartVo;

public class CartDao {
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mysql://192.168.10.39:3306/bookmall?charset=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+ e);
		}
		return connection;
	}
	
	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into cart values (null, ?, ?, ?)"; 
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getCount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getMemberNo());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
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
	
	public List<CartVo> findByCart(String name) {
		List<CartVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select c.no, b.name, a.title, c.count\r\n"
					+ "	from book a, member b, cart c\r\n"
					+ "where a.no = c.book_no\r\n"
					+ "	and b.no = c.member_no\r\n"
					+ "    and b.name = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1);
				String memberName = rs.getString(2); // db 1로 시작
				String title = rs.getString(3);
				int count = rs.getInt(4);
				
				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setMemberName(memberName);
				vo.setBookTitle(title);
				vo.setCount(count);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
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
