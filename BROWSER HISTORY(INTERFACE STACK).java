
import java.util.ArrayList;
import java.util.Scanner;

interface Stack {
    void push(String url);
    String pop();
    String peek();
    boolean isEmpty();
    void display();
}


class GrowStack {
    ArrayList<String> list = new ArrayList<>();

    void add(String url) {
        list.add(url);
    }

    String remove() {
        return list.remove(list.size() - 1);
    }

    String getTop() {
        return list.get(list.size() - 1);
    }
}


class StringList implements Stack {

    GrowStack stack = new GrowStack();

   
    public void push(String url) {
        stack.add(url);
        System.out.println("Visited: " + url);
    }

    
    public String pop() {
        if (isEmpty()) {
            System.out.println("History is Empty.");
            return null;
        }

        return stack.remove();
    }

    
    public String peek() {
        if (isEmpty()) {
            System.out.println("No website is currently available.");
            return null;
        }

        return stack.getTop();
    }


    public boolean isEmpty() {
        return stack.list.isEmpty();
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("History is Empty.");
            return;
        }

        System.out.println("\nBROWSER HISTORY:");

        for (int i = stack.list.size() - 1; i >= 0; i--) {
            System.out.println(stack.list.get(i));
        }
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringList browser = new StringList();

        int choice;

        do {
            System.out.println("\n===== BROWSER HISTORY MENU =====");
            System.out.println("1. Visit Website");
            System.out.println("2. BACKTRACK");
            System.out.println("3. CURRENT WEBSITE");
            System.out.println("4. DISPLAY HISTORY");
            System.out.println("5. EXIT");

            System.out.print("\nENTER CHOICE: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ENTER URL: ");
                    String url = sc.nextLine();

                    browser.push(url);
                    break;

                case 2:
                    String previous = browser.pop();

                    if (previous != null) {
                        System.out.println("Going Back From: " + previous);

                        if (browser.isEmpty()) {
                            System.out.println("No previous website.");
                        } else {
                            System.out.println(
                                "Current Website: " + browser.peek()
                            );
                        }
                    }
                    break;

                case 3:
                    String current = browser.peek();

                    if (current != null) {
                        System.out.println("CURRENT WEBSITE: " + current);
                    }
                    break;

                case 4:
                    browser.display();
                    break;

                case 5:
                    System.out.println("Exiting Browser History System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

