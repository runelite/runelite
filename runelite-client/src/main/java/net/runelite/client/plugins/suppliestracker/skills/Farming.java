package net.runelite.client.plugins.suppliestracker.skills;


import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.suppliestracker.SuppliesTrackerPlugin;
import javax.inject.Singleton;
import static net.runelite.api.ItemID.*;

@Singleton
public class Farming
{
	private SuppliesTrackerPlugin plugin;
	private ItemManager itemManager;
	private int plantId = 0;
	private int compostId = 0;
	private int bucketId = 0;
	private final int[] ALLOTMENT_SEEDS = new int[]{POTATO_SEED, ONION_SEED, CABBAGE_SEED, TOMATO_SEED, SWEETCORN_SEED, STRAWBERRY_SEED, WATERMELON_SEED, SNAPE_GRASS_SEED};


	public Farming(SuppliesTrackerPlugin plugin, ItemManager itemManager)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
	}

	public void OnChatPlant(String message)
	{
		if (plantId <= 0)
		{
			return;
		}
		String name = itemManager.getItemDefinition(plantId).getName().toLowerCase();
		if ( name.contains(" seed") || name.contains(" sapling"))
		{
			for (int seedId: ALLOTMENT_SEEDS)
			{
				if (plantId == seedId)
				{
					plugin.buildEntries(plantId, 3);
					return;
				}
			}
			plugin.buildEntries(plantId);
		}
	}

	public void OnChatTreat(String message)
	{
		if (bucketId <= 0)
		{
			return;
		}
		String name = itemManager.getItemDefinition(bucketId).getName().toLowerCase();

		if (name.contains(" compost") || name.contains("plant cure"))
		{
			if (bucketId == BOTTOMLESS_COMPOST_BUCKET || bucketId == BOTTOMLESS_COMPOST_BUCKET_22997)
			{
				plugin.buildEntries(compostId);
			}
			else
			{
				plugin.buildEntries(bucketId);
			}
		}
	}



	public void setPlantId(int plantId)
	{
		this.plantId = plantId;
	}

	public void setBucketId(int bucketId)
	{
		this.bucketId = bucketId;
	}

	public void setEndlessBucket(String message)
	{
		if (message.toLowerCase().contains("ultracompost"))
		{
			compostId = ULTRACOMPOST;
		}
		else if (message.toLowerCase().contains("supercompost"))
		{
			compostId = SUPERCOMPOST;
		}
		else
		{
			compostId = COMPOST;
		}
	}
}
