package guru;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Prop {
	private static Properties prop = new Properties();
	static FileInputStream read;

	public static void main(String[] args) throws FileNotFoundException {
		read =  new FileInputStream("prop.properties");

	}
}
