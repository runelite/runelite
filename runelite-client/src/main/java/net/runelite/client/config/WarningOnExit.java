package net.runelite.client.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WarningOnExit
{
    ALWAYS("Always"),
    ONLY_WHEN_LOGGED_IN("Only when logged in"),
    NEVER("Never");

    private final String type;

    @Override
    public String toString()
    {
        return type;
    }
}
