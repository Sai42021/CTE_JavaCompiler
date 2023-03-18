import java.util.Scanner;
import java.util.StringTokenizer;

public class Painvi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
                case "A": case "B": case "C": case "D": case "E":
                case "F": case "G": case "H": case "I": case "J":
                case "K": case "L": case "M": case "N": case "O":
                case "P": case "Q": case "R": case "S": case "T":
                case "U": case "V": case "W": case "X": case "Y": case "Z":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENA);
                    break;
                case "a": case "b": case "c": case "d": case "e":
                case "f": case "g": case "h": case "i": case "j":
                case "k": case "l": case "m": case "n": case "o":
                case "p": case "q": case "r": case "s": case "t":
                case "u": case "v": case "w": case "x": case "y": case "z":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENB);
                    break;
                case "+":
                case "/":
                case "*":
                case "-":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKENC);
                    break; 
                case "=":
                case "&":
                case ";":
                    System.out.println("TOKEN#" + ++count + " " + Charac + TOKEND);
                    break;     
            }
        }
            System.out.print("Total number of Tokens: " + count);
        }
    }
