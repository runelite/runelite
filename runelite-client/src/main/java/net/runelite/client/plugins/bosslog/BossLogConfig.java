package net.runelite.client.plugins.bosslog;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("bosslog")
public interface BossLogConfig extends Config
{
	//ZULRAH
	@ConfigItem(
			keyName = "zulrahDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackZulrah",
			name = "Track Zulrah kills",
			description = "Configures whether or not Zulrah is tracked.",
			position = 0
	)
	default boolean trackZulrah()
	{
		return true;
	}

	//VORKATH
	@ConfigItem(
		keyName = "vorkathDrops",
		name = "",
		description = "",
		hidden = true
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
			keyName = "trackVorkath",
			name = "Track Vorkath kills",
			description = "Configures whether or not Vorkath is tracked.",
			position = 1
	)
	default boolean trackVorkath()
	{
		return true;
	}

	//CHAMBERS OF XERIC
	@ConfigItem(
			keyName = "coxDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getCoxDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "coxDrops",
			name = "",
			description = ""
	)
	void setCoxDrops(String key);
	@ConfigItem(
			keyName = "trackCOX",
			name = "Track Chambers of Xeric raids",
			description = "Configures whether or not Chambers of Xeric is tracked.",
			position = 1
	)
	default boolean trackCOX()
	{
		return true;
	}

	//THEATRE OF BLOOD
	@ConfigItem(
			keyName = "tobDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getTobDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "tobDrops",
			name = "",
			description = ""
	)
	void setTobDrops(String key);
	@ConfigItem(
			keyName = "trackTOB",
			name = "Track Theatre of Blood raids",
			description = "Configures whether or not Theatre of Blood is tracked.",
			position = 0
	)
	default boolean trackTOB()
	{
		return true;
	}

	//BANDOS
	@ConfigItem(
			keyName = "bandosDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackBandos",
			name = "Track General Graador kills",
			description = "Configures whether or not General Graador is tracked.",
			position = 0
	)
	default boolean trackBandos()
	{
		return true;
	}

	//ZAMORAK
	@ConfigItem(
			keyName = "zamorakDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackZamorak",
			name = "Track K'ril Tsutsaroth",
			description = "Configures whether or not K'ril Tsutsaroth is tracked.",
			position = 0
	)
	default boolean trackZamorak()
	{
		return true;
	}

	//SARADOMIN
	@ConfigItem(
			keyName = "saradominDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackSaradomin",
			name = "Track Commander Zilyana",
			description = "Configures whether or not Commander Zilyana is tracked.",
			position = 0
	)
	default boolean trackSaradomin()
	{
		return true;
	}

	//ARMADYL
	@ConfigItem(
			keyName = "armadylDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackArmadyl",
			name = "Track Kree'arra kills",
			description = "Configures whether or not Kree'arra is tracked.",
			position = 0
	)
	default boolean trackArmadyl()
	{
		return true;
	}

	@ConfigItem(
			keyName = "corpDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getCorpDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "corpDrops",
			name = "",
			description = ""
	)
	void setCorpDrops(String key);
	@ConfigItem(
			keyName = "trackCorp",
			name = "Track Corporeal Beast kills",
			description = "Configures whether or not Corporeal Beast is tracked.",
			position = 0
	)
	default boolean trackCorp()
	{
		return true;
	}

	//CERBERUS
	@ConfigItem(
			keyName = "cerberusDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getCerberusDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "cerberusDrops",
			name = "",
			description = ""
	)
	void setCerberusDrops(String key);
	@ConfigItem(
			keyName = "trackCerberus",
			name = "Track Cerberus kills",
			description = "Configures whether or not Cerberus is tracked.",
			position = 0
	)
	default boolean trackCerberus()
	{
		return true;
	}

	//ABYSSAL SIRE
	@ConfigItem(
			keyName = "sireDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getSireDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "sireDrops",
			name = "",
			description = ""
	)
	void setSireDrops(String key);
	@ConfigItem(
			keyName = "trackSire",
			name = "Track Abyssal Sire kills",
			description = "Configures whether or not Abyssal Sire is tracked.",
			position = 0
	)
	default boolean trackSire()
	{
		return true;
	}

	//Kraken
	@ConfigItem(
			keyName = "krakenDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getKrakenDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "krakenDrops",
			name = "",
			description = ""
	)
	void setKrakenDrops(String key);
	@ConfigItem(
			keyName = "trackKraken",
			name = "Track Kraken kills",
			description = "Configures whether or not Kraken is tracked.",
			position = 0
	)
	default boolean trackKraken()
	{
		return true;
	}

	//GROTESQUE GUARDIANS
	@ConfigItem(
			keyName = "groguarDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getGroguarDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "groguarDrops",
			name = "",
			description = ""
	)
	void setGroguarDrops(String key);
	@ConfigItem(
			keyName = "trackGroguar",
			name = "Track Grotesque Guardian kills",
			description = "Configures whether or not Grotesque Guardians are tracked.",
			position = 0
	)
	default boolean trackGroguar()
	{
		return true;
	}

