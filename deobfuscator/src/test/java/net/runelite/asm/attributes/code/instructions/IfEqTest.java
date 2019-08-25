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
package net.runelite.asm.attributes.code.instructions;

import static net.runelite.asm.Type.INT;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IfEqTest
{

	@Test
	public void testIsSame()
	{
		Instructions ins = mock(Instructions.class);
		Frame originalIfEqFrame = mock(Frame.class);
		Stack stack = new Stack(42);

		Variables variables = new Variables(42);
		when(originalIfEqFrame.getStack()).thenReturn(stack);
		when(originalIfEqFrame.getVariables()).thenReturn(variables);

		variables.set(9, new VariableContext(INT));

		Instruction i = new LDC(ins, 0);
		InstructionContext ctx = new InstructionContext(i, originalIfEqFrame);

		// ifeq 0
		IfEq ifeq = new IfEq(ins, InstructionType.IFEQ);
		InstructionContext ifeqCtx = new InstructionContext(ifeq, originalIfEqFrame);
		ifeqCtx.pop(new StackContext(ctx, INT, new Value(1)));

		//
		ins = mock(Instructions.class);
		Frame originalIfIcmpNeFrame = mock(Frame.class);
		stack = new Stack(42);
		variables = new Variables(42);
		when(originalIfIcmpNeFrame.getStack()).thenReturn(stack);
		when(originalIfIcmpNeFrame.getVariables()).thenReturn(variables);
		variables.set(5, new VariableContext(INT));

		i = new LDC(ins, 1);
		InstructionContext ctx1 = new InstructionContext(i, originalIfIcmpNeFrame);
		i = new ILoad(ins, 5);
		InstructionContext ctx2 = new InstructionContext(i, originalIfIcmpNeFrame);

		// ificmpne 1
		IfICmpNe ificmpne = new IfICmpNe(ins, InstructionType.IF_ICMPNE);
		InstructionContext ificmpneCtx = new InstructionContext(ificmpne, originalIfIcmpNeFrame);
		ificmpneCtx.pop(
			new StackContext(ctx1, INT, new Value(1)),
			new StackContext(ctx2, INT, Value.UNKNOWN)
		);

		assertEquals(
			ifeq.isSame(ifeqCtx, ificmpneCtx),
			ificmpne.isSame(ificmpneCtx, ifeqCtx)
		);
		
		// check that both frames jump the same direction
		
		Frame ifeqBranchFrame = mock(Frame.class);
		ifeqCtx.branch(ifeqBranchFrame);
		
		Frame ificmpneBranchFrame = mock(Frame.class);
		ificmpneCtx.branch(ificmpneBranchFrame);
		
		// initially originalIfEqFrame.other == originalIfIcmpNeFrame.other
		when(originalIfEqFrame.getOther()).thenReturn(originalIfIcmpNeFrame);
		when(originalIfIcmpNeFrame.getOther()).thenReturn(originalIfEqFrame);
		
		ParallelExecutorMapping mapping = mock(ParallelExecutorMapping.class);
		ifeq.map(mapping, ifeqCtx, ificmpneCtx);
		
		// verify that ifeqBranchFrame.other = ificmpneBranchFrame
		ArgumentCaptor<Frame> frameCapture = ArgumentCaptor.forClass(Frame.class);
		verify(ifeqBranchFrame).setOther(frameCapture.capture());
		assertEquals(ificmpneBranchFrame, frameCapture.getValue());
	}
}
