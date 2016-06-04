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

package net.runelite.asm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.pool.ConstantType;
import net.runelite.asm.pool.InterfaceMethod;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.pool.UTF8;

public class ConstantPool
{
	private ClassFile classFile;

	private List<PoolEntry> entries = new ArrayList<PoolEntry>();
	
	ConstantPool(ClassFile c)
	{
		classFile = c;
	}

	ConstantPool(ClassFile c, DataInputStream is) throws IOException
	{
		this(c);

		int count = is.readUnsignedShort();

		for (int i = 1; i < count; ++i)
		{
			byte typeCode = is.readByte();

			ConstantType type = ConstantType.findFromType(typeCode);

			try
			{
				Constructor<? extends PoolEntry> con = type.getPoolClass().getConstructor(new Class[] { ConstantPool.class, DataInputStream.class });
				PoolEntry entry = con.newInstance(this, is);
				entry.id = i;

				entries.add(entry);
				i += entry.getSlots() - 1;
			}
			catch (Exception e)
			{
				throw new IOException(e);
			}
		}
		
		for (PoolEntry entry : entries)
			entry.resolve(this);
	}
	
	public void reset()
	{
		for (PoolEntry entry : entries)
		{
			entry.id = 0;
		}
		
		entries.clear();
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		/* this grows as it is iterated */
		for (int i = 0; i < entries.size(); ++i)
		{
			PoolEntry entry = entries.get(i);
			entry.prime(this);
		}
		
		int size = 0;
		for (PoolEntry entry : entries)
			size += entry.getSlots();
		
		out.writeShort(size + 1);
		int i = 1;
		for (PoolEntry entry : entries)
		{
			assert i == entry.id;
			i += entry.getSlots();
			
			out.writeByte(entry.getType().getType());
			entry.write(out);
		}
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	public PoolEntry getEntry(int index)
	{
		for (PoolEntry entry : entries)
			if (entry.id == index)
				return entry;
		return null;
	}
	
	public String getUTF8(int index)
	{
		PoolEntry entry = getEntry(index);
		UTF8 u = (UTF8) entry;
		return u.getValue();
	}
	
	public net.runelite.asm.pool.Class getClass(int index)
	{
		return (net.runelite.asm.pool.Class) getEntry(index);
	}
	
	public net.runelite.asm.pool.Field getField(int index)
	{
		return (net.runelite.asm.pool.Field) getEntry(index);
	}
	
	public InterfaceMethod getInterfaceMethod(int index)
	{
		return (InterfaceMethod) getEntry(index);
	}
	
	public net.runelite.asm.pool.Method getMethod(int index)
	{
		return (net.runelite.asm.pool.Method) getEntry(index);
	}
	
	public NameAndType getNameAndType(int index)
	{
		return (NameAndType) getEntry(index);
	}
	
	public int make(PoolEntry entry)
	{
		int i = 1;
		
		for (PoolEntry e : entries)
		{
			if (e.equals(entry))
			{
				assert e.getClass() == entry.getClass();
				return i;
			}
			
			i += e.getSlots();
		}
		
		entries.add(entry);
		entry.id = i;
		return i;
	}
	
	public int makeUTF8(String str)
	{
		return make(new UTF8(str));
	}
	
	public int make(Object object)
	{
		if (object instanceof String)
			return make(new net.runelite.asm.pool.String((String) object));
		
		if (object instanceof Integer)
			return make(new net.runelite.asm.pool.Integer((int) object));
		
		if (object instanceof Float)
			return make(new net.runelite.asm.pool.Float((float) object));
		
		if (object instanceof Long)
			return make(new net.runelite.asm.pool.Long((long) object));
		
		if (object instanceof Double)
			return make(new net.runelite.asm.pool.Double((double) object));
		
		System.err.println("Constant pool make with unknown object " + object + " type " + object.getClass());
		
		return 0;
	}
}
