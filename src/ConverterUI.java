import java.awt.Color;
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
	private JComboBox<Unit> unitCombobox1 = new JComboBox<Unit>();
	private JComboBox<Unit> unitCombobox2 = new JComboBox<Unit>();
	private JTextField textFieldLeft, textFieldRight;
	private JLabel equals;
	private JRadioButton leftButton, rightButton;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem lengthItem, weightItem, areaItem, timeItem, exitItem;

	/**
	 * Set title of display window and run order component in initComponents method.
	 * @param uc converter the units of length from UnitConverter class.
	 */
	public ConverterUI (UnitConverter uc){
		this.converter = uc;
		this.setTitle("Unit Converter");
		this.setSize(700, 150);
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

		lengthItem = new JMenuItem("Length");
		lengthItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unitCombobox1.removeAllItems();
				unitCombobox2.removeAllItems();
				changeUnitType(UnitType.Length);
				setSize(700, 150);
			}
		});
		weightItem = new JMenuItem("Weight");
		weightItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unitCombobox1.removeAllItems();
				unitCombobox2.removeAllItems();
				changeUnitType(UnitType.Weight);
				setSize(700, 150);
			}
		});
		areaItem = new JMenuItem("Area");
		areaItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unitCombobox1.removeAllItems();
				unitCombobox2.removeAllItems();
				changeUnitType(UnitType.Area);
				setSize(700, 150);
			}
		});
		timeItem = new JMenuItem("Time");
		timeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unitCombobox1.removeAllItems();
				unitCombobox2.removeAllItems();
				changeUnitType(UnitType.Time);
				setSize(700, 150);
			}
		});
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		menuBar.add(menu);
		container.add(menuBar);

		menu.add(lengthItem);
		menu.add(weightItem);
		menu.add(areaItem);
		menu.add(timeItem);
		menu.add(exitItem);

		containerA.setLayout(new FlowLayout());
		containerB.setLayout(new FlowLayout());
		container.add(containerA);
		container.add(containerB);

		converterButton = new JButton("Convert");		
		textFieldLeft = new JTextField(7);

		equals = new JLabel("=");
		textFieldRight = new JTextField(7);

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
						textFieldRight.setForeground(Color.BLACK);
						textFieldLeft.setForeground(Color.BLACK);
						
						double value = Double.valueOf(text);
						Unit getComboBoxLeft = (Unit) unitCombobox1.getSelectedItem();
						Unit getComboBoxRight = (Unit) unitCombobox2.getSelectedItem();
						if(textFieldLeft.isEditable())
							textFieldRight.setText(String.valueOf(String.format("%.4f",(converter.convert(value,getComboBoxLeft,getComboBoxRight)))));
						else if(textFieldRight.isEditable())
							textFieldLeft.setText(String.valueOf(String.format("%.4f",(converter.convert(value, getComboBoxRight,getComboBoxLeft)))));
					}
				} catch (NumberFormatException exception){
					if(textFieldLeft.isEditable())
						textFieldLeft.setForeground(Color.RED);
					else
						textFieldRight.setForeground(Color.RED);
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
						textFieldRight.setForeground(Color.BLACK);
						textFieldLeft.setForeground(Color.BLACK);
						
						double value = Double.valueOf(text);
						Unit getComboBoxLeft = (Unit) unitCombobox1.getSelectedItem();
						Unit getComboBoxRight = (Unit) unitCombobox2.getSelectedItem();
						if (textFieldLeft.isEditable())
							textFieldRight.setText(String.valueOf(String.format("%.4f", (converter.convert(value,getComboBoxLeft, getComboBoxRight)))));
						else if (textFieldRight.isEditable())
							textFieldLeft.setText(String.valueOf(String.format("%.4f", (converter.convert(value, getComboBoxRight, getComboBoxLeft)))));
					}
				} catch (NumberFormatException exception){
					if(textFieldLeft.isEditable())
						textFieldLeft.setForeground(Color.RED);
					else
						textFieldRight.setForeground(Color.RED);
				}
			}
		});
		
		getContentPane().add(container);
		this.pack();
	}
	
	/**
	 * Change to other unit types
	 * @param type of unit type
	 */
	public void changeUnitType(UnitType type) {
		Unit[] length1 = converter.getUnits(type);
			for (Unit u : length1)
				unitCombobox1.addItem(u);
		Unit[] length2 = converter.getUnits(type);
			for (Unit u : length2)
				unitCombobox2.addItem(u);
	}
	public void run(){
		setVisible(true);
		setSize(700,150);
	}
}