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

import com.google.common.primitives.Ints;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferFinder;
import net.runelite.deob.deobfuscators.packethandler.PacketLengthFinder;
import net.runelite.deob.deobfuscators.packethandler.PacketRead;
import net.runelite.deob.deobfuscators.packethandler.PacketTypeFinder;
import static net.runelite.deob.deobfuscators.transformers.OpcodesTransformer.RUNELITE_OPCODES;
import net.runelite.deob.s2c.HandlerFinder;
import net.runelite.deob.s2c.PacketHandler;
import net.runelite.deob.s2c.PacketHandlers;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketHandlerOrder implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(PacketHandlerOrder.class);

	private static final String RUNELITE_PACKET = "RUNELITE_PACKET";

	private static final MessageDigest sha256;

	static
	{
		try
		{
			sha256 = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}
	}

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
			// exception processing won't do non-local jumps, so
			// depending on whether methods are inlined or not
			// it may jump completely out of the handler into the
			// catch all for all packet handling
			// just disable exception execution
			e.noExceptions = true;

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
						if (!handler.mappable.contains(ictx.getInstruction()))
						{
							handler.mappable.add(ictx.getInstruction());
						}
					}
				}
				if (ictx.getInstruction().getType() == InstructionType.INVOKEVIRTUAL)
				{
					InvokeInstruction ii = (InvokeInstruction) ictx.getInstruction();

					// check if the invoke is on buffer/packetbuffer classes
					boolean matches = ii.getMethods().stream()
						.filter(m -> m.getDescriptor().size() == 0)
						.map(method -> method.getClassFile())
						.anyMatch(cf -> cf == bf.getBuffer() || cf == bf.getPacketBuffer());
					if (matches)
					{
						Method method = ii.getMethods().get(0);
						Signature signature = method.getDescriptor();
						Type returnValue = signature.getReturnValue();

						assert ictx.getPops().size() == 1; // buffer reference
						InstructionContext bufferCtx = ictx.getPops().get(0).getPushed();
						if (bufferCtx.getInstruction().getType() != InstructionType.GETSTATIC)
						{
							return; // sometimes buffer is passed to a function and then invoked.
						}
						PacketRead packetRead = new PacketRead(returnValue, bufferCtx.getInstruction(), ictx);

						if (!handler.reads.contains(packetRead))
						{
							handler.reads.add(packetRead);
						}
					}
				}

				if (ictx.getInstruction().getType() == InstructionType.INVOKEVIRTUAL
					|| ictx.getInstruction().getType() == InstructionType.INVOKESPECIAL
					|| ictx.getInstruction().getType() == InstructionType.INVOKEINTERFACE)
				{
					InvokeInstruction ii = (InvokeInstruction) ictx.getInstruction();
					// read methods are scrambled so cant count them
					if (!handler.hasPacketRead(ictx.getInstruction()))
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
				if (ictx.getInstruction() instanceof LVTInstruction)
				{
					LVTInstruction lvt = (LVTInstruction) ictx.getInstruction();
					if (!lvt.store())
					{
						// get lvt access order
						Frame frame = ictx.getFrame();
						int order = frame.getNextOrder();
						if (!handler.lvtOrder.containsKey(lvt.getVariableIndex()))
						{
							handler.lvtOrder.put(lvt.getVariableIndex(), order);
						}
					}
				}
				if (ictx.getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) ictx.getInstruction();
					handler.constants.add(pci.getConstant());
				}
			});

			logger.debug("Beginning execution of opcode {}", handler.getOpcode());

			e.run();

			logger.info("Executed opcode {}: {} mappable instructions", handler.getOpcode(), handler.mappable.size());

			handler.findReorderableReads();
		}

		List<PacketHandler> unsortedHandlers = new ArrayList<>(handlers.getHandlers());
		List<PacketHandler> sortedHandlers = new ArrayList<>(handlers.getHandlers()).stream()
			.sorted((PacketHandler p1, PacketHandler p2) ->
			{
				int c = compareReads(p1.reads, p2.reads);
				if (c != 0)
				{
					return c;
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
				int i = Integer.compare(p1.mappable.size(), p2.mappable.size());
				if (i != 0)
				{
					return i;
				}

				int s1 = hashConstants(p1.constants), s2 = hashConstants(p2.constants);
				if (s1 != s2)
				{
					return Integer.compare(s1, s2);
				}

				logger.warn("Unable to differentiate {} from {}", p1, p2);
				return 0;
			})
			.map(s -> s.clone())
			.collect(Collectors.toList());

		assert sortedHandlers.size() == handlers.getHandlers().size();

		for (PacketHandler handler : sortedHandlers)
		{
			handler.sortedReads = new ArrayList<>(handler.reads);
			Collections.sort(handler.sortedReads, (PacketRead p1, PacketRead p2) ->
			{
				LVTInstruction l1 = (LVTInstruction) p1.getStore();
				LVTInstruction l2 = (LVTInstruction) p2.getStore();

				if (l1 == null && l2 == null)
				{
					return 0;
				}
				if (l1 == null)
				{
					return 1;
				}
				if (l2 == null)
				{
					return -1;
				}

				if (l1.getVariableIndex() == l2.getVariableIndex())
				{
					return 0;
				}

				Integer i1 = handler.lvtOrder.get(l1.getVariableIndex());
				Integer i2 = handler.lvtOrder.get(l2.getVariableIndex());
				assert i1 != null;
				assert i2 != null;
				int i = Integer.compare(i1, i2);

				if (i == 0)
				{
					logger.warn("Cannot differentiate {} from {}", p1, p2);
				}

				return i;
			});
			Collections.reverse(handler.sortedReads);
		}

		ClassFile runeliteOpcodes = group.findClass(RUNELITE_OPCODES);
		assert runeliteOpcodes != null : "Opcodes class must exist";

		for (PacketHandler handler : sortedHandlers)
		{
			logger.info("Handler {} mappable {} reads {} invokes {} freads {} fwrites {}",
				handler.getOpcode(), handler.mappable.size(), handler.reads.size(), handler.methodInvokes.size(),
				handler.fieldRead.size(), handler.fieldWrite.size());

			final String fieldName = "PACKET_SERVER_" + handler.getOpcode();

			// Add opcode fields
			if (runeliteOpcodes.findField(fieldName) == null)
			{
				Field opField = new Field(runeliteOpcodes, fieldName, Type.INT);
				// ACC_FINAL causes javac to inline the fields, which prevents
				// the mapper from doing field mapping
				opField.setAccessFlags(ACC_PUBLIC | ACC_STATIC);
				// setting a non-final static field value
				// doesn't work with fernflower
				opField.setValue(handler.getOpcode());
				runeliteOpcodes.addField(opField);

				// add initialization
				Method clinit = runeliteOpcodes.findMethod("<clinit>");
				assert clinit != null;
				Instructions instructions = clinit.getCode().getInstructions();
				instructions.addInstruction(0, new LDC(instructions, handler.getOpcode()));
				instructions.addInstruction(1, new PutStatic(instructions, opField));
			}
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

				Instructions instructions = unsorted.getMethod().getCode().getInstructions();

				final String fieldName = "PACKET_SERVER_" + sortedh.getOpcode();

				net.runelite.asm.pool.Field field = new net.runelite.asm.pool.Field(
					new net.runelite.asm.pool.Class(RUNELITE_OPCODES),
					fieldName,
					Type.INT
				);
				instructions.replace(unsorted.getPush(), new GetStatic(instructions, field));

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

		insertSortedReads(group, sortedHandlers);
		insertPacketLength(group, ptf);
	}

	private void insertSortedReads(ClassGroup group, List<PacketHandler> handlers)
	{
		outer:
		for (PacketHandler handler : handlers)
		{
			Method method = handler.getMethod();
			Instructions instructions = method.getCode().getInstructions();
			List<Instruction> ins = instructions.getInstructions();

			Instruction afterRead = handler.getAfterRead();
			if (afterRead == null)
			{
				continue;
			}

			for (PacketRead read : handler.reads)
			{
				if (read.getStore() == null)
				{
					continue outer;
				}
			}

			List<Instruction> follow = follow(instructions, handler.getStart(), afterRead);
			if (follow == null)
			{
				continue;
			}

			for (Instruction i : follow)
			{
				if (i instanceof ComparisonInstruction)
				{
					continue outer;
				}
			}

			Label afterReadLabel = instructions.createLabelFor(afterRead);

			int idx = ins.indexOf(handler.getStart());
			assert idx != -1;

			if (handler.getStart() instanceof Label)
			{
				++idx;
			}

			net.runelite.asm.pool.Field field = new net.runelite.asm.pool.Field(
				new net.runelite.asm.pool.Class(findClient(group).getName()),
				RUNELITE_PACKET,
				Type.BOOLEAN
			);

			instructions.addInstruction(idx, new GetStatic(instructions, field));
			++idx;

			instructions.addInstruction(idx, new IfEq(instructions, instructions.createLabelFor(ins.get(idx))));
			++idx;

			List<Instruction> toCopy = new ArrayList<>();
			for (Instruction i : follow)
			{
				assert !(i instanceof JumpingInstruction);
				if (i instanceof Label)
				{
					continue;
				}

				toCopy.add(i);
			}

			// Remove getstatic/invoke/store for packet reads
			for (PacketRead read : handler.reads)
			{
				boolean b = toCopy.remove(read.getGetBuffer());
				assert b;
				b = toCopy.remove(read.getInvoke());
				assert b;
				b = toCopy.remove(read.getStore());
				assert b;
			}

			// Add sorted reads
			for (PacketRead read : handler.sortedReads)
			{
				toCopy.add(0, read.getGetBuffer());

				// replace invoke instruction with typed read
				InvokeInstruction ii = (InvokeInstruction) read.getInvoke();
				net.runelite.asm.pool.Method invokeMethod;
				if (read.getType().equals(Type.BYTE))
				{
					invokeMethod = new net.runelite.asm.pool.Method(
						ii.getMethod().getClazz(),
						"runeliteReadByte",
						new Signature("()B")
					);
				}
				else if (read.getType().equals(Type.SHORT))
				{
					invokeMethod = new net.runelite.asm.pool.Method(
						ii.getMethod().getClazz(),
						"runeliteReadShort",
						new Signature("()S")
					);
				}
				else if (read.getType().equals(Type.INT))
				{
					invokeMethod = new net.runelite.asm.pool.Method(
						ii.getMethod().getClazz(),
						"runeliteReadInt",
						new Signature("()I")
					);
				}
				else if (read.getType().equals(Type.STRING))
				{
					invokeMethod = new net.runelite.asm.pool.Method(
						ii.getMethod().getClazz(),
						"runeliteReadString",
						new Signature("()Ljava/lang/String;")
					);
				}
				else
				{
					throw new UnsupportedOperationException("Unknown type " + read.getType());
				}
				toCopy.add(1, new InvokeVirtual(instructions, invokeMethod));

				toCopy.add(2, read.getStore());
			}

			for (Instruction i : toCopy)
			{
				instructions.addInstruction(idx++, i.clone());
			}

			instructions.addInstruction(idx, new Goto(instructions, afterReadLabel));
			++idx;
		}
	}

	private int compareReads(List<PacketRead> r1, List<PacketRead> r2)
	{
		List<Type> t1 = r1.stream()
			.map(pr -> pr.getType())
			.sorted(this::compareType)
			.collect(Collectors.toList());
		List<Type> t2 = r2.stream()
			.map(pr -> pr.getType())
			.sorted(this::compareType)
			.collect(Collectors.toList());
		if (t1.size() != t2.size())
		{
			return Integer.compare(t1.size(), t2.size());
		}

		for (int i = 0; i < t1.size(); ++i)
		{
			Type type1 = t1.get(i), type2 = t2.get(i);

			int cmp = compareType(type1, type2);
			if (cmp != 0)
			{
				return cmp;
			}
		}

		return 0;
	}

	private int compareType(Type t1, Type t2)
	{
		if (t1.getDimensions() != t2.getDimensions())
		{
			return Integer.compare(t1.getDimensions(), t2.getDimensions());
		}
		return t1.toString().compareTo(t2.toString());
	}

	public static int hashConstants(List<Object> constants)
	{
		sha256.reset();
		for (Object o : constants)
		{
			if (o instanceof Number)
			{
				sha256.update(((Number) o).byteValue());
			}
			else if (o instanceof String)
			{
				String s = (String) o;
				sha256.update(s.getBytes());
			}
		}
		byte[] b = sha256.digest();
		return Ints.fromByteArray(b);
	}

	private void insertPacketLength(ClassGroup group, PacketTypeFinder ptf)
	{
		PacketLengthFinder pfl = new PacketLengthFinder(group, ptf);
		pfl.find();

		GetStatic getArray = pfl.getGetArray();
		PutStatic ps = pfl.getStore(); // instruction to store packet length

		Instructions instructions = ps.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		Label getArrayLabel = instructions.createLabelFor(getArray);
		Label storeLabel = instructions.createLabelFor(ps);

		int idx = ins.indexOf(getArray);
		assert idx != -1;

		--idx; // to go before label, which must exist

		net.runelite.asm.pool.Field field = new net.runelite.asm.pool.Field(
			new net.runelite.asm.pool.Class(findClient(group).getName()),
			RUNELITE_PACKET,
			Type.BOOLEAN
		);

		instructions.addInstruction(idx++, new GetStatic(instructions, field));
		instructions.addInstruction(idx++, new IfEq(instructions, getArrayLabel));
		instructions.addInstruction(idx++, new LDC(instructions, -2)); // 2 byte length
		instructions.addInstruction(idx++, new Goto(instructions, storeLabel));
	}

	private ClassFile findClient(ClassGroup group)
	{
		// "client" in vainlla but "Client" in deob..
		ClassFile cf = group.findClass("client");
		return cf != null ? cf : group.findClass("Client");
	}

	private List<Instruction> follow(Instructions instructions, Instruction start, Instruction end)
	{
		List<Instruction> list = new ArrayList<>();

		int idx = instructions.getInstructions().indexOf(start);
		assert idx != -1;

		for (;;)
		{
			Instruction i = instructions.getInstructions().get(idx);

			// end is the following instruction post read.. not included
			if (i == end)
			{
				break;
			}

			if (i instanceof Goto)
			{
				Goto g = (Goto) i;
				Label to = g.getTo();

				idx = instructions.getInstructions().indexOf(to);
				assert idx != -1;
				continue;
			}

			list.add(i);

			if (i instanceof ComparisonInstruction)
			{
				return list;
			}

			++idx;
		}

		return list;
	}
}
