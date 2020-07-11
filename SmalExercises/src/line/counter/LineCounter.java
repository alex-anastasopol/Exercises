package line.counter;

import java.io.*;
import java.util.Scanner;

public class LineCounter {
	private static int finalLineCounter = 0;
	private static int finalCommentLineCounter = 0;

	public static void main(String[] args) {
		resetLineCounter();
		String path = getPathToSearch(); // getPathToSearch();
		countLines(path);
		System.err
				.println("\n\nNr de linii de cod din fisiere *.java din calea data este: "
						+ getFinalLineCounter());
		System.err
				.println("\n\nNr de linii comentate/goale cod din fisiere *.java din calea data este: "
						+ getFinalCommentLineCounter());

		System.err.println("\n\nTotal : "
				+ ((int) getFinalLineCounter() + getFinalCommentLineCounter()));
	}

	private static String getPathToSearch() {
		Scanner scanner = new Scanner(System.in);
		String pathToSearch = "";
		// pathToSearch = scanner.nextLine();
		// if (!new File(pathToSearch).canRead()) {
		pathToSearch = "C:\\temp\\JavaClass.java";
		// "D:/Code/WorkSpaceEclipse/TSEARCH/";
		// }
		System.err.println("Path to search is : " + pathToSearch + "\n\n");
		return pathToSearch;

	}

	private static void countLines(String path) {
		try {

			File f1 = new File(path);

			String[] files = f1.list();
			String file = "";
			BufferedReader br = null;
			for (int i = 0; i < files.length; i++) {

				File f2 = new File(path + files[i]);
				if (f2.isDirectory()) {
					countLines(f2.getAbsolutePath() + "\\");
				} else {
					int localLineCounter = 0;
					int localCommentLineCounter = 0;
					 
					 if(files[i].endsWith(".java")||files[i].endsWith(".jsp")||files[i].endsWith(".xml")){
					
					br = new BufferedReader(new FileReader(path + files[i]));
					String line = "";
					while ((line = br.readLine()) != null) {
						if (line.contains("/*")) {
							localCommentLineCounter++;
							while ((line = br.readLine()) != null) {
								if (!line.contains("*/")) {
									localCommentLineCounter++;
								}
							}
						}
						if (line != null && !line.trim().isEmpty()
								&& !line.trim().startsWith("//")) {
							localLineCounter++;
						} else {
							localCommentLineCounter++;
						}
					}
					addLinesToTotal(localLineCounter);
					addCommentLinesToTotal(localCommentLineCounter);
					System.out.println("File path: " + f1.getAbsolutePath()
							+ "\\" + files[i] + ": " + localLineCounter
							+ " lines\n");
					System.out.println("File path: " + f1.getAbsolutePath()
							+ "\\" + files[i] + ": " + localCommentLineCounter
							+ " comment lines\n");
				}}
			}
			// br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addLinesToTotal(int lines) {
		finalLineCounter += lines;
	}

	private static void addCommentLinesToTotal(int lines) {
		finalCommentLineCounter += lines;
	}

	private static int getFinalLineCounter() {
		return finalLineCounter;
	}

	private static int getFinalCommentLineCounter() {
		return finalCommentLineCounter;
	}

	private static void resetLineCounter() {
		finalLineCounter = 0;
		finalCommentLineCounter = 0;
	}
}
