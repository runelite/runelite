import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class13 {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "637886489"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		if (var1) {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var4) {
				}
			}

			if (class50.field410.startsWith("win")) {
				class216.method4017(var0, 0);
			} else if (class50.field410.startsWith("mac")) {
				GrandExchangeEvent.method79(var0, 1, "openjs");
			} else {
				class216.method4017(var0, 2);
			}
		} else {
			class216.method4017(var0, 3);
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIIIB)I",
		garbageValue = "119"
	)
	static final int method150(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "1952174760"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (MusicPatch.loadInterface(var0)) {
			ClientPacket.field2223 = null;
			UserComparator7.drawInterface(UserComparator7.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (ClientPacket.field2223 != null) {
				UserComparator7.drawInterface(ClientPacket.field2223, -1412584499, var1, var2, var3, var4, GrandExchangeEvents.field31, class81.field1126, var7);
				ClientPacket.field2223 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field833[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field833[var8] = true;
				}
			}

		}
	}
}
