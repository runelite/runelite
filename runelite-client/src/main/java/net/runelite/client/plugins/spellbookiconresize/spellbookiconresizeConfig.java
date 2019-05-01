/*
 * Copyright (c) 2018, https://runelitepl.us
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

package net.runelite.client.plugins.spellbookiconresize;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("spellbookfixer")
public interface spellbookiconresizeConfig extends Config
{
	@ConfigItem(position = 0, keyName = "shouldHideOthers", name = "Hide Others", description = "Toggle on to hide spells not useful for pking that cannot be filtered otherwise.")
	default boolean shouldHideOthers()
	{
		return true;
	}

	//Blood Barrage
	@ConfigItem(position = 1, keyName = "shouldModifyBloodBarrage", name = "Blood Barrage", description = "Toggle on to Blood Barrage modifications.")
	default boolean shouldModifyBloodBarrage() { return true; }
	@ConfigItem(position = 2, keyName = "getBloodPositionX", name = "Blood Barrage Pos X", description = "Modifies the X-axis position of Blood Barrage.")
	default int getBloodPositionX()
	{
		return 0;
	}
	@ConfigItem(position = 3, keyName = "getBloodPositionY", name = "Blood Barrage Pos Y", description = "Modifies the Y-axis position of Blood Barrage.")
	default int getBloodPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 4, keyName = "getBloodSize", name = "Blood Barrage Size", description = "Modifies the width of Blood Barrage.")
	default int getBloodSize() { return 100; }
	@ConfigItem(position = 6, keyName = "shouldHideBloodBarrage", name = "Hide Blood Barrage", description = "Enable this to hide blood barrage")
	default boolean shouldHideBloodBarrage()
	{
		return false;
	}
	//Ice Barrage
	@ConfigItem(position = 7, keyName = "shouldModifyIceBarrage", name = "Ice Barrage", description = "Toggle on to enable Ice Barrage modifications.")
	default boolean shouldModifyIceBarrage() { return true; }
	@ConfigItem(position = 8, keyName = "getBarragePositionX", name = "Ice Barrage Pos X", description = "Modifies the X-axis position of Ice Barrage.")
	default int getBarragePositionX()
	{
		return 0;
	}
	@ConfigItem(position = 9, keyName = "getBarragePositionY", name = "Ice Barrage Pos y", description = "Modifies the X-axis position of Ice Barrage.")
	default int getBarragePositionY()
	{
		return 75;
	}
	@ConfigItem(position = 10, keyName = "getBarrageSize", name = "Ice Barrage Size", description = "Modifies the width position of Ice Barrage.")
	default int getBarrageSize()
	{
		return 100;
	}
	@ConfigItem(position = 12, keyName = "shouldHideIceBarrage", name = "Hide Ice Barrage", description = "Enable this to hide Ice barrage")
	default boolean shouldHideIceBarrage()
	{
		return false;
	}
	//Ice Blitz
	@ConfigItem(position = 13, keyName = "shouldModifyIceBlitz", name = "Ice Blitz", description = "Toggle on to enable Ice Blitz modifications.")
	default boolean shouldModifyIceBlitz() { return true; }
	@ConfigItem(position = 14, keyName = "getBlitzPositionX", name = "Ice Blitz Pos X", description = "Modifies the X-axis position of Ice Blitz.")
	default int getBlitzPositionX() { return 0; }
	@ConfigItem(position = 15, keyName = "getBlitzPositionY", name = "Ice Blitz Pos y", description = "Modifies the X-axis position of Ice Blitz.")
	default int getBlitzPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 16, keyName = "getBlitzeSize", name = "Ice Blitz Size", description = "Modifies the width position of Ice Blitz.")
	default int getBlitzSize()
	{
		return 100;
	}
	@ConfigItem(position = 17, keyName = "shouldHideIceBlitz", name = "Hide Ice Blitz", description = "Enable this to hide Ice blitz")
	default boolean shouldHideIceBlitz()
	{
		return false;
	}
	//Blood blitz
	@ConfigItem(position = 18, keyName = "shouldModifyBloodBlitz", name = "Blood Blitz", description = "Toggle on to enable Blood Blitz modifications.")
	default boolean shouldModifyBloodBlitz() { return true; }
	@ConfigItem(position = 19, keyName = "getBloodBlitzPositionX", name = "Blood Blitz Pos X", description = "Modifies the X-axis position of Blood Blitz.")
	default int getBloodBlitzPositionX() { return 0; }
	@ConfigItem(position = 20, keyName = "getBloodBlitzPositionY", name = "Blood Blitz Pos y", description = "Modifies the X-axis position of Blood Blitz.")
	default int getBloodBlitzPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 21, keyName = "getBloodBlitzSize", name = "Blood Blitz Size", description = "Modifies the width position of Blood Blitz.")
	default int getBloodBlitzSize()
	{
		return 100;
	}
	@ConfigItem(position = 22, keyName = "shouldHideBLoodBlitz", name = "Hide Blood Blitz", description = "Enable this to hide Blood blitz")
	default boolean shouldHideBloodBlitz()
	{
		return false;
	}
/*
	//Vengeance
	@ConfigItem(position = 23, keyName = "shouldModifyVengeance", name = "Vengeance", description = "Toggle on to enable Vengeance modifications.")
	default boolean shouldModifyVengeance() { return true; }
	@ConfigItem(position = 24, keyName = "getVengeancePositionX", name = "Vengeance Pos X", description = "Modifies the X-axis position of Vengeance.")
	default int getVengeancePositionX() { return 0; }
	@ConfigItem(position = 25, keyName = "getVengeancePositionY", name = "Vengeance Pos y", description = "Modifies the X-axis position of Vengeance.")
	default int getVengeancePositionY()
	{
		return 0;
	}
	@ConfigItem(position = 26, keyName = "getVengeanceSize", name = "Vengeance Size", description = "Modifies the width position of Vengeance.")
	default int getVengeanceSize()
	{
		return 100;
	}
	@ConfigItem(position = 27, keyName = "shouldHideVengeance", name = "Hide Vengeance", description = "Enable this to hide Vengeance")
	default boolean shouldVengeance()
	{
		return false;
	}	
	//TeleBlock
	@ConfigItem(position = 28, keyName = "shouldModifyTeleBlock", name = "TeleBlock", description = "Toggle on to enable TeleBlock modifications.")
	default boolean shouldModifyTeleBlock() { return true; }
	@ConfigItem(position = 29, keyName = "getTeleBlockPositionX", name = "TeleBlock Pos X", description = "Modifies the X-axis position of TeleBlock.")
	default int getTeleBlockPositionX() { return 0; }
	@ConfigItem(position = 30, keyName = "getTeleBlockPositionY", name = "TeleBlock Pos y", description = "Modifies the X-axis position of TeleBlock.")
	default int getTeleBlockPositionY()
	{
		return 0;
	}
	@ConfigItem(position = 31, keyName = "getTeleBlockSize", name = "TeleBlock Size", description = "Modifies the width position of TeleBlock.")
	default int getTeleBlockSize()
	{
		return 100;
	}
	@ConfigItem(position = 32, keyName = "shouldHideTeleBlock", name = "Hide TeleBlock", description = "Enable this to hide TeleBlock")
	default boolean shouldTeleBlock()
	{
		return false;
	}	
	//Entangle
	@ConfigItem(position = 33, keyName = "shouldModifyEntangle", name = "Entangle", description = "Toggle on to enable Entangle modifications.")
	default boolean shouldModifyEntangle() { return true; }
	@ConfigItem(position = 34, keyName = "getEntanglePositionX", name = "Entangle Pos X", description = "Modifies the X-axis position of Entangle.")
	default int getEntanglePositionX() { return 0; }
	@ConfigItem(position = 35, keyName = "getEntanglePositionY", name = "Entangle Pos y", description = "Modifies the X-axis position of Entangle.")
	default int getEntanglePositionY()
	{
		return 0;
	}
	@ConfigItem(position = 36, keyName = "getEntangleSize", name = "Entangle Size", description = "Modifies the width position of Entangle.")
	default int getEntangleSize()
	{
		return 100;
	}
	@ConfigItem(position = 37, keyName = "shouldHideEntangle", name = "Hide Entangle", description = "Enable this to hide Entangle")
	default boolean shouldEntangle()
	{
		return false;
	}	
	//FireSurge
	@ConfigItem(position = 38, keyName = "shouldModifyFireSurge", name = "FireSurge", description = "Toggle on to enable FireSurge modifications.")
	default boolean shouldModifyFireSurge() { return true; }
	@ConfigItem(position = 39, keyName = "getFireSurgePositionX", name = "FireSurge Pos X", description = "Modifies the X-axis position of FireSurge.")
	default int getFireSurgePositionX() { return 0; }
	@ConfigItem(position = 40, keyName = "getFireSurgePositionY", name = "FireSurge Pos y", description = "Modifies the X-axis position of FireSurge.")
	default int getFireSurgePositionY()
	{
		return 0;
	}
	@ConfigItem(position = 41, keyName = "getFireSurgeSize", name = "FireSurge Size", description = "Modifies the width position of FireSurge.")
	default int getFireSurgeSize()
	{
		return 100;
	}
	@ConfigItem(position = 42, keyName = "shouldHideFireSurge", name = "Hide FireSurge", description = "Enable this to hide FireSurge")
	default boolean shouldFireSurge()
	{
		return false;
	}	
*/
}
