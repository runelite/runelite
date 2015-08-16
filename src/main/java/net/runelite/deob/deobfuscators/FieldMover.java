package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.pool.NameAndType;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.map.MultiValueMap;

public class FieldMover implements Deobfuscator
{
	private static final String mainClass = "client";
	
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
	
	private boolean isDowncastable(ClassFile from, ClassFile to)
	{
		while (from != null && from != to)
		{
			from = from.getParent();
		}
		
		return from != null;
	}
	
	private ClassFile getBase(ClassFile one, ClassFile two)
	{
		if (one == two)
			return one;
		
		if (isDowncastable(one, two))
			return two;
		
		if (isDowncastable(two, one))
			return one;
		
		return null;
	}
	
	private ClassFile findCommonBase(Collection<ClassFile> classes)
	{
		List<ClassFile> list = new ArrayList<>(classes);
		
		if (list.size() == 1)
			return list.get(0);
		
//		ClassFile cf = getBase(list.get(0), list.get(1));
//		
//		for (int i = 2; i < list.size(); ++i)
//			cf = getBase(cf, list.get(i));
//		
//		return cf;
		return null; // to do this, would have to move static initializer
	}
	
	private int moveFields()
	{
		int count = 0;
		
		for (Field field : fields.keySet())
		{
			Collection<ClassFile> cfs = fields.getCollection(field);
			
			ClassFile to = findCommonBase(cfs);
			if (to == null)
				continue;
				// no common base, move to entry class
				//to = group.findClass(mainClass);
			
			assert to != null;
			
			if (field.getFields().getClassFile() == to)
				continue;
			
			moveField(field, to);
			++count;
		}
		
		return count;
	}
	
	private void moveField(Field field, ClassFile to)
	{
		assert field.getFields().getClassFile() != to;
		
		net.runelite.deob.pool.Field newField = new net.runelite.deob.pool.Field(
			new net.runelite.deob.pool.Class(to.getName()),
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
		int count = moveFields();
		
		System.out.println("Moved " + count + " fields");
	}
	
}
