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

package net.runelite.deob.updater;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.signature.Type;
import net.runelite.deob.deobfuscators.Renamer;
import net.runelite.deob.util.NameMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationRenamer
{
	private static final Logger logger = LoggerFactory.getLogger(AnnotationRenamer.class);
	
	private static final Type EXPORT_TYPE = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS_TYPE = new Type("Lnet/runelite/mapping/Implements;");

	private ClassGroup group;

	public AnnotationRenamer(ClassGroup group)
	{
		this.group = group;
	}

	public void run()
	{
		NameMappings mappings = buildMappings();

		Renamer renamer = new Renamer(mappings);
		renamer.run(group);
	}

	private NameMappings buildMappings()
	{
		NameMappings mappings = new NameMappings();

		for (ClassFile cf : group.getClasses())
		{
			String name = getImplements(cf.getAnnotations());
			if (name != null)
				mappings.map(cf.getPoolClass(), name);

			for (Field f : cf.getFields().getFields())
			{
				name = getExport(f.getAnnotations());
				if (name != null)
					mappings.map(f.getPoolField(), name);
			}

			for (Method m : cf.getMethods().getMethods())
			{
				name = getExport(m.getAnnotations());
				if (name != null)
					mappings.map(m.getPoolMethod(), name);
			}
		}

		return mappings;
	}

	private String getExport(Annotations annotations)
	{
		Annotation an = annotations.find(EXPORT_TYPE);
		return an != null ? an.getElement().getString() : null;
	}

	private String getImplements(Annotations annotations)
	{
		Annotation an = annotations.find(IMPLEMENTS_TYPE);
		return an != null ? an.getElement().getString() : null;
	}
}
