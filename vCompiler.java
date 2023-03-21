import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Hashtable;

public class vCompiler {
        // TODO: Semi colon error handling (line 143)
        // TODO: numbers error handling (line 145)
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

            // Hash table to store all unique keywords, Identifiers, Operators, and Symbols
            Hashtable<Integer, String> uniqueKeywordsReference = new Hashtable<>();
            //The code adds all keywords to the hash table object, where the key is an integer and the value is a string.
            // Keywords
            uniqueKeywordsReference.put(0, "BEGIN");
            uniqueKeywordsReference.put(1, "INTEG");
            uniqueKeywordsReference.put(2, "REAL");
            uniqueKeywordsReference.put(3, "INPUT");
            uniqueKeywordsReference.put(4, "WRITE");
            uniqueKeywordsReference.put(5, "END");

            // Identifiers
            uniqueKeywordsReference.put(6, "num");
            uniqueKeywordsReference.put(7, "numm");
            uniqueKeywordsReference.put(8, "nummm");
            uniqueKeywordsReference.put(9, "summation");
            uniqueKeywordsReference.put(10, "multi");
            
            // Identifiers with commas
            uniqueKeywordsReference.put(11, "num,");
            uniqueKeywordsReference.put(12, "numm,");
            uniqueKeywordsReference.put(13, "nummm,");
            uniqueKeywordsReference.put(14, "summation,");
            uniqueKeywordsReference.put(15, "multi,");

            //Operators
            uniqueKeywordsReference.put(16, "+");
            uniqueKeywordsReference.put(17, "/");
            uniqueKeywordsReference.put(18, "*");
            uniqueKeywordsReference.put(19, "-");
            
            // Symbols
            uniqueKeywordsReference.put(20, "=");
            uniqueKeywordsReference.put(21, ";");

            // Set to store unique keywords
            Set<String> uniqueKeywords = new HashSet<>();

            // Loop through each token in the input string
            for (int j = 0; j < splitStr.length; j++) {
                String input = splitStr[j];

                // Check if the current token is a keyword 
                if (input.equals("BEGIN") || input.equals("INTEG") || input.equals("REAL") || input.equals("LET") || input.equals("INPUT") || input.equals("WRITE") || input.equals("END")) {
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
                
                // Error handling 

                // To handle spelling errors or undefined terms
                boolean notvalid = false; // flag to check if input is found
                for(int h = 0; h <= 21; h++){
                    if(input.equals(uniqueKeywordsReference.get(h))){
                        notvalid = true;
                        break; // exit the loop if input is found
                    }
                }
                
                if(!notvalid){

                // Semantic errors
                if(input.equals("%") || input.equals("$") || input.equals("&") || input.equals("<") || input.equals(">") || input.equals(">&") || input.equals("!")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("#" + (j+1) + " SEMANTIC ERROR- symbol entered is not allowed! i.e(%,$,&,<,>$,%,!,;)");
                    }
                }
                else if(input.equals("%,") || input.equals("$,") || input.equals("&,") || input.equals("<,") || input.equals(">,") || input.equals(">&,") || input.equals("!,")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("#" + (j+1) + " SEMANTIC ERROR- symbol entered is not allowed! i.e(%,$,&,<,>$,%,!,;)");
                    }
                }

                    // Handling two operators next each other
                else if(input.equals("+*") || input.equals("-/") || input.equals("*/") || input.equals("*+") || input.equals("/*") || input.equals("*-") || input.equals("-*") || input.equals("+/") || input.equals("/+")) {
                    if (!uniqueKeywords.contains(input)) {
                        uniqueKeywords.add(input);
                        System.out.println("#" + (j+1) + " SYNTAX ERROR- two operators must not be combined! i.e(+*, -/, */, *+ )");
                    }
                }
                    else{
                        System.out.println("#" + (j+1) + " SEMANTIC ERROR- your input is undefined for this language");
                    }

                    //Semi colon error handling

                    //Numbers error handling
                }
            }
        }
    }
}
