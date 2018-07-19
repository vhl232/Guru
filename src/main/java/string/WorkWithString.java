package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WorkWithString {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    String stroka =	bufferedReader.readLine();
	   // metod(stroka);
	   // metod1(stroka);
	    //metod2(stroka);
	   // metod3(stroka);
	    //metod4(stroka);
	   // metod5(stroka);
	    //metod6(stroka);
		method("sobaka");
	}

	private static void metod(String a){
		if(a.contains("abc")){
			System.out.println(a.toUpperCase());
		}
		else System.out.println(a.toLowerCase());

	}

	private static void metod1(String a){
		if(a.startsWith("abc")||a.endsWith("abc")){
			System.out.println(a.substring(3));
		}


	}

	private static void metod2(String a){
		if(a.contains(" ")){
			String[] as = a.trim().split(" ");
			for (int i = 0; i <as.length ; i++) {
				if(i%2==0){
					metod1(as[i]);
				}
				else metod(as[i]);
			}
		}
		else System.out.println("no space");
	}

	private  static void metod3(String a){
		if(a.contains("a")&&a.contains("z")) {
			if (a.indexOf("a") < a.lastIndexOf("z")) {
				System.out.println(a.substring(a.indexOf("a")+1,a.lastIndexOf("z")));
			}
			else System.out.println(a.substring(a.indexOf("z")+1,a.lastIndexOf("a")));
		}
	}
	private static void metod4(String a){
		char[] sa = a.toCharArray();
		Map <Character,Integer> mao = new TreeMap<>();
		for (int i = 0; i <sa.length ; i++) {
			if(mao.containsKey(sa[i])){
				int q = mao.get(sa[i]);
				mao.put(sa[i],q+1);
			}
			else mao.put(sa[i], 1);
		}
		System.out.println(mao);
	}
	private static void metod5(String a){
		int q = a.length();
		StringBuilder stringBuilder = new StringBuilder(a);
		for (int i = 0; i <q ; i++) {
			stringBuilder.append(i);
		}
		System.out.println(stringBuilder.reverse());
		//new StringBuilder(a).reverse().toString()
	}

	private static void metod6(String a){
		String b = a.replaceAll("hui","***")
				.replaceAll("pizda", "*****");
		System.out.println(b);
	}
	private static void method(String s){
		StringBuffer sb = new StringBuffer(s);
		sb.append("Как жил?— Я не жил.— Что узнал?— \n")
				.append("Забыл. Я только помню, как тебя любил. \n")
				.append("Так взвейся вихрем это восклицанье! \n")
				.append("Разлейся в марте, ржавая вода, \n")
				.append("Рассмейся, жизнь, над словом \"никогда!\", \n")
				.append("Все остальное остается в тайне.");

		sb.append("\n\n");
		sb.append("Циркачка в черно-золотом трико,-\n")
				.append("Лети сквозь мир так дико, так легко, \n")
		.append("Так высоко, с таким весельем дерзким, \n")
		.append("Так издевательски не по-людски, \n")
		.append("Что самообладанием тоски\n")
		.append("Тебе делиться в самом деле не с кем!");
		String ss = sb.toString();
		System.out.println(ss);
	}

}
