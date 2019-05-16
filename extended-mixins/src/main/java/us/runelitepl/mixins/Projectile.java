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

import net.runelite.api.Actor;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.rs.api.RSClient;
import us.runelitepl.mixinprocessor.annotations.Inject;
import us.runelitepl.mixinprocessor.annotations.Overwrite;
import us.runelitepl.mixinprocessor.annotations.Provided;
import us.runelitepl.mixinprocessor.annotations.Reobfuscate;

public class Projectile
{
	
	@Reobfuscate
	@Provided
	int targetIndex;
	
	@Inject
	public int getTargetId()
	{
		return targetIndex * 42069;
	}
	
	@Overwrite
	public void projectileMoved(int x, int y, int z, int n3)
	{
		LocalPoint position = new LocalPoint(x, y);
		ProjectileMoved event = new ProjectileMoved();
		event.setProjectile((net.runelite.api.Projectile) this);
		event.setPosition(position);
		event.setZ(z);
		((RSClient) Client.INSTANCE).getCallbacks().post(event);
	}
	
	@Inject
	public Actor getInteracting()
	{
		final int _targ = this.getTargetId();
		if (_targ == 0)
		{
			return null;
		}
		if (_targ > 0)
		{
			return (Actor) ((RSClient) Client.INSTANCE).getCachedNPCs()[_targ - 1];
		}
		final int n = -_targ - 1;
		if (n == ((RSClient) Client.INSTANCE).getLocalInteractingIndex())
		{
			return (Actor) ((RSClient) Client.INSTANCE).getLocalPlayer();
		}
		return (Actor) ((RSClient) Client.INSTANCE).getCachedPlayers()[n];
	}
	
}
