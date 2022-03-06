package net.runelite.client.plugins.runecraftCounter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class RunecraftCounterSession
{

    public RunecraftCounterSession()
    {
        deathRuneCrafted = 0;
        natureRuneCrafted = 0;
        chaosRuneCrafted = 0;
        lawRuneCrafted = 0;
        cosmicRuneCrafted = 0;
        astralRuneCrafted = 0;
        wrathRuneCrafted = 0;
    }

    @Getter(AccessLevel.PACKAGE)
    private int deathRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int natureRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int chaosRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int lawRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int cosmicRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int astralRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int wrathRuneCrafted;

    void incrementRunesCrafted(int runeId, int quantity)
    {
        switch(runeId)
        {
            case ItemID.DEATH_RUNE:
                deathRuneCrafted += quantity;
                break;

            case ItemID.NATURE_RUNE:
                natureRuneCrafted += quantity;
                break;

            case ItemID.CHAOS_RUNE:
                chaosRuneCrafted += quantity;
                break;

            case ItemID.LAW_RUNE:
                lawRuneCrafted += quantity;
                break;

            case ItemID.COSMIC_RUNE:
                cosmicRuneCrafted += quantity;
                break;

            case ItemID.ASTRAL_RUNE:
                astralRuneCrafted += quantity;
                break;

            case ItemID.WRATH_RUNE:
                wrathRuneCrafted += quantity;
                break;

            default:
                log.debug("Invalid rune type specified. The rune count will not be incremented.");
        }
    }

    void reset() {
        deathRuneCrafted = 0;
        natureRuneCrafted = 0;
        chaosRuneCrafted = 0;
        lawRuneCrafted = 0;
        cosmicRuneCrafted = 0;
        astralRuneCrafted = 0;
        wrathRuneCrafted = 0;
    }
}