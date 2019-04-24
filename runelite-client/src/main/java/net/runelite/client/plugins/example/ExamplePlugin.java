package net.runelite.client.plugins.example;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.HashSet;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.Point;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cluescrolls.clues.emote.STASHUnit;
import net.runelite.client.ui.overlay.arrow.ArrowPoint;
import net.runelite.client.ui.overlay.arrow.ArrowPointManager;
import net.runelite.client.ui.overlay.arrow.ArrowType;

@PluginDescriptor(
	name = "ArrowTest",
	developerPlugin = true
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private ArrowPointManager arrowPointManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private boolean	firstLogin = true;

	@Override
	public void startUp() throws Exception
	{
		clientThread.invokeLater(this::loadArrows);
	}

	@Override
	public void shutDown()
	{
		arrowPointManager.clear();
	}

	public void loadArrows()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		BufferedImage i = spriteManager.getSprite(SpriteID.MINIMAP_GUIDE_ARROW_YELLOW, 0);

		BufferedImage i3 = spriteManager.getSprite(SpriteID.RED_GUIDE_ARROW, 0);
		AffineTransform at = new AffineTransform();
		at.concatenate(AffineTransform.getScaleInstance(1, -1));
		at.concatenate(AffineTransform.getTranslateInstance(0, -i3.getHeight()));
		BufferedImage i4 = new BufferedImage(i3.getWidth(), i3.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = i4.createGraphics();
		g.transform(at);
		g.drawImage(i3, 0, 0, null);
		g.dispose();

		Point i3Offset = new Point(0, i3.getHeight() / -2);

		ArrowPoint one = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1554, 3551, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.WORLD_POINT))
			.build();
		//arrowPointManager.add(this, one);

		ArrowPoint two = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1544, 3580, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.WORLD_POINT))
			.build();
		//arrowPointManager.add(this, two);

		ArrowPoint three = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1571, 3541, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.WORLD_POINT))
			.build();
		//arrowPointManager.add(this, three);

		HashSet<Integer> NPCs = new HashSet<>();
		NPCs.add(6910);

		ArrowPoint npcone = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1545, 3595, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.npcIDs(NPCs)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.NPC))
			.build();
		//arrowPointManager.add(this, npcone);

		HashSet<Integer> NPCs2 = new HashSet<>();
		NPCs2.add(6889);
		NPCs2.add(6883);
		NPCs2.add(6885);

		ArrowPoint npctwo = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1551, 3561, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.worldImageOffset(new Point(0, -i4.getHeight()))
			.npcIDs(NPCs2)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.NPC))
			.build();
		//arrowPointManager.add(this, npctwo);

		HashSet<Integer> OBJs = new HashSet<>();
		OBJs.add(STASHUnit.SHAYZIEN_WAR_TENT);

		ArrowPoint objone = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1550, 3541, 0))
			.minimapImage(i4)
			.worldImage(i)
			.minimapImageOffset(i3Offset)
			.worldImageOffset(new Point(0, -i4.getHeight()))
			.objectIDs(OBJs)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.OBJECT))
			.build();
		arrowPointManager.add(this, objone);

		BufferedImage i5 = itemManager.getImage(ItemID.BONES);

		ArrowPoint four = ArrowPoint.builder()
			.worldPoint(new WorldPoint(1517, 3553, 0))
			.minimapImage(i5)
			.worldImage(i5)
			.minimapImagePointToTarget(false)
			.types(EnumSet.of(ArrowType.MINIMAP, ArrowType.WORLD_POINT))
			.build();
		//arrowPointManager.add(this, four);
	}
}
