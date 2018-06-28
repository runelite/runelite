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

package net.runelite.asm.objectwebasm;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import org.objectweb.asm.ClassWriter;

public class NonloadingClassWriter extends ClassWriter
{
	private final ClassGroup group;

	public NonloadingClassWriter(ClassGroup group, int flags)
	{
		super(flags);

		this.group = group;
	}

	@Override
	protected String getCommonSuperClass(String type1, String type2)
	{
		ClassFile cf1 = group.findClass(type1),
			cf2 = group.findClass(type2);

		if (cf1 == null && cf2 == null)
		{
			// not mine
			try
			{
				return super.getCommonSuperClass(type1, type2);
			}
			catch (RuntimeException ex)
			{
				// java.lang.RuntimeException: java.lang.ClassNotFoundException: com.sun.deploy.appcontext.AppContext
				return "java/lang/Object";
			}
		}

		if (cf1 != null && cf2 != null)
		{
			for (ClassFile c = cf1; c != null; c = c.getParent())
				for (ClassFile c2 = cf2; c2 != null; c2 = c2.getParent())
					if (c == c2)
						return c.getName();

			return "java/lang/Object";
		}

		ClassFile found;
		String other;

		if (cf1 == null)
		{
			found = cf2;
			other = type1;
		}
		else
		{
			assert cf2 == null;
			found = cf1;
			other = type2;
		}

		ClassFile prev = null;

		for (ClassFile c = found; c != null; c = c.getParent())
		{
			prev = c;

			if (c.getName().equals(other))
				return other;
		}

		return super.getCommonSuperClass(prev.getSuperName(), other);
	}
}
