
import java.util.Scanner;

// User-defined exception class
class StackUnderflowException extends Exception {
    StackUnderflowException(String message) {
        super(message);
    }
}

// Stack implementation
class Stack {
    int stack[];
    int top;
    int size;

    // Constructor
    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push operation
    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow!");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    // Pop operation
    void pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException(
                "Stack Underflow! Cannot delete from an empty stack."
            );
        } else {
            System.out.println("Popped element: " + stack[top--]);
        }
    }

    // Display operation
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Stack s = new Stack(5);
        int choice, value;

        do {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;

                case 2:
                    try {
                        s.pop();
                    } catch (StackUnderflowException e) {
                        System.out.println("Exception caught: " 
                                           + e.getMessage());
                    }
                    break;

                case 3:
                    s.display();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

