import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("v")
	static boolean field3583;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)Ljz;",
		garbageValue = "-7"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1147653243"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "403246047"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)V",
		garbageValue = "1456948401"
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljk;I)I",
		garbageValue = "-746331144"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}
}
