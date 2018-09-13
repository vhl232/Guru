package listener;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("listener.Listner");
		packegeScan();
	}


	private static void packegeScan(){
 		String path = new File("").getAbsolutePath() + "\\src\\main\\java\\listener";
		File derictory = new File(path);
		List<File> allFiles = getAllFiles(derictory);
		System.out.println(allFiles.size());
		List<? extends Class<?>> classes = allFiles.stream()
				.filter(x -> x.getName().endsWith(".java"))
				.map(File::getName)
				.map(x -> {
					try {
						return Class.forName("listener." + x.substring(0,x.length()-5));
					} catch (ClassNotFoundException e) {
						return null;
					}
				})
				.collect(Collectors.toList());

		System.out.println(classes.size());
		List<Class> listners = callectListners(classes);
		System.out.println(listners);
	}

	private static List<File> getAllFiles (File dir){
		if(dir!=null && dir.exists() && dir.isDirectory()){
			List<File> rasult = new LinkedList<>();
			for(File f:dir.listFiles()){
				if(f.isFile()){
					rasult.add(f);
				}
				else if(f.isDirectory()){
					rasult.addAll(getAllFiles(f));
				}
			}
			return rasult;
		}
		else return new LinkedList<>();
	}
	private static List<Class> callectListners(List<? extends Class> classes){
		List<Class> listClasses = new LinkedList<>();
		for (Class a :classes){
			if(a==null){continue;}
			Annotation[] annotations = a.getAnnotations();
			for (Annotation q : annotations){
				if(q instanceof Listner){
					listClasses.add(a);
					break;
				}
			}
		}
		return listClasses;
	}
}
