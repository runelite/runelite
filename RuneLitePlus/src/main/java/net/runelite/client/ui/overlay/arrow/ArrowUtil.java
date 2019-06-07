package net.runelite.client.ui.overlay.arrow;

import api.Client;
import api.GameObject;
import api.ObjectDefinition;
import api.Scene;
import api.Tile;
import java.util.ArrayList;
import java.util.HashSet;

class ArrowUtil
{
	static ArrayList<GameObject> getObjects(final Client client, HashSet<Integer> objectIDs)
	{
		final Scene scene = client.getScene();
		final Tile[][] tiles = scene.getTiles()[client.getPlane()];
		final ArrayList<GameObject> found = new ArrayList<>();

		for (Tile[] tiles2 : tiles)
		{
			for (Tile tile : tiles2)
			{
				for (GameObject object : tile.getGameObjects())
				{
					if (object == null)
					{
						continue;
					}

					if (objectIDs.contains(object.getId()))
					{
						found.add(object);
						continue;
					}

					// Check impostors
					final ObjectDefinition comp = client.getObjectDefinition(object.getId());
					final ObjectDefinition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

					if (impostor != null && objectIDs.contains(impostor.getId()))
					{
						found.add(object);
					}
				}
			}
		}

		return found;
	}
}
