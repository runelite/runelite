/*
 * Copyright (c) 2020, Christopher Oswald <https://github.com/cesoun>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.questpicker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup("optimal-quest-guide")
public interface GuideConfig extends Config {

    @ConfigSection(
            name = "Quest Status Colors",
            description = "Colors of not started, in progress and completed Quest",
            position = 98
    )
    String questStatusSection = "status";

    @ConfigSection(
            name = "Quest Requirement Colors",
            description = "Colors of met, unmet and boostable Quest Requirements",
            position = 99
    )
    String questRequirementSection = "requirement";

    @ConfigItem(
            keyName = "showCompletedQuests",
            name = "Show completed quests",
            description = "Displays already completed quests"
    )
    default boolean showCompletedQuests() {
        return false;
    }

    @ConfigItem(
            keyName = "searchCompletedQuests",
            name = "Search completed quests",
            description = "Have the search include completed quests"
    )
    default boolean searchCompletedQuests() {
        return false;
    }

    @ConfigItem(
            keyName = "filterMetRequirements",
            name = "Filter by met Requirements",
            description = "Only display the quests that you have the met requirements to complete"
    )
    default boolean filterMetRequirements() { return false; }

    @ConfigItem(
            keyName = "inProgressColor",
            name = "Quest in progress color",
            description = "Color of Quests in progress",
            section = questStatusSection
    )
    default Color getInProgressColor() {
        return new Color(240, 207, 123);
    }

    @ConfigItem(
            keyName = "completedColor",
            name = "Quest completed color",
            description = "Color of Quests that have been completed",
            section = questStatusSection
    )
    default Color getCompletedColor() {
        return new Color(110, 225, 110);
    }

    @ConfigItem(
            keyName = "notStartedColor",
            name = "Quest not started color",
            description = "Color of Quests that have not been started",
            section = questStatusSection
    )
    default Color getNotStartedColor() {
        return new Color(198, 198, 198);
    }

    @ConfigItem(
            keyName = "requirementMetColor",
            name = "Requirement level met",
            description = "Color of Requirements that have been met or exceeded",
            section = questRequirementSection
    )
    default Color getRequirementMetColor() {
        return new Color(110, 225, 110);
    }

    @ConfigItem(
            keyName = "requirementUnmetColor",
            name = "Requirement level unmet",
            description = "Color of Requirements that have been unmet and unboostable",
            section = questRequirementSection
    )
    default Color getRequirementUnmetColor() {
        return new Color(230, 30, 30);
    }

    @ConfigItem(
            keyName = "requirementBoostableColor",
            name = "Requirement boostable",
            description = "Color of Requirements that have are unmet and boostable",
            section = questRequirementSection
    )
    default Color getRequirementBoostableColor() {
        return new Color(50, 160, 250);
    }
}
