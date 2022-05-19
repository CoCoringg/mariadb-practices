package dao.test;

import dao.CategoryDao;

public class CategoryDaoTest {

	public static void main(String[] args) {
		testInsert();
	}

	private static void testInsert() {
		CategoryDao dao = new CategoryDao();
		
		dao.insert("과학");
		
		dao.insert("IT");
		
		dao.insert("문학");
		
	}

}
