import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class1 implements class0 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkq;I)V",
		garbageValue = "-685052934"
	)
	public void vmethod53(Object var1, Buffer var2) {
		this.method8((Integer)var1, var2);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)Ljava/lang/Object;",
		garbageValue = "390816352"
	)
	public Object vmethod60(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkq;I)V",
		garbageValue = "-1005316457"
	)
	void method8(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)V",
		garbageValue = "-52"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = ScriptFrame.fontPlain12.lineWidth(var0, 250);
			int var6 = ScriptFrame.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
			ScriptFrame.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			GameObject.method3297(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
			if (var1) {
				IgnoreList.rasterProvider.drawFull(0, 0);
			} else {
				int var7 = var3;
				int var8 = var4;
				int var9 = var5;
				int var10 = var6;

				for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
					if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
						Client.field834[var11] = true;
					}
				}
			}

		}
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
		garbageValue = "3"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		AbstractWorldMapIcon.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}
}
