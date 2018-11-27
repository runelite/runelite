package net.runelite.client.plugins.Flinching;

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

    FlinchingTarget(NPC target)
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