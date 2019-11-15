import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ln")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4025;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4031;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4029;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4028;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4027;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4030;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	static final LoginType field4026;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	public static final LoginType field4032;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -812459159
	)
	final int field4033;
	@ObfuscatedName("m")
	final String field4034;

	static {
		oldscape = new LoginType(4, 0, "", "");
		field4025 = new LoginType(1, 1, "", "");
		field4031 = new LoginType(2, 2, "", "");
		field4029 = new LoginType(5, 3, "", "");
		field4028 = new LoginType(0, 4, "", "");
		field4027 = new LoginType(8, 5, "", "");
		field4030 = new LoginType(6, 6, "", "");
		field4026 = new LoginType(7, 7, "", "");
		field4032 = new LoginType(3, -1, "", "", true, new LoginType[]{oldscape, field4025, field4031, field4028, field4029});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lln;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	public String toString() {
		return this.field4034;
	}
}
