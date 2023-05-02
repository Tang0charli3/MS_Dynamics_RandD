package testMsd;

public class SubString {
public static void main(String[] args) {
	String text="Microsoft account\r\n"
			+ "Security code\r\n"
			+ "Please use the following security code for the Microsoft account da**x@gmail.com.\r\n"
			+ "Security code: 0109642\r\n"
			+ "If you don't recognise the Microsoft account da**x@gmail.com, you can click here to remove your email address from that account.\r\n"
			+ "Thanks,\r\n"
			+ "The Microsoft account team\r\n"
			+ "";
	String nums=text.replaceAll("[^0-9]", "");
	System.out.println(nums);
	nums=nums.substring(0, 7);
	System.out.println(nums);
}
}
