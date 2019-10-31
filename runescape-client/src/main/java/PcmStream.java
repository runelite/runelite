import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ldj;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("r")
	int field1467;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("sound")
	AbstractSound sound;
	@ObfuscatedName("s")
	@Export("active")
	volatile boolean active;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("o")
	protected abstract int vmethod4063();

	@ObfuscatedName("i")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("m")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("as")
	int vmethod2868() {
		return 255;
	}

	@ObfuscatedName("fw")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
