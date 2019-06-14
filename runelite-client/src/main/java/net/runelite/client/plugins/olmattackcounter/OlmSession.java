package net.runelite.client.plugins.olmattackcounter;

import lombok.AccessLevel;
import lombok.Getter;

public class OlmSession {
    @Getter(AccessLevel.PACKAGE)
    private int rangeCounter;
    @Getter(AccessLevel.PACKAGE)
    private int mageCounter;
    @Getter(AccessLevel.PACKAGE)
    private int acidDripCounter;
    @Getter(AccessLevel.PACKAGE)
    private int acidSprayCounter;
    @Getter(AccessLevel.PACKAGE)
    private int flameWallCounter;
    @Getter(AccessLevel.PACKAGE)
    private int burnCounter;
    @Getter(AccessLevel.PACKAGE)
    private int fallingCrystalCounter;
    @Getter(AccessLevel.PACKAGE)
    private int bombCounter;
    @Getter(AccessLevel.PACKAGE)
    private int smiteCounter;
    @Getter(AccessLevel.PACKAGE)
    private int switchCounter;

    void increaseRangeAmount()
    {
        this.rangeCounter++;
    }

    void increaseMageAmount()
    {
        this.mageCounter++;
    }

    void increaseDripAmount()
    {
        this.acidDripCounter++;
    }

    void increaseSprayAmount()
    {
        this.acidSprayCounter++;
    }

    void increaseWallAmount()
    {
        this.flameWallCounter++;
    }

    void increaseBurnAmount()
    {
        this.burnCounter++;
    }

    void increaseFallAmount()
    {
        this.fallingCrystalCounter++;
    }

    void increaseBombAmount()
    {
        this.bombCounter++;
    }

    void increaseSmiteAmount()
    {
        this.smiteCounter++;
    }

    void increaseSwitchAmount()
    {
        this.switchCounter++;
    }



}
