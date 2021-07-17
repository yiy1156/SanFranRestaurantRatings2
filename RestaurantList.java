package project3;
/**
 * RestaurantList class is used to store a collection of Restaurant objects. 
 * This class inherits all of its properties from an LinkedList<Restaurant>. It 
 * adds Restaurant-specific functions that allow search by restaurant name and zip
 * 
 * This class stores Restaurant objects in the natural order of elements. 
 * 
 * @author Yi Yang
 *
 */



public class RestaurantList extends LinkedList<Restaurant> {
	/**
	 * Constructs a RestaurantList object.
	 */
	public RestaurantList() {
		
	}
	/**
	 * Search through the list of Restaurant objects for a name matching the 
	 * given keyword
	 * @param keyword the name of the Restaurant to search
	 * @return the list of all restaurants with matching names,or null
	 * if none found.
	 */
	public RestaurantList getMatchingRestaurants(String keyword) {
		/*Creates a list that contains just matching restaurant names.*/
		RestaurantList matchingNameList = new RestaurantList();
		/*Iterates through Restaurant. */
		for (Restaurant res : this ) {
			String name = res.getName();
			if (name == null) 
				/*Returns null if the name is null.*/
				return null; 
			if (name.equalsIgnoreCase( keyword ) ) 
				/*When matching names are found, they are added the list of matching restaurants.*/
				matchingNameList.add(res);
			/*Sorts the list in natural order.*/
			matchingNameList.sort();
			/*Returns the list of all matching restaurants.*/
			return matchingNameList;
		}
		return null; 
	}
	/**
	 * Search through the list of Restaurant objects for a zip code matching the 
	 * given keyword
	 * @param keyword the zip code of the Restaurant to search
	 * @return the list of all restaurants with matching zip codes,or null
	 * if none found.
	 */
	public RestaurantList getMatchingZip(String keyword) {
		/*Creates a list that contains just matching restaurant zip codes.*/
		RestaurantList matchingZipList = new RestaurantList();
		/*Iterates through Restaurant. */
		for (Restaurant res : this ) {
			String zip = res.getZip();
			if (zip == null) 
				/*Returns null if the zip code is null.*/
				return null; 
			if (zip.equalsIgnoreCase( keyword ) ) 
				/*When matching zip codes are found, 
				 * they are added the list of matching restaurants.*/
				matchingZipList.add(res);
			/*Sorts the list in natural order.*/
			matchingZipList.sort();
			/*Returns the list of all matching restaurants.*/
			return matchingZipList;
		}
		return null;
	}
	/**
	 * Returns the string representation of the RestaurantList.
	 * @return the string representation of the RestaurantList
	 */
	public String toString() {
		StringBuilder restaurantsMatched = new StringBuilder();
		for (Restaurant r : this) {
			restaurantsMatched.append(r.getName()+"; ");
		}
		return restaurantsMatched.toString();
	}
}
