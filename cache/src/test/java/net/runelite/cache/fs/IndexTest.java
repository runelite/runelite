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
package net.runelite.cache.fs;

import java.util.Random;
import net.runelite.cache.util.Djb2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class IndexTest
{
	@Test
	public void testLookupAfterAddingArchive()
	{
		Index index = new Index(0);
		assertNull(index.findArchiveByName("map"));
		assertNull(index.findArchiveByName(""));

		Archive archive = index.addArchive(7);
		assertSame(archive, index.findArchiveByName(""));
		archive.setNameHash(Djb2.hash("map"));
		assertSame(archive, index.findArchiveByName("map"));
		assertNull(index.findArchiveByName(""));
		assertNull(index.findArchiveByName("missing"));
	}

	@Test
	public void testHashCollisionUsesLowestArchiveId()
	{
		assertEquals(Djb2.hash("Aa"), Djb2.hash("BB"));
		Index index = new Index(0);
		Archive higher = index.addArchive(20);
		higher.setNameHash(Djb2.hash("Aa"));
		assertSame(higher, index.findArchiveByName("BB"));

		Archive lower = index.addArchive(10);
		lower.setNameHash(Djb2.hash("BB"));
		assertSame(lower, index.findArchiveByName("Aa"));
		assertSame(lower, index.findArchiveByName("BB"));

		assertTrue(index.removeArchive(lower));
		assertSame(higher, index.findArchiveByName("Aa"));
		assertTrue(index.removeArchive(higher));
		assertNull(index.findArchiveByName("BB"));
	}

	@Test
	public void testRenameUpdatesBothHashes()
	{
		Index index = new Index(0);
		Archive lower = index.addArchive(10);
		lower.setNameHash(Djb2.hash("original"));
		Archive higher = index.addArchive(20);
		higher.setNameHash(Djb2.hash("original"));
		assertSame(lower, index.findArchiveByName("original"));

		lower.setNameHash(Djb2.hash("renamed"));
		assertSame(lower, index.findArchiveByName("renamed"));
		assertSame(higher, index.findArchiveByName("original"));

		higher.setNameHash(Djb2.hash("renamed"));
		assertSame(lower, index.findArchiveByName("renamed"));
		assertNull(index.findArchiveByName("original"));
	}

	@Test
	public void testRemovalByEqualArchive()
	{
		Index index = new Index(0);
		Archive archive = index.addArchive(10);
		archive.setNameHash(Djb2.hash("map"));
		assertSame(archive, index.findArchiveByName("map"));

		Archive equivalent = new Archive(index, 10);
		equivalent.setNameHash(archive.getNameHash());
		assertSame(archive, index.findArchiveByName("map"));
		assertTrue(index.removeArchive(equivalent));
		assertNull(index.findArchiveByName("map"));
		assertFalse(index.removeArchive(equivalent));
	}

	@Test
	public void testLookupsMatchLinearScanAfterMutations()
	{
		Index index = new Index(0);
		Random random = new Random(0);
		String[] names = {"", "Aa", "BB", "map", "location", "missing"};
		for (int iteration = 0; iteration < 1000; ++iteration)
		{
			int id = random.nextInt(100);
			Archive archive = index.getArchive(id);
			if (archive == null)
			{
				archive = index.addArchive(id);
			}
			else if (random.nextBoolean())
			{
				index.removeArchive(archive);
			}
			archive.setNameHash(Djb2.hash(names[random.nextInt(names.length - 1)]));

			for (String name : names)
			{
				Archive expected = null;
				for (Archive candidate : index.getArchives())
				{
					if (candidate.getNameHash() == Djb2.hash(name))
					{
						expected = candidate;
						break;
					}
				}
				assertSame(expected, index.findArchiveByName(name));
			}
		}
	}
}
