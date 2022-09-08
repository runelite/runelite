/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2020, Anthony Alves
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

package net.runelite.client.plugins.gauntletextended.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.util.Text;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig.ResourceFilter;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Singleton
public class ResourceManager
{
	private static final int NORMAL_GAUNTLET_REGION_ID = 7512;
	private static final int CORRUPTED_GAUNTLET_REGION_ID = 7768;

	private static final String MESSAGE_UNTRADEABLE_DROP = "Untradeable drop: ";

	private static final Pattern PATTERN_RESOURCE_DROP = Pattern.compile("((?<quantity>\\d+) x )?(?<name>.+)");

	@Inject
	private Client client;

	@Inject
	private GauntletExtendedPlugin plugin;

	@Inject
	private GauntletExtendedConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	private final Map<Resource, ResourceCounter> resources = new HashMap();

	private Region region = Region.UNKNOWN;

	private String prefix;

	public void init()
	{
		prefix = isLootVarbitSet() ? MESSAGE_UNTRADEABLE_DROP : getNamedDropMessage();
		region = getRegion();
		createCustomCounters();
	}

	public void reset()
	{
		prefix = null;
		region = Region.UNKNOWN;

		resources.clear();

		infoBoxManager.removeIf(ResourceCounter.class::isInstance);
	}

	public void parseChatMessage(String chatMessage)
	{
		if (config.resourceTracker() == ResourceFilter.OFF || region == Region.UNKNOWN || prefix == null)
		{
			return;
		}

		chatMessage = Text.removeTags(chatMessage);

		if (chatMessage.startsWith(prefix))
		{
			chatMessage = chatMessage.replace(prefix, "");

			processNpcResource(chatMessage);
		}
		else
		{
			processSkillResource(chatMessage);
		}
	}

	private void processNpcResource(final String chatMessage)
	{
		final Matcher matcher = PATTERN_RESOURCE_DROP.matcher(chatMessage);

		if (!matcher.matches())
		{
			return;
		}

		final String itemName = matcher.group("name");

		if (itemName == null)
		{
			return;
		}

		final Resource resource = Resource.fromName(itemName, region == Region.CORRUPTED);

		if (resource == null ||
			(config.resourceTracker() == ResourceFilter.CUSTOM && !resources.containsKey(resource)) ||
			(config.resourceTracker() == ResourceFilter.BASIC && isNonBasicResource(resource)))
		{
			return;
		}

		final String quantity = matcher.group("quantity");
		final int itemCount = quantity != null ? Integer.parseInt(quantity) : 1;

		processResource(resource, itemCount);
	}

	private void processSkillResource(final String chatMessage)
	{
		final Map<Resource, Integer> mapping = Resource.fromPattern(chatMessage, region == Region.CORRUPTED);

		if (mapping == null)
		{
			return;
		}

		final Resource resource = mapping.keySet().iterator().next();

		if (config.resourceTracker() == ResourceFilter.CUSTOM && !resources.containsKey(resource))
		{
			return;
		}

		final int itemCount = mapping.get(resource);

		processResource(resource, itemCount);
	}

	private void processResource(final Resource resource, final int itemCount)
	{
		if (!resources.containsKey(resource))
		{
			initResource(resource, itemCount);
		}
		else
		{
			ResourceCounter counter = resources.get(resource);
			if (config.resourceTracker() == ResourceFilter.CUSTOM)
			{
				counter.decrementCount(itemCount);
			}
			else
			{
				counter.incrementCount(itemCount);
			}
		}
	}

	private void initResource(final Resource resource, final int itemCount)
	{
		final ResourceCounter counter = new ResourceCounter(plugin, resource,
			itemManager.getImage(resource.getItemId()), itemCount);

		resources.put(resource, counter);
		infoBoxManager.addInfoBox(counter);
	}

	private void createCustomCounters()
	{
		if (config.resourceTracker() != ResourceFilter.CUSTOM || region == Region.UNKNOWN)
		{
			return;
		}

		final int ore = config.resourceOre();
		final int bark = config.resourceBark();
		final int tirinum = config.resourceTirinum();
		final int grym = config.resourceGrym();
		final int frame = config.resourceFrame();
		final int fish = config.resourcePaddlefish();
		final int shard = config.resourceShard();
		final boolean bowstring = config.resourceBowstring();
		final boolean spike = config.resourceSpike();
		final boolean orb = config.resourceOrb();

		final boolean corrupted = region == Region.CORRUPTED;

		if (ore > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_ORE : Resource.CRYSTAL_ORE, ore);
		}
		if (bark > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_PHREN_BARK : Resource.PHREN_BARK, bark);
		}
		if (tirinum > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_LINUM_TIRINUM : Resource.LINUM_TIRINUM, tirinum);
		}
		if (grym > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_GRYM_LEAF : Resource.GRYM_LEAF, grym);
		}
		if (frame > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_WEAPON_FRAME : Resource.WEAPON_FRAME, frame);
		}
		if (fish > 0)
		{
			initResource(Resource.RAW_PADDLEFISH, fish);
		}
		if (shard > 0)
		{
			initResource(corrupted ? Resource.CORRUPTED_SHARDS : Resource.CRYSTAL_SHARDS, shard);
		}
		if (bowstring)
		{
			initResource(corrupted ? Resource.CORRUPTED_BOWSTRING : Resource.CRYSTALLINE_BOWSTRING, 1);
		}
		if (spike)
		{
			initResource(corrupted ? Resource.CORRUPTED_SPIKE : Resource.CRYSTAL_SPIKE, 1);
		}
		if (orb)
		{
			initResource(corrupted ? Resource.CORRUPTED_ORB : Resource.CRYSTAL_ORB, 1);
		}
	}

	private String getNamedDropMessage()
	{
		final Player player = client.getLocalPlayer();

		if (player == null)
		{
			return null;
		}

		return player.getName() + " received a drop: ";
	}

	private boolean isLootVarbitSet()
	{
		return client.getVarbitValue(5399) == 1 &&
			client.getVarbitValue(5402) == 1;
	}

	private Region getRegion()
	{
		final int regionId = client.getMapRegions()[0];

		if (regionId == CORRUPTED_GAUNTLET_REGION_ID)
		{
			return Region.CORRUPTED;
		}

		if (regionId == NORMAL_GAUNTLET_REGION_ID)
		{
			return Region.NORMAL;
		}

		return Region.UNKNOWN;
	}

	private static boolean isNonBasicResource(final Resource resource)
	{
		switch (resource)
		{
			case TELEPORT_CRYSTAL:
			case CORRUPTED_TELEPORT_CRYSTAL:
			case WEAPON_FRAME:
			case CORRUPTED_WEAPON_FRAME:
			case CRYSTALLINE_BOWSTRING:
			case CORRUPTED_BOWSTRING:
			case CRYSTAL_SPIKE:
			case CORRUPTED_SPIKE:
			case CRYSTAL_ORB:
			case CORRUPTED_ORB:
				return true;
			default:
				return false;
		}
	}

	private enum Region
	{
		UNKNOWN, NORMAL, CORRUPTED
	}
}
