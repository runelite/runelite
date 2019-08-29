import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("Link")
public class Link {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lfk;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lfk;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("s")
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
