package net.runelite.rs.api;

import java.io.RandomAccessFile;
import net.runelite.mapping.Import;

public interface RSAccessFile
{
	@Import("file")
	RandomAccessFile getFile();

	@Import("offset")
	long getPosition();

	@Import("maxSize")
	long getLength();
}
