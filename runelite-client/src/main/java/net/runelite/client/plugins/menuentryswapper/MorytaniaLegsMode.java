package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MorytaniaLegsMode
{
    WEAR("Wear"),
    ECTO("Ecto Teleport"),
    BURGH("Burgh Teleport");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}