/**
 * This is a program to test whether a given string is a palindrome or not. The user is prompted to 
 * enter a string, then the string is read and tested for equality to an output string. The user is 
 * then asked whether they want to run the program again. The program executes until the user enters 
 * 'n' or 'N'. If the user does not enter 'y' or 'n', the program prompts them to enter a valid 
 * answer until they enter either of the two valid options.
 */

import java.util.Scanner;

public class Palindrome {

	/**
	 * @param none
	 * @return none
	 * This is a method to test whether the user wants to execute the program again. If the user 
	 * enters 'y' or 'Y', run the program until the user enters 'n' or 'N'. If the user enters 
	 * another option, prompt the user for an option until they have entered either 'Y' or 'N'.
	 */
	public static void promptToRunAgain() {
		while (true) {
			Scanner choiceSc = new Scanner(System.in);
			System.out.print("Do you want to test another palindrome (Y/N)? ");
			char choice = choiceSc.next().charAt(0);
			
			switch (choice) {
			case 'y': case 'Y': // Answer is yes, run program again
				testPalindrome();
				break;
			case 'n': case 'N': // Terminate program
				System.out.println("Goodbye!");
				System.exit(0);	
			default: // Prompt user for option until they've entered Y or N
				System.out.println("Invalid option; please enter either Y or N");
				continue;
			}
		}
	}
	
	/**
	 * @param none
	 * @return none
	 * This method prompts the user to enter a string to determine whether or not it is a 
	 * palindrome. The method ignores all punctuation and spaces and converts the string 
	 * to lowercase for equality. The input string is read backwards, and the letters are 
	 * inserted into the output string. If the two strings are equal, the string is a 
	 * palindrome.
	 */
	public static void testPalindrome() {
		Scanner sc = new Scanner(System.in);
		String output = ""; // String to be tested for equality
		System.out.print("Please enter a string: ");
		String input = sc.nextLine();

		// Remove all punctuation and spaces from input
		input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

		// Read input string backwards and store letters into output string
		for (int i = input.length() - 1; i >= 0; i--) {
			output += input.charAt(i);
		}

		if (input.contentEquals(output)) {
			System.out.println("The string is a palindrome.");
		} 
		else {
			System.out.println("The string is not a palindrome.");
		}
	}
	
	/**
	 * 
	 * @param args
	 * @return none
	 * Main method where the user will interact with the program.
	 */
	public static void main(String[] args) {
		testPalindrome();
		promptToRunAgain();
	}

}
