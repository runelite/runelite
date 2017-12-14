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
import java.util.List;
import lombok.Data;

@Data
public class Actor {
	Group parent;
	Stage stage;
	String name;
	boolean visible = true;
	int x, y, originX, originY, width, height, scaleX, scaleY;
	double rotation;
	Object userObject;

	public void setX(int x)
	{
		if (this.x != x)
		{
			this.x = x;
			positionChanged();
		}
	}

	public void setY(int y)
	{
		if (this.y != y)
		{
			this.y = y;
			positionChanged();
		}
	}

	public void setWidth(int width)
	{
		if (this.width != width)
		{
			this.width = width;
			sizeChanged();
		}
	}

	public void setHeight(int height)
	{
		if (this.height != height)
		{
			this.height = height;
			sizeChanged();
		}
	}

	public void setBounds (int x, int y, int width, int height) {
		if (this.x != x || this.y != y) {
			this.x = x;
			this.y = y;
			positionChanged();
		}
		if (this.width != width || this.height != height) {
			this.width = width;
			this.height = height;
			sizeChanged();
		}
	}

	public void setZIndex (int index) {
		if (index < 0) throw new IllegalArgumentException("ZIndex cannot be < 0.");
		Group parent = this.parent;
		if (parent == null) return;
		List<Actor> children = parent.getChildren();
		if (children.size() == 1) return;
		index = Math.min(index, children.size() - 1);
		if (children.get(index) == this) return;
		if (!children.remove(this)) return;
		children.add(index, this);
	}

	public int getZIndex () {
		Group parent = this.parent;
		if (parent == null) return -1;
		return parent.getChildren().indexOf(this);
	}

	public void act(float delta) { }
	public void draw(Graphics2D graphics) { }

	protected void positionChanged() { }
	protected void sizeChanged() { }
}
