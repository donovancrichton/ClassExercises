import java.util.Scanner;
import java.text.NumberFormat;

public class InClassExercise6 {

    public static void main(String[] args) {
       //declare variables
       String[] weekday = new String[7];
       double hourlyRate = 0;
       //7 days in a week.
       double regularHours = 0;
       double overTimeHours = 0;
       
       //initialise arrays
       weekday[0] = "Monday";
       weekday[1] = "Tuesday";
       weekday[2] = "Wednesday";
       weekday[3] = "Thursday";
       weekday[4] = "Friday";
       weekday[5] = "Saturday";
       weekday[6] = "Sunday";
       
       hourlyRate += query("hourly rate");
        for (String i : weekday) {
            regularHours += query("total regular hours for " + i);
            overTimeHours += query("total overtime hours for " + i);
        }
       display(hourlyRate, regularHours, overTimeHours, weekday);       
    }
    
    private static double query(String display) {
        Scanner input = new Scanner(System.in);
        
        double rate = 0;
        System.out.println("Please enter the " + display + ": ");
        //note now validates negative numbers correctly.
        do {
            while ( !input.hasNextDouble() ) {
                System.out.println("Please enter a number!");
                input.next();
            }
            rate = input.nextDouble();
            if (rate < 0) {
                System.out.println("Please enter a postive number!");
            }
        } while (rate < 0); 
        return rate;    
    }
    
    private static void display(double rate, double regular, 
            double overTime, String[] weekday) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double wage = (rate * regular) + (rate * 1.5 * overTime);
        System.out.println("Weekly wage is: $" + currency.format(wage));     
    }
}
