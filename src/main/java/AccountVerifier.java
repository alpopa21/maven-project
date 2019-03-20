import java.io.IOException;

public class AccountVerifier implements AutoCloseable {
	private DataBase db;
	private ScanForUsers sc;
	private static boolean state=false;
	public AccountVerifier() throws IOException{
		db=DataBase.getInstance();
		sc=new ScanForUsers();
	}
	
	private void check() throws IOException {
		sc.ScanConsole();
		String user=null;;
		do{
			user=db.getNextUser();
			if(user==null) {
				db.res();
				state=false;
				break;
			}
			if(sc.username.equals(user)){
				if(sc.password.equals(db.getPassword())) {
					System.out.println("Welcome "+user);
					state=true;
					db.res();
					return;
				}
			}
		}while(user!=null);
		System.out.println("Wrong username/password");
		db.res();
	}
	
	public void function() throws IOException {
		do {
			
				check();
		}while(sc.ScanState(state)!=0);
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		sc.sc1.close();
		db.fin();
	}
}
