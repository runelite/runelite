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

			FieldInstance fi = new FieldInstance(this, field, cv.getValue().getObject());
			this.fields.add(fi);
		}
	}
	
	public FieldInstance getField(NameAndType nat)
	{
		for (FieldInstance f : fields)
			if (f.getField().getName().equals(nat.getName()) && f.getField().getDescriptor().equals(nat.getDescriptor()))
				return f;
		return null;
	}
}
