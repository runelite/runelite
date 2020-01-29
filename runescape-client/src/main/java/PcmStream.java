import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("q")
	int field1478;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ldd;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("l")
	protected abstract int vmethod3965();

	@ObfuscatedName("j")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("p")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ag")
	int vmethod2777() {
		return 255;
	}

	@ObfuscatedName("fs")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
