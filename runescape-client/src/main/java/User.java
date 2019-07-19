import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("jd")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)Ljv;",
		garbageValue = "-156755920"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "92130807"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1677107583"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljv;Ljv;B)V",
		garbageValue = "46"
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

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1938562722"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
		garbageValue = "-811282980"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}
}
