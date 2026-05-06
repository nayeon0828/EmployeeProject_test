package exception;

public class EmployeeException extends Exception{

    //오류 났을때, 메세지만 보내겠다 라는 생성자
    public EmployeeException(String message) {
        super(message);
    }
}
