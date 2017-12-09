package net.runelite.ui.components;

import java.util.List;
import net.runelite.ui.Actor;
import net.runelite.ui.util.Layout;

public class Stack extends ComponentGroup {
	private int prefWidth, prefHeight, minWidth, minHeight, maxWidth, maxHeight;
	private boolean sizeInvalid = true;

	public Stack () {
		setTransform(false);
		setWidth(150);
		setHeight(150);
	}

	public Stack (Actor... actors) {
		this();
		for (Actor actor : actors)
			addActor(actor);
	}

	@Override
	public void invalidate () {
		super.invalidate();
		sizeInvalid = true;
	}

	private void computeSize () {
		sizeInvalid = false;
		prefWidth = 0;
		prefHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxWidth = 0;
		maxHeight = 0;
		List<Actor> children = getChildren();
		for (Actor child : children) {
			int childMaxWidth, childMaxHeight;
			if (child instanceof Layout) {
				Layout layout = (Layout) child;
				prefWidth = Math.max(prefWidth, layout.getPrefWidth());
				prefHeight = Math.max(prefHeight, layout.getPrefHeight());
				minWidth = Math.max(minWidth, layout.getMinWidth());
				minHeight = Math.max(minHeight, layout.getMinHeight());
				childMaxWidth = layout.getMaxWidth();
				childMaxHeight = layout.getMaxHeight();
			} else {
				prefWidth = Math.max(prefWidth, child.getWidth());
				prefHeight = Math.max(prefHeight, child.getHeight());
				minWidth = Math.max(minWidth, child.getWidth());
				minHeight = Math.max(minHeight, child.getHeight());
				childMaxWidth = 0;
				childMaxHeight = 0;
			}
			if (childMaxWidth > 0) maxWidth = maxWidth == 0 ? childMaxWidth : Math.min(maxWidth, childMaxWidth);
			if (childMaxHeight > 0) maxHeight = maxHeight == 0 ? childMaxHeight : Math.min(maxHeight, childMaxHeight);
		}
	}

	@Override
	public void layout () {
		if (sizeInvalid) computeSize();
		int width = getWidth(), height = getHeight();
		List<Actor> children = getChildren();
		for (int i = 0, n = children.size(); i < n; i++) {
			Actor child = children.get(i);
			child.setBounds(0, 0, width, height);
			if (child instanceof Layout) ((Layout)child).validate();
		}
	}

	@Override
	public int getPrefWidth () {
		if (sizeInvalid) computeSize();
		return prefWidth;
	}

	@Override
	public int getPrefHeight () {
		if (sizeInvalid) computeSize();
		return prefHeight;
	}

	@Override
	public int getMinWidth () {
		if (sizeInvalid) computeSize();
		return minWidth;
	}

	@Override
	public int getMinHeight () {
		if (sizeInvalid) computeSize();
		return minHeight;
	}

	@Override
	public int getMaxWidth () {
		if (sizeInvalid) computeSize();
		return maxWidth;
	}

	@Override
	public int getMaxHeight () {
		if (sizeInvalid) computeSize();
		return maxHeight;
	}
}
