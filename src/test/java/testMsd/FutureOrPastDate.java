package testMsd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FutureOrPastDate {
public static void main(String[] args) {
	LocalDate Date = LocalDate.now();
	System.out.println(Date);
	LocalDate pDate =Date.plusDays(-100);
	System.out.println(pDate);
//	String dateString = pDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//	Scanner sc = new Scanner(System.in);
//	String dateformat=sc.next();
//	String format=dateformat.toUpperCase();
//	String[] date=dateString.split("/");
//	List<String> presentDate= Arrays.asList(date);
//	
//	String todaysDate="";
//	switch(format) {
//	
//	case "DD/MM/YYYY":todaysDate=(presentDate.get(0)+"/"+presentDate.get(1)+"/"+presentDate.get(2));
//	break;
//	
//	case "MM/DD/YYYY":todaysDate=(presentDate.get(1)+"/"+presentDate.get(0)+"/"+presentDate.get(2));
//	break;
//	
//	case "YYYY/MM/DD":todaysDate=(presentDate.get(2)+"/"+presentDate.get(1)+"/"+presentDate.get(0));
//	break;
//	
//	default :todaysDate=(presentDate.get(0)+"/"+presentDate.get(1)+"/"+presentDate.get(2));
//	}
//	System.out.println(todaysDate);
}
}
