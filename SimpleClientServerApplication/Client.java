

package SimpleClientServerApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Lauro Ribeiro
 */
public class Client {
    public static void main(String[] args) throws Exception{
        
        System.out.println("Client Started");
        
        Socket soc = new Socket("localhost",9800);
        
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
    
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
    
        int option = 0;
        int num1 = 0;
        int num2 = 0;
        
        do{
            System.out.println("Choose an Operation: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.println("Enter an Option: ");
            option= Integer.parseInt(userInput.readLine());
            
            if(option !=5){
                System.out.println("Enter first number");
                num1 = Integer.parseInt(userInput.readLine());
            
                System.out.println("Enter second number");
                num2 = Integer.parseInt(userInput.readLine());
            
                out.println(option+":"+num1+":"+num2);
            }else{
                out.println(option+":0:0");
                break;
            }
            
            
            String answer = in.readLine();
            System.out.println("Server says: "+ answer);
            System.out.println("");
        }while(true);
        
        System.out.println("Client Terminated");
    }
}
