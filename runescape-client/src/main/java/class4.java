import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class4 implements class0 {
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -905472929
	)
	static int field26;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	@Export("NetCache_reference")
	static Buffer NetCache_reference;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkp;B)V",
		garbageValue = "95"
	)
	public void vmethod55(Object var1, Buffer var2) {
		this.method54((String)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/Object;",
		garbageValue = "1665636232"
	)
	public Object vmethod53(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkp;I)V",
		garbageValue = "1837357255"
	)
	void method54(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1447651687"
	)
	static int method57() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lbw;I)V",
		garbageValue = "1307142310"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		WorldMapID.runScript(var0, 500000);
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2068371159"
	)
	static final void method64() {
		int var0 = ArchiveDiskAction.menuX;
		int var1 = SecureRandomCallable.menuY;
		int var2 = InterfaceParent.menuWidth;
		int var3 = Message.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		class1.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		int var7;
		int var8;
		int var9;
		for (var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			var8 = var1 + (Client.menuOptionsCount - 1 - var7) * 15 + 31;
			var9 = 16777215;
			if (var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			class1.fontBold12.draw(VerticalAlignment.method4426(var7), var0 + 3, var8, var9, 0);
		}

		var7 = ArchiveDiskAction.menuX;
		var8 = SecureRandomCallable.menuY;
		var9 = InterfaceParent.menuWidth;
		int var10 = Message.menuHeight;

		for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
			if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) {
				Client.field852[var11] = true;
			}
		}

	}
}
