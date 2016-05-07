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

import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Methods
{
	ClassFile classFile;

	private List<Method> methods = new ArrayList<>();

	Methods(ClassFile cf, DataInputStream is) throws IOException
	{
		classFile = cf;

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			methods.add(new Method(this, is));
	}
	
	Methods(ClassFile cf)
	{
		classFile = cf;
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(methods.size());
		for (Method m : methods)
			m.write(out);
	}
	
	public void addMethod(Method m)
	{
		methods.add(m);
	}
	
	public void removeMethod(Method m)
	{
		methods.remove(m);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}
	
	public List<Method> getMethods()
	{
		return methods;
	}
	
	public Method findMethod(NameAndType nat)
	{
		for (Method m : methods)
			if (m.getName().equals(nat.getName()) && m.getDescriptor().equals(nat.getDescriptor()))
				return m;
		return null;
	}
	
	public Method findMethod(String name, Signature type)
	{
		for (Method m : methods)
			if (m.getName().equals(name) && m.getDescriptor().equals(type))
				return m;
		return null;
	}
	
	public Method findMethod(String name)
	{
		for (Method m : methods)
			if (m.getName().equals(name))
				return m;
		return null;
	}
}
