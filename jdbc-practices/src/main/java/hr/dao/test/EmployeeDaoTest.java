package hr.dao.test;

import java.util.List;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class EmployeeDaoTest {

	public static void main(String[] args) {
//		testFindByFirstNameOrLastName("ken");
		testFindBySalary(3000,10000);
	}
	
	private static void testFindBySalary(int i, int j) {
		List<EmployeeVo> list = new EmployeeDao().findBySalary(i,j);
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testFindByFirstNameOrLastName(String name) {
			List<EmployeeVo> list = new EmployeeDao().findByFirstNameOrLastName(name);
			for(EmployeeVo vo : list) {
				System.out.println(vo);
			}
	}

}
