import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Ljx;",
		garbageValue = "32"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1978694168"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljx;Ljx;I)V",
		garbageValue = "-906454666"
	)
	@Export("set")
	void set(Username var1, Username var2) {
		if (var1 == null) {
			throw new NullPointerException();
		} else {
			this.username = var1;
			this.previousUsername = var2;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Lju;B)I",
		garbageValue = "1"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-117811845"
	)
	static final int method4969(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = class13.method162(var3, var5);
		int var8 = class13.method162(var3 + 1, var5);
		int var9 = class13.method162(var3, var5 + 1);
		int var10 = class13.method162(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
		int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
		int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
		int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
		return var15;
	}
}
