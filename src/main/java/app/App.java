package app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Creating object to call non-static method
        App obj = new App();

        // Calling add method
        int result = obj.add(a, b);

        // Display result
        System.out.println("Sum = " + result);

        sc.close();
    }

    public int add(int a, int b) {
        return a + b;
    }
}