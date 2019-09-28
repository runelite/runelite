import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("Link")
public class Link {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("z")
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
