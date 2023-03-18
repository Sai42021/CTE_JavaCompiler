import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class vCompiler {
        // TODO: Error handling
        // TODO: Intermediate code representation
        // TODO: Code Optimization
        // TODO: Code Generation
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);

        System.out.println("Enter number of strings: ");
        int strNums = In.nextInt();
        In.nextLine();

        // Strings loop
        for (int i = 1; i <= strNums; i++) {
            System.out.println("\n" + "Enter string #" + i + ":");
            String str = In.nextLine();

            // Split String based on white spaces 
            String[] splitStr = str.split("\\s+");

            // Set to store unique keywords
            Set<String> uniqueKeywords = new HashSet<>();

            // Loop through each token in the input string
            for (int j = 0; j < splitStr.length; j++) {
                String input = splitStr[j];

                // Check if the current token is a keyword 
                if (input.equals("BEGIN") || input.equals("INTEG") || input.equals("LET") || input.equals("INPUT") || input.equals("WRITE") || input.equals("END")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("TOKEN#" + (j+1) + " Keyword");
                    }
                }
                // Check if the current token is an identifier 
                else if(input.equals("num") || input.equals("numm") || input.equals("nummm") || input.equals("summation") || input.equals("multi") || input.equals("temp")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("TOKEN#" + (j+1) + " Identifier");
                    }
                }
                // Check if the current token is an identifier with a comma after it
                else if(input.equals("num,") || input.equals("numm,") || input.equals("nummm,") || input.equals("summation,") || input.equals("multi,") || input.equals("temp,")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("TOKEN#" + (j+1) + " Identifier");
                    }
                }
                // Check if the current token is an operator
                else if(input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*")){
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("TOKEN#" + (j+1) + " Operator");
                    }
                }
                 // Check if the current token is a Symbol
                 else if(input.equals("=") || input.equals(";")){
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("TOKEN#" + (j+1) + " Symbol");
                    }
                }
            }
        }
    }
}
