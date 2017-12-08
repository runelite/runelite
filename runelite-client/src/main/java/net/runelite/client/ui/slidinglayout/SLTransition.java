package net.runelite.client.ui.slidinglayout;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Cubic;
import net.runelite.client.ui.slidinglayout.SLConfig.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A transition consists of one or more keyframes (ie. configurations). The
 * engine will move the children of the panel from the current configuration to
 * the first keyframe, and so on.
 *
 * If a component is present on a keyframe but absent from the current
 * configuration, it will be considered to be a <b>new component</b>. If you
 * don't specify anything, it will appear right at its target place, which may
 * not be very nice. Instead, you can set its starting side, the side from
 * where it should be brought into view to its target place. It will then slide
 * from this side to its target place.
 *
 * Similarly, if a component is present in the current configuration but absent
 * from the next keyframe, it will be considered to be an <b>old component</b>.
 * You can slide it out of the screen gracefully by specifying its ending side.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 * @see SLConfig
 * @see SLKeyframe
 */
public class SLTransition
{
	private final SLPanel panel;
	private final TweenManager tweenManager;
	private final List<SLKeyframe> keyframes = new ArrayList<>();
	private int currentKeyframe;
	private Timeline timeline;

	public SLTransition(SLPanel panel, TweenManager tweenManager)
	{
		this.panel = panel;
		this.tweenManager = tweenManager;
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Adds a new keyframe to the transition.
	 */
	public SLTransition push(SLKeyframe kf)
	{
		keyframes.add(kf);
		return this;
	}

	/**
	 * Attempts to start the transition. Returns true if everything went right.
	 * If another transition was already running, nothing happens and the
	 * method returns false;
	 */
	public boolean play()
	{
		if (!panel.isTransitionPlaying)
		{
			currentKeyframe = 0;
			play(keyframes.get(0), new SLKeyframe(panel.currentCfg, 0));
			panel.isTransitionPlaying = true;
			return true;
		}
		return false;
	}

	// -------------------------------------------------------------------------
	// Private API
	// -------------------------------------------------------------------------

	private void play(SLKeyframe kf, SLKeyframe previousKf)
	{
		panel.currentCfg = kf.getCfg();
		kf.initialize(previousKf);
		tween(kf);
	}

	private void tween(final SLKeyframe kf)
	{
		if (timeline != null) timeline.kill();

		timeline = Timeline.createParallel();

		for (Component c : kf.getCmps())
		{
			Tile t = kf.getTarget(c);

			int dx = c.getX() - t.x;
			int dy = c.getY() - t.y;
			int dw = c.getWidth() - t.w;
			int dh = c.getHeight() - t.h;
			boolean animXY = (dx != 0) || (dy != 0);
			boolean animWH = (dw != 0) || (dh != 0);
			float duration = kf.getDuration();

			if (animXY && animWH)
			{
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.XYWH, duration).target(t.x, t.y, t.w, t.h).ease(Cubic.INOUT).delay(kf.getDelay(c)));
			}
			else if (animXY)
			{
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.XY, duration).target(t.x, t.y).ease(Cubic.INOUT).delay(kf.getDelay(c)));
			}
			else if (animWH)
			{
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.WH, duration).target(t.w, t.h).ease(Cubic.INOUT).delay(kf.getDelay(c)));
			}
		}

		timeline.setCallback((type, source) ->
		{
			for (Component c : kf.getCmpsToAddAfterTransition())
			{
				panel.add(c, new Integer(1));
			}

			for (Component c : kf.getCmpsToRemoveAfterTransition())
			{
				panel.remove(c);
			}

			if (kf.getCallback() != null) kf.getCallback().done();

			if (currentKeyframe < keyframes.size() - 1)
			{
				currentKeyframe++;
				play(keyframes.get(currentKeyframe), keyframes.get(currentKeyframe - 1));
			}
			else
			{
				panel.isTransitionPlaying = false;
			}
		});

		timeline.start(tweenManager);
	}
}
