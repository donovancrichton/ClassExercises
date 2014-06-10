import java.text.NumberFormat;
import java.util.Scanner;

public class InClassExercise7 {

    public static void main(String[] args) {
        double principle = 0;
        double rate = 0;
        double term = 0;
        double frequency = 0;
        
        principle += query("principle (starting) balance");
        rate += query("interst rate % (p.a)") / 100;
        term += query("number of years invested (term)");
        frequency += query("frequency of compounding (1 if once a year)");
        
        outputFutureValue(principle, rate, term, frequency);
        
    }
    
    private static double query(String text) {
        Scanner input = new Scanner(System.in);
        double value = 0;
        System.out.println("Please enter the " + text + ":");
        do {
            while ( !input.hasNextDouble() ) {
                System.out.println("Please enter a number!");
                input.next();
            }
            value = input.nextDouble();
            if (value < 0) {
                System.out.println("Please enter a postive number!");
            }
        } while (value < 0); 
        return value;
    }
    
    private static void outputFutureValue(double principle, double rate,
            double period, double frequency) {
        double opening = 0;
        double closing = principle;
        double interest = 0;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        
        System.out.print("| Year Invested\t");
        System.out.print("| Opening Balance\t");
        System.out.print("| Interest Earned\t");
        System.out.print("| Closing Balance\t|\n");
        for (int i = 0; i < period; i++) {
            opening = closing;
            closing = opening * Math.pow((1 + (rate/frequency)),
                    frequency);
            interest = closing - opening;
            
            System.out.print("| " + (i + 1) + "\t\t");
            System.out.print("| " + currency.format(opening) + "\t\t");
            System.out.print("| " + currency.format(interest) + "\t\t");
            System.out.print("| " + currency.format(closing) + "\t\t|\n");
        }
    }
    
    
    
}
