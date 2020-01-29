import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("ce")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("ca")
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
