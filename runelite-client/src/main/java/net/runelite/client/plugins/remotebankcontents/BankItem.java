package net.runelite.client.plugins.remotebankcontents;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.http.api.item.Item;

public class BankItem extends Item
{

	@Inject
	private final ItemManager itemManager;

	private String name;
	private int id;
	private AsyncBufferedImage image;
	private int quantity;

	@Inject
	private Client client;

	BankItem(int id, int quantity, ItemManager itemManager, Client client)
	{
		this.quantity = quantity;
		this.itemManager = itemManager;
		this.id = id;
		this.name = client.getItemDefinition(id).getName();
		this.client = client;
		this.image = itemManager.getImage(id, quantity, true);
	}

	int getQuantity()
	{
		if (name.equalsIgnoreCase("Bank Filler"))
		{
			quantity = 0;
		}
		return quantity;
	}

	void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	AsyncBufferedImage getImage()
	{
		return image;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public void setId(int id)
	{
		this.id = id;
	}

	boolean isTemplate()
	{
		return client.getItemDefinition(getId()).getPlaceholderTemplateId() != -1;
	}
}
