import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("damagetypeindicator")
public interface DamageTypeIndicatorConfig extends Config
{
    @ConfigItem(
        keyName = "meleeColor",
        name = "Melee Hit Color",
        description = "Color for melee hitsplats"
    )
    default Color meleeColor()
    {
        return Color.RED;
    }

    @ConfigItem(
        keyName = "rangeColor",
        name = "Range Hit Color",
        description = "Color for range hitsplats"
    )
    default Color rangeColor()
    {
        return Color.GREEN;
    }

    @ConfigItem(
        keyName = "magicColor",
        name = "Magic Hit Color",
        description = "Color for magic hitsplats"
    )
    default Color magicColor()
    {
        return Color.BLUE;
    }

    @ConfigItem(
        keyName = "typelessColor",
        name = "Typeless Hit Color",
        description = "Color for typeless hitsplats"
    )
    default Color typelessColor()
    {
        return Color.WHITE;
    }
}
