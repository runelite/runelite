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
	BULL_ROARER("It's coming home", -1),
	YES("It's coming home", EMOTE_YES),
	NO("It's coming home", EMOTE_NO),
	THINK("It's coming home", EMOTE_THINK),
	BOW("It's coming home", EMOTE_BOW),
	ANGRY("It's coming home", EMOTE_ANGRY),
	CRY("It's coming home", EMOTE_CRY),
	LAUGH("It's coming home", EMOTE_LAUGH),
	CHEER("It's coming home", EMOTE_CHEER),
	WAVE("It's coming home", EMOTE_WAVE),
	BECKON("It's coming home", EMOTE_BECKON),
	DANCE("It's coming home", EMOTE_DANCE),
	CLAP("It's coming home", EMOTE_CLAP),
	PANIC("It's coming home", EMOTE_PANIC),
	JIG("It's coming home", EMOTE_JIG),
	SPIN("It's coming home", EMOTE_SPIN),
	HEADBANG("It's coming home", EMOTE_HEADBANG),
	JUMP_FOR_JOY("It's coming home", EMOTE_JUMP_FOR_JOY),
	RASPBERRY("It's coming home", EMOTE_RASPBERRY),
	YAWN("It's coming home", EMOTE_YAWN),
	SALUTE("It's coming home", EMOTE_SALUTE),
	SHRUG("It's coming home", EMOTE_SHRUG),
	BLOW_KISS("It's coming home", EMOTE_BLOW_KISS),
	GOBLIN_SALUTE("It's coming home", EMOTE_GOBLIN_SALUTE),
	SLAP_HEAD("It's coming home", EMOTE_SLAP_HEAD),
	STOMP("It's coming home", EMOTE_STOMP),
	FLAP("It's coming home", EMOTE_FLAP),
	PUSH_UP("It's coming home", EMOTE_PUSH_UP);

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
