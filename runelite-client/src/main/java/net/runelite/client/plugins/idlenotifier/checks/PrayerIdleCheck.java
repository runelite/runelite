package net.runelite.client.plugins.idlenotifier.checks;

import com.google.common.annotations.VisibleForTesting;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.Notifier;
import net.runelite.client.plugins.idlenotifier.IdleNotifierConfig;
import net.runelite.client.plugins.prayer.PrayerCalculator;

import java.time.LocalTime;
import java.util.function.Predicate;

public class PrayerIdleCheck extends IdleCheck
{

    private IdleNotifierConfig config;
    private Client client;

    public PrayerIdleCheck(Notifier notifier, IdleNotifierConfig config, Client client)
    {
        super(notifier);
        this.config = config;
        this.client = client;
    }

    @Override
    public boolean internalIdleCheck() {
        return isLowPrayerPoints.or(isLowPrayerTimeLeft).test(null);
    }

    @Override
    public String idleMessage() {
        return IdleMessages.LOW_PRAYER;
    }

    @VisibleForTesting
    final Predicate<Void> isLowPrayerPoints = x ->
        {
            if (config.getPrayerThreshold() > 0)
            {
                if (client.getRealSkillLevel(Skill.PRAYER) > config.getPrayerThreshold())
                {
                    return client.getBoostedSkillLevel(Skill.PRAYER) <= config.getPrayerThreshold();
                }
            }
            return false;
    };

    @VisibleForTesting
    final Predicate<Void> isLowPrayerTimeLeft = x ->
    {
        if (config.getPrayerTimeThreshold() > 0)
        {
            LocalTime timeLeft = PrayerCalculator.getEstimatedTimeRemaining(client);
            if (timeLeft != null)
            {
                LocalTime timeThreshold = LocalTime.ofSecondOfDay(config.getPrayerTimeThreshold());
                return timeLeft.isBefore(timeThreshold);
            }
        }
        return false;
    };

}
