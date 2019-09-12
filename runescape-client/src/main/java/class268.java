import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class268 {
	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1779178582"
	)
	static void method4967() {
		if (Client.field824 && Varps.localPlayer != null) {
			int var0 = Varps.localPlayer.pathX[0];
			int var1 = Varps.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			SecureRandomFuture.oculusOrbFocalPointX = Varps.localPlayer.x * -78439701;
			int var2 = WorldMapAreaData.getTileHeight(Varps.localPlayer.x * -78439701, Varps.localPlayer.y, MouseRecorder.plane) - Client.camFollowHeight * 172735687;
			if (var2 < class65.field580 * 1615694975) {
				class65.field580 = var2 * -59362433;
			}

			AbstractByteArrayCopier.oculusOrbFocalPointY = Varps.localPlayer.y;
			Client.field824 = false;
		}

	}
}
