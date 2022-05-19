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
		
		
		
		
		displayBookMall();
		
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
