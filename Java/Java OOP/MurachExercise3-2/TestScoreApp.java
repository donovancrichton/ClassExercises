import java.util.Scanner;
import java.text.NumberFormat;

public class TestScoreApp
{
    public static void main(String[] args)
    {
        // display operational messages
        System.out.println("Please enter test scores that range from 0 to 100.");
        System.out.println("To end the program enter 999.");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int testMax = 0;
		  int testMin = 0;
		  NumberFormat nf = NumberFormat.getInstance();
		  Scanner sc = new Scanner(System.in);

        // get a series of test scores from the user
        while (testScore <= 100)
        {
            // get the input from the user
            System.out.print("Enter score: ");
            testScore = sc.nextInt();
	
            // accumulate score count and score total and assign the min/max
            if (testScore <= 100)
            {
					 testMin = Math.min(testScore, testMin);
					 testMax = Math.max(testScore, testMax);
                scoreCount ++;
					 if (scoreCount == 1 ) {
						testMin = testScore;
					 } 
                scoreTotal += testScore;
            }
        }
		  // set the numberformat rounding place to 1 point
		  nf.setMaximumFractionDigits(1);
        
		  // display the score count, score total, and average score
        double averageScore = (double) scoreTotal / (double) scoreCount;
        String message = "\n"
					 + "Minimum score: " + testMin + "\n"
					 + "Maximum score: " + testMax + "\n"
                + "Score count:   " + scoreCount + "\n"
                + "Score total:   " + scoreTotal + "\n"
                + "Average score: " + nf.format(averageScore) + "\n";
        System.out.println(message);
    }
}
