import java.io.File;
import java.util.Scanner;

public class minNumRequired
{
	public static void main(String[] args) throws Exception
	{
                // File input
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		
		// Number of people currently running
		int currCount = 0; 
		// Total number of people that need added so people will join
		int countAdded= 0;
		
		while ( in.hasNextLine() )
		{
			// Minimum number of people that need to be running for people to join
			int minNumber = in.nextInt();
			// Number of people that will join each round
			int joined = in.nextInt();
			// Number of people added each row of input
			int roundAdded = 0;
			
			if  (minNumber == 0)
			{
				currCount += joined;
			}
			else
			{
				if (currCount < minNumber)
				{
					roundAdded = minNumber - currCount;
					countAdded += roundAdded; 
					currCount += roundAdded + joined;
				}
				else
				{
					currCount += joined;
				}
			}
		}
		in.close();
		System.out.println("Out: " + countAdded);
	}
}
