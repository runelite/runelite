import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class173 {
	@ObfuscatedName("t")
	@Export("directions")
	static int[][] directions;
	@ObfuscatedName("g")
	@Export("distances")
	static int[][] distances;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2098626243
	)
	static int field2063;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -300293519
	)
	static int field2068;
	@ObfuscatedName("v")
	@Export("bufferX")
	static int[] bufferX;
	@ObfuscatedName("d")
	@Export("bufferY")
	static int[] bufferY;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("ed")
	@ObfuscatedGetter(
		intValue = -1734851163
	)
	static int field2069;
	@ObfuscatedName("ke")
	@ObfuscatedGetter(
		intValue = -1496378761
	)
	@Export("menuWidth")
	static int menuWidth;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1761278066"
	)
	public static void method3575(boolean var0) {
		if (NetCache.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3);
				var1.writeMedium(0);
				NetCache.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var3) {
				}

				++NetCache.NetCache_ioExceptions;
				NetCache.NetCache_socket = null;
			}

		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lev;",
		garbageValue = "-691724991"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			var1 = class51.method852(SequenceDefinition.SequenceDefinition_animationsArchive, SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
			if (var1 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var1, (long)var0);
			}

			return var1;
		}
	}
}
