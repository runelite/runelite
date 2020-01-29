import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[[Lhn;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("fs")
	@ObfuscatedGetter(
		longValue = 2387271044298976721L
	)
	static long field250;
	@ObfuscatedName("c")
	@Export("text")
	String text;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2063978581
	)
	@Export("width")
	int width;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1586627561
	)
	@Export("height")
	int height;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILq;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "104"
	)
	public static int method440(int var0, int var1) {
		int var2 = var0 >>> 31;
		return (var0 + var2) / var1 - var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "43"
	)
	static final void method439() {
		class60.method1188("You can't add yourself to your own friend list");
	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(Lia;Ljava/lang/String;I)V",
		garbageValue = "16711680"
	)
	static void method438(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field813 += var2.groupCount;
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(ZLks;I)V",
		garbageValue = "-1660108888"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var2;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			var2 = var1.method5740();
			int var3 = var1.readUnsignedShort();
			var4 = var1.readUnsignedShort();
			JagexCache.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					JagexCache.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			FriendsList.regions = new int[var4];
			class30.regionMapArchiveIds = new int[var4];
			class65.regionLandArchiveIds = new int[var4];
			Tiles.regionLandArchives = new byte[var4][];
			class226.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
				var16 = true;
			}

			if (var3 / 8 == 48 && var2 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						FriendsList.regions[var4] = var8;
						class30.regionMapArchiveIds[var4] = NetSocket.archive5.getGroupId("m" + var6 + "_" + var7);
						class65.regionLandArchiveIds[var4] = NetSocket.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			ChatChannel.method2302(var3, var2, true);
		} else {
			var2 = var1.method5614();
			boolean var15 = var1.method5605() == 1;
			var4 = var1.method5762();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			JagexCache.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					JagexCache.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			FriendsList.regions = new int[var5];
			class30.regionMapArchiveIds = new int[var5];
			class65.regionLandArchiveIds = new int[var5];
			Tiles.regionLandArchives = new byte[var5][];
			class226.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (FriendsList.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								FriendsList.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								class30.regionMapArchiveIds[var5] = NetSocket.archive5.getGroupId("m" + var13 + "_" + var14);
								class65.regionLandArchiveIds[var5] = NetSocket.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			ChatChannel.method2302(var2, var4, !var15);
		}

	}
}
