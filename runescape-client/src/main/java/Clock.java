import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("Clock")
public abstract class Clock {
	@ObfuscatedName("ro")
	@ObfuscatedGetter(
		intValue = -578402437
	)
	static int field2036;
	@ObfuscatedName("ly")
	@ObfuscatedGetter(
		intValue = -568224545
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;

	Clock() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1605126906"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "432238723"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;Lhq;Lgg;I)Z",
		garbageValue = "654132136"
	)
	public static boolean method3641(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		class197.soundEffectsArchive = var2;
		class197.midiPcmStream = var3;
		return true;
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(ZLkf;I)V",
		garbageValue = "900111549"
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
			var2 = var1.method5646();
			int var3 = var1.readUnsignedShort();
			var4 = var1.readUnsignedShort();
			ClientPacket.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					ClientPacket.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			GrandExchangeOfferOwnWorldComparator.regions = new int[var4];
			class338.regionMapArchiveIds = new int[var4];
			WorldMapCacheName.regionLandArchiveIds = new int[var4];
			UrlRequester.regionLandArchives = new byte[var4][];
			UserComparator3.regionMapArchives = new byte[var4][];
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
						GrandExchangeOfferOwnWorldComparator.regions[var4] = var8;
						class338.regionMapArchiveIds[var4] = WorldMapRectangle.archive5.getGroupId("m" + var6 + "_" + var7);
						WorldMapCacheName.regionLandArchiveIds[var4] = WorldMapRectangle.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			WorldMapSectionType.method290(var3, var2, true);
		} else {
			var2 = var1.method5648();
			boolean var15 = var1.method5622() == 1;
			var4 = var1.method5647();
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
			ClientPacket.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					ClientPacket.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			GrandExchangeOfferOwnWorldComparator.regions = new int[var5];
			class338.regionMapArchiveIds = new int[var5];
			WorldMapCacheName.regionLandArchiveIds = new int[var5];
			UrlRequester.regionLandArchives = new byte[var5][];
			UserComparator3.regionMapArchives = new byte[var5][];
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
								if (GrandExchangeOfferOwnWorldComparator.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								GrandExchangeOfferOwnWorldComparator.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								class338.regionMapArchiveIds[var5] = WorldMapRectangle.archive5.getGroupId("m" + var13 + "_" + var14);
								WorldMapCacheName.regionLandArchiveIds[var5] = WorldMapRectangle.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			WorldMapSectionType.method290(var4, var2, !var15);
		}

	}
}
