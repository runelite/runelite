/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.rs.auth;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;

class MacOSCredentialStore
{
	private static final String SERVICE = "RuneLite";
	private static final String ACCOUNT = "SessionStore";
	private static final int ERR_SEC_ITEM_NOT_FOUND = -25300;
	private static final int KEY_LENGTH = 32;
	private static final int K_CF_STRING_ENCODING_UTF8 = 0x08000100;
	private static final Pointer CF_TYPE_DICTIONARY_KEY_CALLBACKS =
		globalAddress("CoreFoundation", "kCFTypeDictionaryKeyCallBacks");
	private static final Pointer CF_TYPE_DICTIONARY_VALUE_CALLBACKS =
		globalAddress("CoreFoundation", "kCFTypeDictionaryValueCallBacks");
	private static final Pointer CF_BOOLEAN_TRUE = global("CoreFoundation", "kCFBooleanTrue");
	private static final Pointer SEC_CLASS = global("Security", "kSecClass");
	private static final Pointer SEC_CLASS_GENERIC_PASSWORD = global("Security", "kSecClassGenericPassword");
	private static final Pointer SEC_ATTR_SERVICE = global("Security", "kSecAttrService");
	private static final Pointer SEC_ATTR_ACCOUNT = global("Security", "kSecAttrAccount");
	private static final Pointer SEC_RETURN_DATA = global("Security", "kSecReturnData");
	private static final Pointer SEC_MATCH_LIMIT = global("Security", "kSecMatchLimit");
	private static final Pointer SEC_MATCH_LIMIT_ONE = global("Security", "kSecMatchLimitOne");
	private static final Pointer SEC_VALUE_DATA = global("Security", "kSecValueData");

	private MacOSCredentialStore()
	{
	}

	static byte[] getOrCreateKey() throws IOException
	{
		int status;
		PointerByReference resultRef = new PointerByReference();
		Pointer query = createQuery(true);
		try
		{
			status = Security.INSTANCE.SecItemCopyMatching(query, resultRef);
		}
		finally
		{
			CoreFoundation.INSTANCE.CFRelease(query);
		}

		if (status == 0)
		{
			Pointer result = resultRef.getValue();
			try
			{
				if (result == null || CoreFoundation.INSTANCE.CFDataGetLength(result).longValue() != KEY_LENGTH)
				{
					throw new IOException("Invalid encryption key in macOS Keychain");
				}
				Pointer data = CoreFoundation.INSTANCE.CFDataGetBytePtr(result);
				if (data == null)
				{
					throw new IOException("Unable to read encryption key from macOS Keychain");
				}
				return data.getByteArray(0, KEY_LENGTH);
			}
			finally
			{
				CoreFoundation.INSTANCE.CFRelease(result);
			}
		}

		if (status != ERR_SEC_ITEM_NOT_FOUND)
		{
			throw new IOException("Unable to read encryption key from macOS Keychain (error " + status + ")");
		}

		byte[] key = new byte[KEY_LENGTH];
		new SecureRandom().nextBytes(key);
		Pointer attributes = createQuery(false);
		Pointer keyData = CoreFoundation.INSTANCE.CFDataCreate(null, key, new NativeLong(key.length));
		try
		{
			put(attributes, SEC_VALUE_DATA, keyData);
			status = Security.INSTANCE.SecItemAdd(attributes, null);
		}
		finally
		{
			CoreFoundation.INSTANCE.CFRelease(keyData);
			CoreFoundation.INSTANCE.CFRelease(attributes);
		}

		if (status == 0)
		{
			return key;
		}
		Arrays.fill(key, (byte) 0);
		throw new IOException("Unable to save encryption key to macOS Keychain (error " + status + ")");
	}

	private static Pointer createQuery(boolean returnData)
	{
		Pointer query = CoreFoundation.INSTANCE.CFDictionaryCreateMutable(null, new NativeLong(4),
			CF_TYPE_DICTIONARY_KEY_CALLBACKS, CF_TYPE_DICTIONARY_VALUE_CALLBACKS);
		put(query, SEC_CLASS, SEC_CLASS_GENERIC_PASSWORD);
		putString(query, SEC_ATTR_SERVICE, SERVICE);
		putString(query, SEC_ATTR_ACCOUNT, ACCOUNT);
		if (returnData)
		{
			put(query, SEC_RETURN_DATA, CF_BOOLEAN_TRUE);
			put(query, SEC_MATCH_LIMIT, SEC_MATCH_LIMIT_ONE);
		}
		return query;
	}

	private static void putString(Pointer dictionary, Pointer key, String value)
	{
		Pointer cfString = CoreFoundation.INSTANCE.CFStringCreateWithCString(null, value, K_CF_STRING_ENCODING_UTF8);
		try
		{
			put(dictionary, key, cfString);
		}
		finally
		{
			CoreFoundation.INSTANCE.CFRelease(cfString);
		}
	}

	private static void put(Pointer dictionary, Pointer key, Pointer value)
	{
		CoreFoundation.INSTANCE.CFDictionarySetValue(dictionary, key, value);
	}

	private static Pointer global(String library, String name)
	{
		NativeLibrary nativeLibrary = NativeLibrary.getInstance(library);
		return nativeLibrary.getGlobalVariableAddress(name).getPointer(0);
	}

	private static Pointer globalAddress(String library, String name)
	{
		return NativeLibrary.getInstance(library).getGlobalVariableAddress(name);
	}

	private interface Security extends Library
	{
		Security INSTANCE = Native.load("Security", Security.class);

		int SecItemAdd(Pointer attributes, PointerByReference result);

		int SecItemCopyMatching(Pointer query, PointerByReference result);
	}

	private interface CoreFoundation extends Library
	{
		CoreFoundation INSTANCE = Native.load("CoreFoundation", CoreFoundation.class);

		Pointer CFDictionaryCreateMutable(Pointer allocator, NativeLong capacity, Pointer keyCallBacks,
			Pointer valueCallBacks);

		void CFDictionarySetValue(Pointer dictionary, Pointer key, Pointer value);

		Pointer CFStringCreateWithCString(Pointer allocator, String string, int encoding);

		Pointer CFDataCreate(Pointer allocator, byte[] bytes, NativeLong length);

		NativeLong CFDataGetLength(Pointer data);

		Pointer CFDataGetBytePtr(Pointer data);

		void CFRelease(Pointer object);
	}
}
