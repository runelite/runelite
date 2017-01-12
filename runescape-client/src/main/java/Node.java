import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("Node")
public class Node {
   @ObfuscatedName("cm")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cq")
   @Export("next")
   public Node next;
   @ObfuscatedName("cu")
   @Export("previous")
   Node previous;

   @ObfuscatedName("fn")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("fg")
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
