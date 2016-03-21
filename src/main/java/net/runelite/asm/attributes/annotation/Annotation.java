package net.runelite.asm.attributes.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ConstantPool;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.signature.Type;

public class Annotation
{
	private final Annotations annotations;
	private Type type;
	private final List<Element> elements = new ArrayList<>();

	public Annotation(Annotations annotations)
	{
		this.annotations = annotations;
	}

	public Annotations getAnnotations()
	{
		return annotations;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public Type getType()
	{
		return type;
	}

	public List<Element> getElements()
	{
		return elements;
	}
	
	public Element getElement()
	{
		return elements.get(0);
	}
	
	public void addElement(Element element)
	{
		elements.add(element);
	}
	
	public void load(DataInputStream is) throws IOException
	{
		ConstantPool pool = annotations.getAttributes().getClassFile().getPool();
		
		int typeIndex = is.readUnsignedShort();
		type = new Type(pool.getUTF8(typeIndex));
		
		int pairs = is.readUnsignedShort();
		for (int i = 0; i < pairs; ++i)
		{
			Element e = new Element(this);
			e.load(is);
			elements.add(e);
		}
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = annotations.getAttributes().getClassFile().getPool();
		
		out.writeShort(pool.makeUTF8(type.getFullType()));
		out.writeShort(elements.size());
		for (Element e : elements)
		{
			e.write(out);
		}
	}
}
