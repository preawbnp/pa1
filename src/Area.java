/**
 * 
 * Specification common units of area.
 * @author Budnampetch Onmee
 * 
 */
public enum Area implements Unit{
	
	/**
	 * 
	 * Specification component of enumeration.
	 * String is String name of unit,
	 * value is convert to meter unit.
	 */
	SQUAREKILOMETER("Sq.Kilometer",1),
	SQUAREMETER("Sq.Meter",Math.pow(10,6)),
	SQUARECENTIMETER("Sq.Centimeter", Math.pow(10,10)),
	SQUAREMILE("Sq.Mile",0.386102158539359), 
	SQUAREFOOT("Sq.Foot",10763910.416623611),
	RAI("Rai",625),
	ACRES("Acres",247.105381467165);

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
	Area(String name, double value){
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
