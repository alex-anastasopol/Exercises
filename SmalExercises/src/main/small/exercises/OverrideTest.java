package main.small.exercises;

public class OverrideTest {
	public static void main(String[] args) {
		Base bObj = new Derived();
		bObj.foo(bObj);
		System.out.println("staticVal: " + bObj.staticVal);
		System.out.println("val: " + bObj.val);
		System.out.println("(Derived)staticVal: " + ((Derived) bObj).staticVal);
		System.out.println("(Derived)val: " + ((Derived) bObj).val);
	}
}

class Base {
	int staticVal = 1;
	int val = 3;

	public static void foo(Base bObj) {
		System.out.println("In Base.foo()");
		bObj.bar();
	}

	public void bar() {
		System.out.println("In Base.bar()");
	}
}

class Derived extends Base {
	static int staticVal = 2;
	static int val = 4;

	public static void foo(Base bObj) {
		System.out.println("In Derived.foo()");
		bObj.bar();
	}

	public void bar() {
		System.out.println("In Derived.bar()");
	}
}
