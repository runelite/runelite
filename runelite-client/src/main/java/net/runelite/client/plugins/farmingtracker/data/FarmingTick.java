/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FarmingTick
{
	/**
	 * Flower: marigold, rosemary, nasturtium, woad leaves, limpwurt root
	 * Special: seaweed
	 */
	TICK_5(5),

	/**
	 * Special: grape
	 */
	TICK_8(8),

	/**
	 * Allotment: potato, onion, cabbage, tomato, sweetcorn, stawberry, watermelon
	 * Hop: barley, hammerstone, asgarnian, jute, yanillian, krandorian, wildblood
	 */
	TICK_10(10),

	/**
	 * Herb: guam, marrentill, tarromin, harralander, gout tuber?, ranarr, toadflax, irit, avantoe, kwuarm, snapdragon,
	 * cadantine, lantadyme, dwarf weed, torstol
	 * Bush: redberry, cadavaberry, dwellberry, jangerberry, whiteberry, poison ivy
	 */
	TICK_20(20),

	/**
	 * Tree: acorn, willow, maple, yew, magic
	 * Special: mushroom
	 */
	TICK_40(40),

	/**
	 * Special: cactus, belladonna
	 */
	TICK_80(80),

	/***
	 * Fruit tree: apple, banana, orange, curry, pineapple, papaya, palm
	 * Special: calquat
	 */
	TICK_160(160),

	/**
	 * Special: spirit tree
	 */
	TICK_320(320),

	/**
	 * Special: teak
	 */
	TICK_560(560),

	/**
	 * Special: mahogany
	 */
	TICK_569(569);

	private final int tick;
}

