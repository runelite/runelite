import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4023;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4025;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4026;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4028;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4024;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4027;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4030;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	public static final LoginType field4031;
	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		signature = "Lcq;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1388330399
	)
	public final int field4029;
	@ObfuscatedName("c")
	final String field4033;

	static {
		oldscape = new LoginType(6, 0, "", "");
		field4023 = new LoginType(2, 1, "", "");
		field4025 = new LoginType(3, 2, "", "");
		field4026 = new LoginType(8, 3, "", "");
		field4028 = new LoginType(1, 4, "", "");
		field4024 = new LoginType(4, 5, "", "");
		field4027 = new LoginType(5, 6, "", "");
		field4030 = new LoginType(0, 7, "", "");
		field4031 = new LoginType(7, -1, "", "", true, new LoginType[]{oldscape, field4023, field4025, field4028, field4026});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4029 = var1;
		this.field4033 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lll;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4029 = var1;
		this.field4033 = var4;
	}

	public String toString() {
		return this.field4033;
	}
}
