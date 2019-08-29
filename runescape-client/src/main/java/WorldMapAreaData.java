import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("r")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("y")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("p")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(Lky;Lky;IZI)V",
		garbageValue = "543700314"
	)
	@Export("init")
	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(Lky;ZB)V",
		garbageValue = "23"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5602();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
		garbageValue = "-101"
	)
	public static String method658(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = class14.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1956472070"
	)
	static final int method650(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}

	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2080251380"
	)
	static void method654() {
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1295 = null;
		Client.packetWriter.field1296 = null;
		Client.packetWriter.field1291 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1293 = 0;
		Client.rebootTimer = 0;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.minimapState = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		WorldMapIcon_1.localPlayer = null;

		for (var0 = 0; var0 < Client.npcs.length; ++var0) {
			NPC var1 = Client.npcs[var0];
			if (var1 != null) {
				var1.targetIndex = -1;
				var1.false0 = false;
			}
		}

		ItemContainer.itemContainers = new NodeHashTable(32);
		FloorDecoration.updateGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field703[var0] = true;
		}

		WorldMapCacheName.method593();
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-124"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0, var1, ItemContainer.plane) - var2;
			var0 -= WallDecoration.cameraX;
			var3 -= Coord.cameraY;
			var1 -= UserComparator7.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class43.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class43.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[class40.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[class40.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var5 * var3 - var4 * var1 >> 16;
			var1 = var4 * var3 + var5 * var1 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "([Lhp;Lhp;ZB)V",
		garbageValue = "84"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		ItemContainer.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			ItemContainer.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			GrandExchangeOfferNameComparator.resizeComponents(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}
}
