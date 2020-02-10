package hr;

import java.util.Scanner;

public class HrMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		sc.close();

		EmployeeVo employeeVo = new EmployeeVo();
		employeeVo.setFirstName(name);

		EmployeeDao dao = new EmployeeDao();
		dao.findByName(employeeVo);

	}
}
