package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.runelite.cache.fs.io.InputStream;
import net.runelite.cache.fs.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Index implements Closeable
{
	private static final Logger logger = LoggerFactory.getLogger(Index.class);
	
	private final Store store;
	private final IndexFile index;
	private final int id;
	private int revision;
	private final List<Archive> archives = new ArrayList<>();
	
	public Index(Store store, IndexFile index, int id)
	{
		this.store = store;
		this.index = index;
		this.id = id;
	}
	
	@Override
	public void close() throws IOException
	{
		index.close();
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.index);
		hash = 97 * hash + this.id;
		hash = 97 * hash + this.revision;
		hash = 97 * hash + Objects.hashCode(this.archives);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Index other = (Index) obj;
		if (!Objects.equals(this.index, other.index))
		{
			return false;
		}
		if (this.id != other.id)
		{
			return false;
		}
		if (this.revision != other.revision)
		{
			return false;
		}
		if (!Objects.equals(this.archives, other.archives))
		{
			return false;
		}
		return true;
	}

	public int getId()
	{
		return id;
	}

	public IndexFile getIndex()
	{
		return index;
	}

	public List<Archive> getArchives()
	{
		return archives;
	}
	
	public Archive addArchive(int id)
	{
		Archive archive = new Archive(this, id);
		this.archives.add(archive);
		return archive;
	}
	
	public void load() throws IOException
	{	
		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		IndexEntry entry = index255.read(id);
		DataFileReadResult res = dataFile.read(index255.getIndexFileId(), entry.getId(), entry.getSector(), entry.getLength());
		byte[] data = res.data;
		
		readIndexData(data);
		
		this.loadFiles();
	}
	
	public void save() throws IOException
	{
		saveFiles();
		
		byte[] data = this.writeIndexData();

		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		DataFileWriteResult res = dataFile.write(index255.getIndexFileId(), this.id, ByteBuffer.wrap(data), 0, this.revision);
		index255.write(new IndexEntry(index255, id, res.sector, res.compressedLength));
	}
	
	private void readIndexData(byte[] data)
	{
		InputStream stream = new InputStream(data);
		int protocol = stream.readUnsignedByte();
		if (protocol >= 5 && protocol <= 7)
		{
			if (protocol >= 6)
			{
				this.revision = stream.readInt();
			}

			int hash = stream.readUnsignedByte();
			boolean named = (1 & hash) != 0;
			boolean usesWhirpool = (2 & hash) != 0;
			int validArchivesCount = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
			int lastArchiveId = 0;

			int index;
			int archive;
			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = lastArchiveId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				Archive a = new Archive(this, archive);
				this.archives.add(a);
			}

			if (named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					int nameHash = stream.readInt();
					Archive a = this.archives.get(index);
					a.setNameHash(nameHash);
				}
			}

			if (usesWhirpool)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					byte[] var13 = new byte[64];
					stream.getBytes(var13, 0, 64);

					Archive a = this.archives.get(index);
					a.setWhirlpool(var13);
				}
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int crc = stream.readInt();

				Archive a = this.archives.get(index);
				a.setCrc(crc);
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int revision = stream.readInt();

				Archive a = this.archives.get(index);
				a.setRevision(revision);
			}

			int[] numberOfFiles = new int[validArchivesCount];
			for (index = 0; index < validArchivesCount; ++index)
			{
				int num = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				numberOfFiles[index] = num;
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = 0;

				Archive a = this.archives.get(index);
				a.load(stream, numberOfFiles[index], protocol);
			}

			if (named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					Archive a = this.archives.get(index);
					a.loadNames(stream, numberOfFiles[index]);
				}
			}
		}
	}
	
	private void loadFiles() throws IOException
	{
		// get data from index file
		for (Archive a : archives)
		{
			IndexEntry entry = this.index.read(a.getArchiveId());
			if (entry == null)
			{
				logger.warn("can't read archive " + a.getArchiveId() + " from index " + this.id);
				continue;
			}
			
			assert this.index.getIndexFileId() == this.id;
			assert entry.getId() == a.getArchiveId();
			DataFileReadResult res = store.getData().read(this.id, entry.getId(), entry.getSector(), entry.getLength()); // needs decompress etc...
			byte[] data = res.data;
			
			if (a.getCrc() != res.crc)
			{
				logger.warn("crc mismatch for archive {}", a);
			}
			
			if (a.getWhirlpool() != null && !Arrays.equals(a.getWhirlpool(), res.whirlpool))
			{
				logger.warn("whirlpool mismatch for archive {}", a);
			}

			if (a.getFiles().size() == 1)
			{
				a.getFiles().get(0).setContents(data);
				continue;
			}
			
			final int filesCount = a.getFiles().size();
			
			int readPosition = data.length;
			--readPosition;
			int amtOfLoops = data[readPosition] & 255;
			readPosition -= amtOfLoops * filesCount * 4;
			InputStream stream = new InputStream(data);
			stream.setOffset(readPosition);
			int[] filesSize = new int[filesCount];

			int sourceOffset;
			int count;
			for (int filesData = 0; filesData < amtOfLoops; ++filesData)
			{
				sourceOffset = 0;

				for (count = 0; count < filesCount; ++count)
				{
					filesSize[count] += sourceOffset += stream.readInt();
				}
			}

			byte[][] var18 = new byte[filesCount][];

			for (sourceOffset = 0; sourceOffset < filesCount; ++sourceOffset)
			{
				var18[sourceOffset] = new byte[filesSize[sourceOffset]];
				filesSize[sourceOffset] = 0;
			}

			stream.setOffset(readPosition);
			sourceOffset = 0;

			int fileId;
			int i;
			for (count = 0; count < amtOfLoops; ++count)
			{
				fileId = 0;

				for (i = 0; i < filesCount; ++i)
				{
					fileId += stream.readInt();
					System.arraycopy(data, sourceOffset, var18[i], filesSize[i], fileId);
					sourceOffset += fileId;
					filesSize[i] += fileId;
				}
			}
			
			for (i = 0; i < filesCount; ++i)
			{
				File f = a.getFiles().get(i);
				f.setContents(var18[i]);
			}
		}
	}
	
	public void saveFiles() throws IOException
	{
		for (Archive a : archives)
		{
			OutputStream stream = new OutputStream();
			
			int sourceOffset = 0;
			final int filesCount = a.getFiles().size();
			
			if (filesCount == 1)
			{
				File file = a.getFiles().get(0);
				stream.writeBytes(file.getContents());
			}
			else
			{
				for (int i = 0; i < filesCount; ++i)
				{
					File file = a.getFiles().get(i);
					stream.writeBytes(file.getContents());
				}
			
				for (int count = 0; count < filesCount; ++count)
				{
					File file = a.getFiles().get(count);

					int sz = file.getSize() - sourceOffset;
					sourceOffset = file.getSize();
					stream.writeInt(sz);
				}

				stream.writeByte(1); // number of loops
			}
			
			byte[] fileData = new byte[stream.getOffset()];
			stream.setOffset(0);
			stream.getBytes(fileData, 0, fileData.length);
			
			assert this.index.getIndexFileId() == this.id;
			DataFile data = store.getData();
			
			// XXX old data is just left there in the file?
			DataFileWriteResult res = data.write(this.id, a.getArchiveId(), ByteBuffer.wrap(fileData), 0, this.revision);
			this.index.write(new IndexEntry(this.index, a.getArchiveId(), res.sector, res.compressedLength));
			
			a.setCrc(res.crc);
			a.setWhirlpool(res.whirlpool);
		}
	}
	
	public byte[] writeIndexData()
	{
		OutputStream stream = new OutputStream();
		int protocol = 7;//this.getProtocol();
		stream.writeByte(protocol);
		if (protocol >= 6)
		{
			stream.writeInt(this.revision);
		}

		boolean named = true, usesWhirpool = false;
		stream.writeByte((named ? 1 : 0) | (usesWhirpool ? 2 : 0));
		if (protocol >= 7)
		{
			stream.writeBigSmart(this.archives.size());
		}
		else
		{
			stream.writeShort(this.archives.size());
		}

		int data;
		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			int archive = a.getArchiveId();

			if (data != 0)
			{
				Archive prev = this.archives.get(data - 1);
				archive -= prev.getArchiveId();
			}

			if (protocol >= 7)
			{
				stream.writeBigSmart(archive);
			}
			else
			{
				stream.writeShort(archive);
			}
		}

		if (named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeInt(a.getNameHash());
			}
		}

		if (usesWhirpool)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeBytes(a.getWhirlpool());
			}
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getCrc());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getRevision());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			
			int len = a.getFiles().size();

			if (protocol >= 7)
			{
				stream.writeBigSmart(len);
			}
			else
			{
				stream.writeShort(len);
			}
		}

		int index2;
		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);

			for (index2 = 0; index2 < a.getFiles().size(); ++index2)
			{
				File file = a.getFiles().get(index2);
				int offset = file.getFileId();

				if (index2 != 0)
				{
					File prev = a.getFiles().get(index2 - 1);
					offset -= prev.getFileId();
				}

				if (protocol >= 7)
				{
					stream.writeBigSmart(offset);
				}
				else
				{
					stream.writeShort(offset);
				}
			}
		}

		if (named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);

				for (index2 = 0; index2 < a.getFiles().size(); ++index2)
				{
					File file = a.getFiles().get(index2);
					stream.writeInt(file.getNameHash());
				}
			}
		}

		byte[] indexData = new byte[stream.getOffset()];
		stream.setOffset(0);
		stream.getBytes(indexData, 0, indexData.length);
		return indexData;
	}
}
