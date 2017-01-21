import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Lovisa Colérus
 * 2016
 *
 */

public class ProgramReader {
	public static void main(String[] args){
		Scanner sc;
		String className = "No class";

		try{
			File file = new File("./src/Complex.java");
			sc = new Scanner(file);



			/* Hittar var klassnamnet står, 
			 * skriver ut klassnamnet
			 */
			while(sc.hasNextLine() != false){
				String in = sc.nextLine();

				if(in.contains("class")){
					int classIndex = in.indexOf("class")+5;
					className = in.substring(in.indexOf(" ", classIndex), 
							in.indexOf("{", classIndex));
					System.out.println(className);
					System.out.println("--------");
					break;

				}
			}





			/*skriver ut uml-datan för alla metoder och variabler och konstruktorn
			 * delas upp beroende på åtkomstmöjlighet
			 * 
			 */
			while(sc.hasNextLine() != false){
				String in = sc.nextLine();
				String priv = "private";
				String publ = "public";
				String prot = "protected";

				if(in.contains(priv)){
					System.out.print("- ");
					umlPrint(in, priv);

				}else if(in.contains(prot)){
					System.out.print("# ");
					umlPrint(in, prot);

				}else if(in.contains(publ)){
					System.out.print("+ ");
					umlPrint(in, publ);
				}
			}

		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Prints the uml-code for the constructor
	 * @param in
	 */
	public static void constructorPrint(String in){
		int j = 0;
		String sub;
		String[] types = new String[10];

		if(in.contains("(") && in.contains(")")){
			sub = in.substring(in.indexOf("(")+1, in.indexOf(")"));

			for(String r : sub.split(" +")){

				if(r.contains(",")){
					r = r.substring(0, r.length()-1);
				}

				if(j%2 ==0){
					types[j] = r;

				}else{
					types[j] = r;
					System.out.print(types[j] + ":" + types[j-1] + " ");
				}
				j++;
			}
		}
		System.out.print(")");
	}

	/**
	 * skriver ut uml-datan ifall det är en metod
	 * @param in
	 * @return
	 */
	public static String methodPrint(String in, String type){
		String sub = "";
		ArrayList<String> methodNames = new ArrayList<String>();

		if(in.contains("main")){
			sub = "main()";

		}else{
			sub = in.substring(in.indexOf(type)+type.length(), in.indexOf("("));

			if(sub.contains("static")){
				sub = sub.substring(7, sub.length());
			}

			for(String r : sub.split(" +")){
				if(r != null){
					methodNames.add(r);
				}
			}	

			if(methodNames.size() <=2){
				sub = methodNames.get(1)+"( ";
				System.out.print(sub);
				constructorPrint(in);
				return "";

			}else{
				sub = (methodNames.get(2)+"():"+methodNames.get(1));
			}
		}
		return sub;
	}


	/**
	 * skriver ut uml-datan ifall det är en variabel
	 * @param in
	 * @param type
	 * @return
	 */
	public static String variableString(String in, String type){

		String sub = in.substring(in.indexOf(type)+type.length()+1);
		sub = sub.substring(0, sub.length()-1);
		return sub;
	}

	public static void umlPrint(String in, String type){
		String sub = "";
		if(in.contains("(") && in.contains(")")){
			sub = methodPrint(in, type);

		}else{
			sub = variableString(in, type);
		}
		System.out.println(sub);
	}
}




