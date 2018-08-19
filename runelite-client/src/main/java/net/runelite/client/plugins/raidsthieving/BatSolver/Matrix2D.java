/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving.BatSolver;

public class Matrix2D
{
	public static int[][] MatrixMultiple2D(int[][] matA, int[][] matB)
		// Performs 2d matrix multiplication on integer arrays
	{
		int[][] output = {{0, 0}, {0, 0}};
		for (int i = 0; i < matA.length; i++)
		{
			for (int j = 0; j < matB[0].length; j++)
			{
				for (int k = 0; k < matA[0].length; k++)
				{
					output[i][j] += matA[i][k] * matB[k][j];
				}
			}
		}
		return output;
	}

	public static int[][] Rotate90(int[][] matA)
	{
		// helper function to provide easy access to a counter-clockwise 90degree rotation in 2D cartesian coordiantes
		int[][] rotMat = {{0, -1}, {1, 0}};
		return MatrixMultiple2D(rotMat, matA);
	}

}
