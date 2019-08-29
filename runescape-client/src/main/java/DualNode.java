import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("cr")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "Lfe;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "Lfe;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("cl")
	@Export("removeDual")
	public void removeDual() {
		if (this.nextDual != null) {
			this.nextDual.previousDual = this.previousDual;
			this.previousDual.nextDual = this.nextDual;
			this.previousDual = null;
			this.nextDual = null;
		}
	}
}
