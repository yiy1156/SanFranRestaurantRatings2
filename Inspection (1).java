package project3;
/**
 * This class represents an inspection. 
 * It represents inspections with information regarding the date, the inspection
 * score, as well as the violation and risk level.
 * 
 * 
 * @author Yi Yang
 *
 */
public class Inspection {
	private Date date;
	private int score;
	private String violation;
	private String risk;
	/**
	 * Constructs an Inspection Object with a specific date, score, violation and risk
	 * @param date the date of the inspection, should be in MM/DD/YY or MM/DD/YYYY format
	 * @param score the score of said inspection, should be an int value
	 * @param violation the violation found in the inspection
	 * @param risk the risk found in the inspection
	 * @throws IllegalArgumentException if the date is null or if the score is not 
	 * between 0-100
	 */
	public Inspection (Date date, int score, String violation, String risk) throws IllegalArgumentException {
		if (date.equals(null))
			throw new IllegalArgumentException("Invalid date.");
		if (score<0 || score>100)
			throw new IllegalArgumentException("Invalid score.");
		else
			this.date=date;
			this.score=score;
			this.violation=violation;
			this.risk=risk;
	}
	/**
	 * Returns the date of the Inspection.
	 * @return the date of the Inspection object.
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Returns the score of the Inspection.
	 * @return the score of the Inspection object.
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Returns the violation found in the Inspection.
	 * @return the violation found in the Inspection object.
	 */
	public String getViolation() {
		return violation;
	}
	/**
	 * Returns the risk found in the Inspection.
	 * @return the risk found in the Inspection object.
	 */
	public String getRisk() {
		return risk;
	}
 }
