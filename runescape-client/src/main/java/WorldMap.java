import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("WorldMap")
public class WorldMap {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("fontNameVerdana11")
	static final FontName fontNameVerdana11;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("fontNameVerdana13")
	static final FontName fontNameVerdana13;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("fontNameVerdana15")
	static final FontName fontNameVerdana15;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WorldMap_archive")
	AbstractArchive WorldMap_archive;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WorldMap_geographyArchive")
	AbstractArchive WorldMap_geographyArchive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("WorldMap_groundArchive")
	AbstractArchive WorldMap_groundArchive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("font")
	Font font;
	@ObfuscatedName("n")
	@Export("fonts")
	HashMap fonts;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("w")
	@Export("details")
	HashMap details;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("mainMapArea")
	WorldMapArea mainMapArea;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("currentMapArea")
	WorldMapArea currentMapArea;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	WorldMapArea field3960;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	@Export("worldMapManager")
	WorldMapManager worldMapManager;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("cacheLoader")
	WorldMapArchiveLoader cacheLoader;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1749919679
	)
	@Export("centerTileX")
	int centerTileX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1342348205
	)
	@Export("centerTileY")
	int centerTileY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1704242359
	)
	@Export("worldMapTargetX")
	int worldMapTargetX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 492760155
	)
	@Export("worldMapTargetY")
	int worldMapTargetY;
	@ObfuscatedName("u")
	@Export("zoom")
	float zoom;
	@ObfuscatedName("ae")
	@Export("zoomTarget")
	float zoomTarget;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 945465343
	)
	@Export("worldMapDisplayWidth")
	int worldMapDisplayWidth;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1711866961
	)
	@Export("worldMapDisplayHeight")
	int worldMapDisplayHeight;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 1490885125
	)
	@Export("worldMapDisplayX")
	int worldMapDisplayX;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 203528323
	)
	@Export("worldMapDisplayY")
	int worldMapDisplayY;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -762865251
	)
	@Export("maxFlashCount")
	int maxFlashCount;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 770268231
	)
	@Export("cyclesPerFlash")
	int cyclesPerFlash;
	@ObfuscatedName("aa")
	@Export("perpetualFlash")
	boolean perpetualFlash;
	@ObfuscatedName("aq")
	@Export("flashingElements")
	HashSet flashingElements;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 674929495
	)
	@Export("flashCount")
	int flashCount;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -981605543
	)
	@Export("flashCycle")
	int flashCycle;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -240935151
	)
	int field3979;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 650254011
	)
	int field3982;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 757767451
	)
	int field3977;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1272678139
	)
	int field3951;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		longValue = 5380026643916633153L
	)
	long field3967;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 950213411
	)
	int field3984;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1648273559
	)
	int field3969;
	@ObfuscatedName("ao")
	boolean field3986;
	@ObfuscatedName("ag")
	@Export("enabledElements")
	HashSet enabledElements;
	@ObfuscatedName("ai")
	@Export("enabledCategories")
	HashSet enabledCategories;
	@ObfuscatedName("ab")
	@Export("enabledElementIds")
	HashSet enabledElementIds;
	@ObfuscatedName("ap")
	HashSet field3991;
	@ObfuscatedName("ah")
	@Export("elementsDisabled")
	boolean elementsDisabled;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -1735294353
	)
	int field3981;
	@ObfuscatedName("bc")
	@Export("menuOpcodes")
	final int[] menuOpcodes;
	@ObfuscatedName("bk")
	List field3995;
	@ObfuscatedName("bb")
	@Export("iconIterator")
	Iterator iconIterator;
	@ObfuscatedName("bi")
	HashSet field3997;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("mouseCoord")
	Coord mouseCoord;
	@ObfuscatedName("bl")
	@Export("showCoord")
	public boolean showCoord;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("sprite")
	Sprite sprite;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = -1384358413
	)
	@Export("cachedPixelsPerTile")
	int cachedPixelsPerTile;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1781840663
	)
	@Export("minCachedTileX")
	int minCachedTileX;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -1423775659
	)
	@Export("minCachedTileY")
	int minCachedTileY;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1004367461
	)
	int field3959;

	static {
		fontNameVerdana11 = FontName.FontName_verdana11;
		fontNameVerdana13 = FontName.FontName_verdana13;
		fontNameVerdana15 = FontName.FontName_verdana15;
	}

	public WorldMap() {
		this.worldMapTargetX = -1;
		this.worldMapTargetY = -1;
		this.worldMapDisplayWidth = -1;
		this.worldMapDisplayHeight = -1;
		this.worldMapDisplayX = -1;
		this.worldMapDisplayY = -1;
		this.maxFlashCount = 3;
		this.cyclesPerFlash = 50;
		this.perpetualFlash = false;
		this.flashingElements = null;
		this.flashCount = -1;
		this.flashCycle = -1;
		this.field3979 = -1;
		this.field3982 = -1;
		this.field3977 = -1;
		this.field3951 = -1;
		this.field3986 = true;
		this.enabledElements = new HashSet();
		this.enabledCategories = new HashSet();
		this.enabledElementIds = new HashSet();
		this.field3991 = new HashSet();
		this.elementsDisabled = false;
		this.field3981 = 0;
		this.menuOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field3997 = new HashSet();
		this.mouseCoord = null;
		this.showCoord = false;
		this.minCachedTileX = -1;
		this.minCachedTileY = -1;
		this.field3959 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;Lii;Lko;Ljava/util/HashMap;[Lli;B)V",
		garbageValue = "50"
	)
	@Export("init")
	public void init(AbstractArchive var1, AbstractArchive var2, AbstractArchive var3, Font var4, HashMap var5, IndexedSprite[] var6) {
		this.mapSceneSprites = var6;
		this.WorldMap_archive = var1;
		this.WorldMap_geographyArchive = var2;
		this.WorldMap_groundArchive = var3;
		this.font = var4;
		this.fonts = new HashMap();
		this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_small, var5.get(fontNameVerdana11));
		this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_medium, var5.get(fontNameVerdana13));
		this.fonts.put(WorldMapLabelSize.WorldMapLabelSize_large, var5.get(fontNameVerdana15));
		this.cacheLoader = new WorldMapArchiveLoader(var1);
		int var7 = this.WorldMap_archive.getGroupId(WorldMapCacheName.field313.name);
		int[] var8 = this.WorldMap_archive.getGroupFileIds(var7);
		this.details = new HashMap(var8.length);

		for (int var9 = 0; var9 < var8.length; ++var9) {
			Buffer var10 = new Buffer(this.WorldMap_archive.takeFile(var7, var8[var9]));
			WorldMapArea var11 = new WorldMapArea();
			var11.read(var10, var8[var9]);
			this.details.put(var11.getInternalName(), var11);
			if (var11.getIsMain()) {
				this.mainMapArea = var11;
			}
		}

		this.setCurrentMapArea(this.mainMapArea);
		this.field3960 = null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-449283348"
	)
	public void method6499() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIZIIIIB)V",
		garbageValue = "-1"
	)
	@Export("onCycle")
	public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.cacheLoader.isLoaded()) {
			this.smoothZoom();
			this.scrollToTarget();
			if (var3) {
				int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
				int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
				List var10 = this.worldMapManager.method643(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				AbstractWorldMapIcon var13;
				ScriptEvent var14;
				WorldMapEvent var15;
				for (var12 = var10.iterator(); var12.hasNext(); class4.runScriptEvent(var14)) {
					var13 = (AbstractWorldMapIcon)var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
					var14.setArgs(new Object[]{var15, var1, var2});
					if (this.field3997.contains(var13)) {
						var14.setType(17);
					} else {
						var14.setType(15);
					}
				}

				var12 = this.field3997.iterator();

				while (var12.hasNext()) {
					var13 = (AbstractWorldMapIcon)var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
						var14.setArgs(new Object[]{var15, var1, var2});
						var14.setType(16);
						class4.runScriptEvent(var14);
					}
				}

				this.field3997 = var11;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIZZB)V",
		garbageValue = "3"
	)
	public void method6363(int var1, int var2, boolean var3, boolean var4) {
		long var5 = WorldMapIcon_0.currentTimeMillis();
		this.method6454(var1, var2, var4, var5);
		if (!this.hasTarget() && (var4 || var3)) {
			if (var4) {
				this.field3977 = var1;
				this.field3951 = var2;
				this.field3979 = this.centerTileX;
				this.field3982 = this.centerTileY;
			}

			if (this.field3979 != -1) {
				int var7 = var1 - this.field3977;
				int var8 = var2 - this.field3951;
				this.setWorldMapPosition(this.field3979 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field3982, false);
			}
		} else {
			this.method6368();
		}

		if (var4) {
			this.field3967 = var5;
			this.field3984 = var1;
			this.field3969 = var2;
		}

	}

	@ObfuscatedName("i")
	void method6454(int var1, int var2, boolean var3, long var4) {
		if (this.currentMapArea != null) {
			int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.getDisplayWith() * this.zoom / 2.0F) / this.zoom);
			int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.getDisplayHeight() * this.zoom / 2.0F) / this.zoom);
			this.mouseCoord = this.currentMapArea.coord(var6 + this.currentMapArea.getRegionLowX() * 64, var7 + this.currentMapArea.getRegionLowY() * 64);
			if (this.mouseCoord != null && var3) {
				if (FloorOverlayDefinition.method4835() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
					WorldMapRegion.method563(this.mouseCoord.x, this.mouseCoord.y, this.mouseCoord.plane, false);
				} else {
					boolean var8 = true;
					if (this.field3986) {
						int var9 = var1 - this.field3984;
						int var10 = var2 - this.field3969;
						if (var4 - this.field3967 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
							var8 = false;
						}
					}

					if (var8) {
						PacketBufferNode var11 = TilePaint.getPacketBufferNode(ClientPacket.field2278, Client.packetWriter.isaacCipher);
						var11.packetBuffer.writeInt(this.mouseCoord.packed());
						Client.packetWriter.addNode(var11);
						this.field3967 = 0L;
					}
				}
			}
		} else {
			this.mouseCoord = null;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2064415632"
	)
	@Export("smoothZoom")
	void smoothZoom() {
		if (class218.field2716 != null) {
			this.zoom = this.zoomTarget;
		} else {
			if (this.zoom < this.zoomTarget) {
				this.zoom = Math.min(this.zoomTarget, this.zoom + this.zoom / 30.0F);
			}

			if (this.zoom > this.zoomTarget) {
				this.zoom = Math.max(this.zoomTarget, this.zoom - this.zoom / 30.0F);
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	@Export("scrollToTarget")
	void scrollToTarget() {
		if (this.hasTarget()) {
			int var1 = this.worldMapTargetX - this.centerTileX;
			int var2 = this.worldMapTargetY - this.centerTileY;
			if (var1 != 0) {
				var1 /= Math.min(8, Math.abs(var1));
			}

			if (var2 != 0) {
				var2 /= Math.min(8, Math.abs(var2));
			}

			this.setWorldMapPosition(var1 + this.centerTileX, var2 + this.centerTileY, true);
			if (this.centerTileX == this.worldMapTargetX && this.centerTileY == this.worldMapTargetY) {
				this.worldMapTargetX = -1;
				this.worldMapTargetY = -1;
			}

		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-1067746846"
	)
	@Export("setWorldMapPosition")
	final void setWorldMapPosition(int var1, int var2, boolean var3) {
		this.centerTileX = var1;
		this.centerTileY = var2;
		WorldMapIcon_0.currentTimeMillis();
		if (var3) {
			this.method6368();
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1954951497"
	)
	final void method6368() {
		this.field3951 = -1;
		this.field3977 = -1;
		this.field3982 = -1;
		this.field3979 = -1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "53671809"
	)
	@Export("hasTarget")
	boolean hasTarget() {
		return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIII)Lae;",
		garbageValue = "1541741189"
	)
	@Export("mapAreaAtCoord")
	public WorldMapArea mapAreaAtCoord(int var1, int var2, int var3) {
		Iterator var4 = this.details.values().iterator();

		WorldMapArea var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapArea)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return var5;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "508840243"
	)
	public void method6371(int var1, int var2, int var3, boolean var4) {
		WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.mainMapArea;
		}

		boolean var6 = false;
		if (var5 != this.field3960 || var4) {
			this.field3960 = var5;
			this.setCurrentMapArea(var5);
			var6 = true;
		}

		if (var6 || var4) {
			this.jump(var1, var2, var3);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1319547815"
	)
	@Export("setCurrentMapAreaId")
	public void setCurrentMapAreaId(int var1) {
		WorldMapArea var2 = this.getMapArea(var1);
		if (var2 != null) {
			this.setCurrentMapArea(var2);
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-125"
	)
	@Export("currentMapAreaId")
	public int currentMapAreaId() {
		return this.currentMapArea == null ? -1 : this.currentMapArea.getId();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lae;",
		garbageValue = "255797154"
	)
	@Export("getCurrentMapArea")
	public WorldMapArea getCurrentMapArea() {
		return this.currentMapArea;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "808158376"
	)
	@Export("setCurrentMapArea")
	void setCurrentMapArea(WorldMapArea var1) {
		if (this.currentMapArea == null || var1 != this.currentMapArea) {
			this.initializeWorldMapManager(var1);
			this.jump(-1, -1, -1);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1342819699"
	)
	@Export("initializeWorldMapManager")
	void initializeWorldMapManager(WorldMapArea var1) {
		this.currentMapArea = var1;
		this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
		this.cacheLoader.reset(this.currentMapArea.getInternalName());
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lae;Lhj;Lhj;ZS)V",
		garbageValue = "256"
	)
	public void method6377(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
		if (var1 != null) {
			if (this.currentMapArea == null || var1 != this.currentMapArea) {
				this.initializeWorldMapManager(var1);
			}

			if (!var4 && this.currentMapArea.containsCoord(var2.plane, var2.x, var2.y)) {
				this.jump(var2.plane, var2.x, var2.y);
			} else {
				this.jump(var3.plane, var3.x, var3.y);
			}

		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "17"
	)
	@Export("jump")
	void jump(int var1, int var2, int var3) {
		if (this.currentMapArea != null) {
			int[] var4 = this.currentMapArea.position(var1, var2, var3);
			if (var4 == null) {
				var4 = this.currentMapArea.position(this.currentMapArea.getOriginPlane(), this.currentMapArea.getOriginX(), this.currentMapArea.getOriginY());
			}

			this.setWorldMapPosition(var4[0] - this.currentMapArea.getRegionLowX() * 64, var4[1] - this.currentMapArea.getRegionLowY() * 64, true);
			this.worldMapTargetX = -1;
			this.worldMapTargetY = -1;
			this.zoom = this.getZoomFromPercentage(this.currentMapArea.getZoom());
			this.zoomTarget = this.zoom;
			this.field3995 = null;
			this.iconIterator = null;
			this.worldMapManager.clearIcons();
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-1497062922"
	)
	@Export("draw")
	public void draw(int var1, int var2, int var3, int var4, int var5) {
		int[] var6 = new int[4];
		Rasterizer2D.Rasterizer2D_getClipArray(var6);
		Rasterizer2D.Rasterizer2D_setClip(var1, var2, var3 + var1, var2 + var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
		int var7 = this.cacheLoader.getPercentLoaded();
		if (var7 < 100) {
			this.drawLoading(var1, var2, var3, var4, var7);
		} else {
			if (!this.worldMapManager.isLoaded()) {
				this.worldMapManager.load(this.WorldMap_archive, this.currentMapArea.getInternalName(), Client.isMembersWorld);
				if (!this.worldMapManager.isLoaded()) {
					return;
				}
			}

			if (this.flashingElements != null) {
				++this.flashCycle;
				if (this.flashCycle % this.cyclesPerFlash == 0) {
					this.flashCycle = 0;
					++this.flashCount;
				}

				if (this.flashCount >= this.maxFlashCount && !this.perpetualFlash) {
					this.flashingElements = null;
				}
			}

			int var8 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var9 = (int)Math.ceil((double)((float)var4 / this.zoom));
			this.worldMapManager.drawTiles(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4);
			if (!this.elementsDisabled) {
				boolean var10 = false;
				if (var5 - this.field3981 > 100) {
					this.field3981 = var5;
					var10 = true;
				}

				this.worldMapManager.drawElements(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3991, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
			}

			this.method6381(var1, var2, var3, var4, var8, var9);
			if (FloorOverlayDefinition.method4835() && this.showCoord && this.mouseCoord != null) {
				this.font.draw("Coord: " + this.mouseCoord, Rasterizer2D.Rasterizer2D_xClipStart + 10, Rasterizer2D.Rasterizer2D_yClipStart + 20, 16776960, -1);
			}

			this.worldMapDisplayWidth = var8;
			this.worldMapDisplayHeight = var9;
			this.worldMapDisplayX = var1;
			this.worldMapDisplayY = var2;
			Rasterizer2D.Rasterizer2D_setClipArray(var6);
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIIIIII)Z",
		garbageValue = "1871269432"
	)
	boolean method6380(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.sprite == null) {
			return true;
		} else if (this.sprite.subWidth == var1 && this.sprite.subHeight == var2) {
			if (this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile) {
				return true;
			} else if (this.field3959 != Client.field888) {
				return true;
			} else if (var3 <= 0 && var4 <= 0) {
				return var3 + var1 < var5 || var2 + var4 < var6;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-1868764564"
	)
	void method6381(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (class218.field2716 != null) {
			int var7 = 512 / (this.worldMapManager.pixelsPerTile * 2);
			int var8 = var3 + 512;
			int var9 = var4 + 512;
			float var10 = 1.0F;
			var8 = (int)((float)var8 / var10);
			var9 = (int)((float)var9 / var10);
			int var11 = this.getDisplayX() - var5 / 2 - var7;
			int var12 = this.getDisplayY() - var6 / 2 - var7;
			int var13 = var1 - (var7 + var11 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
			int var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			if (this.method6380(var8, var9, var13, var14, var3, var4)) {
				if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
					Arrays.fill(this.sprite.pixels, 0);
				} else {
					this.sprite = new Sprite(var8, var9);
				}

				this.minCachedTileX = this.getDisplayX() - var5 / 2 - var7;
				this.minCachedTileY = this.getDisplayY() - var6 / 2 - var7;
				this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
				class218.field2716.method4404(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
				this.field3959 = Client.field888;
				var13 = var1 - (var7 + var11 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
				var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			}

			Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
			if (1.0F == var10) {
				this.sprite.method6201(var13, var14, 192);
			} else {
				this.sprite.method6280(var13, var14, (int)(var10 * (float)var8), (int)(var10 * (float)var9), 192);
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "864377578"
	)
	@Export("drawOverview")
	public void drawOverview(int var1, int var2, int var3, int var4) {
		if (this.cacheLoader.isLoaded()) {
			if (!this.worldMapManager.isLoaded()) {
				this.worldMapManager.load(this.WorldMap_archive, this.currentMapArea.getInternalName(), Client.isMembersWorld);
				if (!this.worldMapManager.isLoaded()) {
					return;
				}
			}

			this.worldMapManager.drawOverview(var1, var2, var3, var4, this.flashingElements, this.flashCycle, this.cyclesPerFlash);
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "23"
	)
	@Export("setZoomPercentage")
	public void setZoomPercentage(int var1) {
		this.zoomTarget = this.getZoomFromPercentage(var1);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-1694224866"
	)
	@Export("drawLoading")
	void drawLoading(int var1, int var2, int var3, int var4, int var5) {
		byte var6 = 20;
		int var7 = var3 / 2 + var1;
		int var8 = var4 / 2 + var2 - 18 - var6;
		Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
		Rasterizer2D.Rasterizer2D_drawRectangle(var7 - 152, var8, 304, 34, -65536);
		Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
		this.font.drawCentered("Loading...", var7, var8 + var6, -1, -1);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(IB)F",
		garbageValue = "-6"
	)
	@Export("getZoomFromPercentage")
	float getZoomFromPercentage(int var1) {
		if (var1 == 25) {
			return 1.0F;
		} else if (var1 == 37) {
			return 1.5F;
		} else if (var1 == 50) {
			return 2.0F;
		} else if (var1 == 75) {
			return 3.0F;
		} else {
			return var1 == 100 ? 4.0F : 8.0F;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1982956144"
	)
	@Export("getZoomLevel")
	public int getZoomLevel() {
		if (1.0D == (double)this.zoomTarget) {
			return 25;
		} else if ((double)this.zoomTarget == 1.5D) {
			return 37;
		} else if (2.0D == (double)this.zoomTarget) {
			return 50;
		} else if ((double)this.zoomTarget == 3.0D) {
			return 75;
		} else {
			return 4.0D == (double)this.zoomTarget ? 100 : 200;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-15"
	)
	@Export("loadCache")
	public void loadCache() {
		this.cacheLoader.load();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "62"
	)
	@Export("isCacheLoaded")
	public boolean isCacheLoaded() {
		return this.cacheLoader.isLoaded();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(II)Lae;",
		garbageValue = "-583090673"
	)
	@Export("getMapArea")
	public WorldMapArea getMapArea(int var1) {
		Iterator var2 = this.details.values().iterator();

		WorldMapArea var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (WorldMapArea)var2.next();
		} while(var3.getId() != var1);

		return var3;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1378378704"
	)
	@Export("setWorldMapPositionTarget")
	public void setWorldMapPositionTarget(int var1, int var2) {
		if (this.currentMapArea != null && this.currentMapArea.containsPosition(var1, var2)) {
			this.worldMapTargetX = var1 - this.currentMapArea.getRegionLowX() * 64;
			this.worldMapTargetY = var2 - this.currentMapArea.getRegionLowY() * 64;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1855899067"
	)
	@Export("setWorldMapPositionTargetInstant")
	public void setWorldMapPositionTargetInstant(int var1, int var2) {
		if (this.currentMapArea != null) {
			this.setWorldMapPosition(var1 - this.currentMapArea.getRegionLowX() * 64, var2 - this.currentMapArea.getRegionLowY() * 64, true);
			this.worldMapTargetX = -1;
			this.worldMapTargetY = -1;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "100238164"
	)
	@Export("jumpToSourceCoord")
	public void jumpToSourceCoord(int var1, int var2, int var3) {
		if (this.currentMapArea != null) {
			int[] var4 = this.currentMapArea.position(var1, var2, var3);
			if (var4 != null) {
				this.setWorldMapPositionTarget(var4[0], var4[1]);
			}

		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-50"
	)
	@Export("jumpToSourceCoordInstant")
	public void jumpToSourceCoordInstant(int var1, int var2, int var3) {
		if (this.currentMapArea != null) {
			int[] var4 = this.currentMapArea.position(var1, var2, var3);
			if (var4 != null) {
				this.setWorldMapPositionTargetInstant(var4[0], var4[1]);
			}

		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "429030075"
	)
	@Export("getDisplayX")
	public int getDisplayX() {
		return this.currentMapArea == null ? -1 : this.centerTileX + this.currentMapArea.getRegionLowX() * 64;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1683387381"
	)
	@Export("getDisplayY")
	public int getDisplayY() {
		return this.currentMapArea == null ? -1 : this.centerTileY + this.currentMapArea.getRegionLowY() * 64;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)Lhj;",
		garbageValue = "663930185"
	)
	@Export("getDisplayCoord")
	public Coord getDisplayCoord() {
		return this.currentMapArea == null ? null : this.currentMapArea.coord(this.getDisplayX(), this.getDisplayY());
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-261888637"
	)
	@Export("getDisplayWith")
	public int getDisplayWith() {
		return this.worldMapDisplayWidth;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "73"
	)
	@Export("getDisplayHeight")
	public int getDisplayHeight() {
		return this.worldMapDisplayHeight;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "24"
	)
	@Export("setMaxFlashCount")
	public void setMaxFlashCount(int var1) {
		if (var1 >= 1) {
			this.maxFlashCount = var1;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "80342748"
	)
	@Export("resetMaxFlashCount")
	public void resetMaxFlashCount() {
		this.maxFlashCount = 3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "30"
	)
	@Export("setCyclesPerFlash")
	public void setCyclesPerFlash(int var1) {
		if (var1 >= 1) {
			this.cyclesPerFlash = var1;
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1876711649"
	)
	@Export("resetCyclesPerFlash")
	public void resetCyclesPerFlash() {
		this.cyclesPerFlash = 50;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-15"
	)
	@Export("setPerpetualFlash")
	public void setPerpetualFlash(boolean var1) {
		this.perpetualFlash = var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1016061625"
	)
	@Export("flashElement")
	public void flashElement(int var1) {
		this.flashingElements = new HashSet();
		this.flashingElements.add(var1);
		this.flashCount = 0;
		this.flashCycle = 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1555254761"
	)
	@Export("flashCategory")
	public void flashCategory(int var1) {
		this.flashingElements = new HashSet();
		this.flashCount = 0;
		this.flashCycle = 0;

		for (int var2 = 0; var2 < class218.WorldMapElement_count; ++var2) {
			if (PacketBufferNode.WorldMapElement_get(var2) != null && PacketBufferNode.WorldMapElement_get(var2).category == var1) {
				this.flashingElements.add(PacketBufferNode.WorldMapElement_get(var2).objectId);
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1842650742"
	)
	@Export("stopCurrentFlashes")
	public void stopCurrentFlashes() {
		this.flashingElements = null;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-18"
	)
	@Export("setElementsDisabled")
	public void setElementsDisabled(boolean var1) {
		this.elementsDisabled = !var1;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-486377130"
	)
	@Export("disableElement")
	public void disableElement(int var1, boolean var2) {
		if (!var2) {
			this.enabledElements.add(var1);
		} else {
			this.enabledElements.remove(var1);
		}

		this.method6413();
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-2134751202"
	)
	@Export("setCategoryDisabled")
	public void setCategoryDisabled(int var1, boolean var2) {
		if (!var2) {
			this.enabledCategories.add(var1);
		} else {
			this.enabledCategories.remove(var1);
		}

		for (int var3 = 0; var3 < class218.WorldMapElement_count; ++var3) {
			if (PacketBufferNode.WorldMapElement_get(var3) != null && PacketBufferNode.WorldMapElement_get(var3).category == var1) {
				int var4 = PacketBufferNode.WorldMapElement_get(var3).objectId;
				if (!var2) {
					this.enabledElementIds.add(var4);
				} else {
					this.enabledElementIds.remove(var4);
				}
			}
		}

		this.method6413();
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-85"
	)
	@Export("getElementsDisabled")
	public boolean getElementsDisabled() {
		return !this.elementsDisabled;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1527323517"
	)
	@Export("isElementDisabled")
	public boolean isElementDisabled(int var1) {
		return !this.enabledElements.contains(var1);
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "73"
	)
	@Export("isCategoryDisabled")
	public boolean isCategoryDisabled(int var1) {
		return !this.enabledCategories.contains(var1);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "118"
	)
	void method6413() {
		this.field3991.clear();
		this.field3991.addAll(this.enabledElements);
		this.field3991.addAll(this.enabledElementIds);
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-1183696122"
	)
	@Export("addElementMenuOptions")
	public void addElementMenuOptions(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.cacheLoader.isLoaded()) {
			int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
			List var9 = this.worldMapManager.method643(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
					WorldMapElement var12 = PacketBufferNode.WorldMapElement_get(var11.getElement());
					var13 = false;

					for (int var14 = this.menuOpcodes.length - 1; var14 >= 0; --var14) {
						if (var12.menuActions[var14] != null) {
							GraphicsObject.insertMenuItemNoShift(var12.menuActions[var14], var12.menuTargetName, this.menuOpcodes[var14], var11.getElement(), var11.coord1.packed(), var11.coord2.packed());
							var13 = true;
						}
					}
				} while(!var13);

			}
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(ILhj;B)Lhj;",
		garbageValue = "-33"
	)
	public Coord method6411(int var1, Coord var2) {
		if (!this.cacheLoader.isLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else if (!this.currentMapArea.containsPosition(var2.x, var2.y)) {
			return null;
		} else {
			HashMap var3 = this.worldMapManager.buildIcons();
			List var4 = (List)var3.get(var1);
			if (var4 != null && !var4.isEmpty()) {
				AbstractWorldMapIcon var5 = null;
				int var6 = -1;
				Iterator var7 = var4.iterator();

				while (true) {
					AbstractWorldMapIcon var8;
					int var11;
					do {
						if (!var7.hasNext()) {
							return var5.coord2;
						}

						var8 = (AbstractWorldMapIcon)var7.next();
						int var9 = var8.coord2.x - var2.x;
						int var10 = var8.coord2.y - var2.y;
						var11 = var9 * var9 + var10 * var10;
						if (var11 == 0) {
							return var8.coord2;
						}
					} while(var11 >= var6 && var5 != null);

					var5 = var8;
					var6 = var11;
				}
			} else {
				return null;
			}
		}
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(IILhj;Lhj;B)V",
		garbageValue = "-47"
	)
	@Export("worldMapMenuAction")
	public void worldMapMenuAction(int var1, int var2, Coord var3, Coord var4) {
		ScriptEvent var5 = new ScriptEvent();
		WorldMapEvent var6 = new WorldMapEvent(var2, var3, var4);
		var5.setArgs(new Object[]{var6});
		switch(var1) {
		case 1008:
			var5.setType(10);
			break;
		case 1009:
			var5.setType(11);
			break;
		case 1010:
			var5.setType(12);
			break;
		case 1011:
			var5.setType(13);
			break;
		case 1012:
			var5.setType(14);
		}

		class4.runScriptEvent(var5);
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "(I)Laq;",
		garbageValue = "-2025058751"
	)
	@Export("iconStart")
	public AbstractWorldMapIcon iconStart() {
		if (!this.cacheLoader.isLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else {
			HashMap var1 = this.worldMapManager.buildIcons();
			this.field3995 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List)var2.next();
				this.field3995.addAll(var3);
			}

			this.iconIterator = this.field3995.iterator();
			return this.iconNext();
		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(I)Laq;",
		garbageValue = "483386340"
	)
	@Export("iconNext")
	public AbstractWorldMapIcon iconNext() {
		if (this.iconIterator == null) {
			return null;
		} else {
			AbstractWorldMapIcon var1;
			do {
				if (!this.iconIterator.hasNext()) {
					return null;
				}

				var1 = (AbstractWorldMapIcon)this.iconIterator.next();
			} while(var1.getElement() == -1);

			return var1;
		}
	}
}
