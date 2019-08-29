import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("m")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("dc")
	@ObfuscatedGetter(
		longValue = 8705560174832439427L
	)
	static long field2511;
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = -312378443
	)
	@Export("cameraY")
	static int cameraY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -22513413
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -611305657
	)
	@Export("x")
	public int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2088749017
	)
	@Export("y")
	public int y;

	@ObfuscatedSignature(
		signature = "(Lhd;)V"
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "2"
	)
	@Export("packed")
	public int packed() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lhd;B)Z",
		garbageValue = "-61"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1334181457"
	)
	@Export("toString")
	String toString(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public String toString() {
		return this.toString(",");
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

	public String abd() {
		return this.toString(",");
	}

	public String abb() {
		return this.toString(",");
	}
}
