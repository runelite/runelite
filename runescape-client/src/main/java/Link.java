import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("Link")
public class Link {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("c")
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
