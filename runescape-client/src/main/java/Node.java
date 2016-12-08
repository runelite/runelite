import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("Node")
public class Node {
   @ObfuscatedName("ck")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cn")
   @Export("next")
   public Node next;
   @ObfuscatedName("cr")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ek")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("es")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
