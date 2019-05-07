/*
 * Copyright (c) 2018, Fluffeh <berserkfluff@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.flinching;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;

public class FlinchingTarget
{
    private int currentDisplayLength = 5400;

    private boolean usingHitDelay = false;

    private int displayLength = 5400;
    private int displayHitReceivedLength = 6600;
    private Instant lastAttacked;

    public boolean isActive = false;

    @Getter
    private int objectId;
    private NPC targetObject;

    @Getter
    public WorldPoint worldLocation;

    public FlinchingTarget(NPC target)
    {
        isActive = true;

        this.targetObject = target;
        this.lastAttacked = Instant.now();
        this.objectId = target.getId();
        this.worldLocation = target.getWorldLocation();
    }

    public void TargetHit()
    {
        boolean shouldHit = true;
        if(usingHitDelay)
        {
            if(GetRemainingTime() > displayLength)
            {
                shouldHit = false;
            }
        }

        if(shouldHit)
        {
            lastAttacked = Instant.now();

            usingHitDelay = false;
            currentDisplayLength = displayLength;
        }
    }

    public double GetRemainingTimePercent()
    {
        double remainingTime = GetRemainingTime();
        double timePercent = remainingTime / currentDisplayLength;
        if(timePercent < 0)
        {
            timePercent = 0;
        }
        else if(timePercent > 1)
        {
            timePercent = 1;
        }

        return(timePercent);
    }

    private double GetRemainingTime()
    {
        Duration duration = Duration.between(lastAttacked, Instant.now());
        return( (currentDisplayLength - ((double)duration.toMillis())));
    }

    public void Tick()
    {
        if(targetObject == null)
        {
            isActive = false;
        }
        else
        {
            worldLocation = targetObject.getWorldLocation();

            double remainingTime = GetRemainingTime();
            if(remainingTime <= 0)
            {
                isActive = false;
            }
        }
    }

    public void SetDelayTime(int delayTime, int delayHitReceivedTime)
    {
        displayLength = delayTime;
        displayHitReceivedLength = delayHitReceivedTime;

        if(usingHitDelay)
        {
            currentDisplayLength = displayHitReceivedLength;
        }
        else
        {
            currentDisplayLength = displayLength;
        }
    }

    public void PlayerHit()
    {
        usingHitDelay = true;
        currentDisplayLength = displayHitReceivedLength;

        lastAttacked = Instant.now();
    }
}