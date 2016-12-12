import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
@Implements("Node")
public class Node {
   @ObfuscatedName("cq")
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @Export("previous")
   Node previous;
   @ObfuscatedName("ct")
   @Export("hash")
   public long hash;

   @ObfuscatedName("ey")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("et")
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
