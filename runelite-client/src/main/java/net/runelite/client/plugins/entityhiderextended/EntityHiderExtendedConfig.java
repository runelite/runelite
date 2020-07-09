///*
// * Copyright (c) 2018, Lotto <https://github.com/devLotto>
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are met:
// *
// * 1. Redistributions of source code must retain the above copyright notice, this
// *   list of conditions and the following disclaimer.
// *
// * 2. Redistributions in binary form must reproduce the above copyright notice,
// *   this list of conditions and the following disclaimer in the documentation
// *   and/or other materials provided with the distribution.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
//package net.runelite.client.plugins.entityhiderextended;
//
//import net.runelite.client.config.Config;
//import net.runelite.client.config.ConfigGroup;
//import net.runelite.client.config.ConfigItem;
//import net.runelite.client.config.ConfigTitleSection;
//import net.runelite.client.config.Title;
//
//@ConfigGroup("entityhiderextended")
//public interface EntityHiderExtendedConfig extends Config
//{
//	@ConfigTitleSection(
//		keyName = "npcsTitle",
//		name = "NPCs",
//		description = "",
//		position = 0
//	)
//	default Title npcsTitle()
//	{
//		return new Title();
//	}
//
//	@ConfigItem(
//		position = 15,
//		keyName = "hideDeadNPCs",
//		name = "Hide Dead NPCs",
//		description = "Configures whether or not NPCs that just died are hidden",
//		titleSection = "npcsTitle"
//	)
//	default boolean hideDeadNPCs()
//	{
//		return false;
//	}
//
//	@ConfigItem(
//		position = 16,
//		keyName = "hideNPCsOnDeath",
//		name = "Hide NPCs On Death",
//		description = "Configures which NPCs to hide when they die",
//		titleSection = "npcsTitle"
//	)
//	default String hideNPCsOnDeath()
//	{
//		return "";
//	}
//
//	@ConfigItem(
//		position = 17,
//		keyName = "blacklistDeadNpcs",
//		name = "Hide on Death Blacklist",
//		description = "Configures which NPCs NOT to hide when they die",
//		titleSection = "npcsTitle",
//		hidden = true,
//		unhide = "hideDeadNPCs"
//	)
//	default String blacklistDeadNpcs()
//	{
//		return "";
//	}
//}