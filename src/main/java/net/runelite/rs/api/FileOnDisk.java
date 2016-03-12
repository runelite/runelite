package net.runelite.rs.api;

import java.io.RandomAccessFile;
import net.runelite.mapping.Import;

public interface FileOnDisk
{
	@Import("file")
	RandomAccessFile getFile();

	@Import("position")
	long getPosition();

	@Import("length")
	long getLength();
}
