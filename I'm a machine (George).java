import java.util.regex.Pattern;
import java.util.Scanner;

public class targetMachineCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of strings: ");
        int strNums = in.nextInt();
        in.nextLine();

        String str = null;
        int i = 0;

        /* Strings loop
        for (i = 1; i <= strNums; i++) {
            System.out.println("\nEnter string #" + i + ":");
            str = in.nextLine();*/

        System.out.println("Enter a letter:");
        String letter = in.nextLine();

        if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
            char c = letter.charAt(0);
            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                String binary = Integer.toBinaryString(c);
                System.out.printf("The binary form of %s is %s.\n", letter, binary);
            } else {
                System.out.println("Error: input is not a letter.");
            }
        } else {
            System.out.println("Error: input is not a single letter.");
        }
    }

}
