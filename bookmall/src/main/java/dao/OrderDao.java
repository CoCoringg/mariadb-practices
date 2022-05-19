package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderVo;

public class OrderDao {
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
	
	public boolean insert(String orderNum, String addr, int totalPrice, Long memberNo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into orders values (null, ?, ?, ?, ?)"; 
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, orderNum);
			pstmt.setString(2, addr);
			pstmt.setInt(3, totalPrice);
			pstmt.setLong(4, memberNo);
			
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
	
	public boolean orderBookInsert(int count, Long bookNo, Long orderNo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into order_book values (null, ?, ?, ?)"; 
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setLong(2, bookNo);
			pstmt.setLong(3, orderNo);
			
			int Count = pstmt.executeUpdate();
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
	
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select distinct a.order_num, b.name, b.email, a.total_price, a.addr\r\n"
					+ "	from orders a, member b, order_book c\r\n"
					+ "where a.member_no = b.no\r\n"
					+ "	and a.no = c.orders_no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String orderNum = rs.getString(1); // db 1로 시작
				String name = rs.getString(2);
				String email = rs.getString(3);
				int totalPrice = rs.getInt(4);
				String addr = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setOrderNum(orderNum);
				vo.setName(name);
				vo.setEmail(email);
				vo.setTotalPrice(totalPrice);
				vo.setAddr(addr);
				
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
	
	public List<OrderVo> orderBookFindAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select a.no, b.title, a.count, b.price\r\n"
					+ "	from order_book a, book b\r\n"
					+ "where a.book_no = b.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				int price = rs.getInt(4);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(price);
				
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
