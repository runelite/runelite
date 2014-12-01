package info.sigterm.deob;

import info.sigterm.deob.attributes.Attributes;

import java.io.DataInputStream;
import java.io.IOException;

public class Field
{
	private Fields fields;

	private short accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private Attributes attributes;

	Field(Fields fields) throws IOException
	{
		this.fields = fields;

		DataInputStream is = fields.getClassFile().getStream();

		accessFlags = is.readShort();
		nameIndex = is.readUnsignedShort();
		descriptorIndex = is.readUnsignedShort();
		attributes = new Attributes(this);
	}

	public Fields getFields()
	{
		return fields;
	}
}