import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class232 {
	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "[Lle;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1236815068"
	)
	static final int method4218(int var0, int var1) {
		int var2 = class4.method63(var0 - 1, var1 - 1) + class4.method63(1 + var0, var1 - 1) + class4.method63(var0 - 1, var1 + 1) + class4.method63(var0 + 1, var1 + 1);
		int var3 = class4.method63(var0 - 1, var1) + class4.method63(1 + var0, var1) + class4.method63(var0, var1 - 1) + class4.method63(var0, 1 + var1);
		int var4 = class4.method63(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}
}
