import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
@Implements("Node")
public class Node {
   @ObfuscatedName("eo")
   @Export("next")
   public Node next;
   @ObfuscatedName("ex")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ey")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ii")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("is")
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
