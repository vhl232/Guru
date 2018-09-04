package guru.reflection;

public class Kenguru {
	private boolean isMother;
	private Kenguru child;
	protected Object sumka;
	public String name;

	private Kenguru() {
		isMother = false;
		//child = new Kenguru();
		sumka = new InterruptedException();
		name = "Ru";
	}

	@Override
	public String toString() {
		return "Kenguru{" +
				(isMother?("kenguru=" + child + ", "):"") +
				"sumka=" + sumka +
				", name='" + name + '\'' +
				'}';
	}

	private static final void  jump(){
		System.out.println("kenguru");
	}
}
