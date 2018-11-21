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
			for (Item i : b.getDrops())
			{
				String itemData = "";
				itemData += i.getId() + " ";
				itemData += i.getQuantity() + " ";
				newData += itemData;
			}
			data = front + newData + back; //compile new data string
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
		List<Item> items = new ArrayList<>();
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
				items.add(new Item(ItemID, Quantity, "", 0));
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
	}
}
