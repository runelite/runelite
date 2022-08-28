package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum STASHBuildHelper {
    BEGINNER("12 Construction", "hammer, saw, 2 planks, 10 nails"),
    EASY("27 Construction", "hammer, saw, 2 planks, 10 nails"),
    MEDIUM("42 Construction", "hammer, saw, 2 oak planks, 10 nails"),
    HARD("55 Construction", "hammer, saw, 2 teak planks, 10 nails"),
    ELITE("77 Construction", "hammer, saw, 2 mahogany planks, 10 nails"),
    MASTER("88 Construction", "hammer, saw, 2 mahogany planks, 1 gold leaf, 10 nails"),
    ;

    private final String constructionLevelRequired;
    private final String materialsRequired;
}
