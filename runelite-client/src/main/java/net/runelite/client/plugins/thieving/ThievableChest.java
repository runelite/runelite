package net.runelite.client.plugins.thieving;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;

/**
 * ThievableChest represents a chest that the player can loot. This class contains an array of these chests that will
 * be enabled for timers.
 */
public class ThievableChest
{


	@Getter
	private final WorldPoint location;

	@Getter
	private final int chestIcon;

	@Getter
	private final Duration resetTime;

	public ThievableChest(WorldPoint loc, int chestIcon, Duration resetTime)
	{
		this.location = loc;
		this.chestIcon = chestIcon;
		this.resetTime = resetTime;
	}

	/**
	 * If a new chest needs to be added, simply add it to trackedChests
	 */
	public final static ThievableChest[] trackedChests = {
		// Chest (10 Coints)
		new ThievableChest(new WorldPoint(2673, 3307, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Ardougne east of food stall
		new ThievableChest(new WorldPoint(2612, 3314, 1), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Ardougne south of northern bank

		new ThievableChest(new WorldPoint(3188, 3962, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Relekka southwest house
		new ThievableChest(new WorldPoint(3189, 3962, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Relekka southwest house
		new ThievableChest(new WorldPoint(3193, 3962, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Relekka southwest house

		new ThievableChest(new WorldPoint(2630, 3655, 1), ItemID.COINS, Duration.ofSeconds((long) 3.5)), //Relekka southwest house

		new ThievableChest(new WorldPoint(3044, 3957, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), // Pirate's Hideout
		new ThievableChest(new WorldPoint(3044, 3951, 0), ItemID.COINS, Duration.ofSeconds((long) 3.5)), // Pirate's Hideout

		// Nature Rune
		new ThievableChest(new WorldPoint(2671, 3301, 1), ItemID.NATURE_RUNE, Duration.ofSeconds(8)), //Ardougne east of food stall
		new ThievableChest(new WorldPoint(2614, 3314, 1), ItemID.NATURE_RUNE, Duration.ofSeconds(8)), //Ardougne south of northern bank
		new ThievableChest(new WorldPoint(2668, 3693, 1), ItemID.NATURE_RUNE, Duration.ofSeconds(8)), //Relekka north of longhouse
		new ThievableChest(new WorldPoint(3042, 3949, 0), ItemID.NATURE_RUNE, Duration.ofSeconds(8)), // Pirate's Hideout

		// Isle of Souls
		new ThievableChest(new WorldPoint(2139, 9299, 0), ItemID.DARK_KEY, Duration.ofSeconds(0)), //Relekka north of longhouse

		// Chest (50 Coins)
		new ThievableChest(new WorldPoint(2671, 3299, 1), ItemID.COINS, Duration.ofSeconds(45)), // Ardougne east of food stall
		new ThievableChest(new WorldPoint(2035, 4649, 0), ItemID.COINS, Duration.ofSeconds(45)), // Mourner Tunnels
		new ThievableChest(new WorldPoint(3040, 3949, 0), ItemID.COINS, Duration.ofSeconds(45)), // Pirate's Hideout12

		// Steel Arrowtips
		new ThievableChest(new WorldPoint(2038, 4649, 0), ItemID.STEEL_ARROWTIPS, Duration.ofSeconds(75)), // Mourner Tunnels
		new ThievableChest(new WorldPoint(2650, 3659, 0), ItemID.STEEL_ARROWTIPS, Duration.ofSeconds(75)), // Ardougne Swensen's house
		new ThievableChest(new WorldPoint(2639, 3424, 0), ItemID.STEEL_ARROWTIPS, Duration.ofSeconds(75)), // Hemenster

		// Dorgesh-Kaan Average
		// * Floor 1
		new ThievableChest(new WorldPoint(2749, 5328, 0), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of Teggak
		new ThievableChest(new WorldPoint(2639, 5324, 0), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of Teggak
		new ThievableChest(new WorldPoint(2746, 5295, 0), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Southwest market
		new ThievableChest(new WorldPoint(2743, 5253, 0), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of range
		new ThievableChest(new WorldPoint(2695, 5304, 0), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // West of Ur-meg
		// * Floor 2
		new ThievableChest(new WorldPoint(2743, 5327, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of Nursery
		new ThievableChest(new WorldPoint(2743, 5324, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of Nursery
		new ThievableChest(new WorldPoint(2731, 5373, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Above range
		new ThievableChest(new WorldPoint(2707, 5275, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Above wire machine
		new ThievableChest(new WorldPoint(2696, 5315, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // South of Ferns
		new ThievableChest(new WorldPoint(2694, 5342, 1), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // North of Ferns
		// * Floor 3
		new ThievableChest(new WorldPoint(2746, 5350, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Zanik's bedroom
		new ThievableChest(new WorldPoint(2743, 5350, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Zanik's bedroom
		new ThievableChest(new WorldPoint(2737, 5295, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // North of attic Goblins
		new ThievableChest(new WorldPoint(2697, 5289, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Southwest
		new ThievableChest(new WorldPoint(2696, 5300, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // West
		new ThievableChest(new WorldPoint(2706, 5364, 2), ItemID.OIL_LANTERN, Duration.ofSeconds(90)), // Northwest

		// Blood Runes
		new ThievableChest(new WorldPoint(2586, 9734, 0), ItemID.BLOOD_RUNE, Duration.ofSeconds(120)), // Chaos Druid Tower
		new ThievableChest(new WorldPoint(2586, 9737, 0), ItemID.BLOOD_RUNE, Duration.ofSeconds(120)), // Chaos Druid Tower

		// Stone Chest
		new ThievableChest(new WorldPoint(1300, 10089, 0), ItemID.XERICIAN_FABRIC, Duration.ofSeconds(0)), // Lizardman Temple
		new ThievableChest(new WorldPoint(1302, 10087, 0), ItemID.XERICIAN_FABRIC, Duration.ofSeconds(0)), // Lizardman Temple
		new ThievableChest(new WorldPoint(1300, 10085, 0), ItemID.XERICIAN_FABRIC, Duration.ofSeconds(0)), // Lizardman Temple

		// Ardougne Castle
		new ThievableChest(new WorldPoint(2588, 3302, 1), ItemID.COINS, Duration.ofSeconds(500)), // Ardougne Castle (North)
		new ThievableChest(new WorldPoint(2588, 3291, 1), ItemID.COINS, Duration.ofSeconds(500)), // Ardougne Castle (South)

		// Dorgesh-Kaan Rich
		// * Floor 2
		new ThievableChest(new WorldPoint(2731, 5378, 1), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Above range
		new ThievableChest(new WorldPoint(2700, 5348, 1), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Southwest of Council chamber
		new ThievableChest(new WorldPoint(2703, 5348, 1), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Southwest of Council chamber
		// * Floor 3
		new ThievableChest(new WorldPoint(2731, 5368, 2), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Above Ur-tag
		new ThievableChest(new WorldPoint(2734, 5368, 2), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Above Ur-tag
		new ThievableChest(new WorldPoint(2745, 5359, 2), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // North of Zanik's bedroom
		new ThievableChest(new WorldPoint(2737, 5284, 2), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Attic goblins
		new ThievableChest(new WorldPoint(2739, 5261, 2), ItemID.SAPPHIRE, Duration.ofSeconds(300)), // Southeast of kitchen Attic

		// Rogues' Castle chest
		new ThievableChest(new WorldPoint(3283, 3946, 0), ItemID.DRAGONSTONE, Duration.ofSeconds(10)), // N - left
		new ThievableChest(new WorldPoint(3287, 3946, 0), ItemID.DRAGONSTONE, Duration.ofSeconds(10)), // N - right
		new ThievableChest(new WorldPoint(3297, 3940, 0), ItemID.DRAGONSTONE, Duration.ofSeconds(10)), // NE
	};

	/**
	 * ActiveChest represents a chest that is currently being tracked for timer updates
	 */
	public static class ActiveChest
	{
		@Getter
		@Setter
		private Instant startTime;

		@Getter
		@Setter
		private Duration timerDuration;

		@Getter
		@Setter
		private GameObject object;

		@Getter
		@Setter
		private int RegionID;

		@Getter
		@Setter
		private int iconID;

		@Getter
		@Setter
		private State state;


		enum State
		{
			READY,
			PLUNDERED,
			TRANS,
		}

		public ActiveChest(Instant startTime, Duration timerDuration, GameObject object, int regionID, int iconID, State state)
		{
			this.startTime = startTime;
			this.timerDuration = timerDuration;
			this.object = object;
			this.RegionID = regionID;
			this.iconID = iconID;
			this.state = state;
		}

		public double getRemainingTime()
		{
			if (timerDuration == null)
			{
				return 1;
			}
			Duration duration = Duration.between(startTime, Instant.now());
			return duration.compareTo(timerDuration) < 0 ? (double) duration.toMillis() / timerDuration.toMillis() : 1;
		}
	}

}
