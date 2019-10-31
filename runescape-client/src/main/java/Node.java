import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("Node")
public class Node {
	@ObfuscatedName("cp")
	@Export("key")
	public long key;
	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "Lfd;"
	)
	@Export("next")
	public Node next;

	@ObfuscatedName("fv")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("fk")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
