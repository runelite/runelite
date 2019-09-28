import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class162 implements class161 {
	@ObfuscatedName("m")
	@Export("ItemDefinition_inMembersWorld")
	static boolean ItemDefinition_inMembersWorld;
	@ObfuscatedName("s")
	public static String field1990;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static Bounds field1988;

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1376590669"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}
}
