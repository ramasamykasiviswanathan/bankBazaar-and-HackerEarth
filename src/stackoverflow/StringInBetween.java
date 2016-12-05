package stackoverflow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInBetween {
	public static void main(String[] args) throws ParseException {
		//"name+" at:"+Date+" Notes:"+meetingnotes" (name, Date and meetingnotes being variables).
		String test = "rama"+ " at:"+"2015-01-02"+" Notes:"+"meetingnotes";
		
		Pattern pattern = Pattern.compile("at:(.*)Notes");
		Matcher matcher = pattern.matcher(test);
		
		if(matcher.find())
		{
			String dateString = matcher.group(1);	//I'm using the Capturing groups to capture only the value.
			java.util.Date date = new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
			System.out.println(date);
		}
	}
}
