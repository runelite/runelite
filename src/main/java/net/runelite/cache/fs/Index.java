package net.runelite.cache.fs;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.fs.io.InputStream;
import net.runelite.cache.fs.util.bzip2.BZip2Decompressor;
import net.runelite.cache.fs.util.gzip.GZipDecompressor;

public class Index
{
	private final IndexFile index;
	private final int id;
	private int compression;
	private boolean named, usesWhirpool;
	private int revision;
	private int crc;
	private byte[] whirlpool;
	private List<Archive> archives = new ArrayList<>();
	
	public Index(IndexFile index, int id)
	{
		this.index = index;
		this.id = id;
	}
	
	public void load() throws IOException
	{	
		// read data from index255
		Store store = index.getStore();
		DataFile dataFile = store.getData();
		IndexFile index255 = store.getIndex255();
		
		IndexEntry entry = index255.read(id);
		byte[] b = dataFile.read(id, entry.getId(), entry.getSector(), entry.getLength());
		
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
		if (protocol >= 5 && protocol <= 7) {
			if (protocol >= 6) {
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
			for (index = 0; index < validArchivesCount; ++index) {
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

			for (index = 0; index < validArchivesCount; ++index) {
				Archive a = this.archives.get(index);
				//this.archives[this.validArchiveIds[index]] = new ArchiveReference();
			}

			if (this.named) {
				for (index = 0; index < validArchivesCount; ++index) {
					int nameHash = stream.readInt();
					Archive a = this.archives.get(index);
					a.setNameHash(nameHash);
					//this.archives[this.validArchiveIds[index]].setNameHash(stream.readInt());
				}
			}

			if (this.usesWhirpool) {
				for (index = 0; index < validArchivesCount; ++index) {
					byte[] var13 = new byte[64];
					stream.getBytes(var13, 0, 64);
					
					Archive a = this.archives.get(index);
					a.setWhirlpool(var13);
					//this.archives[this.validArchiveIds[index]].setWhirpool(var13);
				}
			}

			for (index = 0; index < validArchivesCount; ++index) {
				int crc = stream.readInt();
				
				Archive a = this.archives.get(index);
				a.setCrc(crc);
				//this.archives[this.validArchiveIds[index]].setCrc(stream.readInt());
			}

			for (index = 0; index < validArchivesCount; ++index) {
				int revision = stream.readInt();
				
				Archive a = this.archives.get(index);
				a.setRevision(revision);
				//this.archives[this.validArchiveIds[index]].setRevision(stream.readInt());
			}

			int[] numberOfFiles = new int[validArchivesCount];
			for (index = 0; index < validArchivesCount; ++index) {
				int num = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
				numberOfFiles[index] = num;
				//this.archives[this.validArchiveIds[index]].setValidFileIds(new int[protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort()]);
			}

			int index2;
			for (index = 0; index < validArchivesCount; ++index) {
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
}
