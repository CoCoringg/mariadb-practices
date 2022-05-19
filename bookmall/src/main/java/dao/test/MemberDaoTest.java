package dao.test;

import java.util.List;

import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// testInsert();
		testFindAll();
	}
	
	private static void testInsert() {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setName("둘리");
		vo.setPhone("010-1234-5678");
		vo.setEmail("dooly@gmail.com");
		vo.setPwd("1234");
		dao.insert(vo);
		
		vo.setName("마이콜");
		vo.setPhone("010-9999-9999");
		vo.setEmail("michol@gmail.com ");
		vo.setPwd("1234");
		dao.insert(vo);	
	}
	
	private static void testFindAll() {
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
