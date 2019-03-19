package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;

public interface Requirement {
    public boolean meetsRequirements(Client client);
}
