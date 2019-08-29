import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class191 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	static final class191 field2347;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	static final class191 field2345;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	static final class191 field2346;

	static {
		field2347 = new class191();
		field2345 = new class191();
		field2346 = new class191();
	}

	class191() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lhh;",
		garbageValue = "-1783232348"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_normal, PlayerType.PlayerType_ironman, PlayerType.PlayerType_playerModerator};
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(IIIILls;Lhg;B)V",
		garbageValue = "34"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var9 * var2 + var3 * var8 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6020(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
