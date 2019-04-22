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
import lombok.Setter;

public enum  PlayerSpellEffect
{


    BARRAGE("Ice Barrage", 20000, false),
    BLITZ("Ice Blitz", 15000, false);

    @Getter
    private final String SPELL_NAME;
    @Getter
    private long startTime;
    @Getter
    private int duration;
    @Getter
    private boolean halvable;
    //private final BufferedImage SPELL_ICON;



    PlayerSpellEffect(String name, int duration, boolean halvable)
    {
        this.SPELL_NAME = name;
        this.duration = duration;
        this.halvable = halvable;
        this.startTime = System.currentTimeMillis();
    }
}
