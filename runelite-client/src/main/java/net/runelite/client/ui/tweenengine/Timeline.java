package net.runelite.client.ui.tweenengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Timeline can be used to create complex animations made of sequences and
 * parallel sets of Tweens.
 * <p/>
 * <p>
 * The following example will create an animation sequence composed of 5 parts:
 * <p/>
 * <p>
 * 1. First, opacity and scale are set to 0 (with Tween.set() calls).<br/>
 * 2. Then, opacity and scale are animated in parallel.<br/>
 * 3. Then, the animation is paused for 1s.<br/>
 * 4. Then, position is animated to x=100.<br/>
 * 5. Then, rotation is animated to 360°.
 * <p/>
 * <p>
 * This animation will be repeated 5 times, with a 500ms delay between each
 * iteration:
 * <br/><br/>
 * <p>
 * <pre> {@code
 * Timeline.createSequence()
 *     .push(Tween.set(myObject, OPACITY).target(0))
 *     .push(Tween.set(myObject, SCALE).target(0, 0))
 *     .beginParallel()
 *          .push(Tween.to(myObject, OPACITY, 0.5f).target(1).ease(Quad.INOUT))
 *          .push(Tween.to(myObject, SCALE, 0.5f).target(1, 1).ease(Quad.INOUT))
 *     .end()
 *     .pushPause(1.0f)
 *     .push(Tween.to(myObject, POSITION_X, 0.5f).target(100).ease(Quad.INOUT))
 *     .push(Tween.to(myObject, ROTATION, 0.5f).target(360).ease(Quad.INOUT))
 *     .repeat(5, 0.5f)
 *     .start(myManager);
 * }</pre>
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 * @see Tween
 * @see TweenManager
 * @see TweenCallback
 */
public final class Timeline extends BaseTween<Timeline>
{
	// -------------------------------------------------------------------------
	// Static -- pool
	// -------------------------------------------------------------------------

	private static final Pool.Callback<Timeline> poolCallback = new Pool.Callback<Timeline>()
	{
		@Override
		public void onPool(Timeline obj)
		{
			obj.reset();
		}

		@Override
		public void onUnPool(Timeline obj)
		{
			obj.reset();
		}
	};

	static final Pool<Timeline> pool = new Pool<Timeline>(10, poolCallback)
	{
		@Override
		protected Timeline create()
		{
			return new Timeline();
		}
	};

	/**
	 * Used for debug purpose. Gets the current number of empty timelines that
	 * are waiting in the Timeline pool.
	 */
	public static int getPoolSize()
	{
		return pool.size();
	}

	/**
	 * Increases the minimum capacity of the pool. Capacity defaults to 10.
	 */
	public static void ensurePoolCapacity(int minCapacity)
	{
		pool.ensureCapacity(minCapacity);
	}

	// -------------------------------------------------------------------------
	// Static -- factories
	// -------------------------------------------------------------------------

	/**
	 * Creates a new timeline with a 'sequence' behavior. Its children will
	 * be delayed so that they are triggered one after the other.
	 */
	public static Timeline createSequence()
	{
		Timeline tl = pool.get();
		tl.setup(Modes.SEQUENCE);
		return tl;
	}

	/**
	 * Creates a new timeline with a 'parallel' behavior. Its children will be
	 * triggered all at once.
	 */
	public static Timeline createParallel()
	{
		Timeline tl = pool.get();
		tl.setup(Modes.PARALLEL);
		return tl;
	}

	// -------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------

	private enum Modes
	{
		SEQUENCE, PARALLEL
	}

	private final List<BaseTween<?>> children = new ArrayList<BaseTween<?>>(10);
	private Timeline current;
	private Timeline parent;
	private Modes mode;
	private boolean isBuilt;

	// -------------------------------------------------------------------------
	// Setup
	// -------------------------------------------------------------------------

	private Timeline()
	{
		reset();
	}

	@Override
	protected void reset()
	{
		super.reset();

		children.clear();
		current = parent = null;

		isBuilt = false;
	}

	private void setup(Modes mode)
	{
		this.mode = mode;
		this.current = this;
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Adds a Tween to the current timeline.
	 *
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline push(Tween tween)
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		current.children.add(tween);
		return this;
	}

