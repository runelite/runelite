/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.cache.util;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class BzStream extends Structure
{
	/*
	  char *next_in;
	  unsigned int avail_in;
	  unsigned int total_in_lo32;
	  unsigned int total_in_hi32;

	  char *next_out;
	  unsigned int avail_out;
	  unsigned int total_out_lo32;
	  unsigned int total_out_hi32;

	  void *state;

	  void *(*bzalloc)(void *,int,int);
	  void (*bzfree)(void *,void *);
	  void *opaque;
	 */
	public Pointer next_in;
	public int avail_in;
	public int total_in_lo32;
	public int total_in_hi32;

	public Pointer next_out;
	public int avail_out;
	public int total_out_lo32;
	public int total_out_hi32;

	public Pointer state;

	public Pointer bzalloc;
	public Pointer bzfree;
	public Pointer opaque;

	@Override
	protected List<String> getFieldOrder()
	{
		return Arrays.asList(
			"next_in",
			"avail_in",
			"total_in_lo32",
			"total_in_hi32",

			"next_out",
			"avail_out",
			"total_out_lo32",
			"total_out_hi32",

			"state",

			"bzalloc",
			"bzfree",
			"opaque"
		);
	}
}
