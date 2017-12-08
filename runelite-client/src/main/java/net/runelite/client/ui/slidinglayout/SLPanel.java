package net.runelite.client.ui.slidinglayout;

import net.runelite.client.ui.tweenengine.TweenManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The SLPanel is the root of the library. It is a {@link JLayeredPane} under
 * the hood. Therefore, every child that is added to it is able to move
 * over or under the other children.
 * <p/>
 * <p>
 * However, this panel also features its own layout, through the use of
 * {@link SLConfig configurations}. A configuration is a layout of the
 * panel children. The panel can then create smooth transitions between two
 * configurations.
 * <p>
 * <pre>
 * // First create the panel and give it a way to animate
 * // its transitions
 * SLPanel panel = new SLPanel();
 * panel.setTweenManager(SLAnimator.createTweenManager());
 *
 * // Create your configurations (see the {@link SLConfig} documentation)
 * SLConfig config1 = ... ;
 * SLConfig config2 = ... ;
 *
 * // Then set the panel to its initial configuration
 * panel.initialize(config1);
 *
 * // Now, whenever you want, you can fire a transition like
 * // this (see the {@link SLKeyframe} documentation)
 * panel.createTimeline()
 *    .push(new SLKeyframe(config2, 0.6f)
 *        .setEndSide(SLSide.BOTTOM, child1, child2)
 *        .setStartSide(SLSide.UP, child3, child4))
 *    .play();
 * </pre>
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 * @see SLConfig
 * @see SLTransition
 * @see SLKeyframe
 * @see SLAnimator
 */
public class SLPanel extends JLayeredPane
{
	private TweenManager tweenManager;
	SLConfig currentCfg;
	boolean isTransitionPlaying = false;

	public SLPanel()
	{
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				if (currentCfg != null) initialize(currentCfg);
			}
		});
	}

	/**
	 * Sets the {@link TweenManager} that will be used to animate the
	 * transitions. You can use the {@link SLAnimator} class to create a new
	 * manager that wil run in a dedicated thread, or you can pass any
	 * manager if you already have one running in a thread.
	 */
	public void setTweenManager(TweenManager tweenManager)
	{
		this.tweenManager = tweenManager;
	}

	/**
	 * Sets the initial configuration of the panel. This configuration will be
	 * enforced without transition. Do not forget to call this before starting
	 * any transition!
	 */
	public void initialize(SLConfig cfg)
	{
		currentCfg = cfg;

		if (getWidth() != 0 || getHeight() != 0)
		{
			cfg.placeAndRoute();

			//removeAll();
			for (Component c : cfg.getCmps())
			{
				SLConfig.Tile t = cfg.getTile(c);
				c.setBounds(t.x, t.y, t.w, t.h);
				c.validate();
				if (!containsComponent(c))
				{
					add(c, new Integer(1));
				}
			}
		}
	}

	/**
	 * Creates a new transition. Do not hesitate to chain the method calls
	 * from this one, the API is meant for that.
	 */
	public SLTransition createTransition()
	{
		return new SLTransition(this, tweenManager);
	}

	private boolean containsComponent(Component c)
	{
		for (Component existing : getComponents())
		{
			if (existing.equals(c))
			{
				return true;
			}
		}
		return false;
	}
}
