/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, UniquePassive <https://github.com/uniquepassive>
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
package net.runelite.deob.deobfuscators.membermover;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.deobfuscators.Renamer;
import net.runelite.deob.util.OwnerMappings;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class MemberMover implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MemberMover.class);

	private MoveBackMethods moveBackMethods = new MoveBackMethods();

	private ClassFile staticClass;

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();

		moveBackMethods = new MoveBackMethods();
		moveBackMethods.run(group);

		findOrCreateStaticClass(group);

		moveStaticMethods(group);
		moveStaticFields(group);

		this.regeneratePool(group);
	}

	private void findOrCreateStaticClass(ClassGroup group)
	{
		staticClass = group.findClass("Static");

		if (staticClass == null)
		{
			staticClass = new ClassFile(group);

			staticClass.setName("Static");
			staticClass.setSuperName("java/lang/Object");
			staticClass.setVersion(Opcodes.V1_6);
			staticClass.setAccess(Opcodes.ACC_PUBLIC);

			group.addClass(staticClass);
		}
	}

	private void moveStaticMethods(ClassGroup group)
	{
		OwnerMappings ownerMappings = new OwnerMappings();

		for (Method m : moveBackMethods.getUsedMethods())
		{
			if (moveBackMethods.getMovedMethods().contains(m))
			{
				continue;
			}

			ownerMappings.map(m.getPoolMethod(), staticClass.getName());
		}

		Renamer renamer = new Renamer(ownerMappings);
		renamer.run(group);

		logger.info("Moved {} static methods to Static", ownerMappings.getMap().size());
	}

	private void moveStaticFields(ClassGroup group)
	{
		OwnerMappings ownerMappings = new OwnerMappings();

		for (ClassFile cf : group.getClasses())
		{
			Set<String> initializedFields = new HashSet<>();

			Method clinit = cf.findMethod("<clinit>");

			if (clinit != null)
			{
				for (Instruction i : clinit.getCode().getInstructions().getInstructions())
				{
					if (i instanceof SetFieldInstruction)
					{
						SetFieldInstruction sfi = (SetFieldInstruction) i;

						if (!sfi.getMyField().isStatic())
						{
							continue;
						}

						initializedFields.add(sfi.getMyField().getName());
					}
				}
			}

			cf.getFields()
					.stream()
					.filter(Field::isStatic)
					.filter(f -> !initializedFields.contains(f.getName()))
					.forEach(f -> ownerMappings.map(f.getPoolField(), staticClass.getName()));
		}

		Renamer renamer = new Renamer(ownerMappings);
		renamer.run(group);

		logger.info("Moved {} static fields to Static", ownerMappings.getMap().size());
	}

	private void regeneratePool(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code c = m.getCode();
				if (c == null)
				{
					continue;
				}

				c.getInstructions().regeneratePool();
			}
		}
	}
}
