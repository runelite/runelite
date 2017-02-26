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
package net.runelite.cache.script;

import java.util.HashMap;
import java.util.Map;

public class Instructions
{
	private static Map<Integer, Instruction> instructions = new HashMap<>();

	public static void init()
	{
		add(Opcodes.LOAD_INT, 0, 1);
		add(Opcodes.GET_SETTINGS, 0, 1);
		add(Opcodes.PUT_SETTINGS, 0, 1);
		add(Opcodes.LOAD_STRING, 0, 0, 0, 1);
		add(Opcodes.JUMP, 0, 0);
		add(Opcodes.IF_ICMPNE, 2, 0);
		add(Opcodes.IF_ICMPEQ, 2, 0);
		add(Opcodes.IF_ICMPLT, 2, 0);
		add(Opcodes.IF_ICMPGT, 2, 0);
		add(Opcodes.RETURN, 0, 0);
		add(25, 0, 1);
		add(27, 1, 0);
		add(Opcodes.IF_ICMPLE, 2, 0);
		add(Opcodes.IF_ICMPGE, 2, 0);
		add(33, 0, 1);
		add(34, 1, 0);
		add(35, 0, 0, 0, 1);
		add(36, 0, 0, 1, 0);
		// 37 - pops strings eq to int operand, pushes 1 string
		add(Opcodes.POP_INT, 1, 0);
		add(Opcodes.POP_STRING, 0, 0, 1, 0);
		// 40 seems to interact with other scripts, variable pops/pushes
		add(42, 0, 1);
		add(43, 1, 0);
		add(44, 1, 0);
		add(45, 1, 1);
		add(46, 2, 0);
		add(47, 0, 0, 0, 1);
		add(48, 0, 0, 1, 0);
		add(100, 3, 0);
		add(101, 0, 0);
		add(102, 1, 0);
		add(200, 2, 1);
		add(201, 1, 1);
		// 2000-2100 are the same as 1000-1100, but
		// pop an additional int which is used to get the current widget
		add(1000, 4, 0);
		add(1001, 4, 0);
		add(Opcodes.WIDGET_PUT_HIDDEN, 1, 0);
		add(1005, 1, 0);
		add(1006, 1, 0);
		// 2100-2200 and 1100-1200 do the same thing
		add(Opcodes.WIDGET_PUT_SCROLL, 2, 0);
		add(Opcodes.WIDGET_PUT_TEXTCOLOR, 1, 0);
		add(1102, 1, 0);
		add(Opcodes.WIDGET_PUT_OPACITY, 1, 0);
		add(1104, 1, 0);
		add(Opcodes.WIDGET_PUT_TEXTUREID, 1, 0);
		add(1106, 1, 0);
		add(1107, 1, 0);
		add(Opcodes.WIDGET_PUT_MODELID_1, 1, 0);
		add(1109, 6, 0);
		add(1110, 1, 0);
		add(1111, 1, 0);
		add(1112, 0, 0, 1, 0);
		add(Opcodes.WIDGET_PUT_FONTID, 1, 0);
		add(1114, 3, 0);
		add(1115, 1, 0);
		add(Opcodes.WIDGET_PUT_BORDERTHICKNESS, 1, 0);
		add(1117, 1, 0);
		add(Opcodes.WIDGET_PUT_FLIPPEDVERTICALLY, 1, 0);
		add(Opcodes.WIDGET_PUT_FLIPPEDHORIZONALLY, 1, 0);
		add(Opcodes.WIDGET_PUT_SCROLLWIDTHHEIGHT, 2, 0);
		add(1121, 0, 0);
		add(1122, 1, 0);
		add(1123, 1, 0);
		add(1124, 1, 0);
		add(1125, 1, 0);
		// and 1200-1300 and 2200-2300
		add(Opcodes.WIDGET_PUT_MODELID_2, 1, 0);
		add(Opcodes.WIDGET_PUT_MODELID_3, 0, 0);
		add(1200, 2, 0);
		add(1205, 2, 0);
		add(1212, 2, 0);
		// and 1300-1400 and 2300-2400
		add(1300, 1, 0, 1, 0);
		add(1301, 2, 0);
		add(1302, 1, 0);
		add(1303, 1, 0);
		add(1304, 1, 0);
		add(Opcodes.WIDGET_PUT_NAME, 0, 0, 1, 0);
		add(1306, 0, 0, 1, 0);
		add(Opcodes.WIDGET_PUT_ACTIONS_NULL, 0, 0);
		// and 1400-1500 and 2400-2500
		// and 1500-1600 and 2500-2600
		add(Opcodes.WIDGET_GET_RELATIVEX, 0, 1);
		add(Opcodes.WIDGET_GET_RELATIVEY, 0, 1);
		add(Opcodes.WIDGET_GET_WIDTH, 0, 1);
		add(Opcodes.WIDGET_GET_HEIGHT, 0, 1);
		add(Opcodes.WIDGET_GET_HIDDEN, 0, 1);
		add(Opcodes.WIDGET_GET_PARENTID, 0, 1);
		// and 1600-1700 and 2600-2700
		add(Opcodes.WIDGET_GET_SCROLLX, 0, 1);
		add(Opcodes.WIDGET_GET_SCROLLY, 0, 1);
		add(Opcodes.WIDGET_GET_TEXT, 0, 0, 0, 1);
		add(Opcodes.WIDGET_GET_SCROLLWIDTH, 0, 1);
		add(Opcodes.WIDGET_GET_SCROLLHEIGHT, 0, 1);
		add(1605, 0, 1);
		add(Opcodes.WIDGET_GET_ROTATIONX, 0, 1);
		add(Opcodes.WIDGET_GET_ROTATIONY, 0, 1);
		add(Opcodes.WIDGET_GET_ROTATIONZ, 0, 1);
		add(Opcodes.WIDGET_GET_OPACITY, 0, 1);
		add(1610, 0, 1);
		add(Opcodes.WIDGET_GET_TEXTCOLOR, 0, 1);
		add(1612, 0, 1);
		add(1613, 0, 1);
		// 1700
		add(Opcodes.WIDGET_GET_ITEMID, 0, 1);
		add(Opcodes.WIDGET_GET_STACKSIZE, 0, 1);
		add(1702, 0, 1);
		add(1800, 0, 1);
		add(1801, 1, 0, 0, 1);
		add(Opcodes.WIDGET_GET_NAME, 0, 0, 0, 1);
		// and 1900-2000 and 2900-3000
		add(1927, 0, 0);
		// 2000-2100
		add(2000, 5, 0);
		add(2001, 5, 0);
		add(Opcodes.WIDGET_PUT_HIDDEN_WIDGET, 2, 0);
		add(2005, 2, 0);
		add(2006, 2, 0);
		// 2100-2200
		add(Opcodes.WIDGET_PUT_SCROLL_WIDGET, 3, 0);
		add(Opcodes.WIDGET_PUT_TEXTCOLOR_WIDGET, 2, 0);
		add(2102, 2, 0);
		add(Opcodes.WIDGET_PUT_OPACITY_WIDGET, 2, 0);
		add(2104, 2, 0);
		add(Opcodes.WIDGET_PUT_TEXTUREID_WIDGET, 2, 0);
		add(2106, 2, 0);
		add(2107, 2, 0);
		add(Opcodes.WIDGET_PUT_MODELID_1_WIDGET, 2, 0);
		add(2109, 7, 0);
		add(2110, 2, 0);
		add(2111, 2, 0);
		add(2112, 1, 0, 1, 0);
		add(Opcodes.WIDGET_PUT_FONTID_WIDGET, 2, 0);
		add(2114, 4, 0);
		add(2115, 2, 0);
		add(Opcodes.WIDGET_PUT_BORDERTHICKNESS_WIDGET, 2, 0);
		add(2117, 2, 0);
		add(Opcodes.WIDGET_PUT_FLIPPEDVERTICALLY_WIDGET, 2, 0);
		add(Opcodes.WIDGET_PUT_FLIPPEDHORIZONALLY_WIDGET, 2, 0);
		add(Opcodes.WIDGET_PUT_SCROLLWIDTHHEIGHT_WIDGET, 3, 0);
		add(2121, 1, 0);
		add(2122, 2, 0);
		add(2123, 2, 0);
		add(2124, 2, 0);
		add(2125, 2, 0);
		// 2200-2300
		add(Opcodes.WIDGET_PUT_MODELID_2_WIDGET, 2, 0);
		add(Opcodes.WIDGET_PUT_MODELID_3_WIDGET, 1, 0);
		add(2200, 3, 0);
		add(2205, 3, 0);
		add(2212, 3, 0);
		// 2300-2400
		add(2300, 2, 0, 1, 0);
		add(2301, 3, 0);
		add(2302, 2, 0);
		add(2303, 2, 0);
		add(2304, 2, 0);
		add(Opcodes.WIDGET_PUT_NAME_WIDGET, 1, 0, 1, 0);
		add(2306, 1, 0, 1, 0);
		add(Opcodes.WIDGET_PUT_ACTIONS_NULL_WIDGET, 1, 0);
		// 2400-2500
		// 2500-2600
		add(Opcodes.WIDGET_GET_RELATIVEX_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_RELATIVEY_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_WIDTH_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_HEIGHT_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_HIDDEN_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_PARENTID_WIDGET, 1, 1);
		// 2600-2700
		add(Opcodes.WIDGET_GET_SCROLLX_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_SCROLLY_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_TEXT_WIDGET, 1, 0, 0, 1);
		add(Opcodes.WIDGET_GET_SCROLLWIDTH_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_SCROLLHEIGHT_WIDGET, 1, 1);
		add(2605, 1, 1);
		add(Opcodes.WIDGET_GET_ROTATIONX_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_ROTATIONY_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_ROTATIONZ_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_OPACITY_WIDGET, 1, 1);
		add(2610, 1, 1);
		add(Opcodes.WIDGET_GET_TEXTCOLOR_WIDGET, 1, 1);
		add(2612, 1, 1);
		add(2613, 1, 1);
		// 2700-2800
		add(Opcodes.WIDGET_GET_ITEMID_WIDGET, 1, 1);
		add(Opcodes.WIDGET_GET_STACKSIZE_WIDGET, 1, 1);
		add(2702, 1, 1);
		add(2706, 0, 1);
		// 2800-2900
		add(2800, 1, 1);
		add(2801, 2, 0, 0, 1);
		add(Opcodes.WIDGET_GET_NAME_WIDGET, 1, 0, 0, 1);
		// 2900-3000
		add(2927, 1, 0);
		// 3000-3200
		add(Opcodes.SEND_GAME_MESSAGE, 0, 0, 1, 0);
		add(3101, 2, 0);
		add(3103, 0, 0);
		add(3104, 0, 0, 1, 0);
		add(3105, 0, 0, 1, 0);
		add(3106, 0, 0, 1, 0);
		add(3107, 1, 0, 1, 0);
		add(3108, 3, 0);
		add(3109, 2, 0);
		add(3110, 1, 0);
		add(3111, 0, 1);
		add(3112, 1, 0);
		add(3113, 1, 0, 1, 0);
		add(3115, 1, 0);
		add(3116, 1, 0, 2, 0);
		add(3117, 1, 0);
		// 3200-3300
		add(3200, 3, 0);
		add(3201, 1, 0);
		add(3202, 2, 0);
		// 3300-3400
		add(Opcodes.GET_GAMECYCLE, 0, 1);
		add(3301, 2, 0);
		add(3302, 2, 1);
		add(3303, 2, 1);
		add(3304, 1, 1);
		add(Opcodes.GET_BOOSTEDSKILLLEVELS, 1, 1);
		add(Opcodes.GET_REALSKILLLEVELS, 1, 1);
		add(Opcodes.GET_SKILLEXPERIENCES, 1, 1);
		add(Opcodes.GET_COORDINATES, 0, 1);
		add(Opcodes.DIVIDE_BY_16384, 1, 1);
		add(Opcodes.RIGHT_SHIFT_28, 1, 1);
		add(Opcodes.AND_16384, 1, 1);
		add(Opcodes.GET_ISMEMBERS, 0, 1);
		add(3313, 2, 1);
		add(3314, 2, 1);
		add(3315, 2, 1);
		add(3316, 0, 1);
		add(3317, 0, 1);
		add(Opcodes.GET_WORLD, 0, 1);
		add(Opcodes.GET_ENERGY, 0, 1);
		add(Opcodes.GET_WEIGHT, 0, 1);
		add(3323, 0, 1);
		add(Opcodes.GET_FLAGS, 0, 1);
		// 3400-3500
		add(3400, 2, 0, 0, 1);
		// 3408 is variable
		// 3500-3700
		add(Opcodes.GET_FRIENDCOUNT, 0, 1);
		add(Opcodes.GET_FRIEND, 1, 0, 0, 2);
		add(Opcodes.GET_FRIEND_WORLD, 1, 1);
		add(Opcodes.GET_FRIEND_RANK, 1, 1);
		add(3604, 1, 0, 1, 0);
		add(Opcodes.ADD_FRIEND, 0, 0, 1, 0);
		add(Opcodes.REMOVE_FRIEND, 0, 0, 1, 0);
		add(Opcodes.ADD_IGNORE, 0, 0, 1, 0);
		add(Opcodes.REMOVE_IGNORE, 0, 0, 1, 0);
		add(3609, 0, 1, 1, 0);
		add(3611, 0, 0, 0, 1);
		add(Opcodes.GET_CLANCHATCOUNT, 0, 1);
		add(Opcodes.GET_CLAN_MEMBER_NAME, 1, 0, 0, 1);
		add(Opcodes.GET_CLAN_MEMBER_WORLD, 1, 1);
		add(Opcodes.GET_CLAN_MEMBER_RANK, 1, 1);
		add(3616, 0, 1);
		add(3617, 0, 0, 1, 0);
		add(3618, 0, 1);
		add(3619, 0, 0, 1, 0);
		add(3620, 0, 0);
		add(Opcodes.GET_IGNORECOUNT, 0, 1);
		add(Opcodes.GET_IGNORE, 1, 0, 0, 2);
		add(3623, 0, 1, 1, 0);
		add(Opcodes.CLANMEMBER_ISME, 1, 1);
		add(Opcodes.GET_CLANCHATOWNER, 0, 0, 0, 1);
		// 3700-4000
		add(3903, 1, 1);
		add(Opcodes.GET_GRANDEXCHANGE_OFFER_ITEMID, 1, 1);
		add(Opcodes.GET_GRANDEXCHANGE_OFFER_PRICE, 1, 1);
		add(Opcodes.GET_GRANDEXCHANGE_OFFER_TOTALQUANTITY, 1, 1);
		add(Opcodes.GET_GRANDEXCHANGE_OFFER_QUANTITYSOLD, 1, 1);
		add(Opcodes.GET_GRANDEXCHANGE_OFFER_SPENT, 1, 1);
		add(3910, 1, 1);
		add(3911, 1, 1);
		add(3912, 1, 1);
		add(3913, 1, 1);
		add(3914, 1, 0);
		add(3915, 1, 0);
		add(3916, 2, 0);
		add(3917, 1, 0);
		add(3918, 1, 0);
		add(3919, 0, 1);
		add(3920, 1, 1);
		add(3921, 1, 0, 0, 1);
		add(3922, 1, 0, 0, 1);
		add(3923, 1, 0, 0, 1);
		add(3924, 1, 1);
		add(3925, 1, 1);
		add(3926, 1, 1);
		// 4000-4100
		add(Opcodes.IADD, 2, 1);
		add(Opcodes.ISUB, 2, 1);
		add(Opcodes.IMUL, 2, 1);
		add(Opcodes.IDIV, 2, 1);
		add(Opcodes.RAND_EXCL, 1, 1);
		add(Opcodes.RAND_INCL, 1, 1);
		add(4006, 5, 1);
		add(4007, 2, 1);
		add(Opcodes.SET_BIT, 2, 1);
		add(Opcodes.CLEAR_BIT, 2, 1);
		add(Opcodes.TEST_BIT, 2, 1);
		add(Opcodes.MODULO, 2, 1);
		add(Opcodes.POW, 2, 1);
		add(4013, 2, 1);
		add(Opcodes.AND, 2, 1);
		add(Opcodes.OR, 2, 1);
		add(4018, 3, 1);
		// 4100-4200
		add(Opcodes.CONCAT_INT, 1, 0, 1, 1);
		add(Opcodes.CONCAT_STRING, 0, 0, 2, 1);
		add(4102, 1, 0, 1, 1);
		add(Opcodes.TOLOWERCASE, 0, 0, 1, 1);
		add(Opcodes.FORMAT_DATE, 1, 0, 0, 1);
		add(Opcodes.SWITCH_MALE_OR_FEMALE, 0, 0, 2, 1);
		add(Opcodes.INT_TO_STRING, 1, 0, 0, 1);
		add(4107, 0, 1, 2, 0);
		add(4108, 2, 1, 1, 0);
		add(4109, 2, 1, 1, 0);
		add(Opcodes.SWITCH_STRING, 1, 0, 2, 1);
		add(4111, 0, 0, 1, 1);
		add(Opcodes.CONCAT_CHAR, 1, 0, 1, 1);
		add(Opcodes.CHAR_IS_PRINTABLE, 1, 1);
		add(4114, 1, 1);
		add(4115, 1, 1);
		add(4116, 1, 1);
		add(Opcodes.STRING_LENGTH, 0, 1, 1, 0);
		add(Opcodes.STRING_SUBSTRING, 2, 0, 1, 1);
		add(Opcodes.STRING_REMOVE_HTML, 0, 0, 1, 1);
		add(Opcodes.STRING_INDEXOF, 1, 1, 1, 0);
		add(Opcodes.STRING_INDEXOF_FROM, 1, 1, 2, 0);
		// 4200-4300
		add(Opcodes.GET_ITEM_NAME, 1, 0, 0, 1);
		add(Opcodes.GET_ITEM_GROUND_ACTION, 2, 0, 0, 1);
		add(Opcodes.GET_ITEM_INVENTORY_ACTION, 2, 0, 0, 1);
		add(Opcodes.GET_ITEM_PRICE, 1, 1);
		add(Opcodes.GET_ITEM_STACKABLE, 1, 1);
		add(Opcodes.GET_ITEM_NOTE_1, 1, 1);
		add(Opcodes.GET_ITEM_NOTE_2, 1, 1);
		add(Opcodes.GET_ITEM_ISMEMBERS, 1, 1);
		add(4208, 1, 1);
		add(4209, 1, 1);
		add(4210, 1, 1, 1, 0);
		add(4211, 0, 1);
		add(4212, 0, 0);
		// 4300-5100
		add(5000, 0, 1);
		add(5001, 3, 0);
		add(5002, 2, 0, 1, 0);
		add(5003, 2, 2, 0, 3);
		add(5004, 1, 2, 0, 3);
		add(5005, 0, 1);
		add(5008, 1, 0, 1, 0);
		add(5009, 0, 0, 2, 0);
		add(Opcodes.GET_LOCALPLAYER_NAME, 0, 0, 0, 1);
		add(5016, 0, 1);
		add(5017, 1, 1);
		add(5018, 1, 1);
		add(5019, 1, 1);
		add(5020, 0, 0, 1, 0);
		add(5021, 0, 0, 1, 0);
		add(5022, 0, 0, 0, 1);
		// 5100-5400
		add(Opcodes.GET_ISRESIZED, 0, 1);
		add(Opcodes.SET_ISRESIZED, 1, 0);
		add(5308, 0, 1);
		add(5308, 1, 0);
		// 5400-5600
		add(5504, 2, 0);
		add(5505, 0, 1);
		add(5506, 0, 1);
		add(5530, 1, 0);
		add(5531, 0, 1);
		// 5600-5700
		add(5630, 0, 0);
		// 5700-6300
		add(6200, 2, 0);
		add(6201, 2, 0);
		add(6202, 4, 0);
		add(6203, 0, 2);
		add(6204, 0, 2);
		add(6205, 0, 2);
		// 6300-6600
		add(Opcodes.LOAD_WORLDS, 0, 1);
		add(6501, 0, 4, 0, 2);
		add(6502, 0, 4, 0, 2);
		add(Opcodes.GET_WORLD_BY_ID, 1, 4, 0, 2);
		add(6507, 4, 0);
		add(Opcodes.GET_WORLD_BY_INDEX, 1, 4, 0, 2);
		add(6512, 1, 0);
	}

	private static void add(int opcode, int ipops, int ipushes, int spops, int spushes)
	{
		Instruction i = new Instruction(opcode);
		i.setIntStackPops(ipops);
		i.setIntStackPushes(ipushes);
		i.setStringStackPops(spops);
		i.setStringStackPushes(spushes);

		assert instructions.containsKey(opcode) == false;
		instructions.put(opcode, i);
	}

	private static void add(int opcode, int ipops, int ipushes)
	{
		add(opcode, ipops, ipushes, 0, 0);
	}
}
