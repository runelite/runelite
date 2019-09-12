import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("cu")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("cx")
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
