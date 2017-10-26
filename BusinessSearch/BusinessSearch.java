import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BusinessSearch
{	
    /** 
     * sortBusinesses (File text)
     *
     * Method takes in a text file adds businesses from the text
     * file into an array.
     * 
     * Input:  A text file
     * Output: An array containing a list of businesses
     */ 
    public static String[] sortBusinesses(File text) throws IOException
    {
        // Create an array to hold the list of businesses from the text file
	String businessList[];
	// Number of businesses in the text file
	int count;
	// Name of business
	String name;
	BufferedReader input = new BufferedReader( new FileReader(text));
	name = input.readLine();
	count = Integer.parseInt(name);
	// Create a list of businesses with size of the integer from first line of text file
	businessList = new String[count];
	// Insert businesses into array
	for (int i = 0; i < count; i++)
	{
	    name = input.readLine();
	    businessList[i] = name;
	}
	input.close();
	return businessList;
    } 
	
    /** 
     * mergeSort(String[] nameList)
     *
     * Method takes in an array of businesses. It then splits the list in half and copies
     * it into two new arrays. It continues to do this until there is one business in each array.
     * It then calls merge(String[] firstHalf, String[] secondHalf, String[] contactList) to
     * rearrange the individual businesses in alphabetical order.
     *
     * Input:  A String array that contains a list of businesses
     * Output: A String array of alphabetically sorted businesses
     */ 
    public static String[] mergeSort(String[] nameList)
    {
        if (nameList.length <=1)
	{
	    return nameList;
	}
	String[] splitOne = new String[nameList.length / 2];
	String[] splitTwo = new String[nameList.length - splitOne.length];
	// Copy first half of list of businesses to new array
	System.arraycopy(nameList, 0, splitOne, 0, splitOne.length);
	// Copy Second half of list of businesses to new array
	System.arraycopy(nameList, splitOne.length, splitTwo, 0, splitTwo.length);
		
	mergeSort(splitOne);
	mergeSort(splitTwo);
	
	// Combine the two seperate sorted lists
	merge(splitOne, splitTwo, nameList);
	return nameList;
    }
	
    /** 
     * merge(String[] firstHalf, String[] secondHalf, String[] contactList)
     *
     * Method compares the restaurants from firstHalf and secondHalf and puts them into
     * contactList alphabetically. 
     * 
     * Input:  First half of array, Second half of array
     * Output: No ouput.
     */ 
    public static void merge(String[] firstHalf, String[] secondHalf, String[] contactList)
    {
        int firstHalfCount = 0;
	int secondHalfCount =  0;
	int resultCount = 0;
		
	while (firstHalfCount < firstHalf.length && secondHalfCount < secondHalf.length)
	{
	    // Compares the two String values alphabetically 
	    if (firstHalf[firstHalfCount].compareTo(secondHalf[secondHalfCount]) < 0)
            {
		contactList[resultCount++] = firstHalf[firstHalfCount++];
	    }
	    else
	    {
		contactList[resultCount++] = secondHalf[secondHalfCount++];
	    }
	}
		
	System.arraycopy(firstHalf, firstHalfCount, contactList, resultCount, firstHalf.length - firstHalfCount);
        System.arraycopy(secondHalf, secondHalfCount, contactList, resultCount, secondHalf.length - secondHalfCount);
    }
             
    /** 
     * binarySearch(String[] List, String restaurantName, int min, int max)
     *
     * Method searches for restaurantName in List to see if restaurant being searched exists in list.
     * It then returns the phone number of business if found and if not "NOT FOUND".
     * 
     * Input:  Sorted list of restaurants, name of restaurant being searched, 0, size of list of restaurants
     * Output: Returns the phone number of restaurantName input 
     */ 
    public static String binarySearch(String[] List, String restaurantName, int min, int max) 
    {
        if (min > max) 
	{
	    return "NOT FOUND";
	}
	
	int mid = (max + min) / 2;
	String[] temp = new String[2];
	for (int i = 0; i < 2; i++)
	{
	    temp = List[mid].split(",");
	}
	String restaurant = temp[0];    
	String phoneNumber = temp[1];    
	 
	// First letter of restaurant searched matches with first letter of resturant in middle of List array
	if (restaurantName.equalsIgnoreCase(restaurant)) 
	{
	    return phoneNumber;
	} 
	// Restaurant searched comes alphabeticaly before restaurant in middle of List array
	else if(restaurantName.compareTo(restaurant) < 0  ) 
	{
	    return binarySearch(List, restaurantName, min, mid - 1);
	} 
	// Restaurant searched comes alphabetically after restaurant in middle of List array
	else 
	{
	    return binarySearch(List, restaurantName, mid + 1, max);
	}
    }
	
    public static void main(String[] args) throws IOException
    {
        // Takes in file name
	File file = new File(args[0]);
	// Add businesses from file to array
	String businessArray[] = sortBusinesses(file);
	Scanner in = new Scanner(System.in);
	// Sort businesses alphabetically
	businessArray = mergeSort(businessArray);
	boolean isTrue = true;
	String phoneNumber = "";
	int notFoundCount = 0;
	int foundCount = 0;
	System.out.println("Enter a business name.");
		
	while (isTrue)
	{
	    String businessName = in.nextLine();
	    // Exit program
	    if (businessName.equals("") )
	    {
	        isTrue = false;
	    }
	    else
	    {
		// Search for phone number of business and print out if exists 
		phoneNumber = binarySearch(businessArray, businessName, 0, businessArray.length - 1);
		if (phoneNumber.equals("NOT FOUND"))
		{
		    notFoundCount++;
		}
		System.out.println(phoneNumber);
		foundCount++;
	    }
	}
        // Print out number of businesses found and not found.
	System.out.println(foundCount + " total queries, " + notFoundCount + " not found");
	in.close();
    }
}
