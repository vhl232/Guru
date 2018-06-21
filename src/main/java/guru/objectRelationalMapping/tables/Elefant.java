package guru.objectRelationalMapping.tables;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "sloni")
public class Elefant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int legs;
	private  int ears;
	private String name;

	public Elefant(int legs, int ears, String name) {
		this.legs = legs;
		this.ears = ears;
		this.name = name;
	}

	public Elefant() {
	}

	public Elefant(int id, int legs, int ears, String name) {
		this.id = id;
		this.legs = legs;
		this.ears = ears;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getEars() {
		return ears;
	}

	public void setEars(int ears) {
		this.ears = ears;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Elefant)) return false;
		Elefant elefant = (Elefant) o;
		return id == elefant.id &&
				legs == elefant.legs &&
				ears == elefant.ears &&
				Objects.equals(name, elefant.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, legs, ears, name);
	}

	@Override
	public String toString() {
		return "Elefant{" +
				"id=" + id +
				", legs=" + legs +
				", ears=" + ears +
				", name='" + name + '\'' +
				'}';
	}
}
