import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("a")
	int field1496;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldx;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("i")
	protected abstract int vmethod3892();

	@ObfuscatedName("c")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("x")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ay")
	int vmethod2689() {
		return 255;
	}

	@ObfuscatedName("ec")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
