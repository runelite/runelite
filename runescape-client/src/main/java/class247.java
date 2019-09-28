import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class247 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1617248140"
	)
	static String method4455(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1170068749"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "(IIIZB)V",
		garbageValue = "-73"
	)
	@Export("resizeComponents")
	static final void resizeComponents(int var0, int var1, int var2, boolean var3) {
		if (WorldMapData_0.loadInterface(var0)) {
			FaceNormal.resizeInterface(UserComparator5.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}
}
