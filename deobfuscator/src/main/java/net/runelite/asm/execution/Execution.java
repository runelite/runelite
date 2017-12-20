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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import static net.runelite.asm.execution.StaticStep.popStack;
import net.runelite.deob.Deob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Execution
{
	private static final Logger logger = LoggerFactory.getLogger(Execution.class);

	private final ClassGroup group;
	public List<Frame> frames = new ArrayList<>(), framesOther = new ArrayList<>();
	public Set<Instruction> executed = new HashSet<>(); // executed instructions
	private Multimap<WeakInstructionContext, Method> stepInvokes = HashMultimap.create();
	private Set<Method> invokes = new HashSet<>();
	public boolean paused;
	public boolean step = false;
	public boolean noInvoke = false;
	private List<ExecutionVisitor> visitors = new ArrayList<>();
	private List<FrameVisitor> frameVisitors = new ArrayList<>();
	private List<MethodContextVisitor> methodContextVisitors = new ArrayList<>();
	private final Map<Object, Integer> order = new HashMap<>(); // field,method -> order encountered
	private final Map<Object, Integer> accesses = new HashMap<>();
	public boolean staticStep; // whether to step through static methods
	public boolean noExceptions;

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
			boolean extendsApplet = extendsApplet(cf);

			for (Method m : cf.getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
				{
					if (m.getCode() == null)
					{
						methods.add(m);
						continue;
					}

					methods.add(m); // I guess this method name is overriding a jre interface (init, run, ?).
					logger.debug("Adding initial method {}", m);
				}

				if (m.getName().equals("<init>") && extendsApplet)
				{
					methods.add(m);
				}
			}
		}

		return methods;
	}

	private static boolean extendsApplet(ClassFile cf)
	{
		if (cf.getParent() != null)
		{
			return extendsApplet(cf.getParent());
		}

		return cf.getSuperName().equals("java/applet/Applet");
	}

	public void populateInitialMethods()
	{
		for (Method m : this.getInitialMethods())
		{
			if (m.getCode() == null)
			{
				continue;
			}

			addMethod(m); // I guess this method name is overriding a jre interface (init, run, ?).
		}
	}

	public boolean hasInvoked(InstructionContext from, Method to)
	{
		if (!step && !staticStep)
		{
			if (invokes.contains(to))
			{
				return true;
			}

			invokes.add(to);
			return false;
		}

		// The step executor needs to be able to step into static methods,
		// and use MappingExecutorUtil.resolve to trace back through
		// the lvt to the caller which invoked the method.
		//
		// So, check that the stack is unique too. invoke() doesn't get this
		// far in the step executor, but does for staticStep
		Collection<Method> methods = stepInvokes.get(from.toWeak());
		if (methods != null && methods.contains(to))
		{
			return true;
		}

		stepInvokes.put(from.toWeak(), to);
		return false;
	}

	public void addFrame(Frame frame)
	{
		// this is to keep frames with same methodcontext together to reduce memory
		if (frames.isEmpty() || frames.get(0).getMethod() == frame.getMethod())
		{
			frames.add(frame);
		}
		else
		{
			framesOther.add(frame);
		}
	}

	public Frame invoke(InstructionContext from, Method to)
	{
		if (step) // step executor
		{
			return null;
		}

		if (noInvoke)
		{
			return null;
		}

		if (hasInvoked(from, to))
		{
			return null;
		}

		if (to.isNative())
		{
			return null;
		}

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

			++fcount;
			frame.execute();

			if (!staticStep)
			{
				// static step inserts stepped static function frames
				assert frames.get(0) == frame;
			}
			assert !frame.isExecuting();

			accept(frame);

			frames.remove(frame);

			// Return to caller
			popStack(frame);

			if (frames.isEmpty())
			{
				assert frame.getMethod() == frame.getMethodCtx().getMethod();

				accept(frame.getMethodCtx());

				if (framesOther.isEmpty())
				{
					break;
				}

				Frame begin = framesOther.remove(0);
				frames.add(begin);

				List<Frame> toMove = framesOther.stream().filter(f -> f.getMethod() == begin.getMethod()).collect(Collectors.toList());
				frames.addAll(toMove);
				framesOther.removeAll(toMove);
			}
		}

		logger.debug("Processed {} frames", fcount);
	}

	public void addExecutionVisitor(ExecutionVisitor ev)
	{
		this.visitors.add(ev);
	}

	public void clearExecutionVisitor()
	{
		this.visitors.clear();
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

	public void reset()
	{
		frames.clear();
		framesOther.clear();
		invokes.clear();
		stepInvokes.clear();
		executed.clear();
	}

	public void order(Frame frame, Method method)
	{
		order(frame, (Object) method);
	}

	public void order(Frame frame, Field field)
	{
		order(frame, (Object) field);
	}

	private void order(Frame frame, Object m)
	{
		if (!staticStep)
		{
			return; // no sense keeping track of this
		}

		Integer i;
		i = order.get(m);
		int next = frame.getNextOrder();
		if (i == null || next < i)
		{
			order.put(m, next);
		}

		i = accesses.get(m);
		if (i == null)
		{
			accesses.put(m, 1);
		}
		else
		{
			accesses.put(m, i + 1);
		}
	}

	public Integer getOrder(Object m)
	{
		return order.get(m);
	}

	public Integer getAccesses(Object m)
	{
		return accesses.get(m);
	}
}
