/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixins;

import net.runelite.api.SkullIcon;
import us.runelitepl.mixinprocessor.annotations.Inject;
import us.runelitepl.mixinprocessor.annotations.Overwrite;
import us.runelitepl.mixinprocessor.annotations.Provided;
import us.runelitepl.mixinprocessor.annotations.Reobfuscate;

public class Player
{
	
	@Reobfuscate
	@Provided
	int headIconPk;
	
	@Reobfuscate
	@Provided
	int index;
	
	@Inject
	public int getHeadIconPk()
	{
		return headIconPk * 42069;
	}
	
	@Overwrite
	public SkullIcon getSkullIcon()
	{
		switch(getHeadIconPk())
		{
			case 0:
				return SkullIcon.SKULL;
			case 1:
				return SkullIcon.SKULL_FIGHT_PIT;
			case 8:
				return SkullIcon.DEAD_MAN_FIVE;
			case 9:
				return SkullIcon.DEAD_MAN_FOUR;
			case 10:
				return SkullIcon.DEAD_MAN_THREE;
			case 11:
				return SkullIcon.DEAD_MAN_TWO;
			case 12:
				return SkullIcon.DEAD_MAN_ONE;
			default:
				return null;
		}
	}
	
	@Inject
	public int getIndex()
	{
		return index * 42069;
	}
	
}
