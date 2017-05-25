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

package net.runelite.asm.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.deob.Deob;
import org.apache.commons.collections4.map.MultiValueMap;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>(), framesOther = new ArrayList<>();
	public Set<Method> methods = new HashSet<>(); // all methods
	public Set<Instruction> executed = new HashSet<>(); // executed instructions
	private MultiValueMap<WeakInstructionContext, Method> invokes = new MultiValueMap<>();
	public boolean paused;
	public boolean step = false;
	public boolean noInvoke = false;
	private List<ExecutionVisitor> visitors = new ArrayList<>();
	private List<FrameVisitor> frameVisitors = new ArrayList<>();
	private List<MethodContextVisitor> methodContextVisitors = new ArrayList<>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}
	
	public List<Method> getInitialMethods()
	{
		List<Method> methods = new ArrayList<>();
		
		group.buildClassGraph(); // required when looking up methods
		group.lookup(); // lookup methods
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
				{
					if (m.getCode() == null)
					{
						methods.add(m);
						continue;
					}
					
					methods.add(m); // I guess this method name is overriding a jre interface (init, run, ?).
				}

				if (m.getName().equals("<init>") && cf.getSuperName().equals("java/applet/Applet"))
				{
					methods.add(m);
				}
			}
		}
		
		return methods;
	}
	
	public void populateInitialMethods()
	{
		for (Method m : this.getInitialMethods())
		{
			if (m.getCode() == null)
			{
				methods.add(m);
				continue;
			}

			Frame frame = new Frame(this, m);
			frame.initialize();
			addFrame(frame); // I guess this method name is overriding a jre interface (init, run, ?).
		}
	}
	
	public boolean hasInvoked(InstructionContext from, Method to)
	{
		Collection<Method> methods = invokes.getCollection(from.toWeak());
		if (methods != null && methods.contains(to))
			return true;
		
		invokes.put(from.toWeak(), to);
		return false;
	}

	public void addFrame(Frame frame)
	{
		if (frames.isEmpty() || frames.get(0).getMethod() == frame.getMethod())
			frames.add(frame);
		else
			framesOther.add(frame);
	}
	
	public Frame invoke(InstructionContext from, Method to)
	{
		if (step) // step executor
			return null;
		
		if (noInvoke)
			return null;

		if (hasInvoked(from, to))
			return null;
		
		Frame f = new Frame(this, to);
		f.initialize(from);
		this.addFrame(f);
		return f;
	}
	
	public void addMethod(Method to)
	{
		Frame f = new Frame(this, to);
		f.initialize();
		this.addFrame(f);
	}
	
	public void run()
	{
		assert !paused;
		
		int fcount = 0;
		while (!frames.isEmpty())
		{
			Frame frame = frames.get(0);
			
			methods.add(frame.getMethod());
			
			++fcount;
			frame.execute();
			
			assert frames.get(0) == frame;
			assert !frame.isExecuting();

			accept(frame);

			frames.remove(frame);
			
			if (frames.isEmpty())
			{
				assert frame.getMethod() == frame.getMethodCtx().getMethod();

				accept(frame.getMethodCtx());

				if (framesOther.isEmpty())
					break;

				Frame begin = framesOther.remove(0);
				frames.add(begin);

				List<Frame> toMove = framesOther.stream().filter(f -> f.getMethod() == begin.getMethod()).collect(Collectors.toList());
				frames.addAll(toMove);
				framesOther.removeAll(toMove);
			}
		}
		
		System.out.println("Processed " + fcount + " frames");
	}

	public void addExecutionVisitor(ExecutionVisitor ev)
	{
		this.visitors.add(ev);
	}

	public void accept(InstructionContext ic)
	{
		visitors.forEach(v -> v.visit(ic));
	}

	public void addFrameVisitor(FrameVisitor pv)
	{
		this.frameVisitors.add(pv);
	}

	public void accept(Frame f)
	{
		frameVisitors.forEach(v -> v.visit(f));
	}
	
	public void addMethodContextVisitor(MethodContextVisitor mcv)
	{
		methodContextVisitors.add(mcv);
	}
	
	public void accept(MethodContext m)
	{
		methodContextVisitors.forEach(mc -> mc.visit(m));
	}
}
