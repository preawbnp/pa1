/**
 * 
 * Specification common units of length.
 * @author Budnampetch Onmee
 * 
 */
public enum Length implements Unit{
	/**
	 * 
	 * Specification component of enumeration.
	 * String is String name of unit,
	 * value is convert to meter unit.
	 */
	METER("Meter",1.0),
	FOOT("Foot",0.3048),
	CENTIMETER("Centimeter",0.01),
	KILOMETER("kilometer",1000.0),
	MILE("Mile",1609.344),
	WA("Wa",2.0),
	INCH("Inch",0.0254),
	YARD("Yard",Length.FOOT.getValue() * 3),
	MICRON("MICRON", 1.0E-6);
	
	/**
	 * @param name name of units.
	 * @param value convert to regular unit.
	 */
	private final String name;
	private final double value;

	/**
	 * Create component of enumeration.
	 * @param name name of units.
	 * @param value convert to regular unit.
	 */
	Length(String name, double value){
		this.name = name;
		this.value = value;
	}
	/**
	 * Gets current value.
	 * @return current value.
	 */
	public double getValue(){
		return value;
	}
	/**
	 * @return name of unit.
	 */
	public String toString(){
		return this.name;
	}
}
