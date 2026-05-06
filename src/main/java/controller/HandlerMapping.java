package controller;

public class HandlerMapping {

    private  static  HandlerMapping instance = new HandlerMapping();

    private HandlerMapping() {}


    public static HandlerMapping getInstance() {
        if(instance == null)
            instance = new HandlerMapping();
        return instance;
    }

    public Controller createController (int no){
        Controller controller = null;

        switch (no){
            case 1:
                controller = new AppendController();
                break;
            case 2:
                controller = new DeleteController();
                break;


            case 5:
                controller = new PrintAllController();
                break;
        }

        //switch결과 값을 controller안에 넣어서 main에게 보내겠다
        return controller;

    }


}
