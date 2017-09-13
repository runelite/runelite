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

public class FileEntry
{
	private int id;
	private int archiveId;
	private int fileId;
	private int nameHash;

	@Override
	public String toString()
	{
		return "FileEntry{" + "id=" + id + ", archiveId=" + archiveId + ", fileId=" + fileId + ", nameHash=" + nameHash + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 67 * hash + this.id;
		hash = 67 * hash + this.archiveId;
		hash = 67 * hash + this.fileId;
		hash = 67 * hash + this.nameHash;
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
		final FileEntry other = (FileEntry) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.archiveId != other.archiveId)
		{
			return false;
		}
		if (this.fileId != other.fileId)
		{
			return false;
		}
		if (this.nameHash != other.nameHash)
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

	public int getFileId()
	{
		return fileId;
	}

	public void setFileId(int fileId)
	{
		this.fileId = fileId;
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

}
