import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive15")
	static Archive archive15;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 440805047
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 649013739
	)
	@Export("x")
	public int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1217821847
	)
	@Export("y")
	public int y;

	@ObfuscatedSignature(
		signature = "(Lhf;)V"
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1545441296"
	)
	@Export("packed")
	public int packed() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhf;I)Z",
		garbageValue = "472807046"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1765692684"
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

	public String toString() {
		return this.toString(",");
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)Lih;",
		garbageValue = "-87"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumDefinition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1708484762"
	)
	static void method4144() {
		if (Login.field1188) {
			NPC.titleboxSprite = null;
			UserComparator9.titlebuttonSprite = null;
			class208.runesSprite = null;
			Login.leftTitleSprite = null;
			FontName.rightTitleSprite = null;
			Tiles.logoSprite = null;
			Decimator.title_muteSprite = null;
			UserComparator8.options_buttons_0Sprite = null;
			Login.options_buttons_2Sprite = null;
			GrandExchangeEvent.worldSelectBackSprites = null;
			JagexCache.worldSelectFlagSprites = null;
			StudioGame.worldSelectArrows = null;
			Interpreter.worldSelectStars = null;
			Message.field587 = null;
			Login.loginScreenRunesAnimation.method1955();
			class80.method2194(2);
			UrlRequester.method3428(true);
			Login.field1188 = false;
		}
	}
}
