import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hn")
@Implements("Node")
public class Node {
   @ObfuscatedName("ey")
   @Export("previous")
   Node previous;
   @ObfuscatedName("ep")
   @Export("hash")
   public long hash;
   @ObfuscatedName("em")
   @Export("next")
   public Node next;

   @ObfuscatedName("ip")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("im")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
