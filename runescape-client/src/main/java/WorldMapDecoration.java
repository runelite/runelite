import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("kw")
	@ObfuscatedGetter(
		intValue = -1785453027
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -865323619
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1850610867
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1741054453
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("z")
	static boolean method346(long var0) {
		return Client.method1708(var0) == 2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)[Lgw;",
		garbageValue = "1443955115"
	)
	public static class185[] method348() {
		return new class185[]{class185.field2299, class185.field2300, class185.field2298, class185.field2297, class185.field2295, class185.field2296, class185.field2301, class185.field2302, class185.field2303, class185.field2304};
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-9791286"
	)
	static int method344(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lie;IIIBZI)V",
		garbageValue = "199205492"
	)
	@Export("requestNetFile")
	static void requestNetFile(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
		long var6 = (long)((var1 << 16) + var2);
		NetFileRequest var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.get(var6);
		if (var8 == null) {
			var8 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var6);
			if (var8 == null) {
				var8 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var6);
				if (var8 != null) {
					if (var5) {
						var8.removeDual();
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						--NetCache.NetCache_pendingWritesCount;
						++NetCache.NetCache_pendingPriorityWritesCount;
					}

				} else {
					if (!var5) {
						var8 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var6);
						if (var8 != null) {
							return;
						}
					}

					var8 = new NetFileRequest();
					var8.archive = var0;
					var8.crc = var3;
					var8.padding = var4;
					if (var5) {
						NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
						++NetCache.NetCache_pendingPriorityWritesCount;
					} else {
						NetCache.NetCache_pendingWritesQueue.addFirst(var8);
						NetCache.NetCache_pendingWrites.put(var8, var6);
						++NetCache.NetCache_pendingWritesCount;
					}

				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-917346374"
	)
	static void method349() {
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "2081647418"
	)
	static final int method347(int var0, int var1) {
		int var2 = WorldMapLabelSize.method202(45365 + var0, var1 + 91923, 4) - 128 + (WorldMapLabelSize.method202(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (WorldMapLabelSize.method202(var0, var1, 1) - 128 >> 2);
		var2 = (int)((double)var2 * 0.3D) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lcf;B)V",
		garbageValue = "0"
	)
	public static final void method345(PcmPlayerProvider var0) {
		PcmPlayer.pcmPlayerProvider = var0;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "71"
	)
	protected static final void method343() {
		GameShell.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.clientTickTimes[var0] = 0L;
		}

		GameShell.gameCyclesToDo = 0;
	}
}
