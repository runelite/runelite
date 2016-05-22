/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.If0;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.signature.Type;
import org.apache.commons.collections4.map.MultiValueMap;

class ConstantMethodParameter
{
	public List<Method> methods;
	public int paramIndex;
	public int lvtIndex;
	public Object value;
	List<Instruction> operations = new ArrayList<>();
	Boolean result;

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.methods);
		hash = 47 * hash + this.paramIndex;
		hash = 47 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ConstantMethodParameter other = (ConstantMethodParameter) obj;
		if (!Objects.equals(this.methods, other.methods))
		{
			return false;
		}
		if (this.paramIndex != other.paramIndex)
		{
			return false;
		}
		if (!Objects.equals(this.value, other.value))
		{
			return false;
		}
		return true;
	}
}

public class ConstantParameter implements Deobfuscator
{
	private List<ConstantMethodParameter> parameters = new ArrayList<>();
	private MultiValueMap<Method, ConstantMethodParameter> mparams = new MultiValueMap<>();
	
	private MultiValueMap<Method, Integer> nonconst = new MultiValueMap<>(); // methods with non const parameters
	
	private void checkMethodsAreConsistent(List<Method> methods)
	{
		Method prev = null;
		for (Method m : methods)
		{
			if (prev != null)
			{
				assert prev.getDescriptor().equals(m.getDescriptor());
				assert prev.isStatic() == m.isStatic();
			}
			prev = m;
		}
	}
	
	private void findConstantParameter(List<Method> methods, InstructionContext invokeCtx)
	{
		checkMethodsAreConsistent(methods);
		
		Method method = methods.get(0); // all methods must have the same signature etc
		int offset = method.isStatic() ? 0 : 1;
		
		List<StackContext> pops = invokeCtx.getPops();
		
	 outer:
		// object is popped first, then param 1, 2, 3, etc. double and long take two slots.
		for (int lvtOffset = offset, parameterIndex = 0;
			parameterIndex < method.getDescriptor().size();
			lvtOffset += method.getDescriptor().getTypeOfArg(parameterIndex++).getSlots())
		{	
			// get(0) == first thing popped which is the last parameter,
			// get(descriptor.size() - 1) == first parameter
			StackContext ctx = pops.get(method.getDescriptor().size() - 1 - parameterIndex);
			
			Collection<Integer> nonIdx = nonconst.getCollection(method);
			boolean non = nonIdx != null && nonIdx.contains(parameterIndex);
			
			if (non)
				continue;
			
			if (ctx.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pc = (PushConstantInstruction) ctx.getPushed().getInstruction();
				
				if (!(pc.getConstant().getObject() instanceof Number))
					continue;
				
				ConstantMethodParameter cmp = new ConstantMethodParameter();
				cmp.methods = methods;
				cmp.paramIndex = parameterIndex;
				cmp.lvtIndex = lvtOffset;
				cmp.value = pc.getConstant().getObject();
				
				// already exists?
				for (ConstantMethodParameter c : parameters)
					if (c.equals(cmp))
						continue outer;
				
				parameters.add(cmp);
				for (Method m : methods)
					mparams.put(m, cmp);
			}
			else
			{
				nonconst.put(method, parameterIndex);
				
				// remove from parameters as is not always const
				for (Iterator<ConstantMethodParameter> it = parameters.iterator(); it.hasNext();)
				{
					ConstantMethodParameter c = it.next();
					
					if (c.methods.equals(methods) && c.lvtIndex == lvtOffset)
					{
						it.remove();
					}
				}
			}
		}
	}
	
	private void findParameters(InstructionContext ins)
	{
		if (!(ins.getInstruction() instanceof InvokeInstruction))
			return;

		List<Method> methods = ((InvokeInstruction) ins.getInstruction()).getMethods();
		if (methods.isEmpty())
			return;

		findConstantParameter(methods, ins);
	}
	
	private List<ConstantMethodParameter> findParametersForMethod(Method m)
	{
		Collection<ConstantMethodParameter> c = mparams.getCollection(m);
		if (c == null)
			return new ArrayList<>();
		return new ArrayList<>(c);
	}

