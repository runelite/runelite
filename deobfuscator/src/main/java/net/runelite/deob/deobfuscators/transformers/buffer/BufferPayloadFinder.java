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
package net.runelite.deob.deobfuscators.transformers.buffer;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferPayloadFinder
{
	private static final Logger logger = LoggerFactory.getLogger(BufferPayloadFinder.class);

	private final ClassFile bufferClass;

	private Field offset;
	private Field buffer;

	public BufferPayloadFinder(ClassFile bufferClass)
	{
		this.bufferClass = bufferClass;
	}

	public void find()
	{
		for (Field field : bufferClass.getFields())
		{
			if (field.getType().equals(Type.INT))
			{
				offset = field;
			}
			else if (field.getType().equals(new Type("[B")))
			{
				buffer = field;
			}
		}

		logger.info("Found offset {} buffer {}", offset, buffer);
	}

	public Field getOffset()
	{
		return offset;
	}

	public Field getBuffer()
	{
		return buffer;
	}
}
