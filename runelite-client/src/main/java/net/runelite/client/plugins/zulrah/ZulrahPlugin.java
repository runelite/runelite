package net.runelite.client.plugins.zulrah;

import net.runelite.api.events.AnimationChanged;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.util.List;

import net.runelite.api.*;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Zulrah",
	description = "Zulrah Helper",
	tags = {"Zulrah", "Helper"}
)
public class ZulrahPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ZulrahConfig config;

	@Inject
	private ZulrahOverlay ZulrahOverlay;

	@Inject
	private ZulrahTileOverlay ZulrahTileOverlay;

	@Inject
	private ZulrahJadOverlay ZulrahJadOverlay;

	@Inject
	private Client client;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	ZulrahConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(ZulrahConfig.class);
	}

	private static final int[] PROTECTION_ICONS = {
		SpriteID.PRAYER_PROTECT_FROM_MISSILES,
		SpriteID.PRAYER_PROTECT_FROM_MELEE,
		SpriteID.PRAYER_PROTECT_FROM_MAGIC
	};

	private static final Dimension PROTECTION_ICON_DIMENSION = new Dimension(33, 33);
	private static final Color PROTECTION_ICON_OUTLINE_COLOR = new Color(33, 33, 33);
	public final BufferedImage[] ProtectionIcons = new BufferedImage[PROTECTION_ICONS.length];
	int zulrahstart = 0;
	NPC Zulrah;

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
			loadProtectionIcons();
		}
	}

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(ZulrahOverlay);
		overlayManager.add(ZulrahTileOverlay);
		overlayManager.add(ZulrahJadOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(ZulrahOverlay);
		overlayManager.remove(ZulrahTileOverlay);
		overlayManager.remove(ZulrahJadOverlay);
	}

	LocalPoint ZulrahPosCenter = new LocalPoint(6720, 7616);
	LocalPoint ZulrahPosWest = new LocalPoint(8000, 7360);
	LocalPoint ZulrahPosEast = new LocalPoint(5440, 7360);
	LocalPoint ZulrahPosNorth = new LocalPoint(6720, 6208);

	LocalPoint SWCornerTile = new LocalPoint(7488, 7872);
	LocalPoint SWCornerTileMelee = new LocalPoint(7232, 8000);
	LocalPoint WPillar = new LocalPoint(7232, 7232);
	LocalPoint WPillarN = new LocalPoint(7232, 7104);
	LocalPoint EPillar = new LocalPoint(6208, 7232);
	LocalPoint EPillarN = new LocalPoint(6208, 7104);
	LocalPoint SECornerTile = new LocalPoint(6208, 8000);
	LocalPoint SECornerTileMelee = new LocalPoint(5952, 7744);
	LocalPoint Middle = new LocalPoint(6720, 6848);

	int ticks;
	int phaseticks;
	int not;
	int lastphase;
	int phase;
	int nextprayerendticks;
	boolean phase1 = true;
	boolean phase2 = true;
	boolean phase3 = true;
	boolean phase4 = true;
	boolean restart = false;
	boolean prayerconserve = false;
	int jadphase;
	boolean jadflip = false;
	Color nztcolor;
	LocalPoint nextzulrahtile;
	LocalPoint nexttile;
	LocalPoint currenttile;
	LocalPoint lastloc;
	LocalPoint MeleeTile;
	List<Integer> phases = new ArrayList<>();
	List<LocalPoint> locations = new ArrayList<>();

	ArrayList<Integer> Phase1types = new ArrayList<>(Arrays.asList(2042, 2043, 2044, 2042, 2044, 2043, 2042, 2044, 2042, 2043));
	ArrayList<LocalPoint> Phase1pos = new ArrayList<>(Arrays.asList(ZulrahPosCenter, ZulrahPosCenter, ZulrahPosCenter, ZulrahPosEast, ZulrahPosNorth, ZulrahPosCenter, ZulrahPosWest, ZulrahPosNorth, ZulrahPosEast, ZulrahPosCenter));
	ArrayList<LocalPoint> Phase1tiles = new ArrayList<>(Arrays.asList(SWCornerTile, SWCornerTile, SWCornerTile, EPillar, EPillarN, EPillar, Middle, EPillar, EPillar, SWCornerTile));
	ArrayList<Integer> Phase1ticks = new ArrayList<>(Arrays.asList(28, 20, 18, 28, 39, 22, 20, 36, 48, 20));

	ArrayList<Integer> Phase2types = new ArrayList<>(Arrays.asList(2042, 2043, 2044, 2042, 2043, 2044, 2042, 2044, 2042, 2043));
	ArrayList<LocalPoint> Phase2pos = new ArrayList<>(Arrays.asList(ZulrahPosCenter, ZulrahPosCenter, ZulrahPosCenter, ZulrahPosNorth, ZulrahPosCenter, ZulrahPosEast, ZulrahPosNorth, ZulrahPosNorth, ZulrahPosEast, ZulrahPosCenter));
	ArrayList<LocalPoint> Phase2tiles = new ArrayList<>(Arrays.asList(SWCornerTile, SWCornerTile, SWCornerTile, EPillar, EPillar, EPillar, WPillar, WPillarN, EPillar, SWCornerTile));
	ArrayList<Integer> Phase2ticks = new ArrayList<>(Arrays.asList(28, 20, 17, 39, 22, 20, 28, 36, 48, 21));

	ArrayList<Integer> Phase3types = new ArrayList<>(Arrays.asList(2042, 2042, 2043, 2044, 2042, 2044, 2042, 2042, 2044, 2042, 2044));
	ArrayList<LocalPoint> Phase3pos = new ArrayList<>(Arrays.asList(ZulrahPosCenter, ZulrahPosWest, ZulrahPosCenter, ZulrahPosEast, ZulrahPosNorth, ZulrahPosWest, ZulrahPosCenter, ZulrahPosEast, ZulrahPosCenter, ZulrahPosWest, ZulrahPosCenter));
	ArrayList<LocalPoint> Phase3tiles = new ArrayList<>(Arrays.asList(SWCornerTile, SWCornerTile, SECornerTile, EPillar, WPillar, WPillar, EPillar, EPillar, WPillar, WPillar, SWCornerTile));
	ArrayList<Integer> Phase3ticks = new ArrayList<>(Arrays.asList(28, 30, 40, 20, 20, 20, 25, 20, 36, 35, 18));

	ArrayList<Integer> Phase4types = new ArrayList<>(Arrays.asList(2042, 2044, 2042, 2044, 2043, 2042, 2042, 2044, 2042, 2044, 2042, 2044));
	ArrayList<LocalPoint> Phase4pos = new ArrayList<>(Arrays.asList(ZulrahPosCenter, ZulrahPosWest, ZulrahPosNorth, ZulrahPosEast, ZulrahPosCenter, ZulrahPosWest, ZulrahPosNorth, ZulrahPosEast, ZulrahPosCenter, ZulrahPosCenter, ZulrahPosWest, ZulrahPosCenter));
	ArrayList<LocalPoint> Phase4tiles = new ArrayList<>(Arrays.asList(SWCornerTile, SWCornerTile, EPillar, EPillar, WPillar, WPillar, WPillar, EPillar, WPillar, WPillar, WPillar, SWCornerTile));
	ArrayList<Integer> Phase4ticks = new ArrayList<>(Arrays.asList(28, 36, 24, 30, 28, 17, 34, 33, 20, 27, 29, 18));

	@Subscribe
	public void onGameTick(GameTick event) {
		if (!config.EnableZulrah()) {
			return;
		}

		if (phase4 && phases.size() == 11) {
			jadphase = 1;
		} else if (phase3 && phases.size() == 10) {
            jadphase = 1;
		} else if (phase2 && phases.size() == 9) {
            jadphase = 2;
		} else if (phase1 && phases.size() == 9) {
            jadphase = 2;
		} else {
            jadphase = 0;
            jadflip = false;
        }

		boolean foundzulrah = false;
		for (NPC monster : client.getNpcs())
		{
			if (monster == null || monster.getName() == null)
			{
				continue;
			}
			if (monster.getName().equalsIgnoreCase("zulrah")) {
				foundzulrah = true;
				Zulrah = monster;
				break;
			}
		}
		if (!foundzulrah) {
			Zulrah = null;
		}

		if (Zulrah != null) {
			if (zulrahstart == 0) {
				currenttile = SWCornerTile;
				lastloc = Zulrah.getLocalLocation();
				lastphase = Zulrah.getId();
				zulrahstart = client.getTickCount();
				phases.add(lastphase);
				locations.add(lastloc);
				phaseticks = 28;
			} else {
				if (!Zulrah.getLocalLocation().equals(lastloc) || Zulrah.getId() != lastphase) {
					if (restart) {
						phases.clear();
						locations.clear();
						zulrahstart = client.getTickCount();
						lastphase = 0;
						lastloc = null;
						phase = 0;
						phase1 = true;
						phase2 = true;
						phase3 = true;
						phase4 = true;
						nextzulrahtile = null;
						nztcolor = null;
						nexttile = null;
						currenttile = SWCornerTile;
						restart = false;
						ticks = 0;
						prayerconserve = false;
						phaseticks = 34;
						not = 0;
						nextprayerendticks = 0;
					}
					lastloc = Zulrah.getLocalLocation();
					lastphase = Zulrah.getId();
					ticks = 0;
					phases.add(lastphase);
					locations.add(lastloc);
					if (phase == 0) {
						for (int i = 0; i < phases.size(); i++) {
							if (phase1) {
								if (!phases.get(i).equals(Phase1types.get(i)) || !locations.get(i).equals(Phase1pos.get(i))) {
									phase1 = false;
									not++;
								}
							}
							if (phase2) {
								if (!phases.get(i).equals(Phase2types.get(i)) || !locations.get(i).equals(Phase2pos.get(i))) {
									phase2 = false;
									not++;
								}
							}
							if (phase3) {
								if (!phases.get(i).equals(Phase3types.get(i)) || !locations.get(i).equals(Phase3pos.get(i))) {
									phase3 = false;
									not++;
								}
							}
							if (phase4) {
								if (!phases.get(i).equals(Phase4types.get(i)) || !locations.get(i).equals(Phase4pos.get(i))) {
									phase4 = false;
									not++;
								}
							}
						}

						if (not == 2) {
							if (lastphase == 2043) {
								nztcolor = Color.BLUE;
								nextzulrahtile = ZulrahPosCenter;
								currenttile = SWCornerTile;
								nexttile = SWCornerTile;
								phaseticks = Phase2ticks.get(phases.size() - 1);
								prayerconserve = true;
							} else if (lastphase == 2044) {
								nztcolor = Color.GREEN;
								nextzulrahtile = ZulrahPosNorth;
								currenttile = SWCornerTile;
								nexttile = EPillar;
								phaseticks = Phase2ticks.get(phases.size() - 1);
								prayerconserve = false;
							}
						} else if (not == 3) {
							if (phase1) {
								nztcolor = zulrahtype(Phase1types.get(phases.size()));
								nextzulrahtile = Phase1pos.get(phases.size());
								currenttile = Phase1tiles.get(phases.size() - 1);
								nexttile = Phase1tiles.get(phases.size());
								phaseticks = Phase1ticks.get(phases.size() - 1);
								prayerconserve = true;
								phase = 1;
							} else if (phase2) {
								nztcolor = zulrahtype(Phase2types.get(phases.size()));
								nextzulrahtile = Phase2pos.get(phases.size());
								currenttile = Phase2tiles.get(phases.size() - 1);
								nexttile = Phase2tiles.get(phases.size());
								phaseticks = Phase2ticks.get(phases.size() - 1);
								prayerconserve = false;
								phase = 2;
							} else if (phase3) {
								nztcolor = zulrahtype(Phase3types.get(phases.size()));
								nextzulrahtile = Phase3pos.get(phases.size());
								currenttile = Phase3tiles.get(phases.size() - 1);
								nexttile = Phase3tiles.get(phases.size());
								phaseticks = Phase3ticks.get(phases.size() - 1);
								prayerconserve = false;
								phase = 3;
							} else if (phase4) {
								nztcolor = zulrahtype(Phase4types.get(phases.size()));
								nextzulrahtile = Phase4pos.get(phases.size());
								currenttile = Phase4tiles.get(phases.size() - 1);
								nexttile = Phase4tiles.get(phases.size());
								phaseticks = Phase4ticks.get(phases.size() - 1);
								prayerconserve = true;
								phase = 4;
							} else {
								System.out.println("ERROR: COULD NOT IDENTIFY ZULRAH PHASE!");
							}
							not = 0;
						}
					} else {
						if (phase == 1) {
							if (Phase1types.size() == phases.size()) {
								nztcolor = null;
								nextzulrahtile = null;
								nexttile = null;
								restart = true;
							} else {
								nextzulrahtile = Phase1pos.get(phases.size());
								nexttile = Phase1tiles.get(phases.size());
								if (phases.size() == 8) {
									nztcolor = Color.YELLOW;
								} else {
									nztcolor = zulrahtype(Phase1types.get(phases.size()));
								}
							}
							currenttile = Phase1tiles.get(phases.size() - 1);
							phaseticks = Phase1ticks.get(phases.size() - 1);
						} else if (phase == 2) {
							if (Phase2types.size() == phases.size()) {
								nztcolor = null;
								nextzulrahtile = null;
								nexttile = null;
								restart = true;
							} else {
								nextzulrahtile = Phase2pos.get(phases.size());
								nexttile = Phase2tiles.get(phases.size());
								if (phases.size() == 8) {
									nztcolor = Color.YELLOW;
								} else {
									nztcolor = zulrahtype(Phase2types.get(phases.size()));
								}
							}
							currenttile = Phase2tiles.get(phases.size() - 1);
							phaseticks = Phase2ticks.get(phases.size() - 1);
						} else if (phase == 3) {
							if (Phase3types.size() == phases.size()) {
								nztcolor = null;
								nextzulrahtile = null;
								nexttile = null;
								restart = true;
							} else {
								nextzulrahtile = Phase3pos.get(phases.size());
								nexttile = Phase3tiles.get(phases.size());
								if (phases.size() == 9) {
									nztcolor = Color.YELLOW;
								} else {
									nztcolor = zulrahtype(Phase3types.get(phases.size()));
								}
							}
							currenttile = Phase3tiles.get(phases.size() - 1);
							phaseticks = Phase3ticks.get(phases.size() - 1);
						} else if (phase == 4) {
							if (Phase4types.size() == phases.size()) {
								nztcolor = null;
								nextzulrahtile = null;
								nexttile = null;
								restart = true;
							} else {
								nextzulrahtile = Phase4pos.get(phases.size());
								nexttile = Phase4tiles.get(phases.size());
								if (phases.size() == 10) {
									nztcolor = Color.YELLOW;
								} else {
									nztcolor = zulrahtype(Phase4types.get(phases.size()));
								}
							}
							currenttile = Phase4tiles.get(phases.size() - 1);
							phaseticks = Phase4ticks.get(phases.size() - 1);
						} else {
							System.out.println("ERROR: COULD NOT IDENTIFY ZULRAH PHASE!");
						}
					}
				} else {
					ticks++;
					if (phases.size() == 1 && phaseticks == 34) {
						if (ticks >= 18) {
							prayerconserve = true;
						} else {
							prayerconserve = false;
						}
					}
					if (not == 2) {
						if (lastphase == 2043) {
							if (ticks >= 12 && ticks <= 13) {
								MeleeTile = SWCornerTileMelee;
							} else {
								MeleeTile = null;
							}
						}
					} else if (phase == 1) {
						if (phases.size() == 5) {
							if (ticks >= 19) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 8) {
							if (ticks >= 19) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 9) {
							if (ticks >= 34) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 10) {
							if (ticks >= 12 && ticks <= 13) {
								MeleeTile = SWCornerTileMelee;
							} else {
								MeleeTile = null;
							}
						} else if (phases.size() == 4 || phases.size() == 6 || phases.size() == 10) {
							prayerconserve = true;
						} else {
							prayerconserve = false;
						}
					} else if (phase == 2) {
						if (phases.size() == 4) {
							if (ticks >= 20) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 8) {
							if (ticks >= 18) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 9) {
							if (ticks >= 34) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 5 || phases.size() == 7 || phases.size() == 10) {
							if (phases.size() == 10) {
								if (ticks >= 12 && ticks <= 13) {
									MeleeTile = SWCornerTileMelee;
								} else {
									MeleeTile = null;
								}
							}
							prayerconserve = true;
						} else {
							prayerconserve = false;
						}
					} else if (phase == 3) {
						if (phases.size() == 2) {
							if (ticks >= 20) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 3) {
							prayerconserve = true;
							if (ticks >= 24 && ticks <= 25) {
								MeleeTile = SECornerTileMelee;
							} else if (ticks >= 32 && ticks <= 33) {
								MeleeTile = SECornerTile;
							} else {
								MeleeTile = null;
							}
						}  else if (phases.size() == 7 || phases.size() == 11) {
							prayerconserve = true;
						} else if (phases.size() == 9) {
							if (ticks >= 16) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else {
							prayerconserve = false;
						}
					} else if (phase == 4) {
						if (phases.size() == 2) {
							if (ticks >= 10 && ticks <= 16) {
								nextprayerendticks = 16;
							} else {
								nextprayerendticks = 0;
							}

							if (ticks >= 16) {
								prayerconserve = false;
							} else {
								prayerconserve = true;
							}
						} else if (phases.size() == 3) {
							if (ticks >= 16) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 4) {
							if (ticks >= 10 && ticks <= 16) {
								nextprayerendticks = 16;
							} else {
								nextprayerendticks = 0;
							}

							if (ticks <= 16) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 5 || phases.size() == 7 || phases.size() == 12) {
							prayerconserve = true;
						} else if (phases.size() == 8) {
							if (ticks >= 18) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else if (phases.size() == 10) {
							if (ticks >= 14) {
								prayerconserve = true;
							} else {
								prayerconserve = false;
							}
						} else {
							prayerconserve = false;
						}
					}
				}
			}
		} else {
			if (zulrahstart > 0) {
				phases.clear();
				locations.clear();
				zulrahstart = 0;
				lastphase= 0;
				lastloc = null;
				phase = 0;
				phase1 = true;
				phase2 = true;
				phase3 = true;
				phase4 = true;
				nextzulrahtile = null;
				nztcolor = null;
				nexttile = null;
				currenttile = null;
				restart = false;
				ticks = 0;
				prayerconserve = false;
				not = 0;
				nextprayerendticks = 0;
				jadphase = 0;
				jadflip = false;
			}
		}
	}

	@Subscribe
    public void onAnimationChanged(AnimationChanged event) {
        Actor Zulrhyboy = event.getActor();
        if (Zulrhyboy != null && Zulrhyboy.getName() != null) {
            if (Zulrhyboy instanceof NPC) {
                if (Zulrhyboy.equals(Zulrah)) {
                    if (jadphase > 0) {
                        if (Zulrhyboy.getAnimation() == 5069) {
                            if (!jadflip) {
                                jadflip = true;
                            } else {
                                jadflip = false;
                            }
                        }
                    }
                }
            }
        }
    }


	public Color zulrahtype(int type) {
		switch(type) {
			case 2042:
				return Color.GREEN;
			case 2043:
				return Color.RED;
			case 2044:
				return Color.BLUE;
		}
		return null;
	}

	private void loadProtectionIcons() {
		final IndexedSprite[] protectionIcons = {};
		final IndexedSprite[] newProtectionIcons = Arrays.copyOf(protectionIcons, PROTECTION_ICONS.length);
		int curPosition = 0;

		for (int i = 0; i < PROTECTION_ICONS.length; i++, curPosition++)
		{
			final int resource = PROTECTION_ICONS[i];
			ProtectionIcons[i] = rgbaToIndexedBufferedImage(ProtectionIconFromSprite(spriteManager.getSprite(resource, 0)));
			newProtectionIcons[curPosition] = createIndexedSprite(client, ProtectionIcons[i]);
		}
	}

	private static IndexedSprite createIndexedSprite(final Client client, final BufferedImage bufferedImage) {
		final IndexColorModel indexedCM = (IndexColorModel) bufferedImage.getColorModel();

		final int width = bufferedImage.getWidth();
		final int height = bufferedImage.getHeight();
		final byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
		final int[] palette = new int[indexedCM.getMapSize()];
		indexedCM.getRGBs(palette);

		final IndexedSprite newIndexedSprite = client.createIndexedSprite();
		newIndexedSprite.setPixels(pixels);
		newIndexedSprite.setPalette(palette);
		newIndexedSprite.setWidth(width);
		newIndexedSprite.setHeight(height);
		newIndexedSprite.setOriginalWidth(width);
		newIndexedSprite.setOriginalHeight(height);
		newIndexedSprite.setOffsetX(0);
		newIndexedSprite.setOffsetY(0);
		return newIndexedSprite;
	}

	private static BufferedImage rgbaToIndexedBufferedImage(final BufferedImage sourceBufferedImage) {
		final BufferedImage indexedImage = new BufferedImage(
				sourceBufferedImage.getWidth(),
				sourceBufferedImage.getHeight(),
				BufferedImage.TYPE_BYTE_INDEXED);

		final ColorModel cm = indexedImage.getColorModel();
		final IndexColorModel icm = (IndexColorModel) cm;

		final int size = icm.getMapSize();
		final byte[] reds = new byte[size];
		final byte[] greens = new byte[size];
		final byte[] blues = new byte[size];
		icm.getReds(reds);
		icm.getGreens(greens);
		icm.getBlues(blues);

		final WritableRaster raster = indexedImage.getRaster();
		final int pixel = raster.getSample(0, 0, 0);
		final IndexColorModel resultIcm = new IndexColorModel(8, size, reds, greens, blues, pixel);
		final BufferedImage resultIndexedImage = new BufferedImage(resultIcm, raster, sourceBufferedImage.isAlphaPremultiplied(), null);
		resultIndexedImage.getGraphics().drawImage(sourceBufferedImage, 0, 0, null);
		return resultIndexedImage;
	}

	private static BufferedImage ProtectionIconFromSprite(final BufferedImage freezeSprite) {
		final BufferedImage freezeCanvas = ImageUtil.resizeCanvas(freezeSprite, PROTECTION_ICON_DIMENSION.width, PROTECTION_ICON_DIMENSION.height);
		return ImageUtil.outlineImage(freezeCanvas, PROTECTION_ICON_OUTLINE_COLOR);
	}

	BufferedImage getProtectionIcon() {
		int type = 0;
		if (phase1) {
			type = Phase1types.get(phases.size());
		} else if (phase2) {
			type = Phase2types.get(phases.size());
		} else if (phase3) {
			type = Phase3types.get(phases.size());
		} else if (phase4) {
			type = Phase4types.get(phases.size());
		} else {
			System.out.println("ERROR: COULD NOT IDENTIFY ZULRAH PHASE!");
		}

		if (type > 0) {
			switch (type) {
				case 2042:
					return ProtectionIcons[0];
				case 2043:
					return ProtectionIcons[1];
				case 2044:
					return ProtectionIcons[2];
			}
		}
		return null;
	}
}