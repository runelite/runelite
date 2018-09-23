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
 */
public class ColorScheme
{
	/* The orange color used for the branding's accents */
	public static final Color BRAND_ORANGE = new Color(220, 138, 0);

	/* The orange color used for the branding's accents, with lowered opacity */
	public static final Color BRAND_ORANGE_TRANSPARENT = new Color(220, 138, 0, 120);

	public static final Color DARKER_GRAY_COLOR = new Color(30, 30, 30);
	public static final Color DARK_GRAY_COLOR = new Color(40, 40, 40);
	public static final Color MEDIUM_GRAY_COLOR = new Color(77, 77, 77);
	public static final Color LIGHT_GRAY_COLOR = new Color(165, 165, 165);

	public static final Color DARKER_GRAY_HOVER_COLOR = new Color(60, 60, 60);
	public static final Color DARK_GRAY_HOVER_COLOR = new Color(35, 35, 35);

	/* The color for the green progress bar (used in ge offers, farming tracker, etc)*/
	public static final Color PROGRESS_COMPLETE_COLOR = new Color(55, 240, 70);

	/* The color for the red progress bar (used in ge offers, farming tracker, etc)*/
	public static final Color PROGRESS_ERROR_COLOR = new Color(230, 30, 30);

	/* The color for the orange progress bar (used in ge offers, farming tracker, etc)*/
	public static final Color PROGRESS_INPROGRESS_COLOR = new Color(230, 150, 30);

	/* The color for the price indicator in the ge search results */
	public static final Color GRAND_EXCHANGE_PRICE = new Color(110, 225, 110);

	/* The color for the high alch indicator in the ge search results */
	public static final Color GRAND_EXCHANGE_ALCH = new Color(240, 207, 123);

	/* The color for the limit indicator in the ge search results */
	public static final Color GRAND_EXCHANGE_LIMIT = new Color(50, 160, 250);

	/* The background color of the scrollbar's track */
	public static final Color SCROLL_TRACK_COLOR = new Color(25, 25, 25);

}