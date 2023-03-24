import java.util.*;
import java.util.regex.Pattern;

public class vCompiler {
        // TODO: Semi colon error handling (line 114)
        // TODO: numbers error handling (line 116)
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

            // tokenize string
            StringTokenizer tokenizer = new StringTokenizer(str, "+-*/,; ", true);

            // Split String based on white spaces 
            //String[] splitStr = str.split("\\s+");

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
            
            //Operators
            uniqueKeywordsReference.put(11, "+");
            uniqueKeywordsReference.put(12, "/");
            uniqueKeywordsReference.put(13, "*");
            uniqueKeywordsReference.put(14, "-");
            
            // Symbols
           uniqueKeywordsReference.put(15, "=");
            
            // token count
            int count = 0;

            // to keep track of previous token
            String prevToken = null;

            // compare each token 
            while(tokenizer.hasMoreTokens()){
                 // initialize token string
                String input = tokenizer.nextToken();

              // Check if the current token is a keyword 
                if (input.equals("BEGIN") || input.equals("INTEG") || input.equals("REAL") || input.equals("LET") || input.equals("INPUT") || input.equals("WRITE") || input.equals("END")) {
                    if (uniqueKeywordsReference.contains(input)) {
                        System.out.println("TOKEN#" + ++count + " Keyword");
                    }
                }
                // Check if the current token is an identifier 
                else if(input.equals("num") || input.equals("numm") || input.equals("nummm") || input.equals("summation") || input.equals("multi") || input.equals("temp")) {
                    if (uniqueKeywordsReference.contains(input)) {
                        System.out.println("TOKEN#" + ++count + " Identifier");
                    }
                }
                // Check if the current token is an operator
                else if(input.matches("[+\\-/\\*]")){
                    if (uniqueKeywordsReference.contains(input)) {
                        if(prevToken != null && prevToken.matches("[+\\-/\\*]")){// checks if two operators were entered after each other
                            System.out.println("#" + ++count + " SYNTAX ERROR- two operators (*,-,+,/) cannot be written together!");
                        } else{
                            System.out.println("TOKEN#" + ++count + " Operator");
                        }
                    }
                }
                 // Check if the current token is a Symbol
                 else if(input.equals("=")){
                    if (uniqueKeywordsReference.contains(input)) {
                        System.out.println("TOKEN#" + ++count + " Symbol");
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
                // Special characters error
                if(Pattern.matches("[\\p{P}\\p{S}]", input)) {
                    System.out.println("#" + (++count) + " SEMANTIC ERROR- symbol entered is not allowed! i.e(%,$,&,<,>$,%,!,;)");
                }

                // Semi colon error handling

                // Numbers error handling
                else if(input.equals("[0-9]")){
                    System.out.println("#" + ++count + " SYNTAX ERROR- numbers are not allowed in this language");
                }    

                }

                // to initialize prevoius token disregarding white space
                if (!input.matches("\\s+")) {
                    // Only update prevToken if the current token is not whitespace
                    prevToken = input;
                }
            }
              
            }
        }
    }