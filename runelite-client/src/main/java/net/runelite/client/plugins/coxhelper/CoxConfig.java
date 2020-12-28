/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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

package net.runelite.client.plugins.coxhelper;

import java.awt.Color;
import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.*;

@ConfigGroup("Cox")

public interface CoxConfig extends Config
{
    @ConfigItem(
            name = "Mirror Mode Compatibility?",
            keyName = "mirrorMode",
            description = "Should we show the overlay on Mirror Mode?",
            position = 0
    )
    default boolean mirrorMode()
    {
        return false;
    }

    @ConfigSection(
            name = "Muttadile",
            position = 1,
            description = ""
    )
    String muttadileTitle = "muttadileTitle";

    @ConfigItem(
            position = 2,
            keyName = "muttadile",
            name = "Muttadile Marker",
            description = "Places an overlay around muttadiles showing their melee range.",
            section = muttadileTitle
    )
    default boolean muttadile()
    {
        return true;
    }

    @ConfigSection(
            name = "Tekton",
            position = 3,
            description = ""
    )
    String tektonTitle = "tektonTitle";


    @ConfigItem(
            position = 4,
            keyName = "tekton",
            name = "Tekton Marker",
            description = "Places an overlay around Tekton showing his melee range.",
            section = tektonTitle
    )
    default boolean tekton()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "tektonTickCounter",
            name = "Tekton Tick Counters",
            description = "Counts down current phase timer, and attack ticks.",
            section = tektonTitle
    )
    default boolean tektonTickCounter()
    {
        return true;
    }

    @ConfigSection(
            position = 5,
            name = "Guardians",
            description = ""
    )
    String guardiansTitle = "guardiansTitle";

    @ConfigItem(
            position = 6,
            keyName = "guardians",
            name = "Guardians Overlay",
            description = "Places an overlay near Guardians showing safespot.",
            section = guardiansTitle
    )
    default boolean guardians()
    {
        return true;
    }

    @ConfigItem(
            position = 6,
            keyName = "guardinTickCounter",
            name = "Guardians Tick Timing",
            description = "Places an overlay on Guardians showing attack tick timers.",
            section = guardiansTitle
    )
    default boolean guardinTickCounter()
    {
        return true;
    }

    @ConfigSection(
            position = 7,
            name = "Vanguards",
            description = ""
    )
    String vanguardsTitle = "vanguardsTitle";

    @ConfigItem(
            position = 8,
            keyName = "vangHighlight",
            name = "Highlight Vanguards",
            description = "Color is based on their attack style.",
            section = vanguardsTitle
    )
    default boolean vangHighlight()
    {
        return true;
    }

    @ConfigItem(
            position = 9,
            keyName = "vangHealth",
            name = "Show Vanguards Current HP",
            description = "This will create an infobox with vanguards current hp.",
            section = vanguardsTitle
    )
    default boolean vangHealth()
    {
        return true;
    }

    @ConfigSection(
            position = 10,
            name = "Olm",
            description = ""
    )
    String olmTitle = "olmTitle";

    @ConfigItem(
            position = 11,
            keyName = "prayAgainstOlm",
            name = "Olm Show Prayer",
            description = "Shows what prayer to use during olm.",
            section = olmTitle
    )
    default boolean prayAgainstOlm()
    {
        return true;
    }

    @Range(
            min = 40,
            max = 100
    )
    @ConfigItem(
            position = 11,
            keyName = "prayAgainstOlmSize",
            name = "Olm Prayer Size",
            description = "Change the Size of the Olm Infobox.",
            section = olmTitle
    )
    @Units(Units.PIXELS)
    default int prayAgainstOlmSize()
    {
        return 40;
    }

    @ConfigItem(
            position = 12,
            keyName = "timers",
            name = "Olm Show Burn/Acid Timers",
            description = "Shows tick timers for burns/acids.",
            section = olmTitle
    )
    default boolean timers()
    {
        return true;
    }

    @ConfigItem(
            position = 13,
            keyName = "tpOverlay",
            name = "Olm Show Teleport Overlays",
            description = "Shows Overlays for targeted teleports.",
            section = olmTitle
    )
    default boolean tpOverlay()
    {
        return true;
    }

    @ConfigItem(
            position = 14,
            keyName = "olmTick",
            name = "Olm Tick Counter",
            description = "Show Tick Counter on Olm",
            section = olmTitle
    )
    default boolean olmTick()
    {
        return true;
    }

    @ConfigItem(
            position = 15,
            keyName = "olmDebug",
            name = "Olm Debug Info",
            description = "Dev tool to show info about olm",
            section = olmTitle
    )
    default boolean olmDebug()
    {
        return false;
    }

    @ConfigItem(
            position = 16,
            keyName = "olmPShowPhase",
            name = "Olm Phase Type",
            description = "Will highlight olm depending on which phase type is active. Red=Flame Green=Acid Purple=Crystal",
            section = olmTitle
    )
    default boolean olmPShowPhase()
    {
        return false;
    }

    @ConfigSection(
            position = 17,
            name = "Colors",
            description = ""
    )
    String colors = "colors";


    @ConfigItem(
            position = 18,
            keyName = "muttaColor",
            name = "Muttadile Tile Color",
            description = "Change hit area tile color for muttadiles",
            section = colors,
            hidden = true
    )
    default Color muttaColor()
    {
        return new Color(0, 255, 99);
    }

    @ConfigItem(
            position = 19,
            keyName = "guardColor",
            name = "Guardians Tile Color",
            description = "Change safespot area tile color for Guardians",
            section = colors
    )
    default Color guardColor()
    {
        return new Color(0, 255, 99);
    }

    @ConfigItem(
            position = 20,
            keyName = "tektonColor",
            name = "Tekton Tile Color",
            description = "Change hit area tile color for Tekton",
            section = colors,
            hidden = true
    )
    default Color tektonColor()
    {
        return new Color(193, 255, 245);
    }

    @ConfigItem(
            position = 21,
            keyName = "burnColor",
            name = "Burn Victim Color",
            description = "Changes tile color for burn victim.",
            section = colors,
            hidden = true
    )
    default Color burnColor()
    {
        return new Color(255, 100, 0);
    }

    @ConfigItem(
            position = 22,
            keyName = "acidColor",
            name = "Acid Victim Color",
            description = "Changes tile color for acid victim.",
            section = colors,
            hidden = true
    )
    default Color acidColor()
    {
        return new Color(69, 241, 44);
    }

    @ConfigItem(
            position = 23,
            keyName = "tpColor",
            name = "Teleport Target Color",
            description = "Changes tile color for teleport target.",
            section = colors,
            hidden = true
    )
    default Color tpColor()
    {
        return new Color(193, 255, 245);
    }

    @ConfigItem(
            position = 24,
            keyName = "olmSpecialColor",
            name = "Olm Special Color",
            description = "Changes color of a special on Olm's tick counter",
            section = colors,
            hidden = true
    )
    default Color olmSpecialColor()
    {
        return new Color(89, 255, 0);
    }

    @ConfigSection(
            position = 25,
            name = "Text",
            description = ""
    )
    String text = "text";

    @ConfigItem(
            position = 26,
            keyName = "fontStyle",
            name = "Font Style",
            description = "Bold/Italics/Plain",
            section = text
    )
    default FontStyle fontStyle()
    {
        return FontStyle.BOLD;
    }

    @Range(
            min = 9,
            max = 20
    )
    @ConfigItem(
            position = 27,
            keyName = "textSize",
            name = "Text Size",
            description = "Text Size for Timers.",
            section = text
    )
    @Units(Units.PIXELS)
    default int textSize()
    {
        return 14;
    }

    @ConfigItem(
            position = 28,
            keyName = "shadows",
            name = "Shadows",
            description = "Adds Shadows to text.",
            section = text
    )
    default boolean shadows()
    {
        return true;
    }

    @Getter
    @AllArgsConstructor
    enum FontStyle
    {
        BOLD("Bold", Font.BOLD),
        ITALIC("Italic", Font.ITALIC),
        PLAIN("Plain", Font.PLAIN);

        private final String name;
        private final int font;

        @Override
        public String toString()
        {
            return this.getName();
        }
    }
}