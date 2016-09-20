import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator {
    interface IntegerMath {
        int operation(int a, int b);  
    }
 
    public int operateBinary(int a, int b, IntegerMath op) {
        return op .operation(a, b);
    }
 
    public static void main(String... args) {
   
        Calculator myApp = new Calculator();
        IntegerMath addition = ( a, b) -> a + b;
        IntegerMath muti = (a ,b ) -> a *b ;
        IntegerMath div = new IntegerMath(){
             @Override
             public int operation(int a, int b) {
                 return a /b ;
            }
        };
        IntegerMath subtraction = (a , b ) -> a - b;
        System. out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System. out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));
       
        System. out.println("class of addition :" + addition.getClass().getName() + " obj:" + addition);
        System. out.println("class of div :" + div.getClass().getName() + " obj:" + div );
    }
}