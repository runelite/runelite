package net.runelite.deob.deobfuscators;

import java.util.List;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;

public class Rename
{
	private static boolean isExpressionInstruction(Instruction in)
	{
		return
			in instanceof SetFieldInstruction ||
			(in instanceof LVTInstruction && ((LVTInstruction) in).store()) ||
			in instanceof InvokeInstruction ||
			in instanceof ComparisonInstruction;
	}
	
	private static List<Instruction> getExprIns(Frame frame)
	{
		return frame.getInstructions().stream().map(i -> i.getInstruction()).filter(i -> isExpressionInstruction(i)).collect(Collectors.toList());
	}
	
	private static boolean equalsFrames(Frame one, Frame two)
	{
		List<Instruction> oneIns = getExprIns(one),
			twoIns = getExprIns(two);
		
		if (oneIns.size() != twoIns.size() || oneIns.isEmpty())
			return false;
		
		for (int i = 0; i < oneIns.size(); ++i)
		{
			Instruction i1 = oneIns.get(i),
				i2 = twoIns.get(i);
			
			if (i1.getType() != i2.getType())
				return false;
		}
		
		if (one.getMethod().getName().startsWith("method") && two.getMethod().getName().startsWith("method"))
		{
			int i =5;
		}
		return true;
	}
	
	public void run(ClassGroup one, ClassGroup two)
	{
		Execution ex1 = new Execution(one);
		ex1.populateInitialMethods();
		ex1.run();
		
		Execution ex2 = new Execution(two);
		ex2.populateInitialMethods();
		ex2.run();
		
		for (Frame f : ex1.processedFrames)
			for (Frame f2 : ex2.processedFrames)
			{
				if (f.getMethod().getName().equals("vmethod2976") && f2.getMethod().getName().equals("vmethod2973"))
				{
					if (equalsFrames(f, f2))
						System.out.println(f.getMethod().getName() + " " + f2.getMethod().getName());
				}
			}
	}
}
