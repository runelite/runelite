package net.runelite.cache.fs;

public class DataFileWriteResult
{
	public int sector, compressedLength;
	public int crc; // crc of compressed data
	public byte[] whirlpool;
}
