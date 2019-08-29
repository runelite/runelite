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

@ObfuscatedName("lv")
@Implements("WorldMap")
public class WorldMap {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("fontNameVerdana11")
	static final FontName fontNameVerdana11;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("fontNameVerdana13")
	static final FontName fontNameVerdana13;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("fontNameVerdana15")
	static final FontName fontNameVerdana15;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_archive")
	AbstractArchive WorldMap_archive;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_geographyArchive")
	AbstractArchive WorldMap_geographyArchive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_groundArchive")
	AbstractArchive WorldMap_groundArchive;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("font")
	Font font;
	@ObfuscatedName("y")
	@Export("fonts")
	HashMap fonts;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("b")
	@Export("details")
	HashMap details;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lav;"
	)
	@Export("mainMapArea")
	WorldMapArea mainMapArea;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lav;"
	)
	@Export("currentMapArea")
	WorldMapArea currentMapArea;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lav;"
	)
	WorldMapArea field3948;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("worldMapManager")
	WorldMapManager worldMapManager;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("cacheLoader")
	WorldMapArchiveLoader cacheLoader;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1709631313
	)
	@Export("centerTileX")
	int centerTileX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -148565401
	)
	@Export("centerTileY")
	int centerTileY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1426592379
	)
	@Export("worldMapTargetX")
	int worldMapTargetX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -131532783
	)
	@Export("worldMapTargetY")
	int worldMapTargetY;
	@ObfuscatedName("o")
	@Export("zoom")
	float zoom;
	@ObfuscatedName("av")
	@Export("zoomTarget")
	float zoomTarget;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -940091853
	)
	@Export("worldMapDisplayWidth")
	int worldMapDisplayWidth;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -99260469
	)
	@Export("worldMapDisplayHeight")
	int worldMapDisplayHeight;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -137724383
	)
	@Export("worldMapDisplayX")
	int worldMapDisplayX;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -128088417
	)
	@Export("worldMapDisplayY")
	int worldMapDisplayY;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -226377957
	)
	@Export("maxFlashCount")
	int maxFlashCount;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1119044333
	)
	@Export("cyclesPerFlash")
	int cyclesPerFlash;
	@ObfuscatedName("at")
	@Export("perpetualFlash")
	boolean perpetualFlash;
	@ObfuscatedName("as")
	@Export("flashingElements")
	HashSet flashingElements;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1909795063
	)
	@Export("flashCount")
	int flashCount;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 277662661
	)
	@Export("flashCycle")
	int flashCycle;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 982159619
	)
	int field3947;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1274299191
	)
	int field3970;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -271346277
	)
	int field3984;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -1131249789
	)
	int field3985;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		longValue = 2241719861447572733L
	)
	long field3986;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -2045594623
	)
	int field3987;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1831517127
	)
	int field3988;
	@ObfuscatedName("aq")
	boolean field3989;
	@ObfuscatedName("al")
	@Export("enabledElements")
	HashSet enabledElements;
	@ObfuscatedName("ah")
	@Export("enabledCategories")
	HashSet enabledCategories;
	@ObfuscatedName("ab")
	@Export("enabledElementIds")
	HashSet enabledElementIds;
	@ObfuscatedName("aw")
	HashSet field3993;
	@ObfuscatedName("ae")
	@Export("elementsDisabled")
	boolean elementsDisabled;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 6416933
	)
	int field3995;
	@ObfuscatedName("bo")
	@Export("menuOpcodes")
	final int[] menuOpcodes;
	@ObfuscatedName("bn")
	List field3980;
	@ObfuscatedName("bp")
	@Export("iconIterator")
	Iterator iconIterator;
	@ObfuscatedName("bz")
	HashSet field4001;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("mouseCoord")
	Coord mouseCoord;
	@ObfuscatedName("bv")
	@Export("showCoord")
	public boolean showCoord;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("sprite")
	Sprite sprite;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -1765997917
	)
	@Export("cachedPixelsPerTile")
	int cachedPixelsPerTile;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 366025991
	)
	@Export("minCachedTileX")
	int minCachedTileX;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 1657101787
	)
	@Export("minCachedTileY")
	int minCachedTileY;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 1737203703
	)
	int field4006;

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
		this.field3947 = -1;
		this.field3970 = -1;
		this.field3984 = -1;
		this.field3985 = -1;
		this.field3989 = true;
		this.enabledElements = new HashSet();
		this.enabledCategories = new HashSet();
		this.enabledElementIds = new HashSet();
		this.field3993 = new HashSet();
		this.elementsDisabled = false;
		this.field3995 = 0;
		this.menuOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field4001 = new HashSet();
		this.mouseCoord = null;
		this.showCoord = false;
		this.minCachedTileX = -1;
		this.minCachedTileY = -1;
		this.field4006 = -1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lkb;Ljava/util/HashMap;[Llq;I)V",
		garbageValue = "-1501971523"
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
		int var7 = this.WorldMap_archive.getGroupId(WorldMapCacheName.field295.name);
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
		this.field3948 = null;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1074851156"
	)
	public void method6187() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIZIIIIB)V",
		garbageValue = "21"
	)
	@Export("onCycle")
	public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.cacheLoader.isLoaded()) {
			this.smoothZoom();
			this.scrollToTarget();
			if (var3) {
				int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
				int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
				List var10 = this.worldMapManager.method629(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				AbstractWorldMapIcon var13;
				ScriptEvent var14;
				WorldMapEvent var15;
				for (var12 = var10.iterator(); var12.hasNext(); class81.runScriptEvent(var14)) {
					var13 = (AbstractWorldMapIcon)var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
					var14.setArgs(new Object[]{var15, var1, var2});
					if (this.field4001.contains(var13)) {
						var14.setType(17);
					} else {
						var14.setType(15);
					}
				}

				var12 = this.field4001.iterator();

				while (var12.hasNext()) {
					var13 = (AbstractWorldMapIcon)var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
						var14.setArgs(new Object[]{var15, var1, var2});
						var14.setType(16);
						class81.runScriptEvent(var14);
					}
				}

				this.field4001 = var11;
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIZZI)V",
		garbageValue = "929867253"
	)
	public void method6185(int var1, int var2, boolean var3, boolean var4) {
		long var5 = SequenceDefinition.method4686();
		this.method6186(var1, var2, var4, var5);
		if (!this.hasTarget() && (var4 || var3)) {
			if (var4) {
				this.field3984 = var1;
				this.field3985 = var2;
				this.field3947 = this.centerTileX;
				this.field3970 = this.centerTileY;
			}

			if (this.field3947 != -1) {
				int var7 = var1 - this.field3984;
				int var8 = var2 - this.field3985;
				this.setWorldMapPosition(this.field3947 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field3970, false);
			}
		} else {
			this.method6330();
		}

		if (var4) {
			this.field3986 = var5;
			this.field3987 = var1;
			this.field3988 = var2;
		}

	}

	@ObfuscatedName("u")
	void method6186(int var1, int var2, boolean var3, long var4) {
		if (this.currentMapArea != null) {
			int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.getDisplayWith() * this.zoom / 2.0F) / this.zoom);
			int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.getDisplayHeight() * this.zoom / 2.0F) / this.zoom);
			this.mouseCoord = this.currentMapArea.coord(var6 + this.currentMapArea.getRegionLowX() * 64, var7 + this.currentMapArea.getRegionLowY() * 64);
			if (this.mouseCoord != null && var3) {
				boolean var8 = Client.staffModLevel >= 2;
				if (var8 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
					BoundaryObject.method3215(this.mouseCoord.x, this.mouseCoord.y, this.mouseCoord.plane, false);
				} else {
					boolean var9 = true;
					if (this.field3989) {
						int var10 = var1 - this.field3987;
						int var11 = var2 - this.field3988;
						if (var4 - this.field3986 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
							var9 = false;
						}
					}

					if (var9) {
						PacketBufferNode var12 = MenuAction.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
						var12.packetBuffer.writeIntME(this.mouseCoord.packed());
						Client.packetWriter.addNode(var12);
						this.field3986 = 0L;
					}
				}
			}
		} else {
			this.mouseCoord = null;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-70"
	)
	@Export("smoothZoom")
	void smoothZoom() {
		if (GameObject.field1921 != null) {
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1338341298"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "1410268107"
	)
	@Export("setWorldMapPosition")
	final void setWorldMapPosition(int var1, int var2, boolean var3) {
		this.centerTileX = var1;
		this.centerTileY = var2;
		SequenceDefinition.method4686();
		if (var3) {
			this.method6330();
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-616749103"
	)
	final void method6330() {
		this.field3985 = -1;
		this.field3984 = -1;
		this.field3970 = -1;
		this.field3947 = -1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-26"
	)
	@Export("hasTarget")
	boolean hasTarget() {
		return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIB)Lav;",
		garbageValue = "1"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-1201377679"
	)
	public void method6193(int var1, int var2, int var3, boolean var4) {
		WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.mainMapArea;
		}

		boolean var6 = false;
		if (var5 != this.field3948 || var4) {
			this.field3948 = var5;
			this.setCurrentMapArea(var5);
			var6 = true;
		}

		if (var6 || var4) {
			this.jump(var1, var2, var3);
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "552511282"
	)
	@Export("setCurrentMapAreaId")
	public void setCurrentMapAreaId(int var1) {
		WorldMapArea var2 = this.getMapArea(var1);
		if (var2 != null) {
			this.setCurrentMapArea(var2);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "2"
	)
	@Export("currentMapAreaId")
	public int currentMapAreaId() {
		return this.currentMapArea == null ? -1 : this.currentMapArea.getId();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Lav;",
		garbageValue = "-1424371982"
	)
	@Export("getCurrentMapArea")
	public WorldMapArea getCurrentMapArea() {
		return this.currentMapArea;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "2090991872"
	)
	@Export("setCurrentMapArea")
	void setCurrentMapArea(WorldMapArea var1) {
		if (this.currentMapArea == null || var1 != this.currentMapArea) {
			this.initializeWorldMapManager(var1);
			this.jump(-1, -1, -1);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lav;B)V",
		garbageValue = "14"
	)
	@Export("initializeWorldMapManager")
	void initializeWorldMapManager(WorldMapArea var1) {
		this.currentMapArea = var1;
		this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
		this.cacheLoader.reset(this.currentMapArea.getInternalName());
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lav;Lhd;Lhd;ZB)V",
		garbageValue = "120"
	)
	public void method6199(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1231444564"
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
			this.field3980 = null;
			this.iconIterator = null;
			this.worldMapManager.clearIcons();
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-2106180683"
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
			boolean var10;
			if (!this.elementsDisabled) {
				var10 = false;
				if (var5 - this.field3995 > 100) {
					this.field3995 = var5;
					var10 = true;
				}

				this.worldMapManager.drawElements(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3993, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
			}

			this.method6203(var1, var2, var3, var4, var8, var9);
			var10 = Client.staffModLevel >= 2;
			if (var10 && this.showCoord && this.mouseCoord != null) {
				this.font.draw("Coord: " + this.mouseCoord, Rasterizer2D.Rasterizer2D_xClipStart + 10, Rasterizer2D.Rasterizer2D_yClipStart + 20, 16776960, -1);
			}

			this.worldMapDisplayWidth = var8;
			this.worldMapDisplayHeight = var9;
			this.worldMapDisplayX = var1;
			this.worldMapDisplayY = var2;
			Rasterizer2D.Rasterizer2D_setClipArray(var6);
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIIIIII)Z",
		garbageValue = "-163932423"
	)
	boolean method6296(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.sprite == null) {
			return true;
		} else if (this.sprite.subWidth == var1 && this.sprite.subHeight == var2) {
			if (this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile) {
				return true;
			} else if (this.field4006 != Client.field892) {
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIIIIS)V",
		garbageValue = "32313"
	)
	void method6203(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (GameObject.field1921 != null) {
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
			if (this.method6296(var8, var9, var13, var14, var3, var4)) {
				if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
					Arrays.fill(this.sprite.pixels, 0);
				} else {
					this.sprite = new Sprite(var8, var9);
				}

				this.minCachedTileX = this.getDisplayX() - var5 / 2 - var7;
				this.minCachedTileY = this.getDisplayY() - var6 / 2 - var7;
				this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
				GameObject.field1921.method4242(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
				this.field4006 = Client.field892;
				var13 = var1 - (var11 + var7 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
				var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			}

			Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
			if (1.0F == var10) {
				this.sprite.method6014(var13, var14, 192);
			} else {
				this.sprite.method6017(var13, var14, (int)((float)var8 * var10), (int)((float)var9 * var10), 192);
			}
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "81"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-178698826"
	)
	@Export("setZoomPercentage")
	public void setZoomPercentage(int var1) {
		this.zoomTarget = this.getZoomFromPercentage(var1);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IIIIIS)V",
		garbageValue = "510"
	)
	@Export("drawLoading")
	void drawLoading(int var1, int var2, int var3, int var4, int var5) {
		byte var6 = 20;
		int var7 = var3 / 2 + var1;
		int var8 = var4 / 2 + var2 - 18 - var6;
		Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
		Rasterizer2D.Rasterizer2D_drawRectangle(var7 - 152, var8, 304, 34, -65536);
		Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
		this.font.drawCentered("Loading...", var7, var6 + var8, -1, -1);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(IB)F",
		garbageValue = "71"
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "666427478"
	)
	@Export("getZoomLevel")
	public int getZoomLevel() {
		if ((double)this.zoomTarget == 1.0D) {
			return 25;
		} else if (1.5D == (double)this.zoomTarget) {
			return 37;
		} else if (2.0D == (double)this.zoomTarget) {
			return 50;
		} else if ((double)this.zoomTarget == 3.0D) {
			return 75;
		} else {
			return 4.0D == (double)this.zoomTarget ? 100 : 200;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "301674641"
	)
	@Export("loadCache")
	public void loadCache() {
		this.cacheLoader.load();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-80"
	)
	@Export("isCacheLoaded")
	public boolean isCacheLoaded() {
		return this.cacheLoader.isLoaded();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(IB)Lav;",
		garbageValue = "97"
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "938749797"
	)
	@Export("setWorldMapPositionTarget")
	public void setWorldMapPositionTarget(int var1, int var2) {
		if (this.currentMapArea != null && this.currentMapArea.containsPosition(var1, var2)) {
			this.worldMapTargetX = var1 - this.currentMapArea.getRegionLowX() * 64;
			this.worldMapTargetY = var2 - this.currentMapArea.getRegionLowY() * 64;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-30"
	)
	@Export("setWorldMapPositionTargetInstant")
	public void setWorldMapPositionTargetInstant(int var1, int var2) {
		if (this.currentMapArea != null) {
			this.setWorldMapPosition(var1 - this.currentMapArea.getRegionLowX() * 64, var2 - this.currentMapArea.getRegionLowY() * 64, true);
			this.worldMapTargetX = -1;
			this.worldMapTargetY = -1;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "1"
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

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-183605322"
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "418458900"
	)
	@Export("getDisplayX")
	public int getDisplayX() {
		return this.currentMapArea == null ? -1 : this.centerTileX + this.currentMapArea.getRegionLowX() * 64;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "8"
	)
	@Export("getDisplayY")
	public int getDisplayY() {
		return this.currentMapArea == null ? -1 : this.centerTileY + this.currentMapArea.getRegionLowY() * 64;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(B)Lhd;",
		garbageValue = "122"
	)
	@Export("getDisplayCoord")
	public Coord getDisplayCoord() {
		return this.currentMapArea == null ? null : this.currentMapArea.coord(this.getDisplayX(), this.getDisplayY());
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1924193012"
	)
	@Export("getDisplayWith")
	public int getDisplayWith() {
		return this.worldMapDisplayWidth;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2076966029"
	)
	@Export("getDisplayHeight")
	public int getDisplayHeight() {
		return this.worldMapDisplayHeight;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-106"
	)
	@Export("setMaxFlashCount")
	public void setMaxFlashCount(int var1) {
		if (var1 >= 1) {
			this.maxFlashCount = var1;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "499272419"
	)
	@Export("resetMaxFlashCount")
	public void resetMaxFlashCount() {
		this.maxFlashCount = 3;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1568353274"
	)
	@Export("setCyclesPerFlash")
	public void setCyclesPerFlash(int var1) {
		if (var1 >= 1) {
			this.cyclesPerFlash = var1;
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1817487801"
	)
	@Export("resetCyclesPerFlash")
	public void resetCyclesPerFlash() {
		this.cyclesPerFlash = 50;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "14"
	)
	@Export("setPerpetualFlash")
	public void setPerpetualFlash(boolean var1) {
		this.perpetualFlash = var1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-91"
	)
	@Export("flashElement")
	public void flashElement(int var1) {
		this.flashingElements = new HashSet();
		this.flashingElements.add(var1);
		this.flashCount = 0;
		this.flashCycle = 0;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1948560443"
	)
	@Export("flashCategory")
	public void flashCategory(int var1) {
		this.flashingElements = new HashSet();
		this.flashCount = 0;
		this.flashCycle = 0;

		for (int var2 = 0; var2 < WorldMapElement.WorldMapElement_count; ++var2) {
			if (WorldMapData_0.WorldMapElement_get(var2) != null && WorldMapData_0.WorldMapElement_get(var2).category == var1) {
				this.flashingElements.add(WorldMapData_0.WorldMapElement_get(var2).objectId);
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-290125378"
	)
	@Export("stopCurrentFlashes")
	public void stopCurrentFlashes() {
		this.flashingElements = null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(ZS)V",
		garbageValue = "12874"
	)
	@Export("setElementsDisabled")
	public void setElementsDisabled(boolean var1) {
		this.elementsDisabled = !var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(IZS)V",
		garbageValue = "256"
	)
	@Export("disableElement")
	public void disableElement(int var1, boolean var2) {
		if (!var2) {
			this.enabledElements.add(var1);
		} else {
			this.enabledElements.remove(var1);
		}

		this.method6235();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "24"
	)
	@Export("setCategoryDisabled")
	public void setCategoryDisabled(int var1, boolean var2) {
		if (!var2) {
			this.enabledCategories.add(var1);
		} else {
			this.enabledCategories.remove(var1);
		}

		for (int var3 = 0; var3 < WorldMapElement.WorldMapElement_count; ++var3) {
			if (WorldMapData_0.WorldMapElement_get(var3) != null && WorldMapData_0.WorldMapElement_get(var3).category == var1) {
				int var4 = WorldMapData_0.WorldMapElement_get(var3).objectId;
				if (!var2) {
					this.enabledElementIds.add(var4);
				} else {
					this.enabledElementIds.remove(var4);
				}
			}
		}

		this.method6235();
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1573190720"
	)
	@Export("getElementsDisabled")
	public boolean getElementsDisabled() {
		return !this.elementsDisabled;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "245562250"
	)
	@Export("isElementDisabled")
	public boolean isElementDisabled(int var1) {
		return !this.enabledElements.contains(var1);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "2145379299"
	)
	@Export("isCategoryDisabled")
	public boolean isCategoryDisabled(int var1) {
		return !this.enabledCategories.contains(var1);
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2006376266"
	)
	void method6235() {
		this.field3993.clear();
		this.field3993.addAll(this.enabledElements);
		this.field3993.addAll(this.enabledElementIds);
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "2038457926"
	)
	@Export("addElementMenuOptions")
	public void addElementMenuOptions(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.cacheLoader.isLoaded()) {
			int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
			List var9 = this.worldMapManager.method629(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
					WorldMapElement var12 = WorldMapData_0.WorldMapElement_get(var11.getElement());
					var13 = false;

					for (int var14 = this.menuOpcodes.length - 1; var14 >= 0; --var14) {
						if (var12.menuActions[var14] != null) {
							WorldMapData_0.insertMenuItemNoShift(var12.menuActions[var14], var12.menuTargetName, this.menuOpcodes[var14], var11.getElement(), var11.coord1.packed(), var11.coord2.packed());
							var13 = true;
						}
					}
				} while(!var13);

			}
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(ILhd;I)Lhd;",
		garbageValue = "-440389364"
	)
	public Coord method6237(int var1, Coord var2) {
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
						var11 = var10 * var10 + var9 * var9;
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

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(IILhd;Lhd;B)V",
		garbageValue = "-119"
	)
	@Export("menuAction")
	public void menuAction(int var1, int var2, Coord var3, Coord var4) {
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

		class81.runScriptEvent(var5);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "(I)Las;",
		garbageValue = "-1599933443"
	)
	@Export("iconStart")
	public AbstractWorldMapIcon iconStart() {
		if (!this.cacheLoader.isLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else {
			HashMap var1 = this.worldMapManager.buildIcons();
			this.field3980 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List)var2.next();
				this.field3980.addAll(var3);
			}

			this.iconIterator = this.field3980.iterator();
			return this.iconNext();
		}
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I)Las;",
		garbageValue = "-1237024182"
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
