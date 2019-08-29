import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("g")
	int field1478;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("sound")
	AbstractSound sound;
	@ObfuscatedName("z")
	@Export("active")
	volatile boolean active;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Ldz;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("q")
	protected abstract int vmethod3834();

	@ObfuscatedName("x")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("f")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("ak")
	int vmethod2644() {
		return 255;
	}

	@ObfuscatedName("fo")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}