	private void findDeadParameters(InstructionContext ins)
	{
		List<ConstantMethodParameter> parameters = this.findParametersForMethod(ins.getFrame().getMethod());

		for (ConstantMethodParameter parameter : parameters)
		{
			int lvtIndex = parameter.lvtIndex;
			Object value = parameter.value;

			if (ins.getInstruction() instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) ins.getInstruction();

				if (lvt.getVariableIndex() == lvtIndex && lvt.store())
				{
					this.parameters.remove(parameter);
					continue; // parameter is used
				}
			}

			if (!(ins.getInstruction() instanceof ComparisonInstruction))
			{
				continue;
			}

			// assume that this will always be variable index #paramIndex comp with a constant.
			ComparisonInstruction comp = (ComparisonInstruction) ins.getInstruction();

			StackContext one, two = null;

			if (comp instanceof If0)
			{
				one = ins.getPops().get(0);
			}
			else if (comp instanceof If)
			{
				one = ins.getPops().get(0);
				two = ins.getPops().get(1);
			}
			else
			{
				throw new RuntimeException("Unknown comp ins");
			}

			// find if one is a lvt ins
			LVTInstruction lvt = null;
			StackContext other = null;

			if (one.getPushed().getInstruction() instanceof LVTInstruction)
			{
				lvt = (LVTInstruction) one.getPushed().getInstruction();
				other = two;
			}
			else if (two != null && two.getPushed().getInstruction() instanceof LVTInstruction)
			{
				lvt = (LVTInstruction) two.getPushed().getInstruction();
				other = one;
			}

			assert lvt == null || !lvt.store();

			if (lvt == null || lvt.getVariableIndex() != lvtIndex)
			{
				continue;
			}

			Object otherValue = null;

			if (two != null) // two is null for if0
			{
				if (!(other.getPushed().getInstruction() instanceof PushConstantInstruction))
				{
					continue;
				}

				PushConstantInstruction pc = (PushConstantInstruction) other.getPushed().getInstruction();
				otherValue = pc.getConstant().getObject();
			}

			// the result of the comparison doesn't matter, only that it always goes the same direction for every invocation
			boolean result = doLogicalComparison(value, comp, otherValue);

			if (parameter.result != null && parameter.result != result)
			{
				this.parameters.remove(parameter);
			}
			else
			{
				parameter.operations.add(ins.getInstruction());
				parameter.result = result;
			}
		}
	}

	private boolean doLogicalComparison(Object value, ComparisonInstruction comparison, Object otherValue)
	{
		Instruction ins = (Instruction) comparison;
		
		assert (comparison instanceof If0) == (otherValue == null);
		assert otherValue == null || otherValue instanceof Integer;

		switch (ins.getType())
		{
			case IFEQ:
				return value.equals(0);
			case IFNE:
				return !value.equals(0);
			case IFLT:
				return (int) value < 0;
			case IFGE:
				return (int) value >= 0;
			case IFGT:
				return (int) value > 0;
			case IFLE:
				return (int) value <= 0;
			case IF_ICMPEQ:
				return value.equals(otherValue);
			case IF_ICMPNE:
				return !value.equals(otherValue);
			case IF_ICMPLT:
				return (int) value < (int) otherValue;
			case IF_ICMPGE:
				return (int) value >= (int) otherValue;
			case IF_ICMPGT:
				return (int) value > (int) otherValue;
			case IF_ICMPLE:
				return (int) value <= (int) otherValue;
			default:
				throw new RuntimeException("Unknown constant comparison instructuction");
		}
	}

	// remove logically dead comparisons
	private int removeDeadOperations(MethodContext mctx)
	{
		int count = 0;
		for (ConstantMethodParameter cmp : parameters)
		{
			if (!cmp.methods.contains(mctx.getMethod()))
				continue;
			
			annotateObfuscatedSignature(cmp);

			for (Instruction ins : cmp.operations) // comparisons
			{
				if (ins.getInstructions() == null || ins.getInstructions().getCode().getAttributes().getMethod() != mctx.getMethod())
					continue;
				
				InstructionContext ctx = mctx.getInstructonContexts(ins).toArray(new InstructionContext[0])[0];
				boolean branch = cmp.result; // branch that is always taken
				
				if (ins.getInstructions() == null)
					continue; // ins already removed?
				
				Instructions instructions = ins.getInstructions();
				
				// remove the if
				if (ctx.getInstruction() instanceof If)
					ctx.removeStack(1);
				ctx.removeStack(0);
				
				int idx = instructions.getInstructions().indexOf(ins);
				if (idx == -1)
					continue; // already removed?
				
				++count;
				
				Instruction to;
				if (branch)
				{
					JumpingInstruction jumpIns = (JumpingInstruction) ins;
					assert jumpIns.getJumps().size() == 1;
					to = jumpIns.getJumps().get(0);
				}
				else
				{
					// just go to next instruction
					to = instructions.getInstructions().get(idx + 1);
				}
				assert to.getInstructions() == instructions;
				assert ins != to;
				assert instructions.getInstructions().contains(to);
				
				// move things that jump here to instead jump to 'to'
				for (Instruction i : instructions.getInstructions())
					i.replace(ins, to);

				for (net.runelite.asm.attributes.code.Exception e : instructions.getCode().getExceptions().getExceptions())
					e.replace(ins, to);
				
				instructions.remove(ins);
				
				assert instructions.getInstructions().contains(to);
				
				if (branch)
				{
					Goto gotoins = new Goto(instructions, instructions.createLabelFor(to));
					
					// insert goto
					instructions.getInstructions().add(idx, gotoins);
				}
			}
		}
		return count;
	}
	
	private static final Type OBFUSCATED_SIGNATURE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");

	private void annotateObfuscatedSignature(ConstantMethodParameter parameter)
	{
		for (Method m : parameter.methods)
		{
			Object value = parameter.value;

			Attributes attributes = m.getAttributes();
			Annotations annotations = attributes.getAnnotations();

			if (annotations != null && annotations.find(OBFUSCATED_SIGNATURE) != null)
				return;

			Annotation annotation = attributes.addAnnotation(OBFUSCATED_SIGNATURE, "signature", new net.runelite.asm.pool.UTF8(m.getDescriptor().toString()));

			Element element = new Element(annotation);
			element.setType(new Type("garbageValue"));
			element.setValue(new net.runelite.asm.pool.UTF8(value.toString()));
			annotation.addElement(element);
		}
	}

	private int count;
	
	@Override
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> findParameters(i));
		execution.addExecutionVisitor(i -> findDeadParameters(i));
		execution.populateInitialMethods();
		execution.run();

		execution = new Execution(group);
		execution.addMethodContextVisitor(m -> count += removeDeadOperations(m));
		execution.populateInitialMethods();
		execution.run();
		
		System.out.println("Removed " + count + " logically dead conditional jumps");
	}
	
}
