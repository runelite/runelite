package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KaramjaGlovesMode
{
    WEAR("Wear"),
    GEM_MINE("Gem Mine"),
    DURADEL("Duradel");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}