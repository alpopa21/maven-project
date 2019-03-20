import java.util.Scanner;

public class ScanForUsers {
	static public String username=null;
	static public String password=null;
	static Scanner sc1=new Scanner(System.in);
	
	public static void ScanConsole() {
		System.out.println("Welcome!");
		System.out.print("Username: ");
		username=sc1.nextLine();
		System.out.print("Password: ");
		password=sc1.nextLine();

		}
	
	public static int ScanState(boolean state) {
		if(state==true) {
			System.out.println("Want to log out? 0 for no, 1 for yes");
		}
		else {
			System.out.println("Want to try again? 0 for no, 1 for yes");
		}
		String aux=sc1.nextLine();
		if(aux.equals("0")) return 0;
		else if(aux.equals("1")) return 1;
			else { 
				System.out.println("Type a valid option");
				return ScanState(state);
		
			}
	}
}
