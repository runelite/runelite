/*
 *  Copyright (c) 2018, trimbe <github.com/trimbe>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.randomevents;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Notification;

@ConfigGroup("randomevents")
public interface RandomEventConfig extends Config
{
	@ConfigSection(
		name = "Notification settings",
		description = "Choose which random events will trigger notifications when spawned.",
		position = 99
	)
	String notificationSection = "section";

	@ConfigItem(
		keyName = "removeMenuOptions",
		name = "Remove others' menu options",
		description = "Remove menu options from random events for other players.",
		position = -3
	)
	default boolean removeMenuOptions()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notifyAll",
		name = "Notify for all events",
		description = "",
		position = -2,
		section = notificationSection
	)
	default Notification notifyAllEvents()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyArnav",
		name = "Notify on Capt' Arnav's chest",
		description = "",
		section = notificationSection
	)
	default Notification notifyArnav()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyBeekeeper",
		name = "Notify on Beekeeper",
		description = "",
		section = notificationSection
	)
	default Notification notifyBeekeeper()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyBob",
		name = "Notify on Evil Bob",
		description = "",
		section = notificationSection
	)
	default Notification notifyBob()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyCerters",
		name = "Notify on certers",
		description = "",
		section = notificationSection
	)
	default Notification notifyCerters()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyDemon",
		name = "Notify on Drill Demon",
		description = "",
		section = notificationSection
	)
	default Notification notifyDemon()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyDunce",
		name = "Notify on surprise exam",
		description = "",
		section = notificationSection
	)
	default Notification notifyDunce()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyDwarf",
		name = "Notify on Drunken Dwarf",
		description = "",
		section = notificationSection
	)
	default Notification notifyDwarf()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyForester",
		name = "Notify on Freaky Forester",
		description = "",
		section = notificationSection
	)
	default Notification notifyForester()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyFlippa",
		name = "Notify on pinball",
		description = "",
		section = notificationSection
	)
	default Notification notifyFlippa()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyFrog",
		name = "Notify on kiss the frog",
		description = "",
		section = notificationSection
	)
	default Notification notifyFrog()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyGenie",
		name = "Notify on Genie",
		description = "",
		section = notificationSection
	)
	default Notification notifyGenie()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyGravedigger",
		name = "Notify on Gravedigger",
		description = "",
		section = notificationSection
	)
	default Notification notifyGravedigger()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyJekyll",
		name = "Notify on Jekyll & Hyde",
		description = "",
		section = notificationSection
	)
	default Notification notifyJekyll()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyMaze",
		name = "Notify on maze",
		description = "",
		section = notificationSection
	)
	default Notification notifyMaze()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyMime",
		name = "Notify on mime",
		description = "",
		section = notificationSection
	)
	default Notification notifyMime()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyMoM",
		name = "Notify on Mysterious Old Man",
		description = "",
		section = notificationSection
	)
	default Notification notifyMoM()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyPillory",
		name = "Notify on pillory",
		description = "",
		section = notificationSection
	)
	default Notification notifyPillory()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyPrison",
		name = "Notify on Prison Pete",
		description = "",
		section = notificationSection
	)
	default Notification notifyPrison()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyQuiz",
		name = "Notify on Quiz Master",
		description = "",
		section = notificationSection
	)
	default Notification notifyQuiz()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifySandwich",
		name = "Notify on Sandwich Lady",
		description = "",
		section = notificationSection
	)
	default Notification notifySandwich()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyTurpentine",
		name = "Notify on Rick Turpentine",
		description = "",
		section = notificationSection
	)
	default Notification notifyTurpentine()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyTwin",
		name = "Notify on evil twin",
		description = "",
		section = notificationSection
	)
	default Notification notifyTwin()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyCountCheck",
		name = "Notify on Count Check",
		description = "",
		section = notificationSection
	)
	default Notification notifyCountCheck()
	{
		return Notification.OFF;
	}
}
