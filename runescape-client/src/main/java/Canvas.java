import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("m")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "-1870"
	)
	public static int method958(int var0) {
		return var0 >> 17 & 7;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIS)I",
		garbageValue = "-22602"
	)
	static final int method957(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = class232.method4218(var3, var5);
		int var8 = class232.method4218(var3 + 1, var5);
		int var9 = class232.method4218(var3, var5 + 1);
		int var10 = class232.method4218(var3 + 1, var5 + 1);
		int var11 = class195.method3695(var7, var8, var4, var2);
		int var12 = class195.method3695(var9, var10, var4, var2);
		return class195.method3695(var11, var12, var6, var2);
	}
}
