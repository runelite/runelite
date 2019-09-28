import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("NanoClock")
public class NanoClock extends Clock {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = -5918640064271728259L
	)
	@Export("lastTimeNano")
	long lastTimeNano;

	NanoClock() {
		this.lastTimeNano = System.nanoTime();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	@Export("mark")
	public void mark() {
		this.lastTimeNano = System.nanoTime();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "569029249"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		long var3 = (long)var2 * 1000000L;
		long var5 = this.lastTimeNano - System.nanoTime();
		if (var5 < var3) {
			var5 = var3;
		}

		long var7 = var5 / 1000000L;
		long var9;
		if (var7 > 0L) {
			if (var7 % 10L == 0L) {
				var9 = var7 - 1L;

				try {
					Thread.sleep(var9);
				} catch (InterruptedException var16) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var15) {
				}
			} else {
				try {
					Thread.sleep(var7);
				} catch (InterruptedException var14) {
				}
			}
		}

		var9 = System.nanoTime();

		int var13;
		for (var13 = 0; var13 < 10 && (var13 < 1 || this.lastTimeNano < var9); this.lastTimeNano += 1000000L * (long)var1) {
			++var13;
		}

		if (this.lastTimeNano < var9) {
			this.lastTimeNano = var9;
		}

		return var13;
	}
}
