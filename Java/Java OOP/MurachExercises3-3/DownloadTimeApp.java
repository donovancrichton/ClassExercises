import java.util.Scanner;

public class DownloadTimeApp {
	public static void main(String[] args) {
		//declare variables
		double size = 0;
		double speed = 0;
		double time = 0;
		int hours = 0;
		String sentinal = "y";
		
		System.out.println("Welcome to the Download Time Estimator");
		while (sentinal.toLowerCase() == "y") { 
			size = query("\nEnter file size (MB): ");
			speed = query("Enter the download speed (MB/sec): ");
			hours = (int) (size / speed / 60 / 60);
			time = size / speed / 60;
			
			System.out.println("\nThis download will take approximately "
				+ hours + " hours "
				+ (int) time + " minutes " 
				+ (int) ((time - (int) time) * 100) + " seconds");
			sentinal = sentinalQuery("\nContinue? (y/n): ");
		}	
	}

	private static double query(String display) {
		Scanner input = new Scanner(System.in);
		double value = 0;
	
		System.out.print(display);
		do {
			while (!input.hasNextDouble()) {
				System.out.println("Error! Please enter a number!");
				input.next();
			}
			value = input.nextDouble();
			if (value < 0) {
				System.out.println("Error! Please enter a positive number!");
			}
		} while (value < 0);
		return value;
	}

	private static String sentinalQuery(String display) {
		Scanner input = new Scanner(System.in);
		
		System.out.print(display);
		return input.next();	
	}
}			
