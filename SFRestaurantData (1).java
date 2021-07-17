package project3;
import java.util.*;
import java.io.*;
/**
 * This class is the program performing SF Restaurant data search.
 * The program is interactive. 
 * When the program is executed the name of the input file containing the list of all the
 * SF Restaurants is provided as the program's single command line argument. The data in this file 
 * serves as a database of all the restaurants. 
 * In the interactive part, the user enters a name or a zip code of a restaurant. The program 
 * responds by printing all the restaurants that match either the name of the zip code.
 * 
 * @author Yi Yang
 *
 */
public class SFRestaurantData {
	/**
	 * The main method of the program.
	 * @param argsarray of Strings provided on the command line when the program is started; 
	 * the first string should be the name of the input file containing the list of restaurants. 
	 */
	public static void main(String[] args) {
		//verify that the command line argument exists 
		if (args.length == 0 ) {
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		//verify that command line argument contains a name of an existing file 
		File restaurantFile = new File(args[0]);
		if (!restaurantFile.exists()){
			System.err.println("Error: the file "+restaurantFile.getAbsolutePath()+" does not exist.\n");
			System.exit(1);
		}
		if (!restaurantFile.canRead()){
			System.err.println("Error: the file "+restaurantFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		//open the file for reading 
		Scanner inputRestaurants=null;
		try {
			inputRestaurants = new Scanner (restaurantFile ) ;
		} catch (FileNotFoundException e) {
			System.err.println("Error: the file "+restaurantFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		//read the content of the file and save the data in a list of restaurants
		RestaurantList list = new RestaurantList();
		ArrayList<String> lineStored = new ArrayList<>();
		ArrayList<String> splitLine = new ArrayList<String>();
		Restaurant current=null;
		Inspection current1=null;
		String line=null;
		String zip=null;
		String name=null;
		Date date=null;
		String address=null;
		String phone=null;
		int score=0;
		String violation=null;
		String risk=null;
		while (inputRestaurants.hasNextLine()) {
			try {
				line=inputRestaurants.nextLine();
				lineStored.add(line);
				int count=0;
				//Iterates through lineStored//
				for (String input : lineStored) {
					splitLine = splitCSVLine(lineStored.get(count));
					count++;
					//Iterates through splitLine//
					for (String input1 : splitLine) {
						//Gets values for each object//
						name=splitLine.get(1);
						zip=splitLine.get(5);
						address=splitLine.get(2);
						phone=splitLine.get(9);
						date= new Date (splitLine.get(11));
						score= Integer.parseInt(splitLine.get(12));
						violation=splitLine.get(15);
						risk=splitLine.get(16);
					}
				}
				
			}
			catch (NoSuchElementException ex ) {
				System.err.println(line);
			}
			try {
				current= new Restaurant (name, zip, address, phone);
				current1= new Inspection (date, score, violation, risk);
				current.addInspection(current1);
				list.add(current);
			}
			catch (IllegalArgumentException ex ) {
				//Do nothing and move on.//
			}
			
		}
		
		
		Scanner userInput = new Scanner (System.in);
		String userValue="";
		//interactive mode:
		do {
			System.out.println("Search the database by matching keywords to restaurant names or zip codes.");
			System.out.println("To search for matching restaurant names, enter");
			System.out.println("name KEYWORD");
			System.out.println("To search for matching zip codes, enter");
			System.out.println("zip KEYWORD");
			System.out.println("To finish the program, enter");
			System.out.println("quit");
			userValue = userInput.nextLine();
			int i = userValue.indexOf(' ');
			if (!userValue.equalsIgnoreCase("quit")) {
				
				if (userValue.substring(0, i).equalsIgnoreCase("name")) {
					RestaurantList res = list.getMatchingRestaurants(userValue.substring(i));
					
					System.out.println(res.toString()+"\n");
				}
				else if (userValue.substring(0, i).equalsIgnoreCase("zip")) {
					RestaurantList res = list.getMatchingZip(userValue.substring(i));
					System.out.println(res.toString()+"\n");
					}
					
				}
				else if (!(userValue.substring(0, i).equalsIgnoreCase("zip") || !(userValue.substring(0, i).equalsIgnoreCase("name"))))
						{
					System.out.println("This is not a valid query, try again!");
					continue;
				
				
		}
		}
	
		while (!userValue.equalsIgnoreCase("quit"));     
		
		userInput.close();
		
	}
	
	
	
	
	
	
	
	/**
	* Splits the given line of a CSV file according to commas and double quotes
	* (double quotes are used to surround multi-word entries so that they may contain commas)
	* @author Joanna Klukowska
	* @param textLine a line of text to be passed
	* @return an Arraylist object containing all individual entries found on that line
	*/
	public static ArrayList<String> splitCSVLine(String textLine){
		 
		if (textLine == null ) return null;

			ArrayList<String> entries = new ArrayList<String>();
			int lineLength = textLine.length();
			StringBuffer nextWord = new StringBuffer();
			char nextChar;
			boolean insideQuotes = false;
			boolean insideEntry= false;

			// iterate over all characters in the textLine
			for (int i = 0; i < lineLength; i++) {
					nextChar = textLine.charAt(i);

					// handle smart quotes as well as regular quotes
						if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') {

							// change insideQuotes flag when nextChar is a quote
								if (insideQuotes) {
									insideQuotes = false;
									insideEntry = false;
								}
								else {
									insideQuotes = true;
									insideEntry = true;
								}
						}
						else if (Character.isWhitespace(nextChar)) {
							if ( insideQuotes || insideEntry ) {
								// add it to the current entry
								nextWord.append( nextChar );
							}
							else { // skip all spaces between entries
								continue;
							}
						}
						else if ( nextChar == ',') {
							if (insideQuotes){ // comma inside an entry
								nextWord.append(nextChar);
							}
							else { // end of entry found
								insideEntry = false;
								entries.add(nextWord.toString());
								nextWord = new StringBuffer();
							}
						}
						else {
							// add all other characters to the nextWord
							nextWord.append(nextChar);
							insideEntry = true;
						}
				}
			// add the last word ( assuming not empty )
			// trim the white space before adding to the list
			if (!nextWord.toString().equals("")) {
				entries.add(nextWord.toString().trim());
			}

			return entries;
	}
	    
	
}
