/**
 * 
 * Specification common units of time.
 * @author Budnampetch Onmee
 * 
 */
public enum Time implements Unit{
	
	/**
	 * 
	 * Specification component of enumeration.
	 * String is String name of unit,
	 * value is convert to meter unit.
	 */
	DAY("Day",1),
	WEEK("Week",7.01923076923077),
	MONTH("Month",30.416666666666664),
	YEAR("Year",365), 
	HOUR("Hour",0.041666666666666664),
	MINUTE("Minute",0.0006944444444444444),
	SECOND("Second",0.000011574074074074073);

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
	Time(String name, double value){
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
