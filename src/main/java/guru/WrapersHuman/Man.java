package guru.WrapersHuman;

public class Man implements Human {
    private Human human;

    public Man(Human human) {
        this.human = human;
    }

    @Override
    public String getName() {
        return human.getName();
    }

    @Override
    public String getAge() {
        return "idi nafig";
    }
}
