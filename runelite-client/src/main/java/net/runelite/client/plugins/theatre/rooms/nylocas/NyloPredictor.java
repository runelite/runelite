package net.runelite.client.plugins.theatre.rooms.nylocas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.NpcSpawned;

public class NyloPredictor
{

	private static final Wave[] NYLOCAS_WAVES = new Wave[]
		{
			new Wave(new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_260, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_260, Spawn.EAST), new Nylocas(NylocasType.RANGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.EAST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_260, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.EAST), new Nylocas(NylocasType.MELEE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_260, Spawn.WEST), new Nylocas(NylocasType.RANGE_260, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST), new Nylocas(NylocasType.RANGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_260, Spawn.WEST), new Nylocas(NylocasType.RANGE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MELEE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MAGE_260, Spawn.WEST), new Nylocas(NylocasType.MELEE_260, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MELEE_260, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.RANGE_260, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.MAGE_260, Spawn.EAST)),
			new Wave(new Nylocas(NylocasType.MELEE_162, Spawn.WEST), new Nylocas(NylocasType.RANGE_162, Spawn.WEST), new Nylocas(NylocasType.MAGE_162, Spawn.SOUTH), new Nylocas(NylocasType.MELEE_162, Spawn.SOUTH), new Nylocas(NylocasType.RANGE_162, Spawn.EAST), new Nylocas(NylocasType.MAGE_162, Spawn.EAST))
		};
	private final Client client;
	int westBound = 50;
	int eastBound = 77;
	int southBound = 42;
	private final NyloHandler handler;
	private final Map<Nylocas, NPC> currentSpawns = new HashMap<>();
	private int currentIndex = -1;

	NyloPredictor(Client client, NyloHandler handler)
	{
		this.client = client;
		this.handler = handler;
		this.reset();
	}

	public void reset()
	{
		this.currentSpawns.clear();
		this.currentIndex = -1;
	}

	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();

		LocalPoint lp = npc.getLocalLocation();

		int x = lp.getSceneX();
		int y = lp.getSceneY();

		Spawn spawn = null;
		if (x <= westBound)
		{
			spawn = Spawn.WEST;
		}
		else if (x >= eastBound)
		{
			spawn = Spawn.EAST;
		}
		else if (y <= southBound)
		{
			spawn = Spawn.SOUTH;
		}

		NylocasType type = null;

		String name = npc.getName();
		int level = npc.getCombatLevel();

		if (name.contains("Hagios"))
		{
			type = NylocasType.valueOf("MAGE_" + level);
		}
		else if (name.contains("Toxobolos"))
		{
			type = NylocasType.valueOf("RANGE_" + level);
		}
		else if (name.contains("Ischyros"))
		{
			type = NylocasType.valueOf("MELEE_" + level);
		}

		if (spawn == null || type == null)
		{
			return;
		}

		currentSpawns.put(new Nylocas(type, spawn), npc);
		this.checkSpawns();
	}

	private void checkSpawns()
	{
		for (int i = (currentIndex + 1); i < NYLOCAS_WAVES.length; i++)
		{
			Wave checkWave = NYLOCAS_WAVES[i];

			List<Nylocas> queue = new ArrayList<>(currentSpawns.keySet());
			HashMap<NPC, Nylocas> npcs = new HashMap<>();

			boolean found = true;
			for (Nylocas nylocas : checkWave.getSpawns())
			{
				if (queue.contains(nylocas))
				{
					int index = queue.indexOf(nylocas);
					Nylocas hashed = queue.remove(index);
					npcs.put(currentSpawns.get(hashed), hashed);
				}
				else
				{
					found = false;
					break;
				}
			}

			if (found)
			{
				currentIndex = i;
				currentSpawns.clear();

				handler.setWave(currentIndex);

				for (Map.Entry<NPC, Nylocas> nylocas : npcs.entrySet())
				{
					Nylocas nylo = nylocas.getValue();

					if (!this.handler.waveSpawns.contains(nylocas.getKey()))
					{
						this.handler.waveSpawns.add(nylocas.getKey());
					}

					if (this.isAgressive(nylo.getType(), nylo.getSpawn(), currentIndex) && !this.handler.waveAgros.contains(nylocas.getKey()))
					{
						this.handler.waveAgros.add(nylocas.getKey());
					}
				}

				int elapsedTicks = client.getTickCount() - this.handler.startTick;

				int mage_count = 0;
				int range_count = 0;
				int melee_count = 0;

				int mage_level = 0;
				int range_level = 0;
				int melee_level = 0;

				for (NPC npc : client.getNpcs())
				{
					if (npc.getHealthRatio() == 0)
					{
						continue;
					}
					if (npc.getName().equalsIgnoreCase("Nylocas Hagios"))
					{
						mage_level += npc.getCombatLevel();
						mage_count += 1;
					}
					else if (npc.getName().equalsIgnoreCase("Nylocas Toxobolos"))
					{
						range_level += npc.getCombatLevel();
						range_count += 1;
					}
					else if (npc.getName().equalsIgnoreCase("Nylocas Ischyros"))
					{
						melee_level += npc.getCombatLevel();
						melee_count += 1;
					}
				}

				for (Nylocas nylocas : checkWave.getSpawns())
				{
					NylocasType type = nylocas.getType();
					if (type.name().contains("RANGE"))
					{
						range_count--;
						range_level -= Integer.parseInt(type.name().split("_")[1]);
					}
					else if (type.name().contains("MAGE"))
					{
						mage_count--;
						mage_level -= Integer.parseInt(type.name().split("_")[1]);
					}
					else if (type.name().contains("MELEE"))
					{
						melee_count--;
						melee_level -= Integer.parseInt(type.name().split("_")[1]);
					}
				}

			}
		}
	}

	private boolean isAgressive(NylocasType type, Spawn spawn, int wave)
	{
		if (wave == 0 && spawn == Spawn.WEST)
		{
			return true;
		}
		else if (wave == 1 && spawn == Spawn.SOUTH)
		{
			return true;
		}
		else if (wave == 2 && spawn == Spawn.EAST)
		{
			return true;
		}
		else if (wave == 6 && spawn == Spawn.SOUTH && type == NylocasType.RANGE_260)
		{
			return true;
		}
		else if (wave == 7 && spawn == Spawn.WEST)
		{
			return true;
		}
		else if (wave == 8 && spawn == Spawn.WEST && type == NylocasType.RANGE_260)
		{
			return true;
		}
		else if (wave == 9)
		{
			if (spawn == Spawn.EAST && type == NylocasType.RANGE_162)
			{
				return true;
			}
			else
			{
				return spawn == Spawn.WEST;
			}
		}
		else if (wave == 10 && (spawn == Spawn.EAST || spawn == Spawn.WEST))
		{
			return true;
		}
		else if (wave == 11 && (spawn == Spawn.EAST || spawn == Spawn.WEST))
		{
			return true;
		}
		else if (wave == 12)
		{
			if (spawn == Spawn.WEST && type == NylocasType.MAGE_162)
			{
				return true;
			}
			else
			{
				return spawn == Spawn.EAST;
			}
		}
		else if (wave == 13)
		{
			if (spawn == Spawn.WEST && type == NylocasType.MELEE_162)
			{
				return true;
			}
			else
			{
				return spawn == Spawn.EAST;
			}
		}
		else if (wave == 14)
		{
			if (spawn == Spawn.WEST && type == NylocasType.RANGE_162)
			{
				return true;
			}
			else
			{
				return spawn == Spawn.EAST && type == NylocasType.MAGE_162;
			}
		}
		else if (wave == 17 && spawn == Spawn.WEST)
		{
			return true;
		}
		else if (wave == 18 && spawn == Spawn.EAST)
		{
			return true;
		}
		else if (wave == 19 && spawn == Spawn.SOUTH)
		{
			return true;
		}
		else if (wave == 20 && (spawn == Spawn.EAST || spawn == Spawn.SOUTH))
		{
			return true;
		}
		else if (wave == 21 && spawn == Spawn.EAST)
		{
			return true;
		}
		else if (wave == 22 && spawn == Spawn.SOUTH)
		{
			return true;
		}
		else if (wave == 23)
		{
			return true;
		}
		else if ((wave == 24 || wave == 25) && spawn == Spawn.WEST)
		{
			return true;
		}
		else if (wave == 26 && spawn == Spawn.SOUTH)
		{
			return true;
		}
		else if (wave == 27 && spawn == Spawn.WEST && type == NylocasType.RANGE_162)
		{
			return true;
		}
		else if (wave == 28)
		{
			if (spawn == Spawn.EAST && type == NylocasType.RANGE_162)
			{
				return true;
			}
			else
			{
				return spawn == Spawn.WEST && type == NylocasType.MELEE_162;
			}

		}
		else
		{
			return wave == 29 && spawn == Spawn.EAST;
		}

	}

	public int getCurrentWave()
	{
		return this.currentIndex + 1;
	}

	public int getTotalWaves()
	{
		return NyloPredictor.NYLOCAS_WAVES.length;
	}

	public Wave getNextWave()
	{
		if ((currentIndex + 1) < NYLOCAS_WAVES.length)
		{
			return NYLOCAS_WAVES[currentIndex + 1];
		}
		else
		{
			return null;
		}
	}

	public String getSpawnStr(Spawn spawn, Wave wave)
	{
		if (wave == null || spawn == null)
		{
			return null;
		}
		else
		{
			StringBuilder types = new StringBuilder();

			for (Nylocas nylo : wave.getSpawns())
			{
				if (nylo.getSpawn() == spawn)
				{
					if (types.length() > 0)
					{
						types.append(", ");
					}

					switch (nylo.getType())
					{
						case MAGE_162:
							types.append("Small Mage");
							break;
						case MAGE_260:
							types.append("Big Mage");
							break;
						case MELEE_162:
							types.append("Small Melee");
							break;
						case MELEE_260:
							types.append("Big Melee");
							break;
						case RANGE_162:
							types.append("Small Range");
							break;
						case RANGE_260:
							types.append("Big Range");
							break;
					}
				}
			}

			return types.length() > 0 ? types.toString() : null;
		}
	}

	public enum NylocasType
	{
		MELEE_162,
		RANGE_162,
		MAGE_162,
		MELEE_260,
		RANGE_260,
		MAGE_260
	}

	public enum Spawn
	{
		WEST,
		SOUTH,
		EAST
	}

	public static class Nylocas
	{

		private final NylocasType type;
		private final Spawn spawn;

		Nylocas(NylocasType type, Spawn spawn)
		{
			this.type = type;
			this.spawn = spawn;
		}

		NylocasType getType()
		{
			return this.type;
		}

		Spawn getSpawn()
		{
			return this.spawn;
		}

		@Override
		public boolean equals(Object object)
		{
			if ((object instanceof Nylocas))
			{
				Nylocas nylo = (Nylocas) object;
				return nylo.getType() == this.type && nylo.getSpawn() == this.spawn;
			}

			return false;
		}
	}

	public static class Wave
	{

		private final Nylocas[] spawns;

		Wave(Nylocas... nylocas)
		{
			this.spawns = nylocas;
		}

		Nylocas[] getSpawns()
		{
			return this.spawns;
		}
	}
}