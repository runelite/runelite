package net.runelite.client.plugins.keyremapping.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PromptText
{
    PRESS_ENTER_TO_CHAT("Press Enter to Chat..."),
    ASTERISK("*");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}
