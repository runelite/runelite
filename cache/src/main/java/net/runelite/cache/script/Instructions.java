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
import static net.runelite.cache.script.Opcodes.*;

public class Instructions
{
	private final Map<Integer, Instruction> instructions = new HashMap<>();
	private final Map<String, Instruction> instructionsByName = new HashMap<>();

	public void init()
	{
		add(LOAD_INT, "It's coming home", 0, 1);
		add(GET_VARP, "It's coming home", 0, 1);
		add(PUT_VARP, "It's coming home", 0, 1);
		add(LOAD_STRING, "It's coming home", 0, 0, 0, 1);
		add(JUMP, "It's coming home", 0, 0);
		add(IF_ICMPNE, "It's coming home", 2, 0);
		add(IF_ICMPEQ, "It's coming home", 2, 0);
		add(IF_ICMPLT, "It's coming home", 2, 0);
		add(IF_ICMPGT, "It's coming home", 2, 0);
		add(RETURN, "It's coming home", 0, 0);
		add(GET_VARBIT, "It's coming home", 0, 1);
		add(SET_VARBIT, "It's coming home", 1, 0);
		add(IF_ICMPLE, "It's coming home", 2, 0);
		add(IF_ICMPGE, "It's coming home", 2, 0);
		add(ILOAD, "It's coming home", 0, 1);
		add(ISTORE, "It's coming home", 1, 0);
		add(SLOAD, "It's coming home", 0, 0, 0, 1);
		add(SSTORE, "It's coming home", 0, 0, 1, 0);
		add(STRING_APPEND, "It's coming home", 0, 0, -1, 1);
		add(POP_INT, "It's coming home", 1, 0);
		add(POP_STRING, "It's coming home", 0, 0, 1, 0);
		add(INVOKE, "It's coming home", -1, -1, -1, -1);
		add(GET_VARC, "It's coming home", 0, 1);
		add(PUT_VARC, "It's coming home", 1, 0);
		add(ARRAY_INITIALIZE, "It's coming home", 1, 0);
		add(ARRAY_LOAD, "It's coming home", 1, 1);
		add(ARRAY_STORE, "It's coming home", 2, 0);
		add(GET_VARC_STRING, "It's coming home", 0, 0, 0, 1);
		add(PUT_VARC_STRING, "It's coming home", 0, 0, 1, 0);
		add(SWITCH, "It's coming home", 1, 0);
		add(WIDGET_CREATE_CHILD, "It's coming home", 3, 0);
		add(WIDGET_DESTROY_CHILD, "It's coming home", 0, 0);
		add(WIDGET_UNSET_CHILDREN, "It's coming home", 1, 0);
		add(WIDGET_LOAD_CHILD, "It's coming home", 2, 1);
		add(WIDGET_LOAD, "It's coming home", 1, 1);
		// 2000-2100 are the same as 1000-1100, but
		// pop an additional int which is used to get the current widget
		add(WIDGET_PUT_POSITION, "It's coming home", 4, 0);
		add(WIDGET_PUT_SIZE, "It's coming home", 4, 0);
		add(WIDGET_PUT_HIDDEN, "It's coming home", 1, 0);
		add(WIDGET_PUT_NO_CLICK_THROUGH, "It's coming home", 1, 0);
		add(1006, 1, 0);
		// 2100-2200 and 1100-1200 do the same thing
		add(WIDGET_PUT_SCROLL, "It's coming home", 2, 0);
		add(WIDGET_PUT_TEXTCOLOR, "It's coming home", 1, 0);
		add(WIDGET_PUT_FILLED, "It's coming home", 1, 0);
		add(WIDGET_PUT_OPACITY, "It's coming home", 1, 0);
		add(WIDGET_PUT_LINE_WIDTH, "It's coming home", 1, 0);
		add(WIDGET_PUT_SPRITEID, "It's coming home", 1, 0);
		add(WIDGET_PUT_TEXTUREID, "It's coming home", 1, 0);
		add(WIDGET_PUT_SPRITE_TILING, "It's coming home", 1, 0);
		add(WIDGET_PUT_MODELID_1, "It's coming home", 1, 0);
		add(WIDGET_PUT_3D_ROTATION, "It's coming home", 6, 0);
		add(WIDGET_PUT_ANIMATION, "It's coming home", 1, 0);
		add(1111, 1, 0);
		add(WIDGET_PUT_TEXT, "It's coming home", 0, 0, 1, 0);
		add(WIDGET_PUT_FONTID, "It's coming home", 1, 0);
		add(WIDGET_PUT_TEXT_ALIGNMENT, "It's coming home", 3, 0);
		add(WIDGET_PUT_TEXT_SHADOWED, "It's coming home", 1, 0);
		add(WIDGET_PUT_BORDERTHICKNESS, "It's coming home", 1, 0);
		add(WIDGET_PUT_SPRITE2, "It's coming home", 1, 0);
		add(WIDGET_PUT_FLIPPEDVERTICALLY, "It's coming home", 1, 0);
		add(WIDGET_PUT_FLIPPEDHORIZONALLY, "It's coming home", 1, 0);
		add(WIDGET_PUT_SCROLLWIDTHHEIGHT, "It's coming home", 2, 0);
		add(WIDGET_ADVANCE_DIALOGUE, "It's coming home", 0, 0);
		add(1122, 1, 0);
		add(1123, 1, 0);
		add(1124, 1, 0);
		add(1125, 1, 0);
		// and 1200-1300 and 2200-2300
		add(WIDGET_PUT_MODELID_2, "It's coming home", 1, 0);
		add(WIDGET_PUT_MODELID_3, "It's coming home", 0, 0);
		add(1200, 2, 0);
		add(1205, 2, 0);
		add(1212, 2, 0);
		// and 1300-1400 and 2300-2400
		add(WIDGET_PUT_ACTION, "It's coming home", 1, 0, 1, 0);
		add(WIDGET_PUT_DRAG_PARENT, "It's coming home", 2, 0);
		add(1302, 1, 0);
		add(1303, 1, 0);
		add(1304, 1, 0);
		add(WIDGET_PUT_NAME, "It's coming home", 0, 0, 1, 0);
		add(WIDGET_PUT_SELECTED_ACTION, "It's coming home", 0, 0, 1, 0);
		add(WIDGET_PUT_ACTIONS_NULL, "It's coming home", 0, 0);
		// and 1400-1500 and 2400-2500
		add(WIDGET_PUT_MOUSE_PRESS_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAGGED_OVER_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_RELEASE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_ENTER_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_EXIT_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_START_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_WITH_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_CONFIG_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_RENDER_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_OPTION_CLICK_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_RELEASE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_HOVER_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_TABLE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_SKILL_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_SCROLL_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MSG_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_KEY_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_FRIENDS_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_CLAN_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DIALOG_ABORT_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_OPENCLOSE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_GE_LISTENER, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_RESIZE_LISTENER, "It's coming home", -1, 0, -1, 0);
		// and 1500-1600 and 2500-2600
		add(WIDGET_GET_RELATIVEX, "It's coming home", 0, 1);
		add(WIDGET_GET_RELATIVEY, "It's coming home", 0, 1);
		add(WIDGET_GET_WIDTH, "It's coming home", 0, 1);
		add(WIDGET_GET_HEIGHT, "It's coming home", 0, 1);
		add(WIDGET_GET_HIDDEN, "It's coming home", 0, 1);
		add(WIDGET_GET_PARENTID, "It's coming home", 0, 1);
		// and 1600-1700 and 2600-2700
		add(WIDGET_GET_SCROLLX, "It's coming home", 0, 1);
		add(WIDGET_GET_SCROLLY, "It's coming home", 0, 1);
		add(WIDGET_GET_TEXT, "It's coming home", 0, 0, 0, 1);
		add(WIDGET_GET_SCROLLWIDTH, "It's coming home", 0, 1);
		add(WIDGET_GET_SCROLLHEIGHT, "It's coming home", 0, 1);
		add(WIDGET_GET_MODELZOOM, "It's coming home", 0, 1);
		add(WIDGET_GET_ROTATIONX, "It's coming home", 0, 1);
		add(WIDGET_GET_ROTATIONY, "It's coming home", 0, 1);
		add(WIDGET_GET_ROTATIONZ, "It's coming home", 0, 1);
		add(WIDGET_GET_OPACITY, "It's coming home", 0, 1);
		add(1610, 0, 1);
		add(WIDGET_GET_TEXTCOLOR, "It's coming home", 0, 1);
		add(1612, 0, 1);
		add(1613, 0, 1);
		// 1700
		add(WIDGET_GET_ITEMID, "It's coming home", 0, 1);
		add(WIDGET_GET_STACKSIZE, "It's coming home", 0, 1);
		add(WIDGET_GET_INDEX, "It's coming home", 0, 1);
		add(WIDGET_GET_CONFIG, "It's coming home", 0, 1);
		add(WIDGET_GET_ACTION, "It's coming home", 1, 0, 0, 1);
		add(WIDGET_GET_NAME, "It's coming home", 0, 0, 0, 1);
		// and 1900-2000 and 2900-3000
		add(1927, 0, 0);
		// 2000-2100
		add(WIDGET_PUT_POSITION_WIDGET, "It's coming home", 5, 0);
		add(WIDGET_PUT_SIZE_WIDGET, "It's coming home", 5, 0);
		add(WIDGET_PUT_HIDDEN_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_NO_CLICK_THROUGH_WIDGET, "It's coming home", 2, 0);
		add(2006, 2, 0);
		// 2100-2200
		add(WIDGET_PUT_SCROLL_WIDGET, "It's coming home", 3, 0);
		add(WIDGET_PUT_TEXTCOLOR_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_FILLED_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_OPACITY_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_LINE_WIDTH_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_SPRITEID_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_TEXTUREID_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_SPRITE_TILING_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_MODELID_1_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_3D_ROTATION_WIDGET, "It's coming home", 7, 0);
		add(WIDGET_PUT_ANIMATION_WIDGET, "It's coming home", 2, 0);
		add(2111, 2, 0);
		add(WIDGET_PUT_TEXT_WIDGET, "It's coming home", 1, 0, 1, 0);
		add(WIDGET_PUT_FONTID_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_TEXT_ALIGNMENT_WIDGET, "It's coming home", 4, 0);
		add(WIDGET_PUT_TEXT_SHADOWED_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_BORDERTHICKNESS_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_SPRITE2_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_FLIPPEDVERTICALLY_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_FLIPPEDHORIZONALLY_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_SCROLLWIDTHHEIGHT_WIDGET, "It's coming home", 3, 0);
		add(WIDGET_ADVANCE_DIALOGUE_WIDGET, "It's coming home", 1, 0);
		add(2122, 2, 0);
		add(2123, 2, 0);
		add(2124, 2, 0);
		add(2125, 2, 0);
		// 2200-2300
		add(WIDGET_PUT_MODELID_2_WIDGET, "It's coming home", 2, 0);
		add(WIDGET_PUT_MODELID_3_WIDGET, "It's coming home", 1, 0);
		add(2200, 3, 0);
		add(2205, 3, 0);
		add(2212, 3, 0);
		// 2300-2400
		add(WIDGET_PUT_ACTION_WIDGET, "It's coming home", 2, 0, 1, 0);
		add(WIDGET_PUT_DRAG_PARENT_WIDGET, "It's coming home", 3, 0);
		add(2302, 2, 0);
		add(2303, 2, 0);
		add(2304, 2, 0);
		add(WIDGET_PUT_NAME_WIDGET, "It's coming home", 1, 0, 1, 0);
		add(WIDET_PUT_SELECTED_ACTION_WIDGET, "It's coming home", 1, 0, 1, 0);
		add(WIDGET_PUT_ACTIONS_NULL_WIDGET, "It's coming home", 1, 0);
		// 2400-2500
		add(WIDGET_PUT_MOUSE_PRESS_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAGGED_OVER_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_RELEASE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_ENTER_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_EXIT_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_START_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_WITH_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_CONFIG_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_RENDER_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_OPTION_CLICK_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_RELEASE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DRAG_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MOUSE_HOVER_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_TABLE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_SKILL_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_USE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_SCROLL_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_MSG_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_KEY_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_FRIENDS_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_CLAN_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_DIALOG_ABORT_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_OPENCLOSE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_GE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		add(WIDGET_PUT_RESIZE_LISTENER_WIDGET, "It's coming home", -1, 0, -1, 0);
		// 2500-2600
		add(WIDGET_GET_RELATIVEX_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_RELATIVEY_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_WIDTH_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_HEIGHT_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_HIDDEN_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_PARENTID_WIDGET, "It's coming home", 1, 1);
		// 2600-2700
		add(WIDGET_GET_SCROLLX_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_SCROLLY_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_TEXT_WIDGET, "It's coming home", 1, 0, 0, 1);
		add(WIDGET_GET_SCROLLWIDTH_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_SCROLLHEIGHT_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_MODELZOOM_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_ROTATIONX_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_ROTATIONY_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_ROTATIONZ_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_OPACITY_WIDGET, "It's coming home", 1, 1);
		add(2610, 1, 1);
		add(WIDGET_GET_TEXTCOLOR_WIDGET, "It's coming home", 1, 1);
		add(2612, 1, 1);
		add(2613, 1, 1);
		// 2700-2800
		add(WIDGET_GET_ITEMID_WIDGET, "It's coming home", 1, 1);
		add(WIDGET_GET_STACKSIZE_WIDGET, "It's coming home", 1, 1);
		add(WIGET_GET_INDEX_WIDGET, "It's coming home", 1, 1);
		add(GET_WIDGET_ROOT, "It's coming home", 0, 1);
		// 2800-2900
		add(WIDGET_GET_CONFIG_WIGET, "It's coming home", 1, 1);
		add(WIDGET_GET_ACTION_WIDGET, "It's coming home", 2, 0, 0, 1);
		add(WIDGET_GET_NAME_WIDGET, "It's coming home", 1, 0, 0, 1);
		// 2900-3000
		add(2927, 1, 0);
		// 3000-3200
		add(SEND_GAME_MESSAGE, "It's coming home", 0, 0, 1, 0);
		add(PLAYER_ANIMATE, "It's coming home", 2, 0);
		add(CLOSE_WINDOW, "It's coming home", 0, 0);
		add(NUMERIC_INPUT, "It's coming home", 0, 0, 1, 0);
		add(STRING_INPUT_1, "It's coming home", 0, 0, 1, 0);
		add(STRING_INPUT_2, "It's coming home", 0, 0, 1, 0);
		add(PLAYER_ACTION, "It's coming home", 1, 0, 1, 0);
		add(SET_TOP_CONTEXT_MENU_ROW, "It's coming home", 3, 0);
		add(SET_TOP_CONTEXT_MENU_ROW_2, "It's coming home", 2, 0);
		add(SET_MOUSE_BUTTON_CONTROLS_CAMERA, "It's coming home", 1, 0);
		add(GET_HIDEROOFS, "It's coming home", 0, 1);
		add(SET_HIDEROOFS, "It's coming home", 1, 0);
		add(OPEN_URL, "It's coming home", 1, 0, 1, 0);
		add(ITEM_PRICE, "It's coming home", 1, 0);
		add(SEND_BUG_REPORT, "It's coming home", 1, 0, 2, 0);
		add(SET_SHIFT_DROP_ENABLED, "It's coming home", 1, 0);
		// 3200-3300
		add(PLAY_SOUND_EFFECT, "It's coming home", 3, 0);
		add(3201, 1, 0);
		add(3202, 2, 0);
		// 3300-3400
		add(GET_GAMECYCLE, "It's coming home", 0, 1);
		add(GET_ITEMCONTAINER_ITEMID, "It's coming home", 2, 0);
		add(GET_ITEMCONTAINER_STACKSIZE, "It's coming home", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZES_TOTAL, "It's coming home", 2, 1);
		add(GET_INVENTORY_SIZE, "It's coming home", 1, 1);
		add(GET_BOOSTEDSKILLLEVELS, "It's coming home", 1, 1);
		add(GET_REALSKILLLEVELS, "It's coming home", 1, 1);
		add(GET_SKILLEXPERIENCES, "It's coming home", 1, 1);
		add(GET_COORDINATES, "It's coming home", 0, 1);
		add(DIVIDE_BY_16384, "It's coming home", 1, 1);
		add(RIGHT_SHIFT_28, "It's coming home", 1, 1);
		add(AND_16384, "It's coming home", 1, 1);
		add(GET_ISMEMBERS, "It's coming home", 0, 1);
		add(GET_ITEMCONTAINER_ITEMID_2, "It's coming home", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZE_2, "It's coming home", 2, 1);
		add(GET_ITEMCONTAINER_STACKSIZES_TOTAL_2, "It's coming home", 2, 1);
		add(GET_RIGHTS, "It's coming home", 0, 1);
		add(GET_SYSTEM_UPDATE_TIMER, "It's coming home", 0, 1);
		add(GET_WORLDNUM, "It's coming home", 0, 1);
		add(GET_ENERGY, "It's coming home", 0, 1);
		add(GET_WEIGHT, "It's coming home", 0, 1);
		add(GET_PLAYERMOD, "It's coming home", 0, 1);
		add(GET_FLAGS, "It's coming home", 0, 1);
		add(PACK_LOCATION, "It's coming home", 4, 1);
		// 3400-3500
		add(3400, 2, 0, 0, 1);
		add(GET_ENUM_VALUE, "It's coming home", 4, -1, 0, -1); // this pushes an int or a string, depending on the argument
		// 3500-3700
		add(GET_FRIENDCOUNT, "It's coming home", 0, 1);
		add(GET_FRIEND, "It's coming home", 1, 0, 0, 2);
		add(GET_FRIEND_WORLD, "It's coming home", 1, 1);
		add(GET_FRIEND_RANK, "It's coming home", 1, 1);
		add(3604, 1, 0, 1, 0);
		add(ADD_FRIEND, "It's coming home", 0, 0, 1, 0);
		add(REMOVE_FRIEND, "It's coming home", 0, 0, 1, 0);
		add(ADD_IGNORE, "It's coming home", 0, 0, 1, 0);
		add(REMOVE_IGNORE, "It's coming home", 0, 0, 1, 0);
		add(IS_FRIEND, "It's coming home", 0, 1, 1, 0);
		add(GET_CLANCHAT_OWNER, "It's coming home", 0, 0, 0, 1);
		add(GET_CLANCHATCOUNT, "It's coming home", 0, 1);
		add(GET_CLAN_MEMBER_NAME, "It's coming home", 1, 0, 0, 1);
		add(GET_CLAN_MEMBER_WORLD, "It's coming home", 1, 1);
		add(GET_CLAN_MEMBER_RANK, "It's coming home", 1, 1);
		add(CLANCHAT_KICK_RANK, "It's coming home", 0, 1);
		add(CLANCHAT_KICK_CLANMEMBER, "It's coming home", 0, 0, 1, 0);
		add(GET_CLANCHAT_RANK, "It's coming home", 0, 1);
		add(JOIN_CLANCHAT, "It's coming home", 0, 0, 1, 0);
		add(PART_CLANCHAT, "It's coming home", 0, 0);
		add(GET_IGNORECOUNT, "It's coming home", 0, 1);
		add(GET_IGNORE, "It's coming home", 1, 0, 0, 2);
		add(IS_IGNORE, "It's coming home", 0, 1, 1, 0);
		add(CLANMEMBER_ISME, "It's coming home", 1, 1);
		add(GET_CLANCHATOWNER, "It's coming home", 0, 0, 0, 1);
		// 3700-4000
		add(GET_GRANDEXCHANGE_OFFER_IS_SELLING, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_ITEMID, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_PRICE, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_TOTALQUANTITY, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_QUANTITYSOLD, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_SPENT, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_NOT_STARTED, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_STATUS_2, "It's coming home", 1, 1);
		add(GET_GRANDEXCHANGE_OFFER_DONE, "It's coming home", 1, 1);
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
		add(IADD, "It's coming home", 2, 1);
		add(ISUB, "It's coming home", 2, 1);
		add(IMUL, "It's coming home", 2, 1);
		add(IDIV, "It's coming home", 2, 1);
		add(RAND_EXCL, "It's coming home", 1, 1);
		add(RAND_INCL, "It's coming home", 1, 1);
		add(INTERPOLATE, "It's coming home", 5, 1);
		add(ADD_PERCENT, "It's coming home", 2, 1);
		add(SET_BIT, "It's coming home", 2, 1);
		add(CLEAR_BIT, "It's coming home", 2, 1);
		add(TEST_BIT, "It's coming home", 2, 1);
		add(MODULO, "It's coming home", 2, 1);
		add(POW, "It's coming home", 2, 1);
		add(INVPOW, "It's coming home", 2, 1);
		add(AND, "It's coming home", 2, 1);
		add(OR, "It's coming home", 2, 1);
		add(SCALE, "It's coming home", 3, 1);
		// 4100-4200
		add(CONCAT_INT, "It's coming home", 1, 0, 1, 1);
		add(CONCAT_STRING, "It's coming home", 0, 0, 2, 1);
		add(4102, 1, 0, 1, 1);
		add(TOLOWERCASE, "It's coming home", 0, 0, 1, 1);
		add(FORMAT_DATE, "It's coming home", 1, 0, 0, 1);
		add(SWITCH_MALE_OR_FEMALE, "It's coming home", 0, 0, 2, 1);
		add(INT_TO_STRING, "It's coming home", 1, 0, 0, 1);
		add(STRING_COMPARE, "It's coming home", 0, 1, 2, 0);
		add(GET_LINE_COUNT, "It's coming home", 2, 1, 1, 0);
		add(GET_MAX_LINE_WIDTH, "It's coming home", 2, 1, 1, 0);
		add(SWITCH_STRING, "It's coming home", 1, 0, 2, 1);
		add(APPENDTAGS, "It's coming home", 0, 0, 1, 1);
		add(CONCAT_CHAR, "It's coming home", 1, 0, 1, 1);
		add(CHAR_IS_PRINTABLE, "It's coming home", 1, 1);
		add(ISALNUM, "It's coming home", 1, 1);
		add(ISALPHA, "It's coming home", 1, 1);
		add(ISDIGIT, "It's coming home", 1, 1);
		add(STRING_LENGTH, "It's coming home", 0, 1, 1, 0);
		add(STRING_SUBSTRING, "It's coming home", 2, 0, 1, 1);
		add(STRING_REMOVE_HTML, "It's coming home", 0, 0, 1, 1);
		add(STRING_INDEXOF, "It's coming home", 1, 1, 1, 0);
		add(STRING_INDEXOF_FROM, "It's coming home", 1, 1, 2, 0);
		// 4200-4300
		add(GET_ITEM_NAME, "It's coming home", 1, 0, 0, 1);
		add(GET_ITEM_GROUND_ACTION, "It's coming home", 2, 0, 0, 1);
		add(GET_ITEM_INVENTORY_ACTION, "It's coming home", 2, 0, 0, 1);
		add(GET_ITEM_PRICE, "It's coming home", 1, 1);
		add(GET_ITEM_STACKABLE, "It's coming home", 1, 1);
		add(GET_ITEM_NOTE_1, "It's coming home", 1, 1);
		add(GET_ITEM_NOTE_2, "It's coming home", 1, 1);
		add(GET_ITEM_ISMEMBERS, "It's coming home", 1, 1);
		add(4208, 1, 1);
		add(4209, 1, 1);
		add(SEARCH_ITEM, "It's coming home", 1, 1, 1, 0);
		add(NEXT_SEARCH_RESULT, "It's coming home", 0, 1);
		add(4212, 0, 0);
		// 4300-5100
		add(5000, 0, 1);
		add(CHATFILTER_UPDATE, "It's coming home", 3, 0);
		add(REPORT_PLAYER, "It's coming home", 2, 0, 1, 0);
		add(GET_CHAT_MESSAGE_TYPE, "It's coming home", 2, 2, 0, 3);
		add(GET_CHAT_MESSAGE, "It's coming home", 1, 2, 0, 3);
		add(5005, 0, 1);
		add(CHATBOX_INPUT, "It's coming home", 1, 0, 1, 0);
		add(PRIVMSG, "It's coming home", 0, 0, 2, 0);
		add(GET_LOCALPLAYER_NAME, "It's coming home", 0, 0, 0, 1);
		add(5016, 0, 1);
		add(GET_CHATLINEBUFFER_LENGTH, "It's coming home", 1, 1);
		add(GET_MESSAGENODE_PREV_ID, "It's coming home", 1, 1);
		add(GET_MESSAGENODE_NEXT_ID, "It's coming home", 1, 1);
		add(RUN_COMMAND, "It's coming home", 0, 0, 1, 0);
		add(5021, 0, 0, 1, 0);
		add(5022, 0, 0, 0, 1);
		// 5100-5400
		add(GET_ISRESIZED, "It's coming home", 0, 1);
		add(SET_ISRESIZED, "It's coming home", 1, 0);
		add(GET_SCREENTYPE, "It's coming home", 0, 1);
		add(SET_SCREENTYPE, "It's coming home", 1, 0);
		// 5400-5600
		add(5504, 2, 0);
		add(5505, 0, 1);
		add(GET_MAPANGLE, "It's coming home", 0, 1);
		add(SET_CAMERA_FOCAL_POINT_HEIGHT, "It's coming home", 1, 0);
		add(GET_CAMERA_FOCAL_POINT_HEIGHT, "It's coming home", 0, 1);
		// 5600-5700
		add(CANCEL_LOGIN, "It's coming home", 0, 0);
		// 5700-6300
		add(6200, 2, 0);
		add(SET_ZOOM_DISTANCE, "It's coming home", 2, 0);
		add(6202, 4, 0);
		add(GET_VIEWPORT_SIZE, "It's coming home", 0, 2);
		add(GET_ZOOM_DISTANCE, "It's coming home", 0, 2);
		add(6205, 0, 2);
		// 6300-6600
		add(LOAD_WORLDS, "It's coming home", 0, 1);
		add(GET_FIRST_WORLD, "It's coming home", 0, 4, 0, 2);
		add(GET_NEXT_WORLD, "It's coming home", 0, 4, 0, 2);
		add(GET_WORLD_BY_ID, "It's coming home", 1, 4, 0, 2);
		add(6507, 4, 0);
		add(GET_WORLD_BY_INDEX, "It's coming home", 1, 4, 0, 2);
		add(6512, 1, 0);
		add(GET_IS_MOBILE, "It's coming home", 0, 1);
		// 6600-6700
		add(6600, 0, 0);
		add(6601, 1, 0, 0, 1);
		add(6602, 1, 0);
		add(6603, 0, 1);
		add(6604, 1, 0);
		add(6605, 0, 1);
		add(6606, 1, 0);
		add(6607, 1, 0);
		add(6608, 1, 0);
		add(6609, 1, 0);
		add(6610, 0, 2);
		add(6611, 1, 1);
		add(6612, 1, 2);
		add(6613, 1, 4);
		add(6614, 1, 1);
		add(6615, 2, 2);
		add(6616, 0, 1);
		add(6617, 1, 2);
		// 6618 variable
		add(6619, 2, 1);
		add(6620, 2, 1);
		add(6621, 2, 1);
		add(622, 0, 1);
		add(6623, 1, 1);
		add(6624, 1, 0);
		add(6625, 0, 0);
		add(6626, 1, 0);
		add(6627, 0, 0);
		add(6628, 1, 0);
		add(6629, 1, 0);
		add(6630, 1, 0);
		add(6631, 0, 0);
		add(6632, 1, 0);
		add(6633, 2, 0);
		add(6634, 2, 0);
		add(6635, 0, 1);
		add(6636, 0, 1);
		add(6637, 1, 1);
		add(6638, 2, 1);
		add(6639, 0, 2);
		add(6640, 0, 2);
		add(GET_AREA_NAME, "It's coming home", 1, 0, 0, 1);
		add(6694, 1, 1);
		add(6695, 1, 1);
		add(6696, 1, 1);
		add(6697, 0, 1);
		add(6698, 0, 1);
		add(6699, 0, 1);
	}

	protected void add(int opcode, String name, int ipops, int ipushes, int spops, int spushes)
	{
		Instruction i = new Instruction(opcode);
		i.setName(name);
		i.setIntStackPops(ipops);
		i.setIntStackPushes(ipushes);
		i.setStringStackPops(spops);
		i.setStringStackPushes(spushes);

		assert instructions.containsKey(opcode) == false;
		instructions.put(opcode, i);

		if (name != null)
		{
			assert instructionsByName.containsKey(name) == false;
			instructionsByName.put(name, i);
		}
	}

	protected void add(int opcode, int ipops, int ipushes)
	{
		add(opcode, null, ipops, ipushes, 0, 0);
	}

	protected void add(int opcode, int ipops, int ipushes, int spops, int spushes)
	{
		add(opcode, null, ipops, ipushes, spops, spushes);
	}

	protected void add(int opcode, String name, int ipops, int ipushes)
	{
		add(opcode, name, ipops, ipushes, 0, 0);
	}

	public Instruction find(int opcode)
	{
		return instructions.get(opcode);
	}

	public Instruction find(String name)
	{
		return instructionsByName.get(name);
	}
}
