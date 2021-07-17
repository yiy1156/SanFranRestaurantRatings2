package project3;
/**
 * This class represents a date. 
 * It represents dates in MM/DD/YY format or MM/DD/YYYY format.
 * 
 * @author Yi Yang
 *
 */
public class Date implements Comparable<Date>  {
	private String date;
	private int month;
	private int day;
	private int year;
	/**
	 * Constructs a new Date object with string value. 
	 * @param date, date in MM/DD/YY or MM/DD/YYYY format
	 * @throws IllegalArgumentException if the name is empty or if it is null or 
	 * if it does not fit either format
	 */
	public Date (String date) throws IllegalArgumentException{
		if (date.equals(null)||date.equals(""))
			throw new IllegalArgumentException("Invalid date.");
		else if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")==false)
			throw new IllegalArgumentException("Invalid date.");
		else if (date.matches("\\d{2}/\\d{2}/\\d{2}")==false)
			throw new IllegalArgumentException("Invalid date.");
		else
			this.date=date;
	}
	/**
	 * Constructs a new Date object with a month, day, and year value.
	 * @param month, the month in int of the date
	 * @param day, the day in int of the date
	 * @param year, the year in int of the date
	 * @throws IllegalArgumentException if the year is not between 2000 and 2025, or if the month is not
	 * between 1 and 12, or if there are too many days in that specific month, or if the day is
	 * smaller than 1
	 */
	public Date (int month, int day, int year) throws IllegalArgumentException {
		if (month< 1 || month>12) {
			throw new IllegalArgumentException("Invalid month.");
		}
		else 
			this.month=month;
			
		if (year<2000 || year>2025) {
			throw new IllegalArgumentException("Invalid year.");
		}
		else if (year>25 && year<2000) {
			throw new IllegalArgumentException("Invalid year.");
		}
		else if (year<25) {
			year+=2000;
		}
		else
			this.year=year;
			
		
		if (day<1) {
			throw new IllegalArgumentException("Invalid day.");
		}
	
		else if (year==2000 || year==2004 || year==2008 || year==2012 || year==2016
				|| year==2020 || year==2024) {
			if (month==2) {
				if (day>29 || day<1)
					throw new IllegalArgumentException("Invalid day.");
				else
					this.day=day;
			}
			else if (month==1 || month==3 || month==5 || month==7 || month==8
					|| month==10 || month==12) {
				if (day>31 || day<1) 
					throw new IllegalArgumentException("Invalid day.");
				else 
					this.day=day;
			}
			else {
				if (day>30 || day<1)
					throw new IllegalArgumentException("Invalid day.");
				else
					this.day=day;
			}
				
					
		}
		else
			if (month==2) {
				if (day>28 || day<1)
					throw new IllegalArgumentException("Invalid day.");
				else
					this.day=day;
			}
			else if (month==1 || month==3 || month==5 || month==7 || month==8
					|| month==10 || month==12) {
				if (day>31 || day<1) 
					throw new IllegalArgumentException("Invalid day.");
				else 
					this.day=day;
			}
			else {
				if (day>30 || day<1)
					throw new IllegalArgumentException("Invalid day.");
				else
					this.day=day;
			}
	}
	/**
	 * Returns the date representing the Date object.
	 * @return the date representing the Date object
	 */
	public String getDate () {
		return date;
	}
	/**
	 * Returns the month of this Date object.
	 * @return the month of this Date object
	 */
	public int getMonth () {
		return month;
	}
	/**
	 * Returns the year of this Date object.
	 * @return the year of this Date object
	 */
	public int getYear () {
		return year;
	}
	/**
	 * Returns the day of this Date object.
	 * @return the day of this Date object
	 */
	public int getDay () {
		return day;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Date date1) {
		if (this.year<date1.year)
			return -1;
		else if (this.year>date1.year)
			return 1;
		else 
			if (this.month<date1.month)
				return -1;
			else if (this.month>date1.month)
				return 1;
			else
				if (this.day<date1.day)
					return -1;
				else if (this.day>date1.day)
					return 1;
				else
					return 0;
	}
	/**
	 * Returns the string representation of this Date.
	 * @returns the string representation of this Date object 
	 */
	public String toString() {
		return String.format("%02d/%02d/%04d", getMonth(), getDay(), getYear());
	}
}
