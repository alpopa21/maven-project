import java.io.IOException;

public class BankApp {

	public static void ourProgram() {
		try(AccountVerifier av=new AccountVerifier()) {
			av.function();
		} catch (IOException e) {
			System.out.println("File not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		ourProgram();
		
	}
}

