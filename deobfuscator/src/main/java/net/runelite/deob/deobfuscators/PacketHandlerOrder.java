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
package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.deobfuscators.packethandler.BufferFinder;
import net.runelite.deob.deobfuscators.packethandler.PacketTypeFinder;
import net.runelite.deob.s2c.HandlerFinder;
import net.runelite.deob.s2c.PacketHandler;
import net.runelite.deob.s2c.PacketHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketHandlerOrder implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(PacketHandlerOrder.class);

	@Override
	public void run(ClassGroup group)
	{
		// This is run on the deobfuscated jar, so there are no symbols yet...
		// Find packetType and buffer classes
		PacketTypeFinder ptf = new PacketTypeFinder(group);
		ptf.find();

		BufferFinder bf = new BufferFinder(group);
		bf.find();

		HandlerFinder hf = new HandlerFinder(group, ptf.getPacketType());
		PacketHandlers handlers = hf.findHandlers();

		logger.info("Found {} packet handlers", handlers.getHandlers().size());

		for (PacketHandler handler : handlers.getHandlers())
		{
			Execution e = hf.getExecution();
			e.reset();

			e.staticStep = true;
			e.step = false;
			e.noInvoke = true;

			assert e.frames.isEmpty();

			Frame f = handler.jumpFrame.dup();
			assert f.isExecuting();
			f.getMethodCtx().reset();

			e.clearExecutionVisitor();
			e.addExecutionVisitor(ictx ->
			{
				if (ictx.getInstruction() instanceof MappableInstruction)
				{
					if (ictx.getInstruction().getType() != InstructionType.INVOKESTATIC)
					{
						++handler.sizeMap;
					}
				}
				if (ictx.getInstruction().getType() == InstructionType.INVOKEVIRTUAL)
				{
					InvokeInstruction ii = (InvokeInstruction) ictx.getInstruction();

					// check if the invoke is on buffer/packetbuffer classes
					boolean matches = ii.getMethods().stream()
						.map(method -> method.getMethods().getClassFile())
						.anyMatch(cf -> cf == bf.getBuffer() || cf == bf.getPacketBuffer());
					if (matches)
					{
						if (!handler.reads.contains(ictx.getInstruction()))
						{
							handler.reads.add(ictx.getInstruction());
						}
					}
				}

				if (ictx.getInstruction().getType() == InstructionType.INVOKEVIRTUAL
					|| ictx.getInstruction().getType() == InstructionType.INVOKESPECIAL
					|| ictx.getInstruction().getType() == InstructionType.INVOKEINTERFACE)
				{
					InvokeInstruction ii = (InvokeInstruction) ictx.getInstruction();
					// read methods are scrambled so cant count them
					if (!handler.reads.contains(ictx.getInstruction()))
					{
						handler.methodInvokes.addAll(ii.getMethods());
					}
				}
				if (ictx.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sfi = (SetFieldInstruction) ictx.getInstruction();
					Field field = sfi.getMyField();
					if (field != null)
					{
						handler.fieldWrite.add(field);
					}
				}
				if (ictx.getInstruction() instanceof GetFieldInstruction)
				{
					GetFieldInstruction gfi = (GetFieldInstruction) ictx.getInstruction();
					Field field = gfi.getMyField();
					if (field != null)
					{
						handler.fieldRead.add(field);
					}
				}
			});

			e.run();

			logger.info("Executed opcode {}: {} mappable instructions", handler.getOpcode(), handler.sizeMap);
		}

		List<PacketHandler> unsortedHandlers = new ArrayList<>(handlers.getHandlers());
		List<PacketHandler> sortedHandlers = new ArrayList<>(handlers.getHandlers()).stream()
			.sorted((PacketHandler p1, PacketHandler p2) ->
			{
				if (p1.reads.size() != p2.reads.size())
				{
					return Integer.compare(p1.reads.size(), p2.reads.size());
				}
				if (p1.methodInvokes.size() != p2.methodInvokes.size())
				{
					return Integer.compare(p1.methodInvokes.size(), p2.methodInvokes.size());
				}
				if (p1.fieldRead.size() != p2.fieldRead.size())
				{
					return Integer.compare(p1.fieldRead.size(), p2.fieldRead.size());
				}
				if (p1.fieldWrite.size() != p2.fieldWrite.size())
				{
					return Integer.compare(p1.fieldWrite.size(), p2.fieldWrite.size());
				}
				return Integer.compare(p1.sizeMap, p2.sizeMap);
			})
			.map(s -> s.clone())
			.collect(Collectors.toList());

		assert sortedHandlers.size() == handlers.getHandlers().size();

		for (PacketHandler handler : sortedHandlers)
		{
			logger.info("Handler {} mappable {} reads {} invokes {} freads {} fwrites {}",
				handler.getOpcode(), handler.sizeMap, handler.reads.size(), handler.methodInvokes.size(),
				handler.fieldRead.size(), handler.fieldWrite.size());
		}

		// Find unique methods
		List<Method> methods = unsortedHandlers.stream()
			.map(ph -> ph.getMethod())
			.distinct()
			.collect(Collectors.toList());

		for (Method m : methods)
		{
			List<PacketHandler> unsortedMethodHandlers = unsortedHandlers.stream()
				.filter(ph -> ph.getMethod() == m)
				.collect(Collectors.toList());

			List<PacketHandler> sortedMethodHandlers = sortedHandlers.stream()
				.filter(ph -> ph.getMethod() == m)
				.collect(Collectors.toList());

			assert unsortedMethodHandlers.size() == sortedMethodHandlers.size();

			for (int i = 0; i < sortedMethodHandlers.size(); ++i)
			{
				PacketHandler unsorted = unsortedMethodHandlers.get(i);
				PacketHandler sortedh = sortedMethodHandlers.get(i);

				// Set opcode/jump from sorted -> unsorted
				If jump = (If) unsorted.getJump();
				PushConstantInstruction pci = (PushConstantInstruction) unsorted.getPush();

				assert unsorted.getOpcode() == ((Number) pci.getConstant()).intValue();

				// unsorted.getPush() might be bipush which cant hold 0-255
				Instructions instructions = unsorted.getMethod().getCode().getInstructions();
				instructions.replace(unsorted.getPush(), new LDC_W(instructions, sortedh.getOpcode()));

				assert jump.getType() == InstructionType.IF_ICMPEQ || jump.getType() == InstructionType.IF_ICMPNE;

				Label startLabel = instructions.createLabelFor(sortedh.getStart());

				if (jump.getType() == InstructionType.IF_ICMPEQ)
				{
					instructions.replace(jump, new IfICmpEq(instructions, startLabel));
				}
				else if (jump.getType() == InstructionType.IF_ICMPNE)
				{
					// insert a jump after to go to sortedh start
					int idx = instructions.getInstructions().indexOf(jump);
					assert idx != -1;

					instructions.addInstruction(idx + 1, new Goto(instructions, startLabel));
				}
				else
				{
					throw new IllegalStateException();
				}
			}
		}
	}

}
