package net.runelite.cache.fs;

import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.fs.io.InputStream;

public class Archive
{
	private Index index; // member of this index
	private int archiveId;
	private int nameHash;
	private byte[] whirlpool;
	private int crc;
	private int revision;
	private List<File> files = new ArrayList<>();
	
	public Archive(Index index, int id)
	{
		this.index = index;
		this.archiveId = id;
	}
	
	public void load(InputStream stream, int numberOfFiles, int protocol)
	{
		int archive = 0;
		
		for (int i = 0; i < numberOfFiles; ++i)
		{
			int fileId = archive += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();

			File file = new File(this, fileId);
			this.files.add(file);
			//archive1.getValidFileIds()[index21] = fileId;
		}

		//archive1.setFiles(new FileReference[index2 + 1]);

//		for (int i = 0; i < archive1.getValidFileIds().length; ++i) {
//			archive1.getFiles()[archive1.getValidFileIds()[ki]] = new FileReference();
//		}
		
//		if (this.named)
//		{
//			for (index = 0; index < validArchivesCount; ++index)
//			{
//				ArchiveReference var14 = this.archives[this.validArchiveIds[index]];
//
//				for (index2 = 0; index2 < var14.getValidFileIds().length; ++index2)
//				{
//					var14.getFiles()[var14.getValidFileIds()[index2]].setNameHash(stream.readInt());
//				}
//			}
//		}
	}
	
	public void loadNames(InputStream stream, int numberOfFiles)
	{
		for (int i = 0; i < numberOfFiles; ++i)
		{
			File file = this.files.get(i);
			int name = stream.readInt();
			file.setNameHash(name);
		}
	}

	public int getNameHash()
	{
		return nameHash;
	}

	public void setNameHash(int nameHash)
	{
		this.nameHash = nameHash;
	}

	public byte[] getWhirlpool()
	{
		return whirlpool;
	}

	public void setWhirlpool(byte[] whirlpool)
	{
		this.whirlpool = whirlpool;
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
}
