/*
 * Copyright (c) 2019 MrGroggle
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
package net.runelite.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * An enumeration of Diaries.
 */
@RequiredArgsConstructor
@Getter
public enum Diary
{
	ARDOUGNE_EASY("Ardougne Easy", Varbits.DIARY_ARDOUGNE_EASY),
	ARDOUGNE_MEDIUM("Ardougne Medium", Varbits.DIARY_ARDOUGNE_MEDIUM),
	ARDOUGNE_HARD("Ardougne Hard", Varbits.DIARY_ARDOUGNE_HARD),
	ARDOUGNE_ELITE("Ardougne Elite", Varbits.DIARY_ARDOUGNE_ELITE),
	DESERT_EASY("Desert Easy", Varbits.DIARY_DESERT_EASY),
	DESERT_MEDIUM("Desert Medium", Varbits.DIARY_DESERT_MEDIUM),
	DESERT_HARD("Desert Hard", Varbits.DIARY_DESERT_HARD),
	DESERT_ELITE("Desert Elite", Varbits.DIARY_DESERT_ELITE),
	FALADOR_EASY("Falador Easy", Varbits.DIARY_FALADOR_EASY),
	FALADOR_MEDIUM("Falador Medium", Varbits.DIARY_FALADOR_MEDIUM),
	FALADOR_HARD("Falador Hard", Varbits.DIARY_FALADOR_HARD),
	FALADOR_ELITE("Falador Elite", Varbits.DIARY_FALADOR_ELITE),
	FREMENNIK_EASY("Fremennik Easy", Varbits.DIARY_FREMENNIK_EASY),
	FREMENNIK_MEDIUM("Fremennik Medium", Varbits.DIARY_FREMENNIK_MEDIUM),
	FREMENNIK_HARD("Fremennik Hard", Varbits.DIARY_FREMENNIK_HARD),
	FREMENNIK_ELITE("Fremennik Elite", Varbits.DIARY_FREMENNIK_ELITE),
	KANDARIN_EASY("Kandarin Easy", Varbits.DIARY_KANDARIN_EASY),
	KANDARIN_MEDIUM("Kandarin Medium", Varbits.DIARY_KANDARIN_MEDIUM),
	KANDARIN_HARD("Kandarin Hard", Varbits.DIARY_KANDARIN_HARD),
	KANDARIN_ELITE("Kandarin Elite", Varbits.DIARY_KANDARIN_ELITE),
	KARAMJA_EASY("Karamja Easy", Varbits.DIARY_KARAMJA_EASY),
	KARAMJA_MEDIUM("Karamja Medium", Varbits.DIARY_KARAMJA_MEDIUM),
	KARAMJA_HARD("Karamja Hard", Varbits.DIARY_KARAMJA_HARD),
	KARAMJA_ELITE("Karamja Elite", Varbits.DIARY_KARAMJA_ELITE),
	KOUREND_EASY("Kourend Easy", Varbits.DIARY_KOUREND_EASY),
	KOUREND_MEDIUM("Kourend Medium", Varbits.DIARY_KOUREND_MEDIUM),
	KOUREND_HARD("Kourend Hard", Varbits.DIARY_KOUREND_HARD),
	KOUREND_ELITE("Kourend Elite", Varbits.DIARY_KOUREND_ELITE),
	LUMBRIDGE_EASY("Lumbridge Easy", Varbits.DIARY_LUMBRIDGE_EASY),
	LUMBRIDGE_MEDIUM("Lumbridge Medium", Varbits.DIARY_LUMBRIDGE_MEDIUM),
	LUMBRIDGE_HARD("Lumbridge Hard", Varbits.DIARY_LUMBRIDGE_HARD),
	LUMBRIDGE_ELITE("Lumbridge Elite", Varbits.DIARY_LUMBRIDGE_ELITE),
	MORYTANIA_EASY("Morytania Easy", Varbits.DIARY_MORYTANIA_EASY),
	MORYTANIA_MEDIUM("Morytania Medium", Varbits.DIARY_MORYTANIA_MEDIUM),
	MORYTANIA_HARD("Morytania Hard", Varbits.DIARY_MORYTANIA_HARD),
	MORYTANIA_ELITE("Morytania Elite", Varbits.DIARY_MORYTANIA_ELITE),
	VARROCK_EASY("Varrock Easy", Varbits.DIARY_VARROCK_EASY),
	VARROCK_MEDIUM("Varrock Medium", Varbits.DIARY_VARROCK_MEDIUM),
	VARROCK_HARD("Varrock Hard", Varbits.DIARY_VARROCK_HARD),
	VARROCK_ELITE("Varrock Elite", Varbits.DIARY_VARROCK_ELITE),
	WESTERN_EASY("Western Provinces Easy", Varbits.DIARY_WESTERN_EASY),
	WESTERN_MEDIUM("Western Provinces Medium", Varbits.DIARY_WESTERN_MEDIUM),
	WESTERN_HARD("Western Provinces Hard", Varbits.DIARY_WESTERN_HARD),
	WESTERN_ELITE("Western Provinces Elite", Varbits.DIARY_WESTERN_ELITE),
	WILDERNESS_EASY("Wilderness Easy", Varbits.DIARY_WILDERNESS_EASY),
	WILDERNESS_MEDIUM("Wilderness Medium", Varbits.DIARY_WILDERNESS_MEDIUM),
	WILDERNESS_HARD("Wilderness Hard", Varbits.DIARY_WILDERNESS_HARD),
	WILDERNESS_ELITE("Wilderness Elite", Varbits.DIARY_WILDERNESS_ELITE);

	private final String name;
	private final Varbits varbit;
}
