/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.s2c;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlerFinder
{
	private static final Logger logger = LoggerFactory.getLogger(HandlerFinder.class);

	private final ClassGroup group;
	private final Field packetType;
	private final Execution execution;

	public HandlerFinder(ClassGroup group, Field packetType)
	{
		this.group = group;
		this.packetType = packetType;
		this.execution = new Execution(group);
	}

	public ClassGroup getGroup()
	{
		return group;
	}

	public Execution getExecution()
	{
		return execution;
	}

	public PacketHandlers findHandlers()
	{
		// Some of the packet handlers are if (type == 1 || type == 2) func()
		// and func() checks the type... so search all functions for packet handlers

		List<PacketHandler> handlers = new ArrayList<>();

		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				if (method.getCode() == null)
				{
					continue;
				}

				List<PacketHandler> h = findHandlers(method, packetType);
				handlers.addAll(h);
			}
		}

		PacketHandlers packetHandlers = new PacketHandlers(group, packetType, handlers);
		removeDuplicates(packetHandlers);
		prepareFrame(execution, packetHandlers);
		return packetHandlers;
	}

	private List<PacketHandler> findHandlers(Method process, Field packetOpcode)
	{
		List<PacketHandler> handlers = new ArrayList<>();

		Instructions ins = process.getCode().getInstructions();

		for (int j = 0; j < ins.getInstructions().size(); ++j)
		{
			Instruction i = ins.getInstructions().get(j);

			if (i.getType() != InstructionType.GETSTATIC)
			{
				continue;
			}

			GetStatic gs = (GetStatic) i;
			if (gs.getMyField() != packetOpcode)
			{
				continue;
			}

			Instruction push = ins.getInstructions().get(j + 1);
			if (!(push instanceof PushConstantInstruction))
			{
				continue;
			}

			PushConstantInstruction pci = (PushConstantInstruction) push;
			if (!(pci.getConstant() instanceof Number))
			{
				continue;
			}

			int opcode = ((Number) pci.getConstant()).intValue();

			if (opcode == -1)
			{
				continue;
			}

			Instruction jump = ins.getInstructions().get(j + 2);
			if (jump.getType() != InstructionType.IF_ICMPEQ && jump.getType() != InstructionType.IF_ICMPNE)
			{
				continue;
			}

			Instruction start, end;
			if (jump.getType() == InstructionType.IF_ICMPEQ)
			{
				// this seems to not ever happen
				start = ((If) jump).getJumps().get(0);
				//end = ins.getInstructions().get(j + 3);
				end = null;
			}
			else
			{
				start = ins.getInstructions().get(j + 3);
				end = ((If) jump).getJumps().get(0);
			}

			PacketHandler handler = new PacketHandler(process, jump, start, push, opcode);
			handlers.add(handler);

			if (end != null)
			{
				// Anything else which jumps to here instead needs to return.
				insertReturn(ins, jump, end);
			}

			logger.info("Found packet handler {} opcode {}", handler, handler.getOpcode());
		}

		return handlers;
	}

	private void removeDuplicates(PacketHandlers handlers)
	{
		// remove handlers which have multiple opcodes
		Multimap<Instruction, PacketHandler> i2h = HashMultimap.create();

		for (PacketHandler handler : handlers.getHandlers())
		{
			i2h.put(handler.getStart(), handler);
		}

		for (Instruction i : i2h.keySet())
		{
			int sz = i2h.get(i).size();

			if (sz == 1)
			{
				continue;
			}

			// this is part of if (opcode == 1 || opcode == 2 || ...) func();
			for (PacketHandler ph : i2h.get(i))
			{
				handlers.getHandlers().remove(ph);
				logger.debug("Removed duplicate handler {}", ph);
			}
		}
	}

	private void prepareFrame(Execution e, PacketHandlers handlers)
	{
		List<Method> methods = handlers.getHandlers().stream()
			.map(handler -> handler.getMethod())
			.distinct()
			.collect(Collectors.toList());

		for (Method method : methods)
		{
			List<PacketHandler> phandlers = handlers.getHandlers().stream()
				.filter(handler -> handler.getMethod() == method)
				.collect(Collectors.toList());

			prepareFrame(e, method, phandlers);
		}
	}

	private void prepareFrame(Execution e, Method method, List<PacketHandler> handlers)
	{
		e.step = true;

		Frame f = new Frame(e, method);
		f.initialize();

		e.addFrame(f);

		while (e.frames.isEmpty() == false)
		{
			f = e.frames.get(0);

			if (!f.isExecuting())
			{
				e.frames.remove(0);
				continue;
			}

			assert f.isExecuting();
			f.execute();

			e.paused = false;

			InstructionContext ctx = f.getInstructions().get(f.getInstructions().size() - 1);

			for (PacketHandler handler : handlers)
			{
				if (handler.getAfterRead() == ctx.getInstruction())
				{
					// frame is stopped at jump prior to handler
					handler.frame = f.dup();
					e.frames.remove(handler.frame);
					logger.info("Found frame for {}: {}", handler, handler.frame);
				}
				if (handler.getJump() == ctx.getInstruction())
				{
					handler.jumpFrame = f.dup();
					e.frames.remove(handler.jumpFrame);
					assert handler.jumpFrame.isExecuting();
					logger.info("Found jump frame for {}: {}", handler, handler.jumpFrame);
				}
			}
		}
	}

	private void insertReturn(Instructions ins, Instruction start, Instruction end)
	{
		assert end instanceof Label;
		int idx = ins.getInstructions().indexOf(end);
		assert idx != -1;

		Instruction before = ins.getInstructions().get(idx - 1);
		if (before.getType() == InstructionType.RETURN) //XXX check isTerminal?
		{
			return;
		}

		// insert return before end
		logger.info("Inserting return before {}", end);

		Instruction ret = new VReturn(ins);
		ins.addInstruction(idx, ret);

		Label label = ins.createLabelFor(ret);

		// Change jumps which go to the next handler to instead go to return
		for (Instruction i : ins.getInstructions())
		{
			if (i instanceof JumpingInstruction)
			{
				JumpingInstruction j = (JumpingInstruction) i;

				if (i == start)
				{
					continue;
				}

				if (j.getJumps().size() == 1 && j.getJumps().get(0) == end)
				{
					j.setJumps(Collections.singletonList(label));
				}
			}
		}
	}
}
