import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("Node")
public class Node {
	@ObfuscatedName("cr")
	@Export("key")
	public long key;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("next")
	public Node next;

	@ObfuscatedName("fu")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("fl")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
