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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

/**
 *
 * @author robin
 */
@ConfigGroup(
	keyName = "implings",
	name = "Implings",
	description = "Configuration for the implings plugin"
)
public interface ImplingsConfig extends Config
{

	@ConfigItem(
		keyName = "showbaby",
		name = "Show Baby implings",
		description = "Configures whether or not Baby impling tags are displayed"
	)
	default boolean showBaby()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showyoung",
		name = "Show Young implings",
		description = "Configures whether or not Young impling tags are displayed"
	)
	default boolean showYoung()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showgourmet",
		name = "Show Gourmet implings",
		description = "Configures whether or not Gourmet impling tags are displayed"
	)
	default boolean showGourmet()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showearth",
		name = "Show Earth implings",
		description = "Configures whether or not Earth impling tags are displayed"
	)
	default boolean showEarth()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showessence",
		name = "Show Essence implings",
		description = "Configures whether or not Essence impling tags are displayed"
	)
	default boolean showEssence()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showeclectic",
		name = "Show Eclectic implings",
		description = "Configures whether or not Eclectic impling tags are displayed"
	)
	default boolean showEclectic()
	{
		return false;
	}

	@ConfigItem(
		keyName = "shownature",
		name = "Show Nature implings",
		description = "Configures whether or not Nature impling tags are displayed"
	)
	default boolean showNature()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showmagpie",
		name = "Show Magpie implings",
		description = "Configures whether or not Magpie impling tags are displayed"
	)
	default boolean showMagpie()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showninja",
		name = "Show Ninja implings",
		description = "Configures whether or not Ninja impling tags are displayed"
	)
	default boolean showNinja()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showdragon",
		name = "Show Dragon implings",
		description = "Configures whether or not Dragon impling tags are displayed"
	)
	default boolean showDragon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showlucky",
		name = "Show Lucky implings",
		description = "Configures whether or not Lucky impling tags are displayed"
	)
	default boolean showLucky()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showspawn",
		name = "Show Spawn locations",
		description = "Configures whether or not spawn locations are displayed"
	)
	default boolean showSpawn()
	{
		return false;
	}
}
