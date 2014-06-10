
import java.util.Scanner;
import java.text.NumberFormat;

public class InClassExercise5 {
	public static void main(String[] args) {
		double hourlyRate = query("hourly rate");
		double regularHours = query("total regular (ordinary) hours for the" 
			+ "week");
		double overTimeHours = query("total overtime hours for the week");
		display(hourlyRate, regularHours, overTimeHours);
	}
	
	private static double query(String display) {
		Scanner input = new Scanner(System.in);
		double value;
		System.out.println("Please enter the " + display + ": ");
		do {
			while ( !input.hasNextDouble() ) {
				System.out.println("Error! Please enter a number!");
				input.next();
			}
			value = input.nextDouble();
			if (value < 0) {
				System.out.println("Error! Please enter a positive number!");
				input.next();
			}
		} while (value < 0);
		return value;	
	}

	private static void display(double rate, double regular, double overTime) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double wage = (rate * regular) + (1.5 * rate * overTime);
		System.out.println("The weekly wage is: " + currency.format(wage));
	}

}
	
