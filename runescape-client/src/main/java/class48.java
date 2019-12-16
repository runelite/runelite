import java.util.Date;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class48 {
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	static ServerBuild field402;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive11")
	static Archive archive11;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("f")
	public static String method864(long var0) {
		Calendar.Calendar_calendar.setTime(new Date(var0));
		int var2 = Calendar.Calendar_calendar.get(7);
		int var3 = Calendar.Calendar_calendar.get(5);
		int var4 = Calendar.Calendar_calendar.get(2);
		int var5 = Calendar.Calendar_calendar.get(1);
		int var6 = Calendar.Calendar_calendar.get(11);
		int var7 = Calendar.Calendar_calendar.get(12);
		int var8 = Calendar.Calendar_calendar.get(13);
		return Calendar.DAYS_OF_THE_WEEK[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lif;IB)V",
		garbageValue = "114"
	)
	static void method862(Archive var0, int var1) {
		if (NetCache.NetCache_reference != null) {
			NetCache.NetCache_reference.offset = var1 * 8 + 5;
			int var2 = NetCache.NetCache_reference.readInt();
			int var3 = NetCache.NetCache_reference.readInt();
			var0.loadIndex(var2, var3);
		} else {
			class226.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var1] = var0;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "([BIIIIIII[Lfp;I)V",
		garbageValue = "264841801"
	)
	static final void method858(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionMap[] var8) {
		int var10;
		for (int var9 = 0; var9 < 8; ++var9) {
			for (var10 = 0; var10 < 8; ++var10) {
				if (var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
					int[] var10000 = var8[var1].flags[var9 + var2];
					var10000[var10 + var3] &= -16777217;
				}
			}
		}

		Buffer var20 = new Buffer(var0);

		for (var10 = 0; var10 < 4; ++var10) {
			for (int var11 = 0; var11 < 64; ++var11) {
				for (int var12 = 0; var12 < 64; ++var12) {
					if (var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
						int var17 = var11 & 7;
						int var18 = var12 & 7;
						int var19 = var7 & 3;
						int var16;
						if (var19 == 0) {
							var16 = var17;
						} else if (var19 == 1) {
							var16 = var18;
						} else if (var19 == 2) {
							var16 = 7 - var17;
						} else {
							var16 = 7 - var18;
						}

						PrivateChatMode.loadTerrain(var20, var1, var16 + var2, var3 + class206.method3926(var11 & 7, var12 & 7, var7), 0, 0, var7);
					} else {
						PrivateChatMode.loadTerrain(var20, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-767929178"
	)
	static int method861() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field629;
		} else {
			return 10000;
		}
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(IZZZI)Lif;",
		garbageValue = "959698373"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, AttackOption.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, WorldMapRectangle.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "197920071"
	)
	static void method859(Buffer var0, int var1) {
		byte[] var2 = var0.array;
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class300.writeRandomDat(var2, var1, Client.randomDatData, 0, 24);
		class160.method3432(var0, var1);
	}
}
