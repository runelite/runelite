/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.aoewarnings;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Stub;

@ConfigGroup("aoe")
public interface AoeWarningConfig extends Config
{
	@ConfigItem(
		keyName = "overlayStub",
		name = "Overlay",
		description = "",
		position = 1
	)
	default Stub overlayStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "outline",
		name = "Display Outline",
		description = "Configures whether or not AoE Projectile Warnings have an outline",
		parent = "overlayStub",
		position = 2
	)
	default boolean isOutlineEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "delay",
		name = "Fade delay",
		description = "Configures the amount of time in milliseconds that the warning lingers for after the projectile has touched the ground",
		parent = "overlayStub",
		position = 3
	)
	default int delay()
	{
		return 300;
	}

	@ConfigItem(
		keyName = "fade",
		name = "Fade Warnings",
		description = "Configures whether or not AoE Projectile Warnings fade over time",
		parent = "overlayStub",
		position = 4
	)
	default boolean isFadeEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "npcStub",
		name = "NPC's",
		description = "",
		position = 5
	)
	default Stub npcStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "lizardmanaoe",
		name = "Lizardman Shamans",
		description = "Configures whether or not AoE Projectile Warnings for Lizardman Shamans is displayed",
		parent = "npcStub",
		position = 6
	)
	default boolean isShamansEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "archaeologistaoe",
		name = "Crazy Archaeologist",
		description = "Configures whether or not AoE Projectile Warnings for Archaeologist is displayed",
		parent = "npcStub",
		position = 7
	)
	default boolean isArchaeologistEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "icedemon",
		name = "Ice Demon",
		description = "Configures whether or not AoE Projectile Warnings for Ice Demon is displayed",
		parent = "npcStub",
		position = 8
	)
	default boolean isIceDemonEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vasa",
		name = "Vasa",
		description = "Configures whether or not AoE Projectile Warnings for Vasa is displayed",
		parent = "npcStub",
		position = 9
	)
	default boolean isVasaEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "tekton",
		name = "Tekton",
		description = "Configures whether or not AoE Projectile Warnings for Tekton is displayed",
		parent = "npcStub",
		position = 10
	)
	default boolean isTektonEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vorkath",
		name = "Vorkath",
		description = "Configures whether or not AoE Projectile Warnings for Vorkath are displayed",
		parent = "npcStub",
		position = 11
	)
	default boolean isVorkathEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "galvek",
		name = "Galvek",
		description = "Configures whether or not AoE Projectile Warnings for Galvek are displayed",
		parent = "npcStub",
		position = 12
	)
	default boolean isGalvekEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "gargboss",
		name = "Gargoyle Boss",
		description = "Configs whether or not AoE Projectile Warnings for Dawn/Dusk are displayed",
		parent = "npcStub",
		position = 13
	)
	default boolean isGargBossEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "vetion",
		name = "Vet'ion",
		description = "Configures whether or not AoE Projectile Warnings for Vet'ion are displayed",
		parent = "npcStub",
		position = 14
	)
	default boolean isVetionEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "chaosfanatic",
		name = "Chaos Fanatic",
		description = "Configures whether or not AoE Projectile Warnings for Chaos Fanatic are displayed",
		parent = "npcStub",
		position = 15
	)
	default boolean isChaosFanaticEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "olm",
		name = "Olm",
		description = "Configures whether or not AoE Projectile Warnings for The Great Olm are displayed",
		parent = "npcStub",
		position = 16
	)
	default boolean isOlmEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "bombDisplay",
		name = "Olm Bombs",
		description = "Display a timer and colour-coded AoE for Olm's crystal-phase bombs.",
		parent = "npcStub",
		position = 17
	)
	default boolean bombDisplay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "corp",
		name = "Corporeal Beast",
		description = "Configures whether or not AoE Projectile Warnings for the Corporeal Beast are displayed",
		parent = "npcStub",
		position = 18
	)
	default boolean isCorpEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "wintertodt",
		name = "Wintertodt Snow Fall",
		description = "Configures whether or not AOE Projectile Warnings for the Wintertodt snow fall are displayed",
		parent = "npcStub",
		position = 19
	)
	default boolean isWintertodtEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "isXarpusEnabled",
		name = "Xarpus",
		description = "Configures whether or not AOE Projectile Warnings for Xarpus are displayed",
		parent = "npcStub",
		position = 20
	)
	default boolean isXarpusEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lightning",
		name = "Olm Lightning Trails",
		description = "Show Lightning Trails",
		parent = "npcStub",
		position = 21
	)
	default boolean LightningTrail()
	{
		return true;
	}

	@ConfigItem(
		keyName = "addyDrags",
		name = "Addy Drags",
		description = "Show Bad Areas",
		parent = "npcStub",
		position = 22
	)
	default boolean addyDrags()
	{
		return true;
	}

	@ConfigItem(
		keyName = "drake", name = "Drakes Breath",
		description = "Configures if Drakes Breath tile markers are displayed",
		parent = "npcStub",
		position = 23
	)
	default boolean isDrakeEnabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "cerbFire",
		name = "Cerberus Fire",
		description = "Configures if Cerberus fire tile markers are displayed",
		parent = "npcStub",
		position = 24
	)
	default boolean isCerbFireEnabled()
	{
		return true;
	}
}
