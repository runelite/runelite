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

public class Opcodes
{
	public static final int LOAD_INT = 0;
	public static final int GET_SETTINGS = 1;
	public static final int PUT_SETTINGS = 2;
	public static final int LOAD_STRING = 3;
	public static final int JUMP = 6;
	public static final int IF_ICMPNE = 7;
	public static final int IF_ICMPEQ = 8;
	public static final int IF_ICMPLT = 9;
	public static final int IF_ICMPGT = 10;
	public static final int RETURN = 21;
	public static final int IF_ICMPLE = 31;
	public static final int IF_ICMPGE = 32;
	public static final int POP_INT = 38;
	public static final int POP_STRING = 39;
	//public static final int INVOKE = 40;
	public static final int WIDGET_PUT_HIDDEN = 1003;
	public static final int WIDGET_PUT_SCROLL = 1100;
	public static final int WIDGET_PUT_TEXTCOLOR = 1101;
	public static final int WIDGET_PUT_OPACITY = 1103;
	public static final int WIDGET_PUT_TEXTUREID = 1105;
	public static final int WIDGET_PUT_MODELID_1 = 1108;
	public static final int WIDGET_PUT_FONTID = 1113;
	public static final int WIDGET_PUT_BORDERTHICKNESS = 1116;
	public static final int WIDGET_PUT_FLIPPEDVERTICALLY = 1118;
	public static final int WIDGET_PUT_FLIPPEDHORIZONALLY = 1119;
	public static final int WIDGET_PUT_SCROLLWIDTHHEIGHT = 1120;
	public static final int WIDGET_PUT_MODELID_2 = 1201;
	public static final int WIDGET_PUT_MODELID_3 = 1202;
	public static final int WIDGET_PUT_NAME = 1305;
	public static final int WIDGET_PUT_ACTIONS_NULL = 1307;
	public static final int WIDGET_GET_RELATIVEX = 1500;
	public static final int WIDGET_GET_RELATIVEY = 1501;
	public static final int WIDGET_GET_WIDTH = 1502;
	public static final int WIDGET_GET_HEIGHT = 1503;
	public static final int WIDGET_GET_HIDDEN = 1504;
	public static final int WIDGET_GET_PARENTID = 1505;
	public static final int WIDGET_GET_SCROLLX = 1600;
	public static final int WIDGET_GET_SCROLLY = 1601;
	public static final int WIDGET_GET_TEXT = 1602;
	public static final int WIDGET_GET_SCROLLWIDTH = 1603;
	public static final int WIDGET_GET_SCROLLHEIGHT = 1604;
	public static final int WIDGET_GET_ROTATIONX = 1606;
	public static final int WIDGET_GET_ROTATIONY = 1607;
	public static final int WIDGET_GET_ROTATIONZ = 1608;
	public static final int WIDGET_GET_OPACITY = 1609;
	public static final int WIDGET_GET_TEXTCOLOR = 1611;
	public static final int WIDGET_GET_ITEMID = 1700;
	public static final int WIDGET_GET_STACKSIZE = 1701;
	public static final int WIDGET_GET_NAME = 1802;
	public static final int WIDGET_PUT_HIDDEN_WIDGET = WIDGET_PUT_HIDDEN + 1000;
	public static final int WIDGET_PUT_SCROLL_WIDGET = WIDGET_PUT_SCROLL + 1000;
	public static final int WIDGET_PUT_TEXTCOLOR_WIDGET = WIDGET_PUT_TEXTCOLOR + 1000;
	public static final int WIDGET_PUT_OPACITY_WIDGET = WIDGET_PUT_OPACITY + 1000;
	public static final int WIDGET_PUT_TEXTUREID_WIDGET = WIDGET_PUT_TEXTUREID + 1000;
	public static final int WIDGET_PUT_MODELID_1_WIDGET = WIDGET_PUT_MODELID_1 + 1000;
	public static final int WIDGET_PUT_FONTID_WIDGET = WIDGET_PUT_FONTID + 1000;
	public static final int WIDGET_PUT_BORDERTHICKNESS_WIDGET = WIDGET_PUT_BORDERTHICKNESS + 1000;
	public static final int WIDGET_PUT_FLIPPEDVERTICALLY_WIDGET = WIDGET_PUT_FLIPPEDVERTICALLY + 1000;
	public static final int WIDGET_PUT_FLIPPEDHORIZONALLY_WIDGET = WIDGET_PUT_FLIPPEDHORIZONALLY + 1000;
	public static final int WIDGET_PUT_SCROLLWIDTHHEIGHT_WIDGET = WIDGET_PUT_SCROLLWIDTHHEIGHT + 1000;
	public static final int WIDGET_PUT_MODELID_2_WIDGET = WIDGET_PUT_MODELID_2 + 1000;
	public static final int WIDGET_PUT_MODELID_3_WIDGET = WIDGET_PUT_MODELID_3 + 1000;
	public static final int WIDGET_PUT_NAME_WIDGET = WIDGET_PUT_NAME + 1000;
	public static final int WIDGET_PUT_ACTIONS_NULL_WIDGET = WIDGET_PUT_ACTIONS_NULL + 1000;
	public static final int WIDGET_GET_RELATIVEX_WIDGET = WIDGET_GET_RELATIVEX + 1000;
	public static final int WIDGET_GET_RELATIVEY_WIDGET = WIDGET_GET_RELATIVEY + 1000;
	public static final int WIDGET_GET_WIDTH_WIDGET = WIDGET_GET_WIDTH + 1000;
	public static final int WIDGET_GET_HEIGHT_WIDGET = WIDGET_GET_HEIGHT + 1000;
	public static final int WIDGET_GET_HIDDEN_WIDGET = WIDGET_GET_HIDDEN + 1000;
	public static final int WIDGET_GET_PARENTID_WIDGET = WIDGET_GET_PARENTID + 1000;
	public static final int WIDGET_GET_SCROLLX_WIDGET = WIDGET_GET_SCROLLX + 1000;
	public static final int WIDGET_GET_SCROLLY_WIDGET = WIDGET_GET_SCROLLY + 1000;
	public static final int WIDGET_GET_TEXT_WIDGET = WIDGET_GET_TEXT + 1000;
	public static final int WIDGET_GET_SCROLLWIDTH_WIDGET = WIDGET_GET_SCROLLWIDTH + 1000;
	public static final int WIDGET_GET_SCROLLHEIGHT_WIDGET = WIDGET_GET_SCROLLHEIGHT + 1000;
	public static final int WIDGET_GET_ROTATIONX_WIDGET = WIDGET_GET_ROTATIONX + 1000;
	public static final int WIDGET_GET_ROTATIONY_WIDGET = WIDGET_GET_ROTATIONY + 1000;
	public static final int WIDGET_GET_ROTATIONZ_WIDGET = WIDGET_GET_ROTATIONZ + 1000;
	public static final int WIDGET_GET_OPACITY_WIDGET = WIDGET_GET_OPACITY + 1000;
	public static final int WIDGET_GET_TEXTCOLOR_WIDGET = WIDGET_GET_TEXTCOLOR + 1000;
	public static final int WIDGET_GET_ITEMID_WIDGET = WIDGET_GET_ITEMID + 1000;
	public static final int WIDGET_GET_STACKSIZE_WIDGET = WIDGET_GET_STACKSIZE + 1000;
	public static final int WIDGET_GET_NAME_WIDGET = WIDGET_GET_NAME + 1000;
	public static final int SEND_GAME_MESSAGE = 3100;
	public static final int GET_GAMECYCLE = 3300;
	public static final int GET_BOOSTEDSKILLLEVELS = 3305;
	public static final int GET_REALSKILLLEVELS = 3306;
	public static final int GET_SKILLEXPERIENCES = 3307;
	public static final int GET_COORDINATES = 3308;
	public static final int DIVIDE_BY_16384 = 3309;
	public static final int RIGHT_SHIFT_28 = 3310;
	public static final int AND_16384 = 3311;
	public static final int GET_ISMEMBERS = 3312;
	public static final int GET_WORLD = 3318;
	public static final int GET_ENERGY = 3321;
	public static final int GET_WEIGHT = 3322;
	public static final int GET_FLAGS = 3324;
	public static final int GET_FRIENDCOUNT = 3600;
	public static final int GET_FRIEND = 3601;
	public static final int GET_FRIEND_WORLD = 3602;
	public static final int GET_FRIEND_RANK = 3603;
	public static final int ADD_FRIEND = 3605;
	public static final int REMOVE_FRIEND = 3606;
	public static final int ADD_IGNORE = 3607;
	public static final int REMOVE_IGNORE = 3608;
	public static final int GET_CLANCHATCOUNT = 3612;
	public static final int GET_CLAN_MEMBER_NAME = 3613;
	public static final int GET_CLAN_MEMBER_WORLD = 3614;
	public static final int GET_CLAN_MEMBER_RANK = 3615;
	public static final int GET_IGNORECOUNT = 3621;
	public static final int GET_IGNORE = 3622;
	public static final int CLANMEMBER_ISME = 3624;
	public static final int GET_CLANCHATOWNER = 3625;
}
