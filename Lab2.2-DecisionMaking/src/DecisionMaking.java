
/*
Task: Use conditional statements to automate the decision-making process.

What will the application do?
The application prompts the user to enter an integer between 1 and 100.
Display the associated result based on the integer range entered.  

Build Specifications
Use if/else statements to take different actions depending on user input.  
Given an integer entered by a user, perform the following conditional actions:
1. If the integer entered is odd, print the number entered and ?Odd.?
2. If the integer entered is even and in the inclusive range of 2 to 25, print ?Even and less than 25.?
3. If the integer entered is even and in the inclusive range of 26 to 60, print ?Even.?
4. If the integer entered is even and greater than 60, print the number entered and ?Even.?
5. If the integer entered is odd and greater than 60, print the number entered and ?Odd and over 60.?
***Please note the difference between the 3rd and 4th If statements. Due to ambiguity in instructions (one requiring only printing
"Even" and the other requiring the number entered and "Even, but all class examples showing the number entered, changes were
made in the output of my own code***

Extra Challenges:
Ask for user information (ex. name) at the beginning of the application, and use it to refer to the user throughout the application.
Add validation to guarantee that a user enters a positive integer between 1 and 100.
*/
import java.util.Scanner;

public class DecisionMaking {

	static String numResultMsg = "";

	public static void main(String[] args) {

		boolean keepGoing = true;

		Scanner scnr = new Scanner(System.in);

		System.out.print("Please enter your name. ");
		String userName = scnr.nextLine();

		while (keepGoing) {
			System.out.print("Hello " + userName + ", enter a whole number between 1 and 100. ");
			int chosenNumber = scnr.nextInt();

			if (isNumberInRange(chosenNumber)) {
				checkNumberAndSetMessage(chosenNumber);
				System.out.print(numResultMsg);
			} else {
				System.out.println("Number is not within range.\n");
			}

			System.out.print("\nContinue? (y/n) ");
			String userContinue = scnr.next();

			keepGoing = userContinue.equalsIgnoreCase("y");
		}
		scnr.close();
	}

	
	// validates user input is number between 1-100
	private static boolean isNumberInRange(int a) {
		if (a > 0 && a <= 100) {
			return true;
		}
		return false;
	}

	// checks number and outputs message based on assignment parameters
	private static void checkNumberAndSetMessage(int a) {
		if (a % 2 != 0) {
			numResultMsg = (a > 60 ? a + ", Odd and over 60" : a + ", and Odd");
		} else if (a <= 60) {
			numResultMsg = (a < 25 ? a + ", Even and less than 25." : a + ", Even and between 26 and 60");
		} else {
			numResultMsg = a + ", Even.";
		}
	}
}
