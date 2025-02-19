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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instruction;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
class ScriptWriter extends rs2asmBaseListener
{
	private static final Logger logger = LoggerFactory.getLogger(ScriptWriter.class);

	private final Instructions instructions;
	private final LabelVisitor labelVisitor;
	private final Map<String, Object> symbols;

	private int id;
	private int pos;
	private int intStackCount;
	private int stringStackCount;
	private int localIntCount;
	private int localStringCount;
	private List<Integer> opcodes = new ArrayList<>();
	private List<Integer> iops = new ArrayList<>();
	private List<String> sops = new ArrayList<>();
	private List<LookupSwitch> switches = new ArrayList<>();

	@Override
	public void enterId_value(rs2asmParser.Id_valueContext ctx)
	{
		int value = Integer.parseInt(ctx.getText());
		id = value;
	}

	@Override
	public void enterInt_stack_value(rs2asmParser.Int_stack_valueContext ctx)
	{
		int value = Integer.parseInt(ctx.getText());
		intStackCount = value;
	}

	@Override
	public void enterString_stack_value(rs2asmParser.String_stack_valueContext ctx)
	{
		int value = Integer.parseInt(ctx.getText());
		stringStackCount = value;
	}

	@Override
	public void enterInt_var_value(rs2asmParser.Int_var_valueContext ctx)
	{
		int value = Integer.parseInt(ctx.getText());
		localIntCount = value;
	}

	@Override
	public void enterString_var_value(rs2asmParser.String_var_valueContext ctx)
	{
		int value = Integer.parseInt(ctx.getText());
		localStringCount = value;
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
		Instruction i = instructions.find(text);
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
		assert switches.size() == pos;

		opcodes.add(opcode);
		iops.add(null);
		sops.add(null);
		switches.add(null);
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

	@Override
	public void enterOperand_symbol(rs2asmParser.Operand_symbolContext ctx)
	{
		String symbolName = ctx.getText().substring(1);
		Object symbol = symbols.get(symbolName);
		if (symbol == null)
		{
			throw new RuntimeException("unknown symbol " + symbolName);
		}

		if (!(symbol instanceof Integer))
		{
			throw new RuntimeException("non-integer symbols not supported");
		}

		iops.set(pos, (int) symbol);
	}

	@Override
	public void enterSwitch_lookup(rs2asmParser.Switch_lookupContext ctx)
	{
		if (switches.get(pos - 1) != null)
		{
			return;
		}

		LookupSwitch ls = new LookupSwitch();
		switches.set(pos - 1, ls);
	}

	@Override
	public void exitSwitch_key(rs2asmParser.Switch_keyContext ctx)
	{
		String text = ctx.getText();
		int key = Integer.parseInt(text);

		LookupSwitch ls = switches.get(pos - 1);
		assert ls != null;

		LookupCase scase = new LookupCase();
		scase.setValue(key);

		ls.getCases().add(scase);
	}

	@Override
	public void exitSwitch_value(rs2asmParser.Switch_valueContext ctx)
	{
		String text = ctx.getText();
		Integer instruction = labelVisitor.getInstructionForLabel(text);
		if (instruction == null)
		{
			throw new RuntimeException("reference to unknown label " + text);
		}

		int target = instruction // target instruction index
			- (pos - 1) // pos is already at the instruction after the switch, so - 1
			- 1; // to go to the instruction prior to target

		LookupSwitch ls = switches.get(pos - 1);
		assert ls != null;

		LookupCase scase = ls.getCases().get(ls.getCases().size() - 1);
		scase.setOffset(target);
	}

	public ScriptDefinition buildScript()
	{
		setSwitchOperands();

		ScriptDefinition script = new ScriptDefinition();
		script.setId(id);
		script.setIntStackCount(intStackCount);
		script.setStringStackCount(stringStackCount);
		script.setLocalIntCount(localIntCount);
		script.setLocalStringCount(localStringCount);
		script.setInstructions(opcodes.stream().mapToInt(Integer::valueOf).toArray());
		script.setIntOperands(iops.stream()
			.map(i -> i == null ? 0 : i)
			.mapToInt(Integer::valueOf)
			.toArray());
		script.setStringOperands(sops.toArray(new String[0]));
		script.setSwitches(buildSwitches());
		return script;
	}

	private void setSwitchOperands()
	{
		int count = 0;
		for (int i = 0; i < opcodes.size(); ++i)
		{
			if (opcodes.get(i) != Opcodes.SWITCH)
			{
				continue;
			}

			iops.set(i, count++);
		}
	}

	private Map<Integer, Integer>[] buildSwitches()
	{
		int count = (int) switches.stream().filter(Objects::nonNull).count();

		if (count == 0)
		{
			return null;
		}

		int index = 0;
		Map<Integer, Integer>[] maps = new Map[count];
		for (LookupSwitch lswitch : switches)
		{
			if (lswitch == null)
			{
				continue;
			}

			Map<Integer, Integer> map = maps[index++] = new LinkedHashMap<>();

			for (LookupCase scase : lswitch.getCases())
			{
				map.put(scase.getValue(), scase.getOffset());
			}
		}
		return maps;
	}
}
