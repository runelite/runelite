import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4024;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4025;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4026;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4027;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4028;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4029;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	static final LoginType field4030;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	public static final LoginType field4031;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1453765621
	)
	final int field4032;
	@ObfuscatedName("k")
	final String field4033;

	static {
		oldscape = new LoginType(5, 0, "", "");
		field4024 = new LoginType(1, 1, "", "");
		field4025 = new LoginType(7, 2, "", "");
		field4026 = new LoginType(0, 3, "", "");
		field4027 = new LoginType(4, 4, "", "");
		field4028 = new LoginType(6, 5, "", "");
		field4029 = new LoginType(3, 6, "", "");
		field4030 = new LoginType(2, 7, "", "");
		field4031 = new LoginType(8, -1, "", "", true, new LoginType[]{oldscape, field4024, field4025, field4027, field4026});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4032 = var1;
		this.field4033 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llg;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4032 = var1;
		this.field4033 = var4;
	}

	public String toString() {
		return this.field4033;
	}
}
