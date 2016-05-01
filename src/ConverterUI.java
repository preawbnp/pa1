import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * 
 * Make the program form JFrame for convert unit
 * @author Budnampetch Onmee
 *
 */
public class ConverterUI extends JFrame{
	/**
	 * Component of display window
	 */
	private JButton converterButton, clearButton;
	private Container container, containerA, containerB;
	private UnitConverter converter;
	private JComboBox<Unit> unitCombobox1;
	private JComboBox<Unit> unitCombobox2;
	private JTextField textFieldLeft, textFieldRight;
	private JLabel equals;
	private JRadioButton leftButton, rightButton;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;

	/**
	 * Set title of display window and run order component in initComponents method.
	 * @param uc converter the units of length from UnitConverter class.
	 */
	public ConverterUI (UnitConverter uc){
		this.converter = uc;
		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * Order component of display window
	 */
	private void initComponents(){
		container = new Container();
		containerA = new Container();
		containerB = new Container();
		this.add(container);
		this.add(containerA);
		this.add(containerB);
		container.setLayout(new GridLayout(3,1));
		
		menuBar = new JMenuBar();
		menu = new JMenu("Unit Type");
		menu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(menu);
	    container.add(menuBar);
	    
		containerA.setLayout(new FlowLayout());
		containerB.setLayout(new FlowLayout());
		container.add(containerA);
		container.add(containerB);

		converterButton = new JButton("Convert");		
		textFieldLeft = new JTextField(7);

		unitCombobox1 = new JComboBox<Unit>();
		Unit[] lengths1 = converter.getUnits();
		for (Unit u : lengths1)
			unitCombobox1.addItem(u);
		unitCombobox1 = new JComboBox<Unit>(lengths1);

		equals = new JLabel("=");
		textFieldRight = new JTextField(7);

		unitCombobox2 = new JComboBox<Unit>();
		Unit[] lengths2 = converter.getUnits();
		for (Unit u : lengths2)
			unitCombobox2.addItem(u);
		unitCombobox2 = new JComboBox<Unit>(lengths2);

		clearButton = new JButton("Clear");		

		containerA.add(textFieldLeft);
		containerA.add(unitCombobox1);
		containerA.add(equals);
		containerA.add(textFieldRight);
		containerA.add(unitCombobox2);
		containerA.add(converterButton);

		containerA.add(clearButton);
		/**
		 * Add actionListener is perform an action when user select it.
		 * Set all JTextField to empty and can editable in JTextField.
		 */
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textFieldLeft.setText("");			
				textFieldRight.setText("");
				textFieldLeft.setEditable(true);
				textFieldRight.setEditable(true);
			}
		});

		String leftString = "Left -> Right";
		leftButton = new JRadioButton(leftString);
		leftButton.setActionCommand(leftString);
		/**
		 *  Add actionListener is perform an action when user select it,
		 *  if user select this button user can edit textFieldLeft.
		 *  But can not edit textFieldRight. 
		 *  And user must select leftButton or rightButton in one time.
		 */
		leftButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Left to Right");
				textFieldLeft.setEditable(true);
				textFieldRight.setEditable(false);
				leftButton.setSelected(true);
				rightButton.setSelected(false);
			}
		});

		String rightString = "Right -> Left";
		rightButton = new JRadioButton(rightString);
		rightButton.setActionCommand(rightString);
		/**
		 *  Add actionListener is perform an action when user select it,
		 *  if user select this button user can edit textFieldRight.
		 *  But can not edit textFieldLeft. 
		 *  And user must select leftButton or rightButton in one time.
		 */
		rightButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Right to Left");
				textFieldLeft.setEditable(false);
				textFieldRight.setEditable(true);
				leftButton.setSelected(false);
				rightButton.setSelected(true);
			}
		});
		containerB.add(leftButton);
		containerB.add(rightButton);		

		/**
		 *  Add actionListener is perform an action when user select it.
		 *  Display will show current value.
		 */
		converterButton.addActionListener(new ActionListener(){
			String text = null;
			public void actionPerformed(ActionEvent e){
				if (textFieldLeft.isEditable())
					text = textFieldLeft.getText().trim();
				else if (textFieldRight.isEditable())
					text = textFieldRight.getText().trim();
				System.out.println("ActionPerformed: input = " + text);
				try {
					if (text.length() > 0) {
						double value = Double.valueOf(text);
						Unit getComboBoxLeft = (Unit) unitCombobox1.getSelectedItem();
						Unit getComboBoxRight = (Unit) unitCombobox2.getSelectedItem();
						if(textFieldLeft.isEditable())
							textFieldRight.setText(String.valueOf(String.format("%.4f",(converter.convert(value,getComboBoxLeft,getComboBoxRight)))));
						else if(textFieldRight.isEditable())
							textFieldLeft.setText(String.valueOf(String.format("%.4f",(converter.convert(value, getComboBoxRight,getComboBoxLeft)))));
					}
				} catch (NumberFormatException exception){
					System.out.println("Not a number! Please input number.");
				}
			}

			public void keyPressed(KeyEvent evt) {
				if (textFieldLeft.isEditable())
					text = textFieldLeft.getText().trim();
				else if (textFieldRight.isEditable())
					text = textFieldRight.getText().trim();
				System.out.println("ActionPerformed: input = " + text);
				try {
					if (text.length() > 0) {
						double value = Double.valueOf(text);
						Unit getComboBoxLeft = (Unit) unitCombobox1.getSelectedItem();
						Unit getComboBoxRight = (Unit) unitCombobox2.getSelectedItem();
						if (textFieldLeft.isEditable())
							textFieldRight.setText(String.valueOf(String.format("%.4f", (converter.convert(value,getComboBoxLeft, getComboBoxRight)))));
						else if (textFieldRight.isEditable())
							textFieldLeft.setText(String.valueOf(String.format("%.4f", (converter.convert(value, getComboBoxRight, getComboBoxLeft)))));
					}
				} catch (NumberFormatException exception){
					System.out.println("Not a number! Please input number.");
				}
			}
		});
		
		getContentPane().add(container);
		this.pack();
	}
	public void run(){
		setVisible(true);
	}
	public static void main(String [] arg){
		UnitConverter uc = new UnitConverter();
		ConverterUI display = new ConverterUI(uc);
		display.run();
	}
}