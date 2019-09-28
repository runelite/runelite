import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Ljq;",
		garbageValue = "827230801"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-835299696"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "116"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljq;Ljq;I)V",
		garbageValue = "-1357976341"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljh;I)I",
		garbageValue = "-531306911"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}
}
