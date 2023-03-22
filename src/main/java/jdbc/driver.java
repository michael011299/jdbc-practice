package jdbc;

public class driver {
	public static void main(String[] args) {
		try (PetDAO dao = new PetDAO("jdbc:mysql://localhost:3306/pets", "root", "pass");) {
			System.out.println(dao.create("clifford", 18, "big red"));
			System.out.println(dao.read());
			System.out.println(dao.update(15, "clifford"));
			System.out.println(dao.read());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
