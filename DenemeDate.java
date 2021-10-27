package sourceCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 

public class DenemeDate {
	public static void main(String[] args)  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String startDate = "10-01-2018 01:10:20";
		String endDate = "10-06-2020 06:30:50";
		
		try {
			Date d1 = sdf.parse(startDate);
			Date d2 = sdf.parse(endDate);
			
			long difference_In_Time = d2.getTime() - d1.getTime();
			long differenceInDay = difference_In_Time / (1000 * 60 * 60 *24);
			System.out.println(differenceInDay);
		}catch(ParseException  e) {
			System.err.println(e);
		}
	}
}
