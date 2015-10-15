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
	
	private final File folder;
	private final DataFile data;
	private final IndexFile index255;
	private final List<Index> indexes = new ArrayList<>();
	
	public Store(File folder) throws IOException
	{
		this.folder = folder;
		
		data = new DataFile(this, new File(folder, MAIN_FILE_CACHE_DAT));
		index255 = new IndexFile(this, 255, new File(folder, MAIN_FILE_CACHE_IDX + "255"));
		
		for (int i = 0; i < index255.getIndexCount(); ++i)
		{
			this.addIndex(i);
//			IndexFile ifile = new IndexFile(this, i, new File(folder, MAIN_FILE_CACHE_IDX + i));
//			Index index = new Index(this, ifile, i);
//			
//			indexes.add(index);
		}
	}

	@Override
	public void close() throws IOException
	{
		data.close();
		index255.close();
		for (Index i : indexes)
		//for (IndexFile i : indexFiles)
			i.close();
	}
	
	public Index addIndex(int id) throws FileNotFoundException
	{
		for (Index i : indexes)
			if (i.getIndex().getIndexFileId() == id)
				throw new IllegalArgumentException("index " + id + " already exists");
		
		IndexFile indexFile = new IndexFile(this, id, new File(folder, MAIN_FILE_CACHE_IDX + id));
		Index index = new Index(this, indexFile, id);
		
		this.indexes.add(index);
		
		return index;
	}
	
	public void load() throws IOException
	{
		for (Index i : indexes)
		{
			int id = i.getIndex().getIndexFileId();
			if (id == 3 || id == 7) // XXXXXXXXXXXXX
				i.load();
		}
	}
	
	public void save() throws IOException
	{
		for (Index i : indexes)
			i.save();
	}

	public DataFile getData()
	{
		return data;
	}

	public IndexFile getIndex255()
	{
		return index255;
	}
}
