package guru.objectRelationalMapping;

import java.io.Closeable;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibenateUtils {
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static Session getSession(){
		return factory.openSession();
	}

	public static void closeFactory() {
		factory.close();
	}
}
