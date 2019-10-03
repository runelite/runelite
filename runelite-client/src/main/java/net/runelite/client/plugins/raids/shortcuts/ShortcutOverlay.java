package net.runelite.client.plugins.raids.shortcuts;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.TileObject;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class ShortcutOverlay extends Overlay
{
	private final Client client;
	private final ShortcutPlugin plugin;
	private final BufferedImage treeIcon;
	private final BufferedImage strengthIcon;
	private final BufferedImage miningIcon;

	@Inject
	ShortcutOverlay(final Client client, final ShortcutPlugin plugin, final SkillIconManager iconManager)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_SCENE);

		treeIcon = iconManager.getSkillImage(Skill.WOODCUTTING);
		strengthIcon = iconManager.getSkillImage(Skill.STRENGTH);
		miningIcon = iconManager.getSkillImage(Skill.MINING);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (TileObject shortcut : plugin.getShortcut())
		{
			if (shortcut.getPlane() == client.getPlane())
			{
				Shape poly;
				if ((shortcut instanceof GameObject))
				{
					poly = ((GameObject) shortcut).getConvexHull();
				}
				else
				{
					poly = shortcut.getCanvasTilePoly();
				}
				if (poly != null)
				{
					String name;
					switch (shortcut.getId())
					{
						case 29736:
							name = "Tree";
							break;
						case 29738:
							name = "Rocks";
							break;
						case 29740:
							name = "Boulder";
							break;
						case 29737:
						case 29739:
						default:
							name = "null";
					}
					if (plugin.isHighlightShortcuts())
					{
						if (name.equals("Tree"))
						{
							Point canvasLoc = Perspective.getCanvasImageLocation(client, shortcut.getLocalLocation(),
								treeIcon, 150);
							if (canvasLoc != null)
							{
								graphics.drawImage(treeIcon, canvasLoc.getX(), canvasLoc.getY(), null);
							}
						}
						if (name.equals("Rocks"))
						{
							Point canvasLoc = Perspective.getCanvasImageLocation(client, shortcut.getLocalLocation(),
								miningIcon, 150);
							if (canvasLoc != null)
							{
								graphics.drawImage(miningIcon, canvasLoc.getX(), canvasLoc.getY(), null);
							}
						}
						if (name.equals("Boulder"))
						{
							Point canvasLoc = Perspective.getCanvasImageLocation(client, shortcut.getLocalLocation(),
								strengthIcon, 150);
							if (canvasLoc != null)
							{
								graphics.drawImage(strengthIcon, canvasLoc.getX(), canvasLoc.getY(), null);
							}
						}
					}
				}
			}
		}
		return null;
	}
}
