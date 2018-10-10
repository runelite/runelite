/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chattranslate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChatLanguageMode
{
	//TODO: Remove languages that the client cannot support
	AFRIKAANS("af"),
	ARABIC("ar"),
	AZERBAIJANI("az"),
	BELARUSIAN("be"),
	BULGARIAN("bg"),
	BENGALI("bn"),
	CATALAN("ca"),
	CZECH("cs"),
	WELSH("cy"),
	DANISH("da"),
	GERMAN("de"),
	GREEK("el"),
	ENGLISH("en"),
	ESPERANTO("eo"),
	SPANISH("es"),
	ESTONIAN("et"),
	BASQUE("eu"),
	PERSIAN("fa"),
	FINNISH("fi"),
	FRENCH("fr"),
	IRISH("ga"),
	GALICIAN("gl"),
	GUJARATI("gu"),
	HINDI("hi"),
	CROATIAN("hr"),
	HAITIANCREOLE("ht"),
	HUNGARIAN("hu"),
	INDONESIAN("id"),
	ICELANDIC("is"),
	ITALIAN("it"),
	HEBREW("iw"),
	JAPANESE("ja"),
	GEORGIAN("ka"),
	KANNADA("kn"),
	KOREAN("ko"),
	LATIN("la"),
	LITHUANIAN("lt"),
	LATVIAN("lv"),
	MACEDONIAN("mk"),
	MALAY("ms"),
	MALTESE("mt"),
	DUTCH("nl"),
	NORWEGIAN("no"),
	POLISH("pl"),
	PORTUGUESE("pt"),
	ROMANIAN("ro"),
	RUSSIAN("ru"),
	SLOVAK("sk"),
	SLOVENIAN("sl"),
	ALBANIAN("sq"),
	SERBIAN("sr"),
	SWEDISH("sv"),
	SWAHILI("sw"),
	TAMIL("ta"),
	TELUGU("te"),
	THAI("th"),
	FILIPINO("tl"),
	TURKISH("tr"),
	UKRAINIAN("uk"),
	URDU("ur"),
	VIETNAMESE("vi"),
	YIDDISH("yi");
	//CHINESESIMPLIFIED("zh-CN"),
	//CHINESETRADITIONAL("zh-TW");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
