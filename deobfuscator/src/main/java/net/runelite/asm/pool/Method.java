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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Method extends PoolEntry
{
	private int classIndex, natIndex;
	private Class clazz;
	private NameAndType nat;
	
	public Method(Class clazz, NameAndType nat)
	{
		super(ConstantType.METHODREF);
		
		this.clazz = clazz;
		this.nat = nat;
	}

	public Method(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.METHODREF);

		classIndex = is.readUnsignedShort();
		natIndex = is.readUnsignedShort();
	}

	@Override
	public Method copy()
	{
		return new Method(clazz.copy(), nat.copy());
	}

	@Override
	public java.lang.String toString()
	{
		return clazz + "." + nat;
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		clazz = pool.getClass(classIndex);
		nat = pool.getNameAndType(natIndex);
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		classIndex = pool.make(clazz);
		natIndex = pool.make(nat);		
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Method))
			return false;
		
		Method m = (Method) other;
		return clazz.equals(m.clazz) && nat.equals(m.nat);
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.clazz);
		hash = 67 * hash + Objects.hashCode(this.nat);
		return hash;
	}
	
	public Class getClassEntry()
	{
		return clazz;
	}

	public NameAndType getNameAndType()
	{
		return nat;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(classIndex);
		out.writeShort(natIndex);
	}
}
