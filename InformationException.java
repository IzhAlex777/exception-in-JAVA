public class InformationException extends RuntimeException {
public InformationException(String massage){
        super();
        System.out.println(massage);
        }
public InformationException(){

        System.out.println("НЕ все данные введены.");
        }
        }