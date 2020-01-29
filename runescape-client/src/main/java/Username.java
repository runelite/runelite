import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -624446357
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("ap")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("c")
	@Export("name")
	String name;
	@ObfuscatedName("t")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lmv;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		String var4;
		if (var1 == null) {
			var4 = null;
		} else {
			int var5 = 0;

			int var6;
			boolean var7;
			char var8;
			for (var6 = var1.length(); var5 < var6; ++var5) {
				var8 = var1.charAt(var5);
				var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
				if (!var7) {
					break;
				}
			}

			while (var6 > var5) {
				var8 = var1.charAt(var6 - 1);
				var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
				if (!var7) {
					break;
				}

				--var6;
			}

			int var13 = var6 - var5;
			if (var13 >= 1 && var13 <= TaskHandler.method3540(var2)) {
				StringBuilder var12 = new StringBuilder(var13);

				for (int var9 = var5; var9 < var6; ++var9) {
					char var10 = var1.charAt(var9);
					if (Projectile.method2160(var10)) {
						char var11 = Decimator.method2597(var10);
						if (var11 != 0) {
							var12.append(var11);
						}
					}
				}

				if (var12.length() == 0) {
					var4 = null;
				} else {
					var4 = var12.toString();
				}
			} else {
				var4 = null;
			}
		}

		this.cleanName = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Ljava/lang/String;",
		garbageValue = "-49"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "750587090"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljz;B)I",
		garbageValue = "-33"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-22"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}
