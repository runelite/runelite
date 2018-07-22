package net.runelite.client.plugins.invalue;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.*;

@ConfigGroup("inventoryvalue")
public interface InventoryValueConfig extends Config {
    // First configure low, medium, high, extreme, and insane margins.
    @ConfigItem(
            position = 0,
            keyName = "lowvaluelimit",
            name = "Low Value Amount",
            description = "Amount to define as low value."
    )
    default int getLValue() { return 1000; }

    @ConfigItem(
            position = 2,
            keyName = "medvaluelimit",
            name = "Medium Value Amount",
            description = "Amount to define as medium value."
    )
    default int getMValue() { return 10000; }

    @ConfigItem(
            position = 4,
            keyName = "highvaluelimit",
            name = "High Value Amount",
            description = "Amount to define as high value."
    )
    default int getHValue() { return 100000; }

    @ConfigItem(
            position = 6,
            keyName = "extremevaluelimit",
            name = "Extremely High Value Amount",
            description = "Amount to define as extremely high value."
    )
    default int getEValue() { return 1000000; }

    @ConfigItem(
            position = 8,
            keyName = "insanevaluelimit",
            name = "Insanely High Value Amount",
            description = "Amount to define as insanely high value."
    )
    default int getIValue() { return 10000000; }

    // Then configure low-insane value colors.
    @ConfigItem( //Low Value
            position = 1,
            keyName = "lowvaluecolor",
            name = "Low Value Stack Color",
            description = "Color for low valued item stacks."
    )
    default Color getLVColor() { return new Color(145, 145, 145); }

    @ConfigItem( //Medium Value
            position = 3,
            keyName = "medvaluecolor",
            name = "Medium Value Stack Color",
            description = "Color for medium valued item stacks."
    )
    default Color getMVColor() { return new Color(0, 143, 145); }

    @ConfigItem( //High Value
            position = 5,
            keyName = "highvaluecolor",
            name = "High Value Stack Color",
            description = "Color for high valued item stacks."
    )
    default Color getHVColor()
    {
        return new Color(213, 125, 0);
    }

    @ConfigItem( //Extreme Value
            position = 7,
            keyName = "extremevaluecolor",
            name = "Extreme Value Stack Color",
            description = "Color for extremely high valued item stacks."
    )
    default Color getEVColor()
    {
        return new Color(228, 0, 6);
    }

    @ConfigItem( //Insane Value
            position = 9,
            keyName = "insanevaluecolor",
            name = "Insane Value Stack Color",
            description = "Color for insanely high valued item stacks."
    )
    default Color getIVColor()
    {
        return new Color(255, 0, 240);
    }
}
