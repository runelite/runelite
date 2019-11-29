import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
public enum class312 implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3814(5, 0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3811(3, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3810(0, 5),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3813(1, 6),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3815(4, 7),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	field3816(2, 8);

	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -348490887
	)
	final int field3812;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1264543599
	)
	@Export("id")
	final int id;

	class312(int var3, int var4) {
		this.field3812 = var3;
		this.id = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-847322953"
	)
	static void method6006() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (UserComparator3.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = FloorDecoration.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = Language.getWidget(var4);
					if (var5 != null) {
						ScriptEvent.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
