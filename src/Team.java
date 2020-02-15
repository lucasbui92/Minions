import java.util.ArrayList;

/**
 * This class Team is responsible for storing all minions and all the attributes and functionality
 * a Team object can do to the minions.
 * 
 * @author THUAN ANH BUI
 *
 */
public class Team {
	
	private ArrayList<Minion> minions = new ArrayList<>();
	
	/**
	 * Empty constructor
	 */
	public Team() {
		
	}
	
	/**
	 * This method adds a minion to the list of minions.
	 * 
	 * @param minion
	 */
	public void addMinion(Minion minion) {
		minions.add(minion);
	}
	
	/**
	 * This method removes a minion from the list.
	 * 
	 * @param minion
	 */
	public void removeMinion(Minion minion) {
		minions.remove(minion);
	}
	
	/**
	 * This method returns the list containing the minions.
	 * 
	 * @return the list of minions stored in the ArrayList
	 */
	public ArrayList<Minion> getMinionList() {
		return minions;
	}
	
	/**
	 * This method returns the total number of minions based on a particular skill.
	 * 
	 * @param skill of MinionSkill enum type
	 * @return Integer value representing the total number of minions
	 */
	public int getNumMinionsOfSkill(MinionSkill skill) {
		int numMinions = 0;
		
		for (Minion m : minions) {
			if (m.hasSkill(skill) == true) {
				numMinions += 1;
			}
		}
		return numMinions;
	}
}
