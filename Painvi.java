import java.util.Scanner;
import java.util.StringTokenizer;

public class Painvi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

	System.out.println("Enter the number of lines to be entered: ");
        int lines = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= lines; i++) {
            System.out.println("\n" + "Enter String #" + i + ": ");
            /*input.nextLine();*/
            /*String lines = input.nextLine();*/

        String str1 = input.nextLine();
        StringTokenizer stoke = new StringTokenizer(str1, " ");

        int count = 0;
        while (stoke.hasMoreTokens()) {
            String Charac = stoke.nextToken();
            String TOKENA = " Keywords";
            String TOKENB = " Identifier";
            String TOKENC = " Operators";
            String TOKEND = " Symbols";


            switch (Charac) {
                case "BEGIN": 
	        	case "END": 
                case "INTEG": 
                case "REAL": 
                case "INPUT": 
                case "WRITE": 
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENA);
                    break;

                case "num": case "numm": case "nummm": 
                case "summation": case "multi":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENB);
                    break;

                case "+":	case "/":	case "*":	case "-":   
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENC);
                    break; 

                case "=":	case "&":	case ";":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKEND);
                    break;     
            }
        }
            System.out.print("Total number of Tokens: " + count);
        }
    }
}
