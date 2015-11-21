package net.runelite.rs.api;

import java.io.RandomAccessFile;

public interface FileOnDisk
{
	RandomAccessFile getFile();

	long getPosition();

	long getLength();
}
