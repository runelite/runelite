/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.rs.api;

import net.runelite.api.Projectile;
import net.runelite.mapping.Import;

public interface RSProjectile extends RSRenderable, Projectile
{
	@Import("id")
	@Override
	int getId();

	@Import("height")
	@Override
	int getHeight();

	@Import("endHeight")
	@Override
	int getEndHeight();

	@Import("x1")
	@Override
	int getX1();

	@Import("y1")
	@Override
	int getY1();

	@Import("floor")
	@Override
	int getFloor();

	@Import("startMovementCycle")
	@Override
	int getStartMovementCycle();

	@Import("endCycle")
	@Override
	int getEndCycle();

	@Import("slope")
	@Override
	int getSlope();

	@Import("startHeight")
	@Override
	int getStartHeight();

	@Import("x")
	@Override
	double getX();

	@Import("y")
	@Override
	double getY();

	@Import("z")
	@Override
	double getZ();

	@Import("scalar")
	@Override
	double getScalar();

	@Import("velocityX")
	@Override
	double getVelocityX();

	@Import("velocityY")
	@Override
	double getVelocityY();

	@Import("velocityZ")
	@Override
	double getVelocityZ();
}
