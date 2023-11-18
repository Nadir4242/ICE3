//Nadir Mahmood
//ICE3
//18/11/2023
//This program calculated the average of 10 numbers. Also, it checks for errors with input values.

import java.util.InputMismatchException;
import java.util.Scanner;

public class AvgCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of values you want to enter: ");
            int numOfValues = scanner.nextInt();

            if (numOfValues <= 0) {
                throw new IllegalArgumentException("Enter a positive number for the number of values.");
            }

            int sum = 0;

            for (int i = 1; i <= numOfValues; i++) {
                while (true) {
                    try {
                        System.out.print("Enter value #" + i + ": ");
                        long value = scanner.nextLong();

                        if (value < 0) {
                            throw new IllegalArgumentException("You have entered a negative value. Please enter a positive value.");
                        }

                        if (value > Integer.MAX_VALUE) {
                            throw new IllegalArgumentException("The value you entered is too large. Please enter a smaller value.");
                        }

                        sum += value;
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a numeric value.");
                        scanner.nextLine(); // Consume the invalid input and allow the user to try again
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine(); // Consume the invalid input and allow the user to try again
                    }
                }
            }

            double average = (double) sum / numOfValues;
            System.out.println("The average is: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Your input is invalid. Please enter a numeric value for the number of values.");
        } finally {
            scanner.close();
        }
    }
}