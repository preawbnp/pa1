import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ConverterUI extends JFrame{
	private JButton converterButton;
	private Container container;
	private Container containerA;
	private Container containerB;
	private UnitConverter converter;
	private JComboBox<Unit> unitCombobox1;
	private JComboBox<Unit> unitCombobox2;
	private JTextField textFieldLeft;
	private JTextField textFieldRight;
	private JLabel equals;
	private JButton clearButton;	
	private JRadioButton leftButton;
	private JRadioButton rightButton;

	public ConverterUI (UnitConverter uc){
		this.converter = uc;
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	private void initComponents(){
		container = new Container();
		containerA = new Container();
		containerB = new Container();
		this.add(container);
		this.add(containerA);
		this.add(containerB);
		container.setLayout(new GridLayout(2,1));
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
						Length getComboBoxLeft = (Length) unitCombobox1.getSelectedItem();
						Length getComboBoxRight = (Length) unitCombobox2.getSelectedItem();
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
						Length getComboBoxLeft = (Length) unitCombobox1.getSelectedItem();
						Length getComboBoxRight = (Length) unitCombobox2.getSelectedItem();
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