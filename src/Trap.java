
public class Trap extends Item {
	private boolean enabled = true;

	public Trap(String itemType, String itemDescription) {
		super(itemType, itemDescription);
	}
	
	protected String description() {
		if (enabled == true) {
			return super.description();
		}
		return super.description() + " (disabled)";
	}
	
	protected void setTrapStatus(boolean value) {
		enabled = value;
	}
}
