package net.runelite.deob.attributes;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Attribute
{
	private Attributes attributes;
	private AttributeType type;
	private int length;

	Attribute(Attributes attr, AttributeType type)
	{
		this.attributes = attr;
		this.type = type;
	}
	
	public void load() throws IOException
	{
		DataInputStream is = attributes.getStream();
		this.length = is.readInt();
	}
	
	public final void write(DataOutputStream out) throws IOException
	{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		writeAttr(new DataOutputStream(bout));
		
		byte[] b = bout.toByteArray();
		out.writeInt(b.length);
		out.write(b);
		
		length = b.length;
	}
	
	public abstract void writeAttr(DataOutputStream out) throws IOException;

	public Attributes getAttributes()
	{
		return attributes;
	}

	public AttributeType getType()
	{
		return type;
	}

	public int getLength()
	{
		return length;
	}
}
