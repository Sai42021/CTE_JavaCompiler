import java.util.*;
import java.util.regex.Pattern;

public class Main{
        // TODO: Code Optimization
        // TODO: Code Generation

        public static String  ldiv1, ldiv2, ldiv3, lmult1, lmult2, lmult3, lplus1, lplus2, lplus3, lminus1, lminus2, lminus3; // used in stage 5
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);

        System.out.println("\n" + "A MINI COMPILER PROJECT FOR CTE711S" + "\n");
        System.out.println("===================================" + "\n");

        System.out.println("-Any string/line must contain: Keywords, Identifiers, Operators, or Symbols ");
        System.out.println("-Symbols such as: %, $, &, <, >,; not allowed and would give Semantic error ");
        System.out.println("-Two operators must not be combined such as: +* not allowed and would give Syntax error");
        System.out.println("-Semi colon ; at the end of a line not allowed and would give Syntax error");
        System.out.println("-Numbers 0,1 to 9 are not allowed and would give Syntax error");
        System.out.println("-The acceptable keywords are: BEGIN, INTEG, LET, INPUT, WRITE, END.");
        System.out.println("-Misspelling in the keywords such as: WRITEE not allowed and would give Lexical error");
        System.out.println("-Any other character on the keyboard different from all the above will give Syntax error." + "\n");

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

        // Strings loop
        for ( i = 1; i <= strNums; i++) {
            System.out.println("\n" + "Enter string #" + i + ":");
            str = In.nextLine();

            // token count
            int count = 0;

            // tokenize string
            StringTokenizer tokenizer = new StringTokenizer(str, "+-*/,; ", true);

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
                        System.out.println("TOKEN#" + ++count + " " + input + " Keyword");
                    }
                }
                // Check if the current token is an identifier 
                else if(input.matches("[A-Za-z]+")) {
                        System.out.println("TOKEN#" + ++count + " " + input +  " Identifier");
                }
                // Check if the current token is an operator
                else if(input.matches("[+\\-/\\*]")){
                    if (uniqueKeywordsReference.contains(input)) {
                        if(prevToken != null && prevToken.matches("[+\\-/\\*]")){// checks if two operators were entered after each other
                            System.out.println("#" + ++count + " SYNTAX ERROR- two operators (*,-,+,/) cannot be written together!");
                            break;
                        } else{
                            System.out.println("TOKEN#" + ++count + " " + input +  " Operator");
                        }
                    }
                }
                 // Check if the current token is a Symbol
                 else if(input.equals("=")){
                    if (uniqueKeywordsReference.contains(input)) {
                        System.out.println("TOKEN#" + ++count + " " + input +  " Symbol");
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
                        break;
                    }
                }
                
                else{
                    System.out.println("#" + ++count + " SEMANTIC ERROR- input undefined!");
                    break;
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

            //E derivation
            String strA = str.replace("A", "E1");
            String stra = strA.replace("a", "E1");

            String strB = stra.replace("B", "E2");
            String strb = strB.replace("b", "E2");

            String strC = strb.replace("C", "E3");
            String strc = strC.replace("c", "E3");

            String strD = strc.replace("D", "E4");
            String strd = strD.replace("d", "E4");

            // String strE = strd.replace("E", "digit5");
            // String stre = strE.replace("e", "digit5");

            String strF = strd.replace("F", "E6");
            String strf = strF.replace("f", "E6");

            String strG = strf.replace("G", "E7");
            String strg = strG.replace("g", "E7");

            String strH = strg.replace("H", "E8");
            String strh = strH.replace("h", "E8");

            String strI = strh.replace("I", "E9");
            String stri = strI.replace("i", "E9");

            String strJ = stri.replace("J", "E10");
            String strj = strJ.replace("j", "E10");

            String strK = strj.replace("K", "E11");
            String strk = strK.replace("k", "E11");

            String strL = strk.replace("L", "E12");
            String strl = strL.replace("l", "E12");

            String strM = strl.replace("M", "E13");
            String strm = strM.replace("m", "E13");

            String strN = strm.replace("N", "E14");
            String strn = strN.replace("n", "E14");

            String strO = strn.replace("O", "E15");
            String stro = strO.replace("o", "E15");

            String strP = stro.replace("P", "E16");
            String strp = strP.replace("p", "E16");

            String strQ = strp.replace("Q", "E17");
            String strq = strQ.replace("q", "E17");

            String strR = strq.replace("R", "E18");
            String strr = strR.replace("r", "E18");

            String strS = strr.replace("S", "E19");
            String strs = strS.replace("s", "E19");

            String strT = strs.replace("T", "E20");
            String strt = strT.replace("t", "E20");

            String strU = strt.replace("U", "E21");
            String stru = strU.replace("u", "E21");

            String strV = stru.replace("V", "E22");
            String strv = strV.replace("v", "E22");

            String strW = strv.replace("W", "E23");
            String strw = strW.replace("w", "E23");

            String strX = strw.replace("X", "E24");
            String strx = strX.replace("x", "E24");

            String strY = strx.replace("Y", "E25");
            String stry = strY.replace("y", "E25");

            String strZ = stry.replace("Z", "E26");
            String strz = strZ.replace("z", "E26");

            System.out.println(strz); //End of E derivation

            //digit derivation
            String strE1 = " ", strE2 = " ", strE3 = " ", strE4 = " ", strE5 = " ", strE6 = " ", strE7 = " ",
            strE8 = " ", strE9 = " ", strE10 = " ", strE11 = " ", strE12 = " ", strE13 = " ", strE14 = " ",
            strE15 = " ", strE16 = " ", strE17 = " ", strE18 = " ", strE19 = " ", strE20 = " ", strE21 = " ",
            strE22 = " ", strE23 = " ", strE24 = " ", strE25 = " ", strE26 = " ";

            String strnum1 = " ", strnum2 = " ", strnum3 = " ", strnum4 = " ", strnum5 = " ", strnum6 = " ", strnum7 = " ",
            strnum8 = " ", strnum9 = " ", strnum10 = " ", strnum11 = " ", strnum12 = " ", strnum13 = " ", strnum14 = " ",
            strnum15 = " ", strnum16 = " ", strnum17 = " ", strnum18 = " ", strnum19 = " ", strnum20 = " ", strnum21 = " ",
            strnum22 = " ", strnum23 = " ", strnum24 = " ", strnum25 = " ", strnum26 = " ";            

            strE1 = strz.replace("E1", "digit1");
            if(strE1.contains("digit1")){
                System.out.println(strE1);
            }

            strE2 = strE1.replace("E2", "digit2");
            if(strE2.contains("digit2")){
                System.out.println(strE2);
            }

            strE3 = strE2.replace("E3", "digit3");
            if(strE3.contains("digit3")){
                System.out.println(strE3);
            }

            strE4 = strE3.replace("E4", "digit4");
            if(strE4.contains("digit4")){
                System.out.println(strE4);
            }

            strE5 = strE4.replace("E5", "digit5");
            if(strE5.contains("digit5")){
                System.out.println(strE5);
            }

            strE6 = strE5.replace("E6", "digit6");
            if(strE6.contains("digit6")){
                System.out.println(strE6);
            }

            strE7 = strE6.replace("E7", "digit7");
            if(strE7.contains("digit7")){
                System.out.println(strE7);
            }   

            strE8 = strE7.replace("E8", "digit8");
            if(strE8.contains("digit8")){
                System.out.println(strE8);
            }   

            strE9 = strE8.replace("E9", "digit9");
            if(strE9.contains("digit9")){
                System.out.println(strE9);
            }   

            strE10 = strE9.replace("E10", "digit10");
            if(strE10.contains("digit10")){
                System.out.println(strE10); 
            }  

            strE11 = strE10.replace("E11", "digit11");
            if(strE11.contains("digit11")){
                System.out.println(strE11);  
            } 

            strE12 = strE11.replace("E12", "digit12");
            if(strE12.contains("digit12")){
                System.out.println(strE12);  
            } 

            strE13 = strE12.replace("E13", "digit13");
            if(strE13.contains("digit13")){
                System.out.println(strE13);  
            } 

            strE14 = strE13.replace("E14", "digit14");
            if(strE14.contains("digit14")){
                System.out.println(strE14);
            }   

            strE15 = strE14.replace("E15", "digit15");
            if(strE15.contains("digit15")){
                System.out.println(strE15); 
            }  

            strE16 = strE15.replace("E16", "digit16");
            if(strE16.contains("digit16")){
                System.out.println(strE16); 
            }  

            strE17 = strE16.replace("E17", "digit17");
            if(strE17.contains("digit17")){
                System.out.println(strE17); 
            }  

            strE18 = strE17.replace("E18", "digit18");
            if(strE18.contains("digit18")){
                System.out.println(strE18);   
            }

            strE19 = strE18.replace("E19", "digit19");
            if(strE19.contains("digit19")){
                System.out.println(strE19);   
            }

            strE20 = strE19.replace("E20", "digit20");
            if(strE20.contains("digit20")){
                System.out.println(strE20);  
            } 

            strE21 = strE20.replace("E21", "digit21");
            if(strE21.contains("digit21")){
                System.out.println(strE21);   
            }

            strE22 = strE21.replace("E22", "digit22");
            if(strE22.contains("digit22")){
                System.out.println(strE22);   
            }

            strE23 = strE22.replace("E23", "digit23");
            if(strE23.contains("digit23")){
                System.out.println(strE23);  
            } 

            strE24 = strE23.replace("E24", "digit24");
            if(strE24.contains("digit24")){
                System.out.println(strE24);   
            }

            strE25 = strE24.replace("E25", "digit25");
            if(strE25.contains("digit25")){
                System.out.println(strE25);  
            } 

            strE26 = strE25.replace("E26", "digit26");
            if(strE26.contains("digit26")){
                System.out.println(strE26);
            }//End of digit derivation


        // Specific number derivation
        strnum1 = strE26.replace("digit1", "1");
            if(strnum1.contains("1")){
                System.out.println(strnum1);
            }

            strnum2 = strnum1.replace("digit2", "2");
            if(strnum2.contains("2")){
                System.out.println(strnum2);
            }

            strnum3 = strnum2.replace("digit3", "3");
            if(strnum3.contains("3")){
                System.out.println(strnum3);
            }

            strnum4 = strnum3.replace("digit4", "4");
            if(strnum4.contains("4")){
                System.out.println(strnum4);
            }

            strnum5 = strnum4.replace("digit5", "5");
            if(strnum5.contains("5")){
                System.out.println(strnum5);
            }

            strnum6 = strnum5.replace("digit6", "6");
            if(strnum6.contains("6")){
                System.out.println(strnum6);
            }

            strnum7 = strnum6.replace("digit7", "7");
            if(strnum7.contains("7")){
                System.out.println(strnum7);
            }   

            strnum8 = strnum7.replace("digit8", "8");
            if(strnum8.contains("8")){
                System.out.println(strnum8);
            }   

            strnum9 = strnum8.replace("digit9", "9");
            if(strnum9.contains("9")){
                System.out.println(strnum9);
            }   

            strnum10 = strnum9.replace("digit10", "10");
            if(strnum10.contains("10")){
                System.out.println(strnum10); 
            }  

            strnum11 = strnum10.replace("digit11", "11");
            if(strnum11.contains("11")){
                System.out.println(strnum11);  
            } 

            strnum12 = strnum11.replace("digit12", "12");
            if(strnum12.contains("12")){
                System.out.println(strnum12);  
            } 

            strnum13 = strnum12.replace("digit13", "13");
            if(strnum13.contains("13")){
                System.out.println(strnum13);  
            } 

            strnum14 = strnum13.replace("digit14", "14");
            if(strnum14.contains("14")){
                System.out.println(strnum14);
            }   

            strnum15 = strnum14.replace("digit15", "15");
            if(strnum15.contains("15")){
                System.out.println(strnum15); 
            }  

            strnum16 = strnum15.replace("digit16", "16");
            if(strnum16.contains("16")){
                System.out.println(strnum16); 
            }  

            strnum17 = strnum16.replace("digit17", "17");
            if(strnum17.contains("17")){
                System.out.println(strnum17); 
            }  

            strnum18 = strnum17.replace("digit18", "18");
            if(strnum18.contains("18")){
                System.out.println(strnum18);   
            }

            strnum19 = strnum18.replace("digit19", "19");
            if(strnum19.contains("19")){
                System.out.println(strnum19);   
            }

            strnum20 = strnum19.replace("digit20", "20");
            if(strnum20.contains("20")){
                System.out.println(strnum20);  
            } 

            strnum21 = strnum20.replace("digit21", "21");
            if(strnum21.contains("21")){
                System.out.println(strnum21);   
            }

            strnum22 = strnum21.replace("digit22", "22");
            if(strnum22.contains("22")){
                System.out.println(strnum22);   
            }

            strnum23 = strnum22.replace("digit23", "23");
            if(strnum23.contains("23")){
                System.out.println(strnum23);  
            } 

            strnum24 = strnum23.replace("digit24", "24");
            if(strnum24.contains("24")){
                System.out.println(strnum24);   
            }

            strnum25 = strnum24.replace("digit25", "25");
            if(strnum25.contains("25")){
                System.out.println(strnum25);  
            } 

            strnum26 = strnum25.replace("digit26", "26");
            if(strnum26.contains("26")){
                System.out.println(strnum26);
            }//End of Specific number derivation
    
            // Stage 3 of compiler
            System.out.println("\n" + "======STAGE3: COMPILER TECHNIQUES--> SEMANTIC ANALYSIS");
            System.out.println("CONCLUSION-->This expression: " + str + " is Syntactically and Semantically correct" + "\n");
            // END of stage3

            // Stage 4 of compiler
            System.out.println("======STAGE4: COMPILER TECHNIQUES--> INTERMEDIATE CODE REPRESENTATION (ICR)");
            System.out.println("THE STRING ENTERED IS : " + str);
            System.out.println("The ICR is as follows: ");

            String[] tokenstge4 = str.split("(?<=[-+*/()=])|(?=[-+*/()=])"); // split the input string into tokens

            String T1 = tokenstge4[2] + "/" + tokenstge4[4];
            String T2 = "T1+" + tokenstge4[6];
            String T3 = T2 + "*" + tokenstge4[0];
            String T4 = tokenstge4[0] + "=" + T3;

            System.out.println("T1 = " + T1);
            System.out.println("T2 = " + T2);
            System.out.println("T3 = " + T3);
            System.out.println("T4 = " + T4);

            System.out.println("CONCLUSION-->The expression was correctly generated in ICR" + "\n");

             // Stage 5 of compiler
            System.out.println("======STAGE5: COMPILER TECHNIQUES--> CODE GENERATION");

            //Division
            if(str.contains("/")){
                ldiv1="LDA"+" "+ tokenstge4[2];
                ldiv2 = "DIV"+ " "+ tokenstge4[4];
                ldiv3 = "STR " + "T1";
            }
            //Multiplication
            if(str.contains("*")){
                lmult1="LDA"+" "+ tokenstge4[8];
                lmult2 = "MUL"+ " "+ tokenstge4[10];
                lmult3 = "STR " + "T3";
            }
            //Addition
            if(str.contains("+")){
                lplus1="LDA"+" "+ tokenstge4[6];
                lplus2 = "ADD"+ " "+ tokenstge4[8];
                lplus3 = "STR " + "T2";
            }

            //Subtraction
            if(str.contains("/")){
                lminus1="LDA"+" "+ tokenstge4[6];
                lminus2 = "SUB"+ " "+ tokenstge4[8];
                lminus3 = "STR " + "T4";
            }
            if (str.contains("/")) System.out.println(ldiv1);System.out.println(ldiv2);System.out.println(ldiv3);
            if (str.contains("*")) System.out.println(lmult1);System.out.println(lmult2);System.out.println(lmult3);
            if (str.contains("+")) System.out.println(lplus1);System.out.println(lplus2);System.out.println(lplus3);
            if (str.contains("-")) System.out.println(lminus1);System.out.println(lminus2);System.out.println(lminus3);
            System.out.println("\n");
            // END of Stage 5

            // End of compilation
            System.out.println("\n" + "======END OF COMPILATION");
            System.out.println("======THE ORIGINAL INPUT STRING IS: " + str + ";");


            }

        }
}