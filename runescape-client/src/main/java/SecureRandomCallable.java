import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;

	SecureRandomCallable() {
	}

	public Object call() {
		return AttackOption.method2081();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIB)J",
		garbageValue = "0"
	)
	static long method1165(int var0, int var1, int var2) {
		return (long)(var2 << 16 | var0 << 8 | var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "19776"
	)
	public static int method1166() {
		return KeyHandler.KeyHandler_idleCycles;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ldh;IIII)Z",
		garbageValue = "810507745"
	)
	static final boolean method1163(Model var0, int var1, int var2, int var3) {
		boolean var4 = ViewportMouse.ViewportMouse_isInViewport;
		if (!var4) {
			return false;
		} else {
			int var5;
			int var6;
			int var7;
			int var8;
			int var11;
			int var12;
			int var13;
			int var16;
			int var17;
			if (!ViewportMouse.ViewportMouse_false0) {
				var5 = Scene.Scene_cameraPitchSine;
				var6 = Scene.Scene_cameraPitchCosine;
				var7 = Scene.Scene_cameraYawSine;
				var8 = Scene.Scene_cameraYawCosine;
				byte var9 = 50;
				short var10 = 3500;
				var11 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var9 / Rasterizer3D.Rasterizer3D_zoom;
				var12 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var9 / Rasterizer3D.Rasterizer3D_zoom;
				var13 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var10 / Rasterizer3D.Rasterizer3D_zoom;
				int var14 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var10 / Rasterizer3D.Rasterizer3D_zoom;
				int var15 = Rasterizer3D.method2986(var12, var9, var6, var5);
				var16 = Rasterizer3D.method2978(var12, var9, var6, var5);
				var12 = var15;
				var15 = Rasterizer3D.method2986(var14, var10, var6, var5);
				var17 = Rasterizer3D.method2978(var14, var10, var6, var5);
				var14 = var15;
				var15 = Rasterizer3D.method2984(var11, var16, var8, var7);
				var16 = Rasterizer3D.method2985(var11, var16, var8, var7);
				var11 = var15;
				var15 = Rasterizer3D.method2984(var13, var17, var8, var7);
				var17 = Rasterizer3D.method2985(var13, var17, var8, var7);
				ViewportMouse.field1707 = (var15 + var11) / 2;
				ViewportMouse.field1708 = (var12 + var14) / 2;
				ViewportMouse.field1714 = (var16 + var17) / 2;
				class96.field1304 = (var15 - var11) / 2;
				ViewportMouse.field1718 = (var14 - var12) / 2;
				ViewportMouse.field1711 = (var17 - var16) / 2;
				class222.field2729 = Math.abs(class96.field1304);
				UserComparator3.field1971 = Math.abs(ViewportMouse.field1718);
				ParamDefinition.field3287 = Math.abs(ViewportMouse.field1711);
			}

			var5 = var0.xMid + var1;
			var6 = var2 + var0.yMid;
			var7 = var3 + var0.zMid;
			var8 = var0.xMidOffset;
			var16 = var0.yMidOffset;
			var17 = var0.zMidOffset;
			var11 = ViewportMouse.field1707 - var5;
			var12 = ViewportMouse.field1708 - var6;
			var13 = ViewportMouse.field1714 - var7;
			if (Math.abs(var11) > var8 + class222.field2729) {
				return false;
			} else if (Math.abs(var12) > var16 + UserComparator3.field1971) {
				return false;
			} else if (Math.abs(var13) > var17 + ParamDefinition.field3287) {
				return false;
			} else if (Math.abs(var13 * ViewportMouse.field1718 - var12 * ViewportMouse.field1711) > var16 * ParamDefinition.field3287 + var17 * UserComparator3.field1971) {
				return false;
			} else if (Math.abs(var11 * ViewportMouse.field1711 - var13 * class96.field1304) > var17 * class222.field2729 + var8 * ParamDefinition.field3287) {
				return false;
			} else {
				return Math.abs(var12 * class96.field1304 - var11 * ViewportMouse.field1718) <= var16 * class222.field2729 + var8 * UserComparator3.field1971;
			}
		}
	}
}
