package net.runelite.client.plugins.regionlocker;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ChunkPickerLink
{
	private static final int rows = 25, cols = 43;
	private static final int left = 18, right = 60, down = 39, up = 63;

	private static String url = "https://gitgeddes.github.io/ChunkPicker/";

	public static int convertId(int regionId)
	{
		int x = regionId >> 8;
		int y = regionId & 255;
		if (x < left || x > right || y < down || y > up) return -1;

		int chunkX = x - left;
		int chunkY = abs(y - up);

		int chunkId = chunkX + chunkY * cols;

		return chunkId;
	}

	// Encode the chunk array into a GET request to avoid 1024 char limit
	public static String getUrl()
	{
		List<Integer> unlockedChunks = new ArrayList<>();
		List<Integer> potentialChunks = new ArrayList<>();
		for (Map.Entry<String, RegionTypes> entry : RegionLocker.getRegions().entrySet())
		{
			int regionId = Integer.parseInt(entry.getKey());
			RegionTypes type = entry.getValue();

			int id = convertId(regionId);
			if (id >= 0)
			{
				if (type == RegionTypes.UNLOCKED)
				{
					unlockedChunks.add(id);
				}
				else if (type == RegionTypes.UNLOCKABLE)
				{
					potentialChunks.add(id);
				}
			}
		}

		String unlocked = chunkIndexesIntoString(unlockedChunks);
		if (unlocked.isEmpty()) unlocked = "-";
		String potential = chunkIndexesIntoString(potentialChunks);
		if (potential.isEmpty()) potential = "-";



		// insert query for unlocked chunks
		return url + '?' + unlocked + ';' + potential;
	}

	public static String chunkIndexesIntoString(List<Integer> chunks)
	{
		List<String> combinedArray = new ArrayList<>();
		String combinedIndexes = "";
		int counter = 0;

		for (int i = 0; i < chunks.size(); i++)
		{
			counter++;
			// unify length of numbers
			combinedIndexes += StringUtils.leftPad(Integer.toString(chunks.get(i)), 4, '0');

			// Combine 3 chunk indexes into base64
			if (counter >= 3 || i >= chunks.size() - 1)
			{
				combinedArray.add(convert(combinedIndexes, BASE10, BASE62));
				combinedIndexes = "";
				counter = 0;
			}
		}

		String retval = "";
		if (combinedArray.size() >= 1)
		{
			retval += combinedArray.get(0);
		}
		for (int i = 1; i < combinedArray.size(); i++)
		{
			retval += "," + combinedArray.get(i);
		}

		return retval;
	}

	// Taken from https://rot47.net/base.html
	private static String BASE10 = "0123456789";
	private static String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	// Convert between two different number bases
	public static String convert(String src, String srctable, String desttable)
	{
		int srclen = srctable.length();
		int destlen = desttable.length();
		long val = 0;
		int numlen = src.length();
		for (int i = 0; i < numlen; i++)
		{
			val = val * srclen + srctable.indexOf(src.charAt(i));
		}
		if (val < 0)
		{
			return "";
		}
		double r = val % destlen;
		String res = Character.toString(desttable.charAt((int)r));
		double q = Math.floor((double)val / destlen);
		while (q > 0)
		{
			r = q % destlen;
			q = Math.floor(q / destlen);
			res = desttable.charAt((int)r) + res;
		}
		return res;
	}
}
