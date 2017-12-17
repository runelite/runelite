/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.instancemap;

class PixelMaps
{
	static final int[][] ALL = new int[][]
	{
		{
			1, 1, 1, 1
		},
		{
			1, 1, 1, 1
		},
		{
			1, 1, 1, 1
		},
		{
			1, 1, 1, 1
		}
	};

	//Diagonal /
	static final int[][] BOTTOM_LEFT_TO_TOP_RIGHT = new int[][]
	{
		{
			0, 0, 0, 1
		},
		{
			0, 0, 1, 0
		},
		{
			0, 1, 0, 0
		},
		{
			1, 0, 0, 0
		}
	};

	static final int[][] TOP_LEFT_DOT = new int[][]
	{
		{
			1, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		}
	};

	static final int[][] TOP_RIGHT_DOT = new int[][]
	{
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		}
	};

	static final int[][] BOTTOM_RIGHT_DOT = new int[][]
	{
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 1
		}
	};

	static final int[][] BOTTOM_LEFT_DOT = new int[][]
	{
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			1, 0, 0, 0
		}
	};

	//Diagonal \
	static final int[][] TOP_LEFT_TO_BOTTOM_RIGHT = new int[][]
	{
		{
			1, 0, 0, 0
		},
		{
			0, 1, 0, 0
		},
		{
			0, 0, 1, 0
		},
		{
			0, 0, 0, 1
		}
	};

	//Left
	static final int[][] LEFT = new int[][]
	{
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		}
	};

	static final int[][] TOP = new int[][]
	{
		{
			1, 1, 1, 1
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		}
	};

	static final int[][] RIGHT = new int[][]
	{
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		}
	};

	static final int BOTTOM[][] = new int[][]
	{
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			0, 0, 0, 0
		},
		{
			1, 1, 1, 1
		}
	};

	static final int[][] TOP_LEFT_CORNER = new int[][]
	{
		{
			1, 1, 1, 1
		},
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		}
	};

	static final int[][] TOP_RIGHT_CORNER = new int[][]
	{
		{
			1, 1, 1, 1
		},
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		}
	};

	static final int[][] BOTTOM_RIGHT_CORNER = new int[][]
	{
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		},
		{
			0, 0, 0, 1
		},
		{
			1, 1, 1, 1
		}
	};

	static final int[][] BOTTOM_LEFT_CORNER = new int[][]
	{
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		},
		{
			1, 0, 0, 0
		},
		{
			1, 1, 1, 1
		}
	};
}
