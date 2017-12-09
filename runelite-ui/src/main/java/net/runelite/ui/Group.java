/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.ui;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Getter;
import lombok.Setter;

public class Group extends Actor {
	@Getter
	private final List<Actor> children = new CopyOnWriteArrayList<>();

	@Getter
	@Setter
	private boolean transform;

	private final AffineTransform affineTransform = new AffineTransform();
	private AffineTransform oldTransform;

	@Override
	public void setStage(Stage stage)
	{
		super.setStage(stage);
		children.forEach(child -> child.setStage(stage));
	}

	public boolean addActor(Actor actor)
	{
		if (actor.parent != null) {
			if (actor.parent == this) return false;
			actor.parent.removeActor(actor);
		}

		children.add(actor);
		actor.parent = this;
		actor.stage = this.stage;
		childrenChanged();
		return true;
	}

	public boolean removeActor(Actor actor)
	{
		if (!children.remove(actor)) return false;
		actor.parent = null;
		actor.stage = null;
		childrenChanged();
		return true;
	}

	public <T extends Actor> T findActor (String name) {
		for (Actor child : children)
		{
			if (name.equals(child.getName())) return (T)child;
		}

		for (Actor child : children) {
			if (child instanceof Group) {
				Actor actor = ((Group)child).findActor(name);
				if (actor != null) return (T)actor;
			}
		}

		return null;
	}

	public void clear () {
		for (Actor child : children) {
			child.setStage(null);
			child.setParent(null);
		}

		children.clear();
		childrenChanged();
	}

	@Override
	public void act(float delta)
	{
		children.forEach(actor -> actor.act(delta));
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		if (transform) applyTransform(graphics, computeTransform());
		drawChildren(graphics);
		if (transform) resetTransform(graphics);
	}

	protected void drawChildren(Graphics2D graphics)
	{
		if (transform) {
			for (Actor actor : children)
			{
				if (!actor.isVisible()) continue;
				actor.draw(graphics);
			}
		} else {
			// No transform for this group, offset each child.
			int offsetX = x, offsetY = y;
			x = 0;
			y = 0;

			for (Actor actor : children)
			{
				if (!actor.isVisible()) continue;
				int cx = actor.x, cy = actor.y;
				actor.x = cx + offsetX;
				actor.y = cy + offsetY;
				actor.draw(graphics);
				actor.x = cx;
				actor.y = cy;
			}

			x = offsetX;
			y = offsetY;
		}
	}

	protected AffineTransform computeTransform()
	{
		final AffineTransform affineTransform = new AffineTransform(this.affineTransform);
		affineTransform.setToTranslation(x + originX, y + originY);
		affineTransform.rotate(rotation);
		affineTransform.scale(scaleX, scaleY);

		if (originX != 0 || originY != 0) affineTransform.translate(-originX, -originY);

		// Find the first parent that transforms.
		Group parentGroup = parent;
		while (parentGroup != null) {
			if (parentGroup.transform) break;
			parentGroup = parentGroup.parent;
		}

		if (parentGroup != null) affineTransform.preConcatenate(parentGroup.affineTransform);
		return affineTransform;
	}

	protected void applyTransform (Graphics2D graphics, AffineTransform transform) {
		oldTransform = transform;
		graphics.setTransform(affineTransform);
	}

	protected void resetTransform (Graphics2D graphics) {
		graphics.setTransform(oldTransform);
	}

	protected void childrenChanged() { }
}
