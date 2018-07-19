package guru.objectRelationalMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import guru.objectRelationalMapping.tables.Elefant;

public class Main {

	public static void main(String[] args) {

		//addElefants();
		System.out.println(getElefent(2));
		HibenateUtils.closeFactory();
	}

	private static void addElefants(){
		Session session = HibenateUtils.getSession();
		Transaction tx = session.beginTransaction();

		Elefant slon = new Elefant(4,2,"slon");
		Elefant mashka = new Elefant(4,2,"mashka");

		session.persist(slon);
		//session.persist(mashka);

		tx.commit();

		session.close();
	}

	public static Elefant getElefent(int index) {
		Session session = HibenateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		return session.get(Elefant.class, index);
	}


}
