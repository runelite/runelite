/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.script.assembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instruction;
import net.runelite.cache.script.Instructions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptWriter extends rs2asmBaseListener
{
	private static final Logger logger = LoggerFactory.getLogger(ScriptWriter.class);

	private final LabelVisitor labelVisitor;

	private int pos;
	private List<Integer> opcodes = new ArrayList<>();
	private List<Integer> iops = new ArrayList<>();
	private List<String> sops = new ArrayList<>();
	private List<Attribute> attrs = new ArrayList<>();

	public ScriptWriter(LabelVisitor labelVisitor)
	{
		this.labelVisitor = labelVisitor;
	}

	@Override
	public void exitAttr_idx(rs2asmParser.Attr_idxContext ctx)
	{
		String text = ctx.getText();
		int idx = Integer.parseInt(text);

		Attribute attr = new Attribute();
		attr.setIdx(idx);

		attrs.add(attr);
	}

	@Override
	public void exitAttr_key(rs2asmParser.Attr_keyContext ctx)
	{
		String text = ctx.getText();
		int key = Integer.parseInt(text);

		Attribute attr = attrs.get(attrs.size() - 1);
		attr.setKey(key);
	}

	@Override
	public void exitAttr_value(rs2asmParser.Attr_valueContext ctx)
	{
		String text = ctx.getText();
		int value = Integer.parseInt(text);

		Attribute attr = attrs.get(attrs.size() - 1);
		attr.setValue(value);
	}

	@Override
	public void exitInstruction(rs2asmParser.InstructionContext ctx)
	{
		++pos;
	}

	@Override
	public void enterName_string(rs2asmParser.Name_stringContext ctx)
	{
		String text = ctx.getText();
		Instruction i = Instructions.find(text);
		if (i == null)
		{
			logger.warn("Unknown instruction {}", text);
			throw new RuntimeException("Unknown instruction " + text);
		}

		int opcode = i.getOpcode();
		addOpcode(opcode);
	}

	@Override
	public void enterName_opcode(rs2asmParser.Name_opcodeContext ctx)
	{
		String text = ctx.getText();
		int opcode = Integer.parseInt(text);
		addOpcode(opcode);
	}

	private void addOpcode(int opcode)
	{
		assert opcodes.size() == pos;
		assert iops.size() == pos;
		assert sops.size() == pos;

		opcodes.add(opcode);
		iops.add(null);
		sops.add(null);
	}

	@Override
	public void enterOperand_int(rs2asmParser.Operand_intContext ctx)
	{
		String text = ctx.getText();
		int value = Integer.parseInt(text);
		iops.set(pos, value);
	}

	@Override
	public void enterOperand_qstring(rs2asmParser.Operand_qstringContext ctx)
	{
		String text = ctx.getText();
		text = text.substring(1, text.length() - 1);
		sops.set(pos, text);
	}

	@Override
	public void enterOperand_label(rs2asmParser.Operand_labelContext ctx)
	{
		String text = ctx.getText();
		Integer instruction = labelVisitor.getInstructionForLabel(text);
		if (instruction == null)
		{
			throw new RuntimeException("reference to unknown label " + text);
		}

		int target = instruction - pos - 1; // -1 to go to the instruction prior
		iops.set(pos, target);
	}

	public ScriptDefinition buildScript()
	{
		ScriptDefinition script = new ScriptDefinition();
		script.setInstructions(opcodes.stream().mapToInt(Integer::valueOf).toArray());
		script.setIntOperands(iops.stream()
			.map(i -> i == null ? 0 : i)
			.mapToInt(Integer::valueOf)
			.toArray());
		script.setStringOperands(sops.toArray(new String[0]));
		script.setAttributes(buildAttributes());
		return script;
	}

	private Map<Integer, Integer>[] buildAttributes()
	{
		if (attrs == null || attrs.isEmpty())
		{
			return null;
		}

		Map<Integer, Integer>[] maps = new Map[attrs.stream().map(attr -> attr.getIdx()).max(Integer::compare).get() + 1];
		for (Attribute attr : attrs)
		{
			Map<Integer, Integer> map = maps[attr.getIdx()];
			if (map == null)
			{
				map = new HashMap<>();
				maps[attr.getIdx()] = map;
			}

			map.put(attr.getKey(), attr.getValue());
		}
		return maps;
	}
}
