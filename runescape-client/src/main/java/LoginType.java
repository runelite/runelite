import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mv")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4034;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4030;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4031;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4032;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4033;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4028;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	static final LoginType field4035;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	public static final LoginType field4029;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1632113899
	)
	final int field4037;
	@ObfuscatedName("p")
	final String field4038;

	static {
		oldscape = new LoginType(0, 0, "", "");
		field4034 = new LoginType(2, 1, "", "");
		field4030 = new LoginType(7, 2, "", "");
		field4031 = new LoginType(8, 3, "", "");
		field4032 = new LoginType(4, 4, "", "");
		field4033 = new LoginType(6, 5, "", "");
		field4028 = new LoginType(5, 6, "", "");
		field4035 = new LoginType(3, 7, "", "");
		field4029 = new LoginType(1, -1, "", "", true, new LoginType[]{oldscape, field4034, field4030, field4032, field4031});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4037 = var1;
		this.field4038 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lmv;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4037 = var1;
		this.field4038 = var4;
	}

	public String toString() {
		return this.field4038;
	}
}
