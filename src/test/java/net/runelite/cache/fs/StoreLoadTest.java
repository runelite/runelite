package net.runelite.cache.fs;

import java.io.FileOutputStream;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import org.junit.Test;

public class StoreLoadTest
{
	//@Test
	public void test() throws IOException
	{
		Store store = new Store(StoreLocation.LOCATION);
		store.load();
		System.out.println(store);
	}

	@Test
	public void unpackStore() throws IOException
	{
		java.io.File base = StoreLocation.LOCATION;
		try (Store store = new Store(base))
		{
			store.load();

			for (Index i : store.getIndexes())
			{
				java.io.File ifile = new java.io.File(base, "" + i.getId());
				ifile.mkdir();

				for (Archive a : i.getArchives())
				{
					java.io.File afile = new java.io.File(ifile, "" + a.getArchiveId());
					afile.mkdir();

					for (File f : a.getFiles())
					{
						java.io.File ffile = new java.io.File(afile, "" + f.getFileId());
						try (FileOutputStream fout = new FileOutputStream(ffile))
						{
							if (f.getContents() != null)
								fout.write(f.getContents());
						}
					}
				}
			}
		}
	}
}
