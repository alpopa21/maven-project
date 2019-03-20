import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataBase {
	private static DataBase Instance=null;
	private static File file;
	private static BufferedReader br;
	private static String password=null;
	
	private DataBase() throws FileNotFoundException{
		
		file = new File("test.txt");
		br = new BufferedReader(new FileReader(file));
	}
	
	protected static DataBase getInstance() throws IOException{
		if(Instance==null) Instance=new DataBase();
		return Instance;
	}
	
	protected static String getNextUser() throws IOException, NullPointerException {
		String user=br.readLine();
		if(user==null) {
			return null;
		}
		String []infos;
		infos=user.split(" ");
		try{
			password=infos[1];
		}catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return infos[0];
	}
	
	protected static String getPassword() {
		return password;
	}
	
	protected static void res() throws IOException {
		br.close();
		br = new BufferedReader(new FileReader(file));
	}
	
	protected static void fin() throws IOException {
		br.close();
	}
}
