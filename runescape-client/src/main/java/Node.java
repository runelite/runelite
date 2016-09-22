import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hr")
@Implements("Node")
public class Node {
   @ObfuscatedName("ez")
   @Export("next")
   public Node next;
   @ObfuscatedName("ev")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ec")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ic")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("is")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
