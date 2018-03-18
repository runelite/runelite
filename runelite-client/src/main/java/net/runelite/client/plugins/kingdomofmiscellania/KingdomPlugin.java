package net.runelite.client.plugins.kingdomofmiscellania;

import com.google.common.eventbus.Subscribe;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Kingdom of Miscellania"
)
@Slf4j
public class KingdomPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private KingdomConfig config;

	@Inject
	ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	private final int[] KINGDOM_REGION = {9787, 9788, 9789, 10043, 10044, 10045, 10299, 10300, 10301};

	@Getter
	private int favor = -1, coffer = -1;

	@Provides
	KingdomConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KingdomConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		infoBoxManager.removeIf(t -> t instanceof KingdomCounter);
		if (!config.showOnlyInKingdom())
		{
			addKingdomInfobox();
		}
		else if (config.showWhenLow() && (isFavorLow(config.favorLessThanValue()) || isCofferLow(config.cofferLessThanValue())))
		{
			addKingdomInfobox();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		infoBoxManager.removeIf(t -> t instanceof KingdomCounter);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		favor = client.getSetting(Varbits.KINGDOM_FAVOR);
		coffer = client.getSetting(Varbits.KINGDOM_COFFER);
	}

	@Subscribe
	public void onRegionChanged(MapRegionChanged event)
	{
		infoBoxManager.removeIf(t -> t instanceof KingdomCounter);
		if (config.showOnlyInKingdom() && isInKingdom())
		{
			addKingdomInfobox();
		}
	}

	public boolean isInKingdom()
	{
		return Ints.indexOf(client.getMapRegions(), KINGDOM_REGION) >= 0;
	}

	private void addKingdomInfobox()
	{
		infoBoxManager.addInfoBox(new KingdomCounter(itemManager.getImage(ItemID.TEAK_PRIZE_CHEST), this));
	}

	private boolean isFavorLow(int lessThanValue)
	{
		return Integer.parseInt(KingdomCounter.getFavorPercent(favor).replace("%", "")) < lessThanValue;
	}

	private boolean isCofferLow(int lessThanValue)
	{
		return coffer < lessThanValue;
	}
}
