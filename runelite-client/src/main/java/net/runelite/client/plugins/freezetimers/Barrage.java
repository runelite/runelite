/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.freezetimers;

import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.client.util.Text;
import org.jetbrains.annotations.NotNull;

public class Barrage extends Spell
{


    @Getter
    public static final long DURATION = 20000;
    private long remainingTime;
    @Getter
    private boolean isFinished;


    public Barrage(Actor affectedTarget, Actor caster)
    {
        super(affectedTarget, caster);
    }

    public long getRemainingTime()
    {
        long elapsedTime = System.currentTimeMillis() - this.startTime;
        if (getDURATION() > elapsedTime)
        {
            return getDURATION() - elapsedTime;
        }
        else
        {
            this.isFinished = true;
            return 0;
        }
    }

    public boolean equals(Object o)
    {
        if (o instanceof Barrage)
        {
            Barrage barrage = (Barrage) o;
            if (Text.standardize(this.getAffectedTarget().getName()).equals(Text.standardize(((Barrage) o)
                    .getAffectedTarget().getName())) && this.getStartTime() == ((Barrage) o).getStartTime())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

}
