import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class83 {
	@ObfuscatedName("c")
	static final BigInteger field1142;
	@ObfuscatedName("x")
	static final BigInteger field1139;
	@ObfuscatedName("kc")
	@ObfuscatedGetter(
		intValue = 2081723437
	)
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("lk")
	@ObfuscatedGetter(
		intValue = 670190247
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;

	static {
		field1142 = new BigInteger("10001", 16);
		field1139 = new BigInteger("f8a2c48a898ebf7a2a5069193f0c6798757879d298af09a6fa94e569d45b09f67aeef8e6bb8a61650d597c743104fdef7d07b24af92df6be995877e9a7dd6a630d3e62c14e70427b959ff70735f96135d73434e73aabbd6aa8cf0b97dae7e2b6b70e646ff550b0ad8a4d8d18675714e5228b026d85e8f2f24607ba69d7404571", 16);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Liw;",
		garbageValue = "-2100671163"
	)
	@Export("SequenceDefinition_get")
	public static SequenceDefinition SequenceDefinition_get(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		signature = "(Lhy;III)V",
		garbageValue = "858308141"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && WorldMapLabel.method382(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = WorldMapLabel.method382(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				ArchiveLoader.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var3 = WorldMapCacheName.getNewestMenuIdx();
				if (var3 != -1) {
					UserComparator3.method3399(var3);
				}

			}
		}
	}
}
