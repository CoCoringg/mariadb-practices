package dao.test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		 testInsert();
		testFindAll();
	}

	private static void testInsert() {
		BookDao dao = new BookDao();
		
		dao.insert("왼손잡이 우주", 18000, 1L);
		
		dao.insert("Must Have 머신러닝·딥러닝 문제해결 전략", 38000, 2L);
		
		dao.insert("호밀밭의 파수꾼", 8000, 3L);
	}

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
