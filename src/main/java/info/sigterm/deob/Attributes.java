package info.sigterm.deob;

import info.sigterm.deob.attributes.Attribute;
import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class Attributes
{
	private ClassFile classFile;
	private Field field;
	private Method method;
	private Code code;

	private int count;
	private Attribute[] attributes;

	Attributes(ClassFile cf) throws IOException
	{
		classFile = cf;

		load();
	}

	Attributes(Field f) throws IOException
	{
		field = f;

		load();
	}

	Attributes(Method m) throws IOException
	{
		method = m;

		load();
	}

	public Attributes(Code c) throws IOException
	{
		code = c;

		load();
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

		count = is.readUnsignedShort();
		attributes = new Attribute[count];

		for (int i = 0; i < count; ++i)
		{
			int nameIndex = is.readUnsignedShort();
			UTF8 name = (UTF8) getClassFile().getPool().getEntry(nameIndex);

			AttributeType type = AttributeType.findType(name.getValue());
			try
			{
				Constructor<? extends Attribute> con = type.getAttributeClass().getConstructor(new Class[] { Attributes.class });
				Attribute attr = con.newInstance(this);

				attributes[i] = attr;
			}
			catch (Exception ex)
			{
				throw new IOException(ex);
			}
		}
	}
}
