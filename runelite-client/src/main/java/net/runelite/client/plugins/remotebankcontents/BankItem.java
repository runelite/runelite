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

	public BankItem(String name, int id, int quantity, ItemManager itemManager)
	{
		this.quantity = quantity;
		this.itemManager = itemManager;
		this.name = name;
		this.id = id;
		this.image = itemManager.getImage(id, quantity, true);
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public AsyncBufferedImage getImage()
	{
		return image;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setId(int id)
	{
		this.id = id;
	}
}
