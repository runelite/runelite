/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.xptracker;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.inject.Inject;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Skill;
import net.runelite.client.config.ConfigSerializer;
import net.runelite.client.config.Serializer;

@ConfigSerializer(XpSaveSerializer.class)
class XpSave
{
	Map<Skill, XpSaveSingle> skills = new LinkedHashMap<>();
	Set<Skill> compactViewSkills = EnumSet.noneOf(Skill.class);
	XpSaveSingle overall;
}

class XpSaveSingle
{
	@SerializedName("s")
	long startXp;
	@SerializedName("br")
	int xpGainedBeforeReset;
	@SerializedName("ar")
	int xpGainedSinceReset;
	@SerializedName("t")
	long time; // ms
}

class XpSaveSerializer implements Serializer<XpSave>
{
	private final Gson gson;

	@Inject
	private XpSaveSerializer(Gson gson)
	{
		this.gson = gson;
	}

	@Override
	public String serialize(XpSave value)
	{
		return gson.toJson(value);
	}

	@Override
	public XpSave deserialize(String s)
	{
		return gson.fromJson(s, XpSave.class);
	}
}