import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("li")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4026;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4029;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4025;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4028;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4027;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4024;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static final LoginType field4031;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	public static final LoginType field4032;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1653780659
	)
	final int field4033;
	@ObfuscatedName("c")
	final String field4034;

	static {
		oldscape = new LoginType(7, 0, "", "");
		field4026 = new LoginType(5, 1, "", "");
		field4029 = new LoginType(6, 2, "", "");
		field4025 = new LoginType(2, 3, "", "");
		field4028 = new LoginType(4, 4, "", "");
		field4027 = new LoginType(0, 5, "", "");
		field4024 = new LoginType(8, 6, "", "");
		field4031 = new LoginType(3, 7, "", "");
		field4032 = new LoginType(1, -1, "", "", true, new LoginType[]{oldscape, field4026, field4029, field4028, field4025});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lli;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4033 = var1;
		this.field4034 = var4;
	}

	public String toString() {
		return this.field4034;
	}
}
