/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.pool;

public enum ConstantType
{
	CLASS(7, Class.class),
	FIELDREF(9, Field.class),
	METHODREF(10, Method.class),
	INTERFACE_METHOD_REF(11, InterfaceMethod.class),
	STRING(8, String.class),
	INTEGER(3, Integer.class),
	FLOAT(4, Float.class),
	LONG(5, Long.class),
	DOUBLE(6, Double.class),
	NAME_AND_TYPE(12, NameAndType.class),
	UTF8(1, UTF8.class);

	private int value;
	private java.lang.Class<? extends PoolEntry> clazz;

	ConstantType(int value, java.lang.Class<? extends PoolEntry> clazz)
	{
		this.value = value;
		this.clazz = clazz;
	}

	public int getType()
	{
		return value;
	}

	public java.lang.Class<? extends PoolEntry> getPoolClass()
	{
		return clazz;
	}

	public static ConstantType findFromType(int type)
	{
		for (ConstantType t : ConstantType.values())
			if (t.getType() == type)
				return t;
		return null;
	}
}
