import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class RatingButton extends JRadioButton{
	
	private String id = "";
	
	public RatingButton(String compID) {
		this.id = compID;
	}
	
	public String getComponentID() {
		return this.id;
	}
	
	public void setComponentID(String newID) {
		this.id = newID;
	}
	
	public void deselect() {
		this.setSelected(false);
		
	}
	
	public void select() {
		this.setSelected(true);
	}
	
}
