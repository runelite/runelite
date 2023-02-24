/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;

@Singleton
@Getter
public class Task
{
	@Inject
	@Getter(AccessLevel.NONE)
	private Client client;

	private static Task task = null;

	public TaskNpc taskNPC;
	public Location location;
	public SlayerMaster master;
	@Setter
	public int amount;
	public String name;
	public int[] npcIds;

	Task()
	{
		this.taskNPC = TaskNpc.NULL;
		this.location = null;
		this.master = null;
		this.amount = 0;
		this.name = "";
		this.npcIds = new int[0];
	}

	void update(Client client)
	{
		taskNPC = TaskNpc.getTask(client);
		name = taskNPC.getName();
		npcIds = taskNPC.getVariations();
		amount = client.getVarpValue(VarPlayer.SLAYER_TASK_SIZE);
		master = SlayerMaster.getSlayerMaster(client);
		location = Location.getTaskLocation(client);
	}

	public boolean isValid()
	{
		return (taskNPC != TaskNpc.NULL && taskNPC != TaskNpc.NULL_BOSS) && amount > 0;
	}
}
