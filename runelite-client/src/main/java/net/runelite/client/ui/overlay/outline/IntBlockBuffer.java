package net.runelite.client.ui.overlay.outline;

import java.util.Arrays;

/**
 * A class which manages 1024-sized blocks of memory.
 */
class IntBlockBuffer
{
	public static final int BLOCK_BITS = 10;
	public static final int BLOCK_SIZE = 1 << BLOCK_BITS;

	private int[] memory;
	private int[] unusedBlockIndices;
	private int unusedBlockIndicesLength;

	public IntBlockBuffer()
	{
		reset();
	}

	/**
	 * Reset memory used by the block buffer.
	 */
	public void reset()
	{
		memory = new int[0];
		unusedBlockIndices = new int[0];
		unusedBlockIndicesLength = 0;
	}

	private void increaseBlockCount()
	{
		int currBlockCount = memory.length >> BLOCK_BITS;
		int newBlockCount = Math.max(1, currBlockCount * 2);
		memory = Arrays.copyOf(memory, newBlockCount * BLOCK_SIZE);
		unusedBlockIndices = Arrays.copyOf(unusedBlockIndices, newBlockCount);
		for (int i = currBlockCount; i < newBlockCount; i++)
		{
			unusedBlockIndices[unusedBlockIndicesLength++] = i;
		}
	}

	/**
	 * Retrieves the whole memory buffer.
	 */
	public int[] getMemory()
	{
		return memory;
	}

	/**
	 * Marks a new block as used.
	 *
	 * @return The index of the block.
	 */
	public int useNewBlock()
	{
		if (unusedBlockIndicesLength == 0)
		{
			increaseBlockCount();
		}

		return unusedBlockIndices[--unusedBlockIndicesLength];
	}

	/**
	 * Marks a block as unused.
	 *
	 * @param index The index of the block. The block should be in use before calling this method.
	 */
	public void freeBlock(int index)
	{
		unusedBlockIndices[unusedBlockIndicesLength++] = index;
	}
}
