package net.runelite.cache.fs;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.fs.io.InputStream;
import net.runelite.cache.fs.io.OutputStream;
import net.runelite.cache.fs.util.bzip2.BZip2Decompressor;
import net.runelite.cache.fs.util.gzip.GZipDecompressor;

public class Index implements Closeable
{
	private final Store store;
	private final IndexFile index;
	private final int id;
	private int compression;
	private boolean named, usesWhirpool;
	private int revision;
	private int crc;
	private byte[] whirlpool;
	private List<Archive> archives = new ArrayList<>();
	
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
	//	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public IndexFile getIndex()
	{
		return index;
	}
	
	public void load() throws IOException
	{	
		// read data from index255
		//Store store = index.getStore();
		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		IndexEntry entry = index255.read(id);
		byte[] b = dataFile.read(index255.getIndexFileId(), entry.getId(), entry.getSector(), entry.getLength());
		
		InputStream stream = new InputStream(b);
		
		//XTEA decrypt here
		
		this.compression = stream.readUnsignedByte();
		int compressedLength = stream.readInt();
		if (compressedLength < 0 || compressedLength > 1000000)
			throw new RuntimeException("Invalid archive header");
		
		byte[] data;
		switch (compression)
		{
			case 0:
				data = new byte[compressedLength];
				this.checkRevision(stream, compressedLength);
				stream.readBytes(data, 0, compressedLength);
				break;
			case 1:
			{
				int length = stream.readInt();
				data = new byte[length];
				this.checkRevision(stream, compressedLength);
				BZip2Decompressor.decompress(data, b, compressedLength, 9);
				break;
			}
			default:
			{
				int length = stream.readInt();
				data = new byte[length];
				this.checkRevision(stream, compressedLength);
				GZipDecompressor.decompress(stream, data);
			}
		}
		
		readIndexData(data);
		
		this.loadFiles();
	}
	
	private void checkRevision(InputStream stream, int compressedLength)
	{
		int offset = stream.getOffset();
		if (stream.getLength() - (compressedLength + stream.getOffset()) >= 2) {
			stream.setOffset(stream.getLength() - 2);
			this.revision = stream.readUnsignedShort();
			stream.setOffset(offset);
		}
		else {
			this.revision = -1;
		}

	}
	
	private void readIndexData(byte[] data)
	{
		InputStream stream = new InputStream(data);
		int protocol = stream.readUnsignedByte();
		if (protocol >= 5 && protocol <= 7)
		{
			if (protocol >= 6)
			{
				int revision = stream.readInt(); // what is this and why is it different from checkRevision?
			}

			int hash = stream.readUnsignedByte();
			this.named = (1 & hash) != 0;
			this.usesWhirpool = (2 & hash) != 0;
			int validArchivesCount = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
//			this.validArchiveIds = new int[validArchivesCount];
			int lastArchiveId = 0;
//			int biggestArchiveId = 0;

			int index;
			int archive;
			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = lastArchiveId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				Archive a = new Archive(this, archive);
				this.archives.add(a);
//				if (archive > biggestArchiveId) {
//					biggestArchiveId = archive;
//				}
//
//				this.validArchiveIds[index] = archive;
			}

			//this.archives = new ArchiveReference[biggestArchiveId + 1];
			for (index = 0; index < validArchivesCount; ++index)
			{
				Archive a = this.archives.get(index);
				//this.archives[this.validArchiveIds[index]] = new ArchiveReference();
			}

			if (this.named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					int nameHash = stream.readInt();
					Archive a = this.archives.get(index);
					a.setNameHash(nameHash);
					//this.archives[this.validArchiveIds[index]].setNameHash(stream.readInt());
				}
			}

			if (this.usesWhirpool)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					byte[] var13 = new byte[64];
					stream.getBytes(var13, 0, 64);

