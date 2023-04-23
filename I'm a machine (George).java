import java.util.*;
import java.util.regex.Pattern;

public class targetMachineCode {
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);

        System.out.println("Enter number of strings: ");
        int strNums = In.nextInt();
        In.nextLine();

        String str = null;

        int i = 0;

        // token count
        int count = 0;

        // Strings loop
        for (i = 1; i <= strNums; i++) {
            System.out.println("\n" + "Enter string #" + i + ":");
            str = In.nextLine();


                String letter = In.nextLine();

                        if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                            char c = letter.charAt(0);
                            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                                String binary = Integer.toBinaryString(c);
                                System.out.printf(binary);
                            }
                        }
                    }
                }
            }