package birds;

public class Swan extends Bird {
	public void glide() {
		System.out.println("I am like SO graceful");
	}
	
	public static void main(String[] args) {
		Swan s = new Swan();
		Bird b = s;
		//Duck d = (Duck)b;
		//d.quack();
		}
}
