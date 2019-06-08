/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
 * Represents the template of a specific object.
 */
public interface ObjectComposition
{
	/**
	 * Gets ID for the object.
	 *
	 * @return the object ID
	 */
	int getId();

	/**
	 * Gets the name of the object.
	 *
	 * @return the object name
	 */
	String getName();

	/**
	 * Gets an array of possible right-click menu actions that can be
	 * performed on the object.
	 *
	 * @return the menu actions
	 */
	String[] getActions();

	/**
	 * Gets the map scene ID for the object.
	 *
	 * @return the scene ID
	 */
	int getMapSceneId();

	/**
	 * Gets the map icon ID for the object.
	 *
	 * @return the map icon ID
	 */
	int getMapIconId();

	/**
	 * Gets IDs for objects that are considered fakes of this object,
	 * such as barrows walls.
	 *
	 * @return the impostor IDs
	 */
	int[] getImpostorIds();

	/**
	 * Gets the impostor composition for this object.
	 *
	 * @return the impostor
	 */
	ObjectComposition getImpostor();
}
