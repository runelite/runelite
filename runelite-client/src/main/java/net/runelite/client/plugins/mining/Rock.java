package net.runelite.client.plugins.mining;

import lombok.Getter;
import net.runelite.api.GameObject;

@Getter
public enum Rock
{
	RuneEssence,
	PureEssence,
	Clay,
	Copper,
	Tin,
	Iron,
	Silver,
	Coal,
	Gold,
	Mithril,
	Adamantite,
	Runite;


	static int runeessenceRock[] =
			{
					7471
			};


	static int clayrockID[] =
			{
					7487,
					7454
			};

	static int copperrockID[] =
			{
					7484,
					7453
			};


	//tin
	static int tinrockID[] =
			{
					7485,
					7486,
			};


	static int ironrockID[] =
			{
					7455,
					7488
			};

	static int silverrockID[] =
			{
					7457,
					7490
			};

	static int coalrockID[] =
			{
					7456,
					7489
			};

	static int goldrockID[] =
			{
					7491,
					7458
			};

	static int mithrilrockID[] =
			{
					7459,
					7492
			};

	static int adamantiterockID[] =
			{
					7460,
					7493
			};

	static int runiterockID[] =
			{
					7461,
					7494
			}; //Need id's


	//returns if the gameObject is a mining rock
	public static boolean isRock(int id)
	{
		return getRockType(id) != null;
	}

	//return what kind of rock
	public static Rock getRockType(int i)
	{

		for (int a : runeessenceRock)
		{
			if (a == i)
			{
				return Rock.RuneEssence;
			}
		}


		for (int a : clayrockID)
		{
			if (a == i)
			{
				return Rock.Clay;
			}
		}

		for (int a : copperrockID)
		{
			if (a == i)
			{
				return Rock.Copper;
			}
		}

		for (int a : tinrockID)
		{
			if (a == i)
			{
				return Rock.Tin;
			}
		}

		for (int a : silverrockID)
		{
			if (a == i)
			{
				return Rock.Silver;
			}
		}

		for (int a : coalrockID)
		{
			if (a == i)
			{
				return Rock.Coal;
			}
		}

		for (int a : ironrockID)
		{
			if (a == i)
			{
				return Rock.Iron;
			}
		}

		for (int a : goldrockID)
		{
			if (a == i)
			{
				return Rock.Gold;
			}
		}

		for (int a : mithrilrockID)
		{
			if (a == i)
			{
				return Rock.Mithril;
			}
		}

		for (int a : adamantiterockID)
		{
			if (a == i)
			{
				return Rock.Adamantite;
			}
		}

		for (int a : runiterockID)
		{
			if (a == i)
			{
				return Rock.Runite;
			}
		}

		return null;
	}


	//returns the respawn time of the rock
	public static int getRespawnTime(int id)
	{

		switch (Rock.getRockType(id))
		{
			case RuneEssence:
				return 0;
			case Clay:
				return 2000;
			case Copper:
				return 2000;
			case Tin:
				return 2000;
			case Iron:
				return 5400;
			case Silver:
				return 60000;
			case Coal:
				return 30000;
			case Gold:
				return 60000;
			case Mithril:
				return 120000;
			case Adamantite:
				return 240000;
			case Runite:
				return 720000;

		}


		return 0;
	}

	//returns rock name
	public static String getName(Rock rock)
	{
		return rock.name();
	}

	//returns rock name
	public static String getName(GameObject gameObject)
	{
		if (gameObject != null)
		{
			if (isRock(gameObject.getId()))
			{
				return getRockType(gameObject.getId()).name();
			}
		}
		return null;
	}

}


