import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final PrivateChatMode field3801;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	public static final PrivateChatMode field3806;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final PrivateChatMode field3803;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("ItemDefinition_archive")
	public static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1679462339
	)
	public final int field3804;

	static {
		field3801 = new PrivateChatMode(0);
		field3806 = new PrivateChatMode(1);
		field3803 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3804 = var1;
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(Lhe;B)Ljava/lang/String;",
		garbageValue = "70"
	)
	static String method5965(Widget var0) {
		if (WorldMapRectangle.method388(ScriptEvent.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
