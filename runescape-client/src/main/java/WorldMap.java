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

@ObfuscatedName("ld")
@Implements("WorldMap")
public class WorldMap {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	@Export("fontNameVerdana11")
	static final FontName fontNameVerdana11;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	@Export("fontNameVerdana13")
	static final FontName fontNameVerdana13;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lkk;"
	)
	@Export("fontNameVerdana15")
	static final FontName fontNameVerdana15;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_archive")
	AbstractArchive WorldMap_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_geographyArchive")
	AbstractArchive WorldMap_geographyArchive;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_groundArchive")
	AbstractArchive WorldMap_groundArchive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("font")
	Font font;
	@ObfuscatedName("k")
	@Export("fonts")
	HashMap fonts;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("l")
	@Export("details")
	HashMap details;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Laa;"
	)
	@Export("mainMapArea")
	WorldMapArea mainMapArea;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Laa;"
	)
	@Export("currentMapArea")
	WorldMapArea currentMapArea;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Laa;"
	)
	WorldMapArea field3959;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	@Export("worldMapManager")
	WorldMapManager worldMapManager;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("cacheLoader")
	WorldMapArchiveLoader cacheLoader;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 769697825
	)
	@Export("centerTileX")
	int centerTileX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1650708007
	)
	@Export("centerTileY")
	int centerTileY;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1898318821
	)
	@Export("worldMapTargetX")
	int worldMapTargetX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1415231623
	)
	@Export("worldMapTargetY")
	int worldMapTargetY;
	@ObfuscatedName("q")
	@Export("zoom")
	float zoom;
	@ObfuscatedName("aa")
	@Export("zoomTarget")
	float zoomTarget;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1100831923
	)
	@Export("worldMapDisplayWidth")
	int worldMapDisplayWidth;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -480393575
	)
	@Export("worldMapDisplayHeight")
	int worldMapDisplayHeight;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -971268509
	)
	@Export("worldMapDisplayX")
	int worldMapDisplayX;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -763154973
	)
	@Export("worldMapDisplayY")
	int worldMapDisplayY;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -258302625
	)
	@Export("maxFlashCount")
	int maxFlashCount;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1236137625
	)
	@Export("cyclesPerFlash")
	int cyclesPerFlash;
	@ObfuscatedName("aq")
	@Export("perpetualFlash")
	boolean perpetualFlash;
	@ObfuscatedName("ao")
	@Export("flashingElements")
	HashSet flashingElements;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -458343583
	)
	@Export("flashCount")
	int flashCount;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -710941377
	)
	@Export("flashCycle")
	int flashCycle;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 634143331
	)
	int field3978;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -874414913
	)
	int field3979;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1920735327
	)
	int field3980;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1563619535
	)
	int field3992;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		longValue = 4789234822527169759L
	)
	long field3952;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1313666647
	)
	int field3982;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 914367019
	)
	int field3984;
	@ObfuscatedName("aj")
	boolean field3981;
	@ObfuscatedName("af")
	@Export("enabledElements")
	HashSet enabledElements;
	@ObfuscatedName("ap")
	@Export("enabledCategories")
	HashSet enabledCategories;
	@ObfuscatedName("ai")
	@Export("enabledElementIds")
	HashSet enabledElementIds;
	@ObfuscatedName("am")
	HashSet field3989;
	@ObfuscatedName("ab")
	@Export("elementsDisabled")
	boolean elementsDisabled;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -1635351133
	)
	int field3991;
	@ObfuscatedName("bw")
	@Export("menuOpcodes")
	final int[] menuOpcodes;
	@ObfuscatedName("bk")
	List field3946;
	@ObfuscatedName("bl")
	@Export("iconIterator")
	Iterator iconIterator;
	@ObfuscatedName("bq")
	HashSet field3995;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("mouseCoord")
	Coord mouseCoord;
	@ObfuscatedName("bc")
	@Export("showCoord")
	public boolean showCoord;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("sprite")
	Sprite sprite;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = 366608429
	)
	@Export("cachedPixelsPerTile")
	int cachedPixelsPerTile;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 1813935141
	)
	@Export("minCachedTileX")
	int minCachedTileX;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -3401919
	)
	@Export("minCachedTileY")
	int minCachedTileY;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 842619581
	)
	int field4002;

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
		this.field3978 = -1;
		this.field3979 = -1;
		this.field3980 = -1;
		this.field3992 = -1;
		this.field3981 = true;
		this.enabledElements = new HashSet();
		this.enabledCategories = new HashSet();
		this.enabledElementIds = new HashSet();
		this.field3989 = new HashSet();
		this.elementsDisabled = false;
		this.field3991 = 0;
		this.menuOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field3995 = new HashSet();
		this.mouseCoord = null;
		this.showCoord = false;
		this.minCachedTileX = -1;
		this.minCachedTileY = -1;
		this.field4002 = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lko;Ljava/util/HashMap;[Lli;I)V",
		garbageValue = "1728699917"
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
		int var7 = this.WorldMap_archive.getGroupId(WorldMapCacheName.field291.name);
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
		this.field3959 = null;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1661861008"
	)
	public void method6357() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIZIIIII)V",
		garbageValue = "46505249"
	)
	@Export("onCycle")
	public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.cacheLoader.isLoaded()) {
			this.smoothZoom();
			this.scrollToTarget();
			if (var3) {
				int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
				int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
				List var10 = this.worldMapManager.method647(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				AbstractWorldMapIcon var13;
				ScriptEvent var14;
				WorldMapEvent var15;
				for (var12 = var10.iterator(); var12.hasNext(); Client.runScriptEvent(var14)) {
					var13 = (AbstractWorldMapIcon)var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
					var14.setArgs(new Object[]{var15, var1, var2});
					if (this.field3995.contains(var13)) {
						var14.setType(17);
					} else {
						var14.setType(15);
					}
				}

				var12 = this.field3995.iterator();

				while (var12.hasNext()) {
					var13 = (AbstractWorldMapIcon)var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
						var14.setArgs(new Object[]{var15, var1, var2});
						var14.setType(16);
						Client.runScriptEvent(var14);
					}
				}

				this.field3995 = var11;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIZZB)V",
		garbageValue = "-96"
	)
	public void method6359(int var1, int var2, boolean var3, boolean var4) {
		long var5 = WorldMapID.currentTimeMillis();
		this.method6423(var1, var2, var4, var5);
		if (!this.hasTarget() && (var4 || var3)) {
			if (var4) {
				this.field3980 = var1;
				this.field3992 = var2;
				this.field3978 = this.centerTileX;
				this.field3979 = this.centerTileY;
			}

			if (this.field3978 != -1) {
				int var7 = var1 - this.field3980;
				int var8 = var2 - this.field3992;
				this.setWorldMapPosition(this.field3978 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field3979, false);
			}
		} else {
			this.method6532();
		}

		if (var4) {
			this.field3952 = var5;
			this.field3982 = var1;
			this.field3984 = var2;
		}

	}

	@ObfuscatedName("p")
	void method6423(int var1, int var2, boolean var3, long var4) {
		if (this.currentMapArea != null) {
			int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.getDisplayWith() * this.zoom / 2.0F) / this.zoom);
			int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.getDisplayHeight() * this.zoom / 2.0F) / this.zoom);
			this.mouseCoord = this.currentMapArea.coord(var6 + this.currentMapArea.getRegionLowX() * 64, var7 + this.currentMapArea.getRegionLowY() * 64);
			if (this.mouseCoord != null && var3) {
				boolean var8 = Client.staffModLevel >= 2;
				int var10;
				int var11;
				if (var8 && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
					int var14 = this.mouseCoord.x;
					var10 = this.mouseCoord.y;
					var11 = this.mouseCoord.plane;
					PacketBufferNode var12 = class2.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeIntME(var14);
					var12.packetBuffer.writeShortLE(0);
					var12.packetBuffer.writeIntME(var10);
					var12.packetBuffer.method5569(var11);
					Client.packetWriter.addNode(var12);
				} else {
					boolean var9 = true;
					if (this.field3981) {
						var10 = var1 - this.field3982;
						var11 = var2 - this.field3984;
						if (var4 - this.field3952 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
							var9 = false;
						}
					}

					if (var9) {
						PacketBufferNode var13 = class2.getPacketBufferNode(ClientPacket.field2210, Client.packetWriter.isaacCipher);
						var13.packetBuffer.writeShortLE(this.mouseCoord.packed());
						Client.packetWriter.addNode(var13);
						this.field3952 = 0L;
					}
				}
			}
		} else {
			this.mouseCoord = null;
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "826413742"
	)
	@Export("smoothZoom")
	void smoothZoom() {
		if (class215.field2534 != null) {
			this.zoom = this.zoomTarget;
		} else {
			if (this.zoom < this.zoomTarget) {
				this.zoom = Math.min(this.zoomTarget, this.zoom / 30.0F + this.zoom);
			}

			if (this.zoom > this.zoomTarget) {
				this.zoom = Math.max(this.zoomTarget, this.zoom - this.zoom / 30.0F);
			}

		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2135583041"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-2141502379"
	)
	@Export("setWorldMapPosition")
	final void setWorldMapPosition(int var1, int var2, boolean var3) {
		this.centerTileX = var1;
		this.centerTileY = var2;
		WorldMapID.currentTimeMillis();
		if (var3) {
			this.method6532();
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "304166033"
	)
	final void method6532() {
		this.field3992 = -1;
		this.field3980 = -1;
		this.field3979 = -1;
		this.field3978 = -1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1744394107"
	)
	@Export("hasTarget")
	boolean hasTarget() {
		return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)Laa;",
		garbageValue = "-1136090862"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "2020995373"
	)
	public void method6367(int var1, int var2, int var3, boolean var4) {
		WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.mainMapArea;
		}

		boolean var6 = false;
		if (var5 != this.field3959 || var4) {
			this.field3959 = var5;
			this.setCurrentMapArea(var5);
			var6 = true;
		}

		if (var6 || var4) {
			this.jump(var1, var2, var3);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-41"
	)
	@Export("setCurrentMapAreaId")
	public void setCurrentMapAreaId(int var1) {
		WorldMapArea var2 = this.getMapArea(var1);
		if (var2 != null) {
			this.setCurrentMapArea(var2);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1765160144"
	)
	@Export("currentMapAreaId")
	public int currentMapAreaId() {
		return this.currentMapArea == null ? -1 : this.currentMapArea.getId();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Laa;",
		garbageValue = "-987525690"
	)
	@Export("getCurrentMapArea")
	public WorldMapArea getCurrentMapArea() {
		return this.currentMapArea;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "0"
	)
	@Export("setCurrentMapArea")
	void setCurrentMapArea(WorldMapArea var1) {
		if (this.currentMapArea == null || var1 != this.currentMapArea) {
			this.initializeWorldMapManager(var1);
			this.jump(-1, -1, -1);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "-2040877349"
	)
	@Export("initializeWorldMapManager")
	void initializeWorldMapManager(WorldMapArea var1) {
		this.currentMapArea = var1;
		this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
		this.cacheLoader.reset(this.currentMapArea.getInternalName());
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Laa;Lht;Lht;ZI)V",
		garbageValue = "-118922828"
	)
	public void method6373(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1542600271"
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
			this.field3946 = null;
			this.iconIterator = null;
			this.worldMapManager.clearIcons();
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-87641945"
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
				if (var5 - this.field3991 > 100) {
					this.field3991 = var5;
					var10 = true;
				}

				this.worldMapManager.drawElements(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3989, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
			}

			this.method6377(var1, var2, var3, var4, var8, var9);
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

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(IIIIIII)Z",
		garbageValue = "-341847306"
	)
	boolean method6514(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.sprite == null) {
			return true;
		} else if (this.sprite.subWidth == var1 && this.sprite.subHeight == var2) {
			if (this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile) {
				return true;
			} else if (this.field4002 != Client.field749) {
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-53"
	)
	void method6377(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (class215.field2534 != null) {
			int var7 = 512 / (this.worldMapManager.pixelsPerTile * 2);
			int var8 = var3 + 512;
			int var9 = var4 + 512;
			float var10 = 1.0F;
			var8 = (int)((float)var8 / var10);
			var9 = (int)((float)var9 / var10);
			int var11 = this.getDisplayX() - var5 / 2 - var7;
			int var12 = this.getDisplayY() - var6 / 2 - var7;
			int var13 = var1 - (var11 + var7 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
			int var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			if (this.method6514(var8, var9, var13, var14, var3, var4)) {
				if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
					Arrays.fill(this.sprite.pixels, 0);
				} else {
					this.sprite = new Sprite(var8, var9);
				}

				this.minCachedTileX = this.getDisplayX() - var5 / 2 - var7;
				this.minCachedTileY = this.getDisplayY() - var6 / 2 - var7;
				this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
				class215.field2534.method4318(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
				this.field4002 = Client.field749;
				var13 = var1 - (var11 + var7 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
				var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			}

			Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
			if (1.0F == var10) {
				this.sprite.method6159(var13, var14, 192);
			} else {
				this.sprite.method6162(var13, var14, (int)(var10 * (float)var8), (int)(var10 * (float)var9), 192);
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2078512734"
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

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "3"
	)
	@Export("setZoomPercentage")
	public void setZoomPercentage(int var1) {
		this.zoomTarget = this.getZoomFromPercentage(var1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "55"
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(II)F",
		garbageValue = "-1442342288"
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	@Export("getZoomLevel")
	public int getZoomLevel() {
		if ((double)this.zoomTarget == 1.0D) {
			return 25;
		} else if ((double)this.zoomTarget == 1.5D) {
			return 37;
		} else if ((double)this.zoomTarget == 2.0D) {
			return 50;
		} else if (3.0D == (double)this.zoomTarget) {
			return 75;
		} else {
			return 4.0D == (double)this.zoomTarget ? 100 : 200;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1583418166"
	)
	@Export("loadCache")
	public void loadCache() {
		this.cacheLoader.load();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "9"
	)
	@Export("isCacheLoaded")
	public boolean isCacheLoaded() {
		return this.cacheLoader.isLoaded();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(II)Laa;",
		garbageValue = "-1454558464"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1969437035"
	)
	@Export("setWorldMapPositionTarget")
	public void setWorldMapPositionTarget(int var1, int var2) {
		if (this.currentMapArea != null && this.currentMapArea.containsPosition(var1, var2)) {
			this.worldMapTargetX = var1 - this.currentMapArea.getRegionLowX() * 64;
			this.worldMapTargetY = var2 - this.currentMapArea.getRegionLowY() * 64;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1231977956"
	)
	@Export("setWorldMapPositionTargetInstant")
	public void setWorldMapPositionTargetInstant(int var1, int var2) {
		if (this.currentMapArea != null) {
			this.setWorldMapPosition(var1 - this.currentMapArea.getRegionLowX() * 64, var2 - this.currentMapArea.getRegionLowY() * 64, true);
			this.worldMapTargetX = -1;
			this.worldMapTargetY = -1;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "37"
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-429166705"
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
		garbageValue = "-640061076"
	)
	@Export("getDisplayX")
	public int getDisplayX() {
		return this.currentMapArea == null ? -1 : this.centerTileX + this.currentMapArea.getRegionLowX() * 64;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1240183513"
	)
	@Export("getDisplayY")
	public int getDisplayY() {
		return this.currentMapArea == null ? -1 : this.centerTileY + this.currentMapArea.getRegionLowY() * 64;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)Lht;",
		garbageValue = "1271020652"
	)
	@Export("getDisplayCoord")
	public Coord getDisplayCoord() {
		return this.currentMapArea == null ? null : this.currentMapArea.coord(this.getDisplayX(), this.getDisplayY());
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "310550352"
	)
	@Export("getDisplayWith")
	public int getDisplayWith() {
		return this.worldMapDisplayWidth;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-238486844"
	)
	@Export("getDisplayHeight")
	public int getDisplayHeight() {
		return this.worldMapDisplayHeight;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1755019724"
	)
	@Export("setMaxFlashCount")
	public void setMaxFlashCount(int var1) {
		if (var1 >= 1) {
			this.maxFlashCount = var1;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1329529501"
	)
	@Export("resetMaxFlashCount")
	public void resetMaxFlashCount() {
		this.maxFlashCount = 3;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "42"
	)
	@Export("setCyclesPerFlash")
	public void setCyclesPerFlash(int var1) {
		if (var1 >= 1) {
			this.cyclesPerFlash = var1;
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1817253337"
	)
	@Export("resetCyclesPerFlash")
	public void resetCyclesPerFlash() {
		this.cyclesPerFlash = 50;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "50"
	)
	@Export("setPerpetualFlash")
	public void setPerpetualFlash(boolean var1) {
		this.perpetualFlash = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1830281477"
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
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("flashCategory")
	public void flashCategory(int var1) {
		this.flashingElements = new HashSet();
		this.flashCount = 0;
		this.flashCycle = 0;

		for (int var2 = 0; var2 < class180.WorldMapElement_count; ++var2) {
			if (GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var2) != null && GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var2).category == var1) {
				this.flashingElements.add(GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var2).objectId);
			}
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "104"
	)
	@Export("stopCurrentFlashes")
	public void stopCurrentFlashes() {
		this.flashingElements = null;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "315793353"
	)
	@Export("setElementsDisabled")
	public void setElementsDisabled(boolean var1) {
		this.elementsDisabled = !var1;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-1035576762"
	)
	@Export("disableElement")
	public void disableElement(int var1, boolean var2) {
		if (!var2) {
			this.enabledElements.add(var1);
		} else {
			this.enabledElements.remove(var1);
		}

		this.method6409();
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-900905988"
	)
	@Export("setCategoryDisabled")
	public void setCategoryDisabled(int var1, boolean var2) {
		if (!var2) {
			this.enabledCategories.add(var1);
		} else {
			this.enabledCategories.remove(var1);
		}

		for (int var3 = 0; var3 < class180.WorldMapElement_count; ++var3) {
			if (GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3) != null && GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3).category == var1) {
				int var4 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var3).objectId;
				if (!var2) {
					this.enabledElementIds.add(var4);
				} else {
					this.enabledElementIds.remove(var4);
				}
			}
		}

		this.method6409();
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1450981799"
	)
	@Export("getElementsDisabled")
	public boolean getElementsDisabled() {
		return !this.elementsDisabled;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-2012828359"
	)
	@Export("isElementDisabled")
	public boolean isElementDisabled(int var1) {
		return !this.enabledElements.contains(var1);
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-521010176"
	)
	@Export("isCategoryDisabled")
	public boolean isCategoryDisabled(int var1) {
		return !this.enabledCategories.contains(var1);
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1601699261"
	)
	void method6409() {
		this.field3989.clear();
		this.field3989.addAll(this.enabledElements);
		this.field3989.addAll(this.enabledElementIds);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-1315174671"
	)
	@Export("addElementMenuOptions")
	public void addElementMenuOptions(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.cacheLoader.isLoaded()) {
			int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
			List var9 = this.worldMapManager.method647(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
					WorldMapElement var12 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(var11.getElement());
					var13 = false;

					for (int var14 = this.menuOpcodes.length - 1; var14 >= 0; --var14) {
						if (var12.menuActions[var14] != null) {
							class1.insertMenuItemNoShift(var12.menuActions[var14], var12.menuTargetName, this.menuOpcodes[var14], var11.getElement(), var11.coord1.packed(), var11.coord2.packed());
							var13 = true;
						}
					}
				} while(!var13);

			}
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(ILht;I)Lht;",
		garbageValue = "1569536165"
	)
	public Coord method6416(int var1, Coord var2) {
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

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "(IILht;Lht;I)V",
		garbageValue = "-268236233"
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

		Client.runScriptEvent(var5);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(S)Lao;",
		garbageValue = "-10343"
	)
	@Export("iconStart")
	public AbstractWorldMapIcon iconStart() {
		if (!this.cacheLoader.isLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else {
			HashMap var1 = this.worldMapManager.buildIcons();
			this.field3946 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List)var2.next();
				this.field3946.addAll(var3);
			}

			this.iconIterator = this.field3946.iterator();
			return this.iconNext();
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(B)Lao;",
		garbageValue = "88"
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
