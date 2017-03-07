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
package net.runelite.cache.script.interpreter;

import net.runelite.cache.script.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericInstructionHandler extends InstructionHandler
{
	private static final Logger logger = LoggerFactory.getLogger(GenericInstructionHandler.class);

	@Override
	public void execute(Frame frame, InstructionContext ctx)
	{
		Instruction i = ctx.getScriptInstruction().getInstruction();
		Stack istack = frame.getIntStack();
		Stack sstack = frame.getStringStack();

		int ipops = i.getIntStackPops();
		for (int j = 0; j < ipops; ++j)
		{
			StackContext value = istack.pop();
			ctx.popsInt(value);
			value.poppedBy(ctx);
		}

		int spops = i.getStringStackPops();
		for (int j = 0; j < spops; ++j)
		{
			StackContext value = sstack.pop();
			ctx.popsString(value);
			value.poppedBy(ctx);
		}

		int ipushes = i.getIntStackPushes();
		for (int j = 0; j < ipushes; ++j)
		{
			StackContext sctx = new StackContext(ctx, null);
			istack.push(sctx);
			ctx.pushesInt(sctx);
		}

		int spushes = i.getStringStackPushes();
		for (int j = 0; j < spushes; ++j)
		{
			StackContext sctx = new StackContext(ctx, null);
			sstack.push(sctx);
			ctx.pushesString(sctx);
		}

		if (ipushes > 0 || spushes > 0)
		{
			logger.debug("Executed instruction {} with {}/{} pushes!", i, ipushes, spushes);
		}
	}

}
