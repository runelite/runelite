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
package net.runelite.ui.components;

import java.awt.Graphics2D;
import java.util.List;
import net.runelite.ui.Actor;
import net.runelite.ui.Group;
import net.runelite.ui.Stage;
import net.runelite.ui.util.Layout;

public class ComponentGroup extends Group implements Layout
{
	private boolean needsLayout = true;
	private boolean fillParent;
	private boolean layoutEnabled = true;

	@Override
	public int getMinWidth ()
	{
		return getPrefWidth();
	}

	@Override
	public int getMinHeight ()
	{
		return getPrefHeight();
	}

	@Override
	public int getPrefWidth ()
	{
		return 0;
	}

	@Override
	public int getPrefHeight ()
	{
		return 0;
	}

	@Override
	public int getMaxWidth ()
	{
		return 0;
	}

	@Override
	public int getMaxHeight ()
	{
		return 0;
	}

	@Override
	public void setLayoutEnabled (boolean enabled)
	{
		if (layoutEnabled == enabled) return;
		layoutEnabled = enabled;
		setLayoutEnabled(this, enabled);
	}

	private void setLayoutEnabled (Group parent, boolean enabled)
	{
		List<Actor> children = parent.getChildren();
		for (Actor actor : children)
		{
			if (actor instanceof Layout)
				((Layout)actor).setLayoutEnabled(enabled);
			else if (actor instanceof Group)
				setLayoutEnabled((Group)actor, enabled);
		}
	}

	@Override
	public void validate ()
	{
		if (!layoutEnabled) return;

		Group parent = getParent();
		if (fillParent && parent != null)
		{
			int parentWidth, parentHeight;
            Stage stage = getStage();

			if (stage != null && parent == stage.getRoot())
			{
				parentWidth = stage.getViewport().width;
				parentHeight = stage.getViewport().height;
			}
			else
			{
				parentWidth = parent.getWidth();
				parentHeight = parent.getHeight();
			}

			if (getWidth() != parentWidth || getHeight() != parentHeight)
			{
				setWidth(parentWidth);
				setHeight(parentHeight);
				invalidate();
			}
		}

		if (!needsLayout) return;
		needsLayout = false;
		layout();
	}

	public boolean needsLayout ()
	{
		return needsLayout;
	}

	@Override
	public void invalidate ()
	{
		needsLayout = true;
	}

	@Override
	public void invalidateHierarchy ()
	{
		invalidate();
		Group parent = getParent();
		if (parent instanceof Layout) ((Layout)parent).invalidateHierarchy();
	}

	@Override
	protected void childrenChanged ()
	{
		invalidateHierarchy();
	}

	@Override
	protected void sizeChanged ()
	{
		invalidate();
	}

	@Override
	public void pack ()
	{
		setWidth(getPrefWidth());
		setHeight(getPrefHeight());
		validate();

		if (needsLayout)
		{
			setWidth(getPrefWidth());
			setHeight(getPrefHeight());
			validate();
		}
	}

	@Override
	public void setFillParent (boolean fillParent)
	{
		this.fillParent = fillParent;
	}

	@Override
	public void layout () { }

	@Override
	public void draw (Graphics2D graphics)
	{
		validate();
		super.draw(graphics);
	}
}
