import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ldt;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("a")
	int field1483;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldl;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("y")
	protected abstract int vmethod3963();

	@ObfuscatedName("w")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("k")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("at")
	int vmethod2741() {
		return 255;
	}

	@ObfuscatedName("fz")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
