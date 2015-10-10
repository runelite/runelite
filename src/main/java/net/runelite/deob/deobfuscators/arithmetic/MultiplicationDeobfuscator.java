package net.runelite.deob.deobfuscators.arithmetic;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.BiPush;
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
	
	private MultiplicationExpression parseExpression(Execution e, InstructionContext ctx)
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
		
//		if (ctx.getInstruction() instanceof IMul)
//		{
//			if (!isOnlyPath(e, ctx))
//				throw new IllegalStateException();
//		}
		
		for (StackContext sctx : ctx.getPops())
		{
			if (ctx.getInstruction() instanceof IMul)
			{
				if (!isOnlyPath(e, ctx, sctx))
					continue;
					//throw new IllegalStateException();
			}
			
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
						MultiplicationExpression other = parseExpression(e, i);

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
						MultiplicationExpression other = parseExpression(e, i);

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
					//if(true) throw new IllegalStateException();
					DupInstruction dup = (DupInstruction) i.getInstruction();
					
					//if (dup instanceof Dup || dup instanceof Dup_X1)
					{
					
						// find other branch of the dup instruction
						// sctx = what dup pushed, find other
						StackContext otherCtx = dup.getOtherBranch(sctx); // other side of dup
						//InstructionContext otherCtxI = otherCtx.getPopped(); // would insert imul here?
						InstructionContext otherCtxI = otherCtx.getPopped().get(0); // is this irght?

						if (otherCtxI.getInstruction() instanceof IMul)
						{
							//assert otherCtxI.getInstruction() instanceof IMul;

							InstructionContext pushConstant = otherCtxI.getPops().get(0).getPushed();
							assert pushConstant.getInstruction() instanceof LDC_W;

							me.dupmagic = pushConstant;

							StackContext orig = dup.getOriginal(sctx); // original
							try
							{
								MultiplicationExpression other = parseExpression(e, orig.getPushed());
								// this expression is used elsewhere like 'pushConstant' so any changes
								// done to it affect that, too. so multiply it by existing values?
								if (orig.getPushed().getInstruction() instanceof IAdd || orig.getPushed().getInstruction() instanceof ISub)
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
				MultiplicationExpression other = parseExpression(e, i); // parse this side of the add/sub
				
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
	
	// for each instruction ctx in ths expression, see if it !equals any other for each ins?
//	
//	private List<InstructionContext> getInsInExpr(InstructionContext ctx, Set<Instruction> set)
//	{
//		List<InstructionContext> l = new ArrayList<>();
//		
//		if (ctx == null || set.contains(ctx.getInstruction()))
//			return l;
//		
//		set.add(ctx.getInstruction());
//		
//		l.add(ctx);
//		for (StackContext s : ctx.getPops())
//			l.addAll(getInsInExpr(s.getPushed(), set));
//		for (StackContext s : ctx.getPushes())
//			l.addAll(getInsInExpr(s.getPopped(), set));
//		
//		return l;
//	}
	
	public static boolean isOnlyPath(Execution execution, InstructionContext ctx)
	{
		assert ctx.getInstruction() instanceof IMul;
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
		
		// check if stack at time of execution is equal
		List<StackContext> ours = one.getStack().getStack(), theirs = two.getStack().getStack();
		//Stack ours = new Stack(one.getStack()), // copy stacks since we destroy them
//			theirs = new Stack(two.getStack());
		
		if (ours.size() != theirs.size()) // is this possible?
			return false;
		
		assert ours.contains(sctx);
		int i = ours.indexOf(sctx);
		
		StackContext theirsctx = theirs.get(i);
		
		if (sctx.getPushed().getInstruction() != theirsctx.getPushed().getInstruction())
			return false;
		
		return true;
	}
	
	public static boolean isOnlyPath(Execution execution, InstructionContext ctx, StackContext sctx)
	{
		// 
		assert ctx.getInstruction() instanceof IMul;
		Collection<InstructionContext> ins = execution.getInstructonContexts(ctx.getInstruction());
		for (InstructionContext i : ins)
		{
			if (!ictxEqualsDir(ctx, i, sctx))
///			if (!i.equals(ctx))
			{
				return false;
			}

			for (StackContext s : i.getPushes())
				if (s.getPopped().size() > 1)
					return false;
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
		int mcount = 0;
		
		for (Frame frame : e.processedFrames)
			//outer:
			for (InstructionContext ictx : frame.getInstructions())
			{
				Instruction instruction = ictx.getInstruction();
				Instructions instructions = instruction.getInstructions();
				
				String cname = frame.getMethod().getMethods().getClassFile().getName();
				
				if (!(instruction instanceof IMul))
					continue;
				
//				if (cname.equals("client"))
//				{
//					// 7500 works ok
//					// 8250 doesnt work
//					//if (mcount++ > 8250)
//					++mcount;
//					if (!(mcount >= 7500 && mcount <= 8250))
//						continue;
//				}
//				else
//				{
//					continue;
//				}
//field721 = (-1 != var5 && 1 != var5 ?
//	(class139.field2363 * 1381104939 + 981643079 * field721 * 1807370871) / 2 :
//	1381104939 * class139.field2363)
//	* 1807370871 * 981643079;
//	
//field721 = (-1 != var5 && 1 != var5 ? 
//	(class139.field2363 * 1381104939 + 981643079 * field721 * 1807370871) / 2 :
//	1 * class139.field2363)
//	* 1 * 1381104939;

				
				MultiplicationExpression expression;
				try
				{
					 expression = parseExpression(e, ictx);
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
//				List<InstructionContext> ilist = this.getInsInExpr(ictx, new HashSet());
//				for (InstructionContext i2 : ilist)
//					if (i2.getInstruction() instanceof IMul)
//						if (!isOnlyPath(e, i2))
//							continue outer;
				
								
				if (done.contains(instruction))
					continue;
				done.add(instruction);
				
				count += expression.simplify(1);
			}
		
		return count;
	}

}
