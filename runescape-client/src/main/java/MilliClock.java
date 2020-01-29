import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lme;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("b")
	public static String field2015;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("c")
	long[] field2011;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1924438695
	)
	int field2009;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 990081357
	)
	int field2008;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = 1282621302724329393L
	)
	long field2013;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -552407369
	)
	int field2012;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1470332853
	)
	int field2014;

	MilliClock() {
		this.field2011 = new long[10];
		this.field2009 = 256;
		this.field2008 = 1;
		this.field2012 = 0;
		this.field2013 = WorldMapIcon_0.currentTimeMillis();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2011[var1] = this.field2013;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "29"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2011[var1] = 0L;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-561232674"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field2009;
		int var4 = this.field2008;
		this.field2009 = 300;
		this.field2008 = 1;
		this.field2013 = WorldMapIcon_0.currentTimeMillis();
		if (this.field2011[this.field2014] == 0L) {
			this.field2009 = var3;
			this.field2008 = var4;
		} else if (this.field2013 > this.field2011[this.field2014]) {
			this.field2009 = (int)((long)(var1 * 2560) / (this.field2013 - this.field2011[this.field2014]));
		}

		if (this.field2009 < 25) {
			this.field2009 = 25;
		}

		if (this.field2009 > 256) {
			this.field2009 = 256;
			this.field2008 = (int)((long)var1 - (this.field2013 - this.field2011[this.field2014]) / 10L);
		}

		if (this.field2008 > var1) {
			this.field2008 = var1;
		}

		this.field2011[this.field2014] = this.field2013;
		this.field2014 = (this.field2014 + 1) % 10;
		int var5;
		if (this.field2008 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field2011[var5]) {
					this.field2011[var5] += (long)this.field2008;
				}
			}
		}

		if (this.field2008 < var2) {
			this.field2008 = var2;
		}

		FriendLoginUpdate.method5325((long)this.field2008);

		for (var5 = 0; this.field2012 < 256; this.field2012 += this.field2009) {
			++var5;
		}

		this.field2012 &= 255;
		return var5;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(III)Lce;",
		garbageValue = "-230494464"
	)
	static Script method3529(int var0, int var1) {
		Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = Clock.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long)(var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1997111110"
	)
	public static void method3535() {
		Widget.Widget_cachedSprites.clear();
		Widget.Widget_cachedModels.clear();
		Widget.Widget_cachedFonts.clear();
		Widget.Widget_cachedSpriteMasks.clear();
	}
}
