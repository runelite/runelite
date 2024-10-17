/*
 * Copyright (c) 2023 Abex
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
package net.runelite.client.externalplugins;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.runelite.client.RuneLite;

public class PluginHubManifest
{
	public static final Base64.Encoder HASH_ENCODER = Base64.getUrlEncoder().withoutPadding();

	@Data
	public static class JarData
	{
		private String internalName;
		private String displayName;
		private String jarHash;
		private int jarSize;

		File getJarFile()
		{
			return new File(RuneLite.PLUGINS_DIR, internalName + "_" + jarHash + ".jar");
		}

		boolean isValid()
		{
			File file = getJarFile();

			try
			{
				if (file.exists())
				{
					HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
					if (this.jarHash.equals(HASH_ENCODER.encodeToString(hash.asBytes())))
					{
						return true;
					}
				}
			}
			catch (IOException e)
			{
			}
			return false;
		}
	}

	@Data
	public static class ManifestLite
	{
		private List<JarData> jars;
	}

	@Data
	@EqualsAndHashCode(callSuper = true)
	public static class ManifestFull extends ManifestLite
	{
		private List<DisplayData> display;
	}

	@Data
	public static class DisplayData
	{
		private String internalName;
		private String displayName;
		private String version;

		@Nullable
		private String iconHash;

		private long createdAt;
		private long lastUpdatedAt;

		private String author;

		@Nullable
		private String description;

		@Nullable
		private String warning;

		@Nullable
		private String[] tags;

		@Nullable
		private String unavailableReason;

		public boolean hasIcon()
		{
			return iconHash != null;
		}
	}

	@Data
	@EqualsAndHashCode(callSuper = true)
	public static class Stub extends DisplayData
	{
		private String[] plugins;
	}
}