import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class3 implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	public static final class3 field13;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	public static final class3 field7;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	public static final class3 field10;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1439803863
	)
	final int field9;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 115854395
	)
	public final int field12;
	@ObfuscatedName("u")
	public final Class field11;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lc;"
	)
	public final class0 field8;

	static {
		field13 = new class3(2, 0, Integer.class, new class1());
		field7 = new class3(0, 1, Long.class, new class2());
		field10 = new class3(1, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lc;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field9 = var1;
		this.field12 = var2;
		this.field11 = var3;
		this.field8 = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field12;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)Ljava/lang/Object;",
		garbageValue = "-1191567390"
	)
	public Object method37(Buffer var1) {
		return this.field8.vmethod41(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1891869764"
	)
	static void method38() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			KeyHandler.KeyHandler_keyCodes[186] = 57;
			KeyHandler.KeyHandler_keyCodes[187] = 27;
			KeyHandler.KeyHandler_keyCodes[188] = 71;
			KeyHandler.KeyHandler_keyCodes[189] = 26;
			KeyHandler.KeyHandler_keyCodes[190] = 72;
			KeyHandler.KeyHandler_keyCodes[191] = 73;
			KeyHandler.KeyHandler_keyCodes[192] = 58;
			KeyHandler.KeyHandler_keyCodes[219] = 42;
			KeyHandler.KeyHandler_keyCodes[220] = 74;
			KeyHandler.KeyHandler_keyCodes[221] = 43;
			KeyHandler.KeyHandler_keyCodes[222] = 59;
			KeyHandler.KeyHandler_keyCodes[223] = 28;
		} else {
			KeyHandler.KeyHandler_keyCodes[44] = 71;
			KeyHandler.KeyHandler_keyCodes[45] = 26;
			KeyHandler.KeyHandler_keyCodes[46] = 72;
			KeyHandler.KeyHandler_keyCodes[47] = 73;
			KeyHandler.KeyHandler_keyCodes[59] = 57;
			KeyHandler.KeyHandler_keyCodes[61] = 27;
			KeyHandler.KeyHandler_keyCodes[91] = 42;
			KeyHandler.KeyHandler_keyCodes[92] = 74;
			KeyHandler.KeyHandler_keyCodes[93] = 43;
			KeyHandler.KeyHandler_keyCodes[192] = 28;
			KeyHandler.KeyHandler_keyCodes[222] = 58;
			KeyHandler.KeyHandler_keyCodes[520] = 59;
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1992850918"
	)
	static void method30() {
		if (MenuAction.field1133 != null) {
			Client.field892 = Client.cycle;
			MenuAction.field1133.method4295();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					MenuAction.field1133.method4319(class4.baseX * 64 + (Client.players[var0].x * -78439701 >> 7), ScriptEvent.baseY + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
