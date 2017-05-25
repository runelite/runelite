import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
@Implements("Node")
public class Node {
   @ObfuscatedName("co")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cx")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cw")
   @Export("next")
   public Node next;

   @ObfuscatedName("iv")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }

   @ObfuscatedName("ii")
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
