import java.util.*;
import java.util.regex.Pattern;

public class vCompiler {
        // TODO: numbers error handling 
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
            uniqueKeywordsReference.put(1, "LET");
            uniqueKeywordsReference.put(2, "INTEG");
            uniqueKeywordsReference.put(3, "REAL");
            uniqueKeywordsReference.put(4, "INPUT");
            uniqueKeywordsReference.put(5, "WRITE");
            uniqueKeywordsReference.put(6, "END");

            // Identifiers
            uniqueKeywordsReference.put(7, "num");
            uniqueKeywordsReference.put(8, "temp");
            uniqueKeywordsReference.put(9, "numm");
            uniqueKeywordsReference.put(10, "nummm");
            uniqueKeywordsReference.put(11, "summation");
            uniqueKeywordsReference.put(12, "multi");
            
            //Operators
            uniqueKeywordsReference.put(13, "+");
            uniqueKeywordsReference.put(14, "/");
            uniqueKeywordsReference.put(15, "*");
            uniqueKeywordsReference.put(16, "-");
            
            // Symbols
           uniqueKeywordsReference.put(17, "=");
           uniqueKeywordsReference.put(18, ",");
            
            // token count
            int count = 0;

            // to keep track of previous token
            String prevToken = null;

            System.out.println("\n" + "======STAGE1: COMPILER TECHNIQUES--> LEXICAL ANALYSIS-Scanner");
            System.out.println("SYMBOL TABLE COMPRISING ATTRIBUTES AND TOKENS:");

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
                for(int h = 0; h <= 16; h++){
                    if(input.equals(uniqueKeywordsReference.get(h))){
                        notvalid = true;
                        break; // exit the loop if input is found
                    }
                }
                
                if(!notvalid  && !input.matches(" ")){

                // Semantic errors
                // Special characters error
                if(Pattern.matches("[\\p{P}\\p{S}]", input)) {
                    System.out.println("#" + (++count) + " SEMANTIC ERROR- symbol entered is not allowed! i.e(%,$,&,<,>$,%,!,;)");
                }
                
                else{
                    System.out.println("#" + ++count + " SEMANTIC ERROR- input undefined!");
                }
                // Numbers error handling
                // for(int numError = 0; numError<=1000000; numError++){
                //     int inputNum = Integer.parseInt(input);
                //     // convert numError to string and compare that
                //     if(inputNum == numError){
                //         System.out.println("#" + ++count + " SYNTAX ERROR- numbers are not allowed in this language");
                //     }
                // }

                }

                // to initialize prevoius token disregarding white space
                if (!input.matches("\\s+")) {
                    // Only update prevToken if the current token is not whitespace
                    prevToken = input;
                }
            }

            System.out.println("TOTAL NUMBER OF TOKENS FOR STRING#" + i + ":" + count);
            System.out.println("END OF STRING#" + i);
            System.out.println("====================");

            // Stage 2 of compiler
            System.out.println("\n" + "======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser");
            System.out.println("GET A DERIVATION FOR : " + str + "\n");
            System.out.println("\n" + "GIVING THE GRAMMAR: E=E1 | E=E1*E2 | E=E1+E2 | E=digit | E={0,1,2,3,4,5,6,7,8,9}");
            System.out.println("GET A DERIVATION FOR : " + str);

              
            }
        }
    }