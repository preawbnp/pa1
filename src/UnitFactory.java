/**
 * 
 * Managing all the kinds of units
 * @author Budnampetch Onmee
 * 
 */
public class UnitFactory {
	/**
	 * @param UnitType is Length, Area, Time, Weight
	 * @param UnitFactory
	 */
	private UnitType[] type;
	private static UnitFactory instance;
	/**
	 *  Create component of UnitFactory.
	 */
	public UnitFactory(){
		type = new UnitType[4];
	}
	/**
	 * Managing all the kinds of units
	 * @return kinds of units
	 */
	public static UnitFactory getInstance(){
		if (instance == null) 
			return instance = new UnitFactory();
		else
			return instance;
	}
	/**
	 * Gets unit types
	 * @return all unit type
	 */
	public UnitType[] getUnitTypes(){
		return type;
	}
	
	/**
	 * Gets units, user want
	 * @param unitType type of unit
	 * @return unit in category of each unit
	 */
	public Unit[] getUnits(UnitType unitType) {
		if (unitType.name().equals("Length"))
			return Length.values();
		else if(unitType.equals(UnitType.Weight))
			return Weight.values();
		else if (unitType.equals(UnitType.Area))
			return Area.values();
		else if (unitType.equals(UnitType.Time))
			return Time.values();
		else 
			return null;
	}

}