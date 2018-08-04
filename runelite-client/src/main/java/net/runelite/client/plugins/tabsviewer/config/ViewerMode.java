package net.runelite.client.plugins.tabsviewer.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ViewerMode
{
    INV("Inventory"),
    EQP("Equipment"),
    BOTH("Both");

    private final String viewMode;

    @Override
    public String toString()
    {
        return viewMode;
    }
}