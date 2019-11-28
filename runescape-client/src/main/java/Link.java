import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("Link")
public class Link {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("u")
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
