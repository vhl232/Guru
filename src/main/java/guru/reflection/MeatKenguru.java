package guru.reflection;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.TreeSet;

public class MeatKenguru {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class<Kenguru> k = Kenguru.class;
		System.out.println(k.getName());
		System.out.println(k.getSimpleName());

		Method[] methods = k.getMethods();
		for (int i = 0; i <methods.length ; i++) {
			System.out.println(methods[i]);
		}
		System.out.println(k.getCanonicalName());
		Constructor<?>[] constructors = k.getConstructors();
		for (int i = 0; i <constructors.length ; i++) {
			System.out.println(constructors[i]);
		}
		Method[] declaredMethods = k.getDeclaredMethods();
		for (int i = 0; i <declaredMethods.length ; i++) {
			System.out.println(declaredMethods[i]);
		}
		int modifiers = k.getModifiers();
		String s = Modifier.toString(modifiers);
		System.out.println(s);
		System.out.println(Modifier.toString(k.getDeclaredMethods()[1].getModifiers()));



		Kenguru kenguru = null;
		try {
			kenguru = k.newInstance();
		}
		catch (Throwable t){
			//t.printStackTrace();
		}
		System.out.println(kenguru);
		Field[] fields = k.getDeclaredFields();
		for (int i = 0; i <fields.length ; i++) {
			System.out.println(fields[i]);
		}
		System.gc();


	}
}
