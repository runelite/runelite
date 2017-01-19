import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
@Implements("Node")
public class Node {
   @ObfuscatedName("cq")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cf")
   @Export("next")
   public Node next;
   @ObfuscatedName("cm")
   @Export("hash")
   public long hash;

   @ObfuscatedName("fc")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("fi")
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
