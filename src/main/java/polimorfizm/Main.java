package polimorfizm;

import guru.WebElementFunc;
import org.openqa.selenium.WebElement;

public class Main {
	public static void main(String[] args) {
		/*Polomorfizm polomorfizm = new Polomorfizm();
		m1(polomorfizm);
		m2(polomorfizm);
		m3(polomorfizm);


		Q p2 = new Q();
		m1(p2);
		Q q = new Polomorfizm();
		q.seriislon();*/

		Sobaca sobaca = new Sobaca() {

		};
		System.out.println(sobaca);

		WebElementFunc webElementFunc = () -> null;

		Runnable rre = () -> {
			System.out.println(sobaca);
		};
		new Thread(rre).start();

		System.out.println(webElementFunc);
	}
	public static interface Sobaca{}





	private static void m1(A a){
		a.m1();
		a.m2();
		a.m3();
		if (a instanceof B){
			B b = (B) a;
			m2(b);
		}
	}
	private static void m2(B b){
		b.b3();
		b.b2();
		b.b1();
	}
	private static void m3(C c){
		c.c2();
		c.c3();
		c.c1();
	}
}
