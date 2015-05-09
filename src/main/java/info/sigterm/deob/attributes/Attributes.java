package info.sigterm.deob.attributes;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Attributes
{
	private ClassFile classFile;
	private Field field;
	private Method method;
	private Code code;

	private List<Attribute> attributes = new ArrayList<>();

	public Attributes(ClassFile cf) throws IOException
	{
		classFile = cf;

		load();
	}

	public Attributes(Field f) throws IOException
	{
		field = f;

		load();
	}

	public Attributes(Method m) throws IOException
	{
		method = m;

		load();
	}

	public Attributes(Code c) throws IOException
	{
		code = c;

		load();
	}
	
	public Method getMethod()
	{
		return method;
	}

	public Attribute findType(AttributeType type)
	{
		for (Attribute a : attributes)
			if (a.getType() == type)
				return a;
		return null;
	}

	public ClassFile getClassFile()
	{
		if (classFile != null)
			return classFile;

		if (field != null)
			return field.getFields().getClassFile();

		if (method != null)
			return method.getMethods().getClassFile();

		if (code != null)
			return code.getAttributes().getClassFile();

		return null;
	}

	public DataInputStream getStream()
	{
		return getClassFile().getStream();
	}

	private void load() throws IOException
	{
		DataInputStream is = getStream();

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
		{
			String name = this.getClassFile().getPool().getUTF8(is.readUnsignedShort());

			AttributeType type = AttributeType.findType(name);
			try
			{
				Constructor<? extends Attribute> con = type.getAttributeClass().getConstructor(new Class[] { Attributes.class });
				Attribute attr = con.newInstance(this);

				if (type != AttributeType.UNKNOWN)
					attributes.add(attr);
			}
			catch (Exception ex)
			{
				throw new IOException(ex);
			}
		}
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(attributes.size());
		for (Attribute a : attributes)
		{
			out.writeShort(this.getClassFile().getPool().makeUTF8(a.getType().getName()));
			a.write(out);
		}
	}
}
