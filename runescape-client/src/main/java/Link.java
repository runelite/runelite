import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("Link")
public class Link {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfq;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfq;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("q")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}
