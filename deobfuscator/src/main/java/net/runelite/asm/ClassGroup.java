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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.runelite.asm.attributes.Code;

public class ClassGroup
{
	private List<ClassFile> classes = new ArrayList<>();

	public ClassGroup()
	{
	}

	public ClassFile addClass(String name, DataInputStream is) throws IOException
	{
		ClassFile cf = new ClassFile(this, is);
		classes.add(cf);
		return cf;
	}
	
	public void addClass(ClassFile cf)
	{
		classes.add(cf);
	}
	
	public void removeClass(ClassFile cf)
	{
		classes.remove(cf);
	}
	
	public List<ClassFile> getClasses()
	{
		return classes;
	}

	public ClassFile findClass(String name)
	{
		// XXX handle arrays?
		for (ClassFile c : classes)
			if (c.getName().equals(name))
				return c;
		return null;
	}
	
	public void initialize()
	{
		//sort();
		buildClassGraph();
		lookup();
	}
	
	private int classNum(ClassFile cf)
	{
		if (cf.getName().startsWith("class"))
			return Integer.parseInt(cf.getName().substring(5));
		
		return -1;
	}
	
	// order of classes affects class graph (eg order of children classes) which affects comparing two classgroups
	private void sort()
	{
		// only sort renamed jars
		for (ClassFile c : classes)
			if (c.getName().startsWith("class") == false && !c.getName().equals("client"))
				return;
		
		Collections.sort(classes, (c1, c2) -> {
			int n1 = classNum(c1), n2 = classNum(c2);
			return Integer.compare(n1, n2);
		});
	}

	public void buildClassGraph()
	{
		for (ClassFile c : classes)
			c.clearClassGraph();
		
		for (ClassFile c : classes)
			c.buildClassGraph();
	}
	
	public void lookup()
	{
		for (ClassFile cf : this.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				code.getInstructions().lookup();
			}
		
	}
}
