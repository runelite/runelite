package net.runelite.client.plugins.raids3Util;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("1Up Utility")
public interface OneUpUtilityConfig extends Config {
  @ConfigItem(
      position = 1,
      keyName = "Inventory Tab",
      name = "Inventory Tab",
      description = "The key which will bind Inventory Tab."
  )
  default ModifierlessKeybind InventoryTab() {
    return new ModifierlessKeybind(27, 0);
  }

  @ConfigItem(
      position = 2,
      keyName = "Prayer Tab",
      name = "Prayer Tab",
      description = "The key which will bind Prayer Tab."
  )
  default ModifierlessKeybind PrayerTab() {
    return new ModifierlessKeybind(116, 0);
  }

  @ConfigItem(
      position = 3,
      keyName = "Spell Tab",
      name = "Spell Tab",
      description = "The key which will bind Spell Tab."
  )
  default ModifierlessKeybind SpellTab() {
    return new ModifierlessKeybind(117, 0);
  }

  @ConfigItem(
      position = 4,
      keyName = "Combat Tab",
      name = "Combat Tab",
      description = "The key which will bind Combat Tab."
  )
  default ModifierlessKeybind SpecTab() {
    return new ModifierlessKeybind(112, 0);
  }
}