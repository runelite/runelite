import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("cz")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("cz")
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
