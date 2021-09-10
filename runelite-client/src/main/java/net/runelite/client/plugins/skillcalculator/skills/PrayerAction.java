/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum PrayerAction implements SkillAction
{
	ENSOULED_GOBLIN_HEAD("Ensouled goblin head", 1, 130, ItemID.ENSOULED_GOBLIN_HEAD, true),
	ENSOULED_MONKEY_HEAD("Ensouled monkey head", 1, 182, ItemID.ENSOULED_MONKEY_HEAD, true),
	ENSOULED_IMP_HEAD("Ensouled imp head", 1, 286, ItemID.ENSOULED_IMP_HEAD, true),
	ENSOULED_MINOTAUR_HEAD("Ensouled minotaur head", 1, 364, ItemID.ENSOULED_MINOTAUR_HEAD, true),
	ENSOULED_SCORPION_HEAD("Ensouled scorpion head", 1, 454, ItemID.ENSOULED_SCORPION_HEAD, true),
	ENSOULED_BEAR_HEAD("Ensouled bear head", 1, 480, ItemID.ENSOULED_BEAR_HEAD, true),
	ENSOULED_UNICORN_HEAD("Ensouled unicorn head", 1, 494, ItemID.ENSOULED_UNICORN_HEAD, true),
	ENSOULED_DOG_HEAD("Ensouled dog head", 1, 520, ItemID.ENSOULED_DOG_HEAD, true),
	ENSOULED_CHAOS_DRUID_HEAD("Ensouled chaos druid head", 1, 584, ItemID.ENSOULED_CHAOS_DRUID_HEAD, true),
	ENSOULED_GIANT_HEAD("Ensouled giant head", 1, 650, ItemID.ENSOULED_GIANT_HEAD, true),
	ENSOULED_OGRE_HEAD("Ensouled ogre head", 1, 716, ItemID.ENSOULED_OGRE_HEAD, true),
	ENSOULED_ELF_HEAD("Ensouled elf head", 1, 754, ItemID.ENSOULED_ELF_HEAD, true),
	ENSOULED_TROLL_HEAD("Ensouled troll head", 1, 780, ItemID.ENSOULED_TROLL_HEAD, true),
	ENSOULED_HORROR_HEAD("Ensouled horror head", 1, 832, ItemID.ENSOULED_HORROR_HEAD, true),
	ENSOULED_KALPHITE_HEAD("Ensouled kalphite head", 1, 884, ItemID.ENSOULED_KALPHITE_HEAD, true),
	ENSOULED_DAGANNOTH_HEAD("Ensouled dagannoth head", 1, 936, ItemID.ENSOULED_DAGANNOTH_HEAD, true),
	ENSOULED_BLOODVELD_HEAD("Ensouled bloodveld head", 1, 1040, ItemID.ENSOULED_BLOODVELD_HEAD, true),
	ENSOULED_TZHAAR_HEAD("Ensouled tzhaar head", 1, 1104, ItemID.ENSOULED_TZHAAR_HEAD, true),
	ENSOULED_DEMON_HEAD("Ensouled demon head", 1, 1170, ItemID.ENSOULED_DEMON_HEAD, true),
	ENSOULED_AVIANSIE_HEAD("Ensouled aviansie head", 1, 1234, ItemID.ENSOULED_AVIANSIE_HEAD, true),
	ENSOULED_ABYSSAL_HEAD("Ensouled abyssal head", 1, 1300, ItemID.ENSOULED_ABYSSAL_HEAD, true),
	ENSOULED_DRAGON_HEAD("Ensouled dragon head", 1, 1560, ItemID.ENSOULED_DRAGON_HEAD, true),
	FIENDISH_ASHES("Fiendish ashes", 1, 10, ItemID.FIENDISH_ASHES, true),
	VILE_ASHES("Vile ashes", 1, 25, ItemID.VILE_ASHES, true),
	MALICIOUS_ASHES("Malicious ashes", 1, 65, ItemID.MALICIOUS_ASHES, true),
	ABYSSAL_ASHES("Abyssal ashes", 1, 85, ItemID.ABYSSAL_ASHES, true),
	INFERNAL_ASHES("Infernal ashes", 1, 110, ItemID.INFERNAL_ASHES, true),
	BONES("Bones", 1, 4.5f, ItemID.BONES, false),
	WOLF_BONES("Wolf bones", 1, 4.5f, ItemID.WOLF_BONES, false),
	LOAR_REMAINS("Loar remains", 1, 33, ItemID.LOAR_REMAINS, false),
	BURNT_BONES("Burnt bones", 1, 4.5f, ItemID.BURNT_BONES, false),
	MONKEY_BONES("Monkey bones", 1, 5, ItemID.MONKEY_BONES, false),
	BAT_BONES("Bat bones", 1, 5.3f, ItemID.BAT_BONES, false),
	JOGRE_BONES("Jogre bones", 1, 15, ItemID.JOGRE_BONES, false),
	BIG_BONES("Big bones", 1, 15, ItemID.BIG_BONES, false),
	ZOGRE_BONES("Zogre bones", 1, 22.5f, ItemID.ZOGRE_BONES, false),
	SHAIKAHAN_BONES("Shaikahan bones", 1, 25, ItemID.SHAIKAHAN_BONES, false),
	BABYDRAGON_BONES("Babydragon bones", 1, 30, ItemID.BABYDRAGON_BONES, false),
	PHRIN_REMAINS("Phrin remains", 1, 46.5f, ItemID.PHRIN_REMAINS, false),
	WYRM_BONES("Wyrm bones", 1, 50, ItemID.WYRM_BONES, false),
	RIYL_REMAINS("Riyl remains", 1, 59.5f, ItemID.RIYL_REMAINS, false),
	WYVERN_BONES("Wyvern bones", 1, 72, ItemID.WYVERN_BONES, false),
	DRAGON_BONES("Dragon bones", 1, 72, ItemID.DRAGON_BONES, false),
	DRAKE_BONES("Drake bones", 1, 80, ItemID.DRAKE_BONES, false),
	ASYN_REMAINS("Asyn remains", 1, 82.5f, ItemID.ASYN_REMAINS, false),
	FAYRG_BONES("Fayrg bones", 1, 84, ItemID.FAYRG_BONES, false),
	FIYR_REMAINS("Fiyr remains", 1, 84, ItemID.FIYR_REMAINS, false),
	LAVA_DRAGON_BONES("Lava dragon bones", 1, 85, ItemID.LAVA_DRAGON_BONES, false),
	RAURG_BONES("Raurg bones", 1, 96, ItemID.RAURG_BONES, false),
	HYDRA_BONES("Hydra bones", 1, 110, ItemID.HYDRA_BONES, false),
	DAGANNOTH_BONES("Dagannoth bones", 1, 125, ItemID.DAGANNOTH_BONES, false),
	OURG_BONES("Ourg bones", 1, 140, ItemID.OURG_BONES, false),
	URIUM_REMAINS("Urium remains", 1, 120, ItemID.URIUM_REMAINS, false),
	GUPPY("Guppy", 1, 4, ItemID.GUPPY, false),
	CAVEFISH("Cavefish", 1, 7, ItemID.CAVEFISH, false),
	TETRA("Tetra", 1, 10, ItemID.TETRA, false),
	CATFISH("Catfish", 1, 16, ItemID.CATFISH, false),
	SUPERIOR_DRAGON_BONES("Superior dragon bones", 70, 150, ItemID.SUPERIOR_DRAGON_BONES, false),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
	private final boolean ignoreBonus;
}
