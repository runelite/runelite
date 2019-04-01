package net.runelite.client.plugins.grounditems.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValueCalculationMode
{
    HA("High Alchemy"), // calc highlight by HA value
    GE("Grand Exchange"), // calc by GE
    BOTH("Both"); // use whatever is highest.

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}
