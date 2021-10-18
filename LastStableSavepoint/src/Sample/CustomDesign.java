package Sample;
import java.awt.Color;
import java.awt.Font;

public interface CustomDesign {

	static final Color Primary = Color.decode("#28264C"); // Black
	static final Color Secondary = Color.decode("#A40033"); // Red
	static final Color Tertiary = Color.decode("#959EC9"); // Violet Blue
	static final Color Text = Color.decode("#E8EAE7"); // White
	
	static final Color backgroundColor = Color.decode("#FFA458");
	static final Color color1 = Color.decode("#FFC89A");
	static final Color color2 = Color.decode("#FFF8F3");
	static final Color color3 = Color.decode("#FF8119");
	static final Color color4 = Color.decode("#FF7400");
	
	static final Font headerFont = new Font("Sans", Font.BOLD, 40); //2
	static final Font subheaderFont = new Font("Sans", Font.PLAIN, 18);
	static final Font textFont = new Font("Sans", Font.PLAIN, 15);
	static final Font tinyFont = new Font("Sans", Font.ITALIC, 10);
	
	
}
