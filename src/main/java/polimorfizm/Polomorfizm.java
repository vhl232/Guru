package polimorfizm;

public class Polomorfizm extends Q implements A,B,C {

	@Override
	public void m1() {
		System.out.println(1);
	}

	@Override
	public void m2() {
		System.out.println(2);
	}

	@Override
	public void m3() {
		System.out.println(3);
	}

	@Override
	public void b1() {
		System.out.println(1);
	}

	@Override
	public void b2() {
		System.out.println(2);
	}

	@Override
	public void b3() {
		System.out.println(3);
	}

	@Override
	public void c1() {
		System.out.println(1);
	}

	@Override
	public void c2() {
		System.out.println(2);
	}

	@Override
	public void c3() {
		System.out.println(3);
	}
	public void seriislon(){
		System.out.println("smert");
	}
	public void m4(){

	}
}
