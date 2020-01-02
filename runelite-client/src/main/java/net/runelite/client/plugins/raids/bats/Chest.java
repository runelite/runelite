package net.runelite.client.plugins.raids.bats;

import java.awt.Color;
import lombok.Getter;
import lombok.Setter;

public class Chest
{
	@Setter
	@Getter
	private long tickPoison = -1;

	@Getter
	@Setter
	private State state = State.UNDEFINED;

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
}
