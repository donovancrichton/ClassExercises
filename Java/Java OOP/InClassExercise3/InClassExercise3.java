import java.util.Scanner;

public class InClassExercise3 {
	public static void main(String[] args) {
		double kilometers = 0;
		double nauticalMiles = 0;
		kilometers = query("Please enter the number of Kilometers to "
			+ "convert to nautical miles: ");
		nauticalMiles = calcNauticalMiles(kilometers);
		System.out.println("Thank you.");
		System.out.println(kilometers + " Kilometers is equivalent to "
			+ nauticalMiles + " nautical miles.");
	}

	private static double query(String inputString) {
		Scanner input = new Scanner(System.in);
		double number = 0;	
		System.out.println(inputString);
		do {
			while ( !input.hasNextDouble() ) {
				System.out.println("Please enter a number!");
				input.next();
			}
			number = input.nextDouble();
			if (number < 0) {
				System.out.println("Please enter a positive number!");
			}
		} while (number < 0);
		return number;
	}
	
	private static double calcNauticalMiles(double kilometers) {
		return kilometers * 0.6214;
	}
}
