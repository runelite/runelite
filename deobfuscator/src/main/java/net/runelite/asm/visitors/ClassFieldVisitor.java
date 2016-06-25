package net.runelite.asm.visitors;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.signature.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class ClassFieldVisitor extends FieldVisitor
{
	private final ClassFile classFile;
	private final Field field;

	public ClassFieldVisitor(ClassFile cf, int access, String name, Type desc, Object value)
	{
		super(Opcodes.ASM5);

		this.classFile = cf;

		field = new Field(classFile.getFields(), name, desc);
		field.setAccessFlags(access);
		field.setValue(value);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible)
	{
		Type type = new Type(desc);
		return new FieldAnnotationVisitor(field, type);
	}

	@Override
	public void visitAttribute(Attribute attr)
	{
		System.out.println(attr);
	}

	@Override
	public void visitEnd()
	{
		classFile.getFields().addField(field);
	}
}
