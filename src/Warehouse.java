import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author THUAN ANH BUI
 *
 */
public class Warehouse {
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public void putIn(Item item) {
		itemList.add(item);
	}
	
	public ArrayList<Item> listItems() {
		return itemList;
	}
	
	/**
	 * Once the item is taken out of the warehouse, it is removed from the warehouse
	 * @param item
	 * @return
	 */
	public Item getItem(Item item) {
		Item returnedItem = null;
		for (Item it: itemList) {
			if (it == item) {
				returnedItem = it;
			}
		}
		itemList.remove(returnedItem);
		return returnedItem;
	}
}
