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
grammar rs2asm;

prog: NEWLINE* (header NEWLINE+)* (line NEWLINE+)+ ;

header: id | int_stack_count | string_stack_count | int_var_count | string_var_count ;

id: '.id ' id_value ;
int_stack_count: '.int_stack_count ' int_stack_value ;
string_stack_count: '.string_stack_count ' string_stack_value ;
int_var_count: '.int_var_count ' int_var_value ;
string_var_count: '.string_var_count ' string_var_value ;

id_value: INT ;
int_stack_value: INT ;
string_stack_value: INT ;
int_var_value: INT ;
string_var_value: INT ;

line: instruction | label | switch_lookup ;
instruction: instruction_name instruction_operand ;
label: IDENTIFIER ':' ;

instruction_name: name_string | name_opcode ;
name_string: IDENTIFIER ;
name_opcode: INT ;

instruction_operand: operand_int | operand_qstring | operand_label | ;
operand_int: INT ;
operand_qstring: QSTRING ;
operand_label: IDENTIFIER ;

switch_lookup: switch_key ':' switch_value ;
switch_key: INT ;
switch_value: IDENTIFIER ;

NEWLINE: ( '\r' | '\n' )+ ;
INT: '-'? [0-9]+ ;
QSTRING: '"' (~('"' | '\\' | '\r' | '\n') | '\\' ('"' | '\\'))* '"' ;
IDENTIFIER: [a-zA-Z0-9_]+ ;
COMMENT: ';' ~( '\r' | '\n' )* -> channel(HIDDEN) ;

WS: (' ' | '\t')+ -> channel(HIDDEN) ;