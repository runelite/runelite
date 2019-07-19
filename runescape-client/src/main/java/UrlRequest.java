import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("q")
	@Export("url")
	final URL url;
	@ObfuscatedName("w")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("e")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1792198908"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-338757002"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;Lhp;I)V",
		garbageValue = "-354587299"
	)
	public static void method3317(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		Widget.Widget_archive = var0;
		ViewportMouse.Widget_modelsArchive = var1;
		class216.Widget_spritesArchive = var2;
		DirectByteArrayCopier.Widget_fontsArchive = var3;
		Widget.Widget_interfaceComponents = new Widget[Widget.Widget_archive.getGroupCount()][];
		ViewportMouse.loadedInterfaces = new boolean[Widget.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1541949649"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(IIIIZB)V",
		garbageValue = "-69"
	)
	@Export("setViewportShape")
	static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) {
			var2 = 1;
		}

		if (var3 < 1) {
			var3 = 1;
		}

		int var5 = var3 - 334;
		int var6;
		if (var5 < 0) {
			var6 = Client.field782;
		} else if (var5 >= 100) {
			var6 = Client.field651;
		} else {
			var6 = (Client.field651 - Client.field782) * var5 / 100 + Client.field782;
		}

		int var7 = var3 * var6 * 512 / (var2 * 334);
		int var8;
		int var9;
		short var17;
		if (var7 < Client.field732) {
			var17 = Client.field732;
			var6 = var17 * var2 * 334 / (var3 * 512);
			if (var6 > Client.field790) {
				var6 = Client.field790;
				var8 = var3 * var6 * 512 / (var17 * 334);
				var9 = (var2 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
				}

				var0 += var9;
				var2 -= var9 * 2;
			}
		} else if (var7 > Client.field659) {
			var17 = Client.field659;
			var6 = var17 * var2 * 334 / (var3 * 512);
			if (var6 < Client.field820) {
				var6 = Client.field820;
				var8 = var17 * var2 * 334 / (var6 * 512);
				var9 = (var3 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
				}

				var1 += var9;
				var3 -= var9 * 2;
			}
		}

		Client.viewportZoom = var3 * var6 / 334;
		if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
			int[] var16 = new int[9];

			for (var9 = 0; var9 < var16.length; ++var9) {
				int var10 = var9 * 32 + 15 + 128;
				int var11 = class40.method700(var10);
				int var12 = Rasterizer3D.Rasterizer3D_sine[var10];
				int var14 = var3 - 334;
				if (var14 < 0) {
					var14 = 0;
				} else if (var14 > 100) {
					var14 = 100;
				}

				int var15 = (Client.field908 - Client.field906) * var14 / 100 + Client.field906;
				int var13 = var15 * var11 / 256;
				var16[var9] = var12 * var13 >> 16;
			}

			Scene.Scene_buildVisiblityMap(var16, 500, 800, var2 * 334 / var3, 334);
		}

		Client.viewportOffsetX = var0;
		Client.viewportOffsetY = var1;
		Client.viewportWidth = var2;
		Client.viewportHeight = var3;
	}
}
