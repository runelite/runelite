package net.runelite.rs.api;

import java.io.RandomAccessFile;
import net.runelite.mapping.Import;

public interface RSFileOnDisk
{
	@Import("file")
	RandomAccessFile getFile();

	@Import("index")
	long getPosition();

	@Import("capacity")
	long getLength();
}
