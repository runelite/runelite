package net.runelite.client.plugins.inferno.displaymodes;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum InfernoWaveDisplayMode
{
    CURRENT("Current wave"),
    NEXT("Next wave"),
    BOTH("Both"),
    NONE("None");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}