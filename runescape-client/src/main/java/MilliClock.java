import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("u")
	long[] field2017;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 90836153
	)
	int field2018;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 878139607
	)
	int field2019;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -4513558875816337439L
	)
	long field2022;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1976068769
	)
	int field2021;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1447162639
	)
	int field2020;

	public MilliClock() {
		this.field2017 = new long[10];
		this.field2018 = 256;
		this.field2019 = 1;
		this.field2021 = 0;
		this.field2022 = TaskHandler.currentTimeMillis();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2017[var1] = this.field2022;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-26166053"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2017[var1] = 0L;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "6"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field2018;
		int var4 = this.field2019;
		this.field2018 = 300;
		this.field2019 = 1;
		this.field2022 = TaskHandler.currentTimeMillis();
		if (0L == this.field2017[this.field2020]) {
			this.field2018 = var3;
			this.field2019 = var4;
		} else if (this.field2022 > this.field2017[this.field2020]) {
			this.field2018 = (int)((long)(var1 * 2560) / (this.field2022 - this.field2017[this.field2020]));
		}

		if (this.field2018 < 25) {
			this.field2018 = 25;
		}

		if (this.field2018 > 256) {
			this.field2018 = 256;
			this.field2019 = (int)((long)var1 - (this.field2022 - this.field2017[this.field2020]) / 10L);
		}

		if (this.field2019 > var1) {
			this.field2019 = var1;
		}

		this.field2017[this.field2020] = this.field2022;
		this.field2020 = (this.field2020 + 1) % 10;
		if (this.field2019 > 1) {
			for (int var5 = 0; var5 < 10; ++var5) {
				if (this.field2017[var5] != 0L) {
					this.field2017[var5] += (long)this.field2019;
				}
			}
		}

		if (this.field2019 < var2) {
			this.field2019 = var2;
		}

		long var10 = (long)this.field2019;
		if (var10 > 0L) {
			if (0L == var10 % 10L) {
				long var7 = var10 - 1L;

				try {
					Thread.sleep(var7);
				} catch (InterruptedException var16) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var15) {
				}
			} else {
				try {
					Thread.sleep(var10);
				} catch (InterruptedException var14) {
				}
			}
		}

		int var13;
		for (var13 = 0; this.field2021 < 256; this.field2021 += this.field2018) {
			++var13;
		}

		this.field2021 &= 255;
		return var13;
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "([Lhl;Lhl;ZB)V",
		garbageValue = "115"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		class225.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			class225.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			WorldMapSectionType.method272(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}
}
