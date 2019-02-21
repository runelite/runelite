package net.runelite.client.plugins.maxhit.bonus.requirements;

import net.runelite.api.Client;

public interface BonusRequirement {
    public boolean meetsRequirements(Client client);
}
