package net.runelite.deob;

import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.pool.Class;
import net.runelite.deob.pool.NameAndType;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassFile
{
	private static final int MAGIC = 0xcafebabe;
	
	private ClassGroup group;
	private DataInputStream is;

	private ClassFile parent; // super class
	private List<ClassFile> children = new ArrayList<>(); // classes which inherit from this

	private short minor_version;
	private short major_version;
	private ConstantPool pool;
	private short access_flags;
	private Class name;
	private Class super_class;
	private Interfaces interfaces;
	private Fields fields;
	private Methods methods;
	private Attributes attributes;

	public ClassFile(ClassGroup group, DataInputStream is) throws IOException
	{
		this.group = group;
		this.is = is;

		int magic = is.readInt();
		if (magic != MAGIC)
			throw new IOException("File is not a java class file.");

		minor_version = is.readShort();
		major_version = is.readShort();

		pool = new ConstantPool(this, is);

		access_flags = is.readShort();
		name = pool.getClass(is.readUnsignedShort());
		super_class = pool.getClass(is.readUnsignedShort());

		interfaces = new Interfaces(this);

		fields = new Fields(this);

		methods = new Methods(this);

		attributes = new Attributes(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeInt(MAGIC);
		
		out.writeShort(minor_version);
		out.writeShort(major_version);
		
		/* constant pool will be rebuilt now */
		pool.reset();
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream rest = new DataOutputStream(bout);
		rest.writeShort(access_flags);
		rest.writeShort(pool.make(name));
		rest.writeShort(pool.make(super_class));
		
		interfaces.write(rest);
		
		fields.write(rest);
		
		methods.write(rest);
		
		attributes.write(rest);
		
		// Now the pool is created
		
		pool.write(out);
		out.write(bout.toByteArray());
	}

	public ClassGroup getGroup()
	{
		return group;
	}

	public DataInputStream getStream()
	{
		return is;
	}

	public ConstantPool getPool()
	{
		return pool;
	}
	
	public Interfaces getInterfaces()
	{
		return interfaces;
	}

	public Fields getFields()
	{
		return fields;
	}
	
	public Methods getMethods()
	{
		return methods;
	}

	public String getName()
	{
		return name.getName();
	}
	
	public void setName(String name)
	{
		this.name = new Class(name);
	}
	
	public Class getParentClass()
	{
		return this.super_class;
	}
	
	public void setParentClass(Class c)
	{
		super_class = c;
	}

	public ClassFile getParent()
	{
		return parent;
	}
	
	public List<ClassFile> getChildren()
	{
		return children;
	}

	public Field findFieldDeep(NameAndType nat)
	{
		Field f = fields.findField(nat);
		if (f != null)
			return f;

		ClassFile parent = getParent();
		if (parent != null)
			return parent.findFieldDeep(nat);

		return null;
	}
	
	public Method findMethodDeep(NameAndType nat)
	{
		Method m = methods.findMethod(nat);
		if (m != null)
			return m;

		ClassFile parent = getParent();
		if (parent != null)
			return parent.findMethodDeep(nat);

		return null;
	}
	
	public Method findMethodDeepStatic(NameAndType nat)
	{
		Method m = methods.findMethod(nat);
		if (m != null && m.isStatic())
			return m;

		ClassFile parent = getParent();
		if (parent != null)
			return parent.findMethodDeep(nat);

		return null;
	}
	
	public Method findMethod(NameAndType nat)
	{
		return methods.findMethod(nat);
	}
	
	public Method findMethod(String name)
	{
		return methods.findMethod(name);
	}
	
	public Method findMethodDeep(String name)
	{
		Method m = methods.findMethod(name);
		if (m != null)
			return m;
		
		ClassFile parent = getParent();
		if (parent != null)
			return parent.findMethodDeep(name);

		return null;
	}
	
	public void clearClassGraph()
	{
		parent = null;
		children.clear();
	}

	public void buildClassGraph()
	{
		ClassFile other = group.findClass(super_class.getName());
		if (other != null)
		{
			this.parent = other;
			parent.children.add(this);
		}
		
		for (ClassFile i : interfaces.getMyInterfaces())
		{
			i.children.add(this);
		}
	}

	public void buildInstructionGraph()
	{
		methods.buildInstructionGraph();
	}
	
	public boolean instanceOf(ClassFile other)
	{
		return this == other || interfaces.instanceOf(other) || (getParent() != null && getParent().instanceOf(other));
	}
}
