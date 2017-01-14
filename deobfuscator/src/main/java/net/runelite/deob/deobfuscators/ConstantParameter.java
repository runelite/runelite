/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
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
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Type;
import net.runelite.deob.Deobfuscator;
import org.apache.commons.collections4.map.MultiValueMap;

class ConstantMethodParameter
{
	List<Method> methods; // methods this is a parameter for
	int paramIndex;
	int lvtIndex;
	List<Number> values = new ArrayList<>(); // possible values for the parameter
	List<Instruction> operations = new ArrayList<>(); // conditional jumps based on the parameter
	Boolean result; // result of the jumps (branch taken or not)
	boolean invalid;

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.methods);
		hash = 47 * hash + this.lvtIndex;
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
		if (this.lvtIndex != other.lvtIndex)
		{
			return false;
		}
		return true;
	}
}

public class ConstantParameter implements Deobfuscator
{
	private Map<ConstantMethodParameter, ConstantMethodParameter> parameters = new HashMap<>();
	private MultiValueMap<Method, ConstantMethodParameter> mparams = new MultiValueMap<>();

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

	private ConstantMethodParameter getCMPFor(List<Method> methods, int paramIndex, int lvtIndex)
	{
		ConstantMethodParameter cmp = new ConstantMethodParameter();
		cmp.methods = methods;
		cmp.paramIndex = paramIndex;
		cmp.lvtIndex = lvtIndex;

		ConstantMethodParameter exists = parameters.get(cmp);
		if (exists != null)
		{
			for (Method m : methods)
				for (ConstantMethodParameter cmp2 : mparams.getCollection(m))
					assert cmp2.methods.equals(methods);
			return exists;
		}

		parameters.put(cmp, cmp);

		for (Method m : methods)
		{
			mparams.put(m, cmp);
		}

		return cmp;
	}

	// find constant values passed as parameters
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

			ConstantMethodParameter cmp = getCMPFor(methods, parameterIndex, lvtOffset);

			if (cmp.invalid)
			{
				continue;
			}

			if (ctx.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pc = (PushConstantInstruction) ctx.getPushed().getInstruction();

				if (!(pc.getConstant() instanceof Number))
				{
					cmp.invalid = true;
					continue;
				}

				Number number = (Number) pc.getConstant();

				if (!cmp.values.contains(number))
				{
					cmp.values.add((Number) pc.getConstant());
				}
			}
			else
			{
				cmp.invalid = true;
			}
		}
	}

	private void findParameters(InstructionContext ins)
	{
		if (!(ins.getInstruction() instanceof InvokeInstruction))
		{
			return;
		}

		List<Method> methods = ((InvokeInstruction) ins.getInstruction()).getMethods();
		if (methods.isEmpty())
		{
			return;
		}

		findConstantParameter(methods, ins);
	}

	private List<ConstantMethodParameter> findParametersForMethod(Method m)
	{
		Collection<ConstantMethodParameter> c = mparams.getCollection(m);
		if (c == null)
		{
			return new ArrayList<>();
		}
		return new ArrayList<>(c);
	}

	// compare known values against a jump. also invalidates constant param
	// if lvt is reassigned or a comparison is made against a non constant
	private void findDeadParameters(InstructionContext ins)
	{
		List<ConstantMethodParameter> parameters = this.findParametersForMethod(ins.getFrame().getMethod());

		for (ConstantMethodParameter parameter : parameters)
		{
			int lvtIndex = parameter.lvtIndex;

			if (parameter.invalid)
			{
				continue;
			}

			if (ins.getInstruction() instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) ins.getInstruction();

				if (lvt.getVariableIndex() == lvtIndex && lvt.store())
				{
					parameter.invalid = true;
					continue; // value changes at some point, parameter is used
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

			Number otherValue = null;

			if (two != null) // two is null for if0
			{
				if (!(other.getPushed().getInstruction() instanceof PushConstantInstruction))
				{
					parameter.invalid = true;
					continue;
				}

				PushConstantInstruction pc = (PushConstantInstruction) other.getPushed().getInstruction();
				otherValue = (Number) pc.getConstant();
			}

			for (Number value : parameter.values)
			{
				// the result of the comparison doesn't matter, only that it always goes the same direction for every invocation
				boolean result = doLogicalComparison(value, comp, otherValue);

				if (parameter.result != null && parameter.result != result)
				{
					parameter.invalid = true;
				}
				else
				{
					parameter.operations.add(ins.getInstruction());
					parameter.result = result;
				}
			}
		}
	}

	private boolean doLogicalComparison(Number value, ComparisonInstruction comparison, Number otherValue)
	{
		Instruction ins = (Instruction) comparison;

		assert (comparison instanceof If0) == (otherValue == null);

		switch (ins.getType())
		{
			case IFEQ:
				return value.equals(0);
			case IFNE:
				return !value.equals(0);
			case IFLT:
				return value.intValue() < 0;
			case IFGE:
				return value.intValue() >= 0;
			case IFGT:
				return value.intValue() > 0;
			case IFLE:
				return value.intValue() <= 0;
			case IF_ICMPEQ:
				return value.equals(otherValue);
			case IF_ICMPNE:
				return !value.equals(otherValue);
			case IF_ICMPLT:
				return value.intValue() < otherValue.intValue();
			case IF_ICMPGE:
				return value.intValue() >= otherValue.intValue();
			case IF_ICMPGT:
				return value.intValue() > otherValue.intValue();
			case IF_ICMPLE:
				return value.intValue() <= otherValue.intValue();
			default:
				throw new RuntimeException("Unknown constant comparison instructuction");
		}
	}

	// remove logically dead comparisons
	private int removeDeadOperations(MethodContext mctx)
	{
		int count = 0;
		for (ConstantMethodParameter cmp : parameters.values())
		{
			if (cmp.invalid)
			{
				continue;
			}

			if (!cmp.methods.contains(mctx.getMethod()))
			{
				continue;
			}

			if (cmp.paramIndex + 1 == mctx.getMethod().getDescriptor().size())
				// only annotate garbage value of last param
				annotateObfuscatedSignature(cmp);

			for (Instruction ins : cmp.operations) // comparisons
			{
				if (ins.getInstructions() == null || ins.getInstructions().getCode().getMethod() != mctx.getMethod())
				{
					continue;
				}

				InstructionContext ctx = mctx.getInstructonContexts(ins).toArray(new InstructionContext[0])[0];
				boolean branch = cmp.result; // branch that is always taken

				if (ins.getInstructions() == null)
				{
					continue; // ins already removed?
				}
				Instructions instructions = ins.getInstructions();

				// remove the if
				if (ctx.getInstruction() instanceof If)
				{
					ctx.removeStack(1);
				}
				ctx.removeStack(0);

				int idx = instructions.getInstructions().indexOf(ins);
				if (idx == -1)
				{
					continue; // already removed?
				}
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
			Object value = parameter.values.get(0);

			Annotations annotations = m.getAnnotations();

			if (annotations != null && annotations.find(OBFUSCATED_SIGNATURE) != null)
			{
				return;
			}

			Annotation annotation = annotations.addAnnotation(OBFUSCATED_SIGNATURE, "signature", m.getDescriptor().toString());

			Element element = new Element(annotation);
			element.setName("garbageValue");
			element.setValue(value.toString());
			annotation.addElement(element);
		}
	}

	private int count;

	@Override
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> findParameters(i));
		execution.populateInitialMethods();
		execution.run();

		execution = new Execution(group);
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
