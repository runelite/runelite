import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("Node")
public class Node {
	@ObfuscatedName("cl")
	@Export("key")
	public long key;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "Lfx;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "Lfx;"
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

	@ObfuscatedName("fa")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
