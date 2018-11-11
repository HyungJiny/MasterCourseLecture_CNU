package hw02;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ComparableWriter {
	private String className;
	public ComparableWriter(String filename) {
		this.className = filename;
	}
	
	public byte[] toByteArray() {
		ClassWriter cw = new ClassWriter(0);
		
		// interface 타입 클래스
		cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE
				, className, null, "java/lang/Object", new String[0]);
		// 변수 3개 생성
		cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC, "LESS", "I",
				null, new Integer(-1)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC, "EQUAL", "I",
				null, new Integer(0)).visitEnd();
		cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC, "GREATER", "I",
				null, new Integer(1)).visitEnd();
		// Object o를 매개변수로 받는 compareTo 메소드 생성
		cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT, "methodA", "(Ljava/lang/Object;)I",
				null, null).visitEnd();
		// Object o를 매개변수로 받는 isGreater 메소드 생성
		cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT, "methodB", "(Ljava/lang/Object;)I",
				null, null).visitEnd();
		// Main 클래스 생성 후 System.out.println() 등록
		cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "Main", "([Ljava/lang/String;)V",
				null, null).visitEnd();
		cw.visitMethod(Opcodes.ACC_PUBLIC, "java/lang/System", "(Ljava/io/PrintStream;)V", null,
				null).visitEnd();
		cw.visitMethod(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "(Ljava/lang/String;)V", "println",
				null).visitEnd();
		
		return cw.toByteArray();
	}

}
