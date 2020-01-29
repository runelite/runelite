import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("qm")
	@ObfuscatedGetter(
		intValue = -1887929743
	)
	static int field3660;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("eh")
	@ObfuscatedGetter(
		intValue = -1770194779
	)
	static int field3650;
	@ObfuscatedName("gt")
	@ObfuscatedGetter(
		intValue = -1472159493
	)
	static int field3663;
	@ObfuscatedName("lo")
	@ObfuscatedGetter(
		intValue = 1238804293
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;
	@ObfuscatedName("d")
	@Export("name")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "2"
	)
	public static int method5401() {
		return KeyHandler.KeyHandler_idleCycles;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1505118855"
	)
	public static void method5402() {
		KitDefinition.KitDefinition_cached.clear();
	}
}