	//THERMONUCULEAR SMOKE DEVIL
	@ConfigItem(
			keyName = "thermoDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getThermoDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "thermoDrops",
			name = "",
			description = ""
	)
	void setThermoDrops(String key);
	@ConfigItem(
			keyName = "trackThermo",
			name = "Track Thermonuclear Smoke Devil kills",
			description = "Configures whether or not Thermonuclear Smoke Devils are tracked.",
			position = 0
	)
	default boolean trackThermo()
	{
		return true;
	}

	//DAGANNOTH KINGS
	@ConfigItem(
			keyName = "dksDrops",
			name = "",
			description = "",
			hidden = true
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
			keyName = "trackDks",
			name = "Track Dagannoth King kills",
			description = "Configures whether or not Dagannoth Kings are tracked.",
			position = 0
	)
	default boolean trackDks()
	{
		return true;
	}

	//Kalphite Queen
	@ConfigItem(
			keyName = "kqDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getKqDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "kqDrops",
			name = "",
			description = ""
	)
	void setKqDrops(String key);
	@ConfigItem(
			keyName = "trackKQ",
			name = "Track Kalphite Queen kills",
			description = "Configures whether or not Kalphite Queen is tracked.",
			position = 0
	)
	default boolean trackKQ()
	{
		return true;
	}

	//CALLISTO
	@ConfigItem(
			keyName = "callistoDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getCallistoDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "callistoDrops",
			name = "",
			description = ""
	)
	void setCallistoDrops(String key);
	@ConfigItem(
			keyName = "trackCallisto",
			name = "Track Callisto kills",
			description = "Configures whether or not Callisto is tracked.",
			position = 0
	)
	default boolean trackCallisto()
	{
		return true;
	}

	//VET'ION
	@ConfigItem(
			keyName = "vetionDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getVetionDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "vetionDrops",
			name = "",
			description = ""
	)
	void setVetionDrops(String key);
	@ConfigItem(
			keyName = "trackVetion",
			name = "Track Vet'ion kills",
			description = "Configures whether or not Vet'ion is tracked.",
			position = 0
	)
	default boolean trackVetion()
	{
		return true;
	}

	//VENENATIS
	@ConfigItem(
			keyName = "venenatisDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getVenenatisDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "venenatisDrops",
			name = "",
			description = ""
	)
	void setVenenatisDrops(String key);
	@ConfigItem(
			keyName = "trackVenenatis",
			name = "Track Venenatis kills",
			description = "Configures whether or not Venenatis is tracked.",
			position = 0
	)
	default boolean trackVenenatis()
	{
		return true;
	}

	//Scorpia
	@ConfigItem(
			keyName = "scorpiaDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getScorpiaDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "scorpiaDrops",
			name = "",
			description = ""
	)
	void setScorpiaDrops(String key);
	@ConfigItem(
			keyName = "trackScorpia",
			name = "Track Scorpia kills",
			description = "Configures whether or not Scorpia is tracked.",
			position = 0
	)
	default boolean trackScorpia()
	{
		return true;
	}

	//CRAZY_ARCHAEOLOGIST
	@ConfigItem(
			keyName = "crazyArchDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getCrazyArchDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "scorpiaDrops",
			name = "",
			description = ""
	)
	void setCrazyArchDrops(String key);
	@ConfigItem(
			keyName = "trackCrazyArch",
			name = "Track Crazy Archaeologist kills",
			description = "Configures whether or not Crazy Archaeologist is tracked.",
			position = 0
	)
	default boolean trackCrazyArch()
	{
		return true;
	}

	//CHAOS FANATIC
	@ConfigItem(
			keyName = "chaosFanaticDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getChaosFanaticDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "chaosFanaticDrops",
			name = "",
			description = ""
	)
	void setChaosFanaticDrops(String key);
	@ConfigItem(
			keyName = "trackChaosFanatic",
			name = "Track Chaos Fanatic kills",
			description = "Configures whether or not Chaos Fanatic is tracked.",
			position = 0
	)
	default boolean trackChaosFanatic()
	{
		return true;
	}

	//SKOTIZO
	@ConfigItem(
			keyName = "skotizoDrops",
			name = "",
			description = "",
			hidden = true
	)
	default String getSkotizoDrops()
	{
		return "";
	}
	@ConfigItem(
			keyName = "skotizoDrops",
			name = "",
			description = ""
	)
	void setSkotizDrops(String key);
	@ConfigItem(
			keyName = "trackSkotizo",
			name = "Track Skotizo kills",
			description = "Configures whether or not Skotizo is tracked.",
			position = 0
	)
	default boolean trackSkotizo()
	{
		return true;
	}

	//LIZARDMEN SHAMAN
	@ConfigItem(
			keyName = "shamanDrops",
			name = "",
			description = "",
			hidden = true
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
	@ConfigItem(
			keyName = "trackShaman",
			name = "Track Lizardmen Shaman kills",
			description = "Configures whether or not Lizardmen Shamans are tracked.",
			position = 0
	)
	default boolean trackShaman()
	{
		return false;
	}
}