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

import net.runelite.asm.attributes.code.instructions.NOP;
import org.objectweb.asm.MethodVisitor;

public class Label extends NOP
{
	private org.objectweb.asm.Label label;
	private Integer lineNumber;

	public Label(Instructions instructions)
	{
		super(instructions);
	}

	public Label(Instructions instructions, org.objectweb.asm.Label label)
	{
		super(instructions);
		this.label = label;
	}

	@Override
	public String toString()
	{
		String string;

		if (this.getInstructions() == null)
		{
			string = "label <unattached>";
		}
		else
		{
			Instruction next = next();

			if (next == null)
			{
				string = "label with no next instruction";
			}
			else
			{
				string = "label " + next.toString();
			}
		}

		if (lineNumber != null)
		{
			string += " on line number " + lineNumber;
		}

		return string;
	}

	@Override
	public Instruction clone()
	{
		Label l = (Label) super.clone();
		l.label = new org.objectweb.asm.Label();
		l.lineNumber = lineNumber;
		return l;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitLabel(label);

		if (lineNumber != null)
		{
			visitor.visitLineNumber(lineNumber, label);
		}
	}

	public org.objectweb.asm.Label getLabel()
	{
		return label;
	}

	public void setLabel(org.objectweb.asm.Label label)
	{
		this.label = label;
	}

	public void setLineNumber(Integer lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	public Integer getLineNumber()
	{
		return this.lineNumber;
	}

	public Instruction next()
	{
		Instructions ins = this.getInstructions();
		int i = ins.getInstructions().indexOf(this);
		assert i != -1;

		Instruction next;
		do
		{
			next = ins.getInstructions().get(i + 1);
			++i;
		}
		while (next instanceof Label);

		return next;
	}
}
