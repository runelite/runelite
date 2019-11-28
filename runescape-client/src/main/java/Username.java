import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("u")
	@Export("name")
	String name;
	@ObfuscatedName("f")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Llg;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		this.cleanName = StudioGame.method4228(var1, var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "70"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-102"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljb;I)I",
		garbageValue = "1816661585"
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

	public int compareTo(Object var1) {
		return this.compareToTyped((Username)var1);
	}

	public String toString() {
		return this.getName();
	}
}
