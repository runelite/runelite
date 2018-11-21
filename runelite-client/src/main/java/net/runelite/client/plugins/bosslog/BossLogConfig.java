package net.runelite.client.plugins.bosslog;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("bosslog")
public interface BossLogConfig extends Config
{
	@ConfigItem(
			keyName = "zulrahDrops",
			name = "Zulrah drops",
			description = "Stores boss log for Zulrah."
	)
	default String getZulrahDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "zulrahDrops",
			name = "",
			description = ""
	)
	void setZulrahDrops(String key);

	@ConfigItem(
		keyName = "vorkathDrops",
		name = "Vorkath drops",
		description = "Stores boss log for Vorkath."
	)
	default String getVorkathDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "vorkathDrops",
			name = "",
			description = ""
	)
	void setVorkathDrops(String key);

	@ConfigItem(
			keyName = "bandosDrops",
			name = "Bandos drops",
			description = "Stores boss log for Bandos."
	)
	default String getBandosDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "bandosDrops",
			name = "",
			description = ""
	)
	void setBandosDrops(String key);

	@ConfigItem(
			keyName = "zamorakDrops",
			name = "Zamorak drops",
			description = "Stores boss log for Zamorak."
	)
	default String getZamorakDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "zamorakDrops",
			name = "",
			description = ""
	)
	void setZamorakDrops(String key);

	@ConfigItem(
			keyName = "saradominDrops",
			name = "Saradomin drops",
			description = "Stores boss log for Saradomin."
	)
	default String getSaradominDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "saradominDrops",
			name = "",
			description = ""
	)
	void setSaradominDrops(String key);

	@ConfigItem(
			keyName = "armadylDrops",
			name = "Armadyl drops",
			description = "Stores boss log for Armadyl."
	)
	default String getArmadylDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "armadylDrops",
			name = "",
			description = ""
	)
	void setArmadylDrops(String key);

	@ConfigItem(
			keyName = "dksDrops",
			name = "DKs drops",
			description = "Stores boss log for Dagannoth Kings."
	)
	default String getDksDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "dksDrops",
			name = "",
			description = ""
	)
	void setDksDrops(String key);

	@ConfigItem(
			keyName = "shamanDrops",
			name = "Shaman drops",
			description = "Stores boss log for Lizardmen Shamans."
	)
	default String getShamanDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "shamanDrops",
			name = "",
			description = ""
	)
	void setShamanDrops(String key);
}