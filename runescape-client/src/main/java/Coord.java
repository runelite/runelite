import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -618740747
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -224554023
	)
	@Export("x")
	public int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1025191447
	)
	@Export("y")
	public int y;

	@ObfuscatedSignature(
		signature = "(Lhv;)V"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1529444039"
	)
	@Export("packed")
	public int packed() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhv;I)Z",
		garbageValue = "2096599249"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1242820641"
	)
	@Export("toString")
	String toString(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public int hashCode() {
		return this.packed();
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
		}
	}

	public String toString() {
		return this.toString(",");
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1626401232"
	)
	@Export("ParamDefinition_clearCached")
	public static void ParamDefinition_clearCached() {
		ParamDefinition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-40"
	)
	static void method3990() {
		Login.loginIndex = 24;
		class268.setLoginResponseString("", "You were disconnected from the server.", "");
	}
}
