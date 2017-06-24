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
package net.runelite.api.widgets;

class WidgetID
{
	static final int BANK_GROUP_ID = 12;
	static final int INVENTORY_GROUP_ID = 149;
	static final int PESTRCONTROL_GROUP_ID = 408;
	static final int CLAN_CHAT_GROUP_ID = 7;
	static final int MINIMAP_GROUP_ID = 160;
	static final int LOGIN_CLICK_TO_PLAY_GROUP_ID = 378;

	static class PestControl
	{
		static final int PURPLE_SHIELD = 21;
		static final int BLUE_SHIELD = 23;
		static final int YELLOW_SHIELD = 25;
		static final int RED_SHIELD = 27;

		static final int PURPLE_HEALTH = 17;
		static final int BLUE_HEALTH = 18;
		static final int YELLOW_HEALTH = 19;
		static final int RED_HEALTH = 20;

		static final int PURPLE_ICON = 13;
		static final int BLUE_ICON = 14;
		static final int YELLOW_ICON = 15;
		static final int RED_ICON = 16;

		static final int ACTIVITY_BAR = 6;
		static final int ACTIVITY_PROGRESS = 8;
	}

	static class ClanChat
	{
		static final int TITLE = 1;
		static final int NAME = 3;
		static final int OWNER = 5;
	}

	static class Bank
	{
		static final int ITEM_CONTAINER = 12;
	}

	static class Minimap
	{
		static final int XP_ORB = 1;
	}
}
