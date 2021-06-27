/*
 * Copyright (c) 2021, Woox <https://github.com/wooxsolo>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.ui.overlay.outline;

import java.util.Arrays;

/**
 * A class which manages 1024-sized blocks of memory.
 */
class IntBlockBuffer
{
	public static final int BLOCK_BITS = 10;
	public static final int BLOCK_SIZE = 1 << BLOCK_BITS;

	private int[] memory = new int[0];
	private int[] unusedBlockIndices = new int[0];
	private int unusedBlockIndicesLength;

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
