package main.utils;

public class MathUtils {
	
	public static boolean isInt(String string) {
		try {
			Integer.parseInt(string);
			return true;
		}catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public static int cap(int value, int min, int max) {
		return value >= max ? max : (value <= min ? min : value);
	}
	
	public static double cap(double value, double min, double max) {
		return value >= max ? max : (value <= min ? min : value);
	}

}
