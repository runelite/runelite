import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("w")
	@Export("active")
	volatile boolean active;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("a")
	int field1507;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldf;"
	)
	@Export("sound")
	AbstractSound sound;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("z")
	protected abstract int vmethod3984();

	@ObfuscatedName("t")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("s")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ac")
	int vmethod2820() {
		return 255;
	}

	@ObfuscatedName("fk")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
