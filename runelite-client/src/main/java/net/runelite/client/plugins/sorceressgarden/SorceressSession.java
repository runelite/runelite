package net.runelite.client.plugins.sorceressgarden;

import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ItemID;

@Singleton
public class SorceressSession
{
    @Getter(AccessLevel.PACKAGE)
    private int winterSqirk;

    @Getter(AccessLevel.PACKAGE)
    private int springSqirk;

    @Getter(AccessLevel.PACKAGE)
    private int autumnSqirk;

    @Getter(AccessLevel.PACKAGE)
    private int summerSqirk;

    void incrementSqirks(int sqirkID)
    {
        switch (sqirkID)
        {
            case ItemID.WINTER_SQIRK:
                winterSqirk++;
                break;
            case ItemID.SPRING_SQIRK:
                springSqirk++;
                break;
            case ItemID.AUTUMN_SQIRK:
                autumnSqirk++;
                break;
            case ItemID.SUMMER_SQIRK:
                summerSqirk++;
                break;
        }
    }
}