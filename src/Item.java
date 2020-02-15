
/**
 * 
 * @author THUAN ANH BUI
 *
 */
public abstract class Item {
	private String itemType;
	private String itemDescription;
	
	public Item (String itemType, String itemDescription) {
		if (itemType == "Equipment" || itemType == "Trap") {
			this.itemType = itemType;
		}
		else {
			throw new IllegalArgumentException("This is not a valid item");
		}
		this.itemDescription = itemDescription;
	}
	
	protected String description() {
		return this.itemDescription + ": " + this.itemType;
	}
}
