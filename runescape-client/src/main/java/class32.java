import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class32 {
	@ObfuscatedName("sz")
	@ObfuscatedGetter(
		intValue = -1121998199
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("i")
	static byte[][][] field282;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lcm;"
	)
	@Export("pcmPlayerProvider")
	public static class99 pcmPlayerProvider;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	static Widget field284;

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-914576641"
	)
	public static int method545(int var0) {
		return var0 >> 17 & 7;
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "994421183"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = ScriptEvent.getTileHeight(var0, var1, class42.plane) - var2;
			var0 -= PacketBuffer.cameraX;
			var3 -= class43.cameraY;
			var1 -= class1.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[GrandExchangeOfferNameComparator.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[GrandExchangeOfferNameComparator.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[Interpreter.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[Interpreter.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var3 * var5 - var4 * var1 >> 16;
			var1 = var5 * var1 + var4 * var3 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = Client.viewportHeight / 2 + var8 * Client.viewportZoom / var1;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}
}
