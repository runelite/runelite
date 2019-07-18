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

@ObfuscatedName("lw")
@Implements("WorldMap")
public class WorldMap {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkd;"
	)
	@Export("fontNameVerdana11")
	static final FontName fontNameVerdana11;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lkd;"
	)
	@Export("fontNameVerdana13")
	static final FontName fontNameVerdana13;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkd;"
	)
	@Export("fontNameVerdana15")
	static final FontName fontNameVerdana15;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("WorldMap_archive")
	AbstractArchive WorldMap_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("WorldMap_geographyArchive")
	AbstractArchive WorldMap_geographyArchive;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("WorldMap_groundArchive")
	AbstractArchive WorldMap_groundArchive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("font")
	Font font;
	@ObfuscatedName("r")
	@Export("fonts")
	HashMap fonts;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("y")
	@Export("details")
	HashMap details;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	@Export("mainMapArea")
	WorldMapArea mainMapArea;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	@Export("currentMapArea")
	WorldMapArea currentMapArea;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	WorldMapArea field3987;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("worldMapManager")
	WorldMapManager worldMapManager;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("cacheLoader")
	WorldMapArchiveLoader cacheLoader;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1418781423
	)
	@Export("centerTileX")
	int centerTileX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1871898529
	)
	@Export("centerTileY")
	int centerTileY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -992718151
	)
	@Export("worldMapTargetX")
	int worldMapTargetX;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1071222737
	)
	@Export("worldMapTargetY")
	int worldMapTargetY;
	@ObfuscatedName("z")
	@Export("zoom")
	float zoom;
	@ObfuscatedName("al")
	@Export("zoomTarget")
	float zoomTarget;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -802390977
	)
	@Export("worldMapDisplayWidth")
	int worldMapDisplayWidth;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -856953133
	)
	@Export("worldMapDisplayHeight")
	int worldMapDisplayHeight;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1183613303
	)
	@Export("worldMapDisplayX")
	int worldMapDisplayX;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 696817529
	)
	@Export("worldMapDisplayY")
	int worldMapDisplayY;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1595018925
	)
	@Export("maxFlashCount")
	int maxFlashCount;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -2142682359
	)
	@Export("cyclesPerFlash")
	int cyclesPerFlash;
	@ObfuscatedName("ax")
	@Export("perpetualFlash")
	boolean perpetualFlash;
	@ObfuscatedName("az")
	@Export("flashingElements")
	HashSet flashingElements;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -11969815
	)
	@Export("flashCount")
	int flashCount;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -616472333
	)
	@Export("flashCycle")
	int flashCycle;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1572567943
	)
	int field4006;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1183921933
	)
	int field4007;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -62799705
	)
	int field4001;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1700345793
	)
	int field3989;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		longValue = 3331576765951850875L
	)
	long field3982;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1084825883
	)
	int field4000;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1928093953
	)
	int field4012;
	@ObfuscatedName("au")
	boolean field4013;
	@ObfuscatedName("ah")
	@Export("enabledElements")
	HashSet enabledElements;
	@ObfuscatedName("am")
	@Export("enabledCategories")
	HashSet enabledCategories;
	@ObfuscatedName("ay")
	@Export("enabledElementIds")
	HashSet enabledElementIds;
	@ObfuscatedName("af")
	HashSet field3988;
	@ObfuscatedName("ab")
	@Export("elementsDisabled")
	boolean elementsDisabled;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1122489777
	)
	int field4011;
	@ObfuscatedName("bi")
	final int[] field4020;
	@ObfuscatedName("bg")
	List field3972;
	@ObfuscatedName("bh")
	@Export("iconIterator")
	Iterator iconIterator;
	@ObfuscatedName("bm")
	HashSet field4005;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("mouseCoord")
	Coord mouseCoord;
	@ObfuscatedName("bc")
	@Export("showCoord")
	public boolean showCoord;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("sprite")
	Sprite sprite;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1411548561
	)
	@Export("cachedPixelsPerTile")
	int cachedPixelsPerTile;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 573003381
	)
	@Export("minCachedTileX")
	int minCachedTileX;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -2083065465
	)
	@Export("minCachedTileY")
	int minCachedTileY;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1463258673
	)
	int field4030;

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
		this.field4006 = -1;
		this.field4007 = -1;
		this.field4001 = -1;
		this.field3989 = -1;
		this.field4013 = true;
		this.enabledElements = new HashSet();
		this.enabledCategories = new HashSet();
		this.enabledElementIds = new HashSet();
		this.field3988 = new HashSet();
		this.elementsDisabled = false;
		this.field4011 = 0;
		this.field4020 = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field4005 = new HashSet();
		this.mouseCoord = null;
		this.showCoord = false;
		this.minCachedTileX = -1;
		this.minCachedTileY = -1;
		this.field4030 = -1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;Lke;Ljava/util/HashMap;[Llx;I)V",
		garbageValue = "269789148"
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
		int var7 = this.WorldMap_archive.getGroupId(WorldMapCacheName.field308.name);
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
		this.field3987 = null;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1654811924"
	)
	public void method6299() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIZIIIII)V",
		garbageValue = "-2047217979"
	)
	@Export("onCycle")
	public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.cacheLoader.getIsLoaded()) {
			this.smoothZoom();
			this.scrollToTarget();
			if (var3) {
				int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
				int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
				List var10 = this.worldMapManager.method607(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				AbstractWorldMapIcon var13;
				ScriptEvent var14;
				WorldMapEvent var15;
				for (var12 = var10.iterator(); var12.hasNext(); LoginPacket.runScriptEvent(var14)) {
					var13 = (AbstractWorldMapIcon)var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
					var14.setArgs(new Object[]{var15, var1, var2});
					if (this.field4005.contains(var13)) {
						var14.setType(17);
					} else {
						var14.setType(15);
					}
				}

				var12 = this.field4005.iterator();

				while (var12.hasNext()) {
					var13 = (AbstractWorldMapIcon)var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
						var14.setArgs(new Object[]{var15, var1, var2});
						var14.setType(16);
						LoginPacket.runScriptEvent(var14);
					}
				}

				this.field4005 = var11;
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIZZB)V",
		garbageValue = "24"
	)
	public void method6301(int var1, int var2, boolean var3, boolean var4) {
		long var5 = DirectByteArrayCopier.currentTimeMs();
		this.method6302(var1, var2, var4, var5);
		if (!this.hasTarget() && (var4 || var3)) {
			if (var4) {
				this.field4001 = var1;
				this.field3989 = var2;
				this.field4006 = this.centerTileX;
				this.field4007 = this.centerTileY;
			}

			if (this.field4006 != -1) {
				int var7 = var1 - this.field4001;
				int var8 = var2 - this.field3989;
				this.setWorldMapPosition(this.field4006 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field4007, false);
			}
		} else {
			this.method6306();
		}

		if (var4) {
			this.field3982 = var5;
			this.field4000 = var1;
			this.field4012 = var2;
		}

	}

	@ObfuscatedName("k")
	void method6302(int var1, int var2, boolean var3, long var4) {
		if (this.currentMapArea != null) {
			int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.getDisplayWith() * this.zoom / 2.0F) / this.zoom);
			int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.getDisplayHeight() * this.zoom / 2.0F) / this.zoom);
			this.mouseCoord = this.currentMapArea.coord(var6 + this.currentMapArea.getRegionLowX() * 64, var7 + this.currentMapArea.getRegionLowY() * 64);
			if (this.mouseCoord != null && var3) {
				boolean var8 = Client.staffModLevel >= 2;
				if (var8 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
					WorldMapLabel.method418(this.mouseCoord.x, this.mouseCoord.y, this.mouseCoord.plane, false);
				} else {
					boolean var9 = true;
					if (this.field4013) {
						int var10 = var1 - this.field4000;
						int var11 = var2 - this.field4012;
						if (var4 - this.field3982 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
							var9 = false;
						}
					}

					if (var9) {
						PacketBufferNode var12 = Archive.method4265(ClientPacket.field2248, Client.packetWriter.isaacCipher);
						var12.packetBuffer.writeIntME(this.mouseCoord.packed());
						Client.packetWriter.method2219(var12);
						this.field3982 = 0L;
					}
				}
			}
		} else {
			this.mouseCoord = null;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-59"
	)
	@Export("smoothZoom")
	void smoothZoom() {
		if (PendingSpawn.field944 != null) {
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1342245212"
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
			if (this.worldMapTargetX == this.centerTileX && this.centerTileY == this.worldMapTargetY) {
				this.worldMapTargetX = -1;
				this.worldMapTargetY = -1;
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "997010308"
	)
	@Export("setWorldMapPosition")
	final void setWorldMapPosition(int var1, int var2, boolean var3) {
		this.centerTileX = var1;
		this.centerTileY = var2;
		DirectByteArrayCopier.currentTimeMs();
		if (var3) {
			this.method6306();
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	final void method6306() {
		this.field3989 = -1;
		this.field4001 = -1;
		this.field4007 = -1;
		this.field4006 = -1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1798677301"
	)
	@Export("hasTarget")
	boolean hasTarget() {
		return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIB)Lal;",
		garbageValue = "30"
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIIZB)V",
		garbageValue = "-128"
	)
	public void method6309(int var1, int var2, int var3, boolean var4) {
		WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.mainMapArea;
		}

		boolean var6 = false;
		if (var5 != this.field3987 || var4) {
			this.field3987 = var5;
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
		garbageValue = "-2081966255"
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
		garbageValue = "89"
	)
	@Export("currentMapAreaId")
	public int currentMapAreaId() {
		return this.currentMapArea == null ? -1 : this.currentMapArea.getId();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)Lal;",
		garbageValue = "-121"
	)
	@Export("getCurrentMapArea")
	public WorldMapArea getCurrentMapArea() {
		return this.currentMapArea;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lal;I)V",
		garbageValue = "812407126"
	)
	@Export("setCurrentMapArea")
	void setCurrentMapArea(WorldMapArea var1) {
		if (this.currentMapArea == null || var1 != this.currentMapArea) {
			this.initializeWorldMapManager(var1);
			this.jump(-1, -1, -1);
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lal;I)V",
		garbageValue = "-1813483224"
	)
	@Export("initializeWorldMapManager")
	void initializeWorldMapManager(WorldMapArea var1) {
		this.currentMapArea = var1;
		this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
		this.cacheLoader.reset(this.currentMapArea.getInternalName());
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lal;Lhv;Lhv;ZI)V",
		garbageValue = "1469825217"
	)
	public void method6315(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1348080831"
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
			this.field3972 = null;
			this.iconIterator = null;
			this.worldMapManager.clearIcons();
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-365948534"
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
				if (var5 - this.field4011 > 100) {
					this.field4011 = var5;
					var10 = true;
				}

				this.worldMapManager.method605(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3988, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
			}

			this.method6319(var1, var2, var3, var4, var8, var9);
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIIIII)Z",
		garbageValue = "-1863961695"
	)
	boolean method6318(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.sprite == null) {
			return true;
		} else if (this.sprite.subWidth == var1 && this.sprite.subHeight == var2) {
			if (this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile) {
				return true;
			} else if (this.field4030 != Client.field924) {
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

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-125"
	)
	void method6319(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (PendingSpawn.field944 != null) {
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
			if (this.method6318(var8, var9, var13, var14, var3, var4)) {
				if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
					Arrays.fill(this.sprite.pixels, 0);
				} else {
					this.sprite = new Sprite(var8, var9);
				}

				this.minCachedTileX = this.getDisplayX() - var5 / 2 - var7;
				this.minCachedTileY = this.getDisplayY() - var6 / 2 - var7;
				this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
				PendingSpawn.field944.method4321(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
				this.field4030 = Client.field924;
				var13 = var1 - (var11 + var7 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
				var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			}

			Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
			if (1.0F == var10) {
				this.sprite.method6135(var13, var14, 192);
			} else {
				this.sprite.method6217(var13, var14, (int)(var10 * (float)var8), (int)((float)var9 * var10), 192);
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1774436451"
	)
	@Export("drawOverview")
	public void drawOverview(int var1, int var2, int var3, int var4) {
		if (this.cacheLoader.getIsLoaded()) {
			if (!this.worldMapManager.isLoaded()) {
				this.worldMapManager.load(this.WorldMap_archive, this.currentMapArea.getInternalName(), Client.isMembersWorld);
				if (!this.worldMapManager.isLoaded()) {
					return;
				}
			}

			this.worldMapManager.drawOverview(var1, var2, var3, var4, this.flashingElements, this.flashCycle, this.cyclesPerFlash);
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1089841292"
	)
	@Export("setZoomPercentage")
	public void setZoomPercentage(int var1) {
		this.zoomTarget = this.getZoomFromPercentage(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "1955930802"
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

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(II)F",
		garbageValue = "-1360526836"
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "58"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1903923036"
	)
	@Export("loadCache")
	public void loadCache() {
		this.cacheLoader.load();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1852688720"
	)
	@Export("isCacheLoaded")
	public boolean isCacheLoaded() {
		return this.cacheLoader.getIsLoaded();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(II)Lal;",
		garbageValue = "-733609439"
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

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1604144136"
	)
	@Export("setWorldMapPositionTarget")
	public void setWorldMapPositionTarget(int var1, int var2) {
		if (this.currentMapArea != null && this.currentMapArea.containsPosition(var1, var2)) {
			this.worldMapTargetX = var1 - this.currentMapArea.getRegionLowX() * 64;
			this.worldMapTargetY = var2 - this.currentMapArea.getRegionLowY() * 64;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2147035195"
	)
	@Export("setWorldMapPositionTargetInstant")
	public void setWorldMapPositionTargetInstant(int var1, int var2) {
		if (this.currentMapArea != null) {
			this.setWorldMapPosition(var1 - this.currentMapArea.getRegionLowX() * 64, var2 - this.currentMapArea.getRegionLowY() * 64, true);
			this.worldMapTargetX = -1;
			this.worldMapTargetY = -1;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1252480817"
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

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1225675746"
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

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-786263367"
	)
	@Export("getDisplayX")
	public int getDisplayX() {
		return this.currentMapArea == null ? -1 : this.centerTileX + this.currentMapArea.getRegionLowX() * 64;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2026899768"
	)
	@Export("getDisplayY")
	public int getDisplayY() {
		return this.currentMapArea == null ? -1 : this.centerTileY + this.currentMapArea.getRegionLowY() * 64;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(B)Lhv;",
		garbageValue = "19"
	)
	@Export("getDisplayCoord")
	public Coord getDisplayCoord() {
		return this.currentMapArea == null ? null : this.currentMapArea.coord(this.getDisplayX(), this.getDisplayY());
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1200687327"
	)
	@Export("getDisplayWith")
	public int getDisplayWith() {
		return this.worldMapDisplayWidth;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "127"
	)
	@Export("getDisplayHeight")
	public int getDisplayHeight() {
		return this.worldMapDisplayHeight;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1678064633"
	)
	public void method6337(int var1) {
		if (var1 >= 1) {
			this.maxFlashCount = var1;
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "18"
	)
	public void method6338() {
		this.maxFlashCount = 3;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "127822739"
	)
	public void method6339(int var1) {
		if (var1 >= 1) {
			this.cyclesPerFlash = var1;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-244117630"
	)
	public void method6340() {
		this.cyclesPerFlash = 50;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1836786082"
	)
	@Export("setPerpetualFlash")
	public void setPerpetualFlash(boolean var1) {
		this.perpetualFlash = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1761276065"
	)
	@Export("flashElement")
	public void flashElement(int var1) {
		this.flashingElements = new HashSet();
		this.flashingElements.add(var1);
		this.flashCount = 0;
		this.flashCycle = 0;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-685614117"
	)
	@Export("flashCategory")
	public void flashCategory(int var1) {
		this.flashingElements = new HashSet();
		this.flashCount = 0;
		this.flashCycle = 0;

		for (int var2 = 0; var2 < UserComparator1.WorldMapElement_count; ++var2) {
			if (class222.getWorldMapElement(var2) != null && class222.getWorldMapElement(var2).category == var1) {
				this.flashingElements.add(class222.getWorldMapElement(var2).objectId);
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1910993188"
	)
	@Export("stopCurrentFlashes")
	public void stopCurrentFlashes() {
		this.flashingElements = null;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "35"
	)
	@Export("setElementsDisabled")
	public void setElementsDisabled(boolean var1) {
		this.elementsDisabled = !var1;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "-69"
	)
	@Export("disableElement")
	public void disableElement(int var1, boolean var2) {
		if (!var2) {
			this.enabledElements.add(var1);
		} else {
			this.enabledElements.remove(var1);
		}

		this.method6350();
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-1036879778"
	)
	@Export("setCategoryDisabled")
	public void setCategoryDisabled(int var1, boolean var2) {
		if (!var2) {
			this.enabledCategories.add(var1);
		} else {
			this.enabledCategories.remove(var1);
		}

		for (int var3 = 0; var3 < UserComparator1.WorldMapElement_count; ++var3) {
			if (class222.getWorldMapElement(var3) != null && class222.getWorldMapElement(var3).category == var1) {
				int var4 = class222.getWorldMapElement(var3).objectId;
				if (!var2) {
					this.enabledElementIds.add(var4);
				} else {
					this.enabledElementIds.remove(var4);
				}
			}
		}

		this.method6350();
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-27155"
	)
	@Export("getElementsDisabled")
	public boolean getElementsDisabled() {
		return !this.elementsDisabled;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-85"
	)
	@Export("isElementDisabled")
	public boolean isElementDisabled(int var1) {
		return !this.enabledElements.contains(var1);
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-120988361"
	)
	@Export("isCategoryDisabled")
	public boolean isCategoryDisabled(int var1) {
		return !this.enabledCategories.contains(var1);
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "27"
	)
	void method6350() {
		this.field3988.clear();
		this.field3988.addAll(this.enabledElements);
		this.field3988.addAll(this.enabledElementIds);
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "90618974"
	)
	public void method6482(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.cacheLoader.getIsLoaded()) {
			int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
			List var9 = this.worldMapManager.method607(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
					WorldMapElement var12 = class222.getWorldMapElement(var11.getElement());
					var13 = false;

					for (int var14 = this.field4020.length - 1; var14 >= 0; --var14) {
						if (var12.strings[var14] != null) {
							class188.insertMenuItemNoShift(var12.strings[var14], var12.string1, this.field4020[var14], var11.getElement(), var11.coord1.packed(), var11.coord2.packed());
							var13 = true;
						}
					}
				} while(!var13);

			}
		}
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(ILhv;I)Lhv;",
		garbageValue = "719601861"
	)
	public Coord method6352(int var1, Coord var2) {
		if (!this.cacheLoader.getIsLoaded()) {
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

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(IILhv;Lhv;B)V",
		garbageValue = "8"
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

		LoginPacket.runScriptEvent(var5);
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "(I)Laz;",
		garbageValue = "1843313611"
	)
	@Export("iconStart")
	public AbstractWorldMapIcon iconStart() {
		if (!this.cacheLoader.getIsLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else {
			HashMap var1 = this.worldMapManager.buildIcons();
			this.field3972 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List)var2.next();
				this.field3972.addAll(var3);
			}

			this.iconIterator = this.field3972.iterator();
			return this.iconNext();
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(B)Laz;",
		garbageValue = "64"
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
