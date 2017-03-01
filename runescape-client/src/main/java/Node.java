import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dn")
@Implements("Node")
public class Node {
   @ObfuscatedName("cl")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cb")
   @Export("next")
   public Node next;
   @ObfuscatedName("cz")
   @Export("previous")
   Node previous;

   @ObfuscatedName("fm")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("fj")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
