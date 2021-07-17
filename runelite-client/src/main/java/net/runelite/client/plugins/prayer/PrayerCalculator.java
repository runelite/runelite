package net.runelite.client.plugins.prayer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;

import java.time.LocalTime;

public class PrayerCalculator
{

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    static int prayerBonus;

    public static double getPrayerDrainRate(Client client)
    {
        double drainRate = 0.0;

        for (Prayer prayer : Prayer.values())
        {
            if (client.isPrayerActive(prayer))
            {
                drainRate += prayer.getDrainRate();
            }
        }

        return drainRate;
    }

    public static LocalTime getEstimatedTimeRemaining(Client client)
    {
        final double drainRate = getPrayerDrainRate(client);

        if (drainRate == 0)
        {
            return null;
        }

        final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);

        // Calculate how many seconds each prayer points last so the prayer bonus can be applied
        final double secondsPerPoint = (60.0 / drainRate) * (1.0 + (prayerBonus / 30.0));

        // Calculate the number of seconds left
        final double secondsLeft = (currentPrayer * secondsPerPoint);

        return LocalTime.ofSecondOfDay((long)secondsLeft);
    }

}
