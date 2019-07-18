import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class191 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	static final class191 field2365;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	static final class191 field2362;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	static final class191 field2364;
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;

	static {
		field2365 = new class191();
		field2362 = new class191();
		field2364 = new class191();
	}

	class191() {
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-474414027"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (class162.loadInterface(var0)) {
			WorldMapIcon_1.field188 = null;
			FontName.drawInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (WorldMapIcon_1.field188 != null) {
				FontName.drawInterface(WorldMapIcon_1.field188, -1412584499, var1, var2, var3, var4, WorldMapDecorationType.field2742, ClientPacket.field2305, var7);
				WorldMapIcon_1.field188 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field843[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field843[var8] = true;
				}
			}

		}
	}
}
