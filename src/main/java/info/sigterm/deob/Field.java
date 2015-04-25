package info.sigterm.deob;

import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Field
{
	public static int ACC_PUBLIC = 0x0001;
	public static int ACC_PRIVATE = 0x0002;
	public static int ACC_PROTECTED = 0x0004;
	public static int ACC_STATIC = 0x0008;
	public static int ACC_FINAL = 0x0010;
	public static int ACC_VOLATILE = 0x0040;
	public static int ACC_TRANSIENT = 0x0080;
	public static int ACC_SYNTHETIC = 0x1000;
	public static int ACC_ENUM = 0x4000;

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
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(accessFlags);
		out.writeShort(nameIndex);
		out.writeShort(descriptorIndex);
		attributes.write(out);
	}

	public Fields getFields()
	{
		return fields;
	}

	public short getAccessFlags()
	{
		return accessFlags;
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

	public Attributes getAttributes()
	{
		return attributes;
	}

	public void addReference(Instruction ins)
	{
		instructions.add(ins);
	}
}