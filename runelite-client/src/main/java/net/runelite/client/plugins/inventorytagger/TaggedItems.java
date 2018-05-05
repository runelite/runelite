package net.runelite.client.plugins.inventorytagger;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

class TaggedItems
{
	@Getter
	public Color overlayColor;

	@Getter
	public String panelName;

	@Getter
	public Set<Integer> itemIdList = new HashSet<>();

	public TaggedItems(String panelName, Color overlayColor)
	{
		this.overlayColor = overlayColor;
		this.panelName = panelName;
	}

	public void addItem(Integer itemID)
	{
		itemIdList.add(itemID);
	}

	public void removeItem(Integer itemID)
	{
		itemIdList.remove(itemID);
	}

	public String getHexColor()
	{
		return String.format("%02x%02x%02x", overlayColor.getRed(), overlayColor.getGreen(), overlayColor.getBlue());
	}

	public void clearItem()
	{
		itemIdList.clear();
	}

	public boolean containsItem(Integer itemID)
	{
		return this.itemIdList.contains(itemID);
	}
}
