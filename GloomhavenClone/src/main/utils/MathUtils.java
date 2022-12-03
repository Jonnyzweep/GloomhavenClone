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

}
