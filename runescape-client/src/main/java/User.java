import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ljb;",
		garbageValue = "167641861"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-1"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljb;Ljb;I)V",
		garbageValue = "1613117622"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljr;B)I",
		garbageValue = "41"
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
		signature = "(II)Lkc;",
		garbageValue = "-1233621276"
	)
	public static PrivateChatMode method5131(int var0) {
		PrivateChatMode[] var1 = TileItemPile.method2810();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PrivateChatMode var3 = var1[var2];
			if (var0 == var3.field3795) {
				return var3;
			}
		}

		return null;
	}
}
