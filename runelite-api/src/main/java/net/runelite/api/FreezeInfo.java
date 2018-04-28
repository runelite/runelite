/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * stores information about freezes.
 * queuedTicks can vary depending on whether we assumed we have pid or not. when others get frozen we always assume
 * we have pid, otherwise refreezes could happen whilst it shows immunity and inaccurate information will display
 */
public class FreezeInfo
{
	/**
	 * list of freezes which ave been queued, can vary depending on pid or not.
	 * We assume we always have pid against other players and players never have pid against npcs
	 */
	@Getter
	private List<QueuedFreeze> queuedFreezes;

	/**
	 * the remaining frozen ticks
	 */
	@Getter
	@Setter
	private int frozen;

	/**
	 * the remaining immune
	 */
	@Getter
	@Setter
	private int immune;

	/**
	 * the type of freeze applied. To know which sprite to display
	 * null upon initialisation and when no freeze is activate.
	 * This value will also be null whilst immune and if this type is set during immunity
	 * it's for the queued freeze.
	 * As a result this value should never be null when the State is either QUEUED or FROZEN
	 */
	@Getter
	@Setter
	private FreezeType type;

	/**
	 * position we are frozen at, if we move from this point the freeze is automatically cancelled and immunity applied
	 */
	@Getter
	private WorldPoint position;

	public FreezeInfo()
	{
		this.queuedFreezes = new ArrayList<>();
		this.frozen = 0;
		this.immune = 0;
		this.type = null;
		this.position = null;
	}

	/**
	 * Create a freeze info object with a queued freeze
	 * @param type The freeze which will be applied
	 * @param hasPid whether the target has pid or not, npcs always have pid
	 */
	public void queueFreeze(FreezeType type, int ticks, boolean hasPid)
	{
		this.queuedFreezes.add(new QueuedFreeze(type, ticks, hasPid));
	}

	/**
	 * decrement all remaining ticks by 1, called every tick by the freeze manager.
	 * for internal use only.
	 */
	public void decrementAll()
	{
		this.immune -= 1;
		this.frozen -= 1;

		for (Iterator<QueuedFreeze> qfIt = queuedFreezes.iterator(); qfIt.hasNext();)
		{
			QueuedFreeze qf = qfIt.next();
			qf.decrement();

			if (qf.getTicksTillActive() < 0)
			{
				qfIt.remove();
				continue;
			}
		}
	}

	public boolean isFrozen()
	{
		return this.frozen > 0;
	}

	public boolean isImmune()
	{
		return this.immune > 0;
	}

	public boolean hasQueued()
	{
		return this.queuedFreezes.size() > 0;
	}

	public void startFreeze(FreezeType t, int frozenTicks, WorldPoint position)
	{
		this.immune = 0;
		this.frozen = frozenTicks;
		this.type = t;
		this.position = position;
	}

	public void startImmunity()
	{
		this.immune = 6;
		this.frozen = 0;
		this.type = null;
		this.position = null;
	}

	public void resetFreeze()
	{
		this.immune = 0;
		this.frozen = 0;
		this.type = null;
		this.position = null;
	}

	public class QueuedFreeze
	{
		@Getter
		private FreezeType type;

		@Getter
		private int lengthTicks;

		@Getter
		private int ticksTillActive;

		/**
		 *
		 * @param type which type of freeze was applied
		 * @param ticks pray halfing is determined on cast and not activation so ticks must be passed at this point and not later on
		 * @param hasPid whether the target has pid or not, npcs should always have pid.
		 */
		public QueuedFreeze(FreezeType type, int ticks, boolean hasPid)
		{
			this.type = type;
			this.lengthTicks = ticks;
			this.ticksTillActive = hasPid ? 2 : 1;
		}

		public void decrement()
		{
			this.ticksTillActive -= 1;
		}

		public boolean shouldTrigger()
		{
			return (this.getTicksTillActive() == 0) ? true : false;
		}
	}
}
