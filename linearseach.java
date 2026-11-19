
import java.util.Scanner;

public class LinearSearchString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter a character to search: ");
        char target = sc.next().charAt(0);

        boolean found = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                System.out.println("Character found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Character not found.");
        }

        sc.close();
    }
}

Example
Enter a string: hello world
Enter a character to search: w
Character found at index: 6

If you want to search for a whole word/string
For example, searching "world" inside "hello world":

import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter string to search: ");
        String target = sc.nextLine();

        boolean found = false;

        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (str.substring(i, i + target.length()).equals(target)) {
                System.out.println("String found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("String not found.");
        }

        sc.close();
    }
}
