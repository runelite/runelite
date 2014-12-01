package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassFile
{
	private int magic;
	private short minor_version;
	private short major_version;
	private ConstantPool pool;
	private short access_flags;
	private int this_class;
	private int super_class;
	private Interfaces interfaces;
	private Fields fields;
	private Methods methods;
	private Attributes attributes;

	private DataInputStream is;

	public ClassFile(DataInputStream is) throws IOException
	{
		this.is = is;

		magic = is.readInt();
		if (magic != 0xcafebabe)
			throw new IOException("File is not a java class file.");

		minor_version = is.readShort();
		major_version = is.readShort();

		pool = new ConstantPool(this);

		access_flags = is.readShort();
		this_class = is.readUnsignedShort();
		super_class = is.readUnsignedShort();

		interfaces = new Interfaces(this);

		fields = new Fields(this);

		methods = new Methods(this);

		attributes = new Attributes(this);
	}

	public DataInputStream getStream()
	{
		return is;
	}

	public ConstantPool getPool()
	{
		return pool;
	}
}
