/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.deob.updater;

import com.google.common.base.Strings;

public class GameConfigUpdateDetector
{
	private final GameConfig g1, g2;

	public GameConfigUpdateDetector(GameConfig g1, GameConfig g2)
	{
		this.g1 = g1;
		this.g2 = g2;
	}

	public boolean hasUpdated()
	{
		// between game updatesthe parameters are scrambled, so detect when that happens.
		// normally only one parameter changes, which is some integer value (+ the world)
		//
		// N.B. my other idea is to compare content-length in HEAD requests for the gamepack.
		// the httpd doesn't support if-match and does not etag anything, and the last-modified time
		// appears to be constant NOW-1 week (it moves per request)
		
		int differences = 0;

		for (String key : g1.getAppletProperties().keySet())
		{
			String value = g1.getAppletProperty(key), otherValue = g2.getAppletProperty(key);

			if (!Strings.nullToEmpty(value).equals(Strings.nullToEmpty(otherValue)))
				++differences;
		}

		return differences > 2; // random number, world
	}
}
