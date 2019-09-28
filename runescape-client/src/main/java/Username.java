import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("z")
	@Export("name")
	String name;
	@ObfuscatedName("n")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lli;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		this.cleanName = ScriptEvent.method1198(var1, var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1788579750"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "415071897"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljq;I)I",
		garbageValue = "432116697"
	)
	@Export("compareToTyped")
	public int compareToTyped(Username var1) {
		if (this.cleanName == null) {
			return var1.cleanName == null ? 0 : 1;
		} else {
			return var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName);
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof Username) {
			Username var2 = (Username)var1;
			if (this.cleanName == null) {
				return var2.cleanName == null;
			} else if (var2.cleanName == null) {
				return false;
			} else {
				return this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	public String toString() {
		return this.getName();
	}

	public int compareTo(Object var1) {
		return this.compareToTyped((Username)var1);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "([BII)I",
		garbageValue = "-42849866"
	)
	public static int method5147(byte[] var0, int var1) {
		return LoginScreenAnimation.method1848(var0, 0, var1);
	}
}
