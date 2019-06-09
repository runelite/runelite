/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.asm.attributes.code.instructions;

import static net.runelite.asm.Type.INT;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.asm.execution.Variables;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IfICmpEqTest
{

	@Test
	public void testIsSame()
	{
		Instructions ins = mock(Instructions.class);
		Frame frame = mock(Frame.class);
		Stack stack = new Stack(42);

		Variables variables = new Variables(42);
		when(frame.getStack()).thenReturn(stack);
		when(frame.getVariables()).thenReturn(variables);

		IfICmpEq ifeq = new IfICmpEq(ins, InstructionType.IF_ICMPEQ);
		InstructionContext ifeqCtx = new InstructionContext(ifeq, frame);
		ifeqCtx.pop(new StackContext(getConstantCtx(ins, 1), INT, new Value(1)));
		ifeqCtx.pop(new StackContext(getConstantCtx(ins, 1), INT, new Value(1)));

		IfNe ifne = new IfNe(ins, InstructionType.IFNE);
		InstructionContext ifneCtx = new InstructionContext(ifne, frame);
		ifneCtx.pop(new StackContext(getConstantCtx(ins, 42), INT, new Value(42)));

		assertTrue(ifeq.isSame(ifeqCtx, ifneCtx));
	}

	private InstructionContext getConstantCtx(Instructions ins, int constant)
	{
		LDC ldc = new LDC(ins, constant);
		InstructionContext pushConstantCtx = mock(InstructionContext.class);
		when(pushConstantCtx.getInstruction()).thenReturn(ldc);
		return pushConstantCtx;
	}
}
