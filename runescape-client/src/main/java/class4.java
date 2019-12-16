import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class4 implements class0 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkq;I)V",
		garbageValue = "-685052934"
	)
	public void vmethod53(Object var1, Buffer var2) {
		this.method51((String)var1, var2);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)Ljava/lang/Object;",
		garbageValue = "390816352"
	)
	public Object vmethod60(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkq;I)V",
		garbageValue = "1310089464"
	)
	void method51(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILhz;IIIZI)V",
		garbageValue = "-1294056256"
	)
	public static void method59(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class197.field2392 = 1;
		Coord.musicTrackArchive = var1;
		class16.musicTrackGroupId = var2;
		GrandExchangeOffer.musicTrackFileId = var3;
		class197.musicTrackVolume = var4;
		WorldMapDecoration.musicTrackBoolean = var5;
		ParamDefinition.field3275 = var0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IB)Leq;",
		garbageValue = "103"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lhz;IB)Z",
		garbageValue = "-83"
	)
	static boolean method61(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			AbstractWorldMapIcon.SpriteBuffer_decode(var2);
			return true;
		}
	}
}
