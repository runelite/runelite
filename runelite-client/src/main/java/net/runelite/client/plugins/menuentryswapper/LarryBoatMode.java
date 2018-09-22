package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LarryBoatMode
{
    TRAVEL("Travel"),
    ICEBERG("Iceberg"),
    WEISS("Weiss");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}
