import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("Node")
public class Node {
	@ObfuscatedName("ci")
	@Export("key")
	public long key;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("next")
	public Node next;

	@ObfuscatedName("fz")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("fj")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
