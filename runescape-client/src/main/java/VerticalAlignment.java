import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lim;"
	)
	field3172(0, 0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lim;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(2, 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lim;"
	)
	field3170(1, 2);

	@ObfuscatedName("df")
	@ObfuscatedGetter(
		longValue = 8439577585786440307L
	)
	static long field3175;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -163994147
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1741450623
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(Lho;I)Ljava/lang/String;",
		garbageValue = "-2118508660"
	)
	static String method4321(Widget var0) {
		if (class2.method30(class2.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
