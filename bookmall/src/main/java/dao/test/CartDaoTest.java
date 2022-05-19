package dao.test;

import java.util.List;
import java.util.Scanner;

import dao.CartDao;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindByCart();
	}

	private static void testInsert() {
		CartDao dao = new CartDao();
//		CartVo vo = new CartVo();
		
//		vo.setCount(2);
//		vo.setBookNo(1L);
//		vo.setMemberNo(1L);
		dao.insert(2,1L,1L);
		
//		vo.setCount(1);
//		vo.setBookNo(2L);
//		vo.setMemberNo(1L);
		dao.insert(1,2L,1L);
		
	}
	
	private static void testFindByCart() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름>>");
		String name = scanner.nextLine();
		scanner.close();
		List<CartVo> list = new CartDao().findByCart(name);
		for(CartVo vo:list) {
			System.out.println(vo);
		}
	}

}
