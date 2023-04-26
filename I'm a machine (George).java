import java.util.regex.Pattern;
import java.util.Scanner;

public class targetMachineCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("======STAGE7: TARGET MACHINE CODE ");



        System.out.println("Enter a string of letters: ");
        String letters = in.nextLine();

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if (Character.isLetter(c)) {
                String binary = Integer.toBinaryString(c);
                System.out.printf(binary + " ");

                if(letters.contains("DIV")){
                    System.out.println("01000100");
                }else if(letters.contains("MUL")){
                    System.out.println("01001101");
                }else if (letters.contains("ADD")){
                    System.out.println("01000001");
                }else if (letters.contains("SUB")){
                    System.out.println("01010011");
                }
            }
        }
    }
}
