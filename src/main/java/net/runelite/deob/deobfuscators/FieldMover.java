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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.PutStatic;
import net.runelite.deob.attributes.code.instructions.VReturn;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.signature.Signature;
import org.apache.commons.collections4.map.MultiValueMap;

public class FieldMover implements Deobfuscator
{
	private static final String mainClass = "client";
	
	private Execution execution;
	private ClassGroup group;
	private MultiValueMap<Field, ClassFile> fields = new MultiValueMap<>();
	private Map<Field, PutStatic> clinits = new HashMap<>();
	
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
					
					if (m.getName().equals("<clinit>"))
					{
						if (fi instanceof PutStatic)
							clinits.put(field, (PutStatic) fi);
					}
					else
					{
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
		
		ClassFile cf = getBase(list.get(0), list.get(1));
		
		for (int i = 2; i < list.size(); ++i)
			cf = getBase(cf, list.get(i));
		
		return cf;
	}
	
	private int moveFields()
	{
		int count = 0;
		
		for (Field field : fields.keySet())
		{
			Collection<ClassFile> cfs = fields.getCollection(field);
			
			ClassFile to = findCommonBase(cfs);
			if (to == null)
				// no common base, move to entry class
				to = group.findClass(mainClass);
			
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
		
		// move initializer
		PutStatic setField = clinits.get(field);
		if (setField == null)
			return; // no initializer
		
		Method toClinit = to.findMethod("<clinit>");
		if (toClinit == null)
		{
			//  make clinit
			
			Signature sig = new Signature("()V");
			toClinit = new Method(to.getMethods(), "<clinit>", sig);
			
			Attributes attributes = toClinit.getAttributes();
			Code code = new Code(attributes);

			attributes.addAttribute(code);
			
			// make instructions
			Instructions instructions = new Instructions(code);
			code.setInstructions(instructions);
			
			instructions.getInstructions().add(new VReturn(instructions, InstructionType.RETURN, 0)); // add return
		}
		
		moveInitializer(setField, toClinit);
	}
	
	private void moveInitializer(PutStatic setInstruction, Method to)
	{
		// find instruction in execution and remove it
		InstructionContext setCtx = null;
		List<StackContext> ctxs = null;
		for (Frame frame : execution.processedFrames)
			for (InstructionContext ctx : frame.getInstructions())
			{
				if (ctx.getInstruction() != setInstruction)
					continue;
				
				setCtx = ctx;
				
				// get instructions before recursive stack removal
				//List<Instruction> oldIns = new ArrayList<>(frame.getMethod().getCode().getInstructions().getInstructions());
				
				ctxs = ctx.removeStack(0); //remove
				
				//List<Instruction> newIns = new ArrayList<>(frame.getMethod().getCode().getInstructions().getInstructions());
				
				//changedIns = CollectionUtils.disjunction(oldIns, newIns);
				break;
			}
		
		if (setCtx == null)
		{
			System.err.println("Unable to locate context for putstatic when moving field initializer");
			return;
		}
		
		// insert instructions into method
	}

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		this.group = group;
		findUses();
		int count = moveFields();
		
		System.out.println("Moved " + count + " fields");
	}
	
}
