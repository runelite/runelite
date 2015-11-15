package net.runelite.deob.execution;

import edu.ucla.sspace.graph.Graph;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.Goto;
import net.runelite.deob.attributes.code.instructions.IConst_0;
import net.runelite.deob.attributes.code.instructions.If0;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.attributes.code.instructions.NOP;
import net.runelite.deob.attributes.code.instructions.VReturn;
import net.runelite.deob.signature.Signature;
import org.junit.Assert;
import org.junit.Test;

public class FrameTest
{
	// invoke instruction,
	// conditional jump out,
	// both jump in,
	// jump,
	// invoke
	// check that num edges = 4
	@Test
	public void testGraph()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();
		
		code.setMaxStack(1);
		
		Method void1 = group.findClass("test").findMethod("void1"),
			void2 = group.findClass("test").findMethod("void2"),
			void3 = group.findClass("test").findMethod("void3"),
			void4 = group.findClass("test").findMethod("void4");
		
		NOP label1 = new NOP(ins),
			label2 = new NOP(ins),
			label3 = new NOP(ins);
		
		Instruction body[] = {
			new InvokeStatic(ins, void1.getPoolMethod()),
			
			new IConst_0(ins),
			new If0(ins, label1),
			
			new InvokeStatic(ins, void2.getPoolMethod()),
			new Goto(ins, label2),
			
			label1,
			new InvokeStatic(ins, void3.getPoolMethod()),
			
			label2,
			// do something dumb
			
			new Goto(ins, label3),
			label3,
			
			new InvokeStatic(ins, void4.getPoolMethod()),
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		Execution e = new Execution(group);
		e.setBuildGraph(true);
		e.populateInitialMethods();
		e.run();
		
		Graph graph = e.processedFrames.get(0).getMethodCtx().getGraph();
		Assert.assertEquals(4, graph.size());
	}
	
	// invoke instruction,
	// conditional jump out,
	// both jump in,
	// invoke
	// check that num edges = 4
	@Test
	public void testGraph2()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();
		
		code.setMaxStack(1);
		
		Method void1 = group.findClass("test").findMethod("void1"),
			void2 = group.findClass("test").findMethod("void2"),
			void3 = group.findClass("test").findMethod("void3"),
			void4 = group.findClass("test").findMethod("void4");
		
		NOP label1 = new NOP(ins),
			label2 = new NOP(ins);
		
		Instruction body[] = {
			new InvokeStatic(ins, void1.getPoolMethod()),
			
			new IConst_0(ins),
			new If0(ins, label1),
			
			new InvokeStatic(ins, void2.getPoolMethod()),
			new Goto(ins, label2),
			
			label1,
			new InvokeStatic(ins, void3.getPoolMethod()),
			
			label2,
			// do something dumb
			
			new InvokeStatic(ins, void4.getPoolMethod()),
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		Execution e = new Execution(group);
		e.setBuildGraph(true);
		e.populateInitialMethods();
		e.run();
		
		Graph graph = e.processedFrames.get(0).getMethodCtx().getGraph();
		Assert.assertEquals(4, graph.size());
	}
}
