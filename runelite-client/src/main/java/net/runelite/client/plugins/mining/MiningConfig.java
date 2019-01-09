package net.runelite.client.plugins.mining;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("miningplugin")
public interface MiningConfig extends Config
{

	@ConfigItem(
		position = 1,
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "The time until mining session data is reset in minutes."
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		position = 2,
		keyName = "showRespawn",
		name = "Show ore respawn timers",
		description = "If the amount of seconds left until a ore respawns should be shown."
	)
	default boolean showRespawnTimer()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showAllRespawns",
		name = "Show timers for every ore",
		description = "Show timers for every ore mined in your nearby vicinity"
	)
	default boolean showAllRespawnTimers()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showMiningStats",
		name = "Show mining session stats",
		description = "Configures whether to display mining session stats"
	)
	default boolean showMiningStats()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "showMiningState",
		name = "Show current mining state",
		description = "Shows current mining state. 'You are currently mining' / 'You are currently NOT mining'"
	)
	default boolean showMiningState()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "disableInMLM",
		name = "Disable in MLM",
		description = "Disables the trackers if you're in the motherloade mine"
	)
	default boolean disableInMLM()
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "trackWorldRock",
		name = "World Tracker",
		description = "Tracks the respawn time of a certain ore as you switch worlds"
	)
	default MiningRockType.WorldRock trackWorldRock()
	{
		return MiningRockType.WorldRock.None;
	}

	@ConfigItem(
		position = 8,
		keyName = "trackTimeout",
		name = "Stop tracking (seconds)",
		description = "The time a world will keep on displaying after the ore has respawned in seconds"
	)
	default int trackTimeout()
	{
		return 60;
	}

}
