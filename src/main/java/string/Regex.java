package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		String s = "dikie kabani begali po polyu";
		String maska = "i k";

		Pattern pattern = Pattern.compile(maska);
		Matcher matcher = pattern.matcher(s);
		System.out.println(matcher.find());

		System.out.println(s.replaceAll("\\sk"," K"));


		String t = "";
		Pattern pattern1 = Pattern.compile("\\+?(\\d{10,12})");
		Matcher matcher1 = pattern1.matcher(t);
		System.out.println(matcher1.find());
	}
}
