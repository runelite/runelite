package net.runelite.deob.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.attributes.annotation.Annotation;

public class Annotations extends Attribute
{
	private final List<Annotation> annotations = new ArrayList<>();
	
	public Annotations(Attributes attributes)
	{
		super(attributes, AttributeType.RUNTIMEVISIBLEANNOTATIONS);
	}

	public List<Annotation> getAnnotations()
	{
		return annotations;
	}
	
	@Override
	public void loadAttribute(DataInputStream is) throws IOException
	{
		int num_annotations = is.readUnsignedShort();
		for (int i = 0; i < num_annotations; ++i)
		{
			Annotation a = new Annotation(this);
			a.load(is);
			annotations.add(a);
		}
	}

	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.writeShort(annotations.size());
		for (Annotation a : annotations)
		{
			a.write(out);
		}
	}

}
