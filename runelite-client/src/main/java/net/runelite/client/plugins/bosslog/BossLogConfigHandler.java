package net.runelite.client.plugins.bosslog;

import net.runelite.api.Client;
import net.runelite.client.plugins.bosslog.enums.Bosses;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

class BossLogConfigHandler
{
	private String player;
	private final BossLogConfig config;

	BossLogConfigHandler(BossLogConfig config, Client client)
	{
		this.config = config;
		this.player = client.getUsername() + "/";
	}

	void write(Boss b)
	{
		String data = getBossData(b.getBoss());
		if (data.contains(player))
		{
			String front = data.substring(0, data.indexOf(" ", data.indexOf(player)) + 1); //substr after name
			String back = data.substring(data.indexOf('|', data.indexOf(player))); //substr starting at |
			String newData = ""; //updated data to insert

			newData += b.getKC() + " "; //insert KC
			StringBuilder sb = new StringBuilder(newData);
			for (BossLogItem i : b.getDrops())
			{
				String itemData = "";
				itemData += i.getId() + " ";
				itemData += i.getQuantity() + " ";
				sb.append(itemData);
			}
			data = front + sb + back; //compile new data string
			setBossData(data, b.getBoss());
		}
		else
		{
			data += ' ' + player + ' ' + 0 + " |"; //init new player
			setBossData(data, b.getBoss());
		}
	}

	Boss read(Bosses b)
	{
		String data;
		List<BossLogItem> items = new ArrayList<>();
		int KC = 0;
		data = getBossData(b);

		if (data.contains(player))
		{
			data = data.substring(data.indexOf(player)); //fetch from current player
			data = data.substring(data.indexOf(" ") + 1); //Slide next
			KC = parseInt(data.substring(0,
					data.indexOf(" "))); //grab KC
			data = data.substring(data.indexOf(" ") + 1); //Slide next

			while (data.charAt(0) != '|') //grab items until end of player data
			{
				int ItemID = parseInt(data.substring(0, data.indexOf(" ")));
				data = data.substring(data.indexOf(" ") + 1); //slide next
				int Quantity = parseInt(data.substring(0, data.indexOf(" ")));
				data = data.substring(data.indexOf(" ") + 1); //slide next
				items.add(new BossLogItem(ItemID, Quantity, "", 0));
			}
		}
		else
		{
			write(new Boss(b, KC, items));
		}

		return new Boss(b, KC, items);
	}

	private String getBossData(Bosses b)
	{
		if (b == Bosses.ZULRAH)
		{
			return config.getZulrahDrops();
		}
		else if (b == Bosses.VORKATH)
		{
			return config.getVorkathDrops();
		}
		else if (b == Bosses.BANDOS)
		{
			return config.getBandosDrops();
		}
		else if (b == Bosses.ZAMORAK)
		{
			return config.getZamorakDrops();
		}
		else if (b == Bosses.SARADOMIN)
		{
			return config.getSaradominDrops();
		}
		else if (b == Bosses.ARMADYL)
		{
			return config.getArmadylDrops();
		}
		else if (b == Bosses.DAGANNOTH_KINGS)
		{
			return config.getDksDrops();
		}
		else if (b == Bosses.SHAMAN)
		{
			return config.getShamanDrops();
		}
		else if (b == Bosses.TOB)
		{
			return config.getTobDrops();
		}
		else if (b == Bosses.COX)
		{
			return config.getCoxDrops();
		}
		else if (b == Bosses.ABYSSAL_SIRE)
		{
			return config.getSireDrops();
		}
		else if (b == Bosses.CERBERUS)
		{
			return config.getCerberusDrops();
		}
		else if (b == Bosses.THERM_SMOKE_DEVIL)
		{
			return config.getThermoDrops();
		}
		else if (b == Bosses.KRAKEN)
		{
			return config.getKrakenDrops();
		}
		else if (b == Bosses.CALLISTO)
		{
			return config.getCallistoDrops();
		}
		else if (b == Bosses.VENENATIS)
		{
			return config.getVenenatisDrops();
		}
		else if (b == Bosses.VETION)
		{
			return config.getVetionDrops();
		}
		else if (b == Bosses.CRAZY_ARCHAEOLOGIST)
		{
			return config.getCrazyArchDrops();
		}
		else if (b == Bosses.SCORPIA)
		{
			return config.getScorpiaDrops();
		}
		else if (b == Bosses.CHAOS_FANATIC)
		{
			return config.getChaosFanaticDrops();
		}
		else if (b == Bosses.KALPHITE_QUEEN)
		{
			return config.getKqDrops();
		}
		else if (b == Bosses.CORP)
		{
			return config.getCorpDrops();
		}
		else if (b == Bosses.GRO_GUAR)
		{
			return config.getGroguarDrops();
		}
		else if (b == Bosses.SKOTIZO)
		{
			return config.getSkotizoDrops();
		}
		return "";
	}

	private void setBossData(String data, Bosses b)
	{
		if (b == Bosses.ZULRAH)
		{
			config.setZulrahDrops(data);
		}
		else if (b == Bosses.VORKATH)
		{
			config.setVorkathDrops(data);
		}
		else if (b == Bosses.BANDOS)
		{
			config.setBandosDrops(data);
		}
		else if (b == Bosses.ZAMORAK)
		{
			config.setZamorakDrops(data);
		}
		else if (b == Bosses.SARADOMIN)
		{
			config.setSaradominDrops(data);
		}
		else if (b == Bosses.ARMADYL)
		{
			config.setArmadylDrops(data);
		}
		else if (b == Bosses.DAGANNOTH_KINGS)
		{
			config.setDksDrops(data);
		}
		else if (b == Bosses.SHAMAN)
		{
			config.setShamanDrops(data);
		}
		else if (b == Bosses.TOB)
		{
			config.setTobDrops(data);
		}
		else if (b == Bosses.COX)
		{
			config.setCoxDrops(data);
		}
		else if (b == Bosses.ABYSSAL_SIRE)
		{
			config.setSireDrops(data);
		}
		else if (b == Bosses.CERBERUS)
		{
			config.setCerberusDrops(data);
		}
		else if (b == Bosses.THERM_SMOKE_DEVIL)
		{
			config.setThermoDrops(data);
		}
		else if (b == Bosses.KRAKEN)
		{
			config.setKrakenDrops(data);
		}
		else if (b == Bosses.CALLISTO)
		{
			config.setCallistoDrops(data);
		}
		else if (b == Bosses.VENENATIS)
		{
			config.setVenenatisDrops(data);
		}
		else if (b == Bosses.VETION)
		{
			config.setVetionDrops(data);
		}
		else if (b == Bosses.CRAZY_ARCHAEOLOGIST)
		{
			config.setCrazyArchDrops(data);
		}
		else if (b == Bosses.SCORPIA)
		{
			config.setScorpiaDrops(data);
		}
		else if (b == Bosses.CHAOS_FANATIC)
		{
			config.setChaosFanaticDrops(data);
		}
		else if (b == Bosses.KALPHITE_QUEEN)
		{
			config.setKqDrops(data);
		}
		else if (b == Bosses.CORP)
		{
			config.setCorpDrops(data);
		}
		else if (b == Bosses.GRO_GUAR)
		{
			config.setGroguarDrops(data);
		}
		else if (b == Bosses.SKOTIZO)
		{
			config.setSkotizDrops(data);
		}
	}
}
