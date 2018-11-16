package net.runelite.client.plugins.hotkeys;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("hotkeys")
public interface HotkeysConfig extends Config
{
	@ConfigItem(
		keyName = "f1",
		name = "F1-key",
		description = "Set your new F1-key",
		position = 0
	)

	default Keybind f1()
	{
		return new Keybind(KeyEvent.VK_F1, 0);
	}

	@ConfigItem(
		keyName = "f2",
		name = "F2-key",
		description = "Set your new F2-key",
		position = 1
	)

	default Keybind f2()
	{
		return new Keybind(KeyEvent.VK_F2, 0);
	}

	@ConfigItem(
		keyName = "f3",
		name = "F3-key",
		description = "Set your new F3-key",
		position = 2
	)

	default Keybind f3()
	{
		return new Keybind(KeyEvent.VK_F3, 0);
	}

	@ConfigItem(
		keyName = "f4",
		name = "F4-key",
		description = "Set your new F4-key",
		position = 3
	)

	default Keybind f4()
	{
		return new Keybind(KeyEvent.VK_F4, 0);
	}

	@ConfigItem(
		keyName = "f5",
		name = "F5-key",
		description = "Set your new F5-key",
		position = 4
	)

	default Keybind f5()
	{
		return new Keybind(KeyEvent.VK_F5, 0);
	}
	@ConfigItem(
		keyName = "f6",
		name = "F6-key",
		description = "Set your new F6-key",
		position = 5
	)

	default Keybind f6()
	{
		return new Keybind(KeyEvent.VK_F6, 0);
	}
	@ConfigItem(
		keyName = "f7",
		name = "F7-key",
		description = "Set your new F7-key",
		position = 6
	)

	default Keybind f7()
	{
		return new Keybind(KeyEvent.VK_F7, 0);
	}

	@ConfigItem(
		keyName = "f8",
		name = "F8-key",
		description = "Set your new F8-key",
		position = 7
	)

	default Keybind f8()
	{
		return new Keybind(KeyEvent.VK_F8, 0);
	}

	@ConfigItem(
		keyName = "f9",
		name = "F9-key",
		description = "Set your new F9-key",
		position = 8
	)

	default Keybind f9()
	{
		return new Keybind(KeyEvent.VK_F9, 0);
	}

	@ConfigItem(
		keyName = "f10",
		name = "F10-key",
		description = "Set your new F10-key",
		position = 9
	)

	default Keybind f10()
	{
		return new Keybind(KeyEvent.VK_F10, 0);
	}

	@ConfigItem(
		keyName = "f11",
		name = "F11-key",
		description = "Set your new F11-key",
		position = 10
	)

	default Keybind f11()
	{
		return new Keybind(KeyEvent.VK_F11, 0);
	}

	@ConfigItem(
		keyName = "f12",
		name = "F12-key",
		description = "Set your new F12-key",
		position = 11
	)

	default Keybind f12()
	{
		return new Keybind(KeyEvent.VK_F12, 0);
	}
}
