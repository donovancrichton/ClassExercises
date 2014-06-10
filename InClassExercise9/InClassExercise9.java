/******************************************************************************
* @author Donovan Crichton
* A Program to determine whether or not a number is prime using the trial
* division algorithm. Note, for this exercise a boolean result is all that is
* required.
******************************************************************************/

import java.util.Scanner;

public class InClassExercise9 {
	public static void main(String args[]) {
		int number = query();
		boolean check = isPrime(number);
		System.out.println("Is " + number + " prime?..." + check + "!");
	}
	
	//requests input for an integer from the user
	private static int query() {
		Scanner input = new Scanner(System.in);
		int number = 0;
		
		System.out.println("Please enter a positive or negative integer: ");
		//get input
		while ( !input.hasNextInt() ) {
			System.out.println("Error! Please enter a positive or negative integer!");
			input.next();
		}
		number = input.nextInt();
		return number;
	}

	private static boolean isPrime(int number) {
		//check for the easily spotted non-primes first
		if ( ( number > 2 && (number % 2 == 0) ) || (number == 1) ) {
			return false;
		}
		else {
			//is there a divisor less than the square root?
			for (int i = 2; i <= (int) Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}		
		


