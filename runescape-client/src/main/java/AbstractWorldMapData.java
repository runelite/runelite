import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1032040448
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2012131328
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1049638377
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 548799015
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 974666319
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1744389767
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1592799997
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1573333695
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("i")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("d")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("m")
	byte[][][] field161;
	@ObfuscatedName("p")
	byte[][][] field157;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[[[[Ly;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("k")
	boolean field159;
	@ObfuscatedName("x")
	boolean field151;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field159 = false;
		this.field151 = false;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "1045041620"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-992891082"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field159 && this.field151;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhq;I)V",
		garbageValue = "126023316"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field159 = true;
				this.field151 = true;
			}

		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "124"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field161 = null;
		this.field157 = null;
		this.decorations = null;
		this.field159 = false;
		this.field151 = false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IILkc;I)V",
		garbageValue = "-2099963410"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method320(var1, var2, var3, var4);
			} else {
				this.method302(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IILkc;IB)V",
		garbageValue = "-1"
	)
	void method320(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IILkc;IB)V",
		garbageValue = "0"
	)
	void method302(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field161[var9][var1][var2] = (byte)(var11 >> 2);
					this.field157[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5638();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "80"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "84"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Z",
		garbageValue = "403966383"
	)
	@Export("isNumber")
	public static boolean isNumber(CharSequence var0) {
		boolean var2 = false;
		boolean var3 = false;
		int var4 = 0;
		int var5 = var0.length();
		int var6 = 0;

		boolean var1;
		while (true) {
			if (var6 >= var5) {
				var1 = var3;
				break;
			}

			label81: {
				char var7 = var0.charAt(var6);
				if (var6 == 0) {
					if (var7 == '-') {
						var2 = true;
						break label81;
					}

					if (var7 == '+') {
						break label81;
					}
				}

				int var9;
				if (var7 >= '0' && var7 <= '9') {
					var9 = var7 - '0';
				} else if (var7 >= 'A' && var7 <= 'Z') {
					var9 = var7 - '7';
				} else {
					if (var7 < 'a' || var7 > 'z') {
						var1 = false;
						break;
					}

					var9 = var7 - 'W';
				}

				if (var9 >= 10) {
					var1 = false;
					break;
				}

				if (var2) {
					var9 = -var9;
				}

				int var8 = var4 * 10 + var9;
				if (var4 != var8 / 10) {
					var1 = false;
					break;
				}

				var4 = var8;
				var3 = true;
			}

			++var6;
		}

		return var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "693586906"
	)
	public static boolean method327(int var0) {
		return (var0 >> 21 & 1) != 0;
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(ZLkf;I)V",
		garbageValue = "1158282077"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field752 = 0;
		Client.field676 = 0;
		class30.method606();
		WorldMapManager.method710(var0, var1);
		class160.method3586(var1);

		int var2;
		for (var2 = 0; var2 < Client.field752; ++var2) {
			int var3 = Client.field870[var2];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2048365157"
	)
	static void method325(int var0, int var1) {
		MenuAction var2 = StudioGame.tempMenuAction;
		GrandExchangeOfferOwnWorldComparator.menuAction(var2.argument1, var2.argument2, var2.opcode, var2.argument0, var2.action, var2.action, var0, var1);
		StudioGame.tempMenuAction = null;
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "871169152"
	)
	static final void method326(int var0) {
		if (TextureProvider.loadInterface(var0)) {
			HealthBarDefinition.drawModelComponents(Widget.Widget_interfaceComponents[var0], -1);
		}
	}
}
