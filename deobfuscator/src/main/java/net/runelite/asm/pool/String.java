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

import net.runelite.asm.ConstantPool;
import net.runelite.asm.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class String extends PoolEntry
{
	private int stringIndex;
	private java.lang.String string;

	public String(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.STRING);

		stringIndex = is.readUnsignedShort();
	}
	
	public String(java.lang.String str)
	{
		super(ConstantType.STRING);
		
		string = str;
	}

	@Override
	public String copy()
	{
		return new String(string);
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		string = pool.getUTF8(stringIndex);
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		stringIndex = pool.makeUTF8(string);
	}
	
	@Override
	public Type getTypeClass()
	{
		return new Type(java.lang.String.class.getCanonicalName());
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof String))
			return false;
		
		String s = (String) other;
		return string.equals(s.string);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.string);
		return hash;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(stringIndex);
	}

	@Override
	public Object getObject()
	{
		return string;
	}
}
