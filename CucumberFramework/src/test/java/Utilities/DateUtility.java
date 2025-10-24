package Utilities;

import java.util.Date;

public class DateUtility {

	public static String GetCurrentDate() {
		return new Date().toString().replaceAll("[- :]", "_");
	}
}
