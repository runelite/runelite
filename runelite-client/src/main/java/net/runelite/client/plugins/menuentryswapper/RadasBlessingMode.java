package net.runelite.client.plugins.menuentryswapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RadasBlessingMode
{
    EQUIP("Equip"),
    WOODLAND("Kourend Woodland"),
    KARUULM("Mount Karuulm");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}