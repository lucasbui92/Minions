
/**
 * This class SupportStaff is a subclass of Minion defining specific characteristics such as
 * different pay amount.
 * 
 * @author THUAN ANH BUI
 *
 */
public class SupportStaff extends Minion {

	/**
	 * This constructor inherits the body of the superclass Minion.
	 * 
	 * @param newSupportStaffId
	 */
	public SupportStaff(String newSupportStaffId) {
		super(newSupportStaffId);
	}
	
	/**
	 * This constructor inherits the body of the superclass Minion.
	 * 
	 * @param newSupportStaffId
	 * @param newGivenName
	 * @param newFamilyName
	 */
	public SupportStaff(String newSupportStaffId, String newGivenName, String newFamilyName) {
		super(newSupportStaffId, newGivenName, newFamilyName);
	}

	/**
	 * This method calculates the pay for the SupportStaff and returns that amount.
	 * 
	 * @return Integer value representing the pay amount
	 */
	public int monthlyPay() {
		int totalWage = 0;
		
		totalWage = 3000 + 500 * setSkills.size();
		return totalWage;
	}
}
