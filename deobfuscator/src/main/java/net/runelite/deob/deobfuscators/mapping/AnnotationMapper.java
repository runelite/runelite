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

package net.runelite.deob.deobfuscators.mapping;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Type;

public class AnnotationMapper
{
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	private static final Type REPLACE = new Type("Lnet/runelite/mapping/Replace;");
	private static final Type OBFUSCATED_OVERRIDE = new Type("Lnet/runelite/mapping/ObfuscatedOverride;");
	
	private final ClassGroup source, target;
	private final ParallelExecutorMapping mapping;

	public AnnotationMapper(ClassGroup source, ClassGroup target, ParallelExecutorMapping mapping)
	{
		this.source = source;
		this.target = target;
		this.mapping = mapping;
	}

	public void run()
	{
		int count = 0;

		for (ClassFile c : source.getClasses())
		{
			ClassFile other = (ClassFile) mapping.get(c);
			System.out.println(c + " -> " + other);

			if (other == null)
			{
				System.out.println("Unable to map class " + c); // XXX if this has any mappings it won't be reported below.
				continue;
			}

			count += run(c, other);
		}

		System.out.println("Copied " + count + " annotations");
	}

	private int run(ClassFile from, ClassFile to)
	{
		int count = 0;

		count += copyAnnotations(from.getAttributes(), to.getAttributes());

		for (Field f : from.getFields().getFields())
		{
			if (!hasCopyableAnnotation(f.getAttributes()))
				continue;

			Field other = (Field) mapping.get(f);
			if (other == null)
			{
				System.out.println("UNABLE TO MAP " + f);
				continue;
				//assert false;
			}

			count += copyAnnotations(f.getAttributes(), other.getAttributes());
		}

		for (Method m : from.getMethods().getMethods())
		{
			if (!hasCopyableAnnotation(m.getAttributes()))
				continue;

			Method other = (Method) mapping.get(m);
			if (other == null)
			{
				System.out.println("UNABLE TO MAP " + m);
				continue;
				//assert false;
			}

			count += copyAnnotations(m.getAttributes(), other.getAttributes());
		}

		return count;
	}

	private int copyAnnotations(Attributes from, Attributes to)
	{
		int count = 0;

		if (from.getAnnotations() == null)
			return count;
		
		for (Annotation a : from.getAnnotations().getAnnotations())
		{
			if (isCopyable(a))
			{
				assert a.getElements().size() == 1;
				Element e = a.getElements().get(0);

				to.addAnnotation(a.getType(), e.getType().toString(), e.getValue().copy());
				++count;
			}
		}

		return count;
	}

	private boolean hasCopyableAnnotation(Attributes a)
	{
		if (a.getAnnotations() == null)
			return false;

		for (Annotation an : a.getAnnotations().getAnnotations())
			if (isCopyable(an))
				return true;

		return false;
	}

	private boolean isCopyable(Annotation a)
	{
		return a.getType().equals(EXPORT) || a.getType().equals(IMPLEMENTS) || a.getType().equals(REPLACE) || a.getType().equals(OBFUSCATED_OVERRIDE);
	}
}
