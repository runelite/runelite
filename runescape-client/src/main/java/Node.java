import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
@Implements("Node")
public class Node {
   @ObfuscatedName("cl")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cg")
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ij")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ig")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
