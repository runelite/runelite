/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.plugins.implings;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Notification;

@ConfigGroup(ImplingsConfig.GROUP)
public interface ImplingsConfig extends Config
{
	String GROUP = "implings";

	enum ImplingMode
	{
		NONE,
		HIGHLIGHT,
		NOTIFY
	}

	@ConfigSection(
		name = "Impling type settings",
		description = "Configuration for each type of impling",
		position = 99
	)
	String implingSection = "implings";

	@ConfigItem(
		position = 1,
		keyName = "highlightBaby",
		name = "Baby impling highlight",
		description = "Configures whether or not Baby impling tags are displayed",
		section = implingSection
	)
	default boolean highlightBaby()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 2,
		keyName = "babyColor",
		name = "Baby impling color",
		description = "Text color for Baby implings",
		section = implingSection
	)
	default Color getBabyColor()
	{
		return new Color(177, 143, 179);
	}

	@ConfigItem(
		position = 3,
		keyName = "babyNotification",
		name = "Baby impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getBabyNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 4,
		keyName = "highlightYoung",
		name = "Young impling highlight",
		description = "Configures whether or not Young impling tags are displayed",
		section = implingSection
	)
	default boolean highlightYoung()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "youngColor",
		name = "Young impling color",
		description = "Text color for Young implings",
		section = implingSection
	)
	default Color getYoungColor()
	{
		return new Color(175, 164, 136);
	}

	@ConfigItem(
		position = 6,
		keyName = "youngNotification",
		name = "Young impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getYoungNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 7,
		keyName = "highlightGourmet",
		name = "Gourmet impling highlight",
		description = "Configures whether or not Gourmet impling tags are displayed",
		section = implingSection
	)
	default boolean highlightGourmet()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "gourmetColor",
		name = "Gourmet impling color",
		description = "Text color for Gourmet implings",
		section = implingSection
	)
	default Color getGourmetColor()
	{
		return new Color(169, 131, 98);
	}

	@ConfigItem(
		position = 9,
		keyName = "gourmetNotification",
		name = "Gourmet impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getGourmetNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 10,
		keyName = "highlightEarth",
		name = "Earth impling highlight",
		description = "Configures whether or not Earth impling tags are displayed",
		section = implingSection
	)
	default boolean highlightEarth()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "earthColor",
		name = "Earth impling color",
		description = "Text color for Earth implings",
		section = implingSection
	)
	default Color getEarthColor()
	{
		return new Color(62, 86, 64);
	}

	@ConfigItem(
		position = 12,
		keyName = "earthNotification",
		name = "Earth impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getEarthNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 13,
		keyName = "highlightEssence",
		name = "Essence impling highlight",
		description = "Configures whether or not Essence impling tags are displayed",
		section = implingSection
	)
	default boolean highlightEssence()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 14,
		keyName = "essenceColor",
		name = "Essence impling color",
		description = "Text color for Essence implings",
		section = implingSection
	)
	default Color getEssenceColor()
	{
		return new Color(32, 89, 90);
	}

	@ConfigItem(
		position = 15,
		keyName = "essenceNotification",
		name = "Essence impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getEssenceNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 16,
		keyName = "highlightEclectic",
		name = "Eclectic impling highlight",
		description = "Configures whether or not Eclectic impling tags are displayed",
		section = implingSection
	)
	default boolean highlightEclectic()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 17,
		keyName = "eclecticColor",
		name = "Eclectic impling color",
		description = "Text color for Eclectic implings",
		section = implingSection
	)
	default Color getEclecticColor()
	{
		return new Color(145, 155, 69);
	}

	@ConfigItem(
		position = 18,
		keyName = "eclecticNotification",
		name = "Eclectic impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getEclecticNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 19,
		keyName = "highlightNature",
		name = "Nature impling highlight",
		description = "Configures whether or not Nature impling tags are displayed",
		section = implingSection
	)
	default boolean highlightNature()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 20,
		keyName = "natureColor",
		name = "Nature impling color",
		description = "Text color for Nature implings",
		section = implingSection
	)
	default Color getNatureColor()
	{
		return new Color(92, 138, 95);
	}

	@ConfigItem(
		position = 21,
		keyName = "natureNotification",
		name = "Nature impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getNatureNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 22,
		keyName = "highlightMagpie",
		name = "Magpie impling highlight",
		description = "Configures whether or not Magpie impling tags are displayed",
		section = implingSection
	)
	default boolean highlightMagpie()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 23,
		keyName = "magpieColor",
		name = "Magpie impling color",
		description = "Text color for Magpie implings",
		section = implingSection
	)
	default Color getMagpieColor()
	{
		return new Color(142, 142, 19);
	}

	@ConfigItem(
		position = 24,
		keyName = "magpieNotification",
		name = "Magpie impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getMagpieNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 25,
		keyName = "highlightNinja",
		name = "Ninja impling highlight",
		description = "Configures whether or not Ninja impling tags are displayed",
		section = implingSection
	)
	default boolean highlightNinja()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 26,
		keyName = "ninjaColor",
		name = "Ninja impling color",
		description = "Text color for Ninja implings",
		section = implingSection
	)
	default Color getNinjaColor()
	{
		return new Color(71, 70, 75);
	}

	@ConfigItem(
		position = 27,
		keyName = "ninjaNotification",
		name = "Ninja impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getNinjaNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 28,
		keyName = "highlightCrystal",
		name = "Crystal impling highlight",
		description = "Configures whether or not Crystal implings are displayed",
		section = implingSection
	)
	default boolean highlightCrystal()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 29,
		keyName = "crystalColor",
		name = "Crystal impling color",
		description = "Text color for Crystal implings",
		section = implingSection
	)
	default Color getCrystalColor()
	{
		return new Color(93, 188, 210);
	}

	@ConfigItem(
		position = 30,
		keyName = "crystalNotification",
		name = "Crystal impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getCrystalNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 31,
		keyName = "highlightDragon",
		name = "Dragon impling highlight",
		description = "Configures whether or not Dragon impling tags are displayed",
		section = implingSection
	)
	default boolean highlightDragon()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 32,
		keyName = "dragonColor",
		name = "Dragon impling color",
		description = "Text color for Dragon implings",
		section = implingSection
	)
	default Color getDragonColor()
	{
		return new Color(210, 85, 75);
	}

	@ConfigItem(
		position = 33,
		keyName = "dragonNotification",
		name = "Dragon impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getDragonNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 34,
		keyName = "highlightLucky",
		name = "Lucky impling highlight",
		description = "Configures whether or not Lucky impling tags are displayed",
		section = implingSection
	)
	default boolean highlightLucky()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 35,
		keyName = "luckyColor",
		name = "Lucky impling color",
		description = "Text color for Lucky implings",
		section = implingSection
	)
	default Color getLuckyColor()
	{
		return new Color(102, 7, 101);
	}

	@ConfigItem(
		position = 36,
		keyName = "luckyNotification",
		name = "Lucky impling notification",
		description = "Configures whether or not the notification is enabled.",
		section = implingSection
	)
	default Notification getLuckyNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		position = 25,
		keyName = "showspawn",
		name = "Show spawn locations",
		description = "Configures whether or not spawn locations are displayed in Puro Puro"
	)
	default boolean showSpawn()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		position = 26,
		keyName = "spawnColor",
		name = "Impling spawn color",
		description = "Text color for impling spawns in Puro Puro"
	)
	default Color getSpawnColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 27,
		keyName = "showname",
		name = "Show name on minimap",
		description = "Configures whether or not impling names are displayed on minimap"
	)
	default boolean showName()
	{
		return false;
	}
}
