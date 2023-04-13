import java.util.*;
import java.util.regex.Pattern;

public class vCompiler {
        // TODO: Intermediate code representation
        // TODO: Code Optimization
        // TODO: Code Generation
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);

        System.out.println("Enter number of strings: ");
        int strNums = In.nextInt();
        In.nextLine();

        String str = null;

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

          // Operators
          uniqueKeywordsReference.put(7, "+");
          uniqueKeywordsReference.put(8, "/");
          uniqueKeywordsReference.put(9, "*");
          uniqueKeywordsReference.put(10, "-");
          uniqueKeywordsReference.put(11, "temp");

          //Symbols
          uniqueKeywordsReference.put(12, "=");
          uniqueKeywordsReference.put(13, ",");

         int i = 0;

         // token count
         int count = 0;

        // Strings loop
        for ( i = 1; i <= strNums; i++) {
            System.out.println("\n" + "Enter string #" + i + ":");
            str = In.nextLine();

            // tokenize string
            StringTokenizer tokenizer = new StringTokenizer(str, "+-*/,; ", true);

            // Split String based on white spaces 
            //String[] splitStr = str.split("\\s+");

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
                else if(input.matches("[A-Za-z]+")) {
                        System.out.println("TOKEN#" + ++count + " Identifier");
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
                for(int h = 0; h <= 13; h++){
                    if(input.equals(uniqueKeywordsReference.get(h))){
                        notvalid = true;
                        break; // exit the loop if input is found
                    }
                }
                
                if(!notvalid && !input.matches("[A-Za-z]+") && !input.matches("\\s+")){

                // Semantic errors
                // Special characters error
                if(Pattern.matches("[\\p{P}\\p{S}]", input)) {
                    if(!input.matches("\\s+") && !input.matches("=")){
                        System.out.println("#" + (++count) + " SEMANTIC ERROR- symbol entered is not allowed! i.e(%,$,&,<,>$,%,!,;)");
                    }
                }
                
                else{
                    System.out.println("#" + ++count + " SEMANTIC ERROR- input undefined!");
                }
        
                }

                // to initialize prevoius token disregarding white space
                if (!input.matches("\\s+")) {
                    // Only update prevToken if the current token is not whitespace
                    prevToken = input;
                }
            }

            System.out.println("TOTAL NUMBER OF TOKENS FOR STRING#" + i + ":" + count);

            // Stage 2 of compiler
            
            System.out.println("\n" + "======STAGE2: COMPILER TECHNIQUES--> SYNTAX ANALYSIS-Parser");
            System.out.println("GET A DERIVATION FOR : " + str + "\n");

            String digit = " ";

            StringTokenizer tokenizerStge2 = new StringTokenizer(str, "+-*/,; ", true);

            while(tokenizerStge2.hasMoreTokens()){
                String inputStge2 = tokenizerStge2.nextToken();

                if(inputStge2.matches("[A-Za-z]+")){
                    if(tokenizerStge2.hasMoreTokens()){
                        if(inputStge2.equals("A")){
                            digit = " digit1";
                        } if(inputStge2.equalsIgnoreCase("B")){
                            digit = " digit2";
                        } if(inputStge2.equalsIgnoreCase("C")){
                            digit = " digit3";
                        } if(inputStge2.equalsIgnoreCase("D")){
                            digit = " digit4";
                        } if(inputStge2.equalsIgnoreCase("E")){
                            digit = " digit5";
                        } if(inputStge2.equalsIgnoreCase("F")){
                            digit = " digit6";
                        } if(inputStge2.equalsIgnoreCase("G")){
                            digit = " digit7";
                        } if(inputStge2.equalsIgnoreCase("H")){
                            digit = " digit8";
                        } if(inputStge2.equalsIgnoreCase("I")){
                            digit = " digit9";
                        } if(inputStge2.equalsIgnoreCase("J")){
                            digit = " digit10";
                        } if(inputStge2.equalsIgnoreCase("K")){
                            digit = " digit11";
                        } if(inputStge2.equalsIgnoreCase("L")){
                            digit = " digit12";
                        } if(inputStge2.equalsIgnoreCase("M")){
                            digit = " digit13";
                        } if(inputStge2.equalsIgnoreCase("N")){
                            digit = " digit14";
                        } if(inputStge2.equalsIgnoreCase("O")){
                            digit = " digit15";
                        } if(inputStge2.equalsIgnoreCase("P")){
                            digit = " digit16";
                        } if(inputStge2.equalsIgnoreCase("Q")){
                            digit = " digit17";
                        } if(inputStge2.equalsIgnoreCase("R")){
                            digit = " digit18";
                        } if(inputStge2.equalsIgnoreCase("S")){
                            digit = " digit19";
                        } if(inputStge2.equalsIgnoreCase("T")){
                            digit = " digit20";
                        } if(inputStge2.equalsIgnoreCase("U")){
                            digit = " digit21";
                        } if(inputStge2.equalsIgnoreCase("V")){
                            digit = " digit22";
                        } if(inputStge2.equalsIgnoreCase("W")){
                            digit = " digit23";
                        } if(inputStge2.equalsIgnoreCase("X")){
                            digit = " digit24";
                        } if(inputStge2.equalsIgnoreCase("Y")){
                            digit = " digit25";
                        } if(inputStge2.equalsIgnoreCase("Z")){
                            digit = " digit26";
                        } 
                        if(tokenizerStge2.nextToken().matches(" ")){
                            System.out.print(digit + " " + tokenizerStge2.nextToken());
                        }
                        else {
                            System.out.print(digit + " |");
                        }
                    }
                    else {
                        System.out.print(digit);
                    }
                }

            }

            }

        }
    }