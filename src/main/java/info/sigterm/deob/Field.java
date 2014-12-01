package info.sigterm.deob;

import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Field
{
	private Fields fields;

	private short accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private Attributes attributes;

	private ArrayList<Instruction> instructions = new ArrayList<Instruction>(); // instructions which reference this field

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

	public String getName()
	{
		UTF8 u = (UTF8) fields.getClassFile().getPool().getEntry(nameIndex);
		return u.getValue();
	}

	public String getDescriptor()
	{
		UTF8 u = (UTF8) fields.getClassFile().getPool().getEntry(descriptorIndex);
		return u.getValue();
	}

	public void addReference(Instruction ins)
	{
		instructions.add(ins);
	}
}