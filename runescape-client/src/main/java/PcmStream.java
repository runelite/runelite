import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ldc;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("g")
	int field1462;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Ldc;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("m")
	protected abstract int vmethod3882();

	@ObfuscatedName("y")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("c")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ah")
	int vmethod2691() {
		return 255;
	}

	@ObfuscatedName("fh")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
