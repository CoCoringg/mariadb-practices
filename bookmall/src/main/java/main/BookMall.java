package main;

import java.util.List;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		
		// 데이터 입력
		insertData();
		// 데이터 출력
		displayBookMall();
		
	}

	private static void insertData() {
		CategoryDao catDao = new CategoryDao();
		catDao.insert("과학");
		catDao.insert("IT");
		catDao.insert("문학");
		
		BookDao bookDao = new BookDao();
		bookDao.insert("왼손잡이 우주", 18000, 1L);
		bookDao.insert("Must Have 머신러닝·딥러닝 문제해결 전략", 38000, 2L);
		bookDao.insert("호밀밭의 파수꾼", 8000, 3L);
		
		MemberDao memDao = new MemberDao();
		memDao.insert("둘리", "010-1234-5678", "dooly@gmail.com", "1234");
		memDao.insert("마이콜", "010-9999-9999", "michol@gmail.com ", "1234");
		
		CartDao cartDao = new CartDao();
		cartDao.insert(2,1L,1L);
		cartDao.insert(1,2L,1L);
		
		OrderDao orderDao = new OrderDao();
		orderDao.insert("20220519-001","부산 센텀시티",74000,1L);
		orderDao.orderBookInsert(2,1L,1L);
		orderDao.orderBookInsert(1,2L,1L);
	}

	private static void displayBookMall() {
		
		List<MemberVo> memberList = new MemberDao().findAll();
		for (MemberVo vo : memberList) {
			System.out.println(vo.getName()+" "+vo.getEmail());
		}
		System.out.println("=====================================");
		
		List<CategoryVo> categoryList  = new CategoryDao().findAll();
		for (CategoryVo vo : categoryList) {
			System.out.println(vo.getNo()+" "+vo.getSort());
		}
		System.out.println("=====================================");
		
		List<BookVo> bookList  = new BookDao().findAll();
		for (BookVo vo : bookList) {
			System.out.println(vo.getNo()+" "+vo.getTitle()+" "+vo.getPrice()+" "+vo.getCategoryName());
		}
		System.out.println("=====================================");
		
		List<CartVo> cartList  = new CartDao().findByCart("둘리");
		for (CartVo vo : cartList) {
			System.out.println(vo.getMemberName()+" "+vo.getBookTitle()+" "+vo.getCount());
		}
		System.out.println("=====================================");
		
		List<OrderVo> orderList  = new OrderDao().findAll();
		for (OrderVo vo : orderList) {
			System.out.println(vo.getOrderNum());
			System.out.println(vo.getName()+"("+vo.getEmail()+")");
			System.out.println(vo.getTotalPrice());
			System.out.println(vo.getAddr());
		}
		System.out.println("=====================================");
		
		List<OrderVo> orderBookList  = new OrderDao().orderBookFindAll();
		for (OrderVo vo : orderBookList) {
			System.out.println(vo.getNo()+" "+vo.getTitle()+" "+vo.getCount()+" "+vo.getPrice());
		}
	}

}
