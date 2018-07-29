package net.runelite.client.plugins.mining;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Point;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.*;
import java.util.Map;

public class miningRockOverlay extends Overlay {


	private final Client client;

	private final miningPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	private boolean panelUp = false;

	@Inject
	ItemManager itemManager;

	@Inject
	miningRockOverlay(Client client, miningPlugin a) {
		this.client = client;
		this.plugin = a;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
	}


	@Override
	public Dimension render(Graphics2D graphics) {


		if (plugin.getRockObjects() != null && plugin.getRockObjects().size() > 0) {

			for (GameObject rock : plugin.getRockObjects()) {
				if (plugin.getRockObjects() != null) {
					if (rock != null) {
						if (rock.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) < 12) {
							if (rock.getCanvasLocation() != null && Rock.isRock(rock.getId())) {
									OverlayUtil.renderTextLocation(graphics, new Point(rock.getCanvasLocation().getX(), rock.getCanvasLocation().getY() - 40), Rock.getName(rock) , Color.green);
									 OverlayUtil.renderImageLocation(graphics, rock.getCanvasLocation(), itemManager.getImage(1275));
								}
							}
						}

					}

				}
		}

		if (plugin.getDespawnedRockObjects() != null) {

			for (GameObject rock : plugin.getDespawnedRockObjects()) {
				if (plugin.getDespawnedRockObjects() != null && rock != null) {
					if (rock.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) < 12) {

						if (rock.getCanvasLocation() != null) {
							Long respawnTime = null;

							Point rockLoc = new Point(rock.getWorldLocation().getX(), rock.getWorldLocation().getY());
							for (Map.Entry<Point, Long> timers : plugin.getDespawnedRockObjectsTimers().entrySet()) {

								if (timers.getKey().getX() == rockLoc.getX() && timers.getKey().getY() == rockLoc.getY()) {

									 respawnTime =  System.currentTimeMillis() - timers.getValue();

									break;
								}
							}
							if (respawnTime != null)
							{
								Long editedRespawnTime = ((Rock.getRespawnTime(rock.getId()) - respawnTime) / 1000);
								OverlayUtil.renderTextLocation(graphics
										, rock.getCanvasLocation()
										, Rock.getName(rock) +
												" respawning in: " +
												(editedRespawnTime)
										, new Color(51,204,255));
								if (respawnTime >= Rock.getRespawnTime(rock.getId())) {
									plugin.getDespawnedRockObjectsTimers().remove(rockLoc);
								}
							}
						}
					}


				}

			}
		}




		return null;
	}



}