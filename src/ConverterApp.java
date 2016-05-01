
public class ConverterApp {
	public static void main(String [] arg){
		UnitConverter uc = new UnitConverter();
		ConverterUI display = new ConverterUI(uc);
		display.run();
	}
}
