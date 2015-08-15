package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.FieldInstruction;
import info.sigterm.deob.pool.NameAndType;
import java.util.Collection;
import org.apache.commons.collections4.map.MultiValueMap;

public class FieldMover implements Deobfuscator
{
	private ClassGroup group;
	private MultiValueMap<Field, ClassFile> fields = new MultiValueMap<>();
	
	private void findUses()
	{
		fields.clear();
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				for (Instruction i : code.getInstructions().getInstructions())
				{
					if (!(i instanceof FieldInstruction))
						continue;
					
					FieldInstruction fi = (FieldInstruction) i;
					Field field = fi.getMyField();
					
					if (field == null)
						continue;
					
					if (!field.isStatic())
						continue;
					
					if (fields.containsKey(field))
					{
						Collection<ClassFile> col = fields.getCollection(field);
						if (!col.contains(cf))
							fields.put(field, cf);
					}
					else
						fields.put(field, cf);
				}
			}
		}
	}
	
	private int moveFields()
	{
		int count = 0;
		
		for (Field field : fields.keySet())
		{
			Collection<ClassFile> cfs = fields.getCollection(field);
			
			if (cfs.size() != 1)
			{
				// XXX clinit
				continue;
			}
			
			ClassFile cf = cfs.iterator().next();
			
			if (field.getFields().getClassFile() == cf)
				continue;
			
			moveField(field, cf);
			++count;
		}
		
		return count;
	}
	
	private void moveField(Field field, ClassFile to)
	{
		assert field.getFields().getClassFile() != to;
		
		info.sigterm.deob.pool.Field newField = new info.sigterm.deob.pool.Field(
			new info.sigterm.deob.pool.Class(to.getName()),
			new NameAndType(field.getName(), field.getType())
		);
		
		// move on instructions
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				code.getInstructions().renameField(field, newField);
			}
		}
		
		// move the field
		field.getFields().getFields().remove(field);
		to.getFields().getFields().add(field);
		field.setFields(to.getFields());
	}

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		this.group = group;
		findUses();
		moveFields();
	}
	
}
