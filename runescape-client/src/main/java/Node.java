import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
@Implements("Node")
public class Node {
   @ObfuscatedName("ez")
   @Export("hash")
   public long hash;
   @ObfuscatedName("es")
   @Export("next")
   public Node next;
   @ObfuscatedName("eb")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ih")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("iv")
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
