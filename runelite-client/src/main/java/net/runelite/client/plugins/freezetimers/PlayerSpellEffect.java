package net.runelite.client.plugins.freezetimers;

public enum PlayerSpellEffect {
    BARRAGE("Ice Barrage", 20000, false),
    BLITZ("Ice Blitz", 15000, false);
    
    private final String SPELL_NAME;
    private long startTime;
    private int duration;
    private boolean halvable;

    private PlayerSpellEffect(String name, int duration, boolean halvable) {
        this.SPELL_NAME = name;
        this.duration = duration;
        this.halvable = halvable;
        this.startTime = System.currentTimeMillis();
    }

    public String getSPELL_NAME() {
        return this.SPELL_NAME;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isHalvable() {
        return this.halvable;
    }
}

