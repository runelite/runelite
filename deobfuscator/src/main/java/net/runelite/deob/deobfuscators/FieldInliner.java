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

package net.runelite.deob.deobfuscators;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldInliner implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(FieldInliner.class);

	private ClassGroup group;
	private Multimap<Field, FieldInstruction> fieldInstructions = HashMultimap.create();
	private List<Field> fields = new ArrayList<>();
	
	private void findFieldIns()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				for (Instruction i : code.getInstructions().getInstructions())
				{
					if (!(i instanceof FieldInstruction))
						continue;
					
					FieldInstruction sf = (FieldInstruction) i;
					
					if (sf.getMyField() == null)
						continue;

					fieldInstructions.put(sf.getMyField(), sf);
				}
			}
		}
	}
	
	private void makeConstantValues()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Field f : cf.getFields())
			{
				if (!f.isStatic() || !f.getType().equals(Type.STRING))
					continue;
				
				Object constantValue = f.getValue();
				if (constantValue != null)
					continue;

				List<FieldInstruction> sfis = fieldInstructions.get(f).stream().filter(f2 -> f2 instanceof SetFieldInstruction).collect(Collectors.toList());
				if (sfis.size() != 1)
					continue;
				
				SetFieldInstruction sfi = (SetFieldInstruction) sfis.get(0);
				Instruction ins = (Instruction) sfi;
				
				Method mOfSet = ins.getInstructions().getCode().getMethod();
				if (!mOfSet.getName().equals("<clinit>"))
					continue;
				
				// get prev instruction and change to a constant value
				Instructions instructions = mOfSet.getCode().getInstructions();
				int idx = instructions.getInstructions().indexOf(ins);
				assert idx != -1;
				
				Instruction prev = instructions.getInstructions().get(idx - 1);
				if (!(prev instanceof PushConstantInstruction))
					continue;
				
				PushConstantInstruction pci = (PushConstantInstruction) prev;
				
				constantValue = pci.getConstant();
				f.setValue(constantValue);
				
				fields.add(f);
				
				boolean b = instructions.getInstructions().remove(prev);
				assert b;
				b = instructions.getInstructions().remove(ins);
				assert b;
			}
		}
	}
	
	public int inlineUse()
	{
		int count = 0;
		
		for (Field f : fields)
		{
			// replace getfield with constant push
			List<FieldInstruction> fins = fieldInstructions.get(f).stream().filter(f2 -> f2 instanceof GetFieldInstruction).collect(Collectors.toList());
			Object value = f.getValue();
			
			for (FieldInstruction fin : fins)
			{
				// remove fin, add push constant
				Instruction i = (Instruction) fin;
				
				Instruction pushIns = new LDC(i.getInstructions(), value);
				
				List<Instruction> instructions = i.getInstructions().getInstructions();
				
				int idx = instructions.indexOf(i);
				assert idx != -1;
				
				i.getInstructions().remove(i);
				instructions.add(idx, pushIns);
				
				++count;
			}

			f.getClassFile().removeField(f);
		}
		
		return count;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		findFieldIns();
		makeConstantValues();
		int count = inlineUse();
		
		logger.info("Inlined " + count + " fields");
	}
	
}
