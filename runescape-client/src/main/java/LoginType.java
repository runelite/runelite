import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4030;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4032;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4027;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4028;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4025;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4026;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static final LoginType field4031;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	public static final LoginType field4024;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -295742569
	)
	final int field4033;
	@ObfuscatedName("n")
	final String field4034;

	static {
		oldscape = new LoginType(6, 0, "", "");
		field4030 = new LoginType(1, 1, "", "");
		field4032 = new LoginType(8, 2, "", "");
		field4027 = new LoginType(0, 3, "", "");
		field4028 = new LoginType(3, 4, "", "");
		field4025 = new LoginType(7, 5, "", "");
		field4026 = new LoginType(4, 6, "", "");
		field4031 = new LoginType(2, 7, "", "");
		field4024 = new LoginType(5, -1, "", "", true, new LoginType[]{oldscape, field4030, field4032, field4028, field4027});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lll;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	public String toString() {
		return this.field4034;
	}

	public String aai() {
		return this.field4034;
	}

	public String aan() {
		return this.field4034;
	}

	public String aar() {
		return this.field4034;
	}
}
