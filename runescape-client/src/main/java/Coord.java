import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("aw")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -275324431
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1946522259
	)
	@Export("y")
	public int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 212884917
	)
	@Export("x")
	public int x;

	@ObfuscatedSignature(
		signature = "(Lhj;)V"
	)
	public Coord(Coord var1) {
		this.plane = var1.plane;
		this.x = var1.x;
		this.y = var1.y;
	}

	public Coord(int var1, int var2, int var3) {
		this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	public Coord(int var1) {
		if (var1 == -1) {
			this.plane = -1;
		} else {
			this.plane = var1 >> 28 & 3;
			this.x = var1 >> 14 & 16383;
			this.y = var1 & 16383;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "94"
	)
	@Export("packed")
	public int packed() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhj;I)Z",
		garbageValue = "49953005"
	)
	@Export("equalsCoord")
	boolean equalsCoord(Coord var1) {
		if (this.plane != var1.plane) {
			return false;
		} else if (this.x != var1.x) {
			return false;
		} else {
			return this.y == var1.y;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-2113109490"
	)
	@Export("toString")
	String toString(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
		}
	}

	public int hashCode() {
		return this.packed();
	}

	public String aai() {
		return this.toString(",");
	}

	public String aar() {
		return this.toString(",");
	}

	public String aan() {
		return this.toString(",");
	}

	public String toString() {
		return this.toString(",");
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lcl;",
		garbageValue = "69"
	)
	static AttackOption[] method3981() {
		return new AttackOption[]{AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels};
	}
}
