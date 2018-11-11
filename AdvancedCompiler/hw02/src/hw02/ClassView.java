package hw02;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.objectweb.asm.ClassReader;

public class ClassView {

	public static void main(String[] args) {
		// input class name
		String className = "Comparable";
		// write class
		ComparableWriter cwr = new ComparableWriter(className); 
		FileOutputStream stream = null;
		try { 
			stream = new FileOutputStream("./bin/"+className+".class");
			stream.write(cwr.toByteArray()); 
		} catch (Throwable t) { 
			t.printStackTrace(); 
		} finally {
			if (stream != null) {
				try { 
					stream.close(); 
				} catch (Throwable t) {
					t.printStackTrace(); 
				} 
			} 
		}
		// read class
		try {
			ClassPrinter cp = new ClassPrinter();
			ClassReader cr = new ClassReader(className);
			cr.accept(cp, 0);
		}catch(Throwable t) {
			t.printStackTrace();
			throw new RuntimeException(t);
		}
	}
	
}
