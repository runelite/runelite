package net.runelite.client.plugins.freezetimers;

import net.runelite.api.Actor;
import net.runelite.client.plugins.freezetimers.Spell;
import net.runelite.client.util.Text;

public class Barrage
extends Spell {
    public static final long DURATION = 20000L;
    private long remainingTime;
    private boolean isFinished;

    public Barrage(Actor affectedTarget, Actor caster) {
        super(affectedTarget, caster);
    }

    public long getRemainingTime() {
        long elapsedTime = System.currentTimeMillis() - this.startTime;
        if (Barrage.getDURATION() > elapsedTime) {
            return Barrage.getDURATION() - elapsedTime;
        }
        this.isFinished = true;
        return 0L;
    }

    public boolean equals(Object o) {
        if (o instanceof Barrage) {
            Barrage barrage = (Barrage)o;
            return Text.standardize(this.getAffectedTarget().getName()).equals(Text.standardize(((Barrage)o).getAffectedTarget().getName())) && this.getStartTime() == ((Barrage)o).getStartTime();
        }
        return false;
    }

    public static long getDURATION() {
        return 20000L;
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}

