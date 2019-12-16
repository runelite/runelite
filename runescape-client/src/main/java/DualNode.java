import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("cu")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "Lgw;"
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
