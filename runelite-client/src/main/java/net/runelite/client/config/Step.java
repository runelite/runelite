package net.runelite.client.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Used with {@link ConfigItem}, describes the step size for a numeric config item.
 * </p>
 * <ul>
 *     <li>for an {@code int} item, use {@link #step()}</li>
 *     <li>for a {@code double} item, use {@link #stepDouble()}</li>
 *     <li>for a {@link java.awt.Dimension} item, use:
 *     <ul>
 *         <li>{@link #step()} {@link java.awt.Dimension#width}</li>
 *         <li>{@link #stepHeight()} for the {@link java.awt.Dimension#height}</li>
 *     </ul>
 * </ul>
 * <p>
 * Any values specified other than those described above will be ignored.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Step
{
	int step() default 1;

	int stepHeight() default 1;

	double stepDouble() default 0.1;
}
