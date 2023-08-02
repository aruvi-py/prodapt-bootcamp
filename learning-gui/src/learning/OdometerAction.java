package learning;

public enum OdometerAction {
	
	INCREMENT ("Increment"),
	DECREMENT ("Decrement"),
	RESET ("Reset"),
	RESIZE("Resize");
	
	private String label;
	
	private OdometerAction(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return label;
	}

}
