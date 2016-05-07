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

package net.runelite.asm.attributes.code;

import net.runelite.asm.ClassFile;
import net.runelite.asm.attributes.Code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exceptions
{
	private Code code;
	private List<Exception> exceptions = new ArrayList<Exception>();

	public Exceptions(Code code)
	{
		this.code = code;
	}
	
	public void load(DataInputStream is) throws IOException
	{
		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			exceptions.add(new Exception(this, is));
	}
	
	public void add(Exception e)
	{
		exceptions.add(e);
	}
	
	public void remove(Exception e)
	{
		exceptions.remove(e);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(exceptions.size());
		for (Exception e : exceptions)
		{
			assert e.getExceptions() == this;
			e.write(out);
		}
	}

	public Code getCode()
	{
		return code;
	}
	
	public List<Exception> getExceptions()
	{
		return exceptions;
	}
	
	public void renameClass(ClassFile cf, String name)
	{
		for (Exception e : exceptions)
			e.renameClass(cf, name);
	}
}