import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("Node")
public class Node {
	@ObfuscatedName("cx")
	@Export("key")
	public long key;
	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "Lfn;"
	)
	@Export("next")
	public Node next;

	@ObfuscatedName("ft")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("ff")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
