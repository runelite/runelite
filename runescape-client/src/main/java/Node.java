import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dq")
@Implements("Node")
public class Node {
   @ObfuscatedName("cb")
   @Export("next")
   public Node next;
   @ObfuscatedName("cz")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ch")
   @Export("previous")
   Node previous;

   @ObfuscatedName("gt")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("gx")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }
}
