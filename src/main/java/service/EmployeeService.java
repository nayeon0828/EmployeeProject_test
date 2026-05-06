package service;

import exception.EmployeeException;
import vo.EmployeeVO;

import java.io.*;
import java.util.ArrayList;

public class EmployeeService {

    private  static EmployeeService instance = new EmployeeService();

    public static EmployeeService getInstance(){
        if(instance == null)
            instance = new EmployeeService();
        return instance;
    }

    private ArrayList<EmployeeVO> list;
    
    
    private EmployeeService() {
        //EmployeeVO를 삽입하지 않아도 됨
        list = new ArrayList<>();
        //1. 파일 로드해서 리스트에 초기화
        LoadToCSV();


    }

    public  ArrayList<EmployeeVO> getList (){
        return list;
    }

    //시작전 파일 읽어들이기 메서드
    private void  LoadToCSV(){
        try(FileReader fr = new FileReader("employee.csv");
            BufferedReader br = new BufferedReader(fr);
        ){
            br.readLine(); //필드 목록 출력 건너뛰기
            while (true){
                String str = br.readLine();
                if(str == null) break;
//                System.out.println(str);

                //,쉼표 기준으로 다 잘라서 배열 안에 넣기
                String[] arr = str.split(",");
                // 3번째 급여는 int 정수형이기에 배열은 문자열이므로, 문자열로 바꿔줌
                list.add(new EmployeeVO(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]),arr[4]));
            }

            //파일 로드 완료
            System.out.println("사원 정보 로드 완료");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /********** 중복체크 ***********/
    public void checkDuplicatEmployeeId(String id) throws EmployeeException{

        int idx = list.indexOf(new EmployeeVO(id,null,null,0,null));

        //중복되면 0이상 나옴
        if(idx != -1)
            throw  new EmployeeException("사원번호가 중복되었습니다.");


    }

    public boolean appendEmployee(EmployeeVO employeeVO) {
        return list.add(employeeVO);

    }


    /************파일 정보 csv로 내보내기**************/
    public void exportTocsv(){
        try(FileWriter fw = new FileWriter("employee.csv");
            PrintWriter pw = new PrintWriter(fw);

        ){
            list.forEach(item -> pw.println(item));
            System.out.println("전체 사원 정보 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
