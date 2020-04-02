package net.runelite.client.plugins.runecraftcounter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;
import org.slf4j.Logger;

import javax.inject.Singleton;
import java.time.Instant;

@Slf4j
@Singleton
public class RuneCraftCounterSession {

    public RuneCraftCounterSession() {
        totalCrafted = 0;
        fireRuneCrafted = 0;
        waterRuneCrafted = 0;
        airRuneCrafted = 0;
        earthRuneCrafted = 0;
        mindRuneCrafted = 0;
        bodyRuneCrafted = 0;
        deathRuneCrafted = 0;
        natureRuneCrafted = 0;
        chaosRuneCrafted = 0;
        lawRuneCrafted = 0;
        cosmicRuneCrafted = 0;
        bloodRuneCrafted = 0;
        soulRuneCrafted = 0;
        astralRuneCrafted = 0;
        wrathRuneCrafted = 0;
    }

    @Getter(AccessLevel.PACKAGE)
    private int totalCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int fireRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int waterRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int airRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int earthRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int mindRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int bodyRuneCrafted;

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
    private int bloodRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int soulRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int astralRuneCrafted;

    @Getter(AccessLevel.PACKAGE)
    private int wrathRuneCrafted;

    void incrementRunesCrafted(int runeId, int quantity)
    {
        switch (runeId)
        {
            case ItemID.FIRE_RUNE:
                fireRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.WATER_RUNE:
                waterRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.AIR_RUNE:
                airRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.EARTH_RUNE:
                earthRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.MIND_RUNE:
                mindRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.BODY_RUNE:
                bodyRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.DEATH_RUNE:
                deathRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.NATURE_RUNE:
                natureRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.CHAOS_RUNE:
                chaosRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.LAW_RUNE:
                lawRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.COSMIC_RUNE:
                cosmicRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.BLOOD_RUNE:
                bloodRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.SOUL_RUNE:
                soulRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.ASTRAL_RUNE:
                astralRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            case ItemID.WRATH_RUNE:
                wrathRuneCrafted += quantity;
                totalCrafted += quantity;
                break;

            default:
                log.debug("Invalid rune type specified. The rune count will not be incremented.");
        }
    }
}
