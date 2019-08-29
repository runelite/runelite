/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues.emote;

import lombok.Getter;
import static net.runelite.api.SpriteID.*;

@Getter
public enum Emote
{
	BULL_ROARER("Bull Roarer", -1),
	YES("Yes", EMOTE_YES),
	NO("No", EMOTE_NO),
	THINK("Think", EMOTE_THINK),
	BOW("Bow", EMOTE_BOW),
	ANGRY("Angry", EMOTE_ANGRY),
	CRY("Cry", EMOTE_CRY),
	LAUGH("Laugh", EMOTE_LAUGH),
	CHEER("Cheer", EMOTE_CHEER),
	WAVE("Wave", EMOTE_WAVE),
	BECKON("Beckon", EMOTE_BECKON),
	DANCE("Dance", EMOTE_DANCE),
	CLAP("Clap", EMOTE_CLAP),
	PANIC("Panic", EMOTE_PANIC),
	JIG("Jig", EMOTE_JIG),
	SPIN("Spin", EMOTE_SPIN),
	HEADBANG("Headbang", EMOTE_HEADBANG),
	JUMP_FOR_JOY("Jump for Joy", EMOTE_JUMP_FOR_JOY),
	RASPBERRY("Raspberry", EMOTE_RASPBERRY),
	YAWN("Yawn", EMOTE_YAWN),
	SALUTE("Salute", EMOTE_SALUTE),
	SHRUG("Shrug", EMOTE_SHRUG),
	BLOW_KISS("Blow Kiss", EMOTE_BLOW_KISS),
	GOBLIN_SALUTE("Goblin Salute", EMOTE_GOBLIN_SALUTE),
	SLAP_HEAD("Slap Head", EMOTE_SLAP_HEAD),
	STAMP("Stamp", EMOTE_STAMP),
	FLAP("Flap", EMOTE_FLAP),
	PUSH_UP("Push up", EMOTE_PUSH_UP);

	private String name;
	private int spriteId;

	Emote(String name, int spriteId)
	{
		this.name = name;
		this.spriteId = spriteId;
	}

	public boolean hasSprite()
	{
		return spriteId != -1;
	}
}
