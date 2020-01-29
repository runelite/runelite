import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	static final PrivateChatMode field3788;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	public static final PrivateChatMode field3790;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	static final PrivateChatMode field3789;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1866307707
	)
	public final int field3787;

	static {
		field3788 = new PrivateChatMode(0);
		field3790 = new PrivateChatMode(1);
		field3789 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3787 = var1;
	}

	@ObfuscatedName("ld")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-78"
	)
	static void method5952() {
		if (Client.field728 && class192.localPlayer != null) {
			int var0 = class192.localPlayer.pathX[0];
			int var1 = class192.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			PendingSpawn.oculusOrbFocalPointX = class192.localPlayer.x;
			int var2 = WorldMapSectionType.getTileHeight(class192.localPlayer.x, class192.localPlayer.y, Clock.Client_plane) - Client.camFollowHeight;
			if (var2 < WorldMapSectionType.field166) {
				WorldMapSectionType.field166 = var2;
			}

			Skeleton.oculusOrbFocalPointY = class192.localPlayer.y;
			Client.field728 = false;
		}

	}
}
