import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mx")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4049;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4051;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4052;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4057;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4059;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4055;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	static final LoginType field4056;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	public static final LoginType field4054;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 838731047
	)
	final int field4058;
	@ObfuscatedName("s")
	final String field4053;

	static {
		oldscape = new LoginType(8, 0, "", "");
		field4049 = new LoginType(3, 1, "", "");
		field4051 = new LoginType(4, 2, "", "");
		field4052 = new LoginType(5, 3, "", "");
		field4057 = new LoginType(0, 4, "", "");
		field4059 = new LoginType(7, 5, "", "");
		field4055 = new LoginType(6, 6, "", "");
		field4056 = new LoginType(2, 7, "", "");
		field4054 = new LoginType(1, -1, "", "", true, new LoginType[]{oldscape, field4049, field4051, field4057, field4052});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4058 = var1;
		this.field4053 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lmx;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4058 = var1;
		this.field4053 = var4;
	}

	public String toString() {
		return this.field4053;
	}
}
