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
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.BiPush;
import net.runelite.deob.attributes.code.instructions.IAdd;
import net.runelite.deob.attributes.code.instructions.IConst_M1;
import net.runelite.deob.attributes.code.instructions.IInc;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.ISub;
import net.runelite.deob.attributes.code.instructions.LAdd;
import net.runelite.deob.attributes.code.instructions.LDC2_W;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.attributes.code.instructions.LMul;
import net.runelite.deob.attributes.code.instructions.LSub;
import net.runelite.deob.attributes.code.instructions.SiPush;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;

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
	
	public static MultiplicationExpression parseExpression(Execution e, InstructionContext ctx, Class want)
	{
		MultiplicationExpression me = new MultiplicationExpression();
		
//		assert !(ctx.getInstruction() instanceof DupInstruction);
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			
			// loading a variable
			if (!lvt.store())
			{
				int idx = lvt.getVariableIndex(); // var index
				Variables vars = ctx.getVariables(); // variables at time of execution
				
				VariableContext vctx = vars.get(idx); // get the variable
				
				if (vctx.getRead().size() == 1) // ?
				{
					InstructionContext storeCtx = vctx.getInstructionWhichStored(); // this is an istore
					if (storeCtx.getInstruction() instanceof LVTInstruction)
					{
						// invoking funcs can put stuff in lvt
						
						LVTInstruction storelvt = (LVTInstruction) storeCtx.getInstruction();

						if (storelvt instanceof IInc)
							throw new IllegalStateException();

						assert storelvt.store();

						InstructionContext pushed = storeCtx.getPops().get(0).getPushed();
						return parseExpression(e, pushed, want);
					}
				}
			}
		}
		
		if (ctx.getInstruction() instanceof PushConstantInstruction)
		{
			if (ctx.getInstruction() instanceof BiPush || ctx.getInstruction() instanceof SiPush
				|| ctx.getInstruction() instanceof IConst_M1)
			{
				throw new IllegalStateException();
			}

			me.instructions.add(ctx);
			return me;
		}
		
		for (StackContext sctx : ctx.getPops())
		{
			if (ctx.getInstruction().getClass() == want)
			{
				if (!isOnlyPath(e, ctx, sctx))
					continue;
			}
			
			InstructionContext i = sctx.getPushed();
			
			// if this instruction is imul, look at pops
			if (ctx.getInstruction().getClass() == want)
			{
				if (i.getInstruction() instanceof PushConstantInstruction)
				{
					if (i.getInstruction() instanceof BiPush || i.getInstruction() instanceof SiPush)
						throw new IllegalStateException();
					
					// a constant of imul
					me.instructions.add(i);
				}
				else if (i.getInstruction().getClass() == want)
				{
					// chained imul, append to me
					try
					{
						MultiplicationExpression other = parseExpression(e, i, want);

						me.instructions.addAll(other.instructions);
						me.subexpressions.addAll(other.subexpressions);
					}
					catch (IllegalStateException ex)
					{
						// this is ok? just don't include it?
					}
				}
				else if (i.getInstruction() instanceof IAdd || i.getInstruction() instanceof ISub
					|| i.getInstruction() instanceof LAdd || i.getInstruction() instanceof LSub)
				{
					// imul using result of iadd or isub. evaluate expression
					try
					{
						MultiplicationExpression other = parseExpression(e, i, want);

						// subexpr
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
					DupInstruction dup = (DupInstruction) i.getInstruction();
					
					// find other branch of the dup instruction
					// sctx = what dup pushed, find other
					StackContext otherCtx = dup.getOtherBranch(sctx); // other side of dup
					InstructionContext otherCtxI = otherCtx.getPopped().get(0); // is this irght?

					if (otherCtxI.getInstruction().getClass() == want)
					{
						//assert otherCtxI.getInstruction() instanceof IMul;

						InstructionContext pushConstant = otherCtxI.getPops().get(0).getPushed();
						assert pushConstant.getInstruction() instanceof LDC_W || pushConstant.getInstruction() instanceof LDC2_W;

						me.dupmagic = pushConstant;

						StackContext orig = dup.getOriginal(sctx); // original
						try
						{
							MultiplicationExpression other = parseExpression(e, orig.getPushed(), want);
							// this expression is used elsewhere like 'pushConstant' so any changes
							// done to it affect that, too. so multiply it by existing values?
							if (orig.getPushed().getInstruction() instanceof IAdd || orig.getPushed().getInstruction() instanceof ISub
								|| orig.getPushed().getInstruction() instanceof LAdd || orig.getPushed().getInstruction() instanceof LSub)
							{
								me.subexpressions.add(other);
							}
							else
							{
								me.instructions.addAll(other.instructions);
								me.dupedInstructions.addAll(other.instructions);
								me.subexpressions.addAll(other.subexpressions);
							}
						}
						catch (IllegalStateException ex)
						{
							assert me.subexpressions.isEmpty();
						}
					}
					else
					{
						System.out.println("dup ins " + otherCtxI.getInstruction());
					}
				}
				else if (i.getInstruction() instanceof GetFieldInstruction)
				{
					me.fieldInstructions.add(i);
					// non constant, ignore
				}
				else
				{
					//System.out.println("imul pops something I don't know " + i.getInstruction());
				}
			}
			// this is an iadd/sub
			else if (ctx.getInstruction() instanceof IAdd || ctx.getInstruction() instanceof ISub
				|| ctx.getInstruction() instanceof LAdd || ctx.getInstruction() instanceof LSub)
			{
				MultiplicationExpression other = parseExpression(e, i, want); // parse this side of the add/sub
				
				me.subexpressions.add(other);
			}
			else
			{
				//System.out.println(ctx.getInstruction() + " pops something I dont know " + i.getInstruction());
			}
		}
		
		if (me.instructions.isEmpty() && me.subexpressions.isEmpty())
			throw new IllegalStateException();
		
		return me;
	}
	
	public static boolean isOnlyPath(Execution execution, InstructionContext ctx)
	{
		assert ctx.getInstruction() instanceof IMul || ctx.getInstruction() instanceof LMul;
		
		Collection<InstructionContext> ins = execution.getInstructonContexts(ctx.getInstruction());
		for (InstructionContext i : ins)
		{
			if (!i.equals(ctx))
			{
				return false;
			}

			for (StackContext sctx : i.getPushes())
				if (sctx.getPopped().size() > 1)
					return false;
		}
		return true;
	}
	
	private static boolean ictxEqualsDir(InstructionContext one, InstructionContext two, StackContext sctx)
	{
		if (one.getInstruction() != two.getInstruction())
			return false;
		
		assert one.getPops().contains(sctx);
		int i = one.getPops().indexOf(sctx);
		
		StackContext theirsctx = two.getPops().get(i);
	
		if (sctx.getPushed().getInstruction() != theirsctx.getPushed().getInstruction())
			return false;
		
		return true;
	}
	
	public static boolean isOnlyPath(Execution execution, InstructionContext ctx, StackContext sctx)
	{
		assert ctx.getInstruction() instanceof IMul || ctx.getInstruction() instanceof LMul;
		
		Collection<InstructionContext> ins = execution.getInstructonContexts(ctx.getInstruction());
		for (InstructionContext i : ins)
		{
			if (!ictxEqualsDir(ctx, i, sctx))
			{
				return false;
			}

			Instruction poppedIns = null;
			for (StackContext s : i.getPushes())
				for (InstructionContext i2 : s.getPopped())
				{
					if (poppedIns == null)
						poppedIns = i2.getInstruction();
					else if (poppedIns != i2.getInstruction())
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
			for (InstructionContext ictx : frame.getInstructions())
			{
				Instruction instruction = ictx.getInstruction();
				
				if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
					continue;
				
				MultiplicationExpression expression;
				try
				{
					 expression = parseExpression(e, ictx, instruction.getClass());
				}
				catch (IllegalStateException ex)
				{
					continue;
				}
				
				if (expression == null)
					continue;		
								
				if (done.contains(instruction))
					continue;
				done.add(instruction);
				
				assert instruction instanceof IMul || instruction instanceof LMul;
				if (instruction instanceof IMul)
					count += expression.simplify(1);
				else if (instruction instanceof LMul)
					count += expression.simplify(1L);
				else
					throw new IllegalStateException();
			}
		
		return count;
	}

}
