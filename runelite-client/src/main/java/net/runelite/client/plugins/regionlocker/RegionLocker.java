/*
 * Copyright (c) 2019, Slay to Stay <https://github.com/slaytostay>
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
package net.runelite.client.plugins.regionlocker;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.util.Text;

public class RegionLocker
{
	private final Client client;
	private final RegionLockerConfig config;
	private final ConfigManager configManager;

	@Getter
	private static Map<String, RegionTypes> regions = new HashMap<>();

	public static boolean renderLockedRegions;
	public static Color grayColor;
	public static int grayAmount;
	public static boolean hardBorder;
	private static boolean unlockReamls;
	private static boolean unlockUnderground;

	RegionLocker(Client client, RegionLockerConfig config, ConfigManager configManager)
	{
		this.client = client;
		this.config = config;
		this.configManager = configManager;
		readConfig();
	}

	private List<String> StringToList(String s)
	{
		List<String> regs;
		if (s.isEmpty())
			regs = new ArrayList<>();
		else
			regs = new ArrayList<>(Text.fromCSV(s));
		return regs;
	}

	public void readConfig()
	{
		renderLockedRegions = config.renderLockedRegions();
		unlockReamls = config.unlockRealms();
		unlockUnderground = config.unlockUnderground();
		grayColor = config.shaderGrayColor();
		grayAmount = config.shaderGrayAmount().getAlpha();
		hardBorder = config.hardBorder();

		regions.clear();

		String unlockedString = config.unlockedRegions();
		List<String> unlockedRegions = StringToList(unlockedString);
		setRegions(unlockedRegions, RegionTypes.UNLOCKED);


		setRegions(StringToList(config.dropdownRegions().getRegions()), RegionTypes.UNLOCKED);

		String unlockableString = config.unlockableRegions();
		List<String> unlockableRegions = StringToList(unlockableString);
		setRegions(unlockableRegions, RegionTypes.UNLOCKABLE);

		String blacklistedString = config.blacklistedRegions();
		List<String> blacklistedRegions = StringToList(blacklistedString);
		setRegions(blacklistedRegions, RegionTypes.BLACKLISTED);
	}

	private void setRegions(List<String> regs, RegionTypes type)
	{
		for (String id : regs)
		{
			regions.put(id, type);
		}
	}

	private void setConfig()
	{
		List<String> unlockedRegions = new ArrayList<>();
		List<String> unlockableRegions = new ArrayList<>();
		List<String> blacklistedRegions = new ArrayList<>();

		regions.entrySet().forEach(e ->
		{
			if (e.getValue() == RegionTypes.UNLOCKED) unlockedRegions.add(e.getKey());
			if (e.getValue() == RegionTypes.UNLOCKABLE) unlockableRegions.add(e.getKey());
			if (e.getValue() == RegionTypes.BLACKLISTED) blacklistedRegions.add(e.getKey());
		});

		String csv = Text.toCSV(unlockedRegions);
		configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockedRegions", csv);

		csv = Text.toCSV(unlockableRegions);
		configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "unlockableRegions", csv);

		csv = Text.toCSV(blacklistedRegions);
		configManager.setConfiguration(RegionLockerPlugin.CONFIG_KEY, "blacklistedRegions", csv);
	}

	public void addRegion(int regionId)
	{
		String id = Integer.toString(regionId);
		RegionTypes type = regions.get(id);
		if (type == null)
			regions.put(id, RegionTypes.UNLOCKABLE);
		else if (type == RegionTypes.UNLOCKABLE)
			regions.put(id, RegionTypes.UNLOCKED);
		else
			regions.remove(id);
		setConfig();
	}

	public void blockRegion(int regionId)
	{
		String id = Integer.toString(regionId);
		RegionTypes type = regions.get(id);
		if (type != RegionTypes.BLACKLISTED)
			if (type == null) regions.put(id, RegionTypes.BLACKLISTED);
			else regions.replace(id, RegionTypes.BLACKLISTED);
		else
			regions.remove(id);
		setConfig();
	}

	public static RegionTypes getType(int regionId)
	{
		String id = Integer.toString(regionId);
		int y = getY(regionId);
		if (unlockReamls && y >= 4160 && y < 5952) return RegionTypes.UNLOCKED;
		if (unlockUnderground && y >= 8960) return RegionTypes.UNLOCKED;
		if (regions == null) return null;
		return regions.get(id);
	}

	public static boolean hasRegion(int regionId)
	{
		RegionTypes type = getType(regionId);
		if (type == null) return false;
		return type == RegionTypes.UNLOCKED;
	}

	public static boolean isUnlockable(int regionId)
	{
		RegionTypes type = getType(regionId);
		if (type == null) return false;
		return type == RegionTypes.UNLOCKABLE;
	}

	public static boolean isBlacklisted(int regionId)
	{
		RegionTypes type = getType(regionId);
		if (type == null) return false;
		return type == RegionTypes.BLACKLISTED;
	}


	public static int getX(int id)
	{
		return ((id >> 8) << 6);
	}

	public static int getY(int id)
	{
		return ((id & 255) << 6);
	}
}
