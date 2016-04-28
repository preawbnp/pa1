
public enum Weight implements Unit{
	
	GRAM("Gram",1.0),
	TAN("Tan",1000000),
	KILOGRAM("Kilogram",0.001),
	MILIGRAM("Miligram",1000),
	POND("Pond",0.00220462262141481),
	ONZ("Onz",0.035273961942636996),
	KARAT("Karat",5.00000000000332);

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
