package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ArdougneCloakMode
{
    WEAR("Wear"),
    MONASTERY("Monastery Teleport"),
    FARM("Farm Teleport");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}