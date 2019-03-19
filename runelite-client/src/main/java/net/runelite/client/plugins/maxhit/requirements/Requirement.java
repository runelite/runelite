package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;

public interface Requirement {
    boolean meetsRequirements(Client client);
}
