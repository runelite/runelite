package info.sigterm.deob.execution;

import info.sigterm.deob.Field;
import info.sigterm.deob.Fields;
import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.ConstantValue;
import info.sigterm.deob.pool.NameAndType;

import java.util.ArrayList;

public class ObjectInstance extends ObjectInstanceBase
{
	private ArrayList<FieldInstance> fields = new ArrayList<FieldInstance>();
	
	public ObjectInstance(Path path, ClassInstance type)
	{
		super(path, type);
		
		/* create fields */
		Fields fields = type.getClassFile().getFields();
		for (Field field : fields.getFields())
		{
			if ((field.getAccessFlags() & Field.ACC_STATIC) != 0)
				continue;
			
			Attributes attributes = field.getAttributes();
			ConstantValue cv = (ConstantValue) attributes.findType(AttributeType.CONSTANT_VALUE);

			FieldInstance fi = new FieldInstance(this, field, cv != null ? cv.getValue().getObject() : null);
			this.fields.add(fi);
		}
	}
	
	private ObjectInstance(ObjectInstance other, Path path, ClassInstance type)
	{
		super(path, type);
		
		/* copy fields */
		for (FieldInstance field : other.fields)
			this.fields.add(new FieldInstance(this, field));
	}
	
	public FieldInstance getField(NameAndType nat)
	{
		for (FieldInstance f : fields)
			if (f.getField().getName().equals(nat.getName()) && f.getField().getType().equals(nat.getDescriptorType()))
				return f;
		return null;
	}

	@Override
	public ObjectInstanceBase dup(Path path, ClassInstance type)
	{
		return new ObjectInstance(this, path, type);
	}
}
