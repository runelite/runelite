package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store implements Closeable
{
	private static final String MAIN_FILE_CACHE_DAT = "main_file_cache.dat2";
	private static final String MAIN_FILE_CACHE_IDX = "main_file_cache.idx";
	
	private final DataFile data;
	private final IndexFile index255;
	private final List<IndexFile> indexFiles = new ArrayList<>();
	
	public Store(File folder) throws IOException
	{
		data = new DataFile(this, new File(folder, MAIN_FILE_CACHE_DAT));
		index255 = new IndexFile(this, 255, new File(folder, MAIN_FILE_CACHE_IDX + "255"));
		
		for (int i = 0; i < index255.getIndexCount(); ++i)
			indexFiles.add(new IndexFile(this, i, new File(folder, MAIN_FILE_CACHE_IDX + i)));
	}

	@Override
	public void close() throws IOException
	{
		data.close();
		index255.close();
		for (IndexFile i : indexFiles)
			i.close();
	}
}
