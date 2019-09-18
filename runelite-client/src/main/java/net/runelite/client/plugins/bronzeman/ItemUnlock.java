package net.runelite.client.plugins.bronzeman;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seth Davis
 * @Email <sethdavis321@gmail.com>
 * @Discord Reminisce#1707
 */
public class ItemUnlock
{

	@Getter
	private final int itemId;

	@Getter
	private long initTime;

	@Getter
	@Setter
	private int locationY;

	ItemUnlock(int itemId)
	{
		this.itemId = itemId;
		this.locationY = -20;
		this.initTime = -1;
	}

	/**
	 * Starts the displaying of the item unlock
	 **/
	public void display()
	{
		this.initTime = System.currentTimeMillis();
	}

	/**
	 * Returns whether or not an items has been displayed as unlocked yet
	 **/
	public boolean displayed()
	{
		return System.currentTimeMillis() > initTime + (5000);
	}

}
