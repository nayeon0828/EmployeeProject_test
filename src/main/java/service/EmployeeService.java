package service;

import vo.EmployeeVO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeService {

    private  static EmployeeService instance = new EmployeeService();
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

    public static EmployeeService getInstance(){
        if(instance == null)
            instance = new EmployeeService();
        return instance;
    }



}
