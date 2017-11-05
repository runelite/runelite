/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
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
package net.runelite.client.events;

public class ProjectileSpawned
{
	private int id;
	private int floor;
	private int startX;
	private int startY;
	private int height;
	private int startTime;
	private int cycle;
	private int slope;
	private int start;
	private int interacting;
	private int endHeight;

	public ProjectileSpawned(int id, int floor, int startX, int startY, int height, int startTime, int cycle, int slope, int start, int interacting, int endHeight)
	{
		this.id = id;
		this.floor = floor;
		this.startX = startX;
		this.startY = startY;
		this.height = height;
		this.startTime = startTime;
		this.cycle = cycle;
		this.slope = slope;
		this.start = start;
		this.interacting = interacting;
		this.endHeight = endHeight;
	}

	public int getId()
	{
		return id;
	}

	public int getFloor()
	{
		return floor;
	}

	public int getStartX()
	{
		return startX;
	}

	public int getStartY()
	{
		return startY;
	}

	public int getHeight()
	{
		return height;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public int getCycle()
	{
		return cycle;
	}

	public int getSlope()
	{
		return slope;
	}

	public int getStart()
	{
		return start;
	}

	public int getInteracting()
	{
		return interacting;
	}

	public int getEndHeight()
	{
		return endHeight;
	}
}
