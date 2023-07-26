package yahtzee;

public class YahtzeeDie extends Die {
	
	public boolean isFrozen;
	
	public YahtzeeDie() {
		super();
		this.isFrozen = false;
	}
	
	@Override
	public String toString() {
		return super.show() + (isFrozen ? "(frozen)" : "(not frozen)");
	}

}
