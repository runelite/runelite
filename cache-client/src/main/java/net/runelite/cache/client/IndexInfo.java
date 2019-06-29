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
package net.runelite.cache.client;

public class IndexInfo
{
	private final int id;
	private final int crc;
	private final int revision;

	public IndexInfo(int id, int crc, int revision)
	{
		this.id = id;
		this.crc = crc;
		this.revision = revision;
	}

	@Override
	public String toString()
	{
		return "IndexInfo{" + "id=" + id + ", crc=" + crc + ", revision=" + revision + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 71 * hash + this.id;
		hash = 71 * hash + this.crc;
		hash = 71 * hash + this.revision;
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
		final IndexInfo other = (IndexInfo) obj;
		if (this.id != other.id)
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
		return true;
	}

	public int getId()
	{
		return id;
	}

	public int getCrc()
	{
		return crc;
	}

	public int getRevision()
	{
		return revision;
	}
}
