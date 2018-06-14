package guru.WrapersHuman;

public class Main {
    public static void main(String[] args) {
        Human h = new Man(new Girl());

        System.out.println(h.getName()+" "+h.getAge());
    }
}
