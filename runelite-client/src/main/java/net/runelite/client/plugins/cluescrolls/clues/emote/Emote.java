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
import net.runelite.api.gameval.SpriteID;

@Getter
public enum Emote
{
	BULL_ROARER("Bull Roarer", -1),
	YES("Yes", SpriteID.Emotes.YES),
	NO("No", SpriteID.Emotes.NO),
	THINK("Think", SpriteID.Emotes.THINK),
	BOW("Bow", SpriteID.Emotes.BOW),
	ANGRY("Angry", SpriteID.Emotes.ANGRY),
	CRY("Cry", SpriteID.Emotes.CRY),
	LAUGH("Laugh", SpriteID.Emotes.LAUGH),
	CHEER("Cheer", SpriteID.Emotes.CHEER),
	WAVE("Wave", SpriteID.Emotes.WAVE),
	BECKON("Beckon", SpriteID.Emotes.BECKON),
	DANCE("Dance", SpriteID.Emotes.DANCE),
	CLAP("Clap", SpriteID.Emotes.CLAP),
	PANIC("Panic", SpriteID.Emotes.PANIC),
	JIG("Jig", SpriteID.Emotes.JIG),
	SPIN("Spin", SpriteID.Emotes.SPIN),
	HEADBANG("Headbang", SpriteID.Emotes.HEADBANG),
	JUMP_FOR_JOY("Jump for Joy", SpriteID.Emotes.JUMP_FOR_JOY),
	RASPBERRY("Raspberry", SpriteID.Emotes.RASPBERRY),
	YAWN("Yawn", SpriteID.Emotes.YAWN),
	SALUTE("Salute", SpriteID.Emotes.SALUTE),
	SHRUG("Shrug", SpriteID.Emotes.SHRUG),
	BLOW_KISS("Blow Kiss", SpriteID.Emotes.BLOW_KISS),
	GOBLIN_SALUTE("Goblin Salute", SpriteID.Emotes.GOBLIN_SALUTE),
	SLAP_HEAD("Slap Head", SpriteID.Emotes.SLAP_HEAD),
	STAMP("Stamp", SpriteID.Emotes.STAMP),
	FLAP("Flap", SpriteID.Emotes.FLAP),
	PUSH_UP("Push up", SpriteID.Emotes.PUSH_UP),
	FORTIS_SALUTE("Fortis Salute", SpriteID.EmotesLocked.FORTIS_SALUTE);

	private final String name;
	private final int spriteId;

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
