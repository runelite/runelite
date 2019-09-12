import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljt;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljt;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)Ljt;",
		garbageValue = "1555546597"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1766346006"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1018058811"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)V",
		garbageValue = "2051055931"
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ljw;B)I",
		garbageValue = "-92"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}
}
