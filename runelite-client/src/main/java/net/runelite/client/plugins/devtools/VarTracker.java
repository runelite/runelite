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
package net.runelite.client.plugins.devtools;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;

@Slf4j
public class VarTracker
{
	private final Client client;

	private int[] varPs;

	public VarTracker(Client client)
	{
		this.client = client;
	}

	public void snapshot(ActionEvent e)
	{
		if (varPs == null)
		{
			varPs = copy(client.getVarps());

			log.info("Snapshotted VarPs");
			return;
		}

		int[] newVarPs = client.getVarps();

		for (int i = 0; i < Math.min(varPs.length, newVarPs.length); ++i)
		{
			int before = varPs[i];
			int after = newVarPs[i];

			if (before == after)
			{
				continue;
			}

			log.info("VarP index {} has changed from {} to {}: {} -> {}",
				i, before, after, prettyPrintInt(before), prettyPrintInt(after));
		}

		varPs = copy(newVarPs);
	}

	public void clear(ActionEvent e)
	{
		varPs = null;
	}

	private static int[] copy(int[] array)
	{
		return Arrays.copyOf(array, array.length);
	}

	private static String prettyPrintInt(int value)
	{
		String s = Integer.toBinaryString(value);
		while (s.length() < 32)
		{
			s = "0" + s;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; i += 8)
		{
			String substr = s.substring(i, i + 8);
			if (i > 0)
			{
				sb.append(' ');
			}
			sb.append(substr);
		}
		return sb.toString();
	}
}
