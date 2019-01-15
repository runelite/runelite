package net.runelite.client.plugins.timetracking;

import lombok.Getter;

public enum SortOrder
{
    NONE("NONE"),
    ASC("ASC"),
    DESC("DESC");

    private final String name;

    SortOrder(String name)
    {
        this.name = name;
    }
}
