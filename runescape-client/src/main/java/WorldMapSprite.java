import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 877299001
	)
	public static int field222;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("j")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "557817784"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var2 * 64 + var1];
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lhv;",
		garbageValue = "20035292"
	)
	public static StudioGame[] method402() {
		return new StudioGame[]{StudioGame.game3, StudioGame.stellardawn, StudioGame.runescape, StudioGame.game5, StudioGame.game4, StudioGame.oldscape};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIZII)J",
		garbageValue = "-519528973"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lee;",
		garbageValue = "836090120"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			AbstractArchive var3 = SequenceDefinition.SequenceDefinition_animationsArchive;
			AbstractArchive var4 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
			boolean var5 = true;
			int[] var6 = var3.getGroupFileIds(var0);

			for (int var7 = 0; var7 < var6.length; ++var7) {
				byte[] var8 = var3.getFile(var0, var6[var7]);
				if (var8 == null) {
					var5 = false;
				} else {
					int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
					byte[] var10 = var4.getFile(var9, 0);
					if (var10 == null) {
						var5 = false;
					}
				}
			}

			Frames var2;
			if (!var5) {
				var2 = null;
			} else {
				try {
					var2 = new Frames(var3, var4, var0, false);
				} catch (Exception var12) {
					var2 = null;
				}
			}

			if (var2 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var2, (long)var0);
			}

			return var2;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1767054771"
	)
	static final boolean method404(int var0, int var1) {
		ObjectDefinition var2 = class215.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4505(var1);
	}
}
