import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class225 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Liv;",
		garbageValue = "-97"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1647752784"
	)
	static final void method4105() {
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
			int var10 = Rasterizer3D.method2983(var7, var4, var1, var0);
			int var11 = Rasterizer3D.method3000(var7, var4, var1, var0);
			var7 = var10;
			var10 = Rasterizer3D.method2983(var9, var5, var1, var0);
			int var12 = Rasterizer3D.method3000(var9, var5, var1, var0);
			var9 = var10;
			var10 = Rasterizer3D.method3026(var6, var11, var3, var2);
			var11 = Rasterizer3D.method2964(var6, var11, var3, var2);
			var6 = var10;
			var10 = Rasterizer3D.method3026(var8, var12, var3, var2);
			var12 = Rasterizer3D.method2964(var8, var12, var3, var2);
			ViewportMouse.field1711 = (var10 + var6) / 2;
			Ignored.field3577 = (var9 + var7) / 2;
			class222.field2726 = (var12 + var11) / 2;
			class4.field20 = (var10 - var6) / 2;
			ViewportMouse.field1712 = (var9 - var7) / 2;
			ServerBuild.field3079 = (var12 - var11) / 2;
			ArchiveLoader.field510 = Math.abs(class4.field20);
			GrandExchangeOfferUnitPriceComparator.field75 = Math.abs(ViewportMouse.field1712);
			class222.field2724 = Math.abs(ServerBuild.field3079);
		}
	}
}
