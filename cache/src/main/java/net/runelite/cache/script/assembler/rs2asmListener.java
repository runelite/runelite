// Generated from net\runelite\cache\script\assembler\rs2asm.g4 by ANTLR 4.6
package net.runelite.cache.script.assembler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link rs2asmParser}.
 */
public interface rs2asmListener extends ParseTreeListener
{
	/**
	 * Enter a parse tree produced by {@link rs2asmParser#prog}.
	 *
	 * @param ctx the parse tree
	 */
	void enterProg(rs2asmParser.ProgContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#prog}.
	 *
	 * @param ctx the parse tree
	 */
	void exitProg(rs2asmParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#header}.
	 *
	 * @param ctx the parse tree
	 */
	void enterHeader(rs2asmParser.HeaderContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#header}.
	 *
	 * @param ctx the parse tree
	 */
	void exitHeader(rs2asmParser.HeaderContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#id}.
	 *
	 * @param ctx the parse tree
	 */
	void enterId(rs2asmParser.IdContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#id}.
	 *
	 * @param ctx the parse tree
	 */
	void exitId(rs2asmParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#int_stack_count}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInt_stack_count(rs2asmParser.Int_stack_countContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#int_stack_count}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInt_stack_count(rs2asmParser.Int_stack_countContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#string_stack_count}.
	 *
	 * @param ctx the parse tree
	 */
	void enterString_stack_count(rs2asmParser.String_stack_countContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#string_stack_count}.
	 *
	 * @param ctx the parse tree
	 */
	void exitString_stack_count(rs2asmParser.String_stack_countContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#int_var_count}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInt_var_count(rs2asmParser.Int_var_countContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#int_var_count}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInt_var_count(rs2asmParser.Int_var_countContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#string_var_count}.
	 *
	 * @param ctx the parse tree
	 */
	void enterString_var_count(rs2asmParser.String_var_countContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#string_var_count}.
	 *
	 * @param ctx the parse tree
	 */
	void exitString_var_count(rs2asmParser.String_var_countContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#id_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterId_value(rs2asmParser.Id_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#id_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitId_value(rs2asmParser.Id_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#int_stack_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInt_stack_value(rs2asmParser.Int_stack_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#int_stack_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInt_stack_value(rs2asmParser.Int_stack_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#string_stack_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterString_stack_value(rs2asmParser.String_stack_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#string_stack_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitString_stack_value(rs2asmParser.String_stack_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#int_var_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInt_var_value(rs2asmParser.Int_var_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#int_var_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInt_var_value(rs2asmParser.Int_var_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#string_var_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterString_var_value(rs2asmParser.String_var_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#string_var_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitString_var_value(rs2asmParser.String_var_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#line}.
	 *
	 * @param ctx the parse tree
	 */
	void enterLine(rs2asmParser.LineContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#line}.
	 *
	 * @param ctx the parse tree
	 */
	void exitLine(rs2asmParser.LineContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#instruction}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInstruction(rs2asmParser.InstructionContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#instruction}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInstruction(rs2asmParser.InstructionContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#label}.
	 *
	 * @param ctx the parse tree
	 */
	void enterLabel(rs2asmParser.LabelContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#label}.
	 *
	 * @param ctx the parse tree
	 */
	void exitLabel(rs2asmParser.LabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#instruction_name}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInstruction_name(rs2asmParser.Instruction_nameContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#instruction_name}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInstruction_name(rs2asmParser.Instruction_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#name_string}.
	 *
	 * @param ctx the parse tree
	 */
	void enterName_string(rs2asmParser.Name_stringContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#name_string}.
	 *
	 * @param ctx the parse tree
	 */
	void exitName_string(rs2asmParser.Name_stringContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#name_opcode}.
	 *
	 * @param ctx the parse tree
	 */
	void enterName_opcode(rs2asmParser.Name_opcodeContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#name_opcode}.
	 *
	 * @param ctx the parse tree
	 */
	void exitName_opcode(rs2asmParser.Name_opcodeContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#instruction_operand}.
	 *
	 * @param ctx the parse tree
	 */
	void enterInstruction_operand(rs2asmParser.Instruction_operandContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#instruction_operand}.
	 *
	 * @param ctx the parse tree
	 */
	void exitInstruction_operand(rs2asmParser.Instruction_operandContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#operand_int}.
	 *
	 * @param ctx the parse tree
	 */
	void enterOperand_int(rs2asmParser.Operand_intContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#operand_int}.
	 *
	 * @param ctx the parse tree
	 */
	void exitOperand_int(rs2asmParser.Operand_intContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#operand_qstring}.
	 *
	 * @param ctx the parse tree
	 */
	void enterOperand_qstring(rs2asmParser.Operand_qstringContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#operand_qstring}.
	 *
	 * @param ctx the parse tree
	 */
	void exitOperand_qstring(rs2asmParser.Operand_qstringContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#operand_label}.
	 *
	 * @param ctx the parse tree
	 */
	void enterOperand_label(rs2asmParser.Operand_labelContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#operand_label}.
	 *
	 * @param ctx the parse tree
	 */
	void exitOperand_label(rs2asmParser.Operand_labelContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#switch_lookup}.
	 *
	 * @param ctx the parse tree
	 */
	void enterSwitch_lookup(rs2asmParser.Switch_lookupContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#switch_lookup}.
	 *
	 * @param ctx the parse tree
	 */
	void exitSwitch_lookup(rs2asmParser.Switch_lookupContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#switch_key}.
	 *
	 * @param ctx the parse tree
	 */
	void enterSwitch_key(rs2asmParser.Switch_keyContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#switch_key}.
	 *
	 * @param ctx the parse tree
	 */
	void exitSwitch_key(rs2asmParser.Switch_keyContext ctx);

	/**
	 * Enter a parse tree produced by {@link rs2asmParser#switch_value}.
	 *
	 * @param ctx the parse tree
	 */
	void enterSwitch_value(rs2asmParser.Switch_valueContext ctx);

	/**
	 * Exit a parse tree produced by {@link rs2asmParser#switch_value}.
	 *
	 * @param ctx the parse tree
	 */
	void exitSwitch_value(rs2asmParser.Switch_valueContext ctx);
}