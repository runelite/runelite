/*
 * Copyright (c) 2026
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
package net.runelite.client.audio;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.Map;

/** Minimal SDL3 C binding. No LWJGL Java bindings or JNI version coupling. */
interface Sdl extends Library
{
	int INIT_AUDIO = 0x10;
	int EVENT_FIRST = 0;
	int EVENT_LAST = 0xffff;
	int DEFAULT_PLAYBACK = -1;
	int S16LE = 0x8010;

	static Sdl load()
	{
		String resource = nativeResource(Platform.RESOURCE_PREFIX);
		try
		{
			return Native.load(Native.extractFromResourcePath(resource).getAbsolutePath(), Sdl.class,
				Collections.singletonMap(OPTION_STRING_ENCODING, "UTF-8"));
		}
		catch (IOException e)
		{
			throw new UncheckedIOException(e);
		}
	}

	static String nativeResource(String platform)
	{
		String resource = Map.of(
			"win32-x86", "/windows/x86/org/lwjgl/sdl/SDL3.dll",
			"win32-x86-64", "/windows/x64/org/lwjgl/sdl/SDL3.dll",
			"win32-aarch64", "/windows/arm64/org/lwjgl/sdl/SDL3.dll",
			"linux-x86-64", "/linux/x64/org/lwjgl/sdl/libSDL3.so",
			"linux-aarch64", "/linux/arm64/org/lwjgl/sdl/libSDL3.so",
			"darwin-x86-64", "/macos/x64/org/lwjgl/sdl/libSDL3.dylib",
			"darwin-aarch64", "/macos/arm64/org/lwjgl/sdl/libSDL3.dylib"
		).get(platform);
		if (resource == null)
		{
			throw new IllegalStateException("Unsupported SDL audio platform: " + platform);
		}
		return resource;
	}

	// SDL3 bool is one byte; JNA's default Java boolean mapping is a four-byte int.
	byte SDL_SetAppMetadata(String name, String version, String identifier);
	byte SDL_InitSubSystem(int flags);
	void SDL_QuitSubSystem(int flags);
	void SDL_PumpEvents();
	void SDL_FlushEvents(int minType, int maxType);
	String SDL_GetError();
	int SDL_OpenAudioDevice(int device, Spec spec);
	void SDL_CloseAudioDevice(int device);
	Pointer SDL_CreateAudioStream(Spec source, Spec destination);
	byte SDL_BindAudioStream(int device, Pointer stream);
	byte SDL_PutAudioStreamData(Pointer stream, byte[] data, int length);
	byte SDL_SetAudioStreamGain(Pointer stream, float gain);
	byte SDL_FlushAudioStream(Pointer stream);
	int SDL_GetAudioStreamQueued(Pointer stream);
	int SDL_GetAudioStreamAvailable(Pointer stream);
	void SDL_DestroyAudioStream(Pointer stream);

	@Structure.FieldOrder({"format", "channels", "freq"})
	class Spec extends Structure
	{
		public int format = S16LE;
		public int channels;
		public int freq;
	}
}
