package les16.minPack;

import java.lang.reflect.*;

public class Main {
	public static void myMethod(int a, String b) {
		System.out.printf("A is %d, string is %s\n", a, b);
	}
	
	public static void myMethod(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) throws ClassNotFoundException, 
	IllegalArgumentException, IllegalAccessException, 
	NoSuchFieldException, SecurityException,
	NoSuchMethodException, 
	InvocationTargetException, InstantiationException {
		//Commodity commodity = new Commodity("Tovar", 202, 351, 56);
		Class<?> c = Class.forName("les16.minPack.Commodity");
		System.out.println("Name: " + c);
		System.out.println("Simplename: " + c.getSimpleName());
		System.out.println("Canonical name: " + c.getCanonicalName());
		System.out.println("c is interface - " + c.isInterface());
		System.out.println("Super class - " + c.getSuperclass());
		System.out.println("Modifiers - " + c.getModifiers());
		System.out.println("Is primitive - " + c.isPrimitive());
		System.out.println("Package - " + c.getPackageName());
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		
		Method[] methods = c.getDeclaredMethods();
		Constructor[] constructors = c.getDeclaredConstructors();
		System.out.println("All methods: ");
		for (Method m : methods)
			System.out.println(m);
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("All constructors: ");
		for (Constructor co : constructors)
			System.out.println(co);
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("All fields: ");
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields)
			System.out.println(f.toString());
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Get all interfaces: ");
		Class[] interfaces = c.getInterfaces();
		for (Class i : interfaces)
			System.out.println(i);
		
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		
		System.out.println("Set field(title) with reflection: "
				+ "");
		Commodity com = new Commodity();
		Field field = c.getDeclaredField("title");
		field.setAccessible(true);
		field.set(com, "Reflection!");
		System.out.println(com.getTitle());
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("First method invoke: ");
		Class<?> cl = Main.class;
		Method m = cl.getMethod("myMethod", int.class, String.class);
		m.invoke(cl, 5, "First method with reflection");
		
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Second method invoke: ");
		m = cl.getMethod("myMethod", String.class);
		m.invoke(cl, "Second method with reflection");
	}
	
}
