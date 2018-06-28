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
package net.runelite.deob.deobfuscators.packethandler;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IALoad;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketLengthFinder
{
	private static final Logger logger = LoggerFactory.getLogger(PacketLengthFinder.class);

	private final ClassGroup group;
	private final PacketTypeFinder packetType;

	private Field packetLength;
	private GetStatic getArray;
	private GetStatic getType;
	private IALoad load;
	private PutStatic store;

	public PacketLengthFinder(ClassGroup group, PacketTypeFinder packetType)
	{
		this.group = group;
		this.packetType = packetType;
	}

	public Field getPacketLength()
	{
		return packetLength;
	}

	public GetStatic getGetArray()
	{
		return getArray;
	}

	public GetStatic getGetType()
	{
		return getType;
	}

	public IALoad getLoad()
	{
		return load;
	}

	public PutStatic getStore()
	{
		return store;
	}

	public void find()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				run(method.getCode());
			}
		}

		logger.info("Found packet length: {}", packetLength);
	}

	//   getstatic             class272/field3690 [I
	//   getstatic             Client/packetType I
	//   iaload
	//   putstatic             Client/packetLength I
	private void run(Code code)
	{
		if (code == null)
		{
			return;
		}

		Instructions instructions = code.getInstructions();
		Field type = packetType.getPacketType();

		for (int i = 0; i < instructions.getInstructions().size() - 3; ++i)
		{
			Instruction i1 = instructions.getInstructions().get(i),
				i2 = instructions.getInstructions().get(i + 1),
				i3 = instructions.getInstructions().get(i + 2),
				i4 = instructions.getInstructions().get(i + 3);

			if (!(i1 instanceof GetStatic))
			{
				continue;
			}

			if (!(i2 instanceof GetStatic))
			{
				continue;
			}

			GetStatic gs = (GetStatic) i2;

			if (gs.getMyField() != type)
			{
				continue;
			}

			if (!(i3 instanceof IALoad))
			{
				continue;
			}

			if (!(i4 instanceof PutStatic))
			{
				continue;
			}

			PutStatic ps = (PutStatic) i4;
			assert packetLength == null : "packetLength already found";
			packetLength = ps.getMyField();
			getArray = (GetStatic) i1;
			getType = gs;
			load = (IALoad) i3;
			store = ps;
			return;
		}
	}
}
