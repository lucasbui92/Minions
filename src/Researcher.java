
/**
 * This class Researcher is a subclass of Minion defining specific characteristics such as
 * different pay amount.
 * 
 * @author THUAN ANH BUI
 *
 */
public class Researcher extends Minion {

	/**
	 * This constructor inherits the body of the superclass Minion.
	 * 
	 * @param newResearcherId
	 */
	public Researcher(String newResearcherId) {
		super(newResearcherId);
	}
	
	/**
	 * This constructor inherits the body of the superclass Minion.
	 * 
	 * @param newResearcherId
	 * @param newGivenName
	 * @param newFamilyName
	 */
	public Researcher(String newResearcherId, String newGivenName, String newFamilyName) {
		super(newResearcherId, newGivenName, newFamilyName);
	}

	/**
	 * This method calculates the pay for the Researcher and returns that amount.
	 * 
	 * @return Integer value representing the pay amount
	 */
	public int monthlyPay() {
		int skillNum = 3;
		int totalWage = 5000;
		
		if (setSkills.size() >= skillNum) {
			totalWage *= 2;
		}
		return totalWage;
	}
}
