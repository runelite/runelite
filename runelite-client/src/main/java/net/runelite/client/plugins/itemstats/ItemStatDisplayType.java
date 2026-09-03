package net.runelite.client.plugins.itemstats;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemStatDisplayType {

    ALWAYS(),
    ON_KEYBIND(),
    NEVER();
}