	/**
	 * Nests a Timeline in the current one.
	 *
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline push(Timeline timeline)
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		if (timeline.current != timeline)
			throw new RuntimeException("You forgot to call a few 'end()' statements in your pushed timeline");
		timeline.parent = current;
		current.children.add(timeline);
		return this;
	}

	/**
	 * Adds a pause to the timeline. The pause may be negative if you want to
	 * overlap the preceding and following children.
	 *
	 * @param time A positive or negative duration.
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline pushPause(float time)
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		current.children.add(Tween.mark().delay(time));
		return this;
	}

	/**
	 * Starts a nested timeline with a 'sequence' behavior. Don't forget to
	 * call {@link end()} to close this nested timeline.
	 *
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline beginSequence()
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		Timeline tl = pool.get();
		tl.parent = current;
		tl.mode = Modes.SEQUENCE;
		current.children.add(tl);
		current = tl;
		return this;
	}

	/**
	 * Starts a nested timeline with a 'parallel' behavior. Don't forget to
	 * call {@link end()} to close this nested timeline.
	 *
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline beginParallel()
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		Timeline tl = pool.get();
		tl.parent = current;
		tl.mode = Modes.PARALLEL;
		current.children.add(tl);
		current = tl;
		return this;
	}

	/**
	 * Closes the last nested timeline.
	 *
	 * @return The current timeline, for chaining instructions.
	 */
	public Timeline end()
	{
		if (isBuilt) throw new RuntimeException("You can't push anything to a timeline once it is started");
		if (current == this) throw new RuntimeException("Nothing to end...");
		current = current.parent;
		return this;
	}

	/**
	 * Gets a list of the timeline children. If the timeline is started, the
	 * list will be immutable.
	 */
	public List<BaseTween<?>> getChildren()
	{
		if (isBuilt) return Collections.unmodifiableList(current.children);
		else return current.children;
	}

	// -------------------------------------------------------------------------
	// Overrides
	// -------------------------------------------------------------------------

	@Override
	public Timeline build()
	{
		if (isBuilt) return this;

		duration = 0;

		for (int i = 0; i < children.size(); i++)
		{
			BaseTween<?> obj = children.get(i);

			if (obj.getRepeatCount() < 0)
				throw new RuntimeException("You can't push an object with infinite repetitions in a timeline");
			obj.build();

			switch (mode)
			{
				case SEQUENCE:
					float tDelay = duration;
					duration += obj.getFullDuration();
					obj.delay += tDelay;
					break;

				case PARALLEL:
					duration = Math.max(duration, obj.getFullDuration());
					break;
			}
		}

		isBuilt = true;
		return this;
	}

	@Override
	public Timeline start()
	{
		super.start();

		for (int i = 0; i < children.size(); i++)
		{
			BaseTween<?> obj = children.get(i);
			obj.start();
		}

		return this;
	}

	@Override
	public void free()
	{
		for (int i = children.size() - 1; i >= 0; i--)
		{
			BaseTween<?> obj = children.remove(i);
			obj.free();
		}

		pool.free(this);
	}

	@Override
	protected void updateOverride(int step, int lastStep, boolean isIterationStep, float delta)
	{
		if (!isIterationStep && step > lastStep)
		{
			assert delta >= 0;
			float dt = isReverse(lastStep) ? -delta - 1 : delta + 1;
			for (int i = 0, n = children.size(); i < n; i++) children.get(i).update(dt);
			return;
		}

		if (!isIterationStep && step < lastStep)
		{
			assert delta <= 0;
			float dt = isReverse(lastStep) ? -delta - 1 : delta + 1;
			for (int i = children.size() - 1; i >= 0; i--) children.get(i).update(dt);
			return;
		}

		assert isIterationStep;

		if (step > lastStep)
		{
			if (isReverse(step))
			{
				forceEndValues();
				for (int i = 0, n = children.size(); i < n; i++) children.get(i).update(delta);
			}
			else
			{
				forceStartValues();
				for (int i = 0, n = children.size(); i < n; i++) children.get(i).update(delta);
			}

		}
		else if (step < lastStep)
		{
			if (isReverse(step))
			{
				forceStartValues();
				for (int i = children.size() - 1; i >= 0; i--) children.get(i).update(delta);
			}
			else
			{
				forceEndValues();
				for (int i = children.size() - 1; i >= 0; i--) children.get(i).update(delta);
			}

		}
		else
		{
			float dt = isReverse(step) ? -delta : delta;
			if (delta >= 0) for (int i = 0, n = children.size(); i < n; i++) children.get(i).update(dt);
			else for (int i = children.size() - 1; i >= 0; i--) children.get(i).update(dt);
		}
	}

	// -------------------------------------------------------------------------
	// BaseTween impl.
	// -------------------------------------------------------------------------

	@Override
	protected void forceStartValues()
	{
		for (int i = children.size() - 1; i >= 0; i--)
		{
			BaseTween<?> obj = children.get(i);
			obj.forceToStart();
		}
	}

	@Override
	protected void forceEndValues()
	{
		for (int i = 0, n = children.size(); i < n; i++)
		{
			BaseTween<?> obj = children.get(i);
			obj.forceToEnd(duration);
		}
	}

	@Override
	protected boolean containsTarget(Object target)
	{
		for (int i = 0, n = children.size(); i < n; i++)
		{
			BaseTween<?> obj = children.get(i);
			if (obj.containsTarget(target)) return true;
		}
		return false;
	}

	@Override
	protected boolean containsTarget(Object target, int tweenType)
	{
		for (int i = 0, n = children.size(); i < n; i++)
		{
			BaseTween<?> obj = children.get(i);
			if (obj.containsTarget(target, tweenType)) return true;
		}
		return false;
	}
}
