/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.asm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.signature.Signature;
import static net.runelite.deob.DeobAnnotations.*;

public class ClassGroup
{
	private final List<ClassFile> classes = new ArrayList<>(); // to keep order
	private final Map<String, ClassFile> classMap = new HashMap<>();

	public void addClass(ClassFile cf)
	{
		assert cf.getGroup() == this || cf.getGroup() == null;
		cf.setGroup(this);

		classes.add(cf);
		classMap.put(cf.getName(), cf);
	}

	public void removeClass(ClassFile cf)
	{
		classes.remove(cf);
		classMap.remove(cf.getName());
	}

	public void renameClass(ClassFile cf, String newName)
	{
		assert classes.contains(cf);
		assert classMap.get(cf.getName()) == cf;

		classMap.remove(cf.getName());
		cf.setName(newName);
		classMap.put(cf.getName(), cf);
	}

	public List<ClassFile> getClasses()
	{
		return Collections.unmodifiableList(classes);
	}

	public ClassFile findClass(String name)
	{
		return classMap.get(name);
	}

	public void initialize()
	{
		buildClassGraph();
		lookup();
	}

	public void buildClassGraph()
	{
		for (ClassFile c : classes)
		{
			c.clearClassGraph();
		}

		for (ClassFile c : classes)
		{
			c.buildClassGraph();
		}
	}

	public void lookup()
	{
		for (ClassFile cf : this.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();

				if (code == null)
				{
					continue;
				}

				code.getInstructions().lookup();
			}
		}
	}

	public Method findStaticMethod(String name, Signature type)
	{
		Method m = null;

		for (ClassFile cf : classes)
		{
			m = cf.findStaticMethod(name, type);

			if (m != null)
			{
				break;
			}
		}

		return m;
	}

	public Method findStaticMethod(String name)
	{
		Method m = null;

		for (ClassFile cf : classes)
		{
			m = cf.findStaticMethod(name);

			if (m != null)
			{
				break;
			}
		}

		return m;
	}

	public ClassFile findObfuscatedName(String name)
	{
		for (ClassFile cf : classes)
		{
			if (name.equals(getObfuscatedName(cf.getAnnotations())))
			{
				return cf;
			}
		}

		return findClass(name);
	}
}
