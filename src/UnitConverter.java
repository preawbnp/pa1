/**
 * 
 * Converter the units of length.
 * @author Budnampetch Onmee
 *
 */
public class UnitConverter {
	/**
	 * 
	 * @param amount value of want to change unit.
	 * @param fromUnit convert form unit.
	 * @param toUnit convert to unit.
	 * @return current of amount.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}
	/**
	 * Gets component units.
	 * @return value of unit.
	 */
	public Unit[] getUnits(){	
		return Length.values();
	}
}