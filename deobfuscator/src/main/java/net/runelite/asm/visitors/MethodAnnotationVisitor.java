package net.runelite.asm.visitors;

import net.runelite.asm.Method;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

public class MethodAnnotationVisitor extends AnnotationVisitor
{
	private final Method method;
	private final Type type;
	private final Annotation annotation;
	
	public MethodAnnotationVisitor(Method method, Type type)
	{
		super(Opcodes.ASM5);
		
		this.method = method;
		this.type = type;
		
		annotation = new Annotation(method.getAnnotations());
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
		method.getAnnotations().addAnnotation(annotation);
	}
}
