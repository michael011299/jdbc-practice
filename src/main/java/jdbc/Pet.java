package jdbc;

public class Pet {

	private int id;
	private String name;
	private int age;
	private String breed;

	public Pet(int id, String name, int age, String breed) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.breed = breed;
	}

	public int getId() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return this.breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", breed=" + breed + "]";
	}

}
