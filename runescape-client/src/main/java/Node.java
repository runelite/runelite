import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
@Implements("Node")
public class Node {
   @ObfuscatedName("ct")
   @Export("next")
   public Node next;
   @ObfuscatedName("cf")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cb")
   @Export("hash")
   public long hash;

   @ObfuscatedName("fk")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("fh")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
