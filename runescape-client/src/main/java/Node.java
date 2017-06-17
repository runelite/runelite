import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("Node")
public class Node {
   @ObfuscatedName("ck")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cb")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cl")
   @Export("next")
   public Node next;

   @ObfuscatedName("ie")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }

   }

   @ObfuscatedName("ik")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
