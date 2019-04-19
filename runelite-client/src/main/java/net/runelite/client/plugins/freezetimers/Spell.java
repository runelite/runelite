package net.runelite.client.plugins.freezetimers;

import net.runelite.api.Actor;

public abstract class Spell {
    private final Actor affectedTarget;
    private final Actor caster;
    public final long startTime;
    private long remainingTime;
    private boolean isFinished;

    protected Spell(Actor affectedTarget, Actor caster) {
        this.affectedTarget = affectedTarget;
        this.caster = caster;
        this.startTime = System.currentTimeMillis();
    }

    public Actor getAffectedTarget() {
        return this.affectedTarget;
    }

    public Actor getCaster() {
        return this.caster;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isFinished() {
        return this.isFinished;
    }
}

