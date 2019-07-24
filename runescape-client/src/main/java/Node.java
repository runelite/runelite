import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("Node")
public class Node {
	@ObfuscatedName("cg")
	@Export("key")
	public long key;
	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		signature = "Lfw;"
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

	@ObfuscatedName("fn")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
