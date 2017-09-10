package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// System.out.println("le is "+args.length);
		System.out.println("Hello World");
		// if(args.length != 3){
		// 	System.err.println("Please specify two arguments");
		// 	return;
		// }
		// System.out.println("arg is " + args[0] + " arg1 is "+ args[1]);
		String inputFile = args[0];
		String outputFile = args[1];
		// try{
		// 	FileReader fr = new FileReader(inputFile);
		// 	BufferedReader br = new BufferedReader(fr);

		// 	// System.out.println("br is "+br);
		// 	// String sCurrentLine;

		// 	// while ((sCurrentLine = br.readLine()) != null) {
		// 	// 	System.out.println(sCurrentLine);
		// 	// }
		// }catch(IOException e) {
		// 	e.printStackTrace();
		// }
	
		try{
		FileProcessor file = new FileProcessor(inputFile);

		String line;

		file.readLine();

		// while((line = file.readLine()) != null){
		// 	System.out.println(line);
		// }
	}catch (Exception e) {
			e.printStackTrace();
		}

		// MyArrayList lis = new MyArrayList();
		// lis.insertSorted(5);
		// lis.insertSorted(2);
		// // lis.insertSorted(3);
		// // lis.insertSorted(2);
		// // lis.insertSorted(1);

		// // System.out.println(lis.size());
		// // lis.removeValue(3);
		// // lis.insertSorted(1);
		// lis.disp();
		// // System.out.println(lis.indexOf(6));

		// // lis.toString();
		// System.out.println("size is "+lis.size());
	}
}
