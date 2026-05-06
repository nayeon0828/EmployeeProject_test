package controller;

import exception.EmployeeException;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.Scanner;

public class AppendController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 추가합니다.");
        System.out.print("등록할 사원 번호 : ");
        String id = sc.nextLine();

        //중복체크
        try {
            EmployeeService.getInstance().checkDuplicatEmployeeId(id);
            System.out.print("등록할 사원명 : ");
            String name = sc.nextLine();
            System.out.print("등록할 직급 : ");
            String postion = sc.nextLine();
            System.out.print("등록할 급여 : ");
            int salary = sc.nextInt(); sc.nextLine();
            System.out.print("등록할 입사일 : ");
            String hireDate = sc.nextLine();

            boolean flag = EmployeeService.getInstance().appendEmployee(
                    new EmployeeVO(id, name, postion, salary,hireDate));

            System.out.println(flag ? "사원 정보 등록 성공" : "사원 정보 등록 실패");

        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }


    }
}
