/*
 * Copyright (c) 2018, Lucas <https://github.com/Lucwousin>
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
package net.runelite.injector.raw;

import com.google.common.collect.Lists;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IALoad;
import net.runelite.asm.attributes.code.instructions.IAStore;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IOr;
import net.runelite.asm.attributes.code.instructions.IShR;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.IUShR;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectUtil;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RasterizerAlpha
{
	private static final Logger logger = LoggerFactory.getLogger(RasterizerAlpha.class);
	private static final net.runelite.asm.pool.Method DRAWALPHA = new net.runelite.asm.pool.Method(
		new Class("client"),
		"drawAlpha",
		new Signature("([IIII)V")
	);
	private static final int ALPHA = 0xff000000;

	private final Inject inject;

	public RasterizerAlpha(Inject inject)
	{
		this.inject = inject;
	}

	/*
	 * This class exists cause of removing colour banding.
	 *
	 * Push array on stack
	 * Push array index on stack
	 * Push colour on stack -> we're interested in where the colour comes from
	 * Put colour in array, popping array, index and colour
	 *
	 *
	 *
	 */
	public void inject() throws InjectionException
	{
		final Field r2dPx = InjectUtil.findDeobField(inject, "Rasterizer2D_pixels", "Rasterizer2D");
		final Method draw = InjectUtil.findMethod(inject, "draw", "Client");
		final ClassFile rasterizer2D = r2dPx.getClassFile();
		final Execution ex = new Execution(rasterizer2D.getGroup());
		ex.staticStep = false;
		ex.step = false;
		ex.addMethod(draw);

		int[] counts = new int[2];

		ex.addMethodContextVisitor((MethodContext mc) ->
		{
			Instructions instrs = getInstrs(mc);
			if (instrs == null)
				return;

			int count = 0;
			int orCount = 0;

			for (InstructionContext ic : mc.getInstructionContexts())
			{
				Instruction instruction = ic.getInstruction();
				if (!(instruction instanceof IAStore))
					continue;

				// Field field = astore.getMyField(ic);
				// doesn't track into methods so doing it here
				StackContext array = ic.getPops().get(2);

				if (!isSameField(r2dPx, array))
					continue;

				// This is the colour that's being set
				StackContext colour = ic.getPops().get(0);

				// resolve gets the original value pusher
				InstructionContext colPusher = colour.getPushed().resolve(colour);
				Instruction colPushI = colPusher.getInstruction();

				// If it's not a >> or a | we're not interested
				if (colPushI instanceof LVTInstruction // when called from a method we didn't execute
					|| colPushI instanceof PushConstantInstruction &&
					!((PushConstantInstruction) colPushI).getConstant().equals(0)
					|| colPushI instanceof IALoad)
				{
					// OR with 0xFF000000, unless 0
					int storeIdx = instrs.getInstructions().indexOf(instruction);

					instrs.addInstruction(storeIdx++, new LDC(instrs, ALPHA));
					instrs.addInstruction(storeIdx, new IOr(instrs, InstructionType.IOR));
					++orCount;
					continue;
				}
				else if (!(
					colPushI instanceof IShR ||
					colPushI instanceof IUShR ||
					colPushI instanceof IAdd))
				{
					continue;
				}

				// So we know we're dealing with alpha here, now we need the alpha value
				// earlier on in the method there's been a 256 - XXX, where xxx is alpha

				for (InstructionContext ins : mc.getInstructionContexts())
				{
					if (!(ins.getInstruction() instanceof SiPush))
						continue;

					SiPush pci = (SiPush) ins.getInstruction();
					if ((short) pci.getConstant() != (short) 256)
						continue;

					InstructionContext isub = ins.getPushes().get(0).getPopped().get(0);
					if (!(isub.getInstruction() instanceof ISub))
						continue;

					StackContext alphaPop = isub.getPops().get(0);
					InstructionContext alphaPusher = alphaPop.getPushed().resolve(alphaPop);
					InstructionContext isubResult = isub.getPushes().get(0).getPopped().get(0);

					if (pushesToSameField(isubResult, alphaPusher))
					{
						alphaPusher = resolveFieldThroughInvokes(alphaPop);

						if (alphaPusher == null)
							throw new RuntimeException("Alpha var is overwritten and we don't know what pushed it"); // cheeky unchecked
					}

					int storeIdx = instrs.getInstructions().indexOf(instruction);

					Instruction alphaPushI = alphaPusher.getInstruction();
					if (alphaPushI instanceof GetStatic)
					{
						instrs.addInstruction(storeIdx++, new LDC(instrs, 255));
						instrs.addInstruction(storeIdx++, new GetStatic(instrs, ((GetStatic) alphaPushI).getField()));
						instrs.addInstruction(storeIdx++, new ISub(instrs, InstructionType.ISUB));
					}
					else if (alphaPushI instanceof LVTInstruction)
					{
						instrs.addInstruction(storeIdx++, new ILoad(instrs, ((LVTInstruction) alphaPushI).getVariableIndex()));
					}

					instrs.getInstructions().set(storeIdx, new InvokeStatic(instrs, DRAWALPHA));
					++count;
					break;
				}
			}

			if (orCount != 0)
			{
				counts[0] += orCount;
				logger.info("Added {} OR's into {}", orCount, mc.getMethod());
			}
			if (count != 0)
			{
				counts[1] += count;
				logger.info("Injected {} DrawAlpha invokes into {}", count, mc.getMethod());
			}
		});

		ex.run();
		logger.info("Injected {} DrawAlpha invokes and {} ors", counts[1], counts[0]);
	}

	private static boolean pushesToSameField(InstructionContext cA, InstructionContext cB)
	{
		if (cA.getInstruction() instanceof FieldInstruction && cB instanceof FieldInstruction)
		{
			Field a = ((FieldInstruction) cA.getInstruction()).getMyField();
			Field b = ((FieldInstruction) cB.getInstruction()).getMyField();

			return a == b;
		}

		return false;
	}

	private static Instructions getInstrs(MethodContext mc)
	{
		Code c = mc.getMethod().getCode();
		if (c == null)
			return null;

		return c.getInstructions();
	}

	private static InstructionContext resolveFieldThroughInvokes(StackContext stackContext)
	{
		InstructionContext pusher = stackContext.getPushed().resolve(stackContext);
		if (pusher.getInstruction() instanceof GetFieldInstruction)
			return pusher;

		// No field I wanna trace, rn at least
		if (!(pusher.getInstruction() instanceof LVTInstruction))
			return null;

		int vidx = ((LVTInstruction) pusher.getInstruction()).getVariableIndex();

		VariableContext vc = pusher.getVariables().get(vidx);
		stackContext = Lists.reverse(vc.getInstructionWhichStored().getPops()).get(vidx);

		return resolveFieldThroughInvokes(stackContext);
	}

	private static boolean isSameField(Field f, StackContext array)
	{
		InstructionContext ic = resolveFieldThroughInvokes(array);

		if (ic == null)
			return false;

		return ((GetFieldInstruction) ic.getInstruction()).getMyField() == f;
	}
}
