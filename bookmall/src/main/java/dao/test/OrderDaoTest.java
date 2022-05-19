package dao.test;

import java.util.List;

import dao.OrderDao;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		testInsert();
		testOrderBookInsert();
		testFindOrders();
		testFindOrderBook();
	}
	
	private static void testFindOrderBook() {
		List<OrderVo> list = new OrderDao().orderBookFindAll();
		for(OrderVo vo:list) {
			System.out.println(vo);
		}
	}

	private static void testFindOrders() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo:list) {
			System.out.println(vo);
		}
	}

	private static void testOrderBookInsert() {
		OrderDao dao = new OrderDao();
//		OrderVo vo = new OrderVo();
		
//		vo.setCount(2);
//		vo.setBookNo(1L);
//		vo.setOrderNo(1L);
		dao.orderBookInsert(2,1L,1L);
		
//		vo.setCount(1);
//		vo.setBookNo(2L);
//		vo.setOrderNo(1L);
		dao.orderBookInsert(1,2L,1L);
		
	}

	private static void testInsert() {
		OrderDao dao = new OrderDao();
//		OrderVo vo = new OrderVo();
		
//		vo.setOrderNum("20220519-001");
//		vo.setAddr("부산 센텀시티");
//		vo.setTotalPrice(74000);
//		vo.setMemberNo(1L);
		dao.insert("20220519-001","부산 센텀시티",74000,1L);
		
		
	}

}
