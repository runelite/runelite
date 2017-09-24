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
package net.runelite.http.service.cache.beans;

import java.util.Arrays;

public class ArchiveEntry
{
	private int id;
	private int archiveId;
	private int nameHash;
	private int crc;
	private int revision;
	private byte[] hash;

	@Override
	public String toString()
	{
		return "ArchiveEntry{" + "id=" + id + ", archiveId=" + archiveId + ", nameHash=" + nameHash + ", crc=" + crc + ", revision=" + revision + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 53 * hash + this.id;
		hash = 53 * hash + this.archiveId;
		hash = 53 * hash + this.nameHash;
		hash = 53 * hash + this.crc;
		hash = 53 * hash + this.revision;
		hash = 53 * hash + Arrays.hashCode(this.hash);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ArchiveEntry other = (ArchiveEntry) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.archiveId != other.archiveId)
		{
			return false;
		}
		if (this.nameHash != other.nameHash)
		{
			return false;
		}
		if (this.crc != other.crc)
		{
			return false;
		}
		if (this.revision != other.revision)
		{
			return false;
		}
		if (!Arrays.equals(this.hash, other.hash))
		{
			return false;
		}
		return true;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getArchiveId()
	{
		return archiveId;
	}

	public void setArchiveId(int archiveId)
	{
		this.archiveId = archiveId;
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

	public int getCrc()
	{
		return crc;
	}

	public void setCrc(int crc)
	{
		this.crc = crc;
	}

	public int getRevision()
	{
		return revision;
	}

	public void setRevision(int revision)
	{
		this.revision = revision;
	}

	public byte[] getHash()
	{
		return hash;
	}

	public void setHash(byte[] hash)
	{
		this.hash = hash;
	}

}
