/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import lombok.SneakyThrows;
import net.runelite.api.clan.ClanID;
import static org.junit.Assert.fail;
import org.junit.Test;

public class DistinctIdTest
{
	@Test
	public void testUnique()
	{
		duplicateCheck(
			// disabled as a few plugins rely on the dups
			//AnimationID.class,
			ClanID.class,
			EnumID.class,
			FontID.class,
			GraphicID.class,
			HitsplatID.class,
			KeyCode.class,
			ParamID.class,
			ScriptID.class,
			SettingID.class,
			SkullIcon.class,
			SoundEffectID.class,
			SpriteID.class,
			StructID.class,
			VarClientInt.class,
			VarClientStr.class,
			VarPlayer.class,
			Varbits.class
		);
	}

	@SneakyThrows
	private void duplicateCheck(Class<?>... classes)
	{
		for (Class<?> clazz : classes)
		{
			Set<Integer> seen = new HashSet<>();
			for (Field f : clazz.getDeclaredFields())
			{
				if (!seen.add(f.getInt(null)))
				{
					fail("field with duplicate value: " + clazz.getSimpleName() + "." + f.getName());
				}
			}
		}
	}
}