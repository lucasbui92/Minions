import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The LairLocation class is obliged to store detail of the location. It also computes the salary of all minions
 * in the team and checks if team satisfies all the conditions before the method in Lair can add team to a location.
 * 
 * @author THUAN ANH BUI
 *
 */
public class LairLocation {
	private String locName;
	private String locDetail;
	Map<MinionSkill, Integer> locMap;
	Team team = new Team();
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	/**
	 * The constructor is responsible for storing name and description of the location of the lair.
	 * 
	 * @param locationName
	 * @param locDescription
	 */
	public LairLocation(String locationName, String locDescription) {
		locName = locationName;
		locDetail = locDescription;
		locMap = new HashMap<>();
	}
	
	/**
	 * This constructor contains an extra parameter for storing the requirement for a team used as a Map.
	 * 
	 * @param locationName
	 * @param locDescription
	 * @param map
	 */
	public LairLocation(String locationName, String locDescription, Map<MinionSkill, Integer> map) {
		locName = locationName;
		locDetail = locDescription;
		locMap = map;
	}
	
	/**
	 * This method returns the name and description of the location.
	 * 
	 * @return a String value
	 */
	public String description() {
		return locName + ": " + locDetail;
	}
	
	/**
	 * This method throws an exception if the method within it returns false value thus no team is generated.
	 * 
	 * @param team
	 */
	public void assignTeam(Team team) {
		if (isValidTeam(team) == false) {
			this.team = null;
			throw new IllegalArgumentException("Team violates the conditions");
		}
		else {
			this.team = team;
		}
	}
	
	/**
	 * This method returns a team object.
	 * 
	 * @return team as an object of Team class
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * This method calculates and sum up the total amount of salary from each minion in a team.
	 * 
	 * @return an integer value for total amount of salary
	 */
	public int calculateMonthlyPayRoll() {
		int payRoll = 0;
		
		for (int i = 0; i < team.getMinionList().size(); i++) {
			payRoll += team.getMinionList().get(i).monthlyPay();
		}
		return payRoll;
	}
	
	/**
	 * This method requires a team to pass each condition for it to return true. If it fails in any steps,
	 * a false value is returned.
	 * 
	 * @param team
	 * @return Boolean value indicating whether team is valid or not
	 */
	public boolean isValidTeam(Team team) {
		int researchCount = 0;
		int supportCount = 0;
		
		if (team.getMinionList().size() < 1) {
			return false;
		}
		
		for (int i = 0; i < team.getMinionList().size(); i++) {
			if (team.getMinionList().get(i) instanceof Researcher) {
				researchCount += 1;
			}
			else if (team.getMinionList().get(i) instanceof SupportStaff) {
				supportCount += 1;
			}
		}
		if (researchCount > supportCount) {
			return false;
		}
		
		for (Map.Entry<MinionSkill, Integer> entry : locMap.entrySet()) {
			if (team.getNumMinionsOfSkill(entry.getKey()) < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	public void putItemInList(Item item) {
		if (item instanceof Trap) {
			if (locMap.size() < 2) {
				throw new IllegalArgumentException("Item cannot be added");
			}
		}
		else if (item instanceof Equipment) {
			if (locMap.size() < 1) {
				throw new IllegalArgumentException("Item cannot be added");
			}
		}
		itemList.add(item);
	}
	
	public void removeEquipments() {
		//is it necessary to specify this method for Equipment only since Trap cannot be removed
		Iterator<Item> itr = itemList.iterator();
	      
		while(itr.hasNext()) {
			Item item = itr.next();
			if (item instanceof Equipment) {
				itr.remove();
			}
			else if (item instanceof Trap) {
				((Trap) item).setTrapStatus(false);
			}
		}
	}
	
	public void removeEquipments(Item item) {
		itemList.remove(item);
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
}
