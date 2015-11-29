package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class Rename
{
	private List<Instruction> getInstructionsInMethodInclStatic(Method method, Set<Method> visited)
	{
		List<Instruction> ilist = new ArrayList<>();
		
		if (visited.contains(method))
			return ilist;
		visited.add(method);
		
		Code code = method.getCode();
		if (code == null)
			return ilist;
		
		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (i instanceof InvokeStatic)
			{
				InvokeInstruction ii = (InvokeInstruction) i;
				List<Method> methods = ii.getMethods();
				
				if (methods.isEmpty())
					continue;
				
				Method m = methods.get(0);
				ilist.addAll(this.getInstructionsInMethodInclStatic(m, visited));
			}
			else
			{
				ilist.add(i);
			}
		}
		
		return ilist;
	}
	
	@Test
	public void test() throws IOException
	{
		ClassGroup one = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar")), two = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Execution eone = new Execution(one);
		eone.setBuildGraph(true);
		eone.populateInitialMethods();
		eone.run();
		
		Execution etwo = new Execution(two);
		etwo.setBuildGraph(true);
		etwo.populateInitialMethods();
		etwo.run();
		
//		Method m1 = one.findClass("client").findMethod("vmethod3096"), m2 = two.findClass("client").findMethod("vmethod2975");
//		
//		List<SetFieldInstruction> l1 = (List<SetFieldInstruction>) getInstructionsInMethodInclStatic(m1, new HashSet()).stream().filter(i -> i instanceof SetFieldInstruction).collect(Collectors.toList()),
//			l2 = (List<SetFieldInstruction>) getInstructionsInMethodInclStatic(m2, new HashSet()).stream().filter(i -> i instanceof SetFieldInstruction).collect(Collectors.toList());
//		
//		
//		List<Field> lf1 =(List)  l1.stream().filter(i -> i.getMyField() != null).map(i -> i.getMyField()).distinct().collect(Collectors.toList()),
//			lf2 = l2.stream().filter(i -> i.getMyField() != null).map(i -> i.getMyField()).distinct().collect(Collectors.toList());
//		
//		for (int i = 0; i< 100; ++i)
//		{
//			Field f1 = lf1.get(i), f2 = lf2.get(i);
//			
//			System.out.println(f1 + " <-> " + f2);
//		}
		// number of setfields
		//List<Frame> f1 = eone.processedFrames.stream().filter(f -> f.getMethod() == m1).collect(Collectors.toList()),
		//	f2 = etwo.processedFrames.stream().filter(f -> f.getMethod() == m2).collect(Collectors.toList());
		
		//System.out.println(ll1);
	}
}
