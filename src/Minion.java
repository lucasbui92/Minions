import java.util.ArrayList;

/**
 * The class Minion stores information of the minion, enables methods that can modify the minions and checks
 * for the valid minion ID.
 * 
 * @author THUAN ANH BUI
 *
 */
public abstract class Minion {
	/* String type can capture both characters and numbers, while int type can only capture numbers. It is
	 * applicable in the case of phone numbers. 
	 */
	protected String minionId;
	protected String givenName;
	protected String familyName;
	protected final int MAX_ID_LENGTH = 8;
	
	ArrayList<MinionSkill> setSkills = new ArrayList<MinionSkill>();
	
	/**
	 * This constructor checks for a valid minion ID before the minion can be assigned in Lair class.
	 * 
	 * @param newMinionId
	 */
	public Minion(String newMinionId) {
		if (newMinionId.length() != MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if ((int)newMinionId.charAt(0) < 65 || (int)newMinionId.charAt(0) > 90) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			for (int i = 1; i < MAX_ID_LENGTH; i++) {
				if (newMinionId.charAt(i) > '9') {
					throw new IllegalArgumentException("Invalid ID");
				}
			}
			minionId = newMinionId;
		}
	}
	
	/**
	 * This constructor checks for a valid minion ID before the minion can be assigned in Lair class
	 * and enable last name and first name to be created.
	 * 
	 * @param newMinionId
	 * @param newGivenName
	 * @param newFamilyName
	 */
	public Minion(String newMinionId, String newGivenName, String newFamilyName) {
		if (newMinionId.length() != MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if ((int)newMinionId.charAt(0) < 65 || (int)newMinionId.charAt(0) > 90) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			for (int i = 1; i < MAX_ID_LENGTH; i++) {
				if (newMinionId.charAt(i) > '9') {
					throw new IllegalArgumentException("Invalid ID");
				}
			}
			minionId = newMinionId;
			givenName = newGivenName;
			familyName = newFamilyName;
		}
	}
	
	/**
	 * This method modifies the given name of the minion.
	 * 
	 * @param givenName
	 */
	protected void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * This method modifies the last name of the minion.
	 * 
	 * @param familyName
	 */
	protected void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**
	 * This method returns a string value with the minion's full name and ID.
	 * 
	 * @return String value for each minion
	 */
	protected String description() {
		return minionId + " " + givenName + " " + familyName;
	}
	
	/**
	 * This method adds a new skill to a minion unless not present in the its list of skills.
	 * 
	 * @param skill
	 */
	protected void addSkill(MinionSkill skill) {
		if (hasSkill(skill) != true) {
			setSkills.add(skill);
		}
	}
	
	protected void removeSkill(MinionSkill skill) {
		setSkills.remove(skill);
	}
	
	/**
	 * This method returns result if a certain skill is in the list
	 * 
	 * @param skill
	 * @return Boolean value
	 */
	protected Boolean hasSkill(MinionSkill skill) {
		return setSkills.contains(skill);
	}
	
	/**
	 * This method provides an interface for subclass to use for their respective purposes.
	 * 
	 * @return
	 */
	protected abstract int monthlyPay();
}
