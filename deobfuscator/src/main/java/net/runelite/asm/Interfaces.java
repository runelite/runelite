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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.pool.Class;

public class Interfaces
{
	private ClassFile classFile;

	private List<Class> interfaces = new ArrayList<Class>();

	Interfaces(ClassFile c, DataInputStream is) throws IOException
	{
		classFile = c;

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			interfaces.add(c.getPool().getClass(is.readUnsignedShort()));
	}
	
	Interfaces(ClassFile c)
	{
		classFile = c;
	}
	
	public void addInterface(Class clazz)
	{
		if (!interfaces.contains(clazz))
			interfaces.add(clazz);
	}
	
	public List<Class> getInterfaces()
	{
		return interfaces;
	}
	
	public void setInterfaces(List<Class> interfaces)
	{
		this.interfaces = interfaces;
	}
	
	public List<ClassFile> getMyInterfaces()
	{
		List<ClassFile> l = new ArrayList<>();
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface != null)
				l.add(iface);
		}
		return l;
	}
	
	public List<Class> getNonMyInterfaces()
	{
		return interfaces.stream().filter(clazz -> classFile.getGroup().findClass(clazz.getName()) == null).collect(Collectors.toList());
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(interfaces.size());
		for (Class clazz : interfaces)
			out.writeShort(classFile.getPool().make(clazz));
	}
	
	public boolean instanceOf(ClassFile cf)
	{
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface.instanceOf(cf))
				return true;
		}
		return false;
	}
}
