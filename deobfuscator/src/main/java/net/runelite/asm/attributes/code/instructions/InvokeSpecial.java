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

package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.Method;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class InvokeSpecial extends Instruction implements InvokeInstruction
{
	private Method method;
	private List<net.runelite.asm.Method> myMethods;

	public InvokeSpecial(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public InvokeSpecial(Instructions instructions, Method method)
	{
		super(instructions, InstructionType.INVOKESPECIAL, -1);

		this.method = method;
		length += 2;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		method = this.getPool().getMethod(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(method));
	}
	
	@Override
	public List<net.runelite.asm.Method> getMethods()
	{
		return myMethods != null ? myMethods : Arrays.asList();
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		int count = method.getNameAndType().getNumberOfArgs();
		
		for (int i = 0; i < count; ++i)
		{
			StackContext arg = stack.pop();
			ins.pop(arg);
		}
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		if (!method.getNameAndType().isVoid())
		{
			StackContext ctx = new StackContext(ins,
				new Type(method.getNameAndType().getDescriptor().getReturnValue()),
				Value.UNKNOWN
			);
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		for (net.runelite.asm.Method method : getMethods())
		{
			ins.invoke(method);
			
			if (method.getCode() == null)
			{
				frame.getExecution().methods.add(method);
				continue;
			}
			
			// add possible method call to execution
			Execution execution = frame.getExecution();
			execution.invoke(ins, method);
		}
		
		return ins;
	}
	
	@Override
	public String toString()
	{
		return "invokespecial " + method + " in " + this.getInstructions().getCode().getAttributes().getMethod();
	}
	
	@Override
	public void removeParameter(int idx)
	{
		net.runelite.asm.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		// create new signature
		Signature sig = new Signature(nat.getDescriptor());
		sig.remove(idx);
		
		// create new method pool object
		method = new Method(clazz, new NameAndType(nat.getName(), sig));
	}
	
	@Override
	public PoolEntry getMethod()
	{
		return method;
	}

	public void setMethod(Method method)
	{
		this.method = method;
		lookup();
	}
	
	@Override
	public void lookup()
	{
		myMethods = null;
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return; // not our class
		
		net.runelite.asm.Method other = otherClass.findMethod(method.getNameAndType());
		assert other != null;
		
		List<net.runelite.asm.Method> list = new ArrayList<>();
		list.add(other);
		myMethods = list;
	}
	
	@Override
	public void regeneratePool()
	{
		if (myMethods != null && !myMethods.isEmpty())
			method = myMethods.get(0).getPoolMethod();
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		InvokeSpecial otherIv = (InvokeSpecial) other.getInstruction();
		
		List<net.runelite.asm.Method> myMethods = this.getMethods(),
			otherMethods = otherIv.getMethods();
		
		List<net.runelite.asm.Method> m1 = this.myMethods;
		List<net.runelite.asm.Method> m2 = ((InvokeSpecial) other.getInstruction()).myMethods;
		assert myMethods.size() == otherMethods.size();
		
		for (int i = 0; i < myMethods.size(); ++i)
			mapping.map(myMethods.get(i), otherMethods.get(i));
		
		for (int i = 0; i < ctx.getPops().size(); ++i)
		{
			StackContext s1 = ctx.getPops().get(i),
				s2 = other.getPops().get(i);
			
			InstructionContext base1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
			InstructionContext base2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);
			
			if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
					gf2 = (GetFieldInstruction) base2.getInstruction();
				
				Field f1 = gf1.getMyField(),
					f2 = gf2.getMyField();
				
				if (f1 != null && f2 != null)
				{
					mapping.map(f1, f2);
				}
			}
		}
		
		/* map field that was invoked on */
		
		StackContext object1 = ctx.getPops().get(method.getNameAndType().getNumberOfArgs()),
			object2 = other.getPops().get(otherIv.method.getNameAndType().getNumberOfArgs());
		
		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			Field f1 = gf1.getMyField(),
				f2 = gf2.getMyField();

			if (f1 != null && f2 != null)
			{
				mapping.map(f1, f2);
			}
		}
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
			return false;
		
		InvokeSpecial thisIi = (InvokeSpecial) thisIc.getInstruction(),
			otherIi = (InvokeSpecial) otherIc.getInstruction();

		if (!MappingExecutorUtil.isMaybeEqual(thisIi.method.getNameAndType().getDescriptor(), otherIi.method.getNameAndType().getDescriptor()))
			return false;
		
		List<net.runelite.asm.Method> thisMethods = thisIi.getMethods(),
			otherMethods = otherIi.getMethods();
		
		if (thisMethods.size() != otherMethods.size())
			return false;
		
		for (int i = 0; i < thisMethods.size(); ++i)
		{
			net.runelite.asm.Method m1 = thisMethods.get(i);
			net.runelite.asm.Method m2 = otherMethods.get(i);

			if (!MappingExecutorUtil.isMaybeEqual(m1.getMethods().getClassFile(), m2.getMethods().getClassFile()))
				return false;
			
			if (!MappingExecutorUtil.isMaybeEqual(m1.getNameAndType().getDescriptor(), m2.getNameAndType().getDescriptor()))
				return false;
		}
		
		return true;
	}
	
	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return MappingExecutorUtil.isMappable(this);
	}
}
