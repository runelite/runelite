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
package net.runelite.api;

/**
 * Stores the clients persisting preferences.
 */
public interface Preferences
{
	/**
	 * Gets the remembered login username.
	 *
	 * @return the remembered username
	 */
	String getRememberedUsername();

	/**
	 * Sets the remembered login username.
	 *
	 * @param username the new remembered username
	 */
	void setRememberedUsername(String username);

	/**
	 * Gets the sound effect volume
	 * @return volume 0-127 inclusive
	 */
	int getSoundEffectVolume();

	/**
	 * Sets the sound effect volume
	 * @param volume 0-127 inclusive
	 */
	void setSoundEffectVolume(int volume);

	/**
	 * Gets the area sound effect volume
	 * @return volume 0-127 inclusive
	 */
	int getAreaSoundEffectVolume();

	/**
	 * Sets the area sound effect volume
	 * @param volume 0-127 inclusive
	 */
	void setAreaSoundEffectVolume(int volume);

	/**
	 * Gets if the login name should be replaced with asterisks
	 */
	boolean getHideUsername();
}
