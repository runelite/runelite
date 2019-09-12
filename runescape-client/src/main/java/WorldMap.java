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

@ObfuscatedName("ln")
@Implements("WorldMap")
public class WorldMap {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("fontNameVerdana11")
	static final FontName fontNameVerdana11;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("fontNameVerdana13")
	static final FontName fontNameVerdana13;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("fontNameVerdana15")
	static final FontName fontNameVerdana15;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_archive")
	AbstractArchive WorldMap_archive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_geographyArchive")
	AbstractArchive WorldMap_geographyArchive;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WorldMap_groundArchive")
	AbstractArchive WorldMap_groundArchive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("font")
	Font font;
	@ObfuscatedName("s")
	@Export("fonts")
	HashMap fonts;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("e")
	@Export("details")
	HashMap details;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	@Export("mainMapArea")
	WorldMapArea mainMapArea;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	@Export("currentMapArea")
	WorldMapArea currentMapArea;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	WorldMapArea field3962;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	@Export("worldMapManager")
	WorldMapManager worldMapManager;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("cacheLoader")
	WorldMapArchiveLoader cacheLoader;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 303275685
	)
	@Export("centerTileX")
	int centerTileX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -225681019
	)
	@Export("centerTileY")
	int centerTileY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1238415701
	)
	@Export("worldMapTargetX")
	int worldMapTargetX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -264227245
	)
	@Export("worldMapTargetY")
	int worldMapTargetY;
	@ObfuscatedName("b")
	@Export("zoom")
	float zoom;
	@ObfuscatedName("ag")
	@Export("zoomTarget")
	float zoomTarget;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -596782653
	)
	@Export("worldMapDisplayWidth")
	int worldMapDisplayWidth;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1953124645
	)
	@Export("worldMapDisplayHeight")
	int worldMapDisplayHeight;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 15596265
	)
	@Export("worldMapDisplayX")
	int worldMapDisplayX;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1826675017
	)
	@Export("worldMapDisplayY")
	int worldMapDisplayY;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 172866649
	)
	@Export("maxFlashCount")
	int maxFlashCount;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -957491597
	)
	@Export("cyclesPerFlash")
	int cyclesPerFlash;
	@ObfuscatedName("ad")
	@Export("perpetualFlash")
	boolean perpetualFlash;
	@ObfuscatedName("ap")
	@Export("flashingElements")
	HashSet flashingElements;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 168471107
	)
	@Export("flashCount")
	int flashCount;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -247291767
	)
	@Export("flashCycle")
	int flashCycle;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1300084977
	)
	int field3981;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -212325427
	)
	int field3982;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -488627691
	)
	int field3983;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -793458395
	)
	int field3987;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		longValue = -8307106057108321705L
	)
	long field3985;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -2042558413
	)
	int field3986;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -1762125431
	)
	int field3948;
	@ObfuscatedName("aq")
	boolean field3988;
	@ObfuscatedName("az")
	@Export("enabledElements")
	HashSet enabledElements;
	@ObfuscatedName("ai")
	@Export("enabledCategories")
	HashSet enabledCategories;
	@ObfuscatedName("am")
	@Export("enabledElementIds")
	HashSet enabledElementIds;
	@ObfuscatedName("aw")
	HashSet field3992;
	@ObfuscatedName("au")
	@Export("elementsDisabled")
	boolean elementsDisabled;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = -1597124293
	)
	int field3994;
	@ObfuscatedName("bk")
	@Export("menuOpcodes")
	final int[] menuOpcodes;
	@ObfuscatedName("bp")
	List field3996;
	@ObfuscatedName("bu")
	@Export("iconIterator")
	Iterator iconIterator;
	@ObfuscatedName("bi")
	HashSet field3998;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("mouseCoord")
	Coord mouseCoord;
	@ObfuscatedName("bf")
	@Export("showCoord")
	public boolean showCoord;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("sprite")
	Sprite sprite;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = 1403177589
	)
	@Export("cachedPixelsPerTile")
	int cachedPixelsPerTile;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1012368723
	)
	@Export("minCachedTileX")
	int minCachedTileX;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 428445179
	)
	@Export("minCachedTileY")
	int minCachedTileY;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -2041822163
	)
	int field4005;

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
		this.field3981 = -1;
		this.field3982 = -1;
		this.field3983 = -1;
		this.field3987 = -1;
		this.field3988 = true;
		this.enabledElements = new HashSet();
		this.enabledCategories = new HashSet();
		this.enabledElementIds = new HashSet();
		this.field3992 = new HashSet();
		this.elementsDisabled = false;
		this.field3994 = 0;
		this.menuOpcodes = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field3998 = new HashSet();
		this.mouseCoord = null;
		this.showCoord = false;
		this.minCachedTileX = -1;
		this.minCachedTileY = -1;
		this.field4005 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lkf;Ljava/util/HashMap;[Llt;B)V",
		garbageValue = "54"
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
		int var7 = this.WorldMap_archive.getGroupId(WorldMapCacheName.field294.name);
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
		this.field3962 = null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1992204657"
	)
	public void method6291() {
		class162.method3424();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIZIIIIB)V",
		garbageValue = "-58"
	)
	@Export("onCycle")
	public void onCycle(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.cacheLoader.isLoaded()) {
			this.smoothZoom();
			this.scrollToTarget();
			if (var3) {
				int var8 = (int)Math.ceil((double)((float)var6 / this.zoom));
				int var9 = (int)Math.ceil((double)((float)var7 / this.zoom));
				List var10 = this.worldMapManager.method601(this.centerTileX - var8 / 2 - 1, this.centerTileY - var9 / 2 - 1, var8 / 2 + this.centerTileX + 1, var9 / 2 + this.centerTileY + 1, var4, var5, var6, var7, var1, var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				AbstractWorldMapIcon var13;
				ScriptEvent var14;
				WorldMapEvent var15;
				for (var12 = var10.iterator(); var12.hasNext(); SecureRandomFuture.runScriptEvent(var14)) {
					var13 = (AbstractWorldMapIcon)var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
					var14.setArgs(new Object[]{var15, var1, var2});
					if (this.field3998.contains(var13)) {
						var14.setType(17);
					} else {
						var14.setType(15);
					}
				}

				var12 = this.field3998.iterator();

				while (var12.hasNext()) {
					var13 = (AbstractWorldMapIcon)var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new WorldMapEvent(var13.getElement(), var13.coord1, var13.coord2);
						var14.setArgs(new Object[]{var15, var1, var2});
						var14.setType(16);
						SecureRandomFuture.runScriptEvent(var14);
					}
				}

				this.field3998 = var11;
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIZZB)V",
		garbageValue = "45"
	)
	public void method6284(int var1, int var2, boolean var3, boolean var4) {
		long var5 = SoundCache.method2480();
		this.method6316(var1, var2, var4, var5);
		if (!this.hasTarget() && (var4 || var3)) {
			if (var4) {
				this.field3983 = var1;
				this.field3987 = var2;
				this.field3981 = this.centerTileX;
				this.field3982 = this.centerTileY;
			}

			if (this.field3981 != -1) {
				int var7 = var1 - this.field3983;
				int var8 = var2 - this.field3987;
				this.setWorldMapPosition(this.field3981 - (int)((float)var7 / this.zoomTarget), (int)((float)var8 / this.zoomTarget) + this.field3982, false);
			}
		} else {
			this.method6272();
		}

		if (var4) {
			this.field3985 = var5;
			this.field3986 = var1;
			this.field3948 = var2;
		}

	}

	@ObfuscatedName("l")
	void method6316(int var1, int var2, boolean var3, long var4) {
		if (this.currentMapArea != null) {
			int var6 = (int)((float)this.centerTileX + ((float)(var1 - this.worldMapDisplayX) - (float)this.getDisplayWith() * this.zoom / 2.0F) / this.zoom);
			int var7 = (int)((float)this.centerTileY - ((float)(var2 - this.worldMapDisplayY) - (float)this.getDisplayHeight() * this.zoom / 2.0F) / this.zoom);
			this.mouseCoord = this.currentMapArea.coord(var6 + this.currentMapArea.getRegionLowX() * 64, var7 + this.currentMapArea.getRegionLowY() * 64);
			if (this.mouseCoord != null && var3) {
				int var9;
				int var10;
				if (SecureRandomCallable.method1092() && KeyHandler.KeyHandler_pressedKeys[82] && KeyHandler.KeyHandler_pressedKeys[81]) {
					int var13 = this.mouseCoord.x;
					var9 = this.mouseCoord.y;
					var10 = this.mouseCoord.plane;
					PacketBufferNode var11 = MenuAction.getPacketBufferNode(ClientPacket.field2187, Client.packetWriter.isaacCipher);
					var11.packetBuffer.method5500(var13);
					var11.packetBuffer.writeShort(var9);
					var11.packetBuffer.method5491(var10);
					var11.packetBuffer.writeIntLE16(0);
					Client.packetWriter.addNode(var11);
				} else {
					boolean var8 = true;
					if (this.field3988) {
						var9 = var1 - this.field3986;
						var10 = var2 - this.field3948;
						if (var4 - this.field3985 > 500L || var9 < -25 || var9 > 25 || var10 < -25 || var10 > 25) {
							var8 = false;
						}
					}

					if (var8) {
						PacketBufferNode var12 = MenuAction.getPacketBufferNode(ClientPacket.field2223, Client.packetWriter.isaacCipher);
						var12.packetBuffer.writeShortLE(this.mouseCoord.packed());
						Client.packetWriter.addNode(var12);
						this.field3985 = 0L;
					}
				}
			}
		} else {
			this.mouseCoord = null;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1791757992"
	)
	@Export("smoothZoom")
	void smoothZoom() {
		if (MenuAction.field1133 != null) {
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2031541689"
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
			if (this.worldMapTargetX == this.centerTileX && this.worldMapTargetY == this.centerTileY) {
				this.worldMapTargetX = -1;
				this.worldMapTargetY = -1;
			}

		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIZB)V",
		garbageValue = "-39"
	)
	@Export("setWorldMapPosition")
	final void setWorldMapPosition(int var1, int var2, boolean var3) {
		this.centerTileX = var1;
		this.centerTileY = var2;
		SoundCache.method2480();
		if (var3) {
			this.method6272();
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1320678525"
	)
	final void method6272() {
		this.field3987 = -1;
		this.field3983 = -1;
		this.field3982 = -1;
		this.field3981 = -1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1096342718"
	)
	@Export("hasTarget")
	boolean hasTarget() {
		return this.worldMapTargetX != -1 && this.worldMapTargetY != -1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIB)Lag;",
		garbageValue = "45"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "1738744053"
	)
	public void method6275(int var1, int var2, int var3, boolean var4) {
		WorldMapArea var5 = this.mapAreaAtCoord(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.mainMapArea;
		}

		boolean var6 = false;
		if (var5 != this.field3962 || var4) {
			this.field3962 = var5;
			this.setCurrentMapArea(var5);
			var6 = true;
		}

		if (var6 || var4) {
			this.jump(var1, var2, var3);
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2088562038"
	)
	@Export("setCurrentMapAreaId")
	public void setCurrentMapAreaId(int var1) {
		WorldMapArea var2 = this.getMapArea(var1);
		if (var2 != null) {
			this.setCurrentMapArea(var2);
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-303428785"
	)
	@Export("currentMapAreaId")
	public int currentMapAreaId() {
		return this.currentMapArea == null ? -1 : this.currentMapArea.getId();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Lag;",
		garbageValue = "1"
	)
	@Export("getCurrentMapArea")
	public WorldMapArea getCurrentMapArea() {
		return this.currentMapArea;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lag;B)V",
		garbageValue = "-27"
	)
	@Export("setCurrentMapArea")
	void setCurrentMapArea(WorldMapArea var1) {
		if (this.currentMapArea == null || var1 != this.currentMapArea) {
			this.initializeWorldMapManager(var1);
			this.jump(-1, -1, -1);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lag;B)V",
		garbageValue = "63"
	)
	@Export("initializeWorldMapManager")
	void initializeWorldMapManager(WorldMapArea var1) {
		this.currentMapArea = var1;
		this.worldMapManager = new WorldMapManager(this.mapSceneSprites, this.fonts, this.WorldMap_geographyArchive, this.WorldMap_groundArchive);
		this.cacheLoader.reset(this.currentMapArea.getInternalName());
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lag;Lhj;Lhj;ZB)V",
		garbageValue = "0"
	)
	public void method6431(WorldMapArea var1, Coord var2, Coord var3, boolean var4) {
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-47"
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
			this.field3996 = null;
			this.iconIterator = null;
			this.worldMapManager.clearIcons();
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "13"
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
				if (var5 - this.field3994 > 100) {
					this.field3994 = var5;
					var10 = true;
				}

				this.worldMapManager.drawElements(this.centerTileX - var8 / 2, this.centerTileY - var9 / 2, var8 / 2 + this.centerTileX, var9 / 2 + this.centerTileY, var1, var2, var3 + var1, var2 + var4, this.field3992, this.flashingElements, this.flashCycle, this.cyclesPerFlash, var10);
			}

			this.method6341(var1, var2, var3, var4, var8, var9);
			if (SecureRandomCallable.method1092() && this.showCoord && this.mouseCoord != null) {
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
		garbageValue = "-943191584"
	)
	boolean method6419(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.sprite == null) {
			return true;
		} else if (this.sprite.subWidth == var1 && this.sprite.subHeight == var2) {
			if (this.worldMapManager.pixelsPerTile != this.cachedPixelsPerTile) {
				return true;
			} else if (this.field4005 != Client.field892) {
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-74"
	)
	void method6341(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (MenuAction.field1133 != null) {
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
			if (this.method6419(var8, var9, var13, var14, var3, var4)) {
				if (this.sprite != null && this.sprite.subWidth == var8 && this.sprite.subHeight == var9) {
					Arrays.fill(this.sprite.pixels, 0);
				} else {
					this.sprite = new Sprite(var8, var9);
				}

				this.minCachedTileX = this.getDisplayX() - var5 / 2 - var7;
				this.minCachedTileY = this.getDisplayY() - var6 / 2 - var7;
				this.cachedPixelsPerTile = this.worldMapManager.pixelsPerTile;
				MenuAction.field1133.method4296(this.minCachedTileX, this.minCachedTileY, this.sprite, (float)this.cachedPixelsPerTile / var10);
				this.field4005 = Client.field892;
				var13 = var1 - (var7 + var11 - this.minCachedTileX) * this.worldMapManager.pixelsPerTile;
				var14 = var2 - this.worldMapManager.pixelsPerTile * (var7 - (var12 - this.minCachedTileY));
			}

			Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var1, var2, var3, var4, 0, 128);
			if (var10 == 1.0F) {
				this.sprite.method6096(var13, var14, 192);
			} else {
				this.sprite.method6099(var13, var14, (int)((float)var8 * var10), (int)((float)var9 * var10), 192);
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "330665907"
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

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("setZoomPercentage")
	public void setZoomPercentage(int var1) {
		this.zoomTarget = this.getZoomFromPercentage(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "1308590489"
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(II)F",
		garbageValue = "-2084145204"
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-83"
	)
	@Export("getZoomLevel")
	public int getZoomLevel() {
		if ((double)this.zoomTarget == 1.0D) {
			return 25;
		} else if ((double)this.zoomTarget == 1.5D) {
			return 37;
		} else if (2.0D == (double)this.zoomTarget) {
			return 50;
		} else if ((double)this.zoomTarget == 3.0D) {
			return 75;
		} else {
			return (double)this.zoomTarget == 4.0D ? 100 : 200;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1483543470"
	)
	@Export("loadCache")
	public void loadCache() {
		this.cacheLoader.load();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "259244874"
	)
	@Export("isCacheLoaded")
	public boolean isCacheLoaded() {
		return this.cacheLoader.isLoaded();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(II)Lag;",
		garbageValue = "-1932249076"
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-75183731"
	)
	@Export("setWorldMapPositionTarget")
	public void setWorldMapPositionTarget(int var1, int var2) {
		if (this.currentMapArea != null && this.currentMapArea.containsPosition(var1, var2)) {
			this.worldMapTargetX = var1 - this.currentMapArea.getRegionLowX() * 64;
			this.worldMapTargetY = var2 - this.currentMapArea.getRegionLowY() * 64;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1776242940"
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
		garbageValue = "183887580"
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "283279247"
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

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1849438841"
	)
	@Export("getDisplayX")
	public int getDisplayX() {
		return this.currentMapArea == null ? -1 : this.centerTileX + this.currentMapArea.getRegionLowX() * 64;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "10636"
	)
	@Export("getDisplayY")
	public int getDisplayY() {
		return this.currentMapArea == null ? -1 : this.centerTileY + this.currentMapArea.getRegionLowY() * 64;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I)Lhj;",
		garbageValue = "1205285454"
	)
	@Export("getDisplayCoord")
	public Coord getDisplayCoord() {
		return this.currentMapArea == null ? null : this.currentMapArea.coord(this.getDisplayX(), this.getDisplayY());
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "32767"
	)
	@Export("getDisplayWith")
	public int getDisplayWith() {
		return this.worldMapDisplayWidth;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1098284021"
	)
	@Export("getDisplayHeight")
	public int getDisplayHeight() {
		return this.worldMapDisplayHeight;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "572826072"
	)
	@Export("setMaxFlashCount")
	public void setMaxFlashCount(int var1) {
		if (var1 >= 1) {
			this.maxFlashCount = var1;
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-950358190"
	)
	@Export("resetMaxFlashCount")
	public void resetMaxFlashCount() {
		this.maxFlashCount = 3;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "420340879"
	)
	@Export("setCyclesPerFlash")
	public void setCyclesPerFlash(int var1) {
		if (var1 >= 1) {
			this.cyclesPerFlash = var1;
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2062037621"
	)
	@Export("resetCyclesPerFlash")
	public void resetCyclesPerFlash() {
		this.cyclesPerFlash = 50;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "0"
	)
	@Export("setPerpetualFlash")
	public void setPerpetualFlash(boolean var1) {
		this.perpetualFlash = var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-68"
	)
	@Export("flashElement")
	public void flashElement(int var1) {
		this.flashingElements = new HashSet();
		this.flashingElements.add(var1);
		this.flashCount = 0;
		this.flashCycle = 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-774711731"
	)
	@Export("flashCategory")
	public void flashCategory(int var1) {
		this.flashingElements = new HashSet();
		this.flashCount = 0;
		this.flashCycle = 0;

		for (int var2 = 0; var2 < WorldMapElement.WorldMapElement_count; ++var2) {
			if (WorldMapSection1.WorldMapElement_get(var2) != null && WorldMapSection1.WorldMapElement_get(var2).category == var1) {
				this.flashingElements.add(WorldMapSection1.WorldMapElement_get(var2).objectId);
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1418784886"
	)
	@Export("stopCurrentFlashes")
	public void stopCurrentFlashes() {
		this.flashingElements = null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-259302748"
	)
	@Export("setElementsDisabled")
	public void setElementsDisabled(boolean var1) {
		this.elementsDisabled = !var1;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-1998188868"
	)
	@Export("disableElement")
	public void disableElement(int var1, boolean var2) {
		if (!var2) {
			this.enabledElements.add(var1);
		} else {
			this.enabledElements.remove(var1);
		}

		this.method6317();
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "51"
	)
	@Export("setCategoryDisabled")
	public void setCategoryDisabled(int var1, boolean var2) {
		if (!var2) {
			this.enabledCategories.add(var1);
		} else {
			this.enabledCategories.remove(var1);
		}

		for (int var3 = 0; var3 < WorldMapElement.WorldMapElement_count; ++var3) {
			if (WorldMapSection1.WorldMapElement_get(var3) != null && WorldMapSection1.WorldMapElement_get(var3).category == var1) {
				int var4 = WorldMapSection1.WorldMapElement_get(var3).objectId;
				if (!var2) {
					this.enabledElementIds.add(var4);
				} else {
					this.enabledElementIds.remove(var4);
				}
			}
		}

		this.method6317();
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "8"
	)
	@Export("getElementsDisabled")
	public boolean getElementsDisabled() {
		return !this.elementsDisabled;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "138663468"
	)
	@Export("isElementDisabled")
	public boolean isElementDisabled(int var1) {
		return !this.enabledElements.contains(var1);
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "194496667"
	)
	@Export("isCategoryDisabled")
	public boolean isCategoryDisabled(int var1) {
		return !this.enabledCategories.contains(var1);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "65"
	)
	void method6317() {
		this.field3992.clear();
		this.field3992.addAll(this.enabledElements);
		this.field3992.addAll(this.enabledElementIds);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "1508673538"
	)
	@Export("addElementMenuOptions")
	public void addElementMenuOptions(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.cacheLoader.isLoaded()) {
			int var7 = (int)Math.ceil((double)((float)var3 / this.zoom));
			int var8 = (int)Math.ceil((double)((float)var4 / this.zoom));
			List var9 = this.worldMapManager.method601(this.centerTileX - var7 / 2 - 1, this.centerTileY - var8 / 2 - 1, var7 / 2 + this.centerTileX + 1, var8 / 2 + this.centerTileY + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					AbstractWorldMapIcon var11 = (AbstractWorldMapIcon)var10.next();
					WorldMapElement var12 = WorldMapSection1.WorldMapElement_get(var11.getElement());
					var13 = false;

					for (int var14 = this.menuOpcodes.length - 1; var14 >= 0; --var14) {
						if (var12.menuActions[var14] != null) {
							FontName.insertMenuItemNoShift(var12.menuActions[var14], var12.menuTargetName, this.menuOpcodes[var14], var11.getElement(), var11.coord1.packed(), var11.coord2.packed());
							var13 = true;
						}
					}
				} while(!var13);

			}
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(ILhj;B)Lhj;",
		garbageValue = "13"
	)
	public Coord method6319(int var1, Coord var2) {
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
		signature = "(IILhj;Lhj;I)V",
		garbageValue = "-1682434011"
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

		SecureRandomFuture.runScriptEvent(var5);
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "(I)Lap;",
		garbageValue = "-1152647604"
	)
	@Export("iconStart")
	public AbstractWorldMapIcon iconStart() {
		if (!this.cacheLoader.isLoaded()) {
			return null;
		} else if (!this.worldMapManager.isLoaded()) {
			return null;
		} else {
			HashMap var1 = this.worldMapManager.buildIcons();
			this.field3996 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List)var2.next();
				this.field3996.addAll(var3);
			}

			this.iconIterator = this.field3996.iterator();
			return this.iconNext();
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "(I)Lap;",
		garbageValue = "770535012"
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
