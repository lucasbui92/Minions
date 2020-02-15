import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Lair class is responsible for creating new lair locations, adding teams containing different
 * minions to those locations. It also displays output into the console.
 * 
 * @author THUAN ANH BUI
 *
 */
public class Lair {
	
	private ArrayList<LairLocation> lairLocList = new ArrayList<>();
	private Map<MinionSkill, Integer> map = new HashMap<>();
	private Map<MinionSkill, Integer> map1 = new HashMap<>();
	private Warehouse warehouse = new Warehouse();
	
	/**
	 * This method calls in other methods responsible for creating and generating the output
	 * to be shown in the console.
	 */
	public void printStatus() {
		System.out.println("Welcome to the Supervillian's Lair Management System.");
		createLairLocations();
		createItems();
		createMinions();
		//testTask2MoveItemsLocToLoc();
		//testTask3(lairLocList.get(0).getTeam());
		displayLairLocations();
		//displayWage();
		System.out.println();
		System.out.println("Good-bye. Thank you for using the Supervillian's Lair Management System.");
	}
	
	/**
	 * This method generates new locations and put in the number of skills needed to be stored in a map.
	 */
	public void createLairLocations() {
		map.put(MinionSkill.PSYCHOLOGY, 1);
		map.put(MinionSkill.CRYPTOGRAPHY, 2);
		map1.put(MinionSkill.CRYPTOGRAPHY, 1);
		
		LairLocation loc1 = new LairLocation("Shark Tank", "Full of sharks with laser beams on their heads", map);
		LairLocation loc2 = new LairLocation("Magneto", "Magnetism manipulation", map1);
		LairLocation loc3 = new LairLocation("Mystique", "Shapeshifting", map);
		LairLocation loc4 = new LairLocation("Apocalypse", "Ancient power with a devastating consequence", map);
		
		lairLocList.add(loc1);
		lairLocList.add(loc2);
		lairLocList.add(loc3);
		lairLocList.add(loc4);
	}
	
	/**
	 * This method displays output in order.
	 */
	public void displayLairLocations() {
		for (int i = 0; i < lairLocList.size(); i++) {
			System.out.println();
			System.out.println(lairLocList.get(i).description());
			
			System.out.println("**Assigned Minions:");
			if (lairLocList.get(i).getTeam() != null) {
				for (Minion mi: lairLocList.get(i).getTeam().getMinionList()) {
					System.out.println(mi.description());
				}
				System.out.println("Total payroll: $" + lairLocList.get(i).calculateMonthlyPayRoll());
			}
			
			System.out.println("**Items:");
			for (Item it: lairLocList.get(i).getItemList()) {
				System.out.println(it.description());
			}
		}
	}
	
	/**
	 * This method enables the team and minion creation. It first needs to check if the minion and team satisfy
	 * the constraint conditions before they are generated and added.
	 */
	public void createMinions() {
		//String id = readString("Enter ID: ");
		Team team1 = new Team();
		Team team2 = new Team();
		
		try {
			Minion mi1 = new Researcher("A2345678", "Mini", "Me");
			
			mi1.addSkill(MinionSkill.PSYCHOLOGY);
			mi1.addSkill(MinionSkill.SCUBA);
			mi1.addSkill(MinionSkill.CRYPTOGRAPHY);
			team1.addMinion(mi1);
			team2.addMinion(mi1);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Minion mi2 = new SupportStaff("B2345678", "Chum", "Berley");
			
			mi2.addSkill(MinionSkill.PSYCHOLOGY);
			mi2.addSkill(MinionSkill.CRYPTOGRAPHY);
			team1.addMinion(mi2);
			lairLocList.get(0).assignTeam(team1);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Minion mi3 = new SupportStaff("C2345678", "Donna", "Matrix");
			
			mi3.addSkill(MinionSkill.CRYPTOGRAPHY);
			team2.addMinion(mi3);
			lairLocList.get(1).assignTeam(team2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createItems() {
		Item trap1 = new Trap("Trap", "Cage");
		Item trap2 = new Trap("Trap", "Mirror Entity");
		Item equip1 = new Equipment("Equipment", "Crossbow");
		Item equip2 = new Equipment("Equipment", "Spear");
		warehouse.putIn(trap1);
		warehouse.putIn(trap2);
		warehouse.putIn(equip1);
		warehouse.putIn(equip2);
		addItem(lairLocList.get(0), warehouse.getItem(trap1));
		addItem(lairLocList.get(0), warehouse.getItem(trap2));
		addItem(lairLocList.get(0), warehouse.getItem(equip2));
		addItem(lairLocList.get(1), warehouse.getItem(equip1));
	}
	
	/**
	 * Use privately for createItems method to check if an item can be added to a location. If there are enough skills
	 * in that location
	 * 
	 * @param la
	 * @param i
	 */
	private void addItem(LairLocation la, Item i) {
		try {
			la.putItemInList(i);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * When an item is taken out from the location, it is checked if it is an equipment
	 * It is removed from the location and put in another location
	 */
	private void testTask2MoveItemsLocToLoc() {
		ArrayList<Item>itemList = lairLocList.get(1).getItemList();
		Item itemRemoved = itemList.get(0);
		//System.out.println(itemList.get(0).description());
		if (itemRemoved instanceof Equipment) {
			lairLocList.get(1).removeEquipments(itemRemoved);
			lairLocList.get(0).putItemInList(itemRemoved);
		}
	}
	
	/**
	 * Pick a minion and remove its skill, reassign that them to check if team is still valid. If not, 
	 * catch the exception and remove all equipments inside that location and disable all traps
	 * 
	 * @param team
	 */
	private void testTask3(Team team) {
		//System.out.println(team2.getMinionList().get(0).hasSkill(MinionSkill.CRYPTOGRAPHY));
		//System.out.println(team2.getMinionList().get(0).hasSkill(MinionSkill.CRYPTOGRAPHY));
		try {
			team.getMinionList().get(0).removeSkill(MinionSkill.CRYPTOGRAPHY);
			lairLocList.get(0).assignTeam(team);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			lairLocList.get(0).removeEquipments();
		}
	}
	
	/**
	 * This method tests and print the result of a specific minion's pay.
	 */
	public void displayWage() {
		System.out.println(lairLocList.get(0).getTeam().getMinionList().get(0).monthlyPay());
	}
	
	private String readString(String prompt) {
		System.out.print(prompt);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

}
