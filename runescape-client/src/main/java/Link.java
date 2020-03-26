import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("Link")
public class Link {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("x")
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
