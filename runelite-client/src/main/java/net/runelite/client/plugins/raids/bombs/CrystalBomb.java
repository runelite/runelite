package net.runelite.client.plugins.raids.bombs;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

import java.time.Instant;


@Slf4j
public class CrystalBomb
{
	@Getter
	private Instant plantedOn;

	@Getter
	private Instant lastClockUpdate;

	@Getter
	@Setter
	private State state;

	@Getter
	private int objectId;

	@Getter
	private int ticksAlive;
	//ticks that bomb has been 'live' for.

	@Getter
	private WorldPoint worldLocation;

	enum State
	{
		ACTIVE
	}

	public CrystalBomb(GameObject gameObject)
	{
		this.state = State.ACTIVE;
		this.plantedOn = Instant.now();
		this.objectId = gameObject.getId();
		this.worldLocation = gameObject.getWorldLocation();
		this.ticksAlive = 0;
	}

	public void tickUpBombTime()
	{
		lastClockUpdate = Instant.now();
		ticksAlive++;
		//log.info("Bomb active for {} ticks.",ticksAlive);
	}

}
