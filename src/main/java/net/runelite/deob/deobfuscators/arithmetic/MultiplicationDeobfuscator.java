package net.runelite.deob.deobfuscators.arithmetic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.BiPush;
import net.runelite.deob.attributes.code.instructions.Dup;
import net.runelite.deob.attributes.code.instructions.Dup_X1;
import net.runelite.deob.attributes.code.instructions.IAdd;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.ISub;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.attributes.code.instructions.SiPush;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class MultiplicationDeobfuscator implements Deobfuscator
{
	private ClassGroup group;
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		
		int i;
		int count = 0;
		while ((i = runOnce()) > 0)
		{
			System.out.println("Replaced " + i + " constants");
			count += i;
		}
		System.out.println("Total changed " + count);
	}
	
	private MultiplicationExpression parseExpression(InstructionContext ctx)
	{
		MultiplicationExpression me = new MultiplicationExpression();
		
		assert !(ctx.getInstruction() instanceof DupInstruction);
		
		if (ctx.getInstruction() instanceof PushConstantInstruction)
		{
			if (ctx.getInstruction() instanceof BiPush || ctx.getInstruction() instanceof SiPush)
			{
				throw new IllegalStateException();
			}

			me.instructions.add(ctx);
			return me;
		}
		
		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext i = sctx.getPushed();
			
//			int count2 = 0;
//			while (i.getInstruction() instanceof DupInstruction)
//			{
//				DupInstruction dup = (DupInstruction) i.getInstruction();
//				sctx = dup.resolve(sctx);
//				i = sctx.getPushed();
//				
//				++count2;
//				assert count2 < 10;
//				//assert !(i.getInstruction() instanceof DupInstruction);
//			}
			
			// if this instruction is imul, look at pops
			if (ctx.getInstruction() instanceof IMul)
			{
				if (i.getInstruction() instanceof PushConstantInstruction)
				{
					if (i.getInstruction() instanceof BiPush || i.getInstruction() instanceof SiPush)
						throw new IllegalStateException();
					
					// a constant of imul
					me.instructions.add(i);
				}
				else if (i.getInstruction() instanceof IMul)
				{
					// chained imul, append to me
					try
					{
						MultiplicationExpression other = parseExpression(i);

						me.instructions.addAll(other.instructions);
						me.subexpressions.addAll(other.subexpressions);
					}
					catch (IllegalStateException ex)
					{
						// this is ok? just don't include it?
					}
				}
				else if (i.getInstruction() instanceof IAdd || i.getInstruction() instanceof ISub)
				{
					// imul using result of iadd or isub. evaluate expression
					try
					{
						MultiplicationExpression other = parseExpression(i);

						// subexpr
						//if (other != null)
							me.subexpressions.add(other);
					}
					catch (IllegalStateException ex)
					{
						assert me.subexpressions.isEmpty();
						// subexpression is too complex. we can still simplify the top level though
					}
				}
				else if (i.getInstruction() instanceof DupInstruction)
				{
					if(true) throw new IllegalStateException();
					DupInstruction dup = (DupInstruction) i.getInstruction();
					
					//if (dup instanceof Dup || dup instanceof Dup_X1)
					{
					
						// find other branch of the dup instruction
						// sctx = what dup pushed, find other
						StackContext otherCtx = dup.getOtherBranch(sctx); // other side of dup
						InstructionContext otherCtxI = otherCtx.getPopped(); // would insert imul here?

						if (otherCtxI.getInstruction() instanceof IMul)
						{
							//assert otherCtxI.getInstruction() instanceof IMul;

							InstructionContext pushConstant = otherCtxI.getPops().get(0).getPushed();
							assert pushConstant.getInstruction() instanceof LDC_W;

							me.dupmagic = pushConstant;

							StackContext orig = dup.getOriginal(sctx); // original
							try
							{
								MultiplicationExpression other = parseExpression(orig.getPushed());
								me.subexpressions.add(other);
							}
							catch (IllegalStateException ex)
							{
								assert me.subexpressions.isEmpty();
							}
						}
						else
						{
							System.out.println("dup ins " + otherCtxI.getInstruction());
							throw new IllegalStateException();
						}
					}
				}
				else if (i.getInstruction() instanceof GetFieldInstruction)
				{
					// non constant, ignore
				}
				else
				{
					//throw new IllegalStateException();
					//System.out.println("imul pops something I don't know " + i.getInstruction());
				}
			}
			// this is an iadd/sub
			else if (ctx.getInstruction() instanceof IAdd || ctx.getInstruction() instanceof ISub)
			{
				MultiplicationExpression other = parseExpression(i); // parse this side of the add/sub
				
				//if (other != null)
					me.subexpressions.add(other);
			}
			else
			{
				//throw new IllegalStateException();
				//System.out.println(ctx.getInstruction() + " pops something I dont know " + i.getInstruction());
			}
//			else if (i.getInstruction() instanceof PushConstantInstruction)
//			{
//				me.instructions.add(i);
//				//PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
//				//int value = (int) pci.getConstant().getObject();
//				//if (value != 1) // already been touched, otherwise we keep multiplying the same ins over and over
//				//	l.add(i);
//			}
//			else if (i.getInstruction() instanceof IAdd || i.getInstruction() instanceof ISub)
//			{
//				MultiplicationExpression other = parseExpression(i);
//				
//				me.subexpressions.add(other);
//			}
		}
		
		if (me.instructions.isEmpty() && me.subexpressions.isEmpty())
			throw new IllegalStateException();
			//return null;
		
		return me;
	}
	
	private boolean isOnlyPath(Execution execution, InstructionContext ctx)
	{
		Collection<InstructionContext> ins = execution.getInstructonContexts(ctx.getInstruction());
		for (InstructionContext i : ins)
		//for (Frame f : execution.processedFrames)
		//	if (f.getMethod() == frame.getMethod())
		//		for (InstructionContext i : f.getInstructions())
					//if (i.getInstruction() == ctx.getInstruction())
					{
						if (!i.equals(ctx))
						{
							return false;
						}
					}
		return true;
	}
	
	private Set<Instruction> done = new HashSet<>();
	
	private int runOnce()
	{
		group.buildClassGraph();
		
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		
		int count = 0;
		
		for (Frame frame : e.processedFrames)
			outer:
			for (InstructionContext ictx : frame.getInstructions())
			{
				Instruction instruction = ictx.getInstruction();
				Instructions instructions = instruction.getInstructions();
				
//				if (!frame.getMethod().getMethods().getClassFile().getName().equals("class118"))
//					continue;
				
				if (!(instruction instanceof IMul))
					continue;
				
				MultiplicationExpression expression;
				try
				{
					 expression = parseExpression(ictx);
				}
				catch (IllegalStateException ex)
				{
					continue;
				}
				
				if (expression == null)
					continue;
				
				//if (expression.subexpressions.isEmpty())
				//	continue;
				
				// there can only be one path to here, or else combinging would change code logic
				if (!isOnlyPath(e, ictx))
					continue;
				
								
				if (done.contains(instruction))
					continue;
				done.add(instruction);
				
				count += expression.simplify(1);
				if (MultiplicationExpression.replace)
				{
					assert false;
					MultiplicationExpression.replace = false;
					return count;
				}
				//break;
//				List<InstructionContext> ins = getConstants(ictx);
//				
//				if (ins.size() == 1)
//					continue;
//				
//				for (InstructionContext i : ins)
//				{
//					if (done.contains(i.getInstruction()))
//					{
//						continue outer;
//					}
//				}
//				
//				// there can only be one path to here, or else combinging would change code logic
//				if (!isOnlyPath(e, frame, ictx))
//					continue;
//				
//				int result = 1;
//				
//				// calculate result
//				for (InstructionContext i : ins)
//				{
//					PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
//					int value = (int) pci.getConstant().getObject();
//					
//					result *= value;
//				}
//				
//				// set result on ins
//				for (InstructionContext i : ins)
//				{
//					PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
//					Instruction newIns = pci.setConstant(new net.runelite.deob.pool.Integer(result));
//					++count;
//					if (newIns != pci)
//					{
//						instructions.replace((Instruction) pci, newIns);
//					}
//					result = 1; // rest of the results go to 1
//				}
//				
//				for (InstructionContext i : ins)
//					done.add(i.getInstruction());
			}
		
		return count;
	}

}
