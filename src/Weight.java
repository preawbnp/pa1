/**
 * 
 * Specification common units of weight.
 * @author Budnampetch Onmee
 * 
 */
public enum Weight implements Unit{
	
	/**
	 * 
	 * Specification component of enumeration.
	 * String is String name of unit,
	 * value is convert to meter unit.
	 */
	KILOGRAM("Kilogram",1),
	GRAM("Gram",0.001),
	TAN("Tan",1000),
	MILIGRAM("Miligram",0.000001), 
	POND("Pond",0.45359237008928677),
	ONZ("Onz",0.02834952313058039),
	KARAT("Karat",0.0001999999999998672);

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
	Weight(String name, double value){
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
