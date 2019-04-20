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

public abstract class Spell
{

    @Getter
    private final Actor affectedTarget;
    @Getter
    private final Actor caster;
    @Getter
    public final long startTime;
    private long remainingTime;
    @Getter
    private boolean isFinished;

    protected Spell(Actor affectedTarget, Actor caster)
    {
        this.affectedTarget = affectedTarget;
        this.caster = caster;
        startTime = System.currentTimeMillis();
    }
}
