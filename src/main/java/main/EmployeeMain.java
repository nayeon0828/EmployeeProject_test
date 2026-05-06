package main;

import controller.Controller;
import controller.HandlerMapping;
import service.EmployeeService;

import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{

        while (true){

            System.out.println("-- 사원 관리 프로그램 --");
            System.out.println("1. 사원 정보 등록");
            System.out.println("2. 사원 정보 삭제");
            System.out.println("3. 사원 정보 수정");
            System.out.println("4. 사원 정보 검색 (이름)");
            System.out.println("5. 전체 사원 조회");
            System.out.println("0. 프로그램 종료");
            System.out.print("원하시는 번호 입력 :");
            int no = sc.nextInt();
            sc.nextLine();

            Controller controller = HandlerMapping.getInstance().createController(no);


            if(controller != null)
                controller.execute(sc);

            if(no == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }


        }finally {
            EmployeeService.getInstance().exportTocsv();
        }


    }
}
