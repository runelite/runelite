package net.runelite.cache.fs;

public class DataFileReadResult
{
	public byte[] data;
	public int revision;
	public int crc; // crc of compressed data
	public byte[] whirlpool;
}
