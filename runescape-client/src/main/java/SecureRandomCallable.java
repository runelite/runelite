import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;

	SecureRandomCallable() {
	}

	public Object call() {
		return GameShell.method1069();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Lcu;",
		garbageValue = "-120"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SoundSystem.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = Tiles.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;II)Lli;",
		garbageValue = "-210217349"
	)
	public static IndexedSprite method1151(AbstractArchive var0, int var1) {
		return !class4.method61(var0, var1) ? null : WorldMapDecoration.method327();
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(ZLkl;B)V",
		garbageValue = "-23"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			int var2 = var1.method5723();
			var3 = var1.method5582();
			var4 = var1.readUnsignedShort();
			Canvas.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					Canvas.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			WorldMapSection2.regions = new int[var4];
			SecureRandomFuture.regionMapArchiveIds = new int[var4];
			class222.regionLandArchiveIds = new int[var4];
			Projectile.regionLandArchives = new byte[var4][];
			GrandExchangeOfferOwnWorldComparator.regionMapArchives = new byte[var4][];
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
						WorldMapSection2.regions[var4] = var8;
						SecureRandomFuture.regionMapArchiveIds[var4] = AbstractWorldMapData.archive5.getGroupId("m" + var6 + "_" + var7);
						class222.regionLandArchiveIds[var4] = AbstractWorldMapData.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			UserComparator8.method3327(var3, var2, true);
		} else {
			boolean var15 = var1.method5675() == 1;
			var3 = var1.method5583();
			var4 = var1.readUnsignedShort();
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
			Canvas.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					Canvas.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			WorldMapSection2.regions = new int[var5];
			SecureRandomFuture.regionMapArchiveIds = new int[var5];
			class222.regionLandArchiveIds = new int[var5];
			Projectile.regionLandArchives = new byte[var5][];
			GrandExchangeOfferOwnWorldComparator.regionMapArchives = new byte[var5][];
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
								if (WorldMapSection2.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								WorldMapSection2.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								SecureRandomFuture.regionMapArchiveIds[var5] = AbstractWorldMapData.archive5.getGroupId("m" + var13 + "_" + var14);
								class222.regionLandArchiveIds[var5] = AbstractWorldMapData.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			UserComparator8.method3327(var4, var3, !var15);
		}

	}
}
