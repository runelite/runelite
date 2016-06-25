package net.runelite.asm.visitors;

import net.runelite.asm.Field;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

public class FieldAnnotationVisitor extends AnnotationVisitor
{
	private final Field field;
	private final Type type;
	private final Annotation annotation;
	
	public FieldAnnotationVisitor(Field field, Type type)
	{
		super(Opcodes.ASM5);
		
		this.field = field;
		this.type = type;
		
		annotation = new Annotation(field.getAnnotations());
		annotation.setType(type);
	}
	
	@Override
	public void visit(String name, Object value)
	{
		Element element = new Element(annotation);
		
		element.setName(name);
		element.setValue(value);
		
		annotation.addElement(element);
	}

	@Override
	public void visitEnd()
	{
		field.getAnnotations().addAnnotation(annotation);
	}
}
