import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class208 {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1981461029
	)
	@Export("RunException_revision")
	public static int RunException_revision;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "10000"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.decode(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILhd;ZI)V",
		garbageValue = "-1500859521"
	)
	static void method3893(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = LoginScreenAnimation.getWorldMap().getMapArea(var0);
		int var4 = WorldMapIcon_1.localPlayer.plane;
		int var5 = PacketWriter.baseX * 64 + (WorldMapIcon_1.localPlayer.x >> 7);
		int var6 = RouteStrategy.baseY * 64 + (WorldMapIcon_1.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		LoginScreenAnimation.getWorldMap().method6199(var3, var7, var1, var2);
	}
}
