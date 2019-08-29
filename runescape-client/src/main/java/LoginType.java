import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4025;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4026;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4034;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4028;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4027;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4030;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	static final LoginType field4029;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	public static final LoginType field4032;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -327526177
	)
	final int field4033;
	@ObfuscatedName("f")
	final String field4024;

	static {
		oldscape = new LoginType(7, 0, "", "");
		field4025 = new LoginType(8, 1, "", "");
		field4026 = new LoginType(0, 2, "", "");
		field4034 = new LoginType(2, 3, "", "");
		field4028 = new LoginType(5, 4, "", "");
		field4027 = new LoginType(1, 5, "", "");
		field4030 = new LoginType(3, 6, "", "");
		field4029 = new LoginType(6, 7, "", "");
		field4032 = new LoginType(4, -1, "", "", true, new LoginType[]{oldscape, field4025, field4026, field4028, field4034});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4033 = var1;
		this.field4024 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llu;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4033 = var1;
		this.field4024 = var4;
	}

	public String toString() {
		return this.field4024;
	}

	public String abd() {
		return this.field4024;
	}

	public String abb() {
		return this.field4024;
	}
}
