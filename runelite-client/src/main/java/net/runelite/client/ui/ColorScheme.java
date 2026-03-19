/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.ui;

import java.awt.Color;

/**
 * This class serves to hold commonly used UI colors.
 * CyberWorld - Midnight Neon Galaxy / Cyberpunk / OSINT / SOC Theme
 */
public class ColorScheme
{
	/* The neon cyan color used for CyberWorld branding accents */
	public static final Color BRAND_ORANGE = new Color(0, 220, 255);

	/* The neon cyan color used for CyberWorld branding accents, with lowered opacity */
	public static final Color BRAND_ORANGE_TRANSPARENT = new Color(0, 220, 255, 120);

	/* Midnight dark backgrounds */
	public static final Color DARKER_GRAY_COLOR = new Color(6, 6, 18);
	public static final Color DARK_GRAY_COLOR = new Color(10, 10, 28);
	public static final Color MEDIUM_GRAY_COLOR = new Color(30, 42, 74);
	public static final Color LIGHT_GRAY_COLOR = new Color(140, 180, 220);

	/* Neon-tinted text and UI controls */
	public static final Color TEXT_COLOR = new Color(180, 220, 255);
	public static final Color CONTROL_COLOR = new Color(10, 10, 28);
	public static final Color BORDER_COLOR = new Color(0, 80, 140);

	/* Hover states with neon glow effect */
	public static final Color DARKER_GRAY_HOVER_COLOR = new Color(0, 40, 80);
	public static final Color DARK_GRAY_HOVER_COLOR = new Color(10, 20, 50);

	/* Neon green for complete/success state */
	public static final Color PROGRESS_COMPLETE_COLOR = new Color(0, 255, 136);

	/* Hot pink/red for error state */
	public static final Color PROGRESS_ERROR_COLOR = new Color(255, 30, 80);

	/* Electric purple for in-progress state */
	public static final Color PROGRESS_INPROGRESS_COLOR = new Color(155, 0, 255);

	/* Neon green for price indicators */
	public static final Color GRAND_EXCHANGE_PRICE = new Color(0, 255, 136);

	/* Gold-yellow for alch indicators */
	public static final Color GRAND_EXCHANGE_ALCH = new Color(255, 215, 0);

	/* Electric blue for limit indicators */
	public static final Color GRAND_EXCHANGE_LIMIT = new Color(0, 160, 255);

	/* The background color of the scrollbar's track */
	public static final Color SCROLL_TRACK_COLOR = new Color(4, 4, 14);

}