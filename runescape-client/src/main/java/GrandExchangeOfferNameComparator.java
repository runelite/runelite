import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("GrandExchangeOfferNameComparator")
final class GrandExchangeOfferNameComparator implements Comparator {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	static AbstractArchive field66;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lm;Lm;I)I",
		garbageValue = "1692871938"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "1206640259"
	)
	public static void method153(AbstractArchive var0) {
		VarbitDefinition.VarbitDefinition_archive = var0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SIIB)V",
		garbageValue = "-18"
	)
	@Export("sortItemsByName")
	public static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lfm;III)Ldv;",
		garbageValue = "-1644992820"
	)
	public static final PcmPlayer method151(TaskHandler var0, int var1, int var2) {
		if (UrlRequest.PcmPlayer_sampleRate == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = PcmPlayer.pcmPlayerProvider.player();
				var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
				var3.field1391 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (MenuAction.PcmPlayer_count > 0 && RunException.soundSystem == null) {
					RunException.soundSystem = new SoundSystem();
					PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(RunException.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (RunException.soundSystem != null) {
					if (RunException.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					RunException.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
