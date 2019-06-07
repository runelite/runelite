package api.events;

import api.Actor;
import lombok.Data;

/**
 * An event where the graphic of an {@link Actor} has changed.
 * <p>
 * The graphic the player has changed to can be obtained using
 * {@link Actor#getSpotAnimation()}.
 * <p>
 * Examples of when this event may trigger include:
 * <ul>
 *     <li>Casting a magic spell</li>
 *     <li>Using a fairy ring</li>
 *     <li>Breaking a teleport tab</li>
 * </ul>
 *
 * @see api.GraphicID
 */
@Data
public class SpotAnimationChanged
{
	/**
	 * The actor that has had their graphic changed.
	 */
	private Actor actor;
}