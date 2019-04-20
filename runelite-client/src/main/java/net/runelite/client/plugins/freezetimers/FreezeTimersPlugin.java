package net.runelite.client.plugins.freezetimers;





import com.google.inject.Provides;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.ImageObserver;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.api.GameState;
import net.runelite.api.HeadIcon;
import net.runelite.api.IndexedSprite;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.freezetimers.Barrage;
import net.runelite.client.plugins.freezetimers.FreezeTimersConfig;
import net.runelite.client.plugins.freezetimers.FreezeTimersOverlay;
import net.runelite.client.plugins.freezetimers.FreezeTimersTileOverlay;
import net.runelite.client.plugins.freezetimers.Spell;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import org.slf4j.Logger;

@PluginDescriptor(
	name = "Freeze Timers",
	description = "PVP Freeze Timers",
	tags = {"PvP", "Freeze", "Timers"},
        type = "PVP"
)

public class FreezeTimersPlugin
extends Plugin {
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private FreezeTimersConfig config;
    @Inject
    private FreezeTimersOverlay FreezeTimersOverlay;
    @Inject
    private FreezeTimersTileOverlay FreezeTimersTileOverlay;
    @Inject
    private Client client;
    @Inject
    private SpriteManager spriteManager;
	
   	private static final int[] FREEZE_ICONS = {
			SpriteID.SPELL_BIND,
			SpriteID.SPELL_SNARE,
			SpriteID.SPELL_ENTANGLE,
			SpriteID.SPELL_ICE_RUSH,
			SpriteID.SPELL_ICE_BURST,
			SpriteID.SPELL_ICE_BLITZ,
			SpriteID.SPELL_ICE_BARRAGE,
			SpriteID.SPELL_BIND,
			SpriteID.SPELL_SNARE,
			SpriteID.SPELL_ENTANGLE,
			SpriteID.SPELL_TELE_BLOCK
	};
   private static final Dimension FREEZE_ICON_DIMENSION = new Dimension(25, 25);
    private static final Color FREEZE_ICON_OUTLINE_COLOR = new Color(33, 33, 33);
    private final BufferedImage[] FreezeIcons = new BufferedImage[FREEZE_ICONS.length];
    private final int SPLASH_ID = 85;
	Map<String, Long> tbedthings = new HashMap<>();
	Map<String, Integer> tbtypes = new HashMap<>();
    Map<String, Spell> testMap = new HashMap<String, Spell>();
    Map<String, Long> frozenthings = new HashMap<String, Long>();
    Map<String, WorldPoint> frozenthingpoints = new HashMap<String, WorldPoint>();
    Map<String, Integer> freezetype = new HashMap<String, Integer>();
    Map<Integer, Integer> magexp = new HashMap<Integer, Integer>();
    int lastxp;
    int ticks;
    int currticks;
    String currtarget;
    String spell;

    @Provides
    FreezeTimersConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(FreezeTimersConfig.class);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            this.loadFreezeIcons();
        }
    }

    @Override
    protected void startUp() throws Exception {
        this.overlayManager.add(this.FreezeTimersOverlay);
        this.overlayManager.add(this.FreezeTimersTileOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        this.overlayManager.remove(this.FreezeTimersOverlay);
        this.overlayManager.remove(this.FreezeTimersTileOverlay);
        this.frozenthings.clear();
        this.frozenthingpoints.clear();
		this.tbedthings.clear();
		this.tbtypes.clear();
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        if (event.getMenuTarget().contains("->")) {
            Pattern spattern = Pattern.compile(">(.+?)</col>");
            Pattern ppattern = Pattern.compile("> <col=ffffff>(.+?)<col=");
            Matcher smatch = spattern.matcher(event.getMenuTarget());
            Matcher pmatch = ppattern.matcher(event.getMenuTarget());
            smatch.find();
            pmatch.find();
            if (smatch.group(1) != null && pmatch.group(1) != null) {
                this.currticks = this.ticks;
                this.spell = smatch.group(1);
                this.currtarget = pmatch.group(1).replace("\u00a0", " ");
            }
        }
    }

    @Subscribe
    public void onExperienceChanged(ExperienceChanged event) {
        if (event.getSkill() == Skill.MAGIC) {
            int xp = this.client.getSkillExperience(Skill.MAGIC);
            int gains = xp - this.lastxp;
            this.lastxp = xp;
            if (!this.magexp.containsKey(this.ticks)) {
                this.magexp.clear();
                this.magexp.put(this.ticks, gains);
            }
        }
    }

    @Subscribe
    private void onAnimationChanged(AnimationChanged event) {
        Logger l = this.client.getLogger();
        Actor subject = event.getActor();
        Actor target = subject.getInteracting();
        if (subject.getAnimation() == 1979) {
            try {
                if (target.getGraphic() == 85 || target.getGraphic() != -1) {
                    return;
                }
                if (this.frozenthings.containsKey(target.getName())) {
                    return;
                }
                this.testMap.put(target.getName(), new Barrage(target, subject));
                this.freezetype.put(target.getName(), 7);
                this.frozenthings.put(target.getName(), System.currentTimeMillis());
                this.frozenthingpoints.put(target.getName(), target.getWorldLocation());
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        int xp = 0;
        boolean praymage = false;
        if (this.magexp.containsKey(this.ticks)) {
            xp = this.magexp.get(this.ticks);
        }
        if (xp > 0 && this.currtarget != null) {
            if (this.frozenthings.containsKey(this.currtarget)) {
                this.currtarget = null;
                return;
            }
            WorldPoint targetPosition = null;
            for (Player player : this.client.getPlayers()) {
                String playerName;
                if (player == null || !(playerName = player.getName()).equals(this.currtarget)) continue;
                if (player.getOverheadIcon() != null && player.getOverheadIcon().equals((Object)HeadIcon.MAGIC)) {
                    praymage = true;
                }
                targetPosition = player.getWorldLocation();
                break;
            }
            if (targetPosition != null) {
                if (this.spell.equals("Bind") && xp > 30) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    if (praymage) {
                        this.freezetype.put(this.currtarget, 8);
                    } else {
                        this.freezetype.put(this.currtarget, 1);
                    }
                } else if (this.spell.equals("Snare") && xp > 60) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    if (praymage) {
                        this.freezetype.put(this.currtarget, 9);
                    } else {
                        this.freezetype.put(this.currtarget, 2);
                    }
                } else if (this.spell.equals("Entangle") && xp >= 89) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    if (praymage) {
                        this.freezetype.put(this.currtarget, 10);
                    } else {
                        this.freezetype.put(this.currtarget, 3);
                    }
                } else if (this.spell.equals("Ice Rush") && xp > 34) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    this.freezetype.put(this.currtarget, 4);
                } else if (this.spell.equals("Ice Burst") && xp > 40) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    this.freezetype.put(this.currtarget, 5);
                } else if (this.spell.equals("Ice Blitz") && xp > 46) {
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    this.freezetype.put(this.currtarget, 6);
                } else if (this.spell.equals("Ice Barrage") && xp > 52) {
                    Barrage barrage = new Barrage(this.client.getLocalPlayer().getInteracting(), this.client.getLocalPlayer());
                    this.testMap.put(this.currtarget, barrage);
                    this.frozenthings.put(this.currtarget, System.currentTimeMillis());
                    this.frozenthingpoints.put(this.currtarget, targetPosition);
                    this.freezetype.put(this.currtarget, 7);
				} else if (spell.equals("Tele Block") && xp == 95) {
						if (config.TBTimer()) {
							if (praymage) {
								this.tbtypes.put(this.currtarget, 2);
							} else {
								this.tbtypes.put(this.currtarget, 1);
							}
							this.tbedthings.put(this.currtarget, System.currentTimeMillis());
							}
                }
            }
        }
        if (this.currtarget != null && this.ticks > this.currticks + 1) {
            Player local = this.client.getLocalPlayer();
            Actor interacting = local.getInteracting();
            if (interacting != null) {
                if (!interacting.getName().equals(this.currtarget)) {
                    this.currtarget = null;
                }
            } else {
                this.currtarget = null;
            }
        }
        ++this.ticks;
    }

    public long opponentfreezetime(String name) {
        if (this.frozenthings.containsKey(name)) {
            return this.frozenthings.get(name);
        }
        return 0L;
    }

    public WorldPoint playerpos(String name) {
        if (this.frozenthingpoints.containsKey(name)) {
            return this.frozenthingpoints.get(name);
        }
        return null;
    }

    public void updatePosition(String name, WorldPoint point) {
        if (this.frozenthingpoints.containsKey(name)) {
            this.frozenthingpoints.remove(name);
            this.frozenthingpoints.put(name, point);
        }
    }

    public int freezetype(String name) {
        if (this.freezetype.containsKey(name)) {
            return this.freezetype.get(name);
        }
        return 0;
    }
	public long istbed(String name) {
		if (this.tbedthings.containsKey(name)) {
			return this.tbedthings.get(name);
		}
		return 0;
	}
	public int tbtype(String name) {
		if (this.tbtypes.containsKey(name)) {
			return this.tbtypes.get(name);
		}
		return 0;
	}
    public void deleteopponent(String name) {
        if (this.frozenthings.containsKey(name)) {
            this.frozenthings.remove(name);
        }
        if (this.frozenthingpoints.containsKey(name)) {
            this.frozenthingpoints.remove(name);
        }
        if (this.freezetype.containsKey(name)) {
            this.freezetype.remove(name);
        }
    }
	public void deletetb(String name) {
		if (this.tbedthings.containsKey(name)) {
			this.tbedthings.remove(name);
		}
		if (this.tbtypes.containsKey(name)) {
			this.tbtypes.remove(name);
		}
	}
    private void loadFreezeIcons() {
        IndexedSprite[] freezeIcons = new IndexedSprite[]{};
        IndexedSprite[] newfreezeIcons = Arrays.copyOf(freezeIcons, FREEZE_ICONS.length);
        int curPosition = 0;
        int i = 0;
        while (i < FREEZE_ICONS.length) {
            int resource = FREEZE_ICONS[i];
            this.FreezeIcons[i] = FreezeTimersPlugin.rgbaToIndexedBufferedImage(FreezeTimersPlugin.FreezeIconFromSprite(this.spriteManager.getSprite(resource, 0)));
            newfreezeIcons[curPosition] = FreezeTimersPlugin.createIndexedSprite(this.client, this.FreezeIcons[i]);
            ++i;
            ++curPosition;
        }
    }

    private static IndexedSprite createIndexedSprite(Client client, BufferedImage bufferedImage) {
        IndexColorModel indexedCM = (IndexColorModel)bufferedImage.getColorModel();
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        byte[] pixels = ((DataBufferByte)bufferedImage.getRaster().getDataBuffer()).getData();
        int[] palette = new int[indexedCM.getMapSize()];
        indexedCM.getRGBs(palette);
        IndexedSprite newIndexedSprite = client.createIndexedSprite();
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

    private static BufferedImage rgbaToIndexedBufferedImage(BufferedImage sourceBufferedImage) {
        BufferedImage indexedImage = new BufferedImage(sourceBufferedImage.getWidth(), sourceBufferedImage.getHeight(), 13);
        ColorModel cm = indexedImage.getColorModel();
        IndexColorModel icm = (IndexColorModel)cm;
        int size = icm.getMapSize();
        byte[] reds = new byte[size];
        byte[] greens = new byte[size];
        byte[] blues = new byte[size];
        icm.getReds(reds);
        icm.getGreens(greens);
        icm.getBlues(blues);
        WritableRaster raster = indexedImage.getRaster();
        int pixel = raster.getSample(0, 0, 0);
        IndexColorModel resultIcm = new IndexColorModel(8, size, reds, greens, blues, pixel);
        BufferedImage resultIndexedImage = new BufferedImage(resultIcm, raster, sourceBufferedImage.isAlphaPremultiplied(), null);
        resultIndexedImage.getGraphics().drawImage(sourceBufferedImage, 0, 0, null);
        return resultIndexedImage;
    }

    private static BufferedImage FreezeIconFromSprite(BufferedImage freezeSprite) {
        BufferedImage freezeCanvas = ImageUtil.resizeCanvas(freezeSprite, FreezeTimersPlugin.FREEZE_ICON_DIMENSION.width, FreezeTimersPlugin.FREEZE_ICON_DIMENSION.height);
        return ImageUtil.outlineImage(freezeCanvas, FREEZE_ICON_OUTLINE_COLOR);
    }

    BufferedImage GetFreezeIcon(int id) {
        return this.FreezeIcons[id];
    }
}

