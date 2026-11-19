import java.util.Scanner;

public class LinearSearchString {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String str = sc.nextLine();

    System.out.println("\n1. Search for a character");
    System.out.println("2. Search for a word/string");
    System.out.print("Enter your choice: ");

    int choice = sc.nextInt();
    sc.nextLine();

    boolean found = false;

    if (choice == 1) {

        System.out.print("Enter a character to search: ");
        char target = sc.nextLine().charAt(0);

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == target) {

                System.out.println("Character found at index: " + i);
                found = true;
                break;
            }
        }
    }

    else if (choice == 2) {

        System.out.print("Enter a word/string to search: ");
        String target = sc.nextLine();

        for (int i = 0; i <= str.length() - target.length(); i++) {

            if (str.substring(i, i + target.length()).equals(target)) {

                System.out.println("String found at index: " + i);
                found = true;
                break;
            }
        }
    }

    else {

        System.out.println("Invalid choice!");
        sc.close();
        return;
    }

    if (!found) {
        System.out.println("Not found.");
    }

    sc.close();
}


}
