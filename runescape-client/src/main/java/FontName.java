import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("q")
	public static short[][] field3651;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("h")
	@Export("userHomeDirectory")
	public static String userHomeDirectory;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = -1325782569
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("t")
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-11"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field385 == KeyHandler.field383) {
				return false;
			} else {
				ReflectionCheck.field1307 = KeyHandler.field376[KeyHandler.field385];
				SpriteMask.field2499 = KeyHandler.field377[KeyHandler.field385];
				KeyHandler.field385 = KeyHandler.field385 + 1 & 127;
				return true;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhp;IIII)V",
		garbageValue = "452430417"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2623 == null) {
			throw new RuntimeException();
		} else {
			var0.field2623[var1] = var2;
			var0.field2581[var1] = var3;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(CII)Ljava/lang/String;",
		garbageValue = "993620587"
	)
	static String method5230(char var0, int var1) {
		char[] var2 = new char[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var2[var3] = var0;
		}

		return new String(var2);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1040867769"
	)
	@Export("ObjectDefinition_clearCached")
	public static void ObjectDefinition_clearCached() {
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
	}
}
