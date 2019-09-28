import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class2 implements class0 {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = 1489483619
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkl;B)V",
		garbageValue = "0"
	)
	public void vmethod64(Object var1, Buffer var2) {
		this.method18((Long)var1, var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;B)Ljava/lang/Object;",
		garbageValue = "-93"
	)
	public Object vmethod55(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkl;B)V",
		garbageValue = "33"
	)
	void method18(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-620659228"
	)
	public static int method30(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("v")
	@Export("ViewportMouse_unpackX")
	public static int ViewportMouse_unpackX(long var0) {
		return (int)(var0 >>> 0 & 127L);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II)I",
		garbageValue = "-2101135652"
	)
	public static int method29(CharSequence var0, int var1) {
		return SoundCache.parseIntCustomRadix(var0, var1, true);
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(Lho;I)I",
		garbageValue = "425196182"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get(((long)var0.id << 32) + (long)var0.childIndex);
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
