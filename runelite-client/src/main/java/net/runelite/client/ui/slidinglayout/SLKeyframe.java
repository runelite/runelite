package net.runelite.client.ui.slidinglayout;

import net.runelite.client.ui.slidinglayout.SLConfig.Tile;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * A keyframe wraps a {@link SLConfig layout configuration} together with
 * various parameters, such as the ending and starting sides of new and old
 * components, and the optional delays that can be applied to the components
 * to create some nice effects.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SLKeyframe
{
	private final SLConfig cfg;
	private final float duration;
	private final Map<SLSide, List<Component>> cmpsWithStartSide = new EnumMap<>(SLSide.class);
	private final Map<SLSide, List<Component>> cmpsWithEndSide = new EnumMap<>(SLSide.class);
	private final Map<Component, Tile> targetTiles = new HashMap<>();
	private final Map<Component, Float> delays = new HashMap<>();
	private final List<Component> cmpsToAddAfterTransition = new ArrayList<>();
	private final List<Component> cmpsToRemoveAfterTransition = new ArrayList<>();
	private Callback callback;
	private SLSide sideForNewCmps = null;
	private SLSide sideForOldCmps = null;

	/**
	 * The duration parameter controls the duration of the transition of a
	 * component from its current place to its target place in the keyframe
	 * layout configuration. It doesn't account for any optional delay you
	 * may add to it.
	 */
	public SLKeyframe(SLConfig cfg, float duration)
	{
		this.cfg = cfg;
		this.duration = duration;

		for (SLSide s : SLSide.values())
		{
			cmpsWithStartSide.put(s, new ArrayList<>());
			cmpsWithEndSide.put(s, new ArrayList<>());
		}
	}

	/**
	 * A simple callback, yeah.
	 */
	public static interface Callback
	{
		public void done();
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Sets the side of the screen from where the given new components will
	 * slide from. A new component is a component that is present in this
	 * layout configuration but not on the previous one.
	 */
	public SLKeyframe setStartSide(SLSide side, Component... cmps)
	{
		cmpsWithStartSide.get(side).addAll(Arrays.asList(cmps));
		return this;
	}

	/**
	 * Sets the side of the screen from where every new component will
	 * slide from. A new component is a component that is present in this
	 * layout configuration but not on the previous one.
	 */
	public SLKeyframe setStartSideForNewCmps(SLSide side)
	{
		sideForNewCmps = side;
		return this;
	}

	/**
	 * Sets the side of the screen from where the given old components will
	 * slide to. An old component is a component that is not present in this
	 * layout configuration but was on the previous one.
	 */
	public SLKeyframe setEndSide(SLSide side, Component... cmps)
	{
		cmpsWithEndSide.get(side).addAll(Arrays.asList(cmps));
		return this;
	}

	/**
	 * Sets the side of the screen from where every old component will
	 * slide to. An old component is a component that is not present in this
	 * layout configuration but was on the previous one.
	 */
	public SLKeyframe setEndSideForOldCmps(SLSide side)
	{
		sideForOldCmps = side;
		return this;
	}

	/**
	 * Sets the delay used by the given components before the transition from
	 * their current place to their target one starts.
	 */
	public SLKeyframe setDelay(float delay, Component... cmps)
	{
		for (Component c : cmps) delays.put(c, delay);
		return this;
	}

	/**
	 * Sets the delay used by the given components before the transition from
	 * their current place to their target one starts. The delay is
	 * increased for each component in the list.
	 */
	public SLKeyframe setDelayIncr(float delay, Component... cmps)
	{
		float d = 0;
		for (Component c : cmps) delays.put(c, d += delay);
		return this;
	}

	/**
	 * Increases the delay used by the given components before the transition
	 * from their current place to their target one starts.
	 */
	public SLKeyframe addDelay(float delay, Component... cmps)
	{
		for (Component c : cmps) delays.put(c, delays.get(c) + delay);
		return this;
	}

	/**
	 * Increases the delay used by the given components before the transition
	 * from their current place to their target one starts. The delay is
	 * increased for each component in the list.
	 */
	public SLKeyframe addDelayIncr(float delay, Component... cmps)
	{
		float d = 0;
		for (Component c : cmps) delays.put(c, delays.get(c) + (d += delay));
		return this;
	}

	/**
	 * Sets a callback that will be called at the end of the transition to this
	 * keyframe.s
	 */
	public SLKeyframe setCallback(Callback callback)
	{
		this.callback = callback;
		return this;
	}

	/**
	 * Gets the delay associated to the given component.
	 */
	public float getDelay(Component cmp)
	{
		return delays.containsKey(cmp) ? delays.get(cmp) : 0;
	}

	/**
	 * Gets the callback associated with this keyframe, if any.
	 */
	public Callback getCallback()
	{
		return callback;
	}

	/**
	 * Gets the duration of the transition to this keyframe.
	 */
	public float getDuration()
	{
		return duration;
	}

	// -------------------------------------------------------------------------
	// Package API
	// -------------------------------------------------------------------------

	/**
	 * TODO: cut that into smaller chunks
	 */
	void initialize(SLKeyframe prevKf)
	{
		cfg.placeAndRoute();

		// Only needed for new components
		Map<Component, Tile> startTiles = new HashMap<Component, Tile>();

		// Targets are created for every component of this keyframe
		for (Component c : cfg.getCmps())
		{
			targetTiles.put(c, cfg.getTile(c).clone());
		}

		// New components are identified
		List<Component> newCmps = new ArrayList<Component>();
		newCmps.addAll(cfg.getCmps());
		newCmps.removeAll(prevKf.cfg.getCmps());

		// Old components are identified
		List<Component> oldCmps = new ArrayList<Component>();
		oldCmps.addAll(prevKf.cfg.getCmps());
		oldCmps.removeAll(cfg.getCmps());

		// If a "sideForNewCmps" is defined, every new component without an
		// assigned start side is put into the list of this side.
		if (sideForNewCmps != null)
		{
			for (Component c : newCmps)
				if (!isPartOf(c, cmpsWithStartSide)) cmpsWithStartSide.get(sideForNewCmps).add(c);
		}

		// If a "sideForOldCmps" is defined, every old component without an
		// assigned end side is put into the list of this side.
		if (sideForOldCmps != null)
		{
			for (Component c : oldCmps)
				if (!isPartOf(c, cmpsWithEndSide)) cmpsWithEndSide.get(sideForOldCmps).add(c);
		}

		// If new components have a start side, they are added to the panel and
		// their location will be computed later. Else, they are directly
		// placed at their target position, and will be added to the panel
		// at the end of the transition.
		for (Component c : newCmps)
		{
			if (isPartOf(c, cmpsWithStartSide))
			{
				cfg.getPanel().add(c, new Integer(1));
				startTiles.put(c, cfg.getTile(c).clone());
			}
			else
			{
				cmpsToAddAfterTransition.add(c);
				Tile t = cfg.getTile(c);
				c.setBounds(t.x, t.y, t.w, t.h);
				c.validate();
			}
		}

		// If old components have an end side, their target location will be
		// computed later, and they will be removed at the end of the
		//transition. Else, they are directly removed from the panel.
		for (Component c : oldCmps)
		{
			if (isPartOf(c, cmpsWithEndSide))
			{
				cmpsToRemoveAfterTransition.add(c);
				targetTiles.put(c, prevKf.cfg.getTile(c).clone());
			}
			else
			{
				cfg.getPanel().remove(c);
			}
		}

		// Start/target locations are computed for new/old components
		// that have a start/end side set.
		for (SLSide s : SLSide.values())
		{
			hideTiles(getTiles(cmpsWithStartSide.get(s), startTiles), s);
			hideTiles(getTiles(cmpsWithEndSide.get(s), targetTiles), s);
		}

		// New components with a start side are then placed at the location
		// computed above.
		for (Component c : startTiles.keySet())
		{
			Tile t = startTiles.get(c);
			c.setBounds(t.x, t.y, t.w, t.h);
			c.validate();
		}
	}

	Set<Component> getCmps()
	{
		return targetTiles.keySet();
	}

	List<Component> getCmpsToAddAfterTransition()
	{
		return cmpsToAddAfterTransition;
	}

	List<Component> getCmpsToRemoveAfterTransition()
	{
		return cmpsToRemoveAfterTransition;
	}

	Tile getTarget(Component cmp)
	{
		return targetTiles.get(cmp);
	}

	SLConfig getCfg()
	{
		return cfg;
	}

	// -------------------------------------------------------------------------
	// Private API
	// -------------------------------------------------------------------------

	private boolean isPartOf(Component c, Map<SLSide, List<Component>> map)
	{
		for (SLSide s : SLSide.values())
			if (map.get(s).contains(c)) return true;
		return false;
	}

	private List<Tile> getTiles(List<Component> cmps, Map<Component, Tile> cmpsMap)
	{
		List<Tile> tiles = new ArrayList<Tile>();
		for (Component c : cmps) tiles.add(cmpsMap.get(c));
		return tiles;
	}

	private void hideTiles(List<Tile> tiles, SLSide side)
	{
		if (tiles.isEmpty()) return;

		int w = cfg.getPanel().getWidth();
		int h = cfg.getPanel().getHeight();

		switch (side)
		{
			case TOP:
				int maxY = tiles.get(0).y + tiles.get(0).h;
				for (Tile t : tiles) maxY = Math.max(maxY, t.y + t.h);
				for (Tile t : tiles) t.y -= maxY;
				break;

			case BOTTOM:
				int minY = tiles.get(0).y;
				for (Tile t : tiles) minY = Math.min(minY, t.y);
				for (Tile t : tiles) t.y += h - minY;
				break;

			case LEFT:
				int maxX = tiles.get(0).x + tiles.get(0).w;
				for (Tile t : tiles) maxX = Math.max(maxX, t.x + t.w);
				for (Tile t : tiles) t.x -= maxX;
				break;

			case RIGHT:
				int minX = tiles.get(0).x;
				for (Tile t : tiles) minX = Math.min(minX, t.x);
				for (Tile t : tiles) t.x += w - minX;
				break;
		}
	}
}
