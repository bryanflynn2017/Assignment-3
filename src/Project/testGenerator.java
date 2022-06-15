package Project;

public class testGenerator {
	public static void main(String[] args) {
		enemyGenerator.generate();
		System.out.println("Name: "+enemyGenerator.getName());
		System.out.println("HP: "+enemyGenerator.getHP());
	}
}
