import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class16 {
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -367363475
	)
	@Export("musicTrackGroupId")
	static int musicTrackGroupId;
	@ObfuscatedName("ly")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Lcu;",
		garbageValue = "1224179540"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = WorldMapDecorationType.method4085(var1, var0);
		Script var5 = (Script)Script.Script_cached.get((long)(var3 << 16));
		Script var4;
		if (var5 != null) {
			var4 = var5;
		} else {
			String var6 = String.valueOf(var3);
			int var7 = SoundSystem.archive12.getGroupId(var6);
			if (var7 == -1) {
				var4 = null;
			} else {
				label56: {
					byte[] var8 = SoundSystem.archive12.takeFileFlat(var7);
					if (var8 != null) {
						if (var8.length <= 1) {
							var4 = null;
							break label56;
						}

						var5 = Tiles.newScript(var8);
						if (var5 != null) {
							Script.Script_cached.put(var5, (long)(var3 << 16));
							var4 = var5;
							break label56;
						}
					}

					var4 = null;
				}
			}
		}

		if (var4 != null) {
			return var4;
		} else {
			int var12 = (var2 + 40000 << 8) + var0;
			Script var14 = (Script)Script.Script_cached.get((long)(var12 << 16));
			Script var13;
			if (var14 != null) {
				var13 = var14;
			} else {
				String var9 = String.valueOf(var12);
				int var10 = SoundSystem.archive12.getGroupId(var9);
				if (var10 == -1) {
					var13 = null;
				} else {
					byte[] var11 = SoundSystem.archive12.takeFileFlat(var10);
					if (var11 != null) {
						if (var11.length <= 1) {
							var13 = null;
							return var13 != null ? var13 : null;
						}

						var14 = Tiles.newScript(var11);
						if (var14 != null) {
							Script.Script_cached.put(var14, (long)(var12 << 16));
							var13 = var14;
							return var13 != null ? var13 : null;
						}
					}

					var13 = null;
				}
			}

			return var13 != null ? var13 : null;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1669945639"
	)
	public static void method179() {
		ParamDefinition.ParamDefinition_cached.clear();
	}
}
