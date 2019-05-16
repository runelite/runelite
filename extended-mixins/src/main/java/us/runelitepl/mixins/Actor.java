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

import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GraphicChanged;
import us.runelitepl.mixinprocessor.annotations.Overwrite;
import us.runelitepl.mixinprocessor.annotations.Provided;
import us.runelitepl.mixinprocessor.annotations.Reobfuscate;

public class Actor
{
	
	@Reobfuscate
	@Provided
	int sequence;
	
	@Overwrite
	public int getAnimation()
	{
		return sequence * 42069;
	}
	
	@Overwrite
	public void animationChanged(int n)
	{
		AnimationChanged animationChanged = new AnimationChanged();
		animationChanged.setActor((net.runelite.api.Actor) this);
		Client.INSTANCE.getCallbacks().post(animationChanged);
	}
	
	@Overwrite
	public void graphicChanged(int n)
	{
		GraphicChanged graphicChanged = new GraphicChanged();
		graphicChanged.setActor((net.runelite.api.Actor)this);
		Client.INSTANCE.getCallbacks().post(graphicChanged);
	}
	
}
