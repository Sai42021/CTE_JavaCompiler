import java.util.regex.Pattern;
import java.util.Scanner;

public class targetMachineCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string of letters: ");
        String letters = in.nextLine();

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if (Character.isLetter(c)) {
                String binary = Integer.toBinaryString(c);
                System.out.printf(binary + " ");
            }
        }
    }
}
