import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class96 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("reflectionChecks")
	static IterableNodeDeque reflectionChecks;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lid;",
		garbageValue = "-208126476"
	)
	@Export("StructDefinition_getStructDefinition")
	public static StructDefinition StructDefinition_getStructDefinition(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructDefinition.StructDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1542678274"
	)
	static int method2314(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "72"
	)
	static final void method2307() {
		if (!ViewportMouse.ViewportMouse_false0) {
			int var0 = Scene.Scene_cameraPitchSine;
			int var1 = Scene.Scene_cameraPitchCosine;
			int var2 = Scene.Scene_cameraYawSine;
			int var3 = Scene.Scene_cameraYawCosine;
			byte var4 = 50;
			short var5 = 3500;
			int var6 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var7 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var4 / Rasterizer3D.Rasterizer3D_zoom;
			int var8 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var9 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var5 / Rasterizer3D.Rasterizer3D_zoom;
			int var10 = Rasterizer3D.method3048(var7, var4, var1, var0);
			int var11 = Rasterizer3D.method3044(var7, var4, var1, var0);
			var7 = var10;
			var10 = Rasterizer3D.method3048(var9, var5, var1, var0);
			int var12 = Rasterizer3D.method3044(var9, var5, var1, var0);
			var9 = var10;
			var10 = Rasterizer3D.method3054(var6, var11, var3, var2);
			var11 = Rasterizer3D.method3067(var6, var11, var3, var2);
			var6 = var10;
			var10 = Rasterizer3D.method3054(var8, var12, var3, var2);
			var12 = Rasterizer3D.method3067(var8, var12, var3, var2);
			class30.field261 = (var6 + var10) / 2;
			class2.field5 = (var7 + var9) / 2;
			GrandExchangeEvents.field36 = (var12 + var11) / 2;
			ViewportMouse.field1737 = (var10 - var6) / 2;
			ViewportMouse.field1739 = (var9 - var7) / 2;
			class288.field3652 = (var12 - var11) / 2;
			Frames.field1880 = Math.abs(ViewportMouse.field1737);
			class189.field2355 = Math.abs(ViewportMouse.field1739);
			class65.field603 = Math.abs(class288.field3652);
		}
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-50"
	)
	static boolean method2315(int var0) {
		return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
	}
}
