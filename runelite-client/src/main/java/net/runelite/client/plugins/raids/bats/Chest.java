package net.runelite.client.plugins.raids.bats;

import java.awt.Color;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

public class Chest
{
	public enum State
	{
		UNDEFINED(Color.magenta),
		GRUBS(Color.blue),
		POISON(Color.green),
		BATS(Color.white);

		@Getter
		private Color color;

		State(Color color)
		{
			this.color = color;
		}
	}

	@Getter
	@Setter
	private State state = State.UNDEFINED;

	@Getter
	@Setter
	private long tickPoison = -1;

	@Getter
	@Setter
	private int number = -1;

	@Getter
	@Setter
	private int solutionSetCount = -1;

	@Getter
	private WorldPoint location;

	public Chest(WorldPoint location)
	{
		this.location = location;
	}
}
