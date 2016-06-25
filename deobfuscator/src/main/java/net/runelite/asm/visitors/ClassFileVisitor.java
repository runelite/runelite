package net.runelite.asm.visitors;

import net.runelite.asm.ClassFile;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassFileVisitor extends ClassVisitor
{
	private final ClassFile classFile = new ClassFile();

	public ClassFileVisitor()
	{
		super(Opcodes.ASM5);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
	{
		classFile.setName(name);
		classFile.setSuperName(superName);
		classFile.setVersion(version);
		classFile.setAccess(access);
		
		for (String inter : interfaces)
			classFile.getInterfaces().addInterface(new net.runelite.asm.pool.Class(inter));
	}

	@Override
	public void visitSource(String source, String debug)
	{
		classFile.setSource(source);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible)
	{
		Type type = new Type(desc);
		return new ClassAnnotationVisitor(classFile, type);
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
	{
		return new ClassFieldVisitor(classFile, access, name, new Type(desc), value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
	{
		return new CodeVisitor(classFile, access, name, new Signature(desc), exceptions);
	}
}
