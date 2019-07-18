import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	public static final LoginType field4052;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4049;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4050;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4051;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4058;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4053;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4054;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	static final LoginType field4055;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	public static final LoginType field4056;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1957513145
	)
	final int field4057;
	@ObfuscatedName("m")
	final String field4048;

	static {
		field4052 = new LoginType(0, 0, "", "");
		field4049 = new LoginType(3, 1, "", "");
		field4050 = new LoginType(4, 2, "", "");
		field4051 = new LoginType(7, 3, "", "");
		field4058 = new LoginType(5, 4, "", "");
		field4053 = new LoginType(8, 5, "", "");
		field4054 = new LoginType(1, 6, "", "");
		field4055 = new LoginType(6, 7, "", "");
		field4056 = new LoginType(2, -1, "", "", true, new LoginType[]{field4052, field4049, field4050, field4058, field4051});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4057 = var1;
		this.field4048 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lmu;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4057 = var1;
		this.field4048 = var4;
	}

	public String toString() {
		return this.field4048;
	}
}