					Archive a = this.archives.get(index);
					a.setWhirlpool(var13);
					//this.archives[this.validArchiveIds[index]].setWhirpool(var13);
				}
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int crc = stream.readInt();

				Archive a = this.archives.get(index);
				a.setCrc(crc);
				//this.archives[this.validArchiveIds[index]].setCrc(stream.readInt());
			}

			for (index = 0; index < validArchivesCount; ++index)
			{
				int revision = stream.readInt();

				Archive a = this.archives.get(index);
				a.setRevision(revision);
				//this.archives[this.validArchiveIds[index]].setRevision(stream.readInt());
			}

			int[] numberOfFiles = new int[validArchivesCount];
			for (index = 0; index < validArchivesCount; ++index)
			{
				int num = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				numberOfFiles[index] = num;
				//this.archives[this.validArchiveIds[index]].setValidFileIds(new int[protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort()]);
			}

			int index2;
			for (index = 0; index < validArchivesCount; ++index)
			{
				archive = 0;
				index2 = 0;

				Archive a = this.archives.get(index);
				a.load(stream, numberOfFiles[index], protocol);
				//ArchiveReference archive1 = this.archives[this.validArchiveIds[index]];

//				int index21;
//				for (index21 = 0; index21 < archive1.getValidFileIds().length; ++index21) {
//					int fileId = archive += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
//					if (fileId > index2) {
//						index2 = fileId;
//					}
//
//					archive1.getValidFileIds()[index21] = fileId;
//				}
//
//				archive1.setFiles(new FileReference[index2 + 1]);
//
//				for (index21 = 0; index21 < archive1.getValidFileIds().length; ++index21) {
//					archive1.getFiles()[archive1.getValidFileIds()[index21]] = new FileReference();
//				}
			}

			if (this.named)
			{
				for (index = 0; index < validArchivesCount; ++index)
				{
					Archive a = this.archives.get(index);
					a.loadNames(stream, numberOfFiles[index]);
					//ArchiveReference var14 = this.archives[this.validArchiveIds[index]];

//					for (index2 = 0; index2 < var14.getValidFileIds().length; ++index2)
//					{
//						var14.getFiles()[var14.getValidFileIds()[index2]].setNameHash(stream.readInt());
//					}
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
			//is this id supposed to be this.index.id? are those the same?
			assert this.index.getIndexFileId() == this.id;
			byte[] b = store.getData().read(this.id, entry.getId(), entry.getSector(), entry.getLength()); // needs decompress etc...
			
			//if (b == null) continue;
			
			InputStream stream = new InputStream(b);

			this.compression = stream.readUnsignedByte();
			int compressedLength = stream.readInt();
			if (compressedLength < 0 || compressedLength > 1000000)
			{
				throw new RuntimeException("Invalid archive header");
			}

			byte[] data;
			switch (compression)
			{
				case 0:
					data = new byte[compressedLength];
					this.checkRevision(stream, compressedLength);
					stream.readBytes(data, 0, compressedLength);
					break;
				case 1:
				{
					int length = stream.readInt();
					data = new byte[length];
					this.checkRevision(stream, compressedLength);
					BZip2Decompressor.decompress(data, b, compressedLength, 9);
					break;
				}
				default:
				{
					int length = stream.readInt();
//					if(length > 0 && length <= 1000000000) {
						data = new byte[length];
						this.checkRevision(stream, compressedLength);
						GZipDecompressor.decompress(stream, data);
//					} else continue;//data = null;
				}
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
			stream = new InputStream(data);
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

//			count = 0;
//			int[] var17;
//			int var16 = (var17 = this.table.getArchives()[archiveId].getValidFileIds()).length;
//
//			for (i = 0; i < var16; ++i)
//			{
//				fileId = var17[i];
//				this.cachedFiles[archiveId][fileId] = var18[count++];
//			}

		}
	}
	
	public void save()
	{
		OutputStream stream = new OutputStream();
		int protocol = 7;//this.getProtocol();
		stream.writeByte(protocol);
		if (protocol >= 6)
		{
			stream.writeInt(this.revision);
		}

		stream.writeByte((this.named ? 1 : 0) | (this.usesWhirpool ? 2 : 0));
		if (protocol >= 7)
		{
			stream.writeBigSmart(this.archives.size());
		}
		else
		{
			stream.writeShort(this.archives.size());
		}

		int data;
//		int archive;
		for (data = 0; data < this.archives.size(); ++data)
		//for (data = 0; data < this.validArchiveIds.length; ++data)
		{
			Archive a = this.archives.get(data);
			int archive = a.getArchiveId();
			//archive = this.validArchiveIds[data];
			if (data != 0)
			{
				Archive prev = this.archives.get(data - 1);
				archive -= prev.getArchiveId();
				//archive -= this.validArchiveIds[data - 1];
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

		if (this.named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			//for (data = 0; data < this.validArchiveIds.length; ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeInt(a.getNameHash());
				//stream.writeInt(this.archives[this.validArchiveIds[data]].getNameHash());
			}
		}

		if (this.usesWhirpool)
		{
			for (data = 0; data < this.archives.size(); ++data)
			{
				Archive a = this.archives.get(data);
				stream.writeBytes(a.getWhirlpool());
				//stream.writeBytes(this.archives[this.validArchiveIds[data]].getWhirpool());
			}
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getCrc());
			//stream.writeInt(this.archives[this.validArchiveIds[data]].getCRC());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			stream.writeInt(a.getRevision());
			//stream.writeInt(this.archives[this.validArchiveIds[data]].getRevision());
		}

		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			
			int len = a.getFiles().size();
			//archive = this.archives[this.validArchiveIds[data]].getValidFileIds().length;
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
		//ArchiveReference var8;
		for (data = 0; data < this.archives.size(); ++data)
		{
			Archive a = this.archives.get(data);
			//var8 = this.archives[this.validArchiveIds[data]];

			for (index2 = 0; index2 < a.getFiles().size(); ++index2)
			//for (index2 = 0; index2 < var8.getValidFileIds().length; ++index2)
			{
				File file = a.getFiles().get(index2);
				int offset = file.getFileId();
				//int offset = var8.getValidFileIds()[index2];
				if (index2 != 0)
				{
					File prev = a.getFiles().get(index2 - 1);
					offset -= prev.getFileId();
					//offset -= var8.getValidFileIds()[index2 - 1];
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

		if (this.named)
		{
			for (data = 0; data < this.archives.size(); ++data)
			//for (data = 0; data < this.validArchiveIds.length; ++data)
			{
				Archive a = this.archives.get(data);
				//var8 = this.archives[this.validArchiveIds[data]];

				for (index2 = 0; index2 < a.getFiles().size(); ++index2)
//				for (index2 = 0; index2 < var8.getValidFileIds().length; ++index2)
				{
					File file = a.getFiles().get(index2);
					stream.writeInt(file.getNameHash());
					//stream.writeInt(var8.getFiles()[var8.getValidFileIds()[index2]].getNameHash());
				}
			}
		}

//		byte[] var9 = new byte[stream.getOffset()];
//		stream.setOffset(0);
//		stream.getBytes(var9, 0, var9.length);
//		return this.archive.editNoRevision(var9, mainFile);
	}
}
