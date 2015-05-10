package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.Field;
import info.sigterm.deob.Fields;
import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.ConstantValue;
import info.sigterm.deob.pool.NameAndType;

import java.util.ArrayList;

public class ClassInstance
{
	private Path path;
	private ClassFile clazz;
	private ArrayList<StaticFieldInstance> fields = new ArrayList<StaticFieldInstance>();

	public ClassInstance(Path path, ClassFile clazz)
	{
		this.path = path;
		this.clazz = clazz;

		/* initialize static fields */
		Fields fields = clazz.getFields();
		for (Field field : fields.getFields())
			if ((field.getAccessFlags() & Field.ACC_STATIC) != 0)
			{
				Attributes attributes = field.getAttributes();
				ConstantValue cv = (ConstantValue) attributes.findType(AttributeType.CONSTANT_VALUE);

				StaticFieldInstance fi = new StaticFieldInstance(this, field, cv);
				this.fields.add(fi);
			}
	}
	
	protected ClassInstance(Path path, ClassInstance other)
	{
		this.path = path;
		this.clazz = other.clazz;
		for (StaticFieldInstance f : other.fields)
			this.fields.add(new StaticFieldInstance(other, f));
	}

	public Path getPath()
	{
		return path;
	}

	public ClassFile getClassFile()
	{
		return clazz;
	}

	public StaticFieldInstance findStaticField(NameAndType nat)
	{
		for (StaticFieldInstance f : fields)
				if (f.getField().getName().equals(nat.getName()) && f.getField().getType().equals(nat.getDescriptorType()))
					return f;
		return null;
	}
}
