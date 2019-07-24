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
package net.runelite.asm.attributes.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.asm.attributes.Code;

public class Instructions
{
	private final Code code;
	private final List<Instruction> instructions = new ArrayList<>();
	private final Map<org.objectweb.asm.Label, Label> labelMap = new HashMap<>();

	public Instructions(Code code)
	{
		this.code = code;
	}

	public Label createLabelFor(Instruction target)
	{
		return createLabelFor(target, false);
	}

	public Label createLabelFor(Instruction target, boolean forceCreate)
	{
		assert target.getInstructions() == this;
		assert instructions.contains(target);

		if (target instanceof Label)
		{
			return (Label) target;
		}

		int i = instructions.indexOf(target);
		if (i > 0)
		{
			Instruction before = instructions.get(i - 1);

			if (!forceCreate && before instanceof Label)
			{
				return (Label) before;
			}
		}

		Label label = new Label(this);
		label.setLabel(new org.objectweb.asm.Label());
		instructions.add(i, label);
		labelMap.put(label.getLabel(), label);
		return label;
	}

	public Label findLabel(org.objectweb.asm.Label l)
	{
		Label label = labelMap.get(l);
		assert label != null;
		return label;
	}

	public Label findOrCreateLabel(org.objectweb.asm.Label l)
	{
		Label label = labelMap.get(l);
		if (label != null)
		{
			return label;
		}

		label = new Label(this, l);
		labelMap.put(l, label);

		return label;
	}

	public void rebuildLabels()
	{
		labelMap.clear();

		// ow2 asm requires new Labels each time you write out a class
		// with ClassWriter, or else it crytpically fails
		for (Instruction i : instructions)
		{
			if (i instanceof Label)
			{
				org.objectweb.asm.Label label = new org.objectweb.asm.Label();
				((Label) i).setLabel(label);

				labelMap.put(label, (Label) i);
			}
		}
	}

	public List<Instruction> getInstructions()
	{
		return instructions;
	}

	public void addInstruction(Instruction i)
	{
		assert i.getInstructions() == this;
		instructions.add(i);
	}

	public void addInstruction(int idx, Instruction i)
	{
		assert i.getInstructions() == this;
		instructions.add(idx, i);
	}

	public void remove(Instruction ins)
	{
		assert ins.getInstructions() == this;
		ins.remove();
		instructions.remove(ins);
		ins.setInstructions(null);
	}

	public void clear()
	{
		for (Instruction ins : instructions)
		{
			ins.remove();
			ins.setInstructions(null);
		}
		instructions.clear();
	}

	public Code getCode()
	{
		return code;
	}

	public void lookup()
	{
		for (Instruction i : instructions)
		{
			i.lookup();
		}
	}

	public void regeneratePool()
	{
		for (Instruction i : instructions)
		{
			i.regeneratePool();
		}
	}

	public int replace(Instruction oldi, Instruction newi)
	{
		assert oldi != newi;

		assert oldi.getInstructions() == this;
		assert newi.getInstructions() == this;

		assert instructions.contains(oldi);
		assert !instructions.contains(newi);

		int i = instructions.indexOf(oldi);
		instructions.remove(oldi);
		oldi.setInstructions(null);
		instructions.add(i, newi);

		return i;
	}
}
