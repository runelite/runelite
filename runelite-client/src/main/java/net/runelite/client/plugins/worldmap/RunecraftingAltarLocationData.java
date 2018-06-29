/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum RunecraftingAltarLocationData {
    AIR("Air Altar", new WorldPoint(2985,3292,0), "runecrafting_air_rune.png"),
    MIND("Mind Altar", new WorldPoint(2982,3514,0), "runecrafting_mind_rune.png"),
    WATER("Water Altar", new WorldPoint(3185,3165,0), "runecrafting_water_rune.png"),
    EARTH("Earth Altar", new WorldPoint(3306,3474,0), "runecrafting_earth_rune.png"),
    FIRE("Fire Altar", new WorldPoint(3313,3255,0), "runecrafting_fire_rune.png"),
    BODY("Body Altar", new WorldPoint(3053,3445,0), "runecrafting_body_rune.png"),
    COSMIC("Cosmic Altar", new WorldPoint(2408,4377,0), "runecrafting_cosmic_rune.png"),
    CHAOS("Chaos Altar", new WorldPoint(3060,3591,0), "runecrafting_chaos_rune.png"),
    ASTRAL("Astral Altar", new WorldPoint(2158,3864,0), "runecrafting_astral_rune.png"),
    NATURE("Nature Altar", new WorldPoint(2869,3019,0), "runecrafting_nature_rune.png"),
    LAW("Law Altar", new WorldPoint(2858,3381,0), "runecrafting_law_rune.png"),
    DEATH("Death Altar", new WorldPoint(1860,4639,0), "runecrafting_death_rune.png"),
    BLOOD("Blood Altar", new WorldPoint(1716,3830,0), "runecrafting_blood_rune.png"),
    SOUL("Soul Altar", new WorldPoint(1814,3854,0), "runecrafting_soul_rune.png"),
    WRATH("Wrath Altar", new WorldPoint(2446,2825,0), "runecrafting_wrath_rune.png");

    private final String tooltip;
    private final WorldPoint location;
    private final String iconPath;

    RunecraftingAltarLocationData(String tooltip, WorldPoint location, String iconPath)
    {
        this.tooltip = tooltip;
        this.location = location;
        this.iconPath = iconPath;
    }
}
