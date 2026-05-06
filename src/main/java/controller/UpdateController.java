package controller;

import exception.EmployeeException;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.Scanner;

public class UpdateController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 수정을 시작합니다.");
        System.out.print("수정할 사원 번호 : ");
        String id = sc.nextLine();

        //수정할 사원 정보를 가져옴
        try {
            EmployeeVO vo =  EmployeeService.getInstance().searchEmployee(id);
            System.out.print("등록할 사원명 : ");
            vo.setName(sc.nextLine());
            System.out.print("등록할 직급 : ");
            vo.setPostion(sc.nextLine());

            System.out.print("등록할 급여 : ");
            vo.setSalary(sc.nextInt()); sc.nextLine();

            System.out.print("등록할 입사일 : ");
            vo.setHireDate(sc.nextLine());

            System.out.println("사원 정보 수정 성공");

        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
            System.out.println("사원 정보 수정 실패");
        }
    }
}
