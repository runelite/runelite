import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ldl;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("j")
	int field1454;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "()Ldl;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("x")
	protected abstract int vmethod3889();

	@ObfuscatedName("a")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("c")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("at")
	int vmethod2716() {
		return 255;
	}

	@ObfuscatedName("fn")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
