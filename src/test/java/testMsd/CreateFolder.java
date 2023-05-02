package testMsd;
 import java.io.File;
public class CreateFolder {
public static void main(String[] args) {
	File file =new File("C:\\Dummy");
	if(file.mkdir()) {
		System.out.println("Folder Created...");
	}
	else {
	System.out.println("File already exist");
}
}
}
