import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
* The Reverse String program will read a set of strings from 'input.txt'.
* It will then reverse each string using a recursive function.
* Finally, it will write the reversed string to 'output.txt'.
*
* @version 1.0
* @since 2025-04-17
*/

final class ReverseString {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the reverse string method.
     *
     * @param string the string to be reversed.
     * @return the reversed string.
     */

    public static String reverseString(final String string) {

        // Base case
        if (string.length() == 0) {

            // Return the empty string
            return string;

        // Recursive case
        } else {

            // substring method returns the string without the first character
            // and the charAt method returns the first character
            // Source: https://www.w3schools.com/java/ref_string_substring.asp
            return reverseString(string.substring(1)) + string.charAt(0);
        }
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // pass the relative path to the input file as a parameter
        File file = new File("./input.txt");

        // Create a file object
        FileWriter myWriter = new FileWriter("./output.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // Greeting and instructions
        System.out.println("Welcome to the reverse string program!");
        System.out.print("The Reverse String program will read a set of ");
        System.out.println("strings from 'input.txt'.");
        System.out.print("It will populate the set of ");
        System.out.println("strings into an array.");
        System.out.print("It will then reverse each string using ");
        System.out.println("a recursive function.");
        System.out.print("Finally, it will write the reversed ");
        System.out.println("strings to 'output.txt'.");

        // Keep reading the file until there are no more lines
        while (scanner.hasNextLine()) {

            // Read the string from the file
            String string = scanner.nextLine();

            // Get the sorted array by calling the select sort function
            String reversedString = reverseString(string);

            // Add the reversed string to the output string
            outputStr += (reversedString + "\n");
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Close the file writer
        myWriter.close();

        // Added a blank line for spacing
        System.out.println("");

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");

        // Close the scanner
        scanner.close();
    }
}
