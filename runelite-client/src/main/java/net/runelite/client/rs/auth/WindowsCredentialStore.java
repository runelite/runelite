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

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.io.IOException;
import java.security.SecureRandom;

class WindowsCredentialStore
{
	private static final String TARGET = "RuneLite SessionStore";
	private static final int CRED_TYPE_GENERIC = 1;
	private static final int CRED_PERSIST_LOCAL_MACHINE = 2;
	private static final int ERROR_NOT_FOUND = 1168;
	private static final int KEY_LENGTH = 32;

	private WindowsCredentialStore()
	{
	}

	static byte[] getOrCreateKey() throws IOException
	{
		PointerByReference credentialRef = new PointerByReference();
		if (Advapi32.INSTANCE.CredReadW(new WString(TARGET), CRED_TYPE_GENERIC, 0, credentialRef))
		{
			Pointer credentialPointer = credentialRef.getValue();
			try
			{
				Credential credential = new Credential(credentialPointer);
				credential.read();
				if (credential.credentialBlobSize.intValue() != KEY_LENGTH || credential.credentialBlob == null)
				{
					throw new IOException("Invalid encryption key in Windows Credential Manager");
				}
				return credential.credentialBlob.getByteArray(0, KEY_LENGTH);
			}
			finally
			{
				Advapi32.INSTANCE.CredFree(credentialPointer);
			}
		}

		int error = Kernel32.INSTANCE.GetLastError();
		if (error != ERROR_NOT_FOUND)
		{
			throw new IOException("Unable to read Windows credential (error " + error + ")");
		}

		byte[] key = new byte[KEY_LENGTH];
		new SecureRandom().nextBytes(key);
		writeKey(key);
		return key;
	}

	private static void writeKey(byte[] key) throws IOException
	{
		Memory blob = new Memory(key.length);
		blob.write(0, key, 0, key.length);
		Credential credential = new Credential();
		credential.flags = new DWORD(0);
		credential.type = new DWORD(CRED_TYPE_GENERIC);
		credential.targetName = new WString(TARGET);
		credential.comment = new WString("RuneLite Jagex account session token encryption key");
		credential.lastWritten = new WinBase.FILETIME();
		credential.credentialBlobSize = new DWORD(key.length);
		credential.credentialBlob = blob;
		credential.persist = new DWORD(CRED_PERSIST_LOCAL_MACHINE);
		credential.attributeCount = new DWORD(0);
		credential.attributes = null;
		credential.targetAlias = null;
		credential.userName = new WString("RuneLite");
		credential.write();
		if (!Advapi32.INSTANCE.CredWriteW(credential, 0))
		{
			throw new IOException("Unable to save encryption key to Windows Credential Manager (error " + Kernel32.INSTANCE.GetLastError() + ")");
		}
	}

	private interface Advapi32 extends StdCallLibrary
	{
		Advapi32 INSTANCE = Native.load("Advapi32", Advapi32.class, W32APIOptions.UNICODE_OPTIONS);

		boolean CredReadW(WString target, int type, int flags, PointerByReference credential);

		boolean CredWriteW(Credential credential, int flags);

		void CredFree(Pointer credential);
	}

	@Structure.FieldOrder({"flags", "type", "targetName", "comment", "lastWritten", "credentialBlobSize",
		"credentialBlob", "persist", "attributeCount", "attributes", "targetAlias", "userName"})
	public static class Credential extends Structure
	{
		public DWORD flags;
		public DWORD type;
		public WString targetName;
		public WString comment;
		public WinBase.FILETIME lastWritten;
		public DWORD credentialBlobSize;
		public Pointer credentialBlob;
		public DWORD persist;
		public DWORD attributeCount;
		public Pointer attributes;
		public WString targetAlias;
		public WString userName;

		public Credential()
		{
		}

		private Credential(Pointer pointer)
		{
			super(pointer);
		}
	}
}
