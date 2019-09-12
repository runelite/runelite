import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("i")
	int field1459;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ldi;"
	)
	@Export("sound")
	AbstractSound sound;
	@ObfuscatedName("y")
	@Export("active")
	volatile boolean active;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "()Ldg;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("v")
	protected abstract int vmethod3881();

	@ObfuscatedName("d")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("s")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ah")
	int vmethod2673() {
		return 255;
	}

	@ObfuscatedName("eh")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
