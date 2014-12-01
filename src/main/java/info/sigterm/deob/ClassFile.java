package info.sigterm.deob;

import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ClassFile
{
	private ClassGroup group;
	private DataInputStream is;

	private ClassFile parent; // super class
	private ArrayList<ClassFile> children = new ArrayList<ClassFile>(); // classes which inherit from this

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

	public ClassFile(ClassGroup group, DataInputStream is) throws IOException
	{
		this.group = group;
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

	public String getName()
	{
		Class entry = (Class) pool.getEntry(this_class);
		UTF8 className = (UTF8) pool.getEntry(entry.getIndex());
		return className.getValue();
	}

	public void buildClassGraph()
	{
		Class entry = (Class) pool.getEntry(super_class);
		UTF8 className = (UTF8) pool.getEntry(entry.getIndex());
		String superName = className.getValue();

		ClassFile other = group.findClass(superName);
		if (other == null)
			return; // inherits from a class not in my group

		assert other != null;
		assert other != this;

		this.parent = other;
		parent.children.add(this);
	}
}
