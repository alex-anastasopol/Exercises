package main.small.exercises;

public class NullObj {
	public static void main(String[] args) {
		String str = null;
		if (str instanceof Object) {
			System.out.println("str is obj");
		} else {
			System.out.println("str is not obj");
		}
	}
}
