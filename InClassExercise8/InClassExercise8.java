//Create a program to display the tax payable on a particular salary.
//using a given tax system. note: uses ATO income tax thresholds as at
//2014
//@author Donovan Crichton

import java.util.Scanner;
import java.text.NumberFormat;

public class InClassExercise8 {
	public static void main(String[] args) {
		double wage = 0;
		double taxPayable = 0;
		String request = "Please enter the yearly wage: ";
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		wage = query(request);
		taxPayable = calcTax(wage);

		System.out.println( "The tax payable on " + currency.format(wage) + " is: "
			 + currency.format(taxPayable) );
	}
	
	//requests input from the user
	private static double query(String queryString) {
		Scanner input = new Scanner(System.in);
		double value = 0;
		
		//ask for input!
		System.out.println(queryString);
		
		//validates that input is of type double...must be a better way than this!	
		do {
			while (!input.hasNextDouble()) {
				System.out.println("Error! Please enter a number");
				input.next();
			}
			value = input.nextDouble();
			if (value < 0) {
				System.out.println("Error! Please enter a negative number!");
				input.next();
			}
		} while (value < 0);
		
		return value;
	}

	//calculates the tax payable
	private static double calcTax(Double wage) {
		double tax = 0;
		double rate = 0;
		//instantiate an array for the size of the tax tresholds found on
		//https://www.ato.gov.au/Rates/Individual-income-tax-rates/
		double[][] threshold = new double[4][2];
		
		//fill the array with the tax threshold data...
		threshold[0][0] = 18200;
		threshold[1][0] = 37000;
		threshold[2][0] = 80000;
		threshold[3][0] = 180000;

		//and populate the associate percentage data.					
		threshold[0][1] = 0.19;
		threshold[1][1] = 0.325;
		threshold[2][1] = 0.37;
		threshold[3][1] = 0.45;

		for (int i = threshold.length - 1; i > -1 ; i--) {
			rate = threshold[i][1];
			if (wage >= threshold[i][0]) {
				tax += (wage - threshold[i][0]) * rate;
				wage = wage - (wage - threshold[i][0]);
			}
		}
		return tax;
	}	
						
}
	
