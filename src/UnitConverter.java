/**
 * 
 * Converter the units of length.
 * @author Budnampetch Onmee
 *
 */
public class UnitConverter {
	private UnitFactory unitFactory = UnitFactory.getInstance();
	
	/**
	 * @param amount value of want to change unit.
	 * @param fromUnit convert form unit.
	 * @param toUnit convert to unit.
	 * @return current of amount.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}
	
	/**
	 * Gets unit of unit type.
	 * @return unit type.
	 */
	public Unit[] getUnits(UnitType type){	
		return unitFactory.getUnits(type);
	}
	
	/**
	 * Gets unit type of unit factory
	 * @return unit type of unit factory
	 */
	public UnitType[] getUnitTypes() {
		return unitFactory.getUnitTypes();
	}
	
	/**
	 * Gets length unit
	 * @return value of length unit
	 */
	public Unit[] getLengthUnit(){
		return Length.values();
	}
	
	/**
	 * Gets weight unit
	 * @return value of weight unit
	 */
	public Unit[] getWeightUnit(){
		return Weight.values();
	}
	
	/**
	 * Gets time unit
	 * @return value of time unit
	 */
	public Unit[] getTimeUnit(){
		return Time.values();
	}
	
	/**
	 * Gets area unit
	 * @return value of area unit
	 */
	public Unit[] getAreaUnit(){
		return Area.values();
	}
	
	
}